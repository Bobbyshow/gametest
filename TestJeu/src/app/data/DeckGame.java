package app.data;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Stack;

/**
 * Classe du paquet de jeu utilisé pour les combat, issue d'un paquet DeckMenu 
 * @author Anthony
 *
 */
public class DeckGame {
	private DeckMenu paquet_base;
	private Stack<ValeurCarte> tirage;
	public DeckGame(DeckMenu paquet){
		paquet_base = paquet;
		tirage = new Stack<ValeurCarte>();
		_creer_tirage(paquet);
	}
	private void _creer_tirage(DeckMenu pack){
		Enumeration<ValeurCarte> table = pack.getPaquet().keys();
		while(table.hasMoreElements()){
			ValeurCarte c = table.nextElement();
			for(int i = 0;i<pack.nbCartes(c);i++){
				tirage.push(c);
			}
		}
		Collections.shuffle(tirage);
	}
	public ValeurCarte tirerCarte(){
		return tirage.pop();
	}
	public void reinit(){
		_creer_tirage(paquet_base);
	}
}
