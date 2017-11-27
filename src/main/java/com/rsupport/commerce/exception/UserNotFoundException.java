package com.rsupport.commerce.exception;

import com.rsupport.commerce.vo.ResultCodes;

public class UserNotFoundException extends BaseException {

  private static final long serialVersionUID = -4509503570683886400L;

  public UserNotFoundException() {
    this(null);
  }

  public UserNotFoundException(String message) {
    super(ResultCodes.USER_NOT_FOUND, message);
  }
 
}