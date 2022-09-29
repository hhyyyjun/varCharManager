<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="koala"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!-- △위에는 배열의 길이를 사용하기위해 사용 △-->

<!DOCTYPE html>
<html>
<head>
<title>VARCHAR</title>
 <link rel="shortcut icon" href="./images/vc.ico" >
<meta charset="utf-8" />
<meta name="viewport"
   content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<link rel="shortcut icon" href="./images/vc.ico" >
<link
   href="https://fonts.googleapis.com/css?family=Poppins:200,300,400,500,600,700,800&display=swap"
   rel="stylesheet" />

<link rel="stylesheet" href="css/open-iconic-bootstrap.min.css" />
<link rel="stylesheet" href="css/animate.css" />

<link rel="stylesheet" href="css/owl.carousel.min.css" />
<link rel="stylesheet" href="css/owl.theme.default.min.css" />
<link rel="stylesheet" href="css/magnific-popup.css" />

<link rel="stylesheet" href="css/aos.css" />

<link rel="stylesheet" href="css/ionicons.min.css" />

<link rel="stylesheet" href="css/bootstrap-datepicker.css" />
<!--  
      <link rel="stylesheet" href="css/jquery.timepicker.css" />
  -->
<link rel="stylesheet" href="css/flaticon.css" />
<link rel="stylesheet" href="css/icomoon.css" />
<link rel="stylesheet" href="css/style.css" />
<link rel="stylesheet" href="css/filterSearch.css" />
<script src="https://code.jquery.com/jquery-3.6.1.min.js"
   integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ="
   crossorigin="anonymous"></script>
