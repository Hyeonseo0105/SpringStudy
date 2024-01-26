package com.sist.web;

import java.util.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.sist.dao.*;
import com.sist.vo.*;

@Controller
public class GoodsController {
	
	@Autowired
	private GoodsDAO gdao;
	
	@Autowired
	private ReplyGoodsDAO rgDao;
	
	@GetMapping("goods/main.do")
	public String goods_main(String page,Model model)
	{
		if(page==null)
			page="1";
		int curpage=Integer.parseInt(page);
		int rowSize=12;
		int start=(rowSize*curpage)-(rowSize-1);
		int end=rowSize*curpage;
		
		List<GoodsVO> glist=gdao.goodsListData(start, end);
		int totalpage=gdao.goodsTotalPage();
		
		final int BLOCK=10;
		int startPage=((curpage-1)/BLOCK*BLOCK)+1;
		int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
		
		if(endPage>totalpage)
			endPage=totalpage;
		
		model.addAttribute("curpage", curpage);
		model.addAttribute("totalpage", totalpage);
		model.addAttribute("startPage", startPage);		
		model.addAttribute("endPage", endPage);
		model.addAttribute("glist", glist);
		
		model.addAttribute("main_jsp", "list.jsp");
		return "goods/main";
	}
	
	@GetMapping("goods/detail_before.do")
	public String goods_detail_before(int no,HttpServletResponse response,RedirectAttributes ra)
	{
		Cookie cookie=new Cookie("goods_"+no, String.valueOf(no));
		cookie.setPath("/");
		cookie.setMaxAge(60*60*24);
		response.addCookie(cookie);
		ra.addAttribute("no", no);
		return "redirect:../goods/detail.do";
	}
	
	@GetMapping("goods/detail.do")
	public String food_detail(int no,Model model)
	{
		GoodsVO vo=gdao.goodsDetailData(no);
		List<ReplyGoodsVO> rgList=rgDao.replyGoodsListData(no);
		model.addAttribute("vo", vo);
		model.addAttribute("rgList", rgList);
		model.addAttribute("main_jsp", "../goods/detail.jsp");
		return "goods/main";
	}
	@RequestMapping("goods/find.do")
	public String food_find(String page, String colname, String ss,Model model)
	{
		if(colname==null)
			colname="goods_name";
		if(ss==null)
			ss="간식";
		
		if(page==null)
			page="1";
		int curpage=Integer.parseInt(page);
		int rowSize=12;
		int start=(rowSize*curpage)-(rowSize-1);
		int end=rowSize*curpage;
		
		Map map=new HashMap();
		map.put("col_name", colname);
		map.put("ss", ss);
		map.put("start", start);
		map.put("end", end);
		
		List<GoodsVO> list=gdao.goodsFindData(map);
		int totalpage=gdao.goodsFindTotalpage(map);
		
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
		model.addAttribute("ss", ss);
		model.addAttribute("colname", colname);
		
		model.addAttribute("main_jsp", "../goods/find.jsp");
		return "goods/main";
	}
}
