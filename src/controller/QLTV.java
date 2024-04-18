package controller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import model.*;

public class QLTV implements ChucNang {
	List<TaiLieu> list = null;

	Scanner sc = new Scanner(System.in);

	// Contructor
	public QLTV() {
		list = new ArrayList<>();
	}

	// Method
	public int isExist(String maTaiLieu) {
		for (int i = 0; i < list.size(); i++) {
			if (maTaiLieu.equalsIgnoreCase(list.get(i).getMaTaiLieu())) {
				return i;
			}
		}
		return -1;
	}

	private TaiLieu nhapChung() {
		String maTaiLieu, nxbTaiLieu;
		int soBanPH;

		while (true) {
			System.out.println("Hãy nhập mã tài liệu");
			String re = "^[ABCD]{1}\\d{3}$";
			maTaiLieu = sc.nextLine();
			try {
				if ((maTaiLieu.matches(re) == true) && (isExist(maTaiLieu) == -1)) {
					break;
				} else {
					throw new InvalidException("Mã đã tồn tại hoặc nhập không đúng định dạng");
				}
			} catch (InvalidException ie) {
				// TODO: handle exception
				System.err.println(ie);
			}
		}
		while (true) {
			System.out.println("Hãy nhập nhà xuất bản: ");
			String re = "[A-Za-z0-9 ]+";
			nxbTaiLieu = sc.nextLine();
			try {
				if (nxbTaiLieu.matches(re) == true) {
					break;
				} else {
					throw new InvalidException("NXB nhập không đúng định dạng");
				}
			} catch (InvalidException ie) {
				// TODO: handle exception
				System.err.println(ie);
			}
		}

		while (true) {
			System.out.println("Hãy nhập số bản được phát hành");
			String re = "\\d+";
			String tmp = sc.nextLine();
			try {
				if (tmp.matches(re) == true) {
					soBanPH = Integer.parseInt(tmp);
					break;
				} else {
					throw new InvalidException("Đã nhập số bản phát hành không đúng định dạng");
				}
			} catch (InvalidException ie) {
				// TODO: handle exception
				System.err.println(ie);
			}
		}
		TaiLieu tmp = new TaiLieu(maTaiLieu, nxbTaiLieu, soBanPH);
		return tmp;
	}

	@Override
	public void nhapSach() {
		String tenTacGia, tenSach;
		int soTrang;
		// TODO Auto-generated method

		TaiLieu tmp = nhapChung();
		System.out.println("Hãy nhập tên tác giả");
		tenTacGia = sc.nextLine();
		System.out.println("Hãy nhập tên sách");
		tenSach = sc.nextLine();
		while (true) {
			System.out.println("Hãy nhập số trang");
			String re = "\\d+";
			String tmp1 = sc.nextLine();
			try {
				if (tmp1.matches(re) == true) {
					soTrang = Integer.parseInt(tmp1);
					break;
				} else {
					throw new InvalidException("Đã số trang sách không đúng định dạng");
				}
			} catch (InvalidException ie) {
				// TODO: handle exception
				System.err.println(ie);
			}
		}

		list.add(new Sach(tmp.getMaTaiLieu(), tmp.getNxbTaiLieu(), tmp.getSoBanPH(), tenTacGia, tenSach, soTrang));
	}

	@Override
	public void nhapBao() {
		// TODO Auto-generated method stub
		TaiLieu tmp = nhapChung();
		String ngayPH;
		while (true) {
			System.out.println("Hãy nhập ngày phát hành theo định dạng dd/mm/yyyy");
			String re = "^\\d{2}/\\d{2}/\\d{4}$";
			ngayPH = sc.nextLine();

			try {
				if (ngayPH.matches(re) == true) {
					break;
				} else {
					throw new InvalidException("Nhập định dạng ngày tháng sai");
				}
			} catch (InvalidException ie) {
				// TODO: handle exception
				System.err.println(ie);
			}
		}
		list.add(new Bao(tmp.getMaTaiLieu(), tmp.getNxbTaiLieu(), tmp.getSoBanPH(), ngayPH));
	}

	@Override
	public void hienThiDanhSach() {
		// TODO Auto-generated method stub
		for (TaiLieu i : list) {
			System.out.println(i);
		}
		System.out.println("Tổng số tài liệu hiện tại là: " + list.size());
	}

