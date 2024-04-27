package Progettino;

import java.util.Random;
import java.util.Scanner;

public class Giochiamo {
	static String giocatore = null;
	static String avversario=null;
	static String scelta = null;
	static boolean isVivo;
	static Eroe eroe = new Eroe();
	static Licantropo lica = new Licantropo();
	static Vampiro vampi = new Vampiro();	
	
	public static void main (String [] args)  { 
		
		try (Scanner sceltaAzione = new Scanner(System.in)){
			while(true){
				System.out.println("INIZIA UNA NUOVA MANCHE DEL GIOCO");
				//chiama la funzione per scegliere il primo combattente
				scegliGiocatore();
				
				//Viene chiesto di scegliere l'azione da compiere
				System.out.println("Cosa vuoi fare?\n	1 - Attaccare\n	2 - Recuperare le forze\n	3 - Uscire");
				scelta = sceltaAzione.nextLine();
				switch(scelta) {
					case "1":
						//controlla se il giocatore è ancora vivo, altrimenti ne viene scelto un altro
						if (!isVivo) {
							System.out.println("Non hai abbastanza vita per attaccare");
						} else {
					 		//Viene chiesto di scegliere il secondo combattente tra i possibili avversari
					 		System.out.println("Con che personaggio vuoi giocare?");
					 		if (giocatore == "Eroe") {
					 			System.out.println("[l=licantropo, v=vampiro]");
					 		} else 	if (giocatore == "Licantropo") {
					 			System.out.println("[e=eroe, v=vampiro]");
					 		} else 	if (giocatore == "Vampiro") {
					 			System.out.println("[e=eroe, l=licantropo]");
					 		}
					 		//inizia l'attacco in dipendenza dei due rivali
					 		scelta = sceltaAzione.nextLine();
							switch(scelta) {
						 		case "e":
						 			if (giocatore.equals("Vampiro")){
						 				vampi.attacca(eroe);
						 			} else if (giocatore.equals("Licantropo")) {
						 				lica.attacca(eroe);
						 			}
						 			avversario = "Eroe";
						 			break;
						 		case "l":
						 			if (giocatore.equals("Vampiro")){
						 				vampi.attacca(lica);
						 			} else if (giocatore.equals("Eroe")) {
						 				eroe.attacca(lica);
						 			}
						 			avversario = "Licantropo";
						 			break;
						 		case "v":
						 			if (giocatore.equals("Eroe")){
						 				eroe.attacca(vampi);
						 			} else if (giocatore.equals("Licantropo")) {
						 				lica.attacca(vampi);
						 			}
						 			avversario = "Vampiro";
						 			break;
						 		default:
						 			System.out.println("Scelta non prevista");
						 			break;
						 		}
							System.out.println("Il combattimento è tra " + giocatore + " e " + avversario);
						}
						break;
					case "2":
						//il giocatore sceglie di recuperare le forze
						if (giocatore.equals("Eroe")){
							eroe.recuperaForza();
						} else if (giocatore.equals("Licantropo")) {
							lica.recuperaForza();
						} else if (giocatore.equals("Vampiro")) {
							vampi.recuperaForza();
						}
						break;
					case "3":
						//riepiloga l'esito del gioco ed esce
						System.out.println("Fine gioco");
						sceltaAzione.close();
						System.out.println("Vita rimanente dell'eroe: " + eroe.getVita());
						System.out.println(eroe.getForza());
						System.out.println("Vita rimanente del vampiro: " + vampi.getVita());
						System.out.println(vampi.getForza());
						System.out.println("Vita rimanente del licantropo: " + lica.getVita());
						System.out.println(lica.getForza());
						return;
					default:
						System.out.println("Scelta non prevista");
						break;
				}				
			}
		}

	} 
	
	public static void scegliGiocatore() {
		//Viene scelto random il primo combattente
		Random comb1= new Random();
		switch(comb1.nextInt(3)) {
			case 0:
				giocatore = "Eroe";
				break;
			case 1:
				giocatore = "Licantropo";
				break;
			case 2:
				giocatore = "Vampiro";
				break;
			default:
				System.out.println("Scelta non prevista");
				break;
		}
		System.out.println("Il personaggio che gioca è: **  " + giocatore + "  **");
		//se il giocatore è il licantropo, verifica se è umano o mostro
		if (giocatore.equals("Licantropo")) {
			if (!lica.isUomo) {
				System.out.println("Il licantropo ha forma di lupo");
			} else {
				System.out.println("Il licantropo ha forma umana");
			}
		}
	}
	
	public boolean verificaVita() {
		//verifica che il giocatore abbia vita per poter attaccare
		if (giocatore.equals("Eroe")) {
			if (eroe.getVita() <= 0) {
				System.out.println("Non hai abbastanza vita per attaccare");
				isVivo = false;
			} else isVivo = true;
		} else 	if (giocatore.equals("Vampiro")) {
			if (vampi.getVita() <= 0) {
				System.out.println("Non hai abbastanza vita per attaccare");
				isVivo = false;
			} else isVivo = true;
		} else 	if (giocatore.equals("Licantropo")) {
			if (lica.getVita() <= 0) {
				System.out.println("Non hai abbastanza vita per attaccare");
				isVivo = false;
			} else isVivo = true;
		}
			
		return isVivo;
	}
} 
