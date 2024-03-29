package com.sist.main;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 *    어노테이션
 *      = 메모리 할당(선택적)
 *         => 스프링에서 기능별로 구분해서 사용
 *          @Component : 일반 클래스 => ~Manager , MainClass
 *          @Repository : 저장소 => ~DAO
 *          @Service : DAO여러개를 연결해서 사용 , BI
 *                       => 기능을 통합해서 사용
 *                       => 실무에서는 가장 많이 사용되는 어노테이션
 *                       => ~Service
 *          @Controller : Model (스트럿츠: ~Action)
 *                       => BoardController
 *          @RestController : Model => 자바스크립트와 연결
 *            => VueJS
 *          @ControllerAdvice : 모든 Model클래스의 예외처리
 *          @Configuration : application.xml => 자바로 설정
 *        
 *      = DI
 *          @AutoWired => 스프링에 의해서 자동으로 객체주소를 주입
 *          @PostConstructor => init-method
 *          @PreDestroy      => destroy-method
 */
//@Aspect : 메모리 할당 X
//@RequestMapping("databoard") : 할당 X   => @RequestMapping("list.do")

@Component
class A
{
	public void display()
	{
		System.out.println("A:display() Call");
	}
}
class B
{
	public void display()
	{
		System.out.println("B:display() Call");
	}
}

@Component
class C
{
	public void display()
	{
		System.out.println("C:display() Call");
	}
}
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] cls= {"com.sist.main.A",
				       "com.sist.main.B",
				       "com.sist.main.C"};
		try
		{
			for(String s:cls)
			{
				Class clsName=Class.forName(s);
				if(clsName.isAnnotationPresent(Component.class)==false)
				{
					continue;
				}
				Object obj=clsName.getDeclaredConstructor().newInstance();
				System.out.println(obj);
			}
		}
		catch(Exception ex) {}
		
	}
}
