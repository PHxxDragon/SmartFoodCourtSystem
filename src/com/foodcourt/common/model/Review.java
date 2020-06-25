package com.foodcourt.common.model;

public class Review {
	private User user;
	private String[] content;
	private int rating;
	public Review() {

	}
	public User getUser() {
		return user;
	}
	public String[] getContent() {
		return content;
	}
	public void setContent(String[] content) {
		this.content = content;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
}
