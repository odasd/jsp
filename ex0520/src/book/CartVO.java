package book;

public class CartVO extends BookVO {
	
	private int number;
	private int sum;
	private int total;
	private int cnt;
	
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public int getSum() {
		return sum;
	}
	public void setSum(int sum) {
		this.sum = sum;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	
	@Override
	public String toString() {
		return "CartVO [number=" + number + ", sum=" + sum + ", total=" + total + ", cnt=" + cnt + ", getNumber()="
				+ getNumber() + ", getSum()=" + getSum() + ", getTotal()=" + getTotal() + ", getCnt()=" + getCnt()
				+ ", getCode()=" + getCode() + ", getTitle()=" + getTitle() + ", getWriter()=" + getWriter()
				+ ", getPrice()=" + getPrice() + ", toString()=" + super.toString() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + "]";
	}
	

	
}
