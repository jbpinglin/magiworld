package com.jb.magiworld;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {

	static Scanner sc = new Scanner(System.in);

	public static Personnage creerJoueur(int numJoueur) {
		int classes = 0;
		int niveau = -1;
		int force = -1;
		int agilite = -1;
		int intelligence = -1;

		Personnage joueur;
// creation joueur
		System.out.println("CREATION DU JOUEUR " + numJoueur);
// choix de classe
		while (classes != 1 && classes != 2 && classes != 3) {
			System.out.println("Veuillez choisir la classe de votre personnage (1 : Guerrier, 2 : Rodeur, 3 : Mage )");
			try {
				classes = sc.nextInt();
				if (classes != 1 && classes != 2 && classes != 3) {
					System.out.println("Syntax Error");
				}
			} catch (InputMismatchException e) {
				System.out.println("!! MAUVAIS CARACTERE !!");
				sc.nextLine();
			}
		}

		// niveau
		while (niveau < 1 || niveau > 100) {
			try {
				System.out.println("Niveau du personnage ?");
				niveau = sc.nextInt();
				if (niveau < 1 || niveau > 100)
					System.out.println("erreur ! le niveau dois etre compris entre 1 et 100");
			} catch (InputMismatchException e) {
				System.out.println("!! MAUVAIS CARACTERE !!");
				sc.nextLine();
			}
		}
		// stats
		while (force + agilite + intelligence != niveau) {
			try {
				// force
				System.out.println("force du personnage ?");
				force = sc.nextInt();
				// agilité
				System.out.println("Agilité du personnage ?");
				agilite = sc.nextInt();
				// intelligence
				System.out.println("Intélligence du personnage ?");
				intelligence = sc.nextInt();
				if (force + agilite + intelligence != niveau)
					System.out.println(
							"erreur ! la somme des statistiques de votre personnage doivent être égale à votre niveau !");
			} catch (InputMismatchException e) {
				System.out.println("!! MAUVAIS CARACTERE !!");
				sc.nextLine();
			}
		}
		if (classes == 1) {
			joueur = new Guerrier(numJoueur, niveau, force, agilite, intelligence);
		} else if (classes == 2) {
			joueur = new Rodeur(numJoueur, niveau, force, agilite, intelligence);
		} else {
			joueur = new Mage(numJoueur, niveau, force, agilite, intelligence);
		}
		// Annonce J2
		System.out.println(joueur.toString()+"\n");
		return joueur;

	}

	public static void combat(Personnage attaquant, Personnage victime) {
		int attaque = 0;

		while (attaque != 1 && attaque != 2) {
			try {
				// attaquant attaque victime
				System.out.println("joueur " + attaquant.numJoueur + " (" + attaquant.vie
						+ " vitalité) Veuillez choisir une action (1 : Attaque Basique, 2: Attaque Spéciale) Vie J"
						+ victime.numJoueur + " (" + victime.vie + ")");
				attaque = sc.nextInt();
				if (attaque == 1) {
					attaquant.attaqueBasique(victime);
				} else if (attaque == 2) {
					attaquant.attaqueSpecial(victime);
				} else {
					System.out.println("syntax error");
				}
			} catch (InputMismatchException e) {
				System.out.println("!! MAUVAIS CARACTERE !!");
				sc.nextLine();
			}
		}
	}

	public static void main(String[] args) {

		Personnage joueur1 = creerJoueur(1);
		Personnage joueur2 = creerJoueur(2);

		// phase de Combat

		while (joueur1.vie > 0 || joueur2.vie > 0) {
			combat(joueur1, joueur2);

			if (joueur2.vie <= 0 || joueur1.vie <= 0) {
				break;
			}
			combat(joueur2, joueur1);
		}
//phrase de victoire			

		if (joueur2.vie <= 0 && joueur1.vie > 0) {
			System.out.println("Joueur 1 à gagné la battaille");
		}
		if (joueur1.vie <= 0 && joueur2.vie > 0) {
			System.out.println("Joueur 2 à gagné la battaille");
		}
		if (joueur1.vie <= 0 && joueur2.vie <= 0) {
			System.out.println("vous avez perdu tous les deux");
		}
	}
}
