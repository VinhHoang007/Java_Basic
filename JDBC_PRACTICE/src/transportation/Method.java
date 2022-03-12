package transportation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;



public class Method {
	public NhaCungCap inputNCC(Scanner sc) {
		NhaCungCap ncc = new NhaCungCap();
		System.out.print("MaNhaCC: ");
		ncc.setMaNhaCC(sc.nextLine());
		System.out.print("TenNhaCC: ");
		ncc.setTenNhaCC(sc.nextLine());
		System.out.print("DiaChi: ");
		ncc.setDiaChi(sc.nextLine());
		System.out.print("SoDT: ");
		ncc.setSoDT(sc.nextLine());
		System.out.print("MaSoTHue: ");
		ncc.setMaSoThue(sc.nextLine());
		return ncc;
	}
	
	public LoaiDichVu inputLDV(Scanner sc) {
		LoaiDichVu ldv = new LoaiDichVu();
		System.out.print("MaLoaiDV: ");
		ldv.setMaLoaiDV(sc.nextLine());
		System.out.print("TenLoaiDV: ");
		ldv.setTenLoaiDV(sc.nextLine());
		return ldv;
	}
	
	public MucPhi inputMP(Scanner sc) {
		MucPhi mp = new MucPhi();
		System.out.println("MaMP: ");
		mp.setMaMP(sc.nextLine());
		System.out.println("DonGia: ");
		mp.setDonGia(Double.parseDouble(sc.nextLine()));
		System.out.println("MoTa: ");
		mp.setMoTa(sc.nextLine());
		return mp;
	}
	public DongXe inputDX(Scanner sc) {
		DongXe dx = new DongXe();
		System.out.print("DongXe: ");
		dx.setDongXe(sc.nextLine());
		System.out.print("HangXe :");
		dx.setHangXe(sc.nextLine());
		System.out.print("SoChoNgoi: ");
		dx.setSoChoNgoi(Integer.parseInt(sc.nextLine()));
		return dx;
	}
	public DangKyCungCap inputDK(Scanner sc) {
		DangKyCungCap dk = new DangKyCungCap();
		System.out.print("MaDKCC: ");
		dk.setMaDKCC(sc.nextLine());
		System.out.print("MaNhaCC: ");
		dk.setMaNhaCC(sc.nextLine());
		System.out.print("MaLoaiDV: ");
		dk.setMaLoaiDV(sc.nextLine());
		System.out.print("DongXe: ");
		dk.setDongXe(sc.nextLine());
		System.out.print("MaMP: ");
		dk.setMaMP(sc.nextLine());
		System.out.print("Ngay Bat Dau Cung Cap: ");
		dk.setNgayBatDauCungCap(sc.nextLine());
		System.out.print("Ngay Ket Thuc Cung Cap: ");
		dk.setNgayKetThucCungCap(sc.nextLine());
		System.out.print("So Luong Xe Dang Ky: ");
		dk.setSoLuongXeDangKy(Integer.parseInt(sc.nextLine()));
		return dk;
	}
	public void insertNCC(Scanner sc, Connection conn, PreparedStatement pstmt) {
		NhaCungCap ncc = new NhaCungCap();
		ncc = inputNCC(sc);
		String sql = "Insert into NHACUNGCAP VALUES(?,?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,ncc.getMaNhaCC());
			pstmt.setString(2,ncc.getTenNhaCC());
			pstmt.setString(3,ncc.getDiaChi());
			pstmt.setString(4,ncc.getSoDT());
			pstmt.setString(5,ncc.getMaSoThue());
			pstmt.executeUpdate();
			System.out.println("Insert Successfull!!!");
		}catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt!= null) {
					pstmt.close();
				}
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		
	}
	
	public void insertLDV(Scanner sc, Connection conn, PreparedStatement pstmt) {
		LoaiDichVu ldv = new LoaiDichVu();
		ldv = inputLDV(sc);
		String sql = "insert into LOAIDICHVU values(?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ldv.getMaLoaiDV());
			pstmt.setString(2, ldv.getTenLoaiDV());
			pstmt.executeUpdate();
			System.out.println("Insert Successfully!!!");
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt!=null) {
					pstmt.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	public void insertMP(Scanner sc, Connection conn, PreparedStatement pstmt) {
		MucPhi mp = new MucPhi();
		mp = inputMP(sc);
		String sql = "insert into MUCPHI values(?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mp.getMaMP());
			pstmt.setDouble(2, mp.getDonGia());
			pstmt.setString(3, mp.getMoTa());
			pstmt.executeUpdate();
			System.out.println("Insert Successfully!!!");
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt!=null) {
					pstmt.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	public void insertDX(Scanner sc, Connection conn, PreparedStatement pstmt) {
		DongXe dx = new DongXe();
		dx = inputDX(sc);
		String sql = "insert into DONGXE values(?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dx.getDongXe());
			pstmt.setString(2, dx.getHangXe());
			pstmt.setInt(3, dx.getSoChoNgoi());
			pstmt.executeUpdate();
			System.out.println("Insert Successfully!!!");
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt!=null) {
					pstmt.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	public void insertDK(Scanner sc, Connection conn, PreparedStatement pstmt) {
		DangKyCungCap dk = new DangKyCungCap();
		dk = inputDK(sc);
		String sql = "insert into DANGKYCUNGCAP values(?,?,?,?,?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dk.getMaDKCC());
			pstmt.setString(2, dk.getMaNhaCC());
			pstmt.setString(3, dk.getMaLoaiDV());
			pstmt.setString(4, dk.getDongXe());
			pstmt.setString(5,dk.getMaMP());
			pstmt.setString(6,dk.getNgayBatDauCungCap());
			pstmt.setString(7,dk.getNgayKetThucCungCap());
			pstmt.setInt(8,dk.getSoLuongXeDangKy());
			pstmt.executeUpdate();
			System.out.println("Insert Successfully!!!");
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt!=null) {
					pstmt.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	public void select1(Scanner sc, Connection conn, PreparedStatement pstmt) {
		DongXe dx;
//		Liệt kê những dòng xe có số chỗ ngồi trên 5 chỗ
		String sql = "select dongxe,sochongoi from dongxe where SoChoNgoi>5";
		
		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
//			ArrayList<DongXe> list = new ArrayList<DongXe>();
			
			while(rs.next()) {
				dx = new DongXe();
				System.out.printf("%10s | %5d\n",rs.getString("dongxe"),rs.getInt("sochongoi"));
				dx.setDongXe(rs.getString("dongxe"));
				dx.setSoChoNgoi(rs.getInt("sochongoi"));
//				list.add(dx);
			}
//			for(DongXe value: list) {
//				System.out.printf("%10s | %5d\n",value.getDongXe(),value.getSoChoNgoi());
//			}
//			System.out.println(check);
			
		}catch (SQLException se) {
			se.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void select2(Scanner sc, Connection conn, PreparedStatement pstmt) {
		/*Liệt kê thông tin của các nhà cung cấp đã từng đăng ký cung cấp những dòng xe
		thuộc hãng xe “Toyota” với mức phí có đơn giá là 15.000 VNĐ/km hoặc những dòng xe
		thuộc hãng xe “KIA” với mức phí có đơn giá là 20.000 VNĐ/km*/
		String sql = "select NHACUNGCAP.TenNhaCC, NHACUNGCAP.MaNhaCC \r\n"
				+ "from NHACUNGCAP, DANGKYCUNGCAP, DONGXE, MUCPHI\r\n"
				+ "where NHACUNGCAP.MaNhaCC = DANGKYCUNGCAP.MaNhaCC and DANGKYCUNGCAP.DongXe = DongXe.DongXe and DANGKYCUNGCAP.MaMP = MUCPHI.MaMP\r\n"
				+ "and ((DONGXE.HangXe = 'Toyota' and MUCPHI.DonGia = 15000) or (DONGXE.HangXe = 'KIA' and MUCPHI.DonGia = 20000));";
		
		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				System.out.printf("%-10s | %-10s\n",rs.getString("MaNhaCC"),rs.getString("TenNhaCC"));
			}
			
		}catch (SQLException se) {
			se.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void select3(Scanner sc, Connection conn, PreparedStatement pstmt) {
		/*Liệt kê thông tin toàn bộ nhà cung cấp được sắp xếp tăng dần theo tên nhà cung
		cấp và giảm dần theo mã số thuế*/
		String sql = "select MaNhaCC, TenNhaCC, MaSoThue \n"
				+ "from NHACUNGCAP\n"
				+ "order by TenNhaCC asc, MaSoThue desc";
		
		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				System.out.printf("%-10s | %-30s |%-10s\n",rs.getString("MaNhaCC"),rs.getString("TenNhaCC"),rs.getString("MaSoThue"));
			}
			
		}catch (SQLException se) {
			se.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}


