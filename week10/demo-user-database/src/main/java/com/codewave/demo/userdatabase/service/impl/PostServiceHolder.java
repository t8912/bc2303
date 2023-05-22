package com.codewave.demo.userdatabase.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
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
import com.codewave.demo.userdatabase.model.dto.PostDto;
import com.codewave.demo.userdatabase.model.request.PostReqDto;
import com.codewave.demo.userdatabase.model.response.PostRespDto;
import com.codewave.demo.userdatabase.repository.PostRepository;
import com.codewave.demo.userdatabase.service.PostService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PostServiceHolder implements PostService {

    @Autowired
    RestTemplate restTemplate;

    @Value("${api.project-post.domain}")
    String domain;

    @Value("${api.project-post.port}")
    int port;

    @Value("${api.project-post.base-path}")
    String basePath;

    @Value("${api.project-post.version}")
    String version;

    @Value("${api.project-post.endpoints.post}")
    String postEndpoint;

    @Autowired
    PostRepository postRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<PostDto> getAll() {
        List<String> segments = new ArrayList<>();
        segments.add(basePath);
        segments.add(version);
        String url = ApiUtil.getUrl(UriScheme.HTTP, domain, port, segments, postEndpoint);
        log.info("getAll url={}", url);

        ResponseEntity<ApiResponse<List<PostDto>>> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                HttpEntity.EMPTY,
                new ParameterizedTypeReference<ApiResponse<List<PostDto>>>() {}
        );
        ApiResponse<List<PostDto>> apiResponse = response.getBody();
        List<PostDto> postDtos = apiResponse.getData(); // still error, please instead of getData, it is from CommentRespDto
        return postDtos;
    }


    // @Override
    // public List<PostDto> getAll() {
    //     List<String> segments = new ArrayList<>();
    //     segments.add(basePath);
    //     segments.add(version);
    //     String url = ApiUtil.getUrl(UriScheme.HTTP, domain, port, segments, postEndpoint);
    //     log.info("getAll url={}", url);
        
    //     ResponseEntity<ApiResponse<List<PlaceHolderPostDto>>> response = restTemplate.exchange( // PlaceHolderPostDto cannot be resolved to a type
    //             url,
    //             HttpMethod.GET,
    //             HttpEntity.EMPTY,
    //             new ParameterizedTypeReference<ApiResponse<List<PlaceHolderPostDto>>>() {} // PlaceHolderPostDto cannot be resolved to a type
    //     ); // 
    //     ApiResponse<List<PlaceHolderPostDto>> apiResponse = response.getBody();  // PlaceHolderPostDto cannot be resolved to a type
    //     List<PlaceHolderPostDto> placeHolderPostDtos = apiResponse.getData();  // PlaceHolderPostDto cannot be resolved to a type
    //     return placeHolderPostDtos.stream()
    //             .map(dto -> modelMapper.map(dto, PostDto.class))
    //             .collect(Collectors.toList());
    // }

    @Override
    public PostDto getById(Long id) {
        Post post = getPostById(id);
        return modelMapper.map(post, PostDto.class);
    }

    @Override
    public PostDto create(PostReqDto postReqDto) {
        Post post = modelMapper.map(postReqDto, Post.class);
        Post savedPost = postRepository.save(post);
        return modelMapper.map(savedPost, PostDto.class);
    }

    @Override
    public PostDto update(Long id, PostReqDto postReqDto) {
        Post existingPost = getPostById(id);
        if (existingPost == null) {
            throw new IllegalArgumentException("Post not found with id: " + id);
        }
        existingPost.setTitle(postReqDto.getTitle());
        existingPost.setBody(postReqDto.getBody());
        Post updatedPost = postRepository.save(existingPost);
        return modelMapper.map(updatedPost, PostDto.class);
    }

    @Override
    public void delete(Long id) {
        postRepository.deleteById(id);
    }

    private Post getPostById(Long id) {
        return postRepository.findById(id)
                .orElse(null);
    }
}



