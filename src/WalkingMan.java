import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

import javax.swing.BorderFactory;
import javax.swing.JComponent;

public class WalkingMan extends JComponent implements Updatable
{
	private Ellipse2D.Double head;
	private Rectangle arm1;
	private Rectangle arm2;
	private Rectangle body;
	private Rectangle leg1;
	private Rectangle leg2;
	private int dx;
	private int dy;
	
	public WalkingMan(int x, int y)
	{
		head = new Ellipse2D.Double(20, 0, 10, 10);
		arm1 = new Rectangle(0, 10, 20, 5);
		arm2 = new Rectangle(35, 10, 20, 5);
		body = new Rectangle(15, 10, 20, 15);
		leg1 = new Rectangle(15, 25, 5, 20);
		leg2 = new Rectangle(30, 25, 5, 20);
		
		this.setLocation(x, y);
		this.setSize(55, 45);
		
		
		
	}
	public void paintComponent (Graphics g)
	{
		
		Graphics2D g2 = (Graphics2D) g;
		System.out.println(g2.getColor());
		g2.fill(head);
		g2.fill(arm1);
		g2.fill(arm2);
		g2.fill(body);
		g2.fill(leg1);
		g2.fill(leg2);
	}
	
	public void setDx(int x)
	{
		dx = x;
	}
	public void setDy(int y)
	{
		dy = y;
	}
	public void update()
	{
		if (getX() + dx >= 600 && getY() + dy >= 600)
			setLocation(getX() + dx, getY() + dy);		
		
		/*
		if(getX() < 0)
		{
			setLocation(0, man.getY());
		}
		if(man.getX() > myFrame.getWidth() - 75)
		{
			man.setLocation(myFrame.getWidth() - 75, man.getY());
		}
		if(man.getY() < 0)
		{
			man.setLocation(man.getX(), 0);
		}
		if(man.getY() > myFrame.getHeight() - 115)
		{
			man.setLocation(man.getX(), myFrame.getHeight() - 115);
		}
		*/
	}
	
}
