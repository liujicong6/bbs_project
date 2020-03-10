package pojo;

public class user {
	public  String  userId;
	public  String  userPsw;
	public  String  userEmail;
	public  String  userPhoto;
	public  String  userAlice;
	public  String  userSex;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPsw() {
		return userPsw;
	}
	public void setUserPsw(String userPsw) {
		this.userPsw = userPsw;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserPhoto() {
		return userPhoto;
	}
	public void setUserPhoto(String userPhoto) {
		this.userPhoto = userPhoto;
	}
	public String getUserAlice() {
		return userAlice;
	}
	public void setUserAlice(String userAlice) {
		this.userAlice = userAlice;
	}
	
	public String getUserSex() {
		return userSex;
	}
	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}
	public user(String userId, String userPsw, String userEmail, String userPhoto, String userAlice, String userSex) {
		super();
		this.userId = userId;
		this.userPsw = userPsw;
		this.userEmail = userEmail;
		this.userPhoto = userPhoto;
		this.userAlice = userAlice;
		this.userSex = userSex;
	}
	public user() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
}
