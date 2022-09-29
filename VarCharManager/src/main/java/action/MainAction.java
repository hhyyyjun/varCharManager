package action;

import java.util.ArrayList;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.BoardDAO;
import board.BoardVO;
import car.CarDAO;
import car.CarVO;
import member.MemberDAO;
import member.MemberVO;

public class MainAction implements Action {

   @Override
   public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

      CarDAO cdao = new CarDAO(); //최근 등록된 차량 12개 상품 출력할 예정, 제목/가격/연료 표시, 등록된 차량 수 출력 예정
      CarVO cvo = new CarVO();
      BoardVO bvo = new BoardVO();
      BoardDAO bdao = new BoardDAO(); //게시글 최근 3개의 제목 출력할 예정
      MemberDAO mdao = new MemberDAO(); //등록된 회원 수 출력할 예정
      MemberVO mvo = new MemberVO();


      ArrayList<CarVO> recentCarList = cdao.selectAllPage(cvo); //최근 등록 차량들을 저장할 배열객체 생성
      request.setAttribute("recentC", recentCarList);

      ArrayList<MemberVO> countMember = mdao.selectAll(mvo); //회원 전체 데이터 배열로 저장
      ArrayList<CarVO> countCar = cdao.selectAll(cvo); //자동차 전체 데이터 배열로 저장
      ArrayList<CarVO> randCar = new ArrayList<CarVO>(); //추천 랜덤차량 데이터 담는 배열객체ㅐ

      //차량 랜덤 추천
      Random random = new Random();
      for(int i=0;i<7;i++) { //6개까지만 추천할 예정이므로 하드코딩이 필요함
         int rand = random.nextInt(countCar.size()+1); //전체 데이타 중 랜덤 값 추출
         cvo.setCnum(rand);
         cvo = cdao.selectOne(cvo);
         randCar.add(cvo);
      }
      request.setAttribute("cdata", randCar);

         
      //게시판 제목
      ArrayList<BoardVO> recentBoardList = bdao.selectAll_R(bvo); //최근 등록된 문의글 제목담을 배열객체 생성
      request.setAttribute("recentB", recentBoardList);
      System.out.println(recentBoardList);
         

      request.setAttribute("countM", countMember.size()); //회원 데이터 배열의 길이
      request.setAttribute("countC", countCar.size()); //자동차 데이터 배열의 길이

      System.out.println("회원수 :" + countMember.size());
      System.out.println("자동차 등록 대수 :" + countCar.size());

      ActionForward forward = new ActionForward();
      forward.setPath("main.jsp");
      forward.setRedirect(false);
      return forward;
   }

}