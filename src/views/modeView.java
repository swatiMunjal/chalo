package views;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

import com.fazecast.jSerialComm.SerialPort;

import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class modeView extends BorderPane implements Observer {

	private GraphicsContext gc;
	  private TopGUI topgui;
	  Image dancing, cardio, heels, hiking, stairs, back, help, bar, battery, logo, bg;
	  PrintWriter output = null;
	  public modeView(TopGUI top) {
	    topgui = top;
	  //SerialPort serialPort;
		SerialPort[] ports = SerialPort.getCommPorts();
		//System.out.println("Select a port:");
		int i = 1;
		int chosenPort = 1;
		
		try {
		SerialPort serialPort = ports[chosenPort - 1];
		if(serialPort.openPort())
			System.out.println("Port opened successfully.");
		else {
			System.out.println("Unable to open the port.");
			return;
		}
		//serialPort.setComPortParameters(9600, 8, 1, SerialPort.NO_PARITY);
		serialPort.setComPortTimeouts(SerialPort.TIMEOUT_SCANNER, 0, 0);
		output = new PrintWriter(serialPort.getOutputStream());
		}
		catch (Exception e) {}
		Canvas canvas = new Canvas(540,960);
		canvas.setOnMouseClicked(new MouseHandler(output));
		gc = canvas.getGraphicsContext2D(); 
		this.setTop(canvas);
		//this.setTop(infoLabel);
		//drawImage(gc);
		cardio = new Image("file:assets/cardio (1).png", false);
		bg = new Image("file:assets/vsco_050215 copy.jpg", false);
		hiking = new Image("file:assets/hiking (1).png", false);
		heels = new Image("file:assets/heels (1).png", false);
		dancing = new Image("file:assets/dancing (1).png", false);
		stairs = new Image("file:assets/stairs (1).png", false);
		help = new Image("file:assets/question.png", false);
		logo = new Image("file:assets/chaloLogo.png", false);
		bar = new Image("file:assets/bar (1).png", false);
		back = new Image("file:assets/back.png", false);
		battery = new Image("file:assets/battery (1).png", false);
		this.gc.setFill(Color.DIMGRAY);
		//this.gc.fillRect(0, 0, 540, 960);
		this.gc.drawImage(bg, 0, 0, 540, 960);
		this.gc.drawImage(bar, 0, 0, 540, 100);
		this.gc.setFill(Color.WHITE);
		//this.gc.drawImage(userdropdown, 25, 25, 50, 50);
		this.gc.drawImage(battery, 430, 30, 75, 35);
		this.gc.fillRect(433, 32, 50, 32);
		this.gc.setFont(Font.font("Arial", 19));
		this.gc.fillText("80%", 445, 84);
		this.gc.drawImage(logo, 190, 0, 150, 150);
		this.gc.drawImage(cardio, 70, 140, 130, 150);
		this.gc.drawImage(hiking, 70, 330, 130, 160);
		this.gc.drawImage(stairs, 70, 520, 130, 150);
		this.gc.drawImage(heels, 310, 140, 130, 150);
		this.gc.drawImage(dancing, 310, 330, 130, 150);
		this.gc.drawImage(back, 310, 520, 130, 150);
		this.gc.drawImage(help, 440, 655, 80, 80);
		
		this.gc.setFill(Color.WHITE);
		this.gc.setFont(Font.font("Arial", 34));
		this.gc.fillText("Adele", 25, 65);
		//this.gc.drawImage(mode, 40, 180, 220, 220);
		//this.gc.drawImage(social, 40, 430, 220, 220);
		//this.gc.drawImage(stats, 280, 190, 200, 200);
		//this.gc.drawImage(sos, 280, 440, 200, 200);
		//this.gc.drawImage(help, 460, 860, 37, 37);
		
		}
	  
	  public void update(Observable o, Object arg) {
			// TODO Auto-generated method stub
			
		}
	  
	  
	  
	  private class MouseHandler implements EventHandler<MouseEvent> {
		    private PrintWriter outp;
		  	public MouseHandler(PrintWriter output) {
			outp = output;
		  	}
		

			@Override
	//The function will dectect where the mouse clicked, see if the location corresponds with a valid action
	//and takes the action if it is valid
		    public void handle(MouseEvent arg0) {
		      	
		  	   	double x = arg0.getX();
		  	    double y = arg0.getY();
		  	    //Integer xpos =  (int) (Math.floor(y));
		  	    //Integer ypos =  (int) (Math.floor(x));
		  	    if (x > 300 && x < 450 && y > 520 && y < 670) {
		  	    	topgui.setViewTo(topgui.menuView);
		  	    }
		  	  if (x > 440 && x < 520 && y > 655 && y < 735) {
		  	    	topgui.setViewTo(topgui.modeViewHelp);
			  	  }
		  	    if (outp != null) {
				if (x > 70 && x < 200 && y > 140 && y < 290) {
		  	    	this.mode("1", outp);
		  	    }
				if (x > 70 && x < 200 && y > 330 && y < 490) {
		  	    	this.mode("5", outp);
		  	    }
				if (x > 70 && x < 200 && y > 520 && y < 670) {
		  	    	this.mode("4", outp);
		  	    }
				if (x > 310 && x < 540 && y > 140 && y < 290) {
		  	    	this.mode("3", outp);
		  	    }
				if (x > 310 && x < 540 && y > 330 && y < 480) {
		  	    	this.mode("2", outp);
		  	    }
		  	   }
		    }
		    
		    public void mode(String line, PrintWriter output) {
				
				try{
					BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); 
					//String line = null;// Reading from System.in
					//while(true){
						//System.out.println("Enter a number: ");
						//line = reader.readLine();
						//if(line == null || line.length() < 1){
						//	System.exit(0);
						//	break;
						//}
						output.print(line);
						//once finished
						output.flush(); 				
					//}
					reader.close();
				}
				catch(Exception e){
					//try {Thread.sleep(100); } catch(Exception e) {break;}
					e.printStackTrace();
				}
							
			}
	  }
}
