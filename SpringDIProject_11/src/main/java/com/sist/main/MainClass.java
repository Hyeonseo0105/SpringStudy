package com.sist.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import com.sist.dao.*;

@Component
/*
 *    @Component
 *      => 사용 위치 ==> 클래스에만 적용
 *    
 *    @Autowired
 *      value={CONSTRUCTOR, METHOD, PARAMETER, FIELD, ANNOTATION_TYPE}
 *              생성자구분가능
 *            생성자위에올라갈수있다        매개변수   멤버변수  
 *       class A
 *       {
 *          @Autowired?
 *          B b
 *          @Constructor?
 *          public A(){}
 *          @method
 *          public void display(){}
 *          public A(@parameter B b){}
 *       }
 */
public class MainClass {
	// @Autowired + @Qualifier = @Resource(1.8)
	@Autowired
	@Qualifier("foodDAO")      // 여러 객체 중 지정할때 사용
	                           // 특정 객체 선택시 사용
	private OracleDB ob;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext app=new ClassPathXmlApplicationContext("app.xml");
		MainClass mc=(MainClass)app.getBean("mainClass");
		mc.ob.display();
	}

}
