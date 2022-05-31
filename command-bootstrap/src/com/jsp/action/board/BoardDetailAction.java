package com.jsp.action.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;
import com.jsp.dto.BoardVO;
import com.jsp.service.BoardService;
import com.jsp.service.NoticeService;

public class BoardDetailAction implements Action {
	
	private BoardService boardService;
	public void setBoardService(BoardService boardService) {
		this.boardService = boardService;
	}
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = "/board/detail";
		
		int bno = Integer.parseInt(request.getParameter("bno"));
		
		String from = request.getParameter("from");
		
		BoardVO board = null;
		
		if(from != null && from.equals("list")) {
			board = boardService.getBoard(bno);
			// 새로고침해도 조회수 증가 안되게 한다.
			// from을 list와 비교를 하여 list가 아니기 때문에 새로고침을 해도 redirect로 url을 바꾸기 때문에 새로고침을 해도 조회수 증가가 이루어지지 않는다.
			url = "redirect:/board/detail.do?bno="+bno;
		}else {
			board = boardService.getBoardForModify(bno);
		}
		
		request.setAttribute("board", board);
		
		return url;
	}

}
