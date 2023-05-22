package com.codewave.demo.userdatabase.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.codewave.demo.userdatabase.entity.Comment;
import com.codewave.demo.userdatabase.entity.Post;
import com.codewave.demo.userdatabase.infra.response.ApiResponse;
import com.codewave.demo.userdatabase.infra.util.ApiUtil;
import com.codewave.demo.userdatabase.infra.util.UriScheme;
import com.codewave.demo.userdatabase.model.dto.placeholder.CommentDto;
import com.codewave.demo.userdatabase.repository.CommentRepository;
import com.codewave.demo.userdatabase.repository.PostRepository;
import com.codewave.demo.userdatabase.service.CommentService;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CommentServiceHolder implements CommentService {

  @Value(value = "${api.project-user.domain}")
  private String domain;

  @Value(value = "${api.project-user.port}")
  private int port;

  @Value(value = "${api.project-user.base-path}")
  private String basePath;

  @Value(value = "${api.project-user.version}")
  private String version;

  @Value(value = "${api.project-user.endpoints.comment}")
  private String commentEndpoint;

  @Autowired
  private RestTemplate restTemplate;

  @Autowired
  PostRepository postRepository;

  @Autowired
  CommentRepository commentRepository;

  @Override
  public List<CommentDto> getAllFromPlaceHolder() {
    List<String> segments = new ArrayList<>();
    segments.add(basePath);
    segments.add(version);
    // String endpoint = "/post/{id}/" + commentEndpoint;
    // endpoint = endpoint.replace("{id}", String.valueOf(userId));

    String url = ApiUtil.getUrl(UriScheme.HTTP, domain, port, segments, commentEndpoint);
    // String url = "http://localhost:8091/placeholder/v1/users";
    log.info("getAll url={}", url);

    ResponseEntity<ApiResponse<List<CommentDto>>> obj = restTemplate.exchange(url,
        HttpMethod.GET, HttpEntity.EMPTY,
        new ParameterizedTypeReference<ApiResponse<List<CommentDto>>>() {
        });
    ApiResponse<List<CommentDto>> body = obj.getBody();
    return body != null ? body.getData() : new ArrayList<>();
  }

  @Override
  public List<Comment> getAllByPostId(Long postId) {
    if (postId != null)
      return commentRepository.findAllByPostId(postId);
    return null;
  }

  @Override
  public List<Comment> getAll() {
    return commentRepository.findAll();
  }

  @Override
  public Optional<Comment> get(Long id) {
    if (id != null)
      return commentRepository.findById(id);
    return null;
  }

  @Override
  public Comment addByPostId(Comment comment, Long postId) {
    System.out.println("addByPostId");
    if (comment != null && postId != null) {
      Optional<Post> post = postRepository.findById(postId);
      if (!post.isPresent())
        return null;
      comment.setPost(post.get());
      System.out.println("newComment=" + comment);
      return commentRepository.save(comment);
    }
    return null;
  }

  @Override
  @Transactional
  public int remove(Long id) { // TBC, handle runtime exception
    return commentRepository.deleteByIdReturnCount(id);
  }

  @Override
  public Comment update(Comment newComment, Long id) { // handle runtime exception
    if (id == null || newComment == null)
      return null;

    return commentRepository.findById(id)
        .map(comment -> {
          comment.setName(newComment.getName());
          comment.setBody(newComment.getBody());
          return commentRepository.save(comment);
        }).orElseGet(() -> {
          return null;
        });
  }

  @Override
  public List<Comment> addOrUpdateAll(List<Comment> comments) {
    if (comments == null)
      return null;
    if (comments.size() == 0)
      return new ArrayList<>();
    return commentRepository.saveAll(comments);
  }

}
