package com.codewave.demo.userdatabase.config;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.codewave.demo.userdatabase.entity.Comment;
import com.codewave.demo.userdatabase.entity.Post;
import com.codewave.demo.userdatabase.entity.User;
import com.codewave.demo.userdatabase.model.dto.placeholder.CommentDto;
import com.codewave.demo.userdatabase.model.dto.placeholder.PostDto;
import com.codewave.demo.userdatabase.model.dto.placeholder.UserDto;
import com.codewave.demo.userdatabase.service.CommentService;
import com.codewave.demo.userdatabase.service.PostService;
import com.codewave.demo.userdatabase.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;

@Configuration
@EnableScheduling // inject some bean(s) into spring context
public class ScheduledTaskConfig {

  @Autowired
  UserService userService;

  @Autowired
  PostService postService;

  @Autowired
  CommentService commentService;

  // @Scheduled(fixedRate = 2000) // ms
  public void scheduleFixedRateTask() throws Exception {
    System.out.println("Fixed rate task - " + System.currentTimeMillis() / 1000);
    // this.wait(4000);
  }

  // @Scheduled(fixedDelay = 5000) // ms
  public void scheduleFixedDelayTask() throws Exception {
    System.out.println("Fixed delay task - " + System.currentTimeMillis() / 1000);
    // this.wait(4000);
  }

  @Scheduled(cron = "0/30 * 9-23 * * MON-FRI") // Second Minute Hour DD MM Weekday Year
  public void scheduleTaskgetAllUsers() throws JsonProcessingException {
    long now = System.currentTimeMillis() / 1000;
    System.out.println("Call JsonPlaceHolder /users - " + now);
    // Business Logic
    // Step 0: Call placeholder
    List<UserDto> userDtos = userService.getAllFromPlaceHolder();
    List<PostDto> postDtos = postService.getAllFromPlaceHolder();
    List<CommentDto> commentDtos = commentService.getAllFromPlaceHolder();
    // Step 0.5: Remove all tables
    System.out.println("start removeAll");
    userService.removeAll();
    System.out.println("after removeAll");
    // Step 1: Convert dto to entity
    List<User> users = userDtos.stream()
        .map(e -> {
          return User.builder()
              .id(e.getId())
              .fullName(e.getName())
              .email(e.getEmail())
              .userName(e.getUsername())
              .website(e.getWebsite())
              .phone(e.getPhone())
              .build();
        }).collect(Collectors.toList());
    // Step 2: Save entity to DB
    userService.addOrUpdateAll(users);
    System.out.println("after userService.addOrUpdateAll");
    // Step 3: Convert Post
    List<Post> posts = postDtos.stream()
        .map(e -> {
          User user = userService.get(e.getUserId()).orElse(null);
          return Post.builder()
              .id(e.getId())
              .title(e.getTitle())
              .body(e.getBody())
              .user(user) // set user
              .build();
        }).collect(Collectors.toList());
    postService.addOrUpdateAll(posts);
    System.out.println("after postService.addOrUpdateAll");

    List<Comment> comments = commentDtos.stream()
        .map(e -> {
          // System.out.println("comment id=" + e.getId());
          Post post = postService.get(e.getPostId()).orElse(null);
          if (post == null) {
            System.out.println("comment id=" + e.getId() + " "+ e.getPostId());
          }
          return Comment.builder()
              .id(e.getId())
              .name(e.getName())
              .body(e.getBody().substring(0, 5))
              .post(post)
              .build();
        }).collect(Collectors.toList());
    commentService.addOrUpdateAll(comments);

    now = System.currentTimeMillis() / 1000;
    System.out.println("Call JsonPlaceHolder /users - " + now);
  }
}
