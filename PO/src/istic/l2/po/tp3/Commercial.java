package istic.l2.po.tp3;

public class Commercial extends Employe {

	private double receipts;
	
	public Commercial(String name) {
		super(name);
	}
	
	public Commercial(String name, int fixedSum, int receipts) {
		super(name, fixedSum);
		this.receipts = receipts;
	}

	@Override
	public double getSalary() {
		return fixedSum + receipts / 100;
	}
	
	public void setInfoSalary(int fixedSum, double receipts) {
		this.fixedSum = fixedSum;
		this.receipts = receipts;
	}
	
	public double getReceipts() {
		return receipts;
	}
	

}
