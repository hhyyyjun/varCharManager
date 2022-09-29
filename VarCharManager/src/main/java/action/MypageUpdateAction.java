package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.MemberDAO;
import member.MemberVO;

public class MypageUpdateAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward= null;

		MemberDAO mdao = new MemberDAO();
		MemberVO mvo = new MemberVO();
		
		// id,pw로 받아온 값으로 사용자 한명의 모든 데이터를 가져온다.
		//String changeMname = request.getParameter("changeMname");
		String changeMid = request.getParameter("changeMid");
		String changeMnickname = request.getParameter("changeMnickname");
		String changeMpw = request.getParameter("changeMpw");
		String changeMphone = request.getParameter("changeMphone");
		String changeMadd = request.getParameter("changeMadd");
		String changeMemail = request.getParameter("changeMemail");
		//String changeMrole = request.getParameter("changeMrole");
		
		System.out.println("mypageupdate : " + changeMpw);
		System.out.println("mypageupdate : " + changeMnickname);

		// 이름 변경 부분
		//mvo.setMname(changeMname);
		// 아이디 변경 부분
		mvo.setMid(changeMid);
		// 닉네임 변경 부분
		mvo.setMnickname(changeMnickname);
		// 비밀번호 변경 부분
		mvo.setMpw(changeMpw);
		// 전화번호 변경 부분
		mvo.setMphone(changeMphone);
		// 주소 변경 부분
		mvo.setMadd(changeMadd);
		// 이메일 변경 부분
		mvo.setMemail(changeMemail);
		// 계정 변경 
		//mvo.setMrole(changeMrole);

		System.out.println("mvo통과 "  + mvo);
		
		// 회원 정보 변경 
		request.setAttribute("mdata", mvo);
		if(mdao.update(mvo)) {
			forward = new ActionForward();
			forward.setPath("main.do");
			forward.setRedirect(true);
			
		}else {
			throw new Exception("mypageUpdate 오류");
		}
		return forward;
	}
}
		

