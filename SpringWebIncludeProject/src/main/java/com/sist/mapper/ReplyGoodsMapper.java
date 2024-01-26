package com.sist.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import com.sist.vo.ReplyGoodsVO;
import java.util.*;

public interface ReplyGoodsMapper {
	
	@SelectKey(keyProperty = "gno", resultType = int.class,before=true,
				statement = "SELECT NVL(MAX(gno)+1,1) as gmp FROM springGoodsReply")
	@Insert("INSERT INTO springGoodsReply VALUES("
			+"#{gno},#{no},#{id},#{name},#{msg},SYSDATE)")
	public void replyGoodsInsert(ReplyGoodsVO vo);
	
	@Select("SELECT gno,no,id,name,TO_CHAR(regdate,'YYYY-MM-DD HH24:MI:SS') as dbday,msg "
			+"FROM springGoodsReply "
			+"WHERE no=#{no} "
			+"ORDER BY gno DESC")
	public List<ReplyGoodsVO> replyGoodsListData(int no);
	
	@Update("UPDATE springGoodsReply SET "
			+"msg=#{msg} "
			+"WHERE gno=#{gno}")
	public void replyGoodsUpdate(ReplyGoodsVO vo);
	
	@Delete("DELETE FROM springGoodsReply "
			+"WHERE gno=#{gno}")
	public void replyGoodsDelete(int gno);
	
}
