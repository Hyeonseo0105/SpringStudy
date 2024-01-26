package com.sist.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor    // 매개변수없음
@AllArgsConstructor   // 매개변수있음 디폴트생성자가 없어짐
public class FoodVO {
	private int fno;
	private String name,address,type;
}
