package ManagerAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.ActionForward;
import car.CarVO;

public class SelectCarAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		CarVO cvo = new CarVO();
		ManagerDAO mdao = new ManagerDAO();
		System.out.println("select Car : "+request.getParameter("cnum"));
		int cnum = Integer.parseInt(request.getParameter("cnum"));
		cvo.setCnum(cnum);
		cvo=mdao.selectOne(cvo);
		request.setAttribute("data", cvo);
		
		forward.setPath("manager.do");
		forward.setRedirect(false);
		
		return forward;
	}

}
