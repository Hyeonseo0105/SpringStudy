package com.sist.dao;
import java.util.*;

import org.apache.ibatis.annotations.Select;
public interface SeoulMapper {
	@Select("SELECT no,title "
		   +"FROM seoul_nature "
		   +"ORDER BY no ASC")
	public List<SeoulVO> natureListData();
	
	@Select("SELECT no,title,msg,address "
		   +"FROM seoul_nature "
		   +"WHERE no=#{no}")
	public SeoulVO natureDetailData(int no);
	
	@Select("select no,title "
		   +"FROM seoul_nature "
		   +"WHERE title LIKE '%'||#{title}||'%' "
		   +"ORDER BY no ASC")
	public List<SeoulVO> natureFindData(String title);   // VO를 받으면 오류 List<>써야함
	// public SeoulVO findByNo(int no)     // findByNo == WHERE
	/*
	 *    public SeoulVO natureDetailData(int no)
	 *    {
	 *       SeoulVO vo=new SeoulVO();
	 *       try
	 *       {
	 *          getConnection();
	 *          String sql="SELECT ~"
	 *                     +"WHERE no=?";
	 *          ps=conn.prepareStatement(sql);
	 *          ps.setInt(1,no);
	 *          ResultSet rs=ps.executeQuery();
	 *          rs.next();
	 *          vo.set
	 *          vo.setNo(rs.getInt(1));
	 *          vo.setTitle(rs.getString(2));
	 *          vo.setMsg(rs.getString(3));
	 *          vo.setAddress(rs.getString(4));
	 *       }
	 *       catch(Exception ex)
	 *       {
	 *          ex.printStackTrace();
	 *       }
	 *       finally
	 *       {
	 *          dbconn.disConnection(conn,ps);
	 *       }
	 *    }
	 */
}
