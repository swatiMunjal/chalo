package views;

import java.util.Observable;
import java.util.Observer;

import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;


public class sosView extends BorderPane implements Observer {
	private GraphicsContext gc;
	  private TopGUI topgui;
	  Image mode, rx, smile, at, help, userdropdown, bar, battery, logo, bg, back;
	//This function initializes the GUI, and get's the X and O images.
	  public sosView(TopGUI top) {
	    topgui = top;
	    Canvas canvas = new Canvas(540,960);
	    canvas.setOnMouseClicked(new MouseHandler());
		gc = canvas.getGraphicsContext2D(); 
		this.setTop(canvas);
		//this.setTop(infoLabel);
		//drawImage(gc);
		help = new Image("file:assets/question.png", false);
		logo = new Image("file:assets/chaloLogo.png", false);
		bar = new Image("file:assets/bar (1).png", false);
		back = new Image("file:assets/back.png", false);
		at = new Image("file:assets/at.png", false);
		rx = new Image("file:assets/med.png", false);
		smile = new Image("file:assets/em.png", false);
		
		
		battery = new Image("file:assets/battery (1).png", false);
		bg = new Image("file:assets/vsco_011915 copy.jpg", false);
		this.gc.drawImage(bg, 0, 0, 540, 960);
		this.gc.drawImage(bar, 0, 0, 540, 100);
		//this.gc.drawImage(userdropdown, 25, 25, 50, 50);
		this.gc.drawImage(battery, 430, 30, 75, 35);
		this.gc.setFill(Color.WHITE);
		this.gc.fillRect(433, 32, 50, 32);
		this.gc.setFont(Font.font("Arial", 19));
		this.gc.fillText("80%", 445, 84);
		this.gc.drawImage(logo, 190, 0, 150, 150);
		this.gc.drawImage(back, 30, 645, 60, 80);
		this.gc.drawImage(help, 440, 655, 80, 80);
		this.gc.drawImage(at, 145, 180, 240, 120);
		this.gc.drawImage(smile, 145, 375, 260, 120);
		this.gc.drawImage(rx, 150, 570, 240, 120);
		this.gc.setFill(Color.WHITE);
		this.gc.setFont(Font.font("Arial", 34));
		this.gc.fillText("Adele", 25, 65);
	
	
	
	
	  }
	

	@Override
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
	  	    if (x > 30 && x < 90 && y > 645 && y < 725) {
	  	    	topgui.setViewTo(topgui.menuView);
	  	    }
	  	  if (x > 440 && x < 520 && y > 655 && y < 735) {
	  	    	topgui.setViewTo(topgui.sosViewHelp);
	  	    }
	    }

}
}