package transportation;

public class NhaCungCap {
	private String maNhaCC;
	private String tenNhaCC;
	private String diaChi;
	private String soDT;
	private String maSoThue;
	public String getMaNhaCC() {
		return maNhaCC;
	}
	public void setMaNhaCC(String maNhaCC) {
		this.maNhaCC = maNhaCC;
	}
	public String getTenNhaCC() {
		return tenNhaCC;
	}
	public void setTenNhaCC(String tenNhaCC) {
		this.tenNhaCC = tenNhaCC;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getSoDT() {
		return soDT;
	}
	public void setSoDT(String soDT) {
		this.soDT = soDT;
	}
	public String getMaSoThue() {
		return maSoThue;
	}
	public void setMaSoThue(String maSoThue) {
		this.maSoThue = maSoThue;
	}
	public NhaCungCap(String maNhaCC, String tenNhaCC, String diaChi, String soDT, String maSoThue) {
		super();
		this.maNhaCC = maNhaCC;
		this.tenNhaCC = tenNhaCC;
		this.diaChi = diaChi;
		this.soDT = soDT;
		this.maSoThue = maSoThue;
	}
	public NhaCungCap() {

	}
	
	
}
