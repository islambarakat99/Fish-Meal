import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JComponent;

public class GUI extends JComponent{

	private view sharkRobot;	 
	private int sharkX;
	private int sharkY;
	private int [][]fishes ;
	private int goX;
	private int goY;
	private boolean eating;
	private BufferedImage img = null;
	private BufferedImage[] fishesI;
	private boolean[] isEaten;
	
	public GUI(){
		
		sharkRobot = new view();
		sharkRobot.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				goX =e.getX();
				goY=e.getY();
				eating=true;
				
			
			}});
		
		sharkRobot.getShark().add(this,BorderLayout.CENTER);
		
		isEaten = new boolean[3];
		fishes = new int[4][2];
		
		/*for (int i=0;i<3;i++){
			for(int j=0;j<1;j++){
				fishes[i][j]=100;
			}
		}*/
		fishes[0][0]=100;
		fishes[0][1]=200;
		fishes[1][0]=500;
		fishes[1][1]=600;
		fishes[2][0]=500;
		fishes[2][1]=600;
		
		fishesI = new BufferedImage[4];
		
		draw();
		
		Thread animationThread = new Thread(new Runnable() {
            public void run() {
                while (true) {
                    repaint();
                    try {Thread.sleep(10);} catch (Exception ex) {}
                }
            }
        });

        animationThread.start();
	}
	
	 public void paintComponent(Graphics g) {
	      
		 	Graphics2D sharkGraph = (Graphics2D) g;
		 	Graphics2D fishOneGraph = (Graphics2D) g;
		 	Graphics2D fishTwoGraph = (Graphics2D) g;
		 	
		 	eat();
		 	shark(sharkGraph);
	        fishOne(fishOneGraph);
	        fishTwo(fishTwoGraph);
	        
	        
	    }
	public void draw(){
		
		//shark
		
		try {
				img = ImageIO.read( new File("sharkRobot.png" ));
			} catch (IOException e) {
				e.printStackTrace();
			}
		//fishes
		//fishOne
		try {
			fishesI[0] = ImageIO.read( new File("fishess.png" ));
		} catch (IOException e) {
			e.printStackTrace();
		}
		//fishTwo
		try {
			fishesI[1] = ImageIO.read( new File("fishess.png" ));
		} catch (IOException e) {
			e.printStackTrace();
		}
		//fishThree
		try {
			fishesI[2] = ImageIO.read( new File("fishess.png" ));
		} catch (IOException e) {
			e.printStackTrace();
		}
		 
	}
	
	public void shark(Graphics g){
		
		int x,y;
		int w = getWidth();// the size of the Screen here
        int h = getHeight();
		
        int sharkW = 311; // the size of the picture of the Shark
        int sharkH = 200;
        
        
		
		if(eating){
			x=goX-sharkW;
			y=goY-(sharkH/2);
		}
		else{
			x= sharkX+3;
			y= sharkY;
		}
			
		if (x > w + (sharkW/2)) {
            x = -sharkW/2;
        }
		 
		sharkX=x;
		sharkY=y;
		
		g.drawImage(img,x,y,this);
		
		eating=false;
	}
	
	public void fishOne(Graphics g){
		
		int x,y;
				
		
		int w = getWidth();// the size of the Screen here
        int h = getHeight();
        
        int fishW = 150; // the size of the picture of the Shark
        int fishH = 150;
        
        x= fishes[0][0]+2;
		y= fishes[0][1];
		
		
		
		if (x > w + (fishW/2)) {
			x = -fishW/2;
		}
		if(!isEaten[0]){
			g.drawImage(fishesI[0], x, y, this);
		}
		
		fishes[0][0]=x;
		fishes[0][1]=y;
	}
	
	public void fishTwo(Graphics g){
		int x,y;
				
		
		int w = getWidth();// the size of the Screen here
        int h = getHeight();
        
        int fishW = 150; // the size of the picture of the Shark
        int fishH = 150;
        
        x= fishes[1][0]+2;
		y= fishes[1][1];
		
		
		
		if (x > w + (fishW/2)) {
			x = -fishW/2;
		}
		if(!isEaten[1]){
			g.drawImage(fishesI[1], x, y, this);
		}
		
		fishes[1][0]=x;
		fishes[1][1]=y;
	}

	public void fishThree(Graphics g){
		int x,y;
				
		
		int w = getWidth();// the size of the Screen here
        int h = getHeight();
        
        int fishW = 150; // the size of the picture of the Shark
        int fishH = 150;
        
        x= fishes[2][0]+2;
		y= fishes[2][1];
		
		
		
		if (x > w + (fishW/2)) {
			x = -fishW/2;
		}
		if(!isEaten[2]){
			g.drawImage(fishesI[2], x, y, this);
		}
		
		fishes[2][0]=x;
		fishes[2][1]=y;
	}
	
	public void eat(){
		
		for(int i=0;i<3;i++){
			if(((fishes[i][0]+150)-sharkX)<=461&&((fishes[i][1]+200)-sharkY)<=350&&((fishes[i][0]+311)-sharkX)>0&&((fishes[i][1]+200)-sharkY)>0)
				isEaten[i]=true;
			
		}
	}
	
	public static void main(String[]args){
		GUI g = new GUI();
	}
}

