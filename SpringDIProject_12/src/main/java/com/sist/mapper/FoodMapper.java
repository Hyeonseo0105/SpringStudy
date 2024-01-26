package com.sist.mapper;
import java.util.*;
import com.sist.dao.*;
public interface FoodMapper {
	/*
	 * 
	 <mapper namespace="com.sist.mapper.FoodMapper">
  	   <select id="foodFindData" resultType="FoodVO" parameterType="hashMap">
  	                              리턴형                 매개변수
    	 SELECT fno,name,type,address,price,contnet
    	 FROM food_menu_house
    	 WHERE ${col_name} LIKE '%'||#{ss}||'%'
  	   </select>
  	   //동적쿼리
	 </mapper>
	 */
	public List<FoodVO> foodFindData(Map map);
}
