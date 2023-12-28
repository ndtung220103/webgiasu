package com.webgiasu.dto;

public class LopDTO extends BaseDTO {
	private String trinhdo;
	private String monday;
	private String hinhthuc;
	private String diadiem;
	private String thoigian;
	private String mucluong;
	private String ttkhac;
	private Boolean status;
	private Long Id_Nguoitao;
	private Long Id_Nguoinhan;
	
	
	public String getTrinhdo() {
		return trinhdo;
	}
	public void setTrinhdo(String trinhdo) {
		this.trinhdo = trinhdo;
	}
	public String getMonday() {
		return monday;
	}
	public void setMonday(String monday) {
		this.monday = monday;
	}
	public String getHinhthuc() {
		return hinhthuc;
	}
	public void setHinhthuc(String hinhthuc) {
		this.hinhthuc = hinhthuc;
	}
	public String getDiadiem() {
		return diadiem;
	}
	public void setDiadiem(String diadiem) {
		this.diadiem = diadiem;
	}
	public String getThoigian() {
		return thoigian;
	}
	public void setThoigian(String thoigian) {
		this.thoigian = thoigian;
	}
	public String getMucluong() {
		return mucluong;
	}
	public void setMucluong(String mucluong) {
		this.mucluong = mucluong;
	}
	public String getTtkhac() {
		return ttkhac;
	}
	public void setTtkhac(String ttkhac) {
		this.ttkhac = ttkhac;
	}
	
	public Long getId_Nguoitao() {
		return Id_Nguoitao;
	}
	public void setId_Nguoitao(Long id_Nguoitao) {
		Id_Nguoitao = id_Nguoitao;
	}
	public Long getId_Nguoinhan() {
		return Id_Nguoinhan;
	}
	public void setId_Nguoinhan(Long id_Nguoinhan) {
		Id_Nguoinhan = id_Nguoinhan;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	
	
}
