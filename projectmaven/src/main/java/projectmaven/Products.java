package projectmaven;

public class Products {
		private int p_id;
		private String p_name;
		private double p_price;
		public int getP_id() {
			return p_id;
		}
		public void setP_id(int p_id) {
			this.p_id = p_id;
		}
		public String getP_name() {
			return p_name;
		}
		public void setP_name(String p_name) {
			this.p_name = p_name;
		}
		public double getP_price() {
			return p_price;
		}
		public void setP_price(double p_price) {
			this.p_price = p_price;
		}
		@Override
		public String toString() {
			return "Test1 [p_id=" + p_id + ", p_name=" + p_name + ", p_price="
					+ p_price + "]";
		}
		

	}


