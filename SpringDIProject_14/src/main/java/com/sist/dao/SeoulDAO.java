package com.sist.dao;

import java.util.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.sist.mapper.*;

@Repository("sDao")
public class SeoulDAO {
	// 구현된 메퍼 (스프링 내부에 구현)
	@Autowired
	private SeoulMapper mapper;
	
	public List<SeoulVO> seoulListData(Map map)
	{
		return mapper.seoulListData(map);
	}
	
	public SeoulVO seoulDetailData(Map map)
	{
		return mapper.seoulDetailData(map);
	}
}
