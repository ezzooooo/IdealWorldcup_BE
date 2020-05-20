package com.yjy.idw.user;

public class UserVO {
	private int id; 
	private String nickname;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	} 
	
	@Override
	public String toString() {
		return "[" + id + "," + nickname + "]";
	}
}
