package com.foodcourt.vendorowner.model;

import com.foodcourt.common.model.User;

public class Review {
	private User user;
	private String[] content;
	private int rating;
	public Review(User user, String[] content, int rating) {
		this.user = user;
		this.content = content;
		this.rating = rating;
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
