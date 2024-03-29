package com.jsp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.dto.MemberVO;
import com.jsp.service.MemberService;
import com.jsp.service.SearchMemberServiceImpl;

@WebServlet("/member/idCheck")
public class MemberIdCheckServlet extends HttpServlet {

   private MemberService service = new SearchMemberServiceImpl();
   
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String url = null;
      
      String resultStr = "";
      
      String id = request.getParameter("id");
      
      try {
         MemberVO member = service.getMember(id);
         if(member != null) {
            resultStr = "DUPLICATED";
         }
         
         response.setContentType("text/html; charset=utf-8");
         PrintWriter out = response.getWriter();
         out.print(resultStr);
         out.close();
         
      } catch (Exception e) {
         response.sendError(response.SC_INTERNAL_SERVER_ERROR);
      }
   
   }
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // TODO Auto-generated method stub
      doGet(request, response);
   }

}