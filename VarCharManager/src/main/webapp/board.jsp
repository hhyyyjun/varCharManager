<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
   <%@taglib tagdir="/WEB-INF/tags" prefix="koala"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<title>VARCHAR</title>
 <link rel="shortcut icon" href="./images/vc.ico" >
<meta charset="utf-8" />
<meta name="viewport"
   content="width=device-width, initial-scale=1, shrink-to-fit=no" />

<link
   href="https://fonts.googleapis.com/css?family=Poppins:200,300,400,500,600,700,800&display=swap"
   rel="stylesheet" />

<link rel="stylesheet" href="css/open-iconic-bootstrap.min.css" />
<link rel="stylesheet" href="css/animate.css" />

<link rel="stylesheet" href="css/owl.carousel.min.css" />
<link rel="stylesheet" href="css/owl.theme.default.min.css" />
<link rel="stylesheet" href="css/magnific-popup.css" />

<link rel="stylesheet" href="css/aos.css" />
<link rel="stylesheet" href="css/map.css" />
<link rel="stylesheet" href="css/ionicons.min.css" />

<link rel="stylesheet" href="css/bootstrap-datepicker.css" />
<link rel="stylesheet" href="css/jquery.timepicker.css" />

<link rel="stylesheet" href="css/flaticon.css" />
<link rel="stylesheet" href="css/icomoon.css" />
<link rel="stylesheet" href="css/style.css" />
<link rel="stylesheet" href="css/board.css" />


<script src="https://code.jquery.com/jquery-3.6.0.min.js"
   integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
   crossorigin="anonymous"></script>
</head>
<body>
   <!-- <nav
      class="navbar navbar-expand-lg navbar-dark ftco_navbar bg-dark ftco-navbar-light"
      id="ftco-navbar">
      <div class="container">
         <a class="navbar-brand" href="main.jsp">VAR<span>CHAR</span></a>
         <button class="navbar-toggler" type="button" data-toggle="collapse"
            data-target="#ftco-nav" aria-controls="ftco-nav"
            aria-expanded="false" aria-label="Toggle navigation">
            <span class="oi oi-menu"></span> Menu
         </button>

         <div class="collapse navbar-collapse" id="ftco-nav">
            <ul class="navbar-nav ml-auto">
               <li class="nav-item active"><a href="main.jsp"
                  class="nav-link">메인 화면</a></li>
               <li class="nav-item"><a href="login.jsp" class="nav-link">로그인</a>
               </li>
               <li class="nav-item"><a href="signup.jsp" class="nav-link">회원가입</a>
               </li>
               <li class="nav-item"><a href="board.jsp" class="nav-link">문의게시판</a>
               </li>
               <li class="nav-item"><a href="filter.do" class="nav-link">상세
                     보기</a></li>
            </ul>
         </div>
      </div>
   </nav> -->
   <!-- END nav -->
