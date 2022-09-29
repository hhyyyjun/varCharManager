
  	var naver_id_login = new naver_id_login("Xkx0uuCjBlwxfo11qYok", "http://localhost:8088/VarCharProject/naverLogin.jsp");
  	var state = naver_id_login.getUniqState();
  	//naver_id_login.setButton("white", 2,40);
  	naver_id_login.setDomain("http://localhost:8088/VarCharProject/login.jsp");
  	naver_id_login.setState(state);
 	naver_id_login.setPopup();
 	naver_id_login.init_naver_id_login();
