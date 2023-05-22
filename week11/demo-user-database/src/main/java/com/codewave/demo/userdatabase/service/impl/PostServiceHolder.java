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

import com.codewave.demo.userdatabase.entity.Post;
import com.codewave.demo.userdatabase.entity.User;
import com.codewave.demo.userdatabase.infra.response.ApiResponse;
import com.codewave.demo.userdatabase.infra.util.ApiUtil;
import com.codewave.demo.userdatabase.infra.util.UriScheme;
import com.codewave.demo.userdatabase.model.dto.placeholder.PostDto;
import com.codewave.demo.userdatabase.repository.PostRepository;
import com.codewave.demo.userdatabase.repository.UserRepository;
import com.codewave.demo.userdatabase.service.PostService;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PostServiceHolder implements PostService {

  @Value(value = "${api.project-user.domain}")
  String domain;

  @Value(value = "${api.project-user.port}")
  int port;

  @Value(value = "${api.project-user.base-path}")
  String basePath;

  @Value(value = "${api.project-user.version}")
  String version;

  @Value(value = "${api.project-user.endpoints.post}")
  String postEndpoint;

  @Autowired
  RestTemplate restTemplate;

  @Autowired
  PostRepository postRepository;

  @Autowired
  UserRepository userRepository;

  @Override
  public List<PostDto> getAllFromPlaceHolder() {
    List<String> segments = new ArrayList<>();
    segments.add(basePath);
    segments.add(version);
    // String endpoint = "/user/{id}/" + postEndpoint;
    // endpoint = endpoint.replace("{id}", String.valueOf(userId));
    String url = ApiUtil.getUrl(UriScheme.HTTP, domain, port, segments, postEndpoint);
    // String url = "http://localhost:8091/placeholder/v1/users";
    log.info("getAll url={}", url);

    ResponseEntity<ApiResponse<List<PostDto>>> obj = restTemplate.exchange(url,
        HttpMethod.GET, HttpEntity.EMPTY,
        new ParameterizedTypeReference<ApiResponse<List<PostDto>>>() {
        });
    ApiResponse<List<PostDto>> body = obj.getBody();
    return body != null ? body.getData() : new ArrayList<>();
  }

  @Override
  public List<Post> getAllByUserId(Long userId) {
    if (userId != null)
      return postRepository.findAllByUserId(userId);
    return null;
  }

  @Override
  public List<Post> getAll() {
    return postRepository.findAll();
  }

  @Override
  public Optional<Post> get(Long id) {
    if (id != null)
      return postRepository.findById(id);
    return null;
  }

  @Override
  public Post addByUserId(Post post, Long userId) {
    // System.out.println("id=" + userId);
    if (post != null && userId != null) {

      Optional<User> user = userRepository.findById(userId);

      if (!user.isPresent())
        return null;

      post.setUser(user.get());
      System.out.println("post=" + post);
      return postRepository.save(post);
    }
    return null;
  }

  @Override
  @Transactional
  public int remove(Long id) { // TBC, handle runtime exception
    return postRepository.deleteByIdReturnCount(id);
  }

  @Override
  public Post update(Post newPost, Long id) { // handle runtime exception
    if (id == null || newPost == null)
      return null;

    return postRepository.findById(id)
        .map(post -> {
          post.setTitle(newPost.getTitle());
          post.setBody(newPost.getBody());
          return postRepository.save(post);
        }).orElseGet(() -> {
          return null;
        });
  }

  @Override
  public List<Post> addOrUpdateAll(List<Post> posts) {
    if (posts != null && posts.size() != 0)
      return postRepository.saveAll(posts);
    return new ArrayList<>();
  }

}
