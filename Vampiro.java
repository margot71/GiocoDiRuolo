package Progettino;

public class Vampiro implements Mostro {
	public int forza; 
	public int vita;
	
	public Vampiro() 
	{ 
		forza = 15; 
		vita = 70;
	} 
	
	@Override
	public void azzanna() 
	{ 
		forza -= 3;
	} 
	
	public String getForza() 
	{ 
		return "Forza rimanente del vampiro: " + forza; 
	} 
	
	@Override
	public int getVita() {
		return vita;
	}
	
	@Override
	public void attacca(Personaggio p) {
		System.out.println("Il vampiro azzanna");
		azzanna();
		p.riceviDanno(forza);
	}

	@Override
	public void riceviDanno(int danno) {
		vita -= danno;
		System.out.println("Il vampiro subisce un danno " + danno);
		if (vita < 0) {
			vita = 0;
			System.out.println("Il vampiro è morto");
		}
	}
	
	@Override
	public void recuperaForza() 
	{ 
		forza += 3;
		System.out.println("Il vampiro recupera 3 punti forza. Forza attuale: " + forza);
	} 
} 
