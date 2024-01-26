package com.sist.dao;

import java.util.*;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.sist.vo.*;
import com.sist.mapper.*;

/*
 *	 *.do  ======= DispatcherServlet
 *                        | => preHandle() => 자동 로그인
 *                        | HandlerMpping
 *                    @Controller / @RestController
 *                        | => postHandle()
 *                        | Model=request => ViewResolver
 *                        | => afterCompletion() => 권한
 *                       JSP
 *	  => AOP
 *         void aaa(); => Before
 *         void bbb(); => AfterThrowing
 *         void ccc(); => After
 *         void ddd(); => AfterReturning
 *         
 *         public String display()
 *         {
 *             aaa()
 *             try
 *             {
 *                ==============
 *                   핵심 소스
 *                ==============
 *             }
 *             catch(Exception ex)
 *             {
 *                 bbb();
 *             }
 *             finally
 *             {
 *                 ccc()
 *             }
 *             ddd()
 *             return "";
 *         }
 *         
 *         JoinPoint : 호출 위치
 *         PointCut : 대상 메소드
 *         =================== Advice
 *                             ====== 여러개 모아서 == Aspect
 *                                 공통 모듈
 *         => MVC
 *             | DI,AOP => Annotation , XML
 *               ==========================
 *               Annotation : 개발자 마다 (기능별)
 *               XML : 공통 기반 => 라이브러리 설정
 */

@Repository
public class ReplyDAO {
	
	@Autowired
	private ReplyMapper mapper;
	
	public void replyInsert(ReplyVO vo)
	{
		mapper.replyInsert(vo);
	}
	
	// 목록
	public List<ReplyVO> replyListData(int fno)
	{
		return mapper.replyListData(fno);
	}
	
	// 수정
	public void replyUpdate(ReplyVO vo)
	{
		mapper.replyUpdate(vo);
	}
	
	// 삭제
	public void replyDelete(int no)
	{
		mapper.replyDelete(no);
	}
}
