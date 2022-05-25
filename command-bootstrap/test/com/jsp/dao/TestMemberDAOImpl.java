package com.jsp.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.jsp.datasource.OracleMybatisSqlSessionFactory;
import com.jsp.dto.MemberVO;

import junit.framework.Assert;

public class TestMemberDAOImpl {
	
	private SqlSessionFactory factory = new OracleMybatisSqlSessionFactory();
	
	private SqlSession session;
	
	private MemberDAO memberdao = new MemberDAOImpl();
	
	@Before
	public void init()throws Exception{
		session = factory.openSession();
	}
	
	@After
	public void close()throws Exception{
		if(session!=null) session.close();
	}
	
	@Test
	public void testSelectMemberList() throws Exception{
		List<MemberVO> memberList = memberdao.selectMemberList(session);
		Assert.assertEquals(7, memberList.size());
		
	}
}
