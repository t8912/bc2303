package com.codewave.demo.userdatabase.infra.util;

import java.util.List;

import org.springframework.web.util.UriComponentsBuilder;

public class ApiUtil {

  private static void addPathSegments(UriComponentsBuilder builder, String pathSegment) {
    builder.pathSegment(pathSegment);
  }

  public static String getUrl(UriScheme scheme, String domain, int port, List<String> pathSegments, String endpoint) {
    UriComponentsBuilder uriBuilder = UriComponentsBuilder.newInstance()
        .scheme(scheme.getProtocol())
        .host(domain)
        .port(port);

    for (String pathSegment : pathSegments) {
      addPathSegments(uriBuilder, pathSegment); // pass by reference, the address of uriBuilder has no change
    }

    return uriBuilder // same address after the above looping
        .path(endpoint)
        .build(true)
        .toUri()
        .toString();
  }

}
