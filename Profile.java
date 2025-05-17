package com.example.test;

public class Profile {
 int studentID;
 String initials;
 double score;
 String request;
	
	public Profile(int sNum, String init, double pts) {
		this.studentID= sNum;
		this.initials = init;
		this.score = pts;
		}
	public Profile(int sNum, String init, double pts, String req) {
		this.studentID= sNum;
		this.initials = init;
		this.score = pts;
		this.request = req;
		}
	
	public int getID() {
		return studentID;
	}
	
	public String getInitials() {
		return initials;
	}
	
	public double getScore() {
		return score;
	}
	public String getRequest() {
		return request;
	}
	
	public String toString() {
		return String.format(studentID+ " "+ initials+" "+ score);
	}
	
}



