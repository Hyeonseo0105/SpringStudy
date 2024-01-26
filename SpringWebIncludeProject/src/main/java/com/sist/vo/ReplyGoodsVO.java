package com.sist.vo;

import java.util.*;
import lombok.Data;

@Data
public class ReplyGoodsVO {
	private int gno,no;
	private String id,name,msg,dbday;
	private Date regdate;
}
