package Progettino;

import java.util.Random;

public class Licantropo implements Mostro, Umano {
 	public boolean isUomo; 
 	public int forzaUmano, forzaMostro; 
 	public int vita;
	 
	public Licantropo()  {
		//sceglie random se il licantropo ha forma umana o di mostro
		Random lunaPiena= new Random();
	 	isUomo = !lunaPiena.nextBoolean(); 
		if (!isUomo) { 
			forzaMostro = 15; 
			forzaUmano = 0;
			vita = 100;
		} 
		else {
			forzaMostro = 0;
			forzaUmano = 10;
			vita = 70;
		} 
	}
 
	public String getForza () 
	{ 
		return "Forza rimanente del licantropo come umano: " + forzaUmano +
				" Forza rimanente del licantropo come mostro: " + forzaMostro; 
	} 
	 
	public void azzanna() {
		forzaMostro -= 3;
	} 
	 
	public void combatti () {
		forzaUmano -= 2;
	} 
	
	@Override
	public int getVita() {
		return vita;
	}
	
	@Override
	public void attacca(Personaggio p) {
		if(isUomo) {
			System.out.println("Il licantropo attacca");
			combatti();
		} else {
			System.out.println("Il licantropo azzanna");
			azzanna();
		}
	}
	
	@Override
	public void riceviDanno(int danno) {
		vita -= danno;
		System.out.println("Il licantropo subisce un danno " + danno);
		if (vita < 0) {
			vita = 0;
			System.out.println("Il licantropo è morto");
		}
	}

	@Override
	public void recuperaForza() 
	{ 
		if(isUomo) {
			forzaUmano += 2;
			System.out.println("Il licantropo recupera 2 punti forza. Forza attuale come umano: " + forzaUmano);
		} else {
			forzaMostro += 3;
			System.out.println("Il licantropo recupera 3 punti forza. Forza attuale come mostro: " + forzaMostro);
		}
	}
} 
