package com.sist.mapper;
/*
 *   name => N
 *   address => A
 *   type => T
 *   name+address => NA
 *   name+type => NT
 *   address+type => AT
 *   name+address+type => NAT
 */
import java.util.*;
import org.apache.ibatis.annotations.Select;
import com.sist.dao.FoodVO;

public interface FoodMapper {
	// XML
	/*
	 *    <trim prefix="(" suffix=")" PREFIXoVERRIEDS="(">
	 *           접두어       접미어
	 *     suffixOverrides=")"
	 *     
	 *     => name LIKE '%'||#{ss}||'%'
	 *    </trim>
	 *    
	 *    => name LIKE '%'||#{ss}||'%'
	 *    
	 *    <foreach collection=\"fsArr\"
	 *    ?
	 *    ?
	 *    ?
	 *    ==> fd=='A' "A" == 65
	 */
	@Select("<script>"
			+"SELECT fno,name,type,address "
			+"FROM food_menu_house "
			+"WHERE "
			+"<trim prefixOverrides=\"OR\">"
			//+"<trim prefix=\"(\" suffix=\")\" prefixOverrides=\"OR\">"
			// OR (name LIKE '%'||#{ss}||'%') OR (address LIKE '%'||#{ss}||'%')
			+"<foreach collection=\"fsArr\" item=\"fd\">"
			//+"<trim prefix=\"OR\">"
			/* if(ss=='N')
			 * OR name LIKE ~
			 * else if(ss='A')
			 * OR address LIKE ~
			 * else if(ss=='T')
			 * OR type LIKE~
			 */
			 +"<choose>"
			 +"<when test=\"fd=='N'.toString()\">"
			 +"OR name LIKE '%'||#{ss}||'%'"
			 //+"name LIKE '%'||#{ss}||'%'"
			 +"</when>"
			 +"<when test=\"fd=='A'.toString()\">"
			 +"OR name LIKE '%'||#{ss}||'%'"
			// +"name LIKE '%'||#{ss}||'%'"
			 +"</when>"
			 +"<when test=\"fd=='T'.toString()\">"
			 +"OR name LIKE '%'||#{ss}||'%'"
			 //+"name LIKE '%'||#{ss}||'%'"
			 +"</when>"
			 +"</choose>"
			 +"</foreach>"
			 +"</trim>"
			 +"</script>")	
	public List<FoodVO> foodFindData(Map map);
			
}
