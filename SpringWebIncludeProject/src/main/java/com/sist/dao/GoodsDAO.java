package com.sist.dao;

import java.util.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.sist.mapper.GoodsMapper;
import com.sist.vo.FoodVO;
import com.sist.vo.GoodsVO;

@Repository
public class GoodsDAO {
	
	@Autowired
	private GoodsMapper mapper;
	
	public List<GoodsVO> goodsListData(int start, int end)
	{
		return mapper.goodsListData(start, end);
	}
	
	public int goodsTotalPage()
	{
		return mapper.goodsTotalPage();
	}
	
	public GoodsVO goodsDetailData(int no)
	{
		return mapper.goodsDetailData(no);
	}
	
	public GoodsVO goodsCookieData(int no)
	{
		return mapper.goodsDetailData(no);
	}
	
	public List<GoodsVO> goodsFindData(Map map)
	{
		return mapper.goodsFindData(map);
	}
	
	public int goodsFindTotalpage(Map map)
	{
		return mapper.goodsFindTotalpage(map);
	}
}