/* 
@Service
@Slf4j
public class PostServiceHolder implements PostService {

  @Autowired
  RestTemplate restTemplate;

  @Value(value = "${api.project-post.domain}")
  String domain;

  @Value(value = "${api.project-post.port}")
  int port;

  @Value(value = "${api.project-post.base-path}")
  String basePath;

  @Value(value = "${api.project-post.version}")
  String version;

  @Autowired
  ModelMapper modelMapper;

  @Override
  public List<PostDto> findAllById(Long id) {
    List<String> segments = new ArrayList<>();
    segments.add(basePath);
    segments.add(version);
    String endpoint = "/users/{id}/posts";
    endpoint = endpoint.replace("{id}", String.valueOf(id));
    String url = ApiUtil.getUrl(UriScheme.HTTP, domain, port, segments, endpoint);
    log.info("findAllById url={}", url);

    ResponseEntity<ApiResponse<List<PostDto>>> response = restTemplate.exchange(
        url,
        HttpMethod.GET,
        HttpEntity.EMPTY,
        new ParameterizedTypeReference<ApiResponse<List<PostDto>>>() {}
    );

    ApiResponse<List<PostDto>> apiResponse = response.getBody();
    if (apiResponse != null) {
      return apiResponse.getData();
    }
    return Collections.emptyList();
  }

  @Override
  public PostDto saveByUserId(Long id, PostReqDto post) {
    String url = getPostUrl();
    log.info("saveByUserId url={}", url);

    PostRequestDto request = modelMapper.map(post, PostRequestDto.class);
    request.setUserId(id);

    ResponseEntity<ApiResponse<PostDto>> response = restTemplate.exchange(
        url,
        HttpMethod.POST,
        new HttpEntity<>(request),
        new ParameterizedTypeReference<ApiResponse<PostDto>>() {}
    );

    ApiResponse<PostDto> apiResponse = response.getBody();
    if (apiResponse != null) {
      return apiResponse.getData();
    }
    return null;
  }

  @Override
  public PostDto save(PostReqDto post) {
    String url = getPostUrl();
    log.info("save url={}", url);

    PostRequestDto request = modelMapper.map(post, PostRequestDto.class);

    ResponseEntity<ApiResponse<PostDto>> response = restTemplate.exchange(
        url,
        HttpMethod.POST,
        new HttpEntity<>(request),
        new ParameterizedTypeReference<ApiResponse<PostDto>>() {}
    );

    ApiResponse<PostDto> apiResponse = response.getBody();
    if (apiResponse != null) {
      return apiResponse.getData();
    }
    return null;
  }

  @Override
  public PostDto update(Long id, PostReqDto post) {
    String url = getPostUrl(id);
    log.info("update url={}", url);

    PostRequestDto request = modelMapper.map(post, PostRequestDto.class);

    ResponseEntity<ApiResponse<PostDto>> response = restTemplate.exchange(
        url,
        HttpMethod.PUT,
        new HttpEntity<>(request),
        new ParameterizedTypeReference<ApiResponse<PostDto>>() {}
    );

    ApiResponse<PostDto> apiResponse = response.getBody();
    if (apiResponse != null) {
      return apiResponse.getData();
    }
    return null;
  }

  @Override
  public void delete(Long id) {
    String url = getPostUrl(id);
    log.info("delete url={}", url);

    restTemplate.delete(url);
  }

  private String getPostUrl() {
    List<String> segments = new ArrayList<>();
    segments.add(basePath);
    segments.add(version);
    segments.add("posts");
    return ApiUtil.getUrl(UriScheme.HTTP, domain, port, segments);
  }

  private String getPostUrl(Long id) {
    List<String> segments = new ArrayList<>();
    segments.add(basePath);
    segments.add(version);
    segments.add("posts");
    segments.add(String.valueOf(id));
    return ApiUtil.getUrl(UriScheme.HTTP, domain, port, segments);
  }
}




/* 
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

  @Override
  public List<PostDto> findAllById(Long id) {
    List<String> segments = new ArrayList<>();
    segments.add(basePath);
    segments.add(version);
    String endpoint = "/user/{id}/posts";
    endpoint = endpoint.replace("{id}", String.valueOf(id));
    String url = ApiUtil.getUrl(UriScheme.HTTP, domain, port, segments, endpoint);
    log.info("findAllById url={}", url);

    ResponseEntity<ApiResponse<List<PostDto>>> response = restTemplate.exchange(
        url, HttpMethod.GET, HttpEntity.EMPTY, new ParameterizedTypeReference<ApiResponse<List<PostDto>>>() {});
    ApiResponse<List<PostDto>> apiResponse = response.getBody();
    if (apiResponse != null) {
      return apiResponse.getData();
    }
    return new ArrayList<>();
  }

  @Override
  public PostDto saveByUserId(Long id, PostReqDto post) {
    List<String> segments = new ArrayList<>();
    segments.add(basePath);
    segments.add(version);
    String endpoint = "/user/{id}/post";
    endpoint = endpoint.replace("{id}", String.valueOf(id));
    String url = ApiUtil.getUrl(UriScheme.HTTP, domain, port, segments, endpoint);
    log.info("saveByUserId url={}", url);

    ResponseEntity<ApiResponse<PostDto>> response = restTemplate.exchange(
        url, HttpMethod.POST, new HttpEntity<>(post), new ParameterizedTypeReference<ApiResponse<PostDto>>() {});
    ApiResponse<PostDto> apiResponse = response.getBody();
    if (apiResponse != null) {
      return apiResponse.getData();
    }
    return null;
  }

  @Override
  public PostDto save(PostReqDto post) {
    List<String> segments = new ArrayList<>();
    segments.add(basePath);
    segments.add(version);
    String endpoint = "/post";
    String url = ApiUtil.getUrl(UriScheme.HTTP, domain, port, segments, endpoint);
    log.info("save url={}", url);

    ResponseEntity<ApiResponse<PostDto>> response = restTemplate.exchange(
        url, HttpMethod.POST, new HttpEntity<>(post), new ParameterizedTypeReference<ApiResponse<PostDto>>() {});
    ApiResponse<PostDto> apiResponse = response.getBody();
    if (apiResponse != null) {
      return apiResponse.getData();
    }
    return null;
  }

  @Override
  public PostDto update(Long id, PostReqDto post) {
    List<String> segments = new ArrayList<>();
    segments.add(basePath);
    segments.add(version);
    String endpoint = "/post/{id}";
    endpoint = endpoint.replace("{id}", String.valueOf(id));
    String url = ApiUtil.getUrl(UriScheme.HTTP, domain, port, segments, endpoint);
    log.info("update url={}", url);

    ResponseEntity<ApiResponse<PostDto>> response = restTemplate.exchange(
        url, HttpMethod.PUT, new HttpEntity<>(post), new ParameterizedTypeReference<ApiResponse<PostDto>>() {});
    ApiResponse<PostDto> apiResponse = response.getBody();
    if (apiResponse != null) {
      return apiResponse.getData();
    }
    return null;
  }

  @Override
  public void delete(Long id) {
    List<String> segments = new ArrayList<>();

    segments.add(basePath);
    segments.add(version);
    String endpoint = "/post/{id}";
    endpoint = endpoint.replace("{id}", String.valueOf(id));
    String url = ApiUtil.getUrl(UriScheme.HTTP, domain, port, segments, endpoint);
    log.info("delete url={}", url);

    restTemplate.delete(url);
  }
}


  /* 
  @Autowired
    private PostRepository postRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<PostDto> getByUserId(Long userId) {
        List<Post> posts = postRepository.findByUserId(userId);
        return posts.stream().map(post -> modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
    }

    @Override
    public PostRespDto save(PostReqDto postReqDto) {
        Post post = modelMapper.map(postReqDto, Post.class);
        Post savedPost = postRepository.save(post);
        return modelMapper.map(savedPost, PostRespDto.class);
    }

    @Override
    public void update(Long id, PostReqDto postReqDto) {
        Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post not found with id: " + id));
        post.setUserId(postReqDto.getUserId());
        post.setTitle(postReqDto.getPostTitle());
        post.setBody(postReqDto.getPostBody());
        postRepository.save(post);
    }

    @Override
    public void delete(Long id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post not found with id: " + id));
        postRepository.delete(post);
    }

    @Override
    public PostDto getById(Long id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post not found with id: " + id));
        return modelMapper.map(post, PostDto.class);
    }
}

  /* 
  @Autowired
  RestTemplate restTemplate;

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

  @Override
  public List<Post> findAllById(Long id) {
    List<String> segments = new ArrayList<>();
    segments.add(basePath);
    segments.add(version);
    String endpoint = "/user/{id}/" + postEndpoint;
    endpoint = endpoint.replace("{id}", String.valueOf(id));
    String url = ApiUtil.getUrl(UriScheme.HTTP, domain, port, segments, endpoint);
    log.info("findAllById url={}", url);

    ResponseEntity<ApiResponse<List<Post>>> obj = restTemplate.exchange(url, HttpMethod.GET, HttpEntity.EMPTY,
        new ParameterizedTypeReference<ApiResponse<List<Post>>>() {
        });
    ApiResponse<List<Post>> body = obj.getBody();

    if (obj != null) { // null check
      return body.getData(); // OK
    }
    return new ArrayList<>();
  }

  @Override
  public Post save(Post post) {
    List<String> segments = new ArrayList<>();
    segments.add(basePath);
    segments.add(version);
    String endpoint = "/user/" + postEndpoint;
    String url = ApiUtil.getUrl(UriScheme.HTTP, domain, port, segments, endpoint);
    log.info("save url={}", url);
    HttpEntity<Post> requestObj = new HttpEntity<>(post);
    ResponseEntity<ApiResponse<Post>> obj = restTemplate.exchange(url, HttpMethod.POST, requestObj,
        new ParameterizedTypeReference<ApiResponse<Post>>() {
        });
    ApiResponse<Post> body = obj.getBody();

    if (obj != null) { // null check
      return body.getData(); // OK
    }
    return null;
  }

  @Override
  public void deleteById(Long id) {
    List<String> segments = new ArrayList<>();
    segments.add(basePath);
    segments.add(version);
    String endpoint = "/user/" + postEndpoint + "/" + id;
    String url = ApiUtil.getUrl(UriScheme.HTTP, domain, port, segments, endpoint);
    log.info("deleteById url={}", url);
    restTemplate.delete(url);
  }

}
*/



//

  /*

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

  @Override
  public List<PostDto> findAllById(Long id) {
    List<String> segments = new ArrayList<>();
    segments.add(basePath);
    segments.add(version);
    String endpoint = "/user/{id}/" + postEndpoint;
    endpoint = endpoint.replace("{id}", String.valueOf(id));
    // userEndpoint = userEndpoint.replace(userEndpoint, "/user/{id}/" +
    // userEndpoint);
    String url = ApiUtil.getUrl(UriScheme.HTTP, domain, port, segments, endpoint);
    // String url = "http://localhost:8091/placeholder/v1/users";
    log.info("getAll url={}", url);

    ApiResponse<List<PostDto>> obj = restTemplate.getForObject(url, ApiResponse.class);
    if (obj != null) { // null check
      return obj.getData(); // OK
    }
    return new ArrayList<>();
  }
}

*/
