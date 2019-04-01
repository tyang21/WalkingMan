import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.Timer;

public class Main {
	
	public static void main(String[] args) throws IOException
	{
		JFrame myFrame = new JFrame();
		myFrame.setBounds(0, 0, 600, 600);
		myFrame.setLayout(null);
		
		WalkingMan man = new WalkingMan(0,0);
		myFrame.add(man);
		
		ArrayList<Updatable> gameObjs = new ArrayList<Updatable>();
		
		gameObjs.add(man);
		
		myFrame.addKeyListener(new KeyListener()
		{
			public void keyPressed(KeyEvent e)
			{
				if (e.getKeyCode() == e.VK_W)
				{
					man.setDy(-5);
					if(man.getY() < 0)
					{
						man.setDy(0);
					}
				}
				if (e.getKeyCode() == e.VK_S)
				{
					man.setDy(5);
					if(man.getY() > myFrame.getHeight() - 85)
					{
						man.setDy(0);
					}
				}
				if(e.getKeyCode() == e.VK_A)
				{
					man.setDx(-5);
					if(man.getX() < 0)
					{
						man.setDx(0);
					}
					
				}
				if(e.getKeyCode()  == e.VK_D)
				{
					man.setDx(5);
					if(man.getX() > myFrame.getWidth() - 75)
					{
						man.setDx(0);
					}
				}
				if(e.getKeyCode() == e.VK_SPACE)
				{
					Ball ball = new Ball();
					myFrame.add(ball);
					ball.setLocation(man.getX(), man.getY());
					gameObjs.add(ball);
				}
			}
			public void keyReleased(KeyEvent e)
			{
				if (e.getKeyCode() == e.VK_W)
				{
					man.setDy(0);
				}
				if (e.getKeyCode() == e.VK_S)
				{
					man.setDy(0);
				}
				if(e.getKeyCode() == e.VK_A)
				{
					man.setDx(0);
				}
				if(e.getKeyCode()  == e.VK_D)
				{
					man.setDx(0);
				}
			}
			public void keyTyped(KeyEvent e) 
			{
				
			}
		});
		Timer t1 = new Timer(1000/60, new ActionListener()
				{
					public void actionPerformed(ActionEvent a)
					{
						for (Updatable u : gameObjs)					
						{
							u.update();
							if(ball.getX() >600 || ball.getY() > 600)
							{
							gameObjs.remove(u);
							}
						}
						
					}
				});
		t1.start();
		
		
		myFrame.setVisible(true);
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}


}
