package views;
import java.util.Scanner;

import controller.*;
import model.*;

public class Menu {
	public static void main(String[] args) {
		
		QLTV ql = new QLTV();
		Scanner sc = new Scanner(System.in);
		String file = "ThuVienData.txt";
		int c;
		while(true) {
			System.out.println("----------------Menu------------------");
			System.out.println("1. Nhập sách vào thư viện");
			System.out.println("2. Nhập báo vào thư viện");
			System.out.println("3. Hiển thị danh sách có tính tổng");
			System.out.println("4. Sửa 1 tài liệu( sách hoặc mã ) - khi gõ mã");
			System.out.println("5. Xóa 1 tài liệu khỏi thư viện");
			System.out.println("6. Lưu thư viện tạm thời vào file");
			System.out.println("7. Đọc thư viện từ file ra");
			System.out.println("8. Tìm sách theo tên sách");
			System.out.println("9. Tìm báo từ năm ... đến năm ...");
			System.out.println("10. Sắp xếp theo số bản phát hành tăng dần");
			System.out.println("11. Sắp xếp sách theo tên tác giả");
			System.out.println("12. Sắp xếp theo ngày phát hành và số bản phát hành");
			System.out.println("13. Tính số đầu sách và báo theo nhà xuất bản");
			System.out.println("14. Tổng số báo phát hành theo từng năm");
			System.out.println("15. Thoát khỏi chương trình");
			
			c = sc.nextInt();
			
			switch (c) {
			case 1: {
				ql.nhapSach();
				break;
			}
			case 2: {
				ql.nhapBao();
				break;
			}
			case 3: {
				ql.hienThiDanhSach();
				break;
			}
			case 4: {
				ql.suaTaiLieu();
				break;
			}
			case 5: {
				ql.xoaTaiLieu();
				break;
			}
			case 6: {
				ql.luuVaoFile(file);
				break;
			}
			case 7: {
				ql.docTuFile(file);
				break;
			}
			case 8: {
				ql.timSachTheoTen();
				break;
			}
			case 9: {
				ql.timBaoTheoNam();
				break;
			}
			case 10: {
				ql.sapXepTheoSoBanPH();
				break;
			}
			case 11: {
				ql.sapXepTheoTenTG();
				break;
			}
			case 12: {
				ql.sapXepBaoTheoBanPHNgayPH();
				break;
			}
			case 13: {
				
				break;
			}
			case 14: {
				
				break;
			}
			case 15: {
				System.out.println("Cảm ơn bạn đã dùng chương trình hẹn gặp lại");
				System.exit(0);
				break;
			}
			default:
				System.out.println("Chọn không đúng vui lòng chọn lại");
			}
		}
	}
}
