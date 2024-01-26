package com.sist.mapper;

import java.util.*;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import com.sist.vo.*;

public interface GoodsMapper {
	
	@Select("SELECT no,goods_name,goods_discount,goods_first_price,goods_poster,num "
			+"FROM (SELECT no,goods_name,goods_discount,goods_first_price,goods_poster,rownum as num "
			+"FROM (SELECT no,goods_name,goods_discount,goods_first_price,goods_poster "
			+"FROM goods_all ORDER BY no ASC)) "
			+"WHERE num BETWEEN #{start} AND #{end}")
	public List<GoodsVO> goodsListData(@Param("start") int start,@Param("end") int end);
	
	@Select("SELECT CEIL(COUNT(*)/12.0) FROM goods_all")
	public int goodsTotalPage();
	
	@Select("SELECT no,goods_name,goods_sub,goods_price,goods_discount,"
			+"goods_first_price,goods_delivery,goods_poster "
			+"FROM goods_all "
			+"WHERE no=#{no}")
	public GoodsVO goodsDetailData(int no);
	
	@Select("SELECT no,goods_name,goods_sub,goods_poster,num "
			+"FROM (SELECT no,goods_name,goods_sub,goods_poster,rownum as num "
			+"FROM (SELECT no,goods_name,goods_sub,goods_poster "
			+"FROM goods_all "
			+"WHERE ${col_name} LIKE '%'||#{ss}||'%'"
			+"ORDER BY no ASC)) "
			+"WHERE num BETWEEN #{start} AND #{end}")
	public List<GoodsVO> goodsFindData(Map map);
	
	@Select("SELECT CEIL(COUNT(*)/12.0) FROM goods_all "
			+"WHERE ${col_name} LIKE '%'||#{ss}||'%'")
	public int goodsFindTotalpage(Map map);
}
