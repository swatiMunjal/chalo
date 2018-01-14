package views;

import java.util.Observer;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class TopGUI extends Application {

  public static void main(String[] args) {
    launch(args);
  }

  //private MenuBar menuBar;

  protected Observer currentView;
  protected Observer menuView;
  protected Observer menuViewHelp;
  protected Observer socialView;
  protected Observer socialViewHelp;
  protected Observer sosView;
  protected Observer sosViewHelp;
  protected Observer modeView;
  protected Observer modeViewHelp;
  protected Observer statsView;
  protected Observer chatView;
 
  private BorderPane window;
  public static final int width = 520;
  public static final int height = 960;

  public void start(Stage stage) {
    stage.setTitle("Chalo");
    stage.setResizable(false);
    window = new BorderPane();
    Scene scene = new Scene(window, width, height);

    //setupMenus();
    //window.setTop(menuBar);
    //initializeGameForTheFirstTime();

    // Set up the views
    menuView = new menuView(this);
    modeView = new modeView(this);
    modeViewHelp = new modeViewHelp(this);
    statsView = new statsView(this);
    sosView = new sosView(this);
    sosViewHelp = new sosViewHelp(this);
    socialView = new socialView(this);
    socialViewHelp = new socialViewHelp(this);
    chatView = new chatView(this);
    menuViewHelp = new menuViewHelp(this);
    
   
    setViewTo(menuView);
    stage.setScene(scene);
    stage.show();
  }
  

  public void setViewTo(Observer newView) {
    window.setCenter(null);
    Observer currentView = newView;
    window.setCenter((Node) currentView);
  }

}