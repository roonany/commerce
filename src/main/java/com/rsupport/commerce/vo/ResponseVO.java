package com.rsupport.commerce.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
public class ResponseVO implements Serializable {

  @JsonProperty
  private String resultCode;
 
  @JsonProperty
  private String message;
 
  public ResponseVO(String resultCode) {
    this.resultCode = resultCode;
  }
 
  public ResponseVO(String resultCode, String message) {
    this.resultCode = resultCode;
    this.message = message;
  }
 
  public static ResponseVO ok() {
    return new ResponseVO(ResultCodes.OK);
  }
 }
