package all.test;
/** 
 **cette classe est le point d'entrée du jeu ! 
 */  
import org.newdawn.slick.AppGameContainer;  
import org.newdawn.slick.GameContainer;  
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;  
import org.newdawn.slick.state.StateBasedGame;  
public class HelloWorld extends StateBasedGame  
{  

	private GameState jeu; // le premier état du jeu (voir GameState.java) 
	private AppGameContainer container; // le conteneur du jeu  
	public HelloWorld() {super("Mon premier jeu");} // le constructeur de la classe  
	@Override  
	public void initStatesList(GameContainer container) throws SlickException   
	{  
		if (container instanceof AppGameContainer) {  
			this.container = (AppGameContainer) container;// on stocke le conteneur du jeu !  
		}  
		jeu = new GameState();//le jeu en lui même !!  
		container.setShowFPS(true);//on ne veut pas voir le FPS ?? mettre alors "false" !  
		addState(jeu);    //on ajoute le GameState au conteneur !  
	}  

}  // fin de classe  
