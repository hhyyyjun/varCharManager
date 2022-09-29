package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ManagerAction.CarUpdateAction;
import ManagerAction.ManagerPageAction;
import ManagerAction.SelectCarAction;
import action.ActionForward;
import action.BoardMainAction;
import action.CarSearchAction;
import action.DeleteBoardAction;
import action.DeleteManagerReplyAction;
import action.DeleteMemberAction;
import action.DetailAction;
import action.InfoMainAction;
import action.InsertBoardAction;
import action.InsertManagerReplyAction;
import action.InsertMemberAction;
import action.LoginAction;
import action.LogoutAction;
import action.MainAction;
import action.MypageSelectOneAction;
import action.MypageUpdateAction;
import action.SearchBoardTitleAction;
import action.StoreAddAction;
import action.StoreRemoveAction;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("*.do") // *.do 요청을 수행하면 해당 어노테이션에 의해 FC로 오게됨!!!
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FrontController() {
		// ★ FrontController fc=new FrontController(); xxx
		// 객체화를 하지않았는데, 메서드를 사용할수있었다...?!!
		// 서블릿 컨테이너(==객체를 관리하는 것) == 웹 서버 == 톰캣이 서블릿을 객체화해주고있었음!!    	
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}

	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri=request.getRequestURI();
		String cp=request.getContextPath();
		String command=uri.substring(cp.length());
		System.out.println("fc:현재 들어온 명령어"+command);

		ActionForward forward= new ActionForward();
		//메인 페이지 이동
		if(command.equals("/main.do")) {
			System.out.println("메인 페이지 로 이동");
			try {
				forward=new MainAction().execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}else if(command.equals("/logout.do")) {	//로그 아웃
			System.out.println("로그: fc 에서 로그아웃 수행 ");
			try {
				forward=new LogoutAction().execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}



		}else if(command.equals("/detail.do")) {
			System.out.println("로그: fc 에서 상세보기 수행 ");
			try {
				forward=new DetailAction().execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if(command.equals("/filter.do")) { // main
			try {
				forward = new CarSearchAction().execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if(command.equals("/boardMain.do")) { // main
			try {
				forward = new BoardMainAction().execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if(command.equals("/deleteB.do")) { // main
			try {
				forward = new DeleteBoardAction().execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if(command.equals("/deleteMR.do")) { // main
			try {
				forward = new DeleteManagerReplyAction().execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if(command.equals("/deleteM.do")) { // main
			try {
				forward = new DeleteMemberAction().execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if(command.equals("/infoMain.do")) { // main
			try {
				forward = new InfoMainAction().execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if(command.equals("/insertB.do")) { // main
			try {
				forward = new InsertBoardAction().execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if(command.equals("/insertMR.do")) { // main
			try {
				forward = new InsertManagerReplyAction().execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if(command.equals("/insertM.do")) { // main
			try {
				forward = new InsertMemberAction().execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if(command.equals("/login.do")) { // main
			try {
				forward = new LoginAction().execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else if(command.equals("/searchR.do")) { // main
			try {
				forward = new SearchBoardTitleAction().execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if(command.equals("/storeR.do")) { // main
			try {
				forward = new StoreRemoveAction().execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if(command.equals("/storeAdd.do")){
			System.out.println("로그: fc 에서 스토어add 수행 ");
			try {
				forward=new StoreAddAction().execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if(command.equals("/mUpdate.do")) {
			try {
				forward = new MypageUpdateAction().execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if(command.equals("/mypage.do")) {
			try {
				forward = new MypageSelectOneAction().execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(command.equals("/manager.do")) {
			try {
				forward = new ManagerPageAction().execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(command.equals("/updateCar.do")) {
			try {
				forward = new CarUpdateAction().execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(command.equals("/selectCar.do")) {
			try {
				forward = new SelectCarAction().execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}



		if(forward!=null) {  //forward가 널값이 아니면
			if(forward.isRedirect()) {   //sendRidirect
				response.sendRedirect(forward.getPath());
			}
			else {						//forward
				RequestDispatcher dispatcher=request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}
		}else {

			//forward 값 이 null 일떄
			//PrintWriter out = response.getWriter();
			//out.println("<script>alert('요청처리실패!');history.go(-1);</script>");
			response.sendRedirect("main.do");
		}
	}

}
