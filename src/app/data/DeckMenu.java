package app.data;
import java.util.Hashtable;

/**
 * Classe éditant le paquet de carte créer par le joueur dans le menu
 * @author Anthony
 *
 */
public class DeckMenu {
	private Hashtable<ValeurCarte,Integer> paquet;
	private int nb_cartes;
	private int max_cartes;
	public DeckMenu(){
		max_cartes = 40;
		nb_cartes = 0;
		paquet = new Hashtable<ValeurCarte,Integer>(40);
	}
	public int nbCartes(Object key) {
		return paquet.get(key).intValue();
	}
	public Hashtable<ValeurCarte, Integer> getPaquet() {
		return paquet;
	}
	public int getNb_cartes() {
		return nb_cartes;
	}
	public int getMax_cartes() {
		return max_cartes;
	}
	public void ajouterCarte(ValeurCarte c){
		if (nb_cartes<40){
			if(paquet.containsKey(c)){
				paquet.put(c,new Integer(paquet.get(c).intValue()+1));
			}else{
				paquet.put(c, new Integer(1));
			}
			nb_cartes++;
		}
	}
	public void retirerCarte(ValeurCarte c){
		if (paquet.containsKey(c)){
			int tmp = paquet.get(c).intValue();
			if(tmp==1){
				paquet.remove(c);
			}else{
				paquet.put(c,new Integer(tmp-1));
			}
			nb_cartes--;
		}
	}
	@Override
	public String toString() {
		return "DeckMenu [paquet=" + paquet.toString() + ", nb_cartes=" + nb_cartes
				+ ", max_cartes=" + max_cartes + "]";
	}
	
}
