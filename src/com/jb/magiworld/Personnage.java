package com.jb.magiworld;

abstract class Personnage {
	
	protected int niveau;
		
	int vie;
		
	protected int force;
	
	protected int agilite;
	
	protected int intelligence;
	
	int numJoueur;
	
	
	public Personnage (int numJoueur , int niveau , int force , int agilite , int intelligence) {
		this.numJoueur = numJoueur;
		this.niveau = niveau;
		this.force = force;
		this.agilite = agilite;
		this.intelligence = intelligence;
		this.vie = niveau*5;
		
	}
	 
		
	abstract void attaqueBasique (Personnage victime);
	abstract void attaqueSpecial (Personnage victime);
			
}
