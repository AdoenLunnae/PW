package es.uco.pw.display.beans;

import java.io.Serializable;
import java.util.ArrayList;

public class ProfileBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private String mail, name, aboutMe, phone, base64Image, parsedAboutMe;
	private ArrayList<ExperienceBean> experiences;
	private ArrayList<ContactInfoBean> allContactInfo;

	public ProfileBean() {
		super();
	}

	public ProfileBean(String mail, String name, String aboutMe, String phone, String base64Image, String parsedAboutMe,
			ArrayList<ExperienceBean> experiences, ArrayList<ContactInfoBean> allContactInfo) {
		super();
		this.mail = mail;
		this.name = name;
		this.aboutMe = aboutMe;
		this.phone = phone;
		this.base64Image = base64Image;
		this.parsedAboutMe = parsedAboutMe;
		this.experiences = experiences;
		this.allContactInfo = allContactInfo;
	}

	public ArrayList<ExperienceBean> getExperiences() {
		return experiences;
	}

	public void setExperiences(ArrayList<ExperienceBean> experiences) {
		this.experiences = experiences;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAboutMe() {
		return aboutMe;
	}

	public void setAboutMe(String aboutMe) {
		this.aboutMe = aboutMe;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getBase64Image() {
		return base64Image;
	}

	public void setBase64Image(String base64Image) {
		this.base64Image = base64Image;
	}

	public String getParsedAboutMe() {
		return parsedAboutMe;
	}

	public void setParsedAboutMe(String parsedAboutMe) {
		this.parsedAboutMe = parsedAboutMe;
	}

	public ArrayList<ContactInfoBean> getAllContactInfo() {
		return allContactInfo;
	}

	public void setAllContactInfo(ArrayList<ContactInfoBean> allContactInfo) {
		this.allContactInfo = allContactInfo;
	}

}