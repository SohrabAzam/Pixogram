package com.social.imageApp.Pixogram.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "followers", schema = "pixogram")
public class Followers {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "identitynumber")
	private int refNum;

	@Column(name = "userid")
	private int userId;

	@Column(name = "followerid")
	private int followerId;

	@Column(name = "follower")
	private char follower;

	@Column(name = "following")
	private char following;

	@Column(name = "followername")
	private String followerName;

	@Column(name = "followerPicture")
	private String followerPicture;

	public Followers() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Followers(int refNum, int userId, int followerId, char follower, char following, String followerName,
			String followerPicture) {
		super();
		this.refNum = refNum;
		this.userId = userId;
		this.followerId = followerId;
		this.follower = follower;
		this.following = following;
		this.followerName = followerName;
		this.followerPicture = followerPicture;
	}

	public int getRefNum() {
		return refNum;
	}

	public void setRefNum(int refNum) {
		this.refNum = refNum;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getFollowerId() {
		return followerId;
	}

	public void setFollowerId(int followerId) {
		this.followerId = followerId;
	}

	public char getFollower() {
		return follower;
	}

	public void setFollower(char follower) {
		this.follower = follower;
	}

	public char getFollowing() {
		return following;
	}

	public void setFollowing(char following) {
		this.following = following;
	}

	public String getFollowerName() {
		return followerName;
	}

	public void setFollowerName(String followerName) {
		this.followerName = followerName;
	}

	public String getFollowerPicture() {
		return followerPicture;
	}

	public void setFollowerPicture(String followerPicture) {
		this.followerPicture = followerPicture;
	}

	@Override
	public String toString() {
		return "Followers [refNum=" + refNum + ", userId=" + userId + ", followerId=" + followerId + ", follower="
				+ follower + ", following=" + following + ", followerName=" + followerName + ", followerPicture="
				+ followerPicture + "]";
	}

}
