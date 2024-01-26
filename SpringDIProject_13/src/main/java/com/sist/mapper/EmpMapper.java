package com.sist.mapper;
import java.util.*;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import com.sist.dao.*;
public interface EmpMapper {
	
	@Select("SELECT empno,ename,job "
			+"FROM emp")
	public List<EmpVO> empListData();
}
