package jp.co.aforce.bean;

import java.io.Serializable;

public class Bean implements Serializable {

	private String member_id;
	private String last_name;
	private String first_name;
	private String sex;
	private int birth_year;
	private int birth_month;
	private int birth_day;
	private String job;
	private String phone_number;
	private String mail_address;

	public Bean() {}

	public Bean(
			String last_name,
			String first_name,
			String sex,
			int birth_year,
			int birth_month,
			int birth_day,
			String job,
			String phone_number,
			String mailAddress) {
		this.last_name = last_name;
		this.first_name = first_name;
		this.sex = sex;
		this.birth_year = birth_year;
		this.birth_month = birth_month;
		this.birth_day = birth_day;
		this.job = job;
		this.phone_number = phone_number;
		this.mail_address = mailAddress;
	}

	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getBirth_year() {
		return birth_year;
	}
	public void setBirth_year(int birth_year) {
		this.birth_year = birth_year;
	}
	public int getBirth_month() {
		return birth_month;
	}
	public void setBirth_month(int birth_month) {
		this.birth_month = birth_month;
	}
	public int getBirth_day() {
		return birth_day;
	}
	public void setBirth_day(int birth_day) {
		this.birth_day = birth_day;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public String getMail_address() {
		return mail_address;
	}
	public void setMail_address(String mail_address) {
		this.mail_address = mail_address;
	}

}