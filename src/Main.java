import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

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
						man.update();
						if(man.getX() < 0)
						{
							man.setLocation(0, man.getY());
						}
						if(man.getX() > myFrame.getWidth() - 75)
						{
							man.setLocation(myFrame.getWidth() - 75, man.getY());
						}
						if(man.getY() < 0)
						{
							man.setLocation(man.getX(), 0);
						}
						if(man.getY() > myFrame.getHeight() - 85)
						{
							man.setLocation(man.getX(), myFrame.getHeight() - 85);
						}
					}
				});
		t1.start();
		
		
		myFrame.setVisible(true);
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}


}
