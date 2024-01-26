package com.sist.web;

import java.util.*;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.sist.dao.*;

@Controller
public class FoodController {
	
	@Autowired
	private FoodDAO dao;
	
	@RequestMapping("food/list.do")
	public String food_list(String page,Model model)     // 매개변수로 받음   request,response안씀 (디스패처서블릿이 매개변수에 값을채워줌)
	                                                     // model은 전송객체
	                                                     // page int로 안받는 이유 : 첫페이지가 null값이라서
	{
		if(page==null)
			page="1";
		int curpage=Integer.parseInt(page);
		int rowSize=12;
		int start=(rowSize*curpage)-(rowSize-1);
		int end=rowSize*curpage;
		List<FoodVO> list=dao.foodListData(start, end);
		
		int totalpage=dao.foodTotalPage();
		final int BLOCK=10;
		int startPage=((curpage-1)/BLOCK*BLOCK)+1;
		int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
		if(endPage>totalpage)
			endPage=totalpage;
		
		model.addAttribute("curpage", curpage);
		model.addAttribute("totalpage", totalpage);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("list", list);
		
		return "food/list";
	}
	
	@RequestMapping("food/detail.do")
	public String food_detail(int fno,Model model)
	{
		FoodVO vo=dao.foodDetailData(fno);
		model.addAttribute("vo", vo);
		/*
		 *    class Model
		 *    {
		 *    	private HttpServletRequest request
		 *    	public Model(HttpServletRequest request)
		 *    	{
		 *    		this.request=request;
		 *    	}
		 *    	public void addAttribute(String key,Object obj)
		 *    	{
		 *    		request.setAttribute(key,obj)
		 *    	}
		 *    }
		 *    request하면 사용자의 IP를 확인할수있음 보안때문에 request안씀
		 *    쿠키만들땐 request써야함 내장아니라서 (cookies라는 어노테이션도 있음)
		 */
		return "food/detail";
	}
	
	// 화면을 바꿀때
	@RequestMapping("food/find.do")
	public String food_find()
	{
		return "food/find";
	}
}
