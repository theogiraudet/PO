package istic.l2.po.tp4_5;

import java.util.Arrays;

import istic.l2.po.tp4_5.animal.cervide.Cerf;
import istic.l2.po.tp4_5.animal.cervide.Daim;
import istic.l2.po.tp4_5.animal.cervide.Elan;
import istic.l2.po.tp4_5.animal.felin.Lion;
import istic.l2.po.tp4_5.animal.felin.Panthere;
import istic.l2.po.tp4_5.animal.felin.Tigre;
import istic.l2.po.tp4_5.animal.oiseau.Aigle;
import istic.l2.po.tp4_5.animal.oiseau.Faucon;
import istic.l2.po.tp4_5.animal.oiseau.Perroquet;

public class Main {

	public static void main(String... args) {
		
		Lion simba = new Lion("Simba", 2);
		Aigle benoit = new Aigle("Benoit", 15);
		Cerf bambi = new Cerf("Bambi", 1);
		Panthere bagheera = new Panthere("Bagheera", 7);
		Tigre shereKhan = new Tigre("Shere Khan", 14);
		Tigre nathalie = new Tigre("Nathalie", 3, shereKhan);
		Faucon hayabusa = new Faucon("Hayabusa", 7);
		Perroquet iago = new Perroquet("Iago", 4);
		Daim alain = new Daim("Alain", 11);
		Elan rutt = new Elan("Rutt", 10);
		Zoo z = new Zoo("Zoo de la Flèche", 10, simba, benoit, bambi, bagheera, shereKhan, hayabusa, iago, alain, rutt, nathalie);
		System.out.println(z.getFamilyMostRepresented());
		System.out.println(rutt.toString());
		
		ZooEnclos z2 = new ZooEnclos("Mon Zoo", 5);
		Enclos enclos1 = new Enclos("félin");
		enclos1.addAnimal(simba);
		enclos1.addAnimal(bagheera);
		enclos1.addAnimal(shereKhan);
		
		Enclos enclos2 = new Enclos("oiseau");
		enclos2.addAnimal(hayabusa);
		enclos2.addAnimal(iago);
		enclos2.addAnimal(rutt);
		z2.addEnclos(enclos1, enclos2);
		
		z2.createSpectacle();
		z2.createSpectacle();
		System.out.println(Arrays.toString(z2.getChildren()));
		
		System.out.println(hayabusa.getNbParticipate());
	}
}
