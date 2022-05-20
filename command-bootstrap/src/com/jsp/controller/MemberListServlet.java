package com.jsp.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.command.Criteria;
import com.jsp.dto.MemberVO;
import com.jsp.service.MemberService;
import com.jsp.service.MemberServiceImpl;

/**
 * Servlet implementation class MemberListServlet
 */
@WebServlet("/member/list")
public class MemberListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private MemberService memberService = new MemberServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/WEB-INF/views/member/list.jsp";
		
		String pageParam = request.getParameter("page");
		String perPageNumParam = request.getParameter("perPageNum");
		
		Criteria cri = new Criteria();
		
		boolean criFlag = true;
		criFlag = criFlag && pageParam != null
				          && !pageParam.isEmpty()
				          && perPageNumParam != null
				          && !perPageNumParam.isEmpty();
		
		if(criFlag) {
			// 페이지가 문자일 경우 터질 수도 있다.
			try {
				cri.setPage(Integer.parseInt(pageParam));
				cri.setPerPageNum(Integer.parseInt(perPageNumParam));
			} catch (Exception e) {
				response.sendError(response.SC_BAD_REQUEST);
				return; // 값이 없는 메소드는 돌아가라
			}
			
		}
				          
		
		try {
			// 예외가 발생하지 않았을 때
//			List<MemberVO> memberList = memberService.getMemberList(cri);
//			request.setAttribute("memberList", memberList);
			
			Map<String, Object> dataMap = memberService.getMemberListForPage(cri);
			request.setAttribute("dataMap", dataMap);
			
			
		} catch (Exception e) {
			// 예외가 발생했을 때
			url = "/WEB-INF/views/error/500.jsp";
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
