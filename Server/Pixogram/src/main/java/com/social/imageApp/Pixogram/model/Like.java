package com.social.imageApp.Pixogram.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "likes", schema = "pixogram")
public class Like {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	@Column(name = "mediaid")
	private int mediaId;

	@Column(name = "userid")
	private int userId;

	@Column(name = "likerid")
	private int likerId;

	@Column(name = "`like`")
	private char like;

	@Column(name = "likername")
	private String likerName;

	public Like() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Like(int id, int mediaId, int userId, int likerId, char like, String likerName) {
		super();
		this.id = id;
		this.mediaId = mediaId;
		this.userId = userId;
		this.likerId = likerId;
		this.like = like;
		this.likerName = likerName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMediaId() {
		return mediaId;
	}

	public void setMediaId(int mediaId) {
		this.mediaId = mediaId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getLikerId() {
		return likerId;
	}

	public void setLikerId(int likerId) {
		this.likerId = likerId;
	}

	public char getLike() {
		return like;
	}

	public void setLike(char like) {
		this.like = like;
	}

	public String getLikerName() {
		return likerName;
	}

	public void setLikerName(String likerName) {
		this.likerName = likerName;
	}

	@Override
	public String toString() {
		return "Like [id=" + id + ", mediaId=" + mediaId + ", userId=" + userId + ", likerId=" + likerId + ", like="
				+ like + ", likerName=" + likerName + "]";
	}

}
