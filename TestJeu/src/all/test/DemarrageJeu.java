package all.test;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

public class DemarrageJeu {
	public static void main(String[] args)   
	{  
		try  
		{  
			AppGameContainer container = new AppGameContainer(new HelloWorld());  
			container.setDisplayMode(640, 480, false);// fen�tre de 1280*768 fullscreen =false !!  
			container.setTargetFrameRate(60);// on r�gle le FrameRate  
			container.start();//on d�marre le container  
		}                         
		catch (SlickException e) {e.printStackTrace();}  // l'exception de base de slick !!  
	}  
}
