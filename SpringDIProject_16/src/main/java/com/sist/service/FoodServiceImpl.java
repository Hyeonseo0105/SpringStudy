package com.sist.service;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sist.dao.*;

@Service("fService")
public class FoodServiceImpl implements FoodService{

	@Autowired
	private FoodDAO dao;
	
	@Override
	public List<FoodVO> foodListData(String type) {
		// TODO Auto-generated method stub
		return dao.foodListData(type);
	}

	@Override
	public FoodVO foodDetailData(int fno) {
		// TODO Auto-generated method stub
		return dao.foodDetailData(fno);
	}

}
