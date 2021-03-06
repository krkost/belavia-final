package by.htp.belavia.entity;

import java.util.Comparator;

public class Ticket {

	private String date;
	private double price;
	private String className;
	private String time;

	public Ticket() {
		super();
	}

	public Ticket(String date, double price) {
		super();
		this.date = date;
		this.price = price;
	}

	public Ticket(String date, double price, String className, String time) {
		super();
		this.date = date;
		this.price = price;
		this.className = className;
		this.time = time;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ticket other = (Ticket) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "\nTicket [date=" + date + ", price=" + price + ", className=" + className + ", time=" + time + "]";
	}

	public static Comparator<Ticket> COMPARE_BY_PRICE = new Comparator<Ticket>() {
		@Override
		public int compare(Ticket one, Ticket other) {
			Double d1 = (Double) one.price;
			Double d2 = (Double) other.price;

			return d1.compareTo(d2);
		}
	};

}
