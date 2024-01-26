package com.sist.main;
/*
 *    @Autowired : 반드시 스프링에서 메모리 할당을 해야 자동 주입이 가능
 *    
 *    Class A
 *    {
 *       @Autowired
 *       B b;  ==> null       
 *    }
 *    @component
 *    Class B
 *    {
 *       @Autowired
 *       A a; == 주소
 *    }
 *    
 */
import java.util.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.sist.dao.*;

public class MainClass3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		ApplicationContext app=new ClassPathXmlApplicationContext("application-*.xml");
//		FoodDAO fDao=(FoodDAO)app.getBean("fDao");
//		Scanner scan=new Scanner(System.in);
//		System.out.print("1.업체명,2.주소,3.음식종류 선택:");
//		int col=scan.nextInt();
//		String fd="";
//		String[] temp={"","name","address","type"};
//		fd=temp[col];
//		System.out.print("검색어 입력:");
//		String ss=scan.next();
//		
//		Map map=new HashMap();
//		map.put("col_name", fd);
//		map.put("ss", ss);
//		
//		List<FoodVO> list=fDao.foodFindData(map);
//		
//		for(FoodVO vo:list)
//		{
//			System.out.println(vo.getFno()+" "+vo.getName()+" "
//					           +vo.getName()+" "
//					           +vo.getAddress()+" "
//					           +vo.getType());
//		}
		
		ApplicationContext app=new ClassPathXmlApplicationContext("application-*.xml");
		GoodsDAO gDao=(GoodsDAO)app.getBean("gDao");
		Scanner scan=new Scanner(System.in);
		System.out.print("1.제품명,2.가격 선택:");
		int col=scan.nextInt();
		String gd="";
		String[] temp= {"","goods_name","goods_price"};
		gd=temp[col];
		System.out.print("검색어 입력:");
		String name=scan.next();
		
		Map map=new HashMap();
		map.put("col_name", gd);
		map.put("name", name);
		
		List<GoodsVO> list=gDao.goodsFindData(map);
		
		for(GoodsVO vo:list)
		{
			System.out.println(vo.getNo()+" "+vo.getGoods_name()+" "+vo.getGoods_price());
		}
	}

}
