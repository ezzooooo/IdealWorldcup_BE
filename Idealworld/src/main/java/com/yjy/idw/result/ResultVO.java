package com.yjy.idw.result;

public class ResultVO {
	int id; 
	int first_image_id; 
	int second_image_id; 
	int first_win_cnt; 
	int second_win_cnt;
	String winner;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getFirst_image_id() {
		return first_image_id;
	}
	public void setFirst_image_id(int first_image_id) {
		this.first_image_id = first_image_id;
	}
	public int getSecond_image_id() {
		return second_image_id;
	}
	public void setSecond_image_id(int second_image_id) {
		this.second_image_id = second_image_id;
	}
	public int getFirst_win_cnt() {
		return first_win_cnt;
	}
	public void setFirst_win_cnt(int first_win_cnt) {
		this.first_win_cnt = first_win_cnt;
	}
	public int getSecond_win_cnt() {
		return second_win_cnt;
	}
	public void setSecond_win_cnt(int second_win_cnt) {
		this.second_win_cnt = second_win_cnt;
	}
	public String getWinner() {
		return winner;
	}
	public void setWinner(String winner) {
		this.winner = winner;
	} 
}
