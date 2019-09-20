package com.social.imageApp.Pixogram.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "media", schema = "pixogram")
public class Media {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int mediaId;

	@Column(name = "title")
	private String title;

	@Column(name = "type")
	private String type;

	@Column(name = "poster")
	private String poster;

	@Column(name = "description")
	private String description;

	@Column(name = "effect")
	private String effect;

	@Column(name = "fileName")
	private String fileName;

	@Column(name = "fileType")
	private String fileType;

	@Column(name = "fileSize")
	private String fileSize;

	@Column(name = "uploadDate")
	private String uploadDate;

	@Column(name = "uploadTime")
	private String uploadTime;

	@Column(name = "defaultProfile")
	private int defaultProfile;

	@Column(name = "likes")
	private int likes;

	@Column(name = "unlikes")
	private int unlikes;

	@Column(name = "shares")
	private int shares;

	@Column(name = "numberofcomments")
	private int numberOfComments;

	@Column(name = "userid")
	private int userId;

	@Column(name = "username")
	private String userName;

	public Media() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Media(int id, String title, String type, String poster, String description, String effect, String fileName,
			String fileType, String fileSize, String uploadDate, String uploadTime, int defaultProfile, int likes,
			int unlikes, int shares, int numberOfComments, int userId, String userName) {
		super();
		this.mediaId = id;
		this.title = title;
		this.type = type;
		this.poster = poster;
		this.description = description;
		this.effect = effect;
		this.fileName = fileName;
		this.fileType = fileType;
		this.fileSize = fileSize;
		this.uploadDate = uploadDate;
		this.uploadTime = uploadTime;
		this.defaultProfile = defaultProfile;
		this.likes = likes;
		this.unlikes = unlikes;
		this.shares = shares;
		this.numberOfComments = numberOfComments;
		this.userId = userId;
		this.userName = userName;
	}

	public int getMediaId() {
		return mediaId;
	}

	public void setMediaId(int id) {
		this.mediaId = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEffect() {
		return effect;
	}

	public void setEffect(String effect) {
		this.effect = effect;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public String getFileSize() {
		return fileSize;
	}

	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}

	public String getUploadDate() {
		return uploadDate;
	}

	public void setUploadDate(String uploadDate) {
		this.uploadDate = uploadDate;
	}

	public String getUploadTime() {
		return uploadTime;
	}

	public void setUploadTime(String uploadTime) {
		this.uploadTime = uploadTime;
	}

	public int getDefaultProfile() {
		return defaultProfile;
	}

	public void setDefaultProfile(int defaultProfile) {
		this.defaultProfile = defaultProfile;
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

	public int getUnlikes() {
		return unlikes;
	}

	public void setUnlikes(int unlikes) {
		this.unlikes = unlikes;
	}

	public int getShares() {
		return shares;
	}

	public void setShares(int shares) {
		this.shares = shares;
	}

	public int getNumberOfComments() {
		return numberOfComments;
	}

	public void setNumberOfComments(int numberOfComments) {
		this.numberOfComments = numberOfComments;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "Media [id=" + mediaId + ", title=" + title + ", type=" + type + ", poster=" + poster + ", description="
				+ description + ", effect=" + effect + ", fileName=" + fileName + ", fileType=" + fileType
				+ ", fileSize=" + fileSize + ", uploadDate=" + uploadDate + ", uploadTime=" + uploadTime
				+ ", defaultProfile=" + defaultProfile + ", likes=" + likes + ", unlikes=" + unlikes + ", shares="
				+ shares + ", numberOfComments=" + numberOfComments + ", userId=" + userId + ", userName=" + userName
				+ "]";
	}

}
