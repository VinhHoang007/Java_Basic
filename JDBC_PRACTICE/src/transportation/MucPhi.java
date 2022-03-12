package transportation;

public class MucPhi {
	private String maMP;
	private double donGia;
	private String moTa;
	public String getMaMP() {
		return maMP;
	}
	public void setMaMP(String maMP) {
		this.maMP = maMP;
	}
	public double getDonGia() {
		return donGia;
	}
	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}
	public String getMoTa() {
		return moTa;
	}
	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}
	public MucPhi(String maMP, double donGia, String moTa) {
		super();
		this.maMP = maMP;
		this.donGia = donGia;
		this.moTa = moTa;
	}
	public MucPhi() {
	}
	
	
}
