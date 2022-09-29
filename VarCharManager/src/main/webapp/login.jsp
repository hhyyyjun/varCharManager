<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib tagdir="/WEB-INF/tags" prefix="koala" %>
    
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
      rel="stylesheet"
    />

    <link rel="stylesheet" href="css/open-iconic-bootstrap.min.css" />
    <link rel="stylesheet" href="css/animate.css" />

    <link rel="stylesheet" href="css/owl.carousel.min.css" />
    <link rel="stylesheet" href="css/owl.theme.default.min.css" />
    <link rel="stylesheet" href="css/magnific-popup.css" />

    <link rel="stylesheet" href="css/aos.css" />

    <link rel="stylesheet" href="css/ionicons.min.css" />

    <link rel="stylesheet" href="css/bootstrap-datepicker.css" />
    <link rel="stylesheet" href="css/jquery.timepicker.css" />

    <link rel="stylesheet" href="css/flaticon.css" />
    <link rel="stylesheet" href="css/icomoon.css" />
    <link rel="stylesheet" href="css/style.css" />
    <link rel="stylesheet" href="css/login.css" />
  </head>
  <body>
   <koala:nav />
    <!-- END nav -->

    <section
      class="hero-wrap hero-wrap-2 js-fullheight"
      style="background-image: url('images/bg_3.jpg')"
      data-stellar-background-ratio="0.5"
    >
      <div class="overlay"></div>
      <div class="container">
        <div
          class="row no-gutters slider-text js-fullheight align-items-end justify-content-start"
        >
          <div class="col-md-9 ftco-animate pb-5">
            <p class="breadcrumbs">
              <span class="mr-2"
                ><a href="index.html"
                  >Home <i class="ion-ios-arrow-forward"></i></a
              ></span>
              
            </p>
            <h1 class="mb-3 bread">Login</h1>
          </div>
        </div>
      </div>
    </section>
    <!----------------------로그인 form------------------------->
    <div id="wrap">
      <!-- <div class="logo"><img src="./images/logo_user.jpg" alt="logo" /></div> -->
      <div id="loginContainer">
        <form name="login" action="login.do" method="post">
          <p id="idTitle">아이디</p>
          <input
            name="mid"
            type="text"
            id="idInput"
            placeholder="아이디"
            autocomplete="off"
          />

          <p id="pwTitle">비밀번호</p>
          <input
            name="mpw"
            type="password"
            id="pwInput"
            placeholder="비밀번호"
            autocomplete="off"
          />

          <div>
            <button type="submit" id="loginBtn" disabled>로그인</button>
          </div>

          <!-- <div id="missing1">
            <p>이메일에 '@' 문자가 누락되어 있습니다!</p>
          </div>

          <div id="missing2">
            <p>이메일에 ' . ' 문자가 누락되어 있습니다!</p>
          </div> -->

          <div id="blank">
            <p>입력하지 않은 항목이 있습니다!</p>
          </div>

          <div id="short">
            <p>비밀번호는 8자리 이상 입력해야 합니다!</p>
          </div>
        </form>

        <div id="findInner">
          <span
            ><a id="findIdPassword" href="findAccount.jsp"
              >아이디/비밀번호 찾기</a 
            ></span
          >
        </div>
      

    <!-- <h2 class="subLogin"><span>간편하게 로그인하기</span></h2>
        <ul id="otherLogin">
        <li><a id="naver_id_login" href="javascript:void(0)"></a></li>
          <li></li>  
        </ul>
        
        -->
        <h2 class="subLogin"><span>아직 회원이 아니세요?</span></h2>
        <div id="registerInner">
          <a id="registerButton" href="signup.jsp">
            <span>회원가입</span>
          </a>
        </div>

        <div id="moreService">
          <p>
            회원가입을 통해 포인트 적립, 회원전용혜택 등 <br />더 많은 서비스를
            이용하실 수 있습니다.
          </p>
        </div>

        <div id="footer">
          <address>Ⓒ VARCHAR. All Rights Reserved.</address>
        </div>
      </div>
    </div>
    <!------------------------------>

    <koala:fotter />

    <!-- loader -->
    <div id="ftco-loader" class="show fullscreen">
      <svg class="circular" width="48px" height="48px">
        <circle
          class="path-bg"
          cx="24"
          cy="24"
          r="22"
          fill="none"
          stroke-width="4"
          stroke="#eeeeee"
        />
        <circle
          class="path"
          cx="24"
          cy="24"
          r="22"
          fill="none"
          stroke-width="4"
          stroke-miterlimit="10"
          stroke="#F96D00"
        />
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
    <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBVWaKrjvy3MaE7SQ74_uJiULgl1JY0H2s&sensor=false"></script>
    <script src="js/google-map.js"></script>
    <script src="js/main.js"></script>
    <script src="js/login.js"></script>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
   
  </body>
</html>