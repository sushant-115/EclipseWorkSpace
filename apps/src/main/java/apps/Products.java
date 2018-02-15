package apps;

public class Products {
	private int pid;
	private String pName;
	private double pPrice;

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public double getpPrice() {
		return pPrice;
	}

	public void setpPrice(double pPrice) {
		this.pPrice = pPrice;
	}

	@Override
	public String toString() {
		return "Products [pid=" + pid + ", pName=" + pName + ", pPrice="
				+ pPrice + "]";
	}

}
