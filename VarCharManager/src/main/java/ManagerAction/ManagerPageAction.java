package ManagerAction;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.ActionForward;
import car.CarVO;
import member.MemberVO;

public class ManagerPageAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		MemberVO mvo = new MemberVO();
		CarVO cvo = new CarVO();
		ManagerDAO mdao = new ManagerDAO();
		

		//매물 등록하는 경우
		if(request.getParameter("ctitle") != null) {
			String ctitle = request.getParameter("ctitle");
			String csubtitle = request.getParameter("csubtitle");
			String cyear = request.getParameter("cyear");
			String cfuel = request.getParameter("cfuel");
			String ckm = request.getParameter("ckm");
			String cprice = request.getParameter("cprice");
			String ccity = request.getParameter("ccity");
			String uploadFile = request.getParameter("uploadFile");
			cvo.setCtitle(ctitle);
			cvo.setCsubtitle(csubtitle);
			cvo.setCfuel(cfuel);
			cvo.setCkm(Integer.parseInt(ckm));
			cvo.setCprice(Integer.parseInt(cprice));
			cvo.setCcity(ccity);
			cvo.setCyear(Integer.parseInt(cyear));
			cvo.setCimg(uploadFile);
			if(mdao.insert(cvo)) {
			}else {
				throw new Exception("error");
			}
		}

		ArrayList<CarVO> Clist = mdao.selectAllCar(cvo);
		ArrayList<MemberVO> Mlist = mdao.selectAllMember(mvo);
		request.setAttribute("cdata", Clist);
		request.setAttribute("mdata", Mlist);
		forward.setRedirect(false);
		forward.setPath("manager.jsp");
		return forward;
	}

}
