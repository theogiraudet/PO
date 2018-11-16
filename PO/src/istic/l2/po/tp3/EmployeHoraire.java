package istic.l2.po.tp3;

public class EmployeHoraire extends Employe {

	private int percent;
	private int nbreHour;
	
	public EmployeHoraire(String name, int fixedSum, int nbreHour, int percent) {
		super(name, fixedSum);
		this.percent = percent;
		this.nbreHour = nbreHour;
	}

	public EmployeHoraire(String name) {
		super(name);
	}

	public int getPercent() {
		return percent;
	}
	
	public int getNbreDay() {
		return nbreHour;
	}

	public void setPercent(int percent) {
		this.percent = percent;
	}
	
	public void setInfoSalary(int fixedSum, int nbreHour, int percent) {
		this.fixedSum = fixedSum;
		this.nbreHour = nbreHour;
		this.percent = percent;
	}
	
	public double getSalary() {
		return fixedSum * ((nbreHour > 35) ? 35 : 0) + ((nbreHour > 35) ? (nbreHour - 35) * (fixedSum * ((double)percent / 100)) : 0);
	}

}
