package com.sist.mapper;

import java.util.*;
import com.sist.dao.*;

public interface EmpMapper {
	// id=method명
	// resultType,resultMap = return형
	public List<EmpVO> empAllData();
	
	public EmpVO empDetailData(int empno);
}