	@Override
	public void suaTaiLieu() {
		// TODO Auto-generated method stub
		System.out.println("Hãy nhập mã tài liệu muốn sửa");
		String ma;
		ma = sc.nextLine();
		int vitri = isExist(ma);
		while (true) {
			try {
				if (vitri == -1) {
					throw new InvalidException("Mã này không tồn tại");
				} else {
					break;
				}
			} catch (InvalidException e) {
				System.err.println(e);
			}
		}
		// TaiLieu
		TaiLieu t = list.get(vitri);
		System.out.println("Hãy điền lại các thông tin");
		// Sua Chung
		String nxbTaiLieu;
		int soBanPH;
		while (true) {
			System.out.println("Hãy nhập nhà xuất bản: ");
			String re = "[A-Za-z0-9 ]+";
			nxbTaiLieu = sc.nextLine();
			try {
				if (nxbTaiLieu.matches(re) == true) {
					break;
				} else {
					throw new InvalidException("NXB nhập không đúng định dạng");
				}
			} catch (InvalidException ie) {
				// TODO: handle exception
				System.err.println(ie);
			}
		}

		while (true) {
			System.out.println("Hãy nhập số bản được phát hành");
			String re = "\\d+";
			String tmp = sc.nextLine();
			try {
				if (tmp.matches(re) == true) {
					soBanPH = Integer.parseInt(tmp);
					break;
				} else {
					throw new InvalidException("Đã nhập số bản phát hành không đúng định dạng");
				}
			} catch (InvalidException ie) {
				// TODO: handle exception
				System.err.println(ie);
			}
		}

		t.setNxbTaiLieu(nxbTaiLieu);
		t.setSoBanPH(soBanPH);

		if (list.get(vitri) instanceof Sach) {
			String tenTacGia, tenSach;
			int soTrang;
			// TODO Auto-generated method stub
			System.out.println("Hãy nhập tên tác giả");
			tenTacGia = sc.nextLine();
			System.out.println("Hãy nhập tên sách");
			tenSach = sc.nextLine();
			while (true) {
				System.out.println("Hãy nhập số trang");
				String re = "\\d+";
				String tmp1 = sc.nextLine();
				try {
					if (tmp1.matches(re) == true) {
						soTrang = Integer.parseInt(tmp1);
						break;
					} else {
						throw new InvalidException("Đã số trang sách không đúng định dạng");
					}
				} catch (InvalidException ie) {
					// TODO: handle exception
					System.err.println(ie);
				}
			}
			((Sach) t).setTenSach(tenSach);
			((Sach) t).setTenTacGia(tenTacGia);
			((Sach) t).setSoTrang(soTrang);
		} else {
			String ngayPH;
			while (true) {
				System.out.println("Hãy nhập ngày phát hành theo định dạng dd/mm/yyyy");
				String re = "^\\d{2}/\\d{2}/\\d{4}$";
				ngayPH = sc.nextLine();

				try {
					if (ngayPH.matches(re) == true) {
						break;
					} else {
						throw new InvalidException("Nhập định dạng ngày tháng sai");
					}
				} catch (InvalidException ie) {
					// TODO: handle exception
					System.err.println(ie);
				}
			}
			((Bao) t).setNgayPH(ngayPH);
		}
	}

	@Override
	public void xoaTaiLieu() {
		System.out.println("Hãy nhập mã tài liệu muốn xóa:");
		String ma = sc.nextLine();
		int vitri = isExist(ma); // Kiểm tra xem mã tài liệu có tồn tại không

		try {
			if (vitri == -1) {
				throw new InvalidException("Mã này không tồn tại");
			} else {
				list.remove(vitri); // Xóa tài liệu tại vị trí đã tìm thấy
				System.out.println("Tài liệu đã được xóa thành công.");
			}
		} catch (InvalidException e) {
			// Xử lý ngoại lệ
			System.err.println(e);
		}
	}

