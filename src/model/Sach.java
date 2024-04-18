package model;

import java.io.Serializable;
import java.util.StringTokenizer;

public class Sach extends TaiLieu implements ITaiLieu, Serializable {
	private String tenTacGia;
	private String tenSach;
	private int soTrang;
	
	//Contructor
	
	public Sach(String maTaiLieu, String nxbTaiLieu, int soBanPH, String tenTacGia, String tenSach, int soTrang) {
		super(maTaiLieu, nxbTaiLieu, soBanPH);
		this.tenTacGia = tenTacGia;
		this.tenSach = tenSach;
		this.soTrang = soTrang;
	}
	
	//Getter Setter

	public String getTenTacGia() {
		return tenTacGia;
	}

	public void setTenTacGia(String tenTacGia) {
		this.tenTacGia = tenTacGia;
	}

	public String getTenSach() {
		return tenSach;
	}

	public void setTenSach(String tenSach) {
		this.tenSach = tenSach;
	}

	public int getSoTrang() {
		return soTrang;
	}

	public void setSoTrang(int soTrang) {
		this.soTrang = soTrang;
	}	
	
	// Method
	
	@Override
	public String getCode() {
		StringTokenizer strtoken = new StringTokenizer(this.tenSach," ");
		String kiTuDau = "";
		while(strtoken.hasMoreTokens()) {
			String token = strtoken.nextToken();
			kiTuDau += token.charAt(0);
		}
		String code = this.getMaTaiLieu() + kiTuDau;
		return code;
	}

	@Override
	public String toString() {
		return getMaTaiLieu()+"\t" + getNxbTaiLieu() +"\t" +getSoBanPH() +"\t" +  tenTacGia + "\t" + tenSach + "\t" + soTrang;
	}
	
}
