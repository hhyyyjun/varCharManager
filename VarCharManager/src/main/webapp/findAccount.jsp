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
	rel="stylesheet" />

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
<link rel="stylesheet" href="css/findAccount.css" />
<script src="https://code.jquery.com/jquery-3.6.1.min.js"
	integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ="
	crossorigin="anonymous"></script>
</head>
<body>
	<koala:nav/>
	<!-- END nav -->

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
					<h1 class="mb-3 bread">Find Account</h1>
				</div>
			</div>
		</div>
	</section>
	<!----------------------아이디 / 비번 찾기 form------------------------->
	<div id="wrap">
		<div>
			<!-- 아이디, 비밀번호 찾기 -->

			<ul id="searchInner">
				<li id="searchId" class="searchInfo"><span>아이디 찾기</span></li>
				<li id="searchPassword" class="searchInfo"><span>비밀번호 찾기</span>
				</li>
			</ul>
		</div>
		<div id="Container">
			<!-- 아이디(이메일) 찾기 -->

			<div id="idBox">
				<form name="findId" action="/FindId.do" method="post">
					<p id="nameTitle">이름</p>
					<input name="mname" type="text" id="nameInput" placeholder="이름(실명)"
						autocomplete="off" />

					<p id="emailTitleForId">이메일</p>
					<div id="certificateInnerForId">
						<input name="memail" type="text" id="emailInputForId"
							placeholder="이메일 주소" autocomplete="off" />
						<button type="button" id="certificateBtnForId">아이디 발송</button>
					</div>
					<div id="checkResultBox">
						<span id="checkResult"></span>
					</div>
					<div>
						<button type="button" id="idSearchBtn" onclick="location.href='login.jsp';">로그인</button>
					</div>
				</form>

				<div id="phoneMsg">
					<p>회원가입 시 등록한 이름, 이메일을 입력해주세요!</p>
				</div>
			</div>

			<!-- 비밀번호 찾기 -->

			<div id="passwordBox">
				<form name="findPw" action="" method="post">
					<p id="idTitle">아이디</p>
					<input name="mid" type="text" id="idInput" placeholder="아이디"
						autocomplete="off" />
					<p id="emailTitleForPw">이메일</p>
					<div id="certificateInnerForPw">
						<input name="memail" type="email" id="emailInputForPw"
							placeholder="이메일 주소" autocomplete="off" />
						<button type="button" id="certificateBtnForPw">비밀번호 발송</button>
					</div>
					<div id="checkResultBox">
						<span id="checkResult2"></span>
					</div>
					<div>
						<button type="button" id="passwordSearchBtn" onclick="location.href='login.jsp';">로그인
						</button>
					</div>
				</form>

				<div id="emailMsg">
					<p>회원가입 시 등록한 아이디, 이메일을 입력해주세요!</p>
				</div>
			</div>

			<!-- 유효성검사 msg -->
			<div id="onlyName">
				<p>올바른 이름의 형식이 아닙니다!</p>
			</div>
			<div id="onlyId">
				<p>올바른 아이디의 형식이 아닙니다!</p>
			</div>

			<div id="missing1">
				<p>이메일에 '@' 문자가 누락되어 있습니다!</p>
			</div>

			<div id="missing2">
				<p>이메일에 ' . ' 문자가 누락되어 있습니다!</p>
			</div>

			<div id="blank">
				<p>입력하지 않은 항목이 있습니다!</p>
			</div>

			<!--  

			<h2 class="subLogin">
				<span>간편하게 로그인하기</span>
			</h2>
			<ul id="otherLogin">
				<li><a id="naver_id_login" href="javascript:void(0)"></a></li>
				<li><a href="#"></a></li>
			</ul>
			
			-->
			
			<h2 class="subLogin">
				<span>아직 회원이 아니세요?</span>
			</h2>
			<div id="registerInner">
				<a id="registerButton" href="#"> <span>회원가입</span>
				</a>
			</div>
			<div id="moreService">
				<p>
					회원가입을 통해 포인트 적립, 회원전용혜택 등 <br />더 많은 서비스를 이용하실 수 있습니다.
				</p>
			</div>
		</div>

		<div id="footer">
			<address>Ⓒ VARCHAR. All Rights Reserved.</address>
		</div>
	</div>
	<!------------------------------>

	<footer class="ftco-footer ftco-bg-dark ftco-section">
		<div class="container">
			<div class="row mb-5">
				<div class="col-md">
					<div class="ftco-footer-widget mb-4">
						<h2 class="ftco-heading-2">
							<a href="#" class="logo">VAR<span>CHAR</span></a>
						</h2>
						<p>Far far away, behind the word mountains, far from the
							countries Vokalia and Consonantia, there live the blind texts.</p>
						<ul
							class="ftco-footer-social list-unstyled float-md-left float-lft mt-5">
							<li class="ftco-animate"><a href="#"><span
									class="icon-twitter"></span></a></li>
							<li class="ftco-animate"><a href="#"><span
									class="icon-facebook"></span></a></li>
							<li class="ftco-animate"><a href="#"><span
									class="icon-instagram"></span></a></li>
						</ul>
					</div>
				</div>
				<div class="col-md">
					<div class="ftco-footer-widget mb-4 ml-md-5">
						<h2 class="ftco-heading-2">Information</h2>
						<ul class="list-unstyled">
							<li><a href="#" class="py-2 d-block">About</a></li>
							<li><a href="#" class="py-2 d-block">Services</a></li>
							<li><a href="#" class="py-2 d-block">Term and Conditions</a>
							</li>
							<li><a href="#" class="py-2 d-block">Best Price
									Guarantee</a></li>
							<li><a href="#" class="py-2 d-block">Privacy &amp;
									Cookies Policy</a></li>
						</ul>
					</div>
				</div>
				<div class="col-md">
					<div class="ftco-footer-widget mb-4">
						<h2 class="ftco-heading-2">Customer Support</h2>
						<ul class="list-unstyled">
							<li><a href="#" class="py-2 d-block">FAQ</a></li>
							<li><a href="#" class="py-2 d-block">Payment Option</a></li>
							<li><a href="#" class="py-2 d-block">Booking Tips</a></li>
							<li><a href="#" class="py-2 d-block">How it works</a></li>
							<li><a href="#" class="py-2 d-block">Contact Us</a></li>
						</ul>
					</div>
				</div>
				<div class="col-md">
					<div class="ftco-footer-widget mb-4">
						<h2 class="ftco-heading-2">Have a Questions?</h2>
						<div class="block-23 mb-3">
							<ul>
								<li><span class="icon icon-map-marker"></span><span
									class="text">203 Fake St. Mountain View, San Francisco,
										California, USA</span></li>
								<li><a href="#"><span class="icon icon-phone"></span><span
										class="text">+2 392 3929 210</span></a></li>
								<li><a href="#"><span class="icon icon-envelope"></span><span
										class="text">info@yourdomain.com</span></a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12 text-center">
					<p>
						<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
						Copyright &copy;
						<script>
                document.write(new Date().getFullYear());
              </script>
						All rights reserved | This template is made with <i
							class="icon-heart color-danger" aria-hidden="true"></i> by <a
							href="https://colorlib.com" target="_blank">Colorlib</a>
						<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
					</p>
				</div>
			</div>
		</div>
	</footer>

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
	<script src="js/findAccount.js"></script>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
