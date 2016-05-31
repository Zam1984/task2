package dto;

import javax.persistence.Column;
import javax.persistence.Id;

public class TestUserDTO {
	@Id
	@Column(name="USER_ID")
	String userId;
	@Column(name="NAME")
	String userName;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
}
