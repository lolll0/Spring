package com.jsp.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.jsp.command.SearchCriteria;
import com.jsp.dto.MemberVO;

public interface SearchMemberDAO extends MemberDAO {
		
	List<MemberVO> selectSearchMemberList(SqlSession session, SearchCriteria cri)throws Exception;
	int selectSearchMemberListCount(SqlSession session, SearchCriteria cri)throws Exception;
}
