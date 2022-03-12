package transportation;

public class LoaiDichVu {
	private String maLoaiDV;
	private String tenLoaiDV;
	public String getMaLoaiDV() {
		return maLoaiDV;
	}
	public void setMaLoaiDV(String maLoaiDV) {
		this.maLoaiDV = maLoaiDV;
	}
	public String getTenLoaiDV() {
		return tenLoaiDV;
	}
	public void setTenLoaiDV(String tenLoaiDV) {
		this.tenLoaiDV = tenLoaiDV;
	}
	public LoaiDichVu(String maLoaiDV, String tenLoaiDV) {
		this.maLoaiDV = maLoaiDV;
		this.tenLoaiDV = tenLoaiDV;
	}
	public LoaiDichVu() {
	}
	
}
