package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.BoardDAO;
import board.BoardSet;
import board.BoardVO;


public class SearchBoardTitleAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		
		BoardDAO bDAO = new BoardDAO();
		BoardVO bVO = new BoardVO();
		
		
		bVO.setBtitle(request.getParameter("btitle"));
		System.out.println("btitle parameter : "+ request.getParameter("btitle"));
		System.out.println("bVO 값 : " + bVO);
		
		
		ArrayList<BoardSet> datas = bDAO.selectAll_searchTitle(bVO);
		
		if(datas.size() != 0) { //만약 datas에 검색된 내용이 있다면 
			request.setAttribute("bList", datas);
			System.out.println("검색 action 중" + datas);
			forward=new ActionForward();
			forward.setPath("board.jsp"); // 게시글 메인으로 (변경필요) 
			forward.setRedirect(false); 
			
		}else {
			throw new Exception("SearchBoardTitleAction 오류");
		}
		return forward;
	}
}