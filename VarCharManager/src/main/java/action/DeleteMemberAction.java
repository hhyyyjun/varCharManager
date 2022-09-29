package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import board.BoardVO;
import member.MemberDAO;
import member.MemberVO;

public class DeleteMemberAction implements Action{

   @Override
   public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
     ActionForward forward = null;
     MemberVO mvo = new MemberVO();
      BoardVO bvo = new BoardVO();
      MemberDAO mdao = new MemberDAO();

      String deleteAll = request.getParameter("deleteAll");
      String deleteOnlyMsg = request.getParameter("deleteOnlyMsg");
      String userId = request.getParameter("changeMid");
     // String userPw = request.getParameter("changeMpw");
      System.out.println(userId);
      //System.out.println(userPw);
     
      
      mvo.setMid(userId);
     // mvo.setMpw(userPw);
      bvo.setMid(userId);
      if(deleteAll!=null && deleteAll.equals("deleteAll")) {
         System.out.println(deleteAll);
         bvo.setRes(true);
      }
      else if( deleteOnlyMsg!=null && deleteOnlyMsg.equals("deleteOnlyMsg")) {
         System.out.println(deleteOnlyMsg);
         bvo.setRes(false);
      }
      System.out.println(bvo);
      System.out.println(mvo);
      
      if(mdao.delete(bvo, mvo)) {
         System.out.println("deleteaction if문 : ");
          HttpSession session = request.getSession();
          session.invalidate();
          forward = new ActionForward();
          forward.setPath("main.do");
          forward.setRedirect(true);
      }else {
         throw new Exception("error");
      }
      return forward;
   }

}