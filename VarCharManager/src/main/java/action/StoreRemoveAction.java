package action;

import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import car.CarDAO;
import car.CarVO;
public class StoreRemoveAction implements Action{
   @Override
   public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
      
      HttpSession session = request.getSession(); //찜을 세션정보로 저장할 예정
      CarDAO cDAO = new CarDAO();
      CarVO cVO = new CarVO();
//      System.out.println("삭제 전 찜목록 : " + session.getAttribute("sdatas"));
      ArrayList<CarVO> sdatas=(ArrayList<CarVO>)session.getAttribute("sdatas"); // 찜목록
      
      String strCnum = request.getParameter("cnum"); // 삭제할 상품 PK
//      System.out.println("StoreRemoveAction 로그 request.getParameter(cnum) : " + strCnum);
      try {
         int cnum = Integer.parseInt(strCnum); 
         cVO.setCnum(cnum); 
         cVO = cDAO.selectOne(cVO);
//         System.out.println("StoreRemoveAction 로그 sdatas" + sdatas);
//         System.out.println("StoreRemoveAction 로그 cVO : " + cVO);
         
         
         if(sdatas != null && cVO != null) { // 찜목록이 비어있지 않다면 
            for(int i = 0; i < sdatas.size(); i++) { // 찜목록에서 삭제할 상품 찾아 삭제
               if(sdatas.get(i).getCnum() == cnum) {
                  sdatas.remove(i);
               }
            }
            session.setAttribute("sdatas", sdatas); // 삭제 후 찜목록 세션에 저장
//            System.out.println("StoreRemoveAction 로그 : 찜목록 삭제 성공");
         }
         else {
//            System.out.println("StoreRemoveAction 로그 : 찜목록 삭제 실패");
            throw new Exception("찜목록 삭제 실패...");
         }
      //   session.setAttribute("sdatas", sdatas);
      
      } catch (Exception e) {
         e.printStackTrace();
      }
      
      ActionForward forward=new ActionForward();
      forward.setPath("filter.do");
      forward.setRedirect(false);      
      return forward;
   }
}