package com.jb.magiworld;

public class Mage extends Personnage {

	public Mage(int numJoueur, int niveau, int force, int agilite, int intelligence) {
		super(numJoueur, niveau, force, agilite, intelligence);

	}
	@Override
	public String toString() {
		String str = "Joueur " + numJoueur + " est un mage" + " de niveau " + this.niveau + ", vie " + vie + ", force " + this.force
				+ ", agilité " + this.agilite + ", inteligence " + this.intelligence;
		return str;
	}
	
	@Override
	void attaqueBasique(Personnage victime) {
		// boule de feu = int
		victime.vie = victime.vie - this.intelligence;
		System.out.println("Joueur " + numJoueur + " utilise Boule de Feu et inflige " + this.intelligence + " dommages");
		System.out.println("Joueur " + victime.numJoueur + " perd " + this.intelligence + " point de vie");
		if (victime.vie <= 0) {
			System.out.println("Joueur " + victime.numJoueur + " est mort ");
			System.out.println("Joueur " + victime.numJoueur + " à perdu ");
		}
	}

	@Override
	void attaqueSpecial(Personnage victime) {
		// soin = int*2
		this.vie = this.vie + this.intelligence*2;
		if (this.vie > this.niveau*5) {
			this.vie = this.niveau*5;			
		}
		System.out.println("joueur " + numJoueur + " se soigne et gagne " + this.intelligence*2 + " point de vie ("
				+ this.vie + " point de vie)");
		if (victime.vie <= 0) {
			System.out.println("Joueur " + victime.numJoueur + " est mort ");
			System.out.println("Joueur " + victime.numJoueur + " à perdu ");
		}

	}

	
}
