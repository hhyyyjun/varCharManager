package ManagerAction;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.ActionForward;
import car.CarVO;
import member.MemberVO;

public class CarUpdateAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		CarVO cvo = new CarVO();
		MemberVO mvo = new MemberVO();
		ManagerDAO mdao = new ManagerDAO();
		
		System.out.println("업데이트 num 값 : "+request.getParameter("cnum"));
		int cnum = Integer.parseInt(request.getParameter("cnum"));
		String ctitle = request.getParameter("ctitle");
		String csubtitle = request.getParameter("csubtitle");
		String cyear = request.getParameter("cyear");
		String cfuel = request.getParameter("cfuel");
		String ckm = request.getParameter("ckm");
		String cprice = request.getParameter("cprice");
		String ccity = request.getParameter("ccity");
		String uploadFile = request.getParameter("uploadFile");
		cvo.setCnum(cnum);
		cvo.setCtitle(ctitle);
		cvo.setCsubtitle(csubtitle);
		cvo.setCfuel(cfuel);
		cvo.setCkm(Integer.parseInt(ckm));
		cvo.setCprice(Integer.parseInt(cprice));
		cvo.setCcity(ccity);
		cvo.setCyear(Integer.parseInt(cyear));
		cvo.setCimg(uploadFile);
		mdao.update(cvo);
		System.out.println("업데이트 다 지나감?@@@@@@@@@@@@@@");
		ArrayList<CarVO> Clist = mdao.selectAllCar(cvo);
		ArrayList<MemberVO> Mlist = mdao.selectAllMember(mvo);
		request.setAttribute("cdata", Clist);
		request.setAttribute("mdata", Mlist);
		forward.setRedirect(false);
		forward.setPath("manager.jsp");
		return forward;
	}

}
