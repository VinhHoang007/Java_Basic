package transportation;

public class DangKyCungCap {
	private String maDKCC;
	private String maNhaCC;
	private String maLoaiDV;
	private String dongXe;
	private String maMP;
	private String ngayBatDauCungCap;
	private String ngayKetThucCungCap;
	private int soLuongXeDangKy;
	public String getMaDKCC() {
		return maDKCC;
	}
	public void setMaDKCC(String maDKCC) {
		this.maDKCC = maDKCC;
	}
	public String getMaNhaCC() {
		return maNhaCC;
	}
	public void setMaNhaCC(String maNhaCC) {
		this.maNhaCC = maNhaCC;
	}
	public String getMaLoaiDV() {
		return maLoaiDV;
	}
	public void setMaLoaiDV(String maLoaiDV) {
		this.maLoaiDV = maLoaiDV;
	}
	public String getDongXe() {
		return dongXe;
	}
	public void setDongXe(String dongXe) {
		this.dongXe = dongXe;
	}
	public String getMaMP() {
		return maMP;
	}
	public void setMaMP(String maMP) {
		this.maMP = maMP;
	}
	public String getNgayBatDauCungCap() {
		return ngayBatDauCungCap;
	}
	public void setNgayBatDauCungCap(String ngayBatDauCungCap) {
		this.ngayBatDauCungCap = ngayBatDauCungCap;
	}
	public String getNgayKetThucCungCap() {
		return ngayKetThucCungCap;
	}
	public void setNgayKetThucCungCap(String ngayKetThucCungCap) {
		this.ngayKetThucCungCap = ngayKetThucCungCap;
	}
	public int getSoLuongXeDangKy() {
		return soLuongXeDangKy;
	}
	public void setSoLuongXeDangKy(int soLuongXeDangKy) {
		this.soLuongXeDangKy = soLuongXeDangKy;
	}
	public DangKyCungCap(String maDKCC, String maNhaCC,String maLoaiDV, String dongXe, String maMP, String ngayBatDauCungCap,
			String ngayKetThucCungCap, int soLuongXeDangKy) {
		this.maDKCC = maDKCC;
		this.maNhaCC = maNhaCC;
		this.maLoaiDV = maLoaiDV;
		this.dongXe = dongXe;
		this.maMP = maMP;
		this.ngayBatDauCungCap = ngayBatDauCungCap;
		this.ngayKetThucCungCap = ngayKetThucCungCap;
		this.soLuongXeDangKy = soLuongXeDangKy;
	}
	public DangKyCungCap() {
	}
	
	
}
