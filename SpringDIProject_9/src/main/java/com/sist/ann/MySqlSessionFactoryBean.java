package com.sist.ann;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
/*
 * <bean id="ssf" class="org.mybatis.spring.SqlSessionFactoryBean"
		  p:dataSource-ref="ds"
	/>
 */
@Component("ssf")  // 안에 id명칭
// 지정하지 않는 경우 => mySqlSessionFactoryBean 앞글자가 소문자로
public class MySqlSessionFactoryBean extends SqlSessionFactoryBean {

	@Autowired   // 스프링에서 자동으로 datasource를 찾아서 getBean
	public void setDataSource(DataSource dataSource) {
		// TODO Auto-generated method stub
		super.setDataSource(dataSource);
	}

}
