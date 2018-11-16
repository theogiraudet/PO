package istic.l2.po.tp3;

public class Paie {

	public static void main(String[] args) {
		Commercial commercial = new Commercial("c");
		commercial.setInfoSalary(2_000, 1_000_000); //L'utilisation de l'underscore est autorisé en tant que séparateur de centaines pour rendre le nombre plus lisible
		EmployeHoraire employeH1 = new EmployeHoraire("eh3", 250, 40, 30);
		EmployeHoraire employeH2 = new EmployeHoraire("eh5", 250, 40, 50);
		EmployeHoraire employeH3 = new EmployeHoraire("eh32", 510, 28, 50);
		Employe[] table = {commercial, employeH1, employeH2, employeH3};
		
		for(Employe e : table)
			System.out.println(e.toString());
	}

}
