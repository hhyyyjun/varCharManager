package MessageAPI;

public class sendVO {
	private String phone; //사용자의 핸드폰번호 
	private String checkNum; //인증번호 비교 
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getCheckNum() {
		return checkNum;
	}
	public void setCheckNum(String checkNum) {
		this.checkNum = checkNum;
	}

}
