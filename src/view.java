import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class view extends JFrame{

	private JPanel Shark;
	
	public view() {
		this.validate();
		setTitle("Shark Robot");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(0,0,1920,1040);
		getContentPane().setLayout(new BorderLayout());
		Shark = new JPanel();
		Shark.setLayout(new BorderLayout());
		Shark.setBackground(new Color(0,128,255));
		/*BufferedImage myPicture = null;
		
		try {
			myPicture = ImageIO.read(new File("sea.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		JLabel picLabel = new JLabel(new ImageIcon(myPicture));
		Shark.add(picLabel);
		*/

		Shark.setPreferredSize(new Dimension(1920, 1040));
		setLayout(new BorderLayout());
		this.add(Shark,BorderLayout.CENTER);
		setVisible(true);
	}

	public JPanel getShark() {
		return Shark;
	}

}

class background extends JComponent{
	
	private BufferedImage back;
	
	public background(){
		
	}
	
	public void paint(Graphics g){
		
	}
	
	
}



















