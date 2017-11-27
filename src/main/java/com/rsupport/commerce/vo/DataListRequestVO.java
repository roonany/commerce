package com.rsupport.commerce.vo;

import lombok.Setter;
import org.springframework.data.domain.Pageable;
import org.springframework.data.querydsl.QPageRequest;

@Setter
public class DataListRequestVO extends RequestVO {

  private static final int DEFAULT_PAGE_ROW = 20;
 
  private int page;
 
  private int pageSize;
 
  public int getPage() {
    return page < 1 ? 1 : page;
  }
 
  public int getPageSize() {
    return pageSize <= 0 ? DEFAULT_PAGE_ROW : pageSize;
  }
 
  public Pageable getPageable() {
    return new QPageRequest(getPage() - 1, getPageSize());
  }
 
}
