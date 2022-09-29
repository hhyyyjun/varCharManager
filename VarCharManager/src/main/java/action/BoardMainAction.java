package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.BoardDAO;
import board.BoardSet;
import board.BoardVO;
import member.MemberDAO;
import member.MemberVO;


public class BoardMainAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();

		BoardVO bvo = new BoardVO();
		BoardDAO bDAO = new BoardDAO();
		MemberDAO mdao = new MemberDAO();
		MemberVO mvo = new MemberVO();

		String paramCnt = request.getParameter("cnt");
		System.out.println("paramcnt : "+paramCnt);
		if(paramCnt == null || paramCnt.equals("")){
			System.out.println("param값이 null이야!");
			bvo.setCnt(4); // 향후 초기화 매개변수 등으로 설정가능
		}
		else {
			System.out.println("param 값 존재");
			bvo.setCnt(Integer.parseInt(paramCnt));
		}
		//게시판 출력하는 부분
		ArrayList<BoardSet> bList = bDAO.selectAll(bvo); //게시판 정보 담을 배열 객체 생성
		request.setAttribute("bList", bList); //배열객체 데이터를 담아 속성명 저장
		System.out.println("보드메인액션 중 : "+bList);
		//nickname 세팅
		HttpSession session = request.getSession();
		mvo.setMid((String)session.getAttribute("userId")); //세션에 저장된 id 값 셋
		System.out.println("보드메인액션에서 실행 중  11111: "+mvo);
		mvo = mdao.selectOne_M(mvo); //닉네임 정보를 출력할 메서드 사용
		System.out.println("보드메인액션에서 실행 중 : "+mvo);
		request.setAttribute("bdata", mvo); 

		request.setAttribute("cnt", bvo.getCnt());//더보기 세팅
		//		System.out.println("1번 파라미터값 : "+paramCnt+"/세팅한 cnt : "+bVO.getCnt());
		//
		//		System.out.println("2번 파라미터값 : "+paramCnt+"/세팅한 cnt : "+bVO.getCnt());

		BoardVO nextBvo = bvo;
		// 다음에 보여줄 게시글 (2개씩)
		nextBvo.setCnt(bvo.getCnt() + 4);
		System.out.println("4번 파라미터값 : "+paramCnt+"/세팅한 cnt : "+bvo.getCnt());
		ArrayList<BoardSet> nextDatas = bDAO.selectAll(nextBvo);
		// cnt와 '다음에 보여줄 게시글 개수' 차이가 2보다 크거나 같으면 더보기 버튼 비활성화
		request.setAttribute("noMoreContent", nextBvo.getCnt() - nextDatas.size() >= 4 ? true : false);



		forward.setPath("board.jsp");
		forward.setRedirect(false);
		return forward;
	}

}