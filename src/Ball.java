import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;

import javax.swing.JComponent;
import javax.swing.Timer;

public class Ball extends JComponent
{
	private Ellipse2D.Double ball;
	
	public Ball()
	{
		ball = new Ellipse2D.Double(0, 0, 10, 10);
		this.setSize(11, 11);
		Timer t = new Timer(1000/60, new ActionListener()
		{
			public void actionPerformed(ActionEvent a)
			{
				update();
			}
		});
		t.start();
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

