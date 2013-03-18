package all.test;
import app.data.*;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
public class CombatState extends BasicGameState
{
	public static final int ID = 2;
	@Override
	public int getID() {return ID;}
	public void init(GameContainer container, StateBasedGame game) throws SlickException {
		//vide
	}
	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
		g.drawString("Hello World", 500, 50);// comment écrire du texte à l'écran ??
	}
	public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
		//vide
	}
}
