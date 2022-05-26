package com.jsp.action.common;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jsp.action.Action;
import com.jsp.dto.MenuVO;
import com.jsp.service.MenuService;

public class SubMenuAction implements Action {
	
	private MenuService menuService;
	public void setMenuService(MenuService menuService) {
		this.menuService = menuService;
	}
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 서브 메뉴는 view를 보내기보다는 data를 보내기  때문에 url을 null로 설정한다.
		String url = null;
		String mCode = request.getParameter("mCode");
		List<MenuVO> subMenu = null;
		
		try {
			subMenu = menuService.getSubMenuList(mCode);
			
			// 출력
			// json형태의 문구를 java가 읽을 수 있게 만들어 준다.
			ObjectMapper mapper = new ObjectMapper();
			
			// content Type 결정
			response.setContentType("application/json;charset=utf-8");
			PrintWriter out = response.getWriter();
			
			// 내보내기
			// writeValueAsString -> 형태를 String으로 반환하여 보내준다.
			out.println(mapper.writeValueAsString(subMenu));
			
			// out 객체를 종료하고 환원
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
			
			throw e;
		}
		
		return url;
	}

}
