package dto;

import org.codehaus.jackson.annotate.JsonProperty;


public class TestUser {
	@JsonProperty("userId")
	String userId;
	@JsonProperty("name")
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
