package com.jb.magiworld;

public class Rodeur extends Personnage {

	public Rodeur(int numJoueur, int niveau, int force, int agilite, int intelligence) {
		super(numJoueur, niveau, force, agilite, intelligence);

	}

	@Override
	public String toString() {
		String str = "Joueur " + numJoueur + " est un rodeur" + " de niveau " + this.niveau + ", vie " + vie + ", force " + this.force
				+ ", agilité " + this.agilite + ", inteligence " + this.intelligence;
		return str;
	}

	@Override
	void attaqueBasique(Personnage victime) {
		// tir à l'arc = agilite
		victime.vie = victime.vie - this.agilite;
		System.out.println("Joueur " + numJoueur + " utilise tir à l'Arc et inflige " + this.agilite + " dommages");
		System.out.println("Joueur " + victime.numJoueur + " perd " + this.agilite + " point de vie");
		if (victime.vie <= 0) {
			System.out.println("Joueur " + victime.numJoueur + " est mort ");
			System.out.println("Joueur " + victime.numJoueur + " à perdu ");
		}

	}

	@Override
	void attaqueSpecial(Personnage victime) {
		// concentration = +(lvl/2)lvl
		this.agilite = this.agilite + this.niveau/2;
		System.out.println("joueur" + numJoueur + " se concentre et gagne " + this.niveau/2 + " point d'agilité ("
				+ this.agilite + " agilité)");

	}

}