<script type="text/javascript">
  	var naver_id_login = new naver_id_login("Xkx0uuCjBlwxfo11qYok", "http://localhost:8088/aJSPProject2/naverLogin.jsp");
  	var state = naver_id_login.getUniqState();
  	//naver_id_login.setButton("white", 2,40);
  	naver_id_login.setDomain("http://localhost:8088/aJSPProject2/login.jsp");
  	naver_id_login.setState(state);
  	naver_id_login.setPopup();
  	naver_id_login.init_naver_id_login();
  </script>

	<script type="text/javascript">
		//아이디 전송
	  document.getElementById("certificateBtnForId").onclick = () => {
	      const name = $("#nameInput").val(); 
		  const email = $("#emailInputForId").val();
	       console.log("로그 : name " + name);
	       console.log("로그 : email " + email );
	          $.ajax({
	             type:'POST',
	             url: '${pageContext.request.contextPath}/sendIdEmail',
	             data: {name:name ,email:email},
	             
	             success: function(mid){
	                console.log("로그 mid : ["+mid+"]");
	                if(mid != null){
		                   console.log("로그 mid1 : ["+mid+"]");
	                   $('#checkResult').text("아이디 전송 완료");
	                   $('#checkResult').css("color", "blue");

	                }else{
	                   console.log("로그 mid2 : ["+mid+"]");
	                   $('#checkResult').text("아이디 전송 불가");
	                   $('#checkResult').css("color", "red");
	                }
	             }, 
	            error: function(request, status, error){ // 서블릿에서 에러 발생 시 
	               console.log("code: "+request.status);
	               console.log("message: "+request.responseText);
	               console.log("error: "+error);
	            }
	          });
		}
	  
	  	//비밀번호 전송
	  	  document.getElementById("certificateBtnForPw").onclick = () => {
	      const mid = $("#idInput").val(); 
		  const email = $("#emailInputForPw").val();
	       console.log("로그 : mid " + mid);
	       console.log("로그 : email " + email );
	          $.ajax({
	             type:'POST',
	             url: '${pageContext.request.contextPath}/sendPwEmail',
	             data: {mid:mid ,email:email},
	             
	             success: function(randomPw){ //
	                console.log("로그 mpw : ["+randomPw+"]");
	                if(randomPw != null){
		                   console.log("로그 랜덤번호 : ["+randomPw+"]");
	                   $('#checkResult2').text("비밀번호 재발행 완료");
	                   $('#checkResult2').css("color", "blue");

	                }else{
	                   console.log("로그 랜덤번호 null : ["+randomPw+"]");
	                   $('#checkResult2').text("비밀번호 재발행 불가");
	                   $('#checkResult2').css("color", "red");
	                }
	             }, 
	            error: function(request, status, error){ // 서블릿에서 에러 발생 시 
	               console.log("code: "+request.status);
	               console.log("message: "+request.responseText);
	               console.log("error: "+error);
	            }
	    
	          });
		}
	  	
		</script>

</body>
</html>