package com.roadruwa.vo;

import java.util.Date;

public class UserVo extends BaseVO{
	private String uId;
	private String uPwd;
	private String uName; 
	private Integer uAge;/*
					 * String uType; String uImage;
					 */
	private String uPhone;
	private String uGender;
	private String uEmail;
	private String authkey;
	private Integer authstatus;

	private Date uReg;
	
	public String getuId() {
		return uId;
	}
	public void setuId(String uId) {
		this.uId = uId;
	}
	public String getuPwd() {
		return uPwd;
	}
	public void setuPwd(String uPwd) {
		this.uPwd = uPwd;
	}
	public String getuName() {
		return uName;
	}
	public void setuName(String uName) {
		this.uName = uName;
	}
	public Integer getuAge() {
		return uAge;
	}
	public void setuAge(Integer uAge) {
		this.uAge = uAge;
	}

	/*
	 * public String getuType() { return uType; } public void setuType(String uType)
	 * { this.uType = uType; } public String getuImage() { return uImage; } public
	 * void setuImage(String uImage) { this.uImage = uImage; }
	 */
	public String getuPhone() {
		return uPhone;
	}
	public void setuPhone(String uPhone) {
		this.uPhone = uPhone;
	}
	public String getuGender() {
		return uGender;
	}
	public void setuGender(String uGender) {
		this.uGender = uGender;
	}
	public String getuEmail() {
		return uEmail;
	}
	public void setuEmail(String uEmail) {
		this.uEmail = uEmail;
	}
	
	public String getAuthkey() {
		return authkey;
	}
	public void setAuthkey(String authkey) {
		this.authkey = authkey;
	}
	public Integer getAuthstatus() {
		return authstatus;
	}
	public void setAuthstatus(Integer authstatus) {
		this.authstatus = authstatus;
	}
	public Date getuReg() {
		return uReg;
	}
	public void setuReg(Date uReg) {
		this.uReg = uReg;
	}
}
