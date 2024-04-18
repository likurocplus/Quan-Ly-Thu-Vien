package model;

import java.io.Serializable;

public class TaiLieu implements Serializable {
	private String maTaiLieu;
	private String nxbTaiLieu;
	private int soBanPH;
	
	public TaiLieu(String maTaiLieu, String nxbTaiLieu, int soBanPH) {
		this.maTaiLieu = maTaiLieu;
		this.nxbTaiLieu = nxbTaiLieu;
		this.soBanPH = soBanPH;
	}

	public String getMaTaiLieu() {
		return maTaiLieu;
	}

	public void setMaTaiLieu(String maTaiLieu) {
		this.maTaiLieu = maTaiLieu;
	}

	public String getNxbTaiLieu() {
		return nxbTaiLieu;
	}

	public void setNxbTaiLieu(String nxbTaiLieu) {
		this.nxbTaiLieu = nxbTaiLieu;
	}

	public int getSoBanPH() {
		return soBanPH;
	}

	public void setSoBanPH(int soBanPH) {
		this.soBanPH = soBanPH;
	}

	@Override
	public String toString() {
		return  maTaiLieu + "\t" + nxbTaiLieu + "\t" + soBanPH + "\t";
	}
	
	
	
}
