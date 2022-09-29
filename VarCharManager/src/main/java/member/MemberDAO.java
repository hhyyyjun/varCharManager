package member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Util.JDBCUtil;
import board.BoardVO;

public class MemberDAO {
	Connection conn;
	PreparedStatement pstmt;

	//로그인 
	final String sql_selectOne="SELECT * FROM CMEMBER WHERE MID=? AND MPW=?";
	// 회원정보변경 -> mid만으로 사용자 데이터 보기
	final String sql_selectOne_M="SELECT * FROM CMEMBER WHERE MID=?";
	//회원가입 
	final String sql_insert="INSERT INTO CMEMBER VALUES(?,?,?,?,?,?,?,?)";
	//회원가입 시 아이디 중복확인 
	final String sql_idcheck="SELECT * FROM CMEMBER WHERE MID=?";
	//회원 리스트 조희 (필요없으면 삭제!!) 
	final String sql_selectAll ="SELECT * FROM CMEMBER";
	//회원 정보 수정 
	final String sql_update = "UPDATE CMEMBER SET MPW=?, MNICKNAME=?, MADD=?, MPHONE=?, MEMAIL=? WHERE MID=?";
	//회원 탈퇴 
	final String sql_delete = "DELETE FROM CMEMBER WHERE MID=?";
	// 회원 탈퇴시 리뷰 ID (알수없음) - 트랜잭션
	final String sql_bupdate = "UPDATE CBOARD SET MID= '(알수없음)' WHERE MID =?";
	// 해당 MID에 게시글 전부 삭제 - 트랜잭션 
	final String sql_bdelete = "DELETE FROM CBOARD WHERE MID=?"; 
	// 아이디 찾기 (회원 이름, 번호 입력) 
	final String sql_findId = "SELECT MID FROM CMEMBER WHERE MNAME=? AND MEMAIL=?";
	// 비밀번호 찾기 (회원 아이디, 메일 입력) 
	final String sql_findPw = "SELECT MPW FROM CMEMBER WHERE MID=? AND MEMAIL=?"; 
	// 재발행 비밀번호로 변경 
	final String sql_updatePw = "UPDATE CMEMBER SET MPW=? WHERE MID=? AND MEMAIL=?";