</head>
<body>
   <koala:nav />

   <section class="hero-wrap hero-wrap-2 js-fullheight"
      style="background-image: url('images/bg_3.jpg')"
      data-stellar-background-ratio="0.5">
      <div class="overlay"></div>
      <div class="container">
         <div
            class="row no-gutters slider-text js-fullheight align-items-end justify-content-start">
            <div class="col-md-9 ftco-animate pb-5">
               <p class="breadcrumbs">
                  <span class="mr-2"><a href="main.html">Home <i
                        class="ion-ios-arrow-forward"></i>
                  </a></span> 
               </p>
               <h1 class="mb-3 bread">Choose Your Car</h1>
            </div>
         </div>
      </div>
   </section>

   <section class="ftco-section bg-light">
      <div class="filterOpenner">
         <strong>filter</strong>
      </div>
      <!-- 8.20 김종현 수정(필터 검색란 추가) -->
      <div class="filterContainer">
         <div class="filterCloser">
            <h2 class="filterTitle">Close Filter</h2>
            <!-- <i class="filterMark"></i> -->
         </div>
         <hr />

         <form action="filter.do" method="get">
            <!--상품 정렬-->
            <div class="filterBox hideFilter">
               <div class="filterBoxTitle">
                  <label>상품 정렬</label> <i class="openArrow"><img
                     src="images/down_arrow.png" alt="down arrow" /></i>
               </div>
               <select name="sort" id="sort">
                  <option <c:if test="${sort == '최신순'}">selected='selected'</c:if>>최신순</option>
                  <option <c:if test="${sort == '제목순정렬'}">selected='selected'</c:if>>제목순정렬</option>
                  <option <c:if test="${sort == '가격순정렬'}">selected='selected'</c:if>>가격순정렬</option>
                  <option <c:if test="${sort == '주행거리순'}">selected='selected'</c:if>>주행거리순</option>
               </select>
            </div>
            <hr />
            <!--연식 검색-->
            <div class="filterBox hideFilter">
               <div class="filterBoxTitle">
                  <label>연식</label> <i class="openArrow"><img
                     src="images/down_arrow.png" alt="down arrow" /></i>
               </div>
               <select name="ymin" class="minSelect" id="ymin">
                  <option <c:if test="${ymin == 2000}">selected='selected'</c:if>>2000</option>
                  <option <c:if test="${ymin == 2001}">selected='selected'</c:if>>2001</option>
                  <option <c:if test="${ymin == 2002}">selected='selected'</c:if>>2002</option>
                  <option <c:if test="${ymin == 2003}">selected='selected'</c:if>>2003</option>
                  <option <c:if test="${ymin == 2004}">selected='selected'</c:if>>2004</option>
                  <option <c:if test="${ymin == 2005}">selected='selected'</c:if>>2005</option>
                  <option <c:if test="${ymin == 2006}">selected='selected'</c:if>>2006</option>
                  <option <c:if test="${ymin == 2007}">selected='selected'</c:if>>2007</option>
                  <option <c:if test="${ymin == 2008}">selected='selected'</c:if>>2008</option>
                  <option <c:if test="${ymin == 2009}">selected='selected'</c:if>>2009</option>
                  <option <c:if test="${ymin == 2010}">selected='selected'</c:if>>2010</option>
                  <option <c:if test="${ymin == 2011}">selected='selected'</c:if>>2011</option>
                  <option <c:if test="${ymin == 2012}">selected='selected'</c:if>>2012</option>
                  <option <c:if test="${ymin == 2013}">selected='selected'</c:if>>2013</option>
                  <option <c:if test="${ymin == 2014}">selected='selected'</c:if>>2014</option>
                  <option <c:if test="${ymin == 2015}">selected='selected'</c:if>>2015</option>
                  <option <c:if test="${ymin == 2016}">selected='selected'</c:if>>2016</option>
                  <option <c:if test="${ymin == 2017}">selected='selected'</c:if>>2017</option>
                  <option <c:if test="${ymin == 2018}">selected='selected'</c:if>>2018</option>
                  <option <c:if test="${ymin == 2019}">selected='selected'</c:if>>2019</option>
                  <option <c:if test="${ymin == 2020}">selected='selected'</c:if>>2020</option>
                  <option <c:if test="${ymin == 2021}">selected='selected'</c:if>>2021</option>
                  <option <c:if test="${ymin == 2022}">selected='selected'</c:if>>2022</option>
               </select> <span class="between"> ~</span> <select name="ymax" class="maxSelect" id = "ymax">
                  <option value="2023">전체</option>
                  <option <c:if test="${ymax == 2001}">selected='selected'</c:if>>2001</option>
                  <option <c:if test="${ymax == 2002}">selected='selected'</c:if>>2002</option>
                  <option <c:if test="${ymax == 2003}">selected='selected'</c:if>>2003</option>
                  <option <c:if test="${ymax == 2004}">selected='selected'</c:if>>2004</option>
                  <option <c:if test="${ymax == 2005}">selected='selected'</c:if>>2005</option>
                  <option <c:if test="${ymax == 2006}">selected='selected'</c:if>>2006</option>
                  <option <c:if test="${ymax == 2007}">selected='selected'</c:if>>2007</option>
                  <option <c:if test="${ymax == 2008}">selected='selected'</c:if>>2008</option>
                  <option <c:if test="${ymax == 2009}">selected='selected'</c:if>>2009</option>
                  <option <c:if test="${ymax == 2010}">selected='selected'</c:if>>2010</option>
                  <option <c:if test="${ymax == 2011}">selected='selected'</c:if>>2011</option>
                  <option <c:if test="${ymax == 2012}">selected='selected'</c:if>>2012</option>
                  <option <c:if test="${ymax == 2013}">selected='selected'</c:if>>2013</option>
                  <option <c:if test="${ymax == 2014}">selected='selected'</c:if>>2014</option>
                  <option <c:if test="${ymax == 2015}">selected='selected'</c:if>>2015</option>
                  <option <c:if test="${ymax == 2016}">selected='selected'</c:if>>2016</option>
                  <option <c:if test="${ymax == 2017}">selected='selected'</c:if>>2017</option>
                  <option <c:if test="${ymax == 2018}">selected='selected'</c:if>>2018</option>
                  <option <c:if test="${ymax == 2019}">selected='selected'</c:if>>2019</option>
                  <option <c:if test="${ymax == 2020}">selected='selected'</c:if>>2020</option>
                  <option <c:if test="${ymax == 2021}">selected='selected'</c:if>>2021</option>
                  <option <c:if test="${ymax == 2022}">selected='selected'</c:if>>2022</option>
               </select>
            </div>
            <hr />

            <!-- 연료 검색 -->
            <div class="filterBox hideFilter">
               <div class="filterBoxTitle">
                  <label>연료</label> <i class="openArrow"><img
                     src="images/down_arrow.png" alt="down arrow" /></i>
               </div>

               <ul id="fuelFilter">
                  <li><span> <input type="checkbox" value="전체"
                        name="fuel"
                        <c:if test="${fList.contains('전체')}">checked='checked'</c:if> />
                        <label class="fuel">전체</label>
                  </span></li>
                  <li><span> <input type="checkbox" value="가솔린"
                        name="fuel"
                        <c:if test="${fList.contains('가솔린')}">checked='checked'</c:if> />
                        <label class="fuel">가솔린</label>
                  </span></li>
                  <li><span> <input type="checkbox" value="디젤"
                        name="fuel"
                        <c:if test="${fList.contains('디젤')}">checked='checked'</c:if> />
                        <label class="fuel">디젤</label>
                  </span></li>
                  <li><span> <input type="checkbox" value="전기"
                        name="fuel"
                        <c:if test="${fList.contains('전기')}">checked='checked'</c:if> />
                        <label class="fuel">전기</label>
                  </span></li>
               </ul>
            </div>
            <hr />
            <!--주행거리 검색-->
            <div class="filterBox hideFilter">
               <div class="filterBoxTitle">
                  <label>주행거리</label> <i class="openArrow"><img
                     src="images/down_arrow.png" alt="down arrow" /></i>
               </div>

               <!--   <select name="">
              <option selected>하한</option>
              <option>1</option>
              <option>2</option>
            </select>
            <span class="between"> ~</span>
            <select name="">
              <option selected>상한</option>
              <option>1</option>
              <option>2</option>
            </select> -->

               <div class="slideContainer">
                  <div>
                     <div class="col-sm-12">
                        <div id="slider-range"></div>
                     </div>
                  </div>
                  <div class="slider-labels">
                     <div>
                        <strong>최소 :&nbsp;&nbsp;</strong> <span id="slider-range-value1"></span>&nbsp;&nbsp;km
                     </div>
                     <div>
                        <strong>최대 :&nbsp;&nbsp;</strong> <span id="slider-range-value2"></span>&nbsp;&nbsp;km
                     </div>
                  </div>
                  <div>
                     <div class="col-sm-12">
                        <input type="hidden" name="min-value" value="" /> <input
                           type="hidden" name="max-value" value="" />
                     </div>
                  </div>
               </div>
            </div>
            <hr />
            <!--가격 검색-->
            <div class="filterBox hideFilter">
               <div class="filterBoxTitle">
                  <label>가격</label> <i class="openArrow"><img
                     src="images/down_arrow.png" alt="down arrow" /></i>
               </div>
	
               <select name="pmin" class="minSelect" id = "pmin">
                  <option <c:if test="${pmin == 0}">selected='selected'</c:if>>0</option>
                  <option <c:if test="${pmin == 1000}">selected='selected'</c:if>>1000</option>
                  <option <c:if test="${pmin == 2000}">selected='selected'</c:if>>2000</option>
                  <option <c:if test="${pmin == 3000}">selected='selected'</c:if>>3000</option>
                  <option <c:if test="${pmin == 4000}">selected='selected'</c:if>>4000</option>
                  <option <c:if test="${pmin == 5000}">selected='selected'</c:if>>5000</option>
                  <option <c:if test="${pmin == 6000}">selected='selected'</c:if>>6000</option>
                  <option <c:if test="${pmin == 7000}">selected='selected'</c:if>>7000</option>
                  <option <c:if test="${pmin == 8000}">selected='selected'</c:if>>8000</option>
                  <option <c:if test="${pmin == 9000}">selected='selected'</c:if>>9000</option>
                  <option <c:if test="${pmin == 10000}">selected='selected'</c:if>>10000</option>
                  <option <c:if test="${pmin == 11000}">selected='selected'</c:if>>11000</option>
                  <option <c:if test="${pmin == 12000}">selected='selected'</c:if>>12000</option>
                  <option <c:if test="${pmin == 13000}">selected='selected'</c:if>>13000</option>
                  <option <c:if test="${pmin == 14000}">selected='selected'</c:if>>14000</option>
                  <option <c:if test="${pmin == 15000}">selected='selected'</c:if>>15000</option>
               </select> <span class="between"> ~</span> <select name="pmax" class="maxSelect" id = "pmax">
                  <option value="2147483647">전체</option>
                  <option <c:if test="${pmax == 1000}">selected='selected'</c:if>>1000</option>
                  <option <c:if test="${pmax == 2000}">selected='selected'</c:if>>2000</option>
                  <option <c:if test="${pmax == 3000}">selected='selected'</c:if>>3000</option>
                  <option <c:if test="${pmax == 4000}">selected='selected'</c:if>>4000</option>
                  <option <c:if test="${pmax == 5000}">selected='selected'</c:if>>5000</option>
                  <option <c:if test="${pmax == 6000}">selected='selected'</c:if>>6000</option>
                  <option <c:if test="${pmax == 7000}">selected='selected'</c:if>>7000</option>
                  <option <c:if test="${pmax == 8000}">selected='selected'</c:if>>8000</option>
                  <option <c:if test="${pmax == 9000}">selected='selected'</c:if>>9000</option>
                  <option <c:if test="${pmax == 10000}">selected='selected'</c:if>>10000</option>
                  <option <c:if test="${pmax == 11000}">selected='selected'</c:if>>11000</option>
                  <option <c:if test="${pmax == 12000}">selected='selected'</c:if>>12000</option>
                  <option <c:if test="${pmax == 13000}">selected='selected'</c:if>>13000</option>
                  <option <c:if test="${pmax == 14000}">selected='selected'</c:if>>14000</option>
                  <option <c:if test="${pmax == 15000}">selected='selected'</c:if>>15000</option>
               </select>
            </div>
            <hr />
            <!-- 지역 검색 -->
            <div class="filterBox hideFilter">
               <div class="filterBoxTitle">
                  <label>지역</label> <i class="openArrow"><img
                     src="images/down_arrow.png" alt="down arrow" /></i>
               </div>

               <ul id="regionFilter">
                  <li><span> <input type="checkbox" value="전체"
                        name="city"
                        <c:if test="${cList.contains('전체')}">checked='checked'</c:if> />
                        <label class="region">전체</label>
                  </span></li>
                  <li><span> <input type="checkbox" value="서울"
                        name="city"
                        <c:if test="${cList.contains('서울')}">checked='checked'</c:if> />
                        <label class="region">서울</label>
                  </span></li>
                  <li><span> <input type="checkbox" value="경기"
                        name="city"
                        <c:if test="${cList.contains('경기')}">checked='checked'</c:if> />
                        <label class="region">경기</label>
                  </span></li>
                  <li><span> <input type="checkbox" value="인천"
                        name="city"
                        <c:if test="${cList.contains('인천')}">checked='checked'</c:if> />
                        <label class="region">인천</label>
                  </span></li>
                  <li><span> <input type="checkbox" value="강원"
                        name="city"
                        <c:if test="${cList.contains('강원')}">checked='checked'</c:if> />
                        <label class="region">강원</label>
                  </span></li>
                  <li><span> <input type="checkbox" value="충북"
                        name="city"
                        <c:if test="${cList.contains('충북')}">checked='checked'</c:if> />
                        <label class="region">충북</label>
                  </span></li>
                  <li><span> <input type="checkbox" value="충남"
                        name="city"
                        <c:if test="${cList.contains('충남')}">checked='checked'</c:if> />
                        <label class="region">충남</label>
                  </span></li>
                  <li><span> <input type="checkbox" value="대전"
                        name="city"
                        <c:if test="${cList.contains('대전')}">checked='checked'</c:if> />
                        <label class="region">대전</label>
                  </span></li>
                  <li><span> <input type="checkbox" value="세종"
                        name="city"
                        <c:if test="${cList.contains('세종')}">checked='checked'</c:if> />
                        <label class="region">세종</label>
                  </span></li>
                  <li><span> <input type="checkbox" value="경북"
                        name="city"
                        <c:if test="${cList.contains('경북')}">checked='checked'</c:if> />
                        <label class="region">경북</label>
                  </span></li>
                  <li><span> <input type="checkbox" value="경남"
                        name="city"
                        <c:if test="${cList.contains('경남')}">checked='checked'</c:if> />
                        <label class="region">경남</label>
                  </span></li>
                  <li><span> <input type="checkbox" value="대구"
                        name="city"
                        <c:if test="${cList.contains('대구')}">checked='checked'</c:if> />
                        <label class="region">대구</label>
                  </span></li>
                  <li><span> <input type="checkbox" value="부산"
                        name="city"
                        <c:if test="${cList.contains('부산')}">checked='checked'</c:if> />
                        <label class="region">부산</label>
                  </span></li>
                  <li><span> <input type="checkbox" value="울산"
                        name="city"
                        <c:if test="${cList.contains('울산')}">checked='checked'</c:if> />
                        <label class="region">울산</label>
                  </span></li>
                  <li><span> <input type="checkbox" value="전북"
                        name="city"
                        <c:if test="${cList.contains('전북')}">checked='checked'</c:if> />
                        <label class="region">전북</label>
                  </span></li>
                  <li><span> <input type="checkbox" value="전남"
                        name="city"
                        <c:if test="${cList.contains('전남')}">checked='checked'</c:if> />
                        <label class="region">전남</label>
                  </span></li>
                  <li><span> <input type="checkbox" value="광주"
                        name="city"
                        <c:if test="${cList.contains('광주')}">checked='checked'</c:if> />
                        <label class="region">광주</label>
                  </span></li>
                  <li><span> <input type="checkbox" value="제주"
                        name="city"
                        <c:if test="${cList.contains('제주')}">checked='checked'</c:if> />
                        <label class="region">제주</label>
                  </span></li>
               </ul>
            </div>
            <hr />
            <!-- 검색 / 초기화 버튼 -->
            <button id="submitClick" type="submit" class="filterBtn">상세조건
               검색</button>
            <button type="button" class="intializeBtn">초기화</button>
         </form>
      </div>

      <!-- 찜 목록---------------------------------- -->
      <koala:zzim />

      <!---------------------------------- -->

      <div class="container">
         
            <!-- 차 목록 -->


         <div class="row" id = "viewItems">
     <c:if test="${fn:length(datas) == 0}">
      <div id="noItems">
         <p>검색된 상품이 없습니다.</p>
         <div id="noItemsBtn">
            <button id="viewAllItems" type="button" onclick="location.href='filter.do';">전체검색</button>
            <button id="goToMain" type="button" onclick="location.href='main.do';">메인으로</button>   
         </div>         
      </div>
   </c:if>
   
   <c:if test="${fn:length(datas) > 0}">
         <c:forEach var="c" items="${datas}">

   
          <div class="col-md-4">
            <div class="car-wrap rounded ftco-animate">
            <!-- 이미지 -->
              <div
                class="img rounded d-flex align-items-end"
              >
              <img style="width:100%;height:100%;" alt="크롤링한 페이지" src="${c.cimg}"/>
             </div>
             <!-- 제목 -->
              <div class="text">
                <h2 class="mb-0">
                  <a href="detail.do">${c.ctitle}</a>
                </h2>
                <!-- 키로수 -->
                <div class="d-flex mb-3">
                  <span class="cat">${c.ckm} km</span>
                  <!-- 가격 인트 의 최댓값일때 == 상담 예약으로 변경-->
                  <c:choose>
                     <c:when test="${c.cprice==2147483647}">
                        <p class="price ml-auto">상담예약</p>
                     </c:when>
                     <c:otherwise>
                        <p class="price ml-auto">${c.cprice}<span>만원</span></p>
                     </c:otherwise>
                     
                  </c:choose>
                  
                </div>
                <p class="d-flex mb-0 d-block">
                  <a href="storeAdd.do?cnum=${c.cnum}" class="btn btn-primary py-2 mr-1">예약 하기</a>
                  <a href="detail.do?cnum=${c.cnum}" class="btn btn-secondary py-2 ml-1">자세한 정보</a>
                </p>
               
              </div>
            </div>
          </div>
   </c:forEach>
   </c:if>
          
  </div>

            <!-- ============== -->
 

         


         <div class="row mt-5">
            <div class="col text-center">
               <!-- <div class="block-27"> -->
                  <!-- 
              <ul>
                <li><a href="#">&lt;</a></li>
            <c:forEach var="i" begin="1" end="${(fn:length(cdatas)/12)+1}">
               <li><a href="#">${i}</a></li>            
            </c:forEach>
                <li class="active"><span>1</span></li>
                <li><a href="#">2</a></li>
                <li><a href="#">3</a></li>
                <li><a href="#">4</a></li>
                <li><a href="#">5</a></li>
                <li><a href="#">&gt;</a></li>
                
              </ul>
                 -->
              <!--   </div>-->
               <!--  원본
                <button id="viewMore" type="button" class="moreContent">view more</button>
               
               -->

                <p id = "totalAmount">  총 ${fn:length(datas)} 개의 상품을 보고 있습니다</p>
           		<c:if test="${fn:length(datas) >= 12}">
           			<button class = "moreContent">view more</button>
           		</c:if>
            </div>
         </div>
      </div>
   </section>

   <koala:fotter />

   <!-- loader -->
   <div id="ftco-loader" class="show fullscreen">
      <svg class="circular" width="48px" height="48px">
        <circle class="path-bg" cx="24" cy="24" r="22" fill="none"
            stroke-width="4" stroke="#eeeeee" />
        <circle class="path" cx="24" cy="24" r="22" fill="none"
            stroke-width="4" stroke-miterlimit="10" stroke="#F96D00" />
      </svg>
   </div>

   <script src="js/jquery.min.js"></script>
   <script src="js/jquery-migrate-3.0.1.min.js"></script>
   <script src="js/popper.min.js"></script>
   <script src="js/bootstrap.min.js"></script>
   <script src="js/jquery.easing.1.3.js"></script>
   <script src="js/jquery.waypoints.min.js"></script>
   <script src="js/jquery.stellar.min.js"></script>
   <script src="js/owl.carousel.min.js"></script>
   <script src="js/jquery.magnific-popup.min.js"></script>
   <script src="js/aos.js"></script>
   <script src="js/jquery.animateNumber.min.js"></script>
   <script src="js/bootstrap-datepicker.js"></script>
   <script src="js/jquery.timepicker.min.js"></script>
   <script src="js/scrollax.min.js"></script>
   <script
      src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBVWaKrjvy3MaE7SQ74_uJiULgl1JY0H2s&sensor=false"></script>
   <script src="js/google-map.js"></script>
   <script src="js/main.js"></script>
   <script src="js/filterOpenner.js"></script>
   <script src="js/cartOpenner.js"></script>
   <script id="Slider" kmin="${kmin}" kmax="${kmax}"
      src="js/rangeSlider.js"></script>
   <script src="js/selectOption.js"></script>
   <script src="js/clickCheckbox.js"></script>
   <script src="js/initializeFilter.js"></script>
	<script>
      // 보여줄 상품 범위(range1 ~ range2)
      let range1 = 1; 
      let range2 = 12;
      // 페이지 출력 상품 개수
      let contentAmount = 12;
      // 더 보여줄 상품 개수
      const moreContent = 12;
                     // 더보기 버튼 클릭 --> 상품 더보기
                     document.querySelector(".moreContent").onclick = () => {
                     //   console.log("ajax 시작");
                        range1 += moreContent;
                        range2 += moreContent;
                     //   console.log("range1 = "+range1+"/ range2 = "+range2);
                     
                     //  json 데이터 setting
                        const cityCheckbox = document.querySelectorAll("input[name='city']");
                        const fuelCheckbox = document
                              .querySelectorAll("input[name='fuel']");
                        let cityList = [];
                        let fuelList = [];
                        // 지역 setting
                        for (let i = 0; i < cityCheckbox.length; i++) {
                           if (cityCheckbox[i].checked) {
                              cityList.push(cityCheckbox[i].value);
                           }
                        }
                     //   console.log(cityList);
                        // 연료 setting
                        for (let i = 0; i < fuelCheckbox.length; i++) {
                           if (fuelCheckbox[i].checked) {
                              fuelList.push(fuelCheckbox[i].value);
                           }
                        }
                     //   console.log(fuelList);
                        // 정렬 setting
                        const sortSelect = document.getElementById("sort");
                        const sort = sortSelect.children[sortSelect.selectedIndex].value;
                     //   console.log("sort : " + sort);
                        
                        // 가격 setting
                        const pminSelect = document.getElementById("pmin");
                        const pmin = pminSelect.children[pminSelect.selectedIndex].value;
                     //   console.log("pmin : " + pmin);
                        const pmaxSelect = document.getElementById("pmax");
                        const pmax = pmaxSelect.children[pmaxSelect.selectedIndex].value;
                     //   console.log("pmin : " + pmax);

                        // 연식 setting
                        const yminSelect = document.getElementById("ymin");
                        const ymin = yminSelect.children[yminSelect.selectedIndex].value;
                     //   console.log("ymin : " + ymin);
                        const ymaxSelect = document.getElementById("ymax");
                        const ymax = ymaxSelect.children[ymaxSelect.selectedIndex].value;
                     //   console.log("ymax : " + ymax);
                        
                        // 주행거리 setting
                        const kmin = document
                              .querySelector("input[name='min-value']").value;
                     //   console.log("kmin : " + kmin);
                        const kmax = document
                              .querySelector("input[name='max-value']").value;
                     //   console.log("kmax : " + kmax);

                        
                              $.ajax({
                                 type : 'GET',
                                 url : '${pageContext.request.contextPath}/showMore.do', 
                                 data : {
                                    cityList : JSON.stringify(cityList),
                                    fuelList : JSON.stringify(fuelList),
                                    sort : sort,
                                    pmin : pmin,
                                    pmax : pmax,
                                    ymin : ymin,
                                    ymax : ymax,
                                    kmin : kmin,
                                    kmax : kmax,
                                    range1 : range1,
                                    range2 : range2,
                                 },
                                 success : function(result) {
                                    // dataList : 더 보여줄 상품 / result : 더보기 버튼 hiding 여부
                                 //   console.log("로그 : ajax 결과 [" + result.dataList + "]");
                                 //   console.log("로그 : showMore : " + result.showMore);
                                 //   console.log(typeof result.showMore);
                                    if (result.dataList.length == 0 ) {
                                    //   console.log("ajax로그 : 더 보여줄 결과 없음");
                                       return;
                                    } else {

                                       // 총 N개의 상품을 보고 있습니다.
                                       contentAmount += result.dataList.length;
                                       $("#totalAmount").text("총 " + contentAmount + "개의 상품을 보고 있습니다");
                                    //   $("#totalAmount").css("font-weight", "600");
                                    //   $("#totalAmount").css("color", "#000");
                                    //   console.log("ajax로그 : 더 보여줄 결과 존재");
                                       let NodeList = "";
                              $(result.dataList).each(function() {
                                 let newNode = "";
                                 newNode += "<div class='col-md-4'>";
                                 newNode += "<div class='car-wrap rounded'>";
                                 newNode += "<div class='img rounded d-flex align-items-end'>";
                                 newNode += "<img style='width:100%;height:100%;' alt='크롤링한 페이지' src=" + this.cimg + " >"; 
                                 newNode += "</div>";
                                 newNode += "<div class='text'>";
                                 newNode += "<h2 class='mb-0'>";
                                 newNode += "<a href='detail.html'>" + this.ctitle + "</a>";
                                 newNode += "</h2>";
                                 newNode += "<div class='d-flex mb-3'>";
                                 newNode += "<span class='cat'>" + this.ckm + " km</span>";
                                 
                                 // 상담예약 상품의 가격 저장은 2147483647
                                 cprice = this.cprice == 2147483647 ? "상담예약" : this.cprice + "<span>만원</span>";
                                 newNode += "<p class='price ml-auto'>" + cprice + "</p>";
                                 
                                 newNode += "</div>";
                                 newNode += "<p class='d-flex mb-0 d-block'>";
                                 newNode += "<a href='storeAdd.do?cnum=" + this.cnum + "' class='btn btn-primary py-2 mr-1'>예약 하기</a>";
                                 newNode += "<a href='detail.do?cnum=" + this.cnum + "' class='btn btn-secondary py-2 ml-1' >자세한 정보</a>";
                                 newNode += "</p>";
                                 newNode += "</div>";
                                 newNode += "</div>";
                                 newNode += "</div>";
                                 NodeList += newNode;
                                       })
                                       $(NodeList).appendTo($("#viewItems")); // 상품 내용 추가할 html 영역
                                    if(!result.showMore) { // 상품 모두 출력 -> 더보기 버튼 XX
                                       document.querySelector(".moreContent").style.display = "none";
                                    }
                                 }
                              },
                              error : function(request, status,
                                    error) {
                                 console.log("상태코드 : "
                                       + request.status);
                                 console.log("오류메세지 : "
                                       + request.responseText);
                                 console.log("에러 : " + error);
                              }
                           });
                     };
                  
   </script>
</body>
</html>