package Progettino;
/*Differenze interfacce e classi astratte:
 *java permette ad una classe l'implementazione di più interfacce (eredità multipla)
 *una classe può estendere solo una classe astratta
 *le interfacce sono ottime per specificare cosa deve fare una classe senza imporre come deve essere fatto.
 *sono spesse utilizzate per definire un set di metodi che diverse classi provenienti da diverse gerarchie 
 *possono implementare
 *le astratte sono più rigide e le classi concrete che le estendono condividono una struttura comune
 *e metodi comuni ma hanno alcune implementazioni dei metodi con delle variazioni
 *questo ci risulta utile per le classi astratte per fornire una classe
 */
public interface Personaggio {
 public String getForza(); 
 int getVita();
 
 void attacca(Personaggio p);
 void riceviDanno(int danno);
 void recuperaForza();
}
