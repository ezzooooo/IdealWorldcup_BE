package com.yjy.idw.image;

public class ImageVO {
	private int id;
	private int tournament_id;
	private String name;
	private String URL;
	private int win_cnt;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTournament_id() {
		return tournament_id;
	}
	public void setTournament_id(int tournament_id) {
		this.tournament_id = tournament_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getURL() {
		return URL;
	}
	public void setURL(String uRL) {
		URL = uRL;
	}
	public int getWin_cnt() {
		return win_cnt;
	}
	public void setWin_cnt(int win_cnt) {
		this.win_cnt = win_cnt;
	}
}
