package ajax;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import car.CarVO;
import search.SearchDAO;
import search.SearchVO;

/**
 * Servlet implementation class showMore
 */
@WebServlet("/showMore.do")
public class showMore extends HttpServlet {
   private static final long serialVersionUID = 1L;

   /**
    * @see HttpServlet#HttpServlet()
    */
   public showMore() {
      super();
      // TODO Auto-generated constructor stub
   }

   /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   //   System.out.println("showMore로그 ["+request.getParameter("cityList")+"] ["+request.getParameter("fuelList")+"]");
   //   System.out.println("showMore로그 :"+request.getParameter("sort")+"/"+request.getParameter("pmin")+"/"+request.getParameter("range1"));
      SearchVO svo = new SearchVO();
      SearchDAO sdao = new SearchDAO();
      
      // 전달 받은 배열 데이터에서 '[', ']' 삭제
      //연료
      String fuel = request.getParameter("fuelList"); //연료 다중 선택 시
      fuel = fuel.substring(1, fuel.length() - 1);
   //   System.out.println("showMore 로그 fuel : [" + fuel +"]");

      //지역
      String city = request.getParameter("cityList"); //지역 다중 선택 시
      city = city.substring(1, city.length() - 1);
   //   System.out.println("showMore 로그 city : [" + city +"]");

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
      //   System.out.println("가격 : "+price_min+"~"+price_max);
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
      //   System.out.println("연식 : "+year_min+"~"+year_max);
      }
      System.out.println("연식확인 : "+svo.getYear_min()+"/"+svo.getYear_max());

      //주행거리
      //      System.out.println("형변환 전 : "+request.getParameter("min-value"));
      if(request.getParameter("kmin") != null && request.getParameter("kmax") != null) {
         int km_min=Integer.parseInt(request.getParameter("kmin")); //주행거리 최소 값
         int km_max=Integer.parseInt(request.getParameter("kmax")); //주행거리 최대 값
         svo.setKm_min(km_min);
         svo.setKm_max(km_max);
         request.setAttribute("kmin", km_min);
         request.setAttribute("kmax", km_max);
      //   System.out.println("주행거리 : "+km_min+"~"+km_max);
         //         System.out.println("형변환 후 : "+km_max);
      }
   //   System.out.println("주행거리확인 : "+svo.getKm_min()+"/"+svo.getKm_max());

      String sort = request.getParameter("sort"); //select 정렬
      request.setAttribute("sort", sort);
      svo.setChecksort(sort);

      ArrayList<String> fList = new ArrayList<String>(); //필터(연료) 선택 시 데이터가 들어갈 배열객체
      ArrayList<String> cList = new ArrayList<String>(); //필터(지역) 선택 시 데이터가 들어갈 배열객체
      
      // ajax로 전달받은 지역, 연료 배열 데이터는 stringified 
      // --> ["서울", "경기"]와 같이 각 ,(comma)로 구분되고 데이터가 ""로 감싸짐 
      // --> comma, "" 제거
      if(!fuel.equals("") && fuel != null){
         String[] fuelTmp = fuel.split(",");
      //   System.out.println("showMore 로그 fuelTmp : " + Arrays.toString(fuelTmp));
         for(int i = 0; i < fuelTmp.length; i++) {
            fuelTmp[i] = fuelTmp[i].substring(1, fuelTmp[i].length() - 1);
         //   System.out.println("fuelTmp[i] : " + fuelTmp[i]);
            fList.add(fuelTmp[i]);
         }
      //   System.out.println("showMore 로그 fList :" + fList);
      }
      // ★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★
      request.setAttribute("fList", fList);
      svo.setFuelList(fList);
      // ★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★

      if(!city.equals("") && city != null){
         String[] cityTmp =  city.split(",");
      //   System.out.println("showMore 로그 cityTmp : " + Arrays.toString(cityTmp));
         for(int i = 0; i < cityTmp.length; i++) {
            cityTmp[i] = cityTmp[i].substring(1, cityTmp[i].length() - 1);
      //      System.out.println("cityTmp[i] : " + cityTmp[i]);
            cList.add(cityTmp[i]);
         }
      //   System.out.println("showMore 로그 cList :" + cList);
      }
      request.setAttribute("cList", cList);
      svo.setCityList(cList);

      int range1 = Integer.parseInt(request.getParameter("range1"));
      int range2 = Integer.parseInt(request.getParameter("range2"));
      svo.setRange1(range1);
      svo.setRange2(range2);



   //   System.out.println("showMore 로그 fList : " + fList);
   //   System.out.println("showMore 로그 cList : " + cList);
      
   //   System.out.println("showMore 로그 세팅 완료 svo : " + svo);
      ArrayList<CarVO> dataList = sdao.selectMore(svo);
   //   System.out.println("ajax 응답 값 : "+ dataList);
      
      // 다음에 보여줄 데이터 존재 여부 --> 더보기 버튼 활성화 / 비활성화
      final int moreContent = 12; // 더보기를 클릭할 때마다 보여줄 상품 개수
      boolean showMore = true; // 더보기 버튼 활성화 여부
      // 미리 다음에 보여줄 동일 항목 데이터 개수 계산
      range1 += moreContent; 
      range2 += moreContent;
      svo.setRange1(range1);
      svo.setRange2(range2);
      ArrayList<CarVO> nextDataList = sdao.selectMore(svo);
      // 더 보여줄 데이터가 없다면 --> 더보기 버튼 비활성화
      if(nextDataList.size() == 0) {
         showMore = false;
      }
   
      // ajax 응답 데이터
      JSONObject obj = new JSONObject();
      JSONArray jArray = new JSONArray();
      try {
         for(int i = 0; i < dataList.size(); i++) {
            JSONObject sObject = new JSONObject();
            sObject.put("cimg", dataList.get(i).getCimg());
            sObject.put("ctitle", dataList.get(i).getCtitle());
            sObject.put("ckm", dataList.get(i).getCkm());
            sObject.put("cprice", dataList.get(i).getCprice());
            sObject.put("cnum", dataList.get(i).getCnum());
            sObject.put("cyear", dataList.get(i).getCyear());
            sObject.put("cfuel", dataList.get(i).getCfuel());
            sObject.put("ccity", dataList.get(i).getCcity());
            sObject.put("csubtitle", dataList.get(i).getCsubtitle());
            jArray.add(sObject);
         }
         obj.put("dataList", jArray); // 더 보여줄 상품
         obj.put("showMore", showMore); // 더보기 활성화 여부
      } catch (Exception e) {
         e.printStackTrace();
      }

      response.setContentType("application/x-json; charset=UTF-8");
      response.getWriter().write(obj+"");
      
   }



   /**
    * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // TODO Auto-generated method stub
      doGet(request, response);
   }

}