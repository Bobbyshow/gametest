package all.test;
import java.awt.Rectangle;

import javax.swing.text.html.parser.Entity;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import app.data.*;
/**
 ** C'est l'état principal du jeu, c'est ici que l'on codera l'action du jeu !
 */
public class GameState extends BasicGameState
{
	private EntityCharacter heros;
	private EntityCharacter adv;
	public static final int ID = 1;
	private int[] menu;
	private int[] selection;
	@Override
	public int getID() {return ID;}
	public void init(GameContainer container, StateBasedGame game) throws SlickException {
		heros = new EntityCharacter(1,150,100,1,1,1,1,1,1);
		adv = new EntityCharacter(1,150,100,1,1,1,1,1,1);
		heros.set_etat(Etat.ATTENTE);
		adv.set_etat(Etat.ATTENTE);
		menu = new int[4];
		menu[0] = 100;
		menu[1] = 100;
		menu[2] = 80;
		menu[3] = 100;
		selection = new int[2];
		selection[0]=menu[0];
		selection[1]=menu[1];
	}
	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
		afficherSectionHeros(g,heros);
		afficherSectionEnnemi(g,adv);
	}
	public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
		gestionHeros(container, heros);
		if(adv.estMort()){
			adv.set_etat(Etat.DEAD);
		}
	}
	private void afficherSectionHeros(Graphics g, EntityCharacter h){
		afficherPersonnage(g,h);
	}
	private void afficherSectionEnnemi(Graphics g, EntityCharacter e) {
		afficherEnnemi(g,e);
	}
	private void afficherEnnemi(Graphics g, EntityCharacter e) {
		switch (e.get_etat()){
			case DEAD:
				/* Afficher position mort */
				break;
			case ATTENTE:
				/* Afficher position standard */
				g.setColor(Color.gray);
				g.drawRoundRect(400, 50, 70, 100,10);
				g.drawString("HP",400,160);
				g.drawString("" + e.get_hp(),410,180);
				break;
			case PRET:
				/* Afficher position standard */
				g.setColor(Color.gray);
				g.drawRoundRect(400, 50, 70, 100, 10);
				break;
			case CHOIX:
				/*afficher position standard + menu */
				g.setColor(Color.gray);
				g.drawRoundRect(400, 50, 70, 100, 10);
				break;
			case ATTAQUE:
				break;
			case CHOIX_ATTAQUE:
				break;
			case CHOIX_COMBO:
				break;
			case CHOIX_MAGIE:
				break;
			case CHOIX_OBJET:
				break;
			case DEFENSE:
				break;
			case FIN_ATTAQUE:
				break;
			default:
				break;
		}
	}
	private void afficherPersonnage(Graphics g, EntityCharacter h){
		switch (h.get_etat()){
			case DEAD:
				/* Afficher position mort */
				break;
			case ATTENTE:
				/* Afficher position standard */
				g.setColor(Color.gray);
				g.drawRoundRect(50, 50, 70, 100, 1);
				g.drawLine(70,70,70+h.get_temps(),70);
				break;
			case PRET:
				/* Afficher position standard */
				g.setColor(Color.gray);
				g.drawRoundRect(50, 50, 70, 100, 1);
				break;
			case CHOIX:
				/*afficher position standard + menu */
				g.setColor(Color.gray);
				g.drawRoundRect(50, 50, 70, 100, 1);
				g.setColor(Color.yellow);
				g.drawRect(menu[0],menu[1],menu[2],menu[3]);
				g.setColor(Color.white);
				g.drawString("Attaque", menu[0]+5, menu[1]+5);// comment écrire du texte à l'écran ??
				g.drawString("Defense", menu[0]+5, menu[1]+30);
				g.drawRect(selection[0],selection[1],menu[2],25);
				break;
			case ATTAQUE:
				g.setColor(Color.gray);
				g.drawRoundRect(50, 50, 70, 100, 1);
				break;
			case CHOIX_ATTAQUE:
				g.setColor(Color.gray);
				g.drawRoundRect(50, 50, 70, 100, 1);
				g.setColor(Color.yellow);
				g.drawRect(menu[0],menu[1],menu[2],menu[3]);
				g.setColor(Color.white);
				g.drawString("Attaque", menu[0]+5, menu[1]+5);// comment écrire du texte à l'écran ??
				g.drawString("Defense", menu[0]+5, menu[1]+30);
				g.drawRect(selection[0],selection[1],menu[2],25);
				g.setColor(Color.orange);
				g.drawLine(380, 35, 400, 50);
				g.drawLine(390, 50, 400, 50);
				g.drawLine(400, 40, 400, 50);
				break;
			case CHOIX_COMBO:
				break;
			case CHOIX_MAGIE:
				break;
			case CHOIX_OBJET:
				break;
			case DEFENSE:
				break;
			case ATTENTE_DEF:
				g.setColor(Color.green);
				g.drawRoundRect(50, 50, 70, 100, 1);
				g.drawLine(70,70,70+h.get_temps(),70);
				break;
			case FIN_ATTAQUE:
				break;

			default:
				break;
		}
	}
	private void gestionHeros(GameContainer contain, EntityCharacter h){
		Input gestionEntre = contain.getInput();
		switch (h.get_etat()){
			case DEAD:
				/* Rien a faire... Attendre réssurection. */
				break;
			case ATTENTE:
				if (h.tourActive()){
					h.set_etat(Etat.PRET);
				}
				break;
			case PRET:
				h.set_etat(Etat.CHOIX);
				break;
			case CHOIX:
				/* gestion du choix de l'action en fct des inputs : atk, def */
				/* -- CHOIX DE L'ACTION -- */
				if (gestionEntre.isKeyPressed(Input.KEY_DOWN) && selection[1] == menu[1]){
					selection[1] += 25;
				}else if (gestionEntre.isKeyPressed(Input.KEY_UP) && selection[1] != menu[1]){
					selection[1] -= 25;
				/* -- VALIDATION DE L'ACTION -- */
				}else if (gestionEntre.isKeyPressed(Input.KEY_ENTER)){
					switch (selection[1]){
						case 100:
							h.set_etat(Etat.CHOIX_ATTAQUE);
							break;
						case 125:
							h.set_etat(Etat.DEFENSE);
							break;
					}
				}
				break;
			case ATTAQUE:
				h.set_etat(Etat.FIN_ATTAQUE);
				break;
			case CHOIX_ATTAQUE:
				if (gestionEntre.isKeyPressed(Input.KEY_ENTER)){
					h.set_etat(Etat.ATTAQUE);
				}
				break;
			case CHOIX_COMBO:
				break;
			case CHOIX_MAGIE:
				break;
			case CHOIX_OBJET:
				break;
			case DEFENSE:
				h.set_cur_def(h.get_cur_def()*2);
				selection[1] = menu[1];
				h.init_temps();
				h.set_etat(Etat.ATTENTE_DEF);
				break;
			case ATTENTE_DEF:
				if (h.tourActive()){
					h.set_cur_def(h.get_cur_def()/2);
					h.set_etat(Etat.PRET);
				}
				break;
			case FIN_ATTAQUE:
				h.AttaqueEnnemi(adv);
				h.set_etat(Etat.FIN_TOUR);
				break;
			case FIN_TOUR:
				selection[1] = menu[1];
				h.init_temps();
				h.set_etat(Etat.ATTENTE);
				break;
			case DYING:
				h.set_etat(Etat.DEAD);
				break;
			default:
				break;
		}
	}
}