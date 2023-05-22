package com.codewave.demo.hktvmall.Infra.exception;

/*
 * checked Exception
 */

public class NotFoundException extends BusinessException {

  // public NotfoundException () {}

  public NotFoundException() {
    super(BizCode.RESOURCE_NOT_FOUND.getCode(), BizCode.RESOURCE_NOT_FOUND.getMessage());
  }

}
