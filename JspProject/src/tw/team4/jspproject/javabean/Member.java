
package tw.team4.jspproject.javabean;

import java.io.InputStream;
import java.sql.Date;

public class Member {
	
	private int id;
	private String fullname;
	private String nickname;
	private String qid;
	private String mobile;
	private String country;
	private String city;
	private String address;
	private String email;
	private String password;
	private String mobileVerifCode;
	private String emaileVerifCode;
	private InputStream profileImage1;
	private InputStream profileImage2;
	private InputStream profileImage3;
	private boolean active;
	private Date createdDate;
	private Date modifieddDate;

	public Member(String fullname, String nickname,String qid, String email,String password) {
		this.fullname = fullname;
		this.nickname = nickname;
		this.qid = qid;
		this.email = email;
		this.password = password;
	}
	
	public Member() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getFullname() {
		return fullname;
	}


	public void setFullname(String fullname) {
		this.fullname = fullname;
	}


	public String getNickname() {
		return nickname;
	}


	public void setNickname(String nickname) {
		this.nickname = nickname;
	}


	public String getQid() {
		return qid;
	}


	public void setQid(String qid) {
		this.qid = qid;
	}


	public String getMobile() {
		return mobile;
	}


	public void setMobile(String mobile) {
		this.mobile = mobile;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getMobileVerifCode() {
		return mobileVerifCode;
	}


	public void setMobileVerifCode(String mobileVerifCode) {
		this.mobileVerifCode = mobileVerifCode;
	}


	public String getEmaileVerifCode() {
		return emaileVerifCode;
	}


	public void setEmaileVerifCode(String emaileVerifCode) {
		this.emaileVerifCode = emaileVerifCode;
	}


	public InputStream getProfileImage1() {
		return profileImage1;
	}


	public void setProfileImage1(InputStream profileImage1) {
		this.profileImage1 = profileImage1;
	}


	public InputStream getProfileImage2() {
		return profileImage2;
	}


	public void setProfileImage2(InputStream profileImage2) {
		this.profileImage2 = profileImage2;
	}


	public InputStream getProfileImage3() {
		return profileImage3;
	}


	public void setProfileImage3(InputStream profileImage3) {
		this.profileImage3 = profileImage3;
	}


	public boolean isActive() {
		return active;
	}


	public void setActive(boolean active) {
		this.active = active;
	}


	public Date getCreatedDate() {
		return createdDate;
	}


	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}


	public Date getModifieddDate() {
		return modifieddDate;
	}


	public void setModifieddDate(Date modifieddDate) {
		this.modifieddDate = modifieddDate;
	}

}
