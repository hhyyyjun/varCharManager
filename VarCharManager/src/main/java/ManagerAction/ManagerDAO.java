package ManagerAction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Util.JDBCUtil;
import car.CarVO;
import member.MemberVO;

public class ManagerDAO {
	Connection conn;	// DB연결 객체 선언
	PreparedStatement pstmt;	// SQL문 수행할 PreparedStatement 객체 선언
	final String sql_selectAllC ="SELECT * FROM CAR ORDER BY CNUM ASC";	
	final String sql_selectAllM ="SELECT * FROM CMEMBER ORDER BY MID ASC";
	final String sql_insert = "INSERT INTO CAR VALUES((SELECT NVL(MAX(CNUM),0) +1 FROM CAR),?,?,?,?,?,?,?,?)";
	final String sql_selectOne="SELECT * FROM CAR WHERE CNUM=?";
	final String sql_update = "UPDATE CAR SET CTITLE=?, CSUBTITLE=?, CYEAR=?, CFUEL=?, CKM=?, CPRICE=?, CCITY=?, CIMG=? WHERE CNUM=?";

	public ArrayList<CarVO> selectAllCar(CarVO vo){  //출력에 사용될 배열리스트 리턴값으로 사용
			ArrayList<CarVO> datas = new ArrayList<CarVO>();
			conn=JDBCUtil.connect();
			try {
				pstmt=conn.prepareStatement(sql_selectAllC);
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()) {
					CarVO data=new CarVO();
					data.setCtitle(rs.getString("ctitle"));
					data.setCsubtitle(rs.getString("csubtitle"));
					data.setCfuel(rs.getString("cfuel"));
					data.setCkm(rs.getInt("ckm"));
					data.setCprice(rs.getInt("cprice"));
					data.setCcity(rs.getString("ccity"));
					data.setCyear(rs.getInt("cyear"));
					data.setCimg(rs.getString("cimg"));
					data.setCnum(rs.getInt("cnum"));
					datas.add(data);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				JDBCUtil.disconnect(pstmt, conn);
			}
			return datas;
		}	

	public ArrayList<MemberVO> selectAllMember(MemberVO vo){  //출력에 사용될 배열리스트 리턴값으로 사용
			ArrayList<MemberVO> datas = new ArrayList<MemberVO>();
			conn=JDBCUtil.connect();
			try {
				pstmt=conn.prepareStatement(sql_selectAllM);
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()) {
					MemberVO data=new MemberVO();
					data.setMid(rs.getString("mid")); //출력에 쓰일 것들
					data.setMpw(rs.getString("mpw"));
					data.setMname(rs.getString("mname"));
					data.setMnickname(rs.getString("mnickname"));
					data.setMadd(rs.getString("madd"));
					data.setMphone(rs.getString("mphone"));
					data.setMemail(rs.getString("memail"));
					data.setMrole(rs.getString("mrole"));
					datas.add(data);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				JDBCUtil.disconnect(pstmt, conn);
			}
			return datas;
		}
	
	public boolean insert(CarVO vo) {	// vo로 인자값을 받아 유지보수 용이
			conn = JDBCUtil.connect(); // DB연결
			try {
				pstmt=conn.prepareStatement(sql_insert);
				pstmt.setString(1, vo.getCtitle());
				pstmt.setString(2, vo.getCsubtitle());
				pstmt.setInt(3, vo.getCyear());
				pstmt.setString(4, vo.getCfuel());
				pstmt.setInt(5, vo.getCkm());
				pstmt.setInt(6, vo.getCprice());
				pstmt.setString(7, vo.getCcity());
				pstmt.setString(8, vo.getCimg());
				pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			} finally {
				JDBCUtil.disconnect(pstmt, conn);
			} 
			return true;
		}

	public CarVO selectOne(CarVO vo) { //출력할 값이 있는 VO를 리턴값으로, 인자로 넣을 VO를 set
			conn=JDBCUtil.connect();
			try {
				System.out.println("selectOne 로그 : " + vo);
				pstmt=conn.prepareStatement(sql_selectOne);
				pstmt.setInt(1, vo.getCnum()); 
				ResultSet rs=pstmt.executeQuery();
				if(rs.next()) {
					CarVO data=new CarVO();
					data.setCtitle(rs.getString("ctitle"));
					data.setCsubtitle(rs.getString("csubtitle"));
					data.setCfuel(rs.getString("cfuel"));
					data.setCkm(rs.getInt("ckm"));
					data.setCprice(rs.getInt("cprice"));
					data.setCcity(rs.getString("ccity"));
					data.setCyear(rs.getInt("cyear"));
					data.setCimg(rs.getString("cimg"));
					data.setCnum(rs.getInt("cnum"));
					return data;
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				JDBCUtil.disconnect(pstmt, conn);
			}
			return null;
		}
	public boolean update(CarVO vo) { //반환은 boolean 타입
			conn = JDBCUtil.connect();
			try {
				pstmt = conn.prepareStatement(sql_update);
				pstmt.setString(1, vo.getCtitle());
				pstmt.setString(2, vo.getCsubtitle());
				pstmt.setInt(3, vo.getCyear());
				pstmt.setString(4, vo.getCfuel());
				pstmt.setInt(5, vo.getCkm());
				pstmt.setInt(6, vo.getCprice());
				pstmt.setString(7, vo.getCcity());
				pstmt.setString(8, vo.getCimg());
				pstmt.setInt(9, vo.getCnum());
				pstmt.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}finally {
				JDBCUtil.disconnect(pstmt, conn);
			}
			return true;
		}
}