	//로그인 
	public MemberVO selectOne(MemberVO vo) {
		conn=JDBCUtil.connect();
		try {
			System.out.println("selectOne 로그 : " + vo);
			pstmt=conn.prepareStatement(sql_selectOne);
			pstmt.setString(1, vo.getMid());
			pstmt.setString(2, vo.getMpw());
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()) {
				MemberVO data=new MemberVO();
				data.setMid(rs.getString("mid"));
				data.setMpw(rs.getString("mpw"));
				data.setMname(rs.getString("mname"));
				data.setMnickname(rs.getString("mnickname"));
				data.setMadd(rs.getString("madd"));
				data.setMphone(rs.getString("mphone"));
				data.setMemail(rs.getString("memail"));
				data.setMrole(rs.getString("mrole"));
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

	// 회원정보변경 -> mid만으로 사용자 데이터 보기
	public MemberVO selectOne_M(MemberVO vo) {
		conn=JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(sql_selectOne_M);
			pstmt.setString(1, vo.getMid());
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()) {
				MemberVO data=new MemberVO();
				data.setMid(rs.getString("mid"));
				data.setMpw(rs.getString("mpw"));
				data.setMname(rs.getString("mname"));
				data.setMnickname(rs.getString("mnickname"));
				data.setMadd(rs.getString("madd"));
				data.setMphone(rs.getString("mphone"));
				data.setMemail(rs.getString("memail"));
				data.setMrole(rs.getString("mrole"));
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

	//회원가입
	public boolean insert(MemberVO vo) {
		conn=JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(sql_insert);
			pstmt.setString(1, vo.getMid());
			pstmt.setString(2, vo.getMpw());
			pstmt.setString(3, vo.getMname());
			pstmt.setString(4, vo.getMnickname());
			pstmt.setString(5, vo.getMadd());
			pstmt.setString(6, vo.getMphone());
			pstmt.setString(7, vo.getMemail());
			pstmt.setString(8, vo.getMrole());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return true;
	}

	//회원가입 시 아이디 중복확인 
	public int idcheck(String id) {
		conn=JDBCUtil.connect();
		int result = -1;
		try {
			pstmt=conn.prepareStatement(sql_idcheck);
			pstmt.setString(1, id);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()) {
				result=0; //중복된 아이디
			}else {
				result=1; //사용가능한 아이디
			}
			System.out.println("아이디 중복체크결과 : "+result);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return result;
	}

	//회원 리스트 조회 
	public ArrayList<MemberVO> selectAll(MemberVO vo){
		ArrayList<MemberVO> datas = new ArrayList<MemberVO>();
		conn=JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(sql_selectAll);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				MemberVO data=new MemberVO();
				data.setMid(rs.getString("mid"));
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


	//회원 정보 수정 
	public boolean update(MemberVO vo) {
		conn = JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(sql_update);
			pstmt.setString(1, vo.getMpw());
			pstmt.setString(2, vo.getMnickname());
			pstmt.setString(3, vo.getMadd());
			pstmt.setString(4, vo.getMphone());
			pstmt.setString(5, vo.getMemail());
			pstmt.setString(6, vo.getMid());
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

	//회원 탈퇴 
	   // res가 true == 게시글 모두 삭제 / false == 알수없음으로 변경 
	   public boolean delete(BoardVO bvo ,MemberVO vo) {
	      System.out.println(bvo);
	      System.out.println(vo);
	      System.out.println("88888888888");
	      conn = JDBCUtil.connect();
	      try {
	         // 트랜잭션 시작
	         //conn.setAutoCommit(false);
	         // 만약 로그인한상태라면
	         if(vo.getMid() != null) {
	            System.out.println("delete 1");
	            // sql delete문 사용
	            pstmt = conn.prepareStatement(sql_delete);
	            // 위 sql문에 필요한 값들을 set해줌
	            pstmt.setString(1, vo.getMid());
	            //pstmt.setString(2, vo.getMpw());
	            int res = pstmt.executeUpdate(); 
	            System.out.println("delete 수정건수" + res);
	            // 게시글 처리
	            // 아래 bdelete() 함수를 사용
	            if(bdelete(bvo)) {
	               System.out.println("delete 2");
	               // commit일 경우 bdelete 함수가 잘 수행된것 
	               //conn.commit();
	            } else {
	               System.out.println("delete else");
	               // bdelete함수가 잘 수행되지 않았다면 rollback
	               //conn.rollback();
	               // 이후 return false
	               return false;
	            }
	         }
	      } catch (SQLException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	         return false;
	      }finally {
	         JDBCUtil.disconnect(pstmt, conn);
	      }
	      return true;
	   }

	   public boolean bdelete(BoardVO bvo) {
	      conn = JDBCUtil.connect();
	      try {
	         // 로그인 한 상태라면
	         if(bvo.getMid() != null) {
	            System.out.println("bdelete else");
	            // 게시글 삭제 여부를 가리는 VO 내 멤버변수 res
	            // 1일땐 게시글을 모두 삭제하고,
	            System.out.println(bvo.isRes());
	            if(bvo.isRes()) { //true
	               System.out.println("bdelete1");
	               pstmt = conn.prepareStatement(sql_bdelete);   
	               pstmt.setString(1, bvo.getMid());
	               // -1일 즉 else 일땐 알수 없음으로 변경되게끔한다.
	            } else{
	               pstmt = conn.prepareStatement(sql_bupdate);
	               pstmt.setString(1, bvo.getMid());
	            }
	            int res2 = pstmt.executeUpdate();
	            System.out.println(res2);
	            
	         }
	      } catch (SQLException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	         return false;
	      }finally {
		         JDBCUtil.disconnect(pstmt, conn);
	      }
	      return true;
	   }
	// 08.30 추가 사항
		// 아이디 중복 검사 함수 
		// 기존에 있던 selectOne_M sql문 사용 
		// 따로 사용한 이유는 output 값이 다르기 때문
	// 회원정보변경 -> mid만으로 사용자 데이터 보기
//		final String sql_selectOne_M="SELECT * FROM CMEMBER WHERE MID=?";
		public int check(MemberVO vo) {
			conn = JDBCUtil.connect();
			try {
				pstmt = conn.prepareStatement(sql_selectOne_M);
				pstmt.setString(1, vo.getMid());
				ResultSet rs = pstmt.executeQuery();
				if(rs.next()) {
					return 0;	// 아이디 중복 발생
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				JDBCUtil.disconnect(pstmt, conn);
			}
			return 1;		// 아이디 중복 발생 x 
		}

	//전부삭제 1 모두 유지 0 

	//아이디 찾기 (회원 이름, 이메일 입력) 
	public String findId(MemberVO vo) {
		String mid =null;
		conn = JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(sql_findId);
			pstmt.setString(1, vo.getMname()); 
			pstmt.setString(2, vo.getMemail()); 
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				mid = rs.getString("mid");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return mid; //아이디 반환 
	}
	
	//비밀번호 찾기 (회원 아이디, 메일 입력)
	public String findPW(MemberVO vo) {
		String mpw = null;
		conn = JDBCUtil.connect();
		try {
			System.out.println("MemberDAO 로그 : findPw 시작");
			pstmt = conn.prepareStatement(sql_findPw);
			pstmt.setString(1, vo.getMid());
			pstmt.setString(2, vo.getMemail()); 
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				mpw = rs.getString("mpw");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return mpw; //비밀번호 반환
	}
	
	// 재발행 비밀번호로 변경 
	public boolean updatePw(MemberVO vo) {
		conn = JDBCUtil.connect();
		try {
			System.out.println("MemberDAO : updatePw 시작");
			pstmt = conn.prepareStatement(sql_updatePw);
			pstmt.setString(1, vo.getMpw());
			pstmt.setString(2, vo.getMid());
			pstmt.setString(3, vo.getMemail());
			int res = pstmt.executeUpdate();
			System.out.println("수정 건수 : " + res);
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
