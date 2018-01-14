package views;

import java.util.Observable;
import java.util.Observer;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;


public class menuView extends BorderPane implements Observer {
	  private GraphicsContext gc;
	  private TopGUI topgui;
	  Image mode, social, stats, sos, help, userdropdown, bar, battery, logo, bg;
	//This function initializes the GUI, and get's the X and O images.
	  public menuView(TopGUI top) {
	    topgui = top;
	    Canvas canvas = new Canvas(540,960);
	    canvas.setOnMouseClicked(new MouseHandler());
		gc = canvas.getGraphicsContext2D(); 
		this.setTop(canvas);
		//this.setTop(infoLabel);
		//drawImage(gc);
		mode = new Image("file:assets/modes (1).png", false);
		bg = new Image("file:assets/vsco_062715.jpg", false);
		social = new Image("file:assets/social (1).png", false);
		stats = new Image("file:assets/stats (1).png", false);
		sos = new Image("file:assets/sos (1).png", false);
		help = new Image("file:assets/question.png", false);
		logo = new Image("file:assets/chaloLogo.png", false);
		//userdropdown = new Image("file:assets/question.png", false);
		bar = new Image("file:assets/bar (1).png", false);
		battery = new Image("file:assets/battery (1).png", false);
		this.gc.setFill(Color.WHITE);
		//this.gc.fillRect(0, 0, 540, 960);
		this.gc.drawImage(bg, 0, 0, 540, 960);
		this.gc.drawImage(bar, 0, 0, 540, 100);
		this.gc.drawImage(userdropdown, 25, 25, 50, 50);
		this.gc.drawImage(logo, 190, 0, 150, 150);
		
		this.gc.setFill(Color.WHITE);
		this.gc.setFont(Font.font("Arial", 34));
		this.gc.fillText("Adele", 25, 65);
		this.gc.drawImage(battery, 430, 30, 75, 35);
		this.gc.fillRect(433, 32, 50, 32);
		this.gc.setFont(Font.font("Arial", 19));
		this.gc.fillText("80%", 445, 84);
		this.gc.drawImage(mode, 55, 180, 170, 170);
		this.gc.drawImage(social, 55, 430, 170, 170);
		this.gc.drawImage(stats, 295, 180, 170, 170);
		this.gc.drawImage(sos, 295, 430, 170, 170);
		this.gc.drawImage(help, 440, 655, 80, 80);
		
		}
	  
	  public void update(Observable o, Object arg) {
			// TODO Auto-generated method stub
			
		}
	  
	  
	  private class MouseHandler implements EventHandler<MouseEvent> {
		    @Override
	//The function will dectect where the mouse clicked, see if the location corresponds with a valid action
	//and takes the action if it is valid
		    public void handle(MouseEvent arg0) {
		      	
		  	   	double x = arg0.getX();
		  	    double y = arg0.getY();
		  	    //Integer xpos =  (int) (Math.floor(y));
		  	    //Integer ypos =  (int) (Math.floor(x));
		  	    if (x > 40 && x < 240 && y > 180 && y < 370) {
		  	    	topgui.setViewTo(topgui.modeView);
		  	    }
		  	    if (x > 295 && x < 465 && y > 430 && y < 600) {
		  	    	topgui.setViewTo(topgui.sosView);
		  	    }
		  	    if (x > 55 && x < 225 && y > 430 && y < 600) {
		  	    	topgui.setViewTo(topgui.socialView);
		  	    }
		  	    if (x > 295 && x < 465 && y > 180 && y < 350) {
		  	    	topgui.setViewTo(topgui.statsView);
		  	    }
		  	  if (x > 440 && x < 520 && y > 655 && y < 735) {
		  	    	topgui.setViewTo(topgui.menuViewHelp);
		  	    }
		    }
	
}
	  }
		    