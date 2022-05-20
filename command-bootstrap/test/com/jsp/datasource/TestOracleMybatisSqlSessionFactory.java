package com.jsp.datasource;

import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.jsp.dto.MemberVO;


public class TestOracleMybatisSqlSessionFactory {
	// junit테스트
	// 싱글톤패턴을 쓰게 되면 결합도가 올라가기 떄문에 패턴은 사용하지 않고 싱글톤을 사용한다.
	// 싱글톤과 싱글톤 패턴은 다른 것이다.
	// 싱글톤 패턴은 인스턴스를 하나를 가지게 하려고 하는 것이다.
	
	private OracleMybatisSqlSessionFactory sqlSessionFactory = 
			new OracleMybatisSqlSessionFactory();
	
	private SqlSession session;
	
	@Before
	public void init()throws Exception{
		session = sqlSessionFactory.openSession();
	}
	
	@Test
	public void testSqlSessionFactory()throws Exception{
		
		Assert.assertNotNull(sqlSessionFactory);
	}
	
	@Test
	public void testSqlSession()throws SQLException{
		Collection<String> mapNames = (Collection<String>)session.getConfiguration().getMappedStatementNames();
		
		Assert.assertTrue(mapNames.contains("Member-Mapper.selectMemberList"));
	}
	
	@Test
	public void testMemberList()throws SQLException{
		List<MemberVO> memberList = session.selectList("Member-Mapper.selectMemberList");
		
		Assert.assertEquals(7, memberList.size());
	}
	
	@After
	public void close()throws Exception{
		if(session != null) session.close();
	}
}
