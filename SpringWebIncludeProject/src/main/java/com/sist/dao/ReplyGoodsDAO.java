package com.sist.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.ReplyGoodsMapper;
import com.sist.vo.ReplyGoodsVO;

@Repository
public class ReplyGoodsDAO {

	@Autowired
	private ReplyGoodsMapper mapper;
	public void replyGoodsInsert(ReplyGoodsVO vo)
	{
		mapper.replyGoodsInsert(vo);
	}
	
	
	public List<ReplyGoodsVO> replyGoodsListData(int no)
	{
		return mapper.replyGoodsListData(no);
	}
	
	
	public void replyGoodsUpdate(ReplyGoodsVO vo)
	{
		mapper.replyGoodsUpdate(vo);
	}
	
	public void replyGoodsDelete(int gno)
	{
		mapper.replyGoodsDelete(gno);
	}
}
