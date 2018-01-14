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

public class modeViewHelp extends BorderPane implements Observer {
	private GraphicsContext gc;
	  private TopGUI topgui;
	  Image mode, donate, chat, feedback, help, userdropdown, bar, battery, logo, bg, back;
	  public modeViewHelp(TopGUI top) {
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
		donate = new Image("file:assets/donate.png", false);
		chat = new Image("file:assets/chat.png", false);
		feedback = new Image("file:assets/feedback.png", false);
		
		
		battery = new Image("file:assets/battery (1).png", false);
		bg = new Image("file:assets/vsco_021515.jpg", false);
		this.gc.drawImage(bg, 0, 0, 540, 960);
		this.gc.drawImage(bar, 0, 0, 540, 100);
		//this.gc.drawImage(userdropdown, 25, 25, 50, 50);
		this.gc.setFill(Color.WHITE);
		this.gc.drawImage(battery, 430, 30, 75, 35);
		this.gc.fillRect(433, 32, 50, 32);
		this.gc.setFont(Font.font("Arial", 19));
		this.gc.fillText("80%", 445, 84);
		this.gc.drawImage(logo, 190, 0, 150, 150);
		this.gc.drawImage(back, 30, 645, 60, 80);
		this.gc.drawImage(help, 440, 655, 80, 80);
		this.gc.setFill(Color.WHITE);
		this.gc.setFont(Font.font("Arial", 34));
		this.gc.fillText("Adele", 25, 65);
		this.gc.fillText("Lets get you into the action.\nModes for every type.", 30, 200);
		this.gc.setFont(Font.font("Arial", 26));
		this.gc.fillText("Dancing mode loosens up joint\nto let you flow with the music.", 30, 300);
		this.gc.fillText("Putting on shoes, or stepping into stilettos?\nHeels mode points your toes low.", 30, 375);
		this.gc.fillText("Need to get some elevation? Hiking mode\nunlocks your height for uneven terrain.", 30, 445);
		this.gc.fillText("If you're just looking for a run,\nCardio will keep your knees moving.", 30, 515);
		this.gc.fillText("If youre looking at some flights,\nStairs mode will adjust accordingly", 30, 590);
		
	
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
	  	    	topgui.setViewTo(topgui.modeView);
	  	    }
	    }
	}
}