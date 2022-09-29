package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.MemberDAO;
import member.MemberVO;

public class InsertMemberAction implements Action{

   @Override
   public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
      ActionForward forward = null;
      
      MemberDAO mdao = new MemberDAO();
      MemberVO mvo = new MemberVO();
      String madd = request.getParameter("madd"); //주소
      String maddDetail = request.getParameter("maddDetail"); //상세주소
      
      
      mvo.setMadd(madd + " " + maddDetail); // mvo에 주소 + 상세주소 set해줌 
      mvo.setMid(request.getParameter("mid"));
      mvo.setMpw(request.getParameter("mpw"));
      mvo.setMname(request.getParameter("mname"));
      mvo.setMnickname(request.getParameter("mnickname"));
      mvo.setMemail(request.getParameter("memail"));
      mvo.setMphone(request.getParameter("mphone"));
      mvo.setMrole("일반회원");
      
      if(mdao.insert(mvo)) {
      forward = new ActionForward();
      forward.setPath("main.do");
      forward.setRedirect(true);
      } else {
         throw new Exception("insertMemberAction 오류");
      }
      // TODO Auto-generated method stub
      return forward;
   }
   
}