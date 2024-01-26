package com.sist.web;

import java.util.*;

import javax.servlet.http.HttpServletRequest;

import java.io.*;
import com.sist.dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

// 스크립트 처리를 한다
@RestController
public class DataBoardRestController {

	@Autowired
	private DataBoardDAO dao;
	
	// jsp post방식으로 보냄
	@PostMapping("databoard/delete_ok.do")
	public String databoard_delete(int no,String pwd,HttpServletRequest request)
	{
		String path=request.getSession().getServletContext().getRealPath("/")+"upload\\";
		path=path.replace("\\", File.separator);
		String result="";
		try
		{
			DataBoardVO vo=dao.databoardFileInfoData(no);
			boolean bCheck=dao.databoardDelete(no, pwd);
			if(bCheck==true)
			{
				result="yes";
				if(vo.getFilecount()>0)
				{
					StringTokenizer st=new StringTokenizer(vo.getFilename(),",");
					while(st.hasMoreTokens())
					{
						File file=new File(path+st.nextToken());
						file.delete();
					}
				}
			}
			else
			{
				result="no";
			}
		}
		catch (Exception ex) {}
		return result;
	}
	
}
