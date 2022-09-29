<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
            <%@ taglib tagdir="/WEB-INF/tags" prefix="koala" %>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
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
    <!--8.19 김종현 수정 (페이지 css 추가)-->
    <link rel="stylesheet" href="css/detail.css" />
      <link rel="stylesheet" href="css/filterSearch.css" />
    
  </head>
  <body>
    <koala:nav/>
   <koala:zzim/>
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
            <h1 class="mb-3 bread">Car Details</h1>
          </div>
        </div>
      </div>
    </section>

    <section class="ftco-section ftco-car-details">
      <div class="container">
        <div class="row justify-content-center">
          <div class="col-md-12">
            <div class="car-details">
              <div
                class="img rounded"
                style="background-image: url(${data.cimg})"
                
              >
              </div>
              <!--8.19 김종현 수정
            (클래스 text-center삭제, carTitle 추가)-->
              <div class="text carTitle">
                <h2>${data.ctitle}</h2>
                <span class="subheading">${data.ckm}km</span>
                <!--가격, 찜목록 추가 버튼 추가-->
                <div class="buyCar">
                   <c:choose>
                      <c:when test="${data.cprice==2147483647}">
                         <h2>상담 예약</h2>
                      </c:when>
                      <c:otherwise>
                        <h2>${data.cprice}만원</h2>
                      </c:otherwise>
                   </c:choose>
                   
                  <button type="submit" onclick="location.href='storeAdd.do?cnum=${data.cnum}';">찜하기</button>
                </div>
              </div>
              <!------------------------------->
            </div>
          </div>
        </div>
        <div class="row">
          <div class="col-md d-flex align-self-stretch ftco-animate">
            <div class="media block-6 services">
              <div class="media-body py-md-4">
                <div class="d-flex mb-3 align-items-center">
                  <div
                    class="icon d-flex align-items-center justify-content-center"
                  >
                    <span class="flaticon-dashboard"></span>
                  </div>
                  <div class="text">
                    <h3 class="heading mb-0 pl-3">
                      주행거리
                      <span>${data.ckm}km</span>
                    </h3>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <div class="col-md d-flex align-self-stretch ftco-animate">
            <div class="media block-6 services">
              <div class="media-body py-md-4">
                <div class="d-flex mb-3 align-items-center">
                  <div
                    class="icon d-flex align-items-center justify-content-center"
                  >
                    <span class="flaticon-pistons"></span>
                  </div>
                  <div class="text">
                    <h3 class="heading mb-0 pl-3">
                      가격
                      <c:choose>
                         <c:when test="${data.cprice==2147483647}">
                            <span>상담예약</span>
                         </c:when>
                         <c:otherwise>
                         <span>${data.cprice}만원</span>
                         
                         </c:otherwise>
                      </c:choose>
                    </h3>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <div class="col-md d-flex align-self-stretch ftco-animate">
            <div class="media block-6 services">
              <div class="media-body py-md-4">
                <div class="d-flex mb-3 align-items-center">
                  <div
                    class="icon d-flex align-items-center justify-content-center"
                  >
                    <span class="flaticon-car-seat"></span>
                  </div>
                  <div class="text">
                    <h3 class="heading mb-0 pl-3">
                      연식
                      <span>${data.cyear}</span>
                    </h3>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <div class="col-md d-flex align-self-stretch ftco-animate">
            <div class="media block-6 services">
              <div class="media-body py-md-4">
                <div class="d-flex mb-3 align-items-center">
                  <div
                    class="icon d-flex align-items-center justify-content-center"
                  >
                    <span class="flaticon-backpack"></span>
                  </div>
                  <div class="text">
                    <h3 class="heading mb-0 pl-3">
                      지역
                      <span>${data.ccity}</span>
                    </h3>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <div class="col-md d-flex align-self-stretch ftco-animate">
            <div class="media block-6 services">
              <div class="media-body py-md-4">
                <div class="d-flex mb-3 align-items-center">
                  <div
                    class="icon d-flex align-items-center justify-content-center"
                  >
                    <span class="flaticon-diesel"></span>
                  </div>
                  <div class="text">
                    <h3 class="heading mb-0 pl-3">
                      연료
                      <span>${data.cfuel}</span>
                    </h3>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
        <div class="row">
          <div class="col-md-12 pills">
            <div class="bd-example bd-example-tabs">
              <div class="d-flex justify-content-center">
                <ul class="nav nav-pills mb-3" id="pills-tab" role="tablist">
                  <!-- 
                  <li class="nav-item">
                    <a
                      class="nav-link active"
                      id="pills-description-tab"
                      data-toggle="pill"
                      href="#pills-description"
                      role="tab"
                      aria-controls="pills-description"
                      aria-expanded="true"
                      >Features</a
                    >
                  </li>
                   -->
                  <li class="nav-item">
                    <a
                      class="nav-link"
                      id="pills-manufacturer-tab"
                      data-toggle="pill"
                      href="#pills-manufacturer"
                      role="tab"
                      aria-controls="pills-manufacturer"
                      aria-expanded="true"
                      >주요사항</a
                    >
                  </li>
                  <li class="nav-item">
                    <a
                      class="nav-link"
                      id="pills-review-tab"
                      data-toggle="pill"
                      href="#pills-review"
                      role="tab"
                      aria-controls="pills-review"
                      aria-expanded="true"
                      >딜러의 한마디</a
                    >
                  </li>
                </ul>
              </div>

              <div class="tab-content" id="pills-tabContent">
                <!--  
                <div
                  class="tab-pane fade show active"
                  id="pills-description"
                  role="tabpanel"
                  aria-labelledby="pills-description-tab"
                >
                  <div class="row">
                    <div class="col-md-4">
                      <ul class="features">
                        <li class="check">
                          <span class="ion-ios-checkmark"></span>Airconditions
                        </li>
                        <li class="check">
                          <span class="ion-ios-checkmark"></span>Child Seat
                        </li>
                        <li class="check">
                          <span class="ion-ios-checkmark"></span>GPS
                        </li>
                        <li class="check">
                          <span class="ion-ios-checkmark"></span>Luggage
                        </li>
                        <li class="check">
                          <span class="ion-ios-checkmark"></span>Music
                        </li>
                      </ul>
                    </div>
                    <div class="col-md-4">
                      <ul class="features">
                        <li class="check">
                          <span class="ion-ios-checkmark"></span>Seat Belt
                        </li>
                        <li class="remove">
                          <span class="ion-ios-close"></span>Sleeping Bed
                        </li>
                        <li class="check">
                          <span class="ion-ios-checkmark"></span>Water
                        </li>
                        <li class="check">
                          <span class="ion-ios-checkmark"></span>Bluetooth
                        </li>
                        <li class="remove">
                          <span class="ion-ios-close"></span>Onboard computer
                        </li>
                      </ul>
                    </div>
                    <div class="col-md-4">
                      <ul class="features">
                        <li class="check">
                          <span class="ion-ios-checkmark"></span>Audio input
                        </li>
                        <li class="check">
                          <span class="ion-ios-checkmark"></span>Long Term Trips
                        </li>
                        <li class="check">
                          <span class="ion-ios-checkmark"></span>Car Kit
                        </li>
                        <li class="check">
                          <span class="ion-ios-checkmark"></span>Remote central
                          locking
                        </li>
                        <li class="check">
                          <span class="ion-ios-checkmark"></span>Climate control
                        </li>
                      </ul>
                    </div>
                  </div>
                </div>
                -->
                
                <div
                  class="tab-pane fade"
                  id="pills-manufacturer"
                  role="tabpanel"
                  aria-labelledby="pills-manufacturer-tab"
                  >
                  <div class = "moredetail" style="text-align: center;">
                  <p>
                  <h4 class="ex">차량 주요 특징 : [${data.csubtitle}] </h4>
                  <br>
                  </p>
                  <p> 
                     <h4 class="ex">VARCHAR가 인증하는 차량! 10년 이상 경력의 전문 딜러가 
                     당신의 소중한 차를 꼼꼼히 케어합니다!</h4>
                     <br>
                     <h4 class="ex">위 [${data.ctitle}] 차량에 대한 딜러의 의견도 확인하세요!</h4>
                     <br>
                  </p>
                 <br><br>
                  </div>
                  <h4 class="exam"> <${data.ctitle}> 차량의 진단 평가 결과</h4>
                  <br><br>
                  <div class = "globisPicture">
                  
                     <img alt="현대글로비스 좌측사진" src="https://autobell.co.kr/images/contents/suv-panel.png">
                     
                  <div class = "detail-carlist-left">
                                      <ul>
                                 	<li>후드</li>						
                                 	<li>프론트휀더</li>
                                 	<li>도어</li>
                                 	<li>사이드실패널</li>
                                 	<li>트렁크리드</li>
                                 	<li>루프패널</li>
                                 	<li>쿼터패널</li>
                                 </ul>
                                
                                 <ol class = "detail-carlist-left-ol">
                                 	<li>정상</li>
                                 	<li>정상</li>
                                 	<li>정상</li>
                                 	<li>정상</li>
                                 	<li>정상</li>
                                 	<li>정상</li>
                                 	<li>정상</li>
                                 
                                 </ol>
                                           </div>
                     
                     
                  </div>      
                  
                  <div><hr></div>
                  <div class = "globisPicture">
                     <img alt="현대글로비스 우측사진" src="https://autobell.co.kr/images/contents/suv-frame.png">
                       <div class = "detail-carlist-right">
                                      <ul>
                                 	<li>프론트패널</li>						
                                 	<li>크로스멤버</li>
                                 	<li>인사이드패널</li>
                                 	<li>사이드멤버</li>
                                 	<li>휠하우스</li>
                                 	<li>패키지트레이</li>
                                 	<li>대쉬패널</li>
                                 	<li>플로어패널</li>
                                 	<li>필러패널</li>
                                 	
                                 	
                                 	
                                 </ul>
                                
                                 <ol class = "detail-carlist-right-ol">
                                 	<li>정상</li>
                                 	<li>정상</li>
                                 	<li>정상</li>
                                 	<li>정상</li>
                                 	<li>정상</li>
                                 	<li>정상</li>
                                 	<li>정상</li>
                                 	<li>정상</li>
                                 	<li>정상</li>
                                 	
                                 
                                 </ol>
                                           </div>
                                           </div>
                		
                                    
                                 
                <hr>
                  <div class = "detail-ment-background">
                  
                   <h5 class = "detail-ment">
                           
                           차를 잘 몰라서 불안하신가요?<br>
                     걱정하지 마세요! 차를 아는 전문가가 직접 확인하고 진단한 차량입니다.<br>
                   </h5>                 

                        <span >
                     오토벨 상세 진단서의 정보와 실제 차량 상태가 상이할 경우, 최대 150만원까지 보상해 드립니다.<br>
                     (구매 확정 후 3개월 이내, 주행거리 5,000km 이내 차량에 한함)
                        </span>
                  </div>
                        
                        <br><br><br>
                        <div class = "detail-logo">
                        <strong >
                        
                        이 차량을 <a href="main.do"><img alt="로고" src="./images/VARCHARWHITE.png"></a> 가 보증합니다!
                        </strong> 
                        </div>
                     
                  
                </div>

                <div
                  class="tab-pane fade"
                  id="pills-review"
                  role="tabpanel"
                  aria-labelledby="pills-review-tab"
                >
                  <div class="row">
                    <div class="col-md-7">
                      <h3 class="head">3명의 딜러가 고객님께 제안드립니다!</h3>
                      <div class="review d-flex">
                        <div
                          class="user-img1"
                          
                        ></div>
                        <div class="desc">
                          <h4>
                            <span class="text-left">이준선</span>
                            <span class="text-right"></span>
                          </h4>
                          
                          <p>
                            위 ${data.ctitle} 차량은 현재 수리가 전부 완료된 상태이며, 동일 차량 가격 대비 
                            저렴한 가격에 확보했습니다! 자세한 문의는 "문의 게시판"을 활용해 주시기 바랍니다!
                          </p>
                        </div>
                      </div>
                      <div class="review d-flex">
                        <div
                          class="user-img2"
                          
                        ></div>
                        <div class="desc">
                          <h4>
                            <span class="text-left">황지민</span>
                            <span class="text-right"></span>
                          </h4>
                          
                          <p>
                            ${data.ctitle} 과 비슷한 차량만 10여년째 취급하고 있는 딜러입니다. 
                            문의 사항은 "문의 게시판"을 활용해 주시고, 항상 제게 맡겨주셔서 감사합니다.
                          </p>
                        </div>
                      </div>
                      <div class="review d-flex">
                        <div
                          class="user-img3"
                      
                        ></div>
                        <div class="desc">
                          <h4>
                            <span class="text-left">김종현</span>
                            <span class="text-right"></span>
                          </h4>
                          
                            <span class="text-right"
                              ></span>
                         
                          <p>
                            신뢰로 보답드리는 딜러입니다. 위 ${data.ctitle} 차량 뿐 아니라 
                            비슷한 차량을 전문적으로 취급하며, 외에도 여러 종류, 수리까지 전문적으로
                            하고있습니다. 감사합니다.
                          </p>
                        </div>
                      </div>
                    </div>
                    <div class="col-md-5">
                      <div class="rating-wrap">
                        <h3 class="head">딜러에게 문의하세요!</h3>
                        <div class="wrap">
                          <h5>해당 차량 문의하기</h5>
                          <br>
                          <h6>차량 : ${data.ctitle}</h6>
                          <br>
                          
                          <h6>인계 받으실 매장 : ${data.ccity}</h6>
                          <br>
                          <div><a href="board.jsp">WHERE IS VARCHAR ?</a><br>
                          (클릭하시면 매장 위치 정보로 이동합니다.)</div>
                          <br>
                          <div><a href="board.jsp" class="btn btn-primary py-2 mr-1 QnABtn">문의 하기</a></div>
                         
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
    
    <section style="text-align: center;" class="ftco-section ftco-no-pt">
      	<div class = "moveSiteBtn">
        <a href="javascript:history.back();" class="btn btn-primary py-2 mr-1">뒤로가기</a>
        <a href="main.do" class="btn btn-primary py-2 mr-1">메인으로가기</a>
 		</div>
   </section>
<koala:fotter/>

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
    <script src="js/cartOpenner.js"></script>
  </body>
</html>