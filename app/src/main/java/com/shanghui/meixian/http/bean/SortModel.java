package com.shanghui.meixian.http.bean;

import com.shanghui.meixian.sort.AreaBean;

import java.util.List;

public class SortModel {

	private String id;//用于返回的id

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	private String name;   //显示的数据
	private String sortLetters;  //显示数据拼音的首字母

	private List<AreaBean> been;

	public List<AreaBean> getBeen() {
		return been;
	}

	public void setBeen(List<AreaBean> been) {
		this.been = been;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSortLetters() {
		return sortLetters;
	}
	public void setSortLetters(String sortLetters) {
		this.sortLetters = sortLetters;
	}
}
