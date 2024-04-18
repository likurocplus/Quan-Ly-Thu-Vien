package model;

import java.io.Serializable;

public class Bao extends TaiLieu implements ITaiLieu,Serializable {
	private String ngayPH; //dd/mm/yy
	
	//Contructor
	public Bao(String maTaiLieu, String nxbTaiLieu, int soBanPH, String ngayPH) {
		super(maTaiLieu, nxbTaiLieu, soBanPH);
		this.ngayPH = ngayPH;
	}
	//Getter Setter

	public String getNgayPH() {
		return ngayPH;
	}

	public void setNgayPH(String ngayPH) {
		this.ngayPH = ngayPH;
	}
	
	//Method
	@Override
	public String getCode() {
		String code = this.getMaTaiLieu() + this.ngayPH.substring(this.ngayPH.lastIndexOf('/'));
		return code;
	}
	@Override
	public String toString() {
		return getMaTaiLieu()+"\t" + getNxbTaiLieu() +"\t" +getSoBanPH() +"\t" + ngayPH + "\t";
	}
	
	
}
