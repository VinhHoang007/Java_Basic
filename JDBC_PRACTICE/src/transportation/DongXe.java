package transportation;

public class DongXe {
	private String dongXe;
	private String hangXe;
	private int soChoNgoi;
	public String getDongXe() {
		return dongXe;
	}
	public void setDongXe(String dongXe) {
		this.dongXe = dongXe;
	}
	public String getHangXe() {
		return hangXe;
	}
	public void setHangXe(String hangXe) {
		this.hangXe = hangXe;
	}
	public int getSoChoNgoi() {
		return soChoNgoi;
	}
	public void setSoChoNgoi(int soChoNgoi) {
		this.soChoNgoi = soChoNgoi;
	}
	public DongXe(String dongXe, String hangXe, int soChoNgoi) {
		this.dongXe = dongXe;
		this.hangXe = hangXe;
		this.soChoNgoi = soChoNgoi;
	}
	public DongXe() {
	}
	
	
}
