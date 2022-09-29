package search;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Util.JDBCUtil;
import car.CarVO;

public class SearchDAO {
   Connection conn;   // DB연결 객체 선언
   PreparedStatement pstmt;   // SQL문 수행할 PreparedStatement 객체 선언
   //메서드를 하나만 사용할 예정이므로 각 조건에 따라 들어갈 sql문의 초기값 설정
   String CfuelSql = "";
   String CcitySql = "";
   String CyearSql = "";
   String CkmSql = "";
   String CpriceSql = "";
   String sql_selectAll = "";
   String Check="";
   //   String sql_selectAll = "SELECT A.* FROM (SELECT * FROM CAR WHERE 1=1" + CfuelSql + " " + CcitySql+ " " +CyearSql + " " + CkmSql + " " + CpriceSql + ") A";

   public ArrayList<CarVO> selectAll(SearchVO svo){ //데이터는 CarVO로부터 받아올 예정이기 때문에 제네릭을 CarVO로 설정
      //필터에 사용될 데이터는 SearchVO에서 사용할 것이므로 인자로 두었음

      ArrayList<CarVO> dataList=new ArrayList<CarVO>(); //반환할 배열 데이터를 담을 dataList 배열객체 생성
      conn=JDBCUtil.connect();

      try {
         //   pstmt=conn.prepareStatement(sql_selectAll); //맨 아래에 위치함
         //         System.out.println("DAO 로그 fuel 통과 시작 : fuel" + svo.getFuelList());

         if(svo.getFuelList().size() > 0 && !svo.getFuelList().contains("전체")){ //연료의 필터 값을 저장한 배열객체의 길이가 1 이상일 때
            //System.out.println("DAO 로그 fuel 통과 중 : fuel" + svo.getFuelList());

            StringBuilder cfuelSb = new StringBuilder(); // append 메서드를 사용하기 위해 StringBuilder을 통해 객체 생성
            ArrayList<String> fuelData  = svo.getFuelList(); //fuelData 배열객체에 필터값을 저장한 값 삽입

            for(int i = 0; i < svo.getFuelList().size() ; i++){ //필터 배열의 길이만큼 반복진행 ex)검색할 필터가 전기, 가솔린 등 
               cfuelSb.append("\'" + fuelData.get(i)+ "\'"); //cfuelSB객체에 'index[i]번쨰의 필터배열값' 뒤에 붙여줌
               if(i+1 < svo.getFuelList().size())   //만약 필터 배열의 길이가 i+1보다 크다면
                  cfuelSb.append(",");  // 중간에 ','를 붙여줌

               System.out.println("DAO 로그 cfuelSb append " + cfuelSb.toString());
            }
            //cfuelSql 객체 = AND CFUEL IN ('for문을 통해 나온 필터배열값')
            CfuelSql = "AND CFUEL IN ("+cfuelSb.toString()+")";
         }
         if(svo.getCityList().size() > 0 && !svo.getCityList().contains("전체")){ //지역의 필터 값을 저장한 배열객체의 길이가 1 이상일 때
            StringBuilder ccitySb = new StringBuilder();
            ArrayList<String> citydata  = svo.getCityList();

            for(int i = 0; i < svo.getCityList().size() ; i++){
               ccitySb.append("\'" + citydata.get(i) + "\'");
               if(i+1 < svo.getCityList().size())
                  ccitySb.append(","); 
            }
            CcitySql = "AND CCITY IN ("+ccitySb.toString()+")";
         }
         if(svo.getPrice_min() >= 0){ //SearchVO로부터 불러온 price_min의 값이 0보다 크거나 같다면
            //CpriceSql = AND CPRICE BETWEEN '범위의 최소값' AND '범위의 최대값'
            CpriceSql = "AND CPRICE BETWEEN " + svo.getPrice_min() + " AND " + svo.getPrice_max();
         }
         if(svo.getKm_min() >= 0){
            CkmSql = "AND CKM BETWEEN " + svo.getKm_min() + " AND " + svo.getKm_max();
         }
         if(svo.getYear_min() >= 0){
            CyearSql = "AND CYEAR BETWEEN " + svo.getYear_min() + " AND " + svo.getYear_max();
         }
         if(svo.getChecksort() != null) { //값이 참이라면
            String element = "";
            if(svo.getChecksort().equals("최신순")) {
               element = "ROWNUM";
            }
            if(svo.getChecksort().equals("제목순정렬")) {
               element = "CTITLE";
            }
            if(svo.getChecksort().equals("가격순정렬")) {
               element = "CPRICE";
            }
            if(svo.getChecksort().equals("주행거리순")) {
               element = "CKM";
            }
            System.out.println("DAO 로그 element값 : "+element);
            Check = "ORDER BY "+element+" ASC";
         }
         //         if(만약 값이 참이거나 1이라면~) {
         //            range2 += 12;
         //         }
         //sql문을 상단에 위치할 경우 조건에 따른 sql문들이 삽입되었을 때 sql문 자체가 변경된 것이 아니기 때문에
         //메서드를 사용했을 때 원하는 데이터 값을 받을 수 없음.
         sql_selectAll = "SELECT * FROM (SELECT B.*, ROWNUM AS R FROM (SELECT A.* FROM (SELECT * FROM CAR WHERE 1=1 "
               + CfuelSql + " " + CcitySql+ " " +CyearSql + " " + CkmSql + " " + CpriceSql + ") A "+Check+") B) WHERE R BETWEEN "+svo.getRange1()+ " AND "+svo.getRange2();
         pstmt=conn.prepareStatement(sql_selectAll);
         ResultSet rs = pstmt.executeQuery();
         while(rs.next()) {
            CarVO cvo = new CarVO();
            cvo.setCfuel(rs.getString("CFUEL"));
            cvo.setCtitle(rs.getString("CTITLE"));
            cvo.setCprice(rs.getInt("CPRICE"));
            cvo.setCkm(rs.getInt("CKM"));
            cvo.setCcity(rs.getString("CCITY"));
            cvo.setCimg(rs.getString("CIMG"));
            cvo.setCyear(rs.getInt("CYEAR"));
            dataList.add(cvo);
         }
      }catch (Exception e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      } finally {
         System.out.println("DAO 로그 전부 다 통과 selectAll : " + sql_selectAll);
         JDBCUtil.disconnect(pstmt, conn);
      }      
      return dataList;
   }
   public ArrayList<CarVO> selectMore(SearchVO svo){ //데이터는 CarVO로부터 받아올 예정이기 때문에 제네릭을 CarVO로 설정
       //필터에 사용될 데이터는 SearchVO에서 사용할 것이므로 인자로 두었음
       
    //   System.out.println("SearchDAO 로그  svo : " + svo);
       
       ArrayList<CarVO> dataList=new ArrayList<CarVO>(); //반환할 배열 데이터를 담을 dataList 배열객체 생성
       conn=JDBCUtil.connect();
       
       try {
       //   pstmt=conn.prepareStatement(sql_selectAll); //맨 아래에 위치함
          System.out.println("DAO 로그 fuel 통과 시작 fuel : " + svo.getFuelList());
          if(svo.getFuelList().size() > 0 && !svo.getFuelList().contains("전체")){ //연료의 필터 값을 저장한 배열객체의 길이가 1 이상일 때
             System.out.println("DAO 로그 fuel 통과 중 fuel : " + svo.getFuelList());
             
             StringBuilder cfuelSb = new StringBuilder(); // append 메서드를 사용하기 위해 StringBuilder을 통해 객체 생성
             ArrayList<String> fuelData  = svo.getFuelList(); //fuelData 배열객체에 필터값을 저장한 값 삽입

             for(int i = 0; i < svo.getFuelList().size() ; i++){ //필터 배열의 길이만큼 반복진행 ex)검색할 필터가 전기, 가솔린 등 
                cfuelSb.append("\'" + fuelData.get(i)+ "\'"); //cfuelSB객체에 'index[i]번쨰의 필터배열값' 뒤에 붙여줌
                if(i+1 < svo.getFuelList().size())   //만약 필터 배열의 길이가 i+1보다 크다면
                   cfuelSb.append(",");  // 중간에 ','를 붙여줌
                
                System.out.println("DAO 로그 cfuelSb append " + cfuelSb.toString());
             }
             //cfuelSql 객체 = AND CFUEL IN ('for문을 통해 나온 필터배열값')
             CfuelSql = "AND CFUEL IN ("+cfuelSb.toString()+")";
          }
          if(svo.getCityList().size() > 0){ //지역의 필터 값을 저장한 배열객체의 길이가 1 이상일 때
             StringBuilder ccitySb = new StringBuilder();
             ArrayList<String> citydata  = svo.getCityList();

             for(int i = 0; i < svo.getCityList().size() ; i++){
                ccitySb.append("\'" + citydata.get(i) + "\'");
                if(i+1 < svo.getCityList().size())
                   ccitySb.append(","); 
             }
             CcitySql = "AND CCITY IN ("+ccitySb.toString()+")";
          }
          if(svo.getPrice_min() >= 0){ //SearchVO로부터 불러온 price_min의 값이 0보다 크거나 같다면
//             CpriceSql = AND CPRICE BETWEEN '범위의 최소값' AND '범위의 최대값'
             CpriceSql = "AND CPRICE BETWEEN " + svo.getPrice_min() + " AND " + svo.getPrice_max();
          }
          if(svo.getKm_min() >= 0){
             CkmSql = "AND CKM BETWEEN " + svo.getKm_min() + " AND " + svo.getKm_max();
          }
          if(svo.getYear_min() >= 0){
             CyearSql = "AND CYEAR BETWEEN " + svo.getYear_min() + " AND " + svo.getYear_max();
          }
          if(svo.getChecksort() != null) { //값이 참이라면
             String element = "";
             if(svo.getChecksort().equals("최신순")) {
                element = "ROWNUM";
             }
             if(svo.getChecksort().equals("제목순정렬")) {
                element = "CTITLE";
             }
             if(svo.getChecksort().equals("가격순정렬")) {
                element = "CPRICE";
             }
             if(svo.getChecksort().equals("주행거리순")) {
                element = "CKM";
             }
             System.out.println("로그 element값 : "+element);
             Check = "ORDER BY "+element+" ASC";
          }
//          if(만약 값이 참이거나 1이라면~) {
//             range2 += 12;
//          }
          //sql문을 상단에 위치할 경우 조건에 따른 sql문들이 삽입되었을 때 sql문 자체가 변경된 것이 아니기 때문에
          //메서드를 사용했을 때 원하는 데이터 값을 받을 수 없음.
          sql_selectAll = "SELECT * FROM (SELECT * FROM (SELECT * FROM (SELECT * FROM CAR WHERE 1=1 "
          + CfuelSql + " " + CcitySql+ " " +CyearSql + " " + CkmSql + " " + CpriceSql + ") "+Check+") ) WHERE ROWNUM BETWEEN "+svo.getRange1()+ " AND "+svo.getRange2();
          pstmt=conn.prepareStatement(sql_selectAll);
          ResultSet rs = pstmt.executeQuery();
          while(rs.next()) {
             CarVO cvo = new CarVO();
             cvo.setCnum(rs.getInt("CNUM"));
             cvo.setCfuel(rs.getString("CFUEL"));
             cvo.setCtitle(rs.getString("CTITLE"));
             cvo.setCprice(rs.getInt("CPRICE"));
             cvo.setCkm(rs.getInt("CKM"));
             cvo.setCcity(rs.getString("CCITY"));
             cvo.setCimg(rs.getString("CIMG"));
             cvo.setCyear(rs.getInt("CYEAR"));
             dataList.add(cvo);
             System.out.println("SearchDAO 로그 검색된 cvo :" + cvo);
          }
          System.out.println("SearchDAO 로그 검색 결과 dataList : " + dataList);
       }catch (Exception e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
       } finally {
          System.out.println("로그 전부 다 통과 selectSome : " + sql_selectAll);
          JDBCUtil.disconnect(pstmt, conn);
       }      
       
       return dataList;
    }
   
   
   
   
}