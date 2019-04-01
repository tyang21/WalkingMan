import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;

import javax.swing.JComponent;
import javax.swing.Timer;

public class Ball extends JComponent implements Updatable
{
	private Ellipse2D.Double ball;
	
	public Ball()
	{
		ball = new Ellipse2D.Double(0, 0, 10, 10);
		this.setSize(11, 11);
	}
	
	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		g2.draw(ball);
	}
	public void update()
	{
		setLocation(getX() + 10, getY());
		
	}
}

