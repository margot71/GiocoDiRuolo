package Progettino;

public class Eroe implements Umano {
 	public int forza; 
	public int vita;
	 
	public Eroe() 
	{ 
		forza = 10; 
		vita = 40;
	} 
	
	@Override
	public void combatti() 
	{ 
		forza -= 2;
	} 
	 
	public String getForza() 
	{ 
		return "Forza rimanente dell'eroe: " + forza; 
	} 
	
	@Override
	public int getVita() {
		return vita;
	}
	
	@Override
	public void attacca(Personaggio p) {
		System.out.println("L'eroe attacca");
		combatti();
		p.riceviDanno(forza);
	}
	
	@Override
	public void riceviDanno(int danno) {
		vita -= danno;
		System.out.println("L'eroe subisce un danno " + danno);
		if (vita < 0) {
			vita = 0;
			System.out.println("L'eroe è morto");
		}
	}
	
	@Override
	public void recuperaForza() 
	{ 
		forza += 2;
		System.out.println("L'eroe recupera 2 punti forza. Forza attuale: " + forza);
	} 
}
