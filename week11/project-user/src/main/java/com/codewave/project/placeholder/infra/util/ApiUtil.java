package com.codewave.project.placeholder.infra.util;

import org.springframework.web.util.UriComponentsBuilder;

public class ApiUtil {

  public static String getUrl(UriScheme scheme, String domain, String endpoint) {
    return UriComponentsBuilder.newInstance()
        .scheme(scheme.getProtocol())
        .host(domain)
        .path(endpoint)
        .toUriString();
  }

}
