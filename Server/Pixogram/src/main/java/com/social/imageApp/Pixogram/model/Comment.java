package com.social.imageApp.Pixogram.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "comments", schema = "pixogram")
public class Comment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	@Column(name = "userid")
	private int userId;

	@Column(name = "mediaid")
	private int mediaId;

	@Column(name = "commentorid")
	private int commentorId;

	@Column(name = "commentorname")
	private String commentorName;

	@Column(name = "comment")
	private String comment;

	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Comment(int id, int userId, int mediaId, int commentorId, String commentorName, String comment) {
		super();
		this.id = id;
		this.userId = userId;
		this.mediaId = mediaId;
		this.commentorId = commentorId;
		this.commentorName = commentorName;
		this.comment = comment;
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

	public int getMediaId() {
		return mediaId;
	}

	public void setMediaId(int mediaId) {
		this.mediaId = mediaId;
	}

	public int getCommentorId() {
		return commentorId;
	}

	public void setCommentorId(int commentorId) {
		this.commentorId = commentorId;
	}

	public String getCommentorName() {
		return commentorName;
	}

	public void setCommentorName(String commentorName) {
		this.commentorName = commentorName;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public String toString() {
		return "Comment [id=" + id + ", userId=" + userId + ", mediaId=" + mediaId + ", commentorId=" + commentorId
				+ ", commentorName=" + commentorName + ", comment=" + comment + "]";
	}

}
