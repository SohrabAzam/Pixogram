package com.social.imageApp.Pixogram.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "activity")
public class Activity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ref")
	private int id;

	@Column(name = "userid")
	private int userId;

	@Column(name = "activity")
	private String activity;

	@Column(name = "date")
	private String date;

	@Column(name = "time")
	private String time;

	public Activity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Activity(int id, int userId, String activity, String date, String time) {
		super();
		this.id = id;
		this.userId = userId;
		this.activity = activity;
		this.date = date;
		this.time = time;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getActivity() {
		return activity;
	}

	public void setActivity(String activity) {
		this.activity = activity;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "Activity [id=" + id + ", userId=" + userId + ", activity=" + activity + ", date=" + date + ", time="
				+ time + "]";
	}

}
