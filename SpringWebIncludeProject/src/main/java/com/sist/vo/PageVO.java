package com.sist.vo;

import lombok.Data;

@Data
public class PageVO {
  private int curpage;
  private int totalpage;
  private int startPage;
  private int endPage;
}