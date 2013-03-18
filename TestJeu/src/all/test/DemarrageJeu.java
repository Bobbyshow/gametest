package all.test;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

public class DemarrageJeu {
	public static void main(String[] args)   
	{  
		try  
		{  
			AppGameContainer container = new AppGameContainer(new HelloWorld());  
			container.setDisplayMode(640, 480, false);// fenêtre de 1280*768 fullscreen =false !!  
			container.setTargetFrameRate(60);// on règle le FrameRate  
			container.start();//on démarre le container  
		}                         
		catch (SlickException e) {e.printStackTrace();}  // l'exception de base de slick !!  
	}  
}
