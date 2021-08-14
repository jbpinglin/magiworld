package com.jb.magiworld;

public class Guerrier extends Personnage {

	public Guerrier(int numJoueur, int niveau, int force, int agilite, int intelligence) {
		super(numJoueur, niveau, force, agilite, intelligence);

	}

	@Override
	public String toString() {
		String str = "Joueur " + numJoueur + " est un Guerrier" + " de niveau " + this.niveau + ", vie " + vie + ", force " + this.force
				+ ", agilité " + this.agilite + ", inteligence " + this.intelligence;
		return str;
	}

	@Override
	void attaqueBasique(Personnage victime) {
		// coup d'épée = force
		// recupérer valeur force du joueur
		// soustraire la valeur à la vie du deuxieme joueur
		// afficher attaquant utlise coup d'épée et inflige X dommages
		victime.vie = victime.vie - this.force;
		System.out.println("Joueur " + numJoueur + " utilise coup d'épée et inflige " + this.force + " dommages");
		System.out.println("Joueur " + victime.numJoueur + " perd " + this.force + " point de vie");
		if (victime.vie <= 0) {
			System.out.println("Joueur " + victime.numJoueur + " est mort ");
			System.out.println("Joueur " + victime.numJoueur + " à perdu ");
		}
	}

	@Override
	void attaqueSpecial(Personnage victime) {
		// coup de rage = force*2 - force/2
		victime.vie = victime.vie - this.force * 2;
		this.vie = this.vie - this.force / 2;
		System.out.println("Joueur " + numJoueur + " utilise coup de Rage et inflige " + this.force * 2 + " dommages");
		System.out.println("Joueur " + victime.numJoueur + " perd " + this.force * 2 + " point de vie");

		if (victime.vie <= 0) {
			System.out.println("Joueur " + victime.numJoueur + " est mort ");
		}
		System.out.println(
				"Joueur " + numJoueur + " perd " + this.force / 2 + " point de vie (" + this.vie + " vitalité)");
		if (this.vie <= 0) {
			System.out.println("Joueur " + numJoueur + " est mort ");
			System.out.println("Joueur " + numJoueur + " à perdu ");
		}
	}
}
