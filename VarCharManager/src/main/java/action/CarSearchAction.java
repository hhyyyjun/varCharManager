package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import car.CarDAO;
import car.CarVO;
import search.SearchDAO;
import search.SearchVO;

public class CarSearchAction implements Action{

   @Override
   public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

      SearchVO svo = new SearchVO();
      SearchDAO sdao = new SearchDAO();
      CarDAO cdao = new CarDAO();
      CarVO cvo = new CarVO();
      
      //연료
      String fuel[] = request.getParameterValues("fuel"); //연료 다중 선택 시
      //지역
      String city[] = request.getParameterValues("city"); //지역 다중 선택 시

      // 가격
      //검색할 때 입력한 값이 null이 아닌경우 = 범위를 위해 값을 입력하고 검색한 경우
      // => 첫 차량검색페이지를 실행한 경우 파라미터 값이 null임
      if(request.getParameter("pmin") != null && request.getParameter("pmax") != null) {
         int price_min = Integer.parseInt(request.getParameter("pmin")); //가격의 최소 값
         int price_max = Integer.parseInt(request.getParameter("pmax")); //가격의 최대 값
         svo.setPrice_min(price_min);
         svo.setPrice_max(price_max);
         request.setAttribute("pmin", price_min);
         request.setAttribute("pmax", price_max);
         System.out.println("가격 : "+price_min+"~"+price_max);
      }
      System.out.println("가격확인 : "+svo.getPrice_min()+"/"+svo.getPrice_max());

      //연식
      //검색할 때 입력한 값이 null이 아닌경우 = 범위를 위해 값을 입력하고 검색한 경우
      if(request.getParameter("ymin") != null && request.getParameter("ymax") != null) {
         int year_min = Integer.parseInt(request.getParameter("ymin")); //연식의 최소 값
         int year_max = Integer.parseInt(request.getParameter("ymax")); //연식의 최대 값
         svo.setYear_min(year_min);
         svo.setYear_max(year_max);
         request.setAttribute("ymin", year_min);
         request.setAttribute("ymax", year_max);
         System.out.println("연식 : "+year_min+"~"+year_max);
      }
      System.out.println("연식확인 : "+svo.getYear_min()+"/"+svo.getYear_max());
      
      //주행거리
//      System.out.println("형변환 전 : "+request.getParameter("min-value"));
      if(request.getParameter("min-value") != null && request.getParameter("max-value") != null) {
         int km_min=Integer.parseInt(request.getParameter("min-value")); //주행거리 최소 값
         int km_max=Integer.parseInt(request.getParameter("max-value")); //주행거리 최대 값
         svo.setKm_min(km_min);
         svo.setKm_max(km_max);
         request.setAttribute("kmin", km_min);
         request.setAttribute("kmax", km_max);
         System.out.println("주행거리 : "+km_min+"~"+km_max);
//         System.out.println("형변환 후 : "+km_max);
      }
      System.out.println("주행거리확인 : "+svo.getKm_min()+"/"+svo.getKm_max());
      
      String sort = request.getParameter("sort"); //select 정렬
      request.setAttribute("sort", sort);
      svo.setChecksort(sort);

      ArrayList<String> fList = new ArrayList<String>(); //필터(연료) 선택 시 데이터가 들어갈 배열객체
      ArrayList<String> cList = new ArrayList<String>(); //필터(지역) 선택 시 데이터가 들어갈 배열객체
      if(fuel != null){
         for(int i=0;i<fuel.length;i++) { //선택된 필터 개수에 따라 반복처리하여 검색
        	 if(fuel[i].equals("전체")){
        		 continue;
        		 }
            fList.add(fuel[i]);
            System.out.println("받아온 연료 파라미터 값 : " + fuel[i]);
         }
         svo.setFuelList(fList); //SearchVO의 배열객체에 필터선택된 연료배열값 저장
      }
      // ★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★
      request.setAttribute("fList", fList);
      // ★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★
      
      if(city != null){
         for(int i=0;i<city.length;i++) { //선택된 필터 개수에 따라 반복처리하여 검색
        	 if(city[i].equals("전체")){
        		 continue;
        		 }
            cList.add(city[i]);
            System.out.println("받아온 지역 파라미터 값 : " + city[i]);
         }
         svo.setCityList(cList); //SearchVO의 배열객체에 필터선택된 지역배열값 저장
      }
      request.setAttribute("cList", cList);
      System.out.println("로그 CarSearchAction fList : " + fList);
      System.out.println("로그 CarSearchAction cList : " + cList);

      ArrayList<CarVO> datas = sdao.selectMore(svo);
      System.out.println();
      request.setAttribute("datas", datas);
      ActionForward forward = new ActionForward();
      forward.setPath("filterSearch.jsp");
      forward.setRedirect(false);
      return forward;

      
   }

}