	@Override
	public void docTuFile(String file) {
		// TODO Auto-generated method stub
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
			list = (List<TaiLieu>) in.readObject();
			in.close();
		} catch (IOException ioe) {
			// TODO: handle exception
			System.err.println(ioe);
		} catch (ClassNotFoundException cnfe) {

			System.err.println(cnfe);
		}

	}

	@Override
	public void luuVaoFile(String file) {
		// TODO Auto-generated method stub
		try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
			out.writeObject(list);
			out.close();
		} catch (IOException e) {
			// TODO: handle exception
			System.err.println(e);
		}

	}

	@Override
	public void timSachTheoTen() {
		// TODO Auto-generated method stub
		System.out.println("Hãy nhập tên sách muốn tìm kiếm: ");
		String name = sc.nextLine();
		for (TaiLieu i : list) {
			if (i instanceof Sach) {
				if (((Sach) i).getTenSach().toLowerCase().equalsIgnoreCase(name.toLowerCase()) == true) {
					System.out.println(i);
				}
			} else {
				continue;
			}
		}
	}

	@Override
	public void timBaoTheoNam() {
		// TODO Auto-generated method stub
		String a,b;
		while (true) {
			System.out.println("Tìm từ năm yyyy: ");
			String re = "^\\d{4}$";
			a = sc.nextLine();
			try {
				if (a.matches(re) == true) {
					break;
				} else {
					throw new InvalidException("Nhập định dạng năm sai");
				}
			} catch (InvalidException ie) {
				// TODO: handle exception
				System.err.println(ie);
			}
		}
		while (true) {
			System.out.println("Đến năm yyyy: ");
			String re = "^\\d{4}$";
			b = sc.nextLine();
			try {
				if (b.matches(re) == true) {
					break;
				} else {
					throw new InvalidException("Nhập định dạng năm sai");
				}
			} catch (InvalidException ie) {
				// TODO: handle exception
				System.err.println(ie);
			}
		}
		for(TaiLieu i : list) {
			if(i instanceof Bao) {
				int y = Integer.parseInt(((Bao) i).getNgayPH().substring(((Bao) i).getNgayPH().lastIndexOf("/")+1));
				if(Integer.parseInt(a) <= y && y <= Integer.parseInt(b)) {
					System.out.println(i);
				}
			} else {
				continue;
			}
		}
	}

	@Override
	public void sapXepTheoSoBanPH() {
		// TODO Auto-generated method stub
		Collections.sort(list, new Comparator<TaiLieu>() {
			@Override
			public int compare(TaiLieu o1, TaiLieu o2) {
				// TODO Auto-generated method stub
				return o1.getSoBanPH() - o2.getSoBanPH();
			}
		});
		this.hienThiDanhSach();
	}

	@Override
	public void sapXepTheoTenTG() {
		// TODO Auto-generated method stub
		List<Sach> listSach = new ArrayList<>();
		
		for(TaiLieu i : list) {
			if(i instanceof Sach) {
				listSach.add(((Sach) i));
			}
		}
		
		Collections.sort(listSach,new Comparator<Sach>() {
			@Override
			public int compare(Sach o1, Sach o2) {
				// TODO Auto-generated method stub
				String t1 =o1.getTenTacGia();
				String t2 = o2.getTenTacGia();
				String tenTG1 = t1.substring(t1.lastIndexOf(" ")+1) + t1;
				String tenTG2 = t2.substring(t2.lastIndexOf(" ")+1) + t2;
				return tenTG1.compareToIgnoreCase(tenTG2);
			}
		});
		
		for(Sach i : listSach) {
			System.out.println(i);
		}
	}

	@Override
	public void sapXepBaoTheoBanPHNgayPH() {
		// TODO Auto-generated method stub
		List<Bao> listBao = new ArrayList<>();
		for(TaiLieu i : list) {
			if(i instanceof Bao) {
				listBao.add(((Bao)i));
			}
		}
		//Comparator
		Collections.sort(listBao,new Comparator<>() {
			@Override
			public int compare(Bao o1, Bao o2) {
				if(o1.getSoBanPH() - o2.getSoBanPH() > 0) {
					return -1;
				}
				else if (o1.getSoBanPH() == o2.getSoBanPH()){
					return Integer.parseInt(o1.getNgayPH().substring(o1.getNgayPH().lastIndexOf("/")+1))- Integer.parseInt(o2.getNgayPH().substring(o2.getNgayPH().lastIndexOf("/")+1)) ;
				}
				return 1;
			}	
		});
		
		//In ra
		for(Bao i:listBao) {
			System.out.println(i);
		}
		
	}

	@Override
	public void tinhSoDauSachBaoTheoNXB() {
		// TODO Auto-generated method stub

	}

	@Override
	public void tongSoBaoPHTheoNam() {
		// TODO Auto-generated method stub

	}

}
