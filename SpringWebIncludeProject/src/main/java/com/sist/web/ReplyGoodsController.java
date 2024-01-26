package com.sist.web;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.sist.dao.*;
import com.sist.vo.*;

@Controller
public class ReplyGoodsController {
	
	@Autowired
	private ReplyGoodsDAO dao;
	
	@PostMapping("greply/greply_insert.do")
	public String reply_insert(int no, String msg, HttpSession session, RedirectAttributes ra)
	{
		ReplyGoodsVO vo=new ReplyGoodsVO();
		String id=(String)session.getAttribute("id");
		String name=(String)session.getAttribute("name");
		vo.setNo(no);
		vo.setMsg(msg);
		vo.setId(id);
		vo.setName(name);
		dao.replyGoodsInsert(vo);
		ra.addAttribute("no",no);
		return "redirect:../goods/detail.do";
	}
	
	@GetMapping("greply/greply_delete.do")
	public String reply_delete(int gno, int no, RedirectAttributes ra)
	{
		dao.replyGoodsDelete(gno);
		ra.addAttribute("no", no);
		return "redirect:../goods/detail.do";
	}
	
	@PostMapping("greply/greply_update.do")
	public String reply_update(int gno, int no, String msg, RedirectAttributes ra)
	{
		ReplyGoodsVO vo=new ReplyGoodsVO();
		vo.setGno(gno);
		vo.setMsg(msg);
		dao.replyGoodsUpdate(vo);
		ra.addAttribute("no", no);
		return "redirect:../goods/detail.do";
	}
}
