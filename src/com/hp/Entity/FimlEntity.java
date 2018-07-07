package com.hp.Entity;

public class FimlEntity {
	int fid;
	String fname;
	 String fauto;
	String  ontime;
	String  fremark;
	 int fflag;  //是否能正常放映1.正常 0.禁止
	 FsortEntity fsort;
	public int getFid() {
		return fid;
	}
	public void setFid(int fid) {
		this.fid = fid;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getFauto() {
		return fauto;
	}
	public void setFauto(String fauto) {
		this.fauto = fauto;
	}
	public String getOntime() {
		return ontime;
	}
	public void setOntime(String ontime) {
		this.ontime = ontime;
	}
	public String getFremark() {
		return fremark;
	}
	public void setFremark(String fremark) {
		this.fremark = fremark;
	}
	public int getFflag() {
		return fflag;
	}
	public void setFflag(int fflag) {
		this.fflag = fflag;
	}
	public FsortEntity getFsort() {
		return fsort;
	}
	public void setFsort(FsortEntity fsort) {
		this.fsort = fsort;
	}

}
