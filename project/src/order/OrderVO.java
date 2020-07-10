package order;

import java.sql.Date;

import product.ProductVO;

public class OrderVO extends ProductVO{
	
	private String cvs_code;
	private String category_code;
	private int order_quantity;
	private Date order_date;
	private int order_id;
	public String getCvs_code() {
		return cvs_code;
	}
	public void setCvs_code(String cvs_code) {
		this.cvs_code = cvs_code;
	}
	
	public String getCategory_code() {
		return category_code;
	}
	public void setCategory_code(String category_code) {
		this.category_code = category_code;
	}
	public int getOrder_quantity() {
		return order_quantity;
	}
	public void setOrder_quantity(int order_quantity) {
		this.order_quantity = order_quantity;
	}
	public Date getOrder_date() {
		return order_date;
	}
	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	@Override
	public String toString() {
		return "OrderVO [cvs_code=" + cvs_code + ", category_code=" + category_code
				+ ", order_quantity=" + order_quantity + ", order_date=" + order_date + ", order_id=" + order_id
				+ ", getCvs_code()=" + getCvs_code() + ", getProduct_code()=" + getProduct_code()
				+ ", getCategory_code()=" + getCategory_code() + ", getOrder_quantity()=" + getOrder_quantity()
				+ ", getOrder_date()=" + getOrder_date() + ", getOrder_id()=" + getOrder_id() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
	
}
