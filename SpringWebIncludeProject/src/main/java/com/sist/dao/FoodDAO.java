package com.sist.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.*;
import com.sist.vo.*;
import com.sist.mapper.*;
import com.sist.dao.*;

@Repository
public class FoodDAO {
	
	@Autowired
	private FoodMapper mapper;
	
	public List<FoodVO> foodListData(int start, int end)
	{
		return mapper.foodListData(start, end);
	}

	public int foodtotalpage()
	{
		return mapper.foodtotalpage();
	}
	
	public FoodVO foodDetailData(int fno)
	{
		mapper.hitIncrement(fno);
		return mapper.foodDetailData(fno);
	}
	
	public FoodVO foodCookieData(int fno)
	{
		return mapper.foodDetailData(fno);
	}
	
	// 검색
	public List<FoodVO> foodFindData(Map map)
	{
		return mapper.foodFindData(map);
	}
	
	public int foodFindTotalpage(Map map)
	{
		return mapper.foodFindTotalpage(map);
	}
}
