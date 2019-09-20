package com.social.imageApp.Pixogram.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "blocked", schema = "pixogram")
public class Blocked {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "userid")
	private int userId;

	@Column(name = "blockedid")
	private int blockedId;

	@Column(name = "username")
	private String username;

	@Column(name = "blockeduser")
	private String blockedUser;

	public Blocked() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Blocked(int id, int userId, int blockedId, String username, String blockedUser) {
		super();
		this.id = id;
		this.userId = userId;
		this.blockedId = blockedId;
		this.username = username;
		this.blockedUser = blockedUser;
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

	public int getBlockedId() {
		return blockedId;
	}

	public void setBlockedId(int blockedId) {
		this.blockedId = blockedId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getBlockedUser() {
		return blockedUser;
	}

	public void setBlockedUser(String blockedUser) {
		this.blockedUser = blockedUser;
	}

	@Override
	public String toString() {
		return "Blocked [id=" + id + ", userId=" + userId + ", blockedId=" + blockedId + ", username=" + username
				+ ", blockedUser=" + blockedUser + "]";
	}

}
