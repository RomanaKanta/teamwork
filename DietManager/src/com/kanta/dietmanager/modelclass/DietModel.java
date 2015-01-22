package com.kanta.dietmanager.modelclass;

public class DietModel {
	int id;
	String feast;
	String menu;
	String date;
	String time;
	String alarm;

	public DietModel(String mfeast, String mmenu, String mdate, String mtime) {
		super();
		this.feast = mfeast;
		this.menu = mmenu;
		this.date = mdate;
		this.time = mtime;
	}

	public DietModel(int id, String mfeast, String mmenu, String mdate, String mtime) {
		super();
		this.id = id;
		this.feast = mfeast;
		this.menu = mmenu;
		this.date = mdate;
		this.time = mtime;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFeast() {
		return feast;
	}

	public void setFeast(String feast) {
		this.feast = feast;
	}

	public String getMenu() {
		return menu;
	}

	public void setMenu(String menu) {
		this.menu = menu;
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

	public String getAlarm() {
		return alarm;
	}

	public void setAlarm(String alarm) {
		this.alarm = alarm;
	}

	@Override
	public String toString() {
		return "DietModel [id=" + id + ", feast=" + feast + ", menu=" + menu
				+ ", date=" + date + ", time=" + time + ", alarm=" + alarm
				+ "]";
	}

	
	
}