<koala:nav/>


   <section class="hero-wrap hero-wrap-2 js-fullheight"
      style="background-image: url('images/bg_3.jpg')"
      data-stellar-background-ratio="0.5">
      <div class="overlay"></div>
      <div class="container">
         <div
            class="row no-gutters slider-text js-fullheight align-items-end justify-content-start">
            <div class="col-md-9 ftco-animate pb-5">
               <p class="breadcrumbs">
                  <span class="mr-2"><a href="index.html">Home <i
                        class="ion-ios-arrow-forward"></i>
                  </a></span>
               </p>
               <h1 class="mb-3 bread">Q & A</h1>
            </div>
         </div>
      </div>
   </section>

   <section class="ftco-section contact-section">
      <div class="container">
         <div class="row d-flex mb-5 contact-info">
            <div class="col-md-4">
               <div class="row mb-5">
                  <div class="col-md-12">
                     <div class="border w-100 p-4 rounded mb-2 d-flex">
                        <div class="icon mr-3">
                           <span class="icon-map-o"></span>
                        </div>
                        <p>
                           <span>Address:</span>서울특별시 강남구 역삼동 736-7 
                        </p>
                     </div>
                  </div>
                  <div class="col-md-12">
                     <div class="border w-100 p-4 rounded mb-2 d-flex">
                        <div class="icon mr-3">
                           <span class="icon-mobile-phone"></span>
                        </div>
                        <p>
                           <span>Phone:</span> <a href="tel://1234567920">02-1234-1234</a>
                        </p>
                     </div>
                  </div>
                  <div class="col-md-12">
                     <div class="border w-100 p-4 rounded mb-2 d-flex">
                        <div class="icon mr-3">
                           <span class="icon-envelope-o"></span>
                        </div>
                        <p>
                           <span>Email:</span> <a href="mailto:info@yoursite.com">sudal1234@koala.com</a>
                        </p>
                     </div>
                  </div>
               </div>
            </div>
            <div class="col-md-8 block-9 mb-md-5">


               <c:if test="${userId!=null}">
                  <form action="insertB.do" class="bg-light p-5 contact-form">
                     <!-- <div class="form-group">
                <input type="text" class="form-control" placeholder="작성자" />
              </div> -->

                     <div class="form-group">
                        <input name="mid" type="text" class="form-control"
                           value="${userId}" readonly />
                     </div>
                     <div class="form-group">
                        <input name="btitle" type="text" class="form-control"
                           placeholder="제목" autocomplete="off"  required/>
                     </div>
                     <div class="form-group">
                        <textarea name="bcontent" id="" cols="30" rows="7"
                           class="form-control" placeholder="게시글을 작성해보세요!" autocomplete="off" required></textarea>
                     </div>
                     <div class="form-group insertBoardBtn">
                        <c:set var="bd" value="${bdata}" />
                        <input type="hidden" name="mnickname" value="${bd.mnickname}" />
                        <input type="submit" value="게시글 작성"
                           class="btn btn-primary py-3 px-5" />
                     </div>
                  </form>
               </c:if>

               <c:if test="${userId==null}">
                  <form action="login.jsp" class="bg-light p-5 contact-form">
                     <!-- <div class="form-group">
                <input type="text" class="form-control" placeholder="작성자" />
              </div> -->


                     <div class="form-group">
                        <input name="mid" type="text" class="form-control"
                           placeholder="비로그인" readonly />
                     </div>
                     <div class="form-group">
                        <input name="btitle" type="text" class="form-control"
                           placeholder="제목" readonly />
                     </div>
                     <div class="form-group">
                        <textarea name="bcontent" id="" cols="30" rows="7"
                           class="form-control" placeholder="게시글을 작성하시려면 로그인하세요!" readonly></textarea>
                     </div>
                     <div class="form-group insertBoardBtn">
                        <input type="submit" value="로그인하기"
                           class="btn btn-primary py-3 px-5" />
                     </div>
                  </form>
               </c:if>
            </div>
         </div>
         <!-- 게시글 메뉴 -->
         <div class="boardMenu">
            <div class="searchBox">
               <form action="searchR.do" method="GET">
                  <!-- <select name="">
                <option selected value="">제목</option>
                <option value="">작성자</option>
              </select> -->
                  <label>제목</label> <input type="text" name="btitle"
                     autocomplete="off" /> <input type="submit" value="검색" />
               </form>
            </div>

            <ul class="menuBox">
               <c:forEach var="b" items="${bList}" varStatus="status">
                  <c:set var="c" value="${b.boardVO}" />
                  <li><a href="#menu+${status.count}">${c.btitle}</a><koala:delete type="content" bnum="${c.bnum}"/>
                     &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span class="boardInfo">(${c.mid}님,&nbsp;&nbsp;&nbsp;${c.bdate})</span><i
                     class="openArrow"><img src="images/down_arrow.png" /></i>
                     <ul>
                        <li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${c.bcontent}</li>
                        <li>
                        <c:forEach var="r" items="${b.rList}">
                           <hr>
                           <li class="reply">[${r.mid}]&nbsp;&nbsp;<koala:delete type="reply" rid="${r.rid}"/><br> ${r.cmsg}
                           </li>
                        </c:forEach>
                        </li>
                     </ul>
                  <!-- <ul class="menuReply">
                     <c:forEach var="r" items="${b.rList}">
                     <li>[${r.mid}] ${r.cmsg}
                     </li>
                     </c:forEach>
                     </ul>  -->
                     
                     <c:if test="${mrole=='admin'}">
                  <form action="insertMR.do" method="post" class="replyForm">
                     <input type="hidden" name="mid" value="${userId}"> <input
                        type="hidden" name="bnum" value="${c.bnum}"> 댓글 : <input
                        type="text" name="cmsg" autocomplete=""> <input type="submit"
                        value="댓글 등록" class="replyInput">
                  </form>
                  </c:if>
                     </li>
                  
               </c:forEach>
            </ul>


         </div>
         <c:if test="${!noMoreContent}">
          <div class="moreBoard"><a href="boardMain.do?cnt=${cnt+4}">view more</a></div>
         </c:if>


         <!-- --------------------------------------------------- -->
         <div class="row justify-content-center">
            <div class="col-md-12">
               <script
                  src="https://polyfill.io/v3/polyfill.min.js?features=default"></script>




               <h3 id="mapTitle">WHERE IS VARCHAR ?</h3>
               <!--The div element for the map -->
               <div id="map">

                  <script
                     src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAv7LwXYV_LZn5A6X6dIyGFKLUo0bRr1XE&callback=initMap&v=weekly"
                     defer></script>
               </div>
               <div id="storeContainer">
                  <button type="button" id="CarStore1" class="carStore">역삼점</button>
                  <button type="button" id="CarStore2" class="carStore">하남1호점</button>
                  <button type="button" id="CarStore3" class="carStore">하남2호점</button>
                  <button type="button" id="CarStore4" class="carStore">군자점</button>
                  <button type="button" id="CarStore5" class="carStore">거여점</button>
                  <button type="button" id="CarStore6" class="carStore">신림점</button>
                  <button type="button" id="CarStore7" class="carStore">시흥점</button>
               </div>
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
   <script src="js/boardMenu.js"></script>
   <script src="js/changeArrow.js"></script>

</body>
</html>