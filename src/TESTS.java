import java.io.*;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import java.util.Calendar;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.geometry.Insets;
import javafx.scene.Group;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.scene.paint.Color;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.collections.*;
import javafx.scene.effect.*;
import java.util.*;

import javafx.animation.FadeTransition;
import javafx.scene.shape.Circle;
import java.util.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.paint.Color;
import javafx.animation.TranslateTransition;
import javafx.util.Duration;
import timertrial.Clock;
import javafx.animation.Animation;
import javafx.animation.Timeline;
import javafx.animation.KeyFrame;

import java.net.URL;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class TESTS extends Application
{
	MediaPlayer mediaPlayer;
	Media media;
	URL resourceC = getClass().getResource("sound effects/Correct_Answer.mp3");
	URL resourceW = getClass().getResource("sound effects/Wrong_Answer.mp3");
	//Global members
	int COUNT = 0;
	int SceneNumber = 0;
	//int called =0;
	Text game = new Text();
	int width = 850 , height = 500;	//width and height of the stage
	String tooltipattr = "-fx-background-color: white;"+"-fx-text-fill: black;"+"-fx-font-size: 15px;"+"-fx-font-weight: normal;"+
						 "-fx-font-family: 'Aerial';";
    Button credits = new Button("Credits");
    Tooltip tcredits = new Tooltip("View Credits.");
	Button contents = new Button("Contents");
    Tooltip tcontents = new Tooltip("Go to the front page.");
	Button trigger = new Button("Start");
    Button triggerback = new Button("Back");
    Button change = new Button("Change");
    Button btnB = new Button("Back");
    Button btnN = new Button("Next");
    Button exit = new Button("Exit");	//Used in all the scenes except scene0
    Separator sep = new Separator();
    Label copyright = new Label();
    Label cuc = new Label("Code Under Constructiuon.");
    Tooltip tbtnN = new Tooltip();
    Tooltip tbtnB = new Tooltip();
    Tooltip texit = new Tooltip();
    Button newgame = new Button("New Game");
    Button highscore = new Button("High Scores");
    Button instructions = new Button("Instructions");
    Button settings = new Button("Settings");
    Tooltip tnewgame = new Tooltip();
    Tooltip thighscore = new Tooltip();
    Tooltip tinstructions = new Tooltip();
    Tooltip tsettings = new Tooltip();
    CheckBox cbhighscore = new CheckBox("Save my game history.");
    Tooltip tcbhighscore = new Tooltip("Your game score will be saved in the system.");
    Button save = new Button("Save");
    Tooltip tsave = new Tooltip();
    Label invalid = new Label("Entered Data is Invalid. Please Check again.");
    TextField tf = new TextField();
    Tooltip ttf = new Tooltip("Enter name here.");
    Tooltip te = new Tooltip("Easy Mode: Answer each question in 30 seconds.");
	Tooltip tn = new Tooltip("Normal Mode: Answer each question in 20 seconds.");
	Tooltip tt = new Tooltip("Tough Mode: Answer each question in 10 seconds.");
	Tooltip tchange = new Tooltip("Change your name or other game settings.");
	ToggleGroup ent = new ToggleGroup();
	RadioButton e = new RadioButton("Easy");
	RadioButton n = new RadioButton("Normal");
	RadioButton t = new RadioButton("Tough");
	Boolean valid = false;	//for checking the player data entered is valid or not
	Text dots = new Text();
	Button deleteall = new Button("Delete All");	//for deleting high-score file
	Tooltip tdeleteall = new Tooltip("Press to delete all the records.");
    ComboBox<String> choosecategorybox;
	ObservableList<String> categorytypes = FXCollections.observableArrayList("Miscellaneous","Well-Known Brands","Technology","CEOs","Science","Comics","Common Acronyms","Bollywood","Fictions and Authors");
	Button o = new Button("Exit");	//Exit Button in SceneO
	Button begin = new Button("Start");
	Boolean firsttime = true;	//animation only on first time
	boolean jack = true;
	
	//Player members
    StringBuffer playernamex = new StringBuffer("");
    String playername = "null";
    int playerscore = 0;
    String choice = "Normal";
    int playerchoice = 1; //0: EASY		1: NORMAL	2: TOUGH
    String mode = "Normal (20 seconds per question.)";//String form of playerchoice
    boolean playerdetails = true;	//if true then store playername, playerscore, time in a dedicated text file(.txt)
    
    //Game members
    boolean score[]={false,false,false,false,false,false,false,false,false,false};	//for 10Ques = 10btns graphic RED GREEN YELLOW
    String question= null;	//current question
    int sleepcount = 20; //it stores the seconds to answer a question DEFAULT MODE: Normal (20sec.)
    String category = "Miscellaneous";
    
    //settings members:
    Boolean audio = true;
    Boolean playaudio = true;
    RadioButton classic = new RadioButton("Classic");
    RadioButton eclipse = new RadioButton("Eclipse");
    RadioButton moonlight = new RadioButton("Moonlight");
    RadioButton red = new RadioButton("Red");
    ToggleGroup layout = new ToggleGroup();
    CheckBox cbboldques = new CheckBox("Questions in bold font style");
    CheckBox cbboldopts = new CheckBox("Options in bold font style");
    Label settingsinvalid = new Label("Save Changes to go back.");
    CheckBox cbaudio = new CheckBox("Audio");
    Tooltip tcbboldques = new Tooltip("Questions are in bold font style. Options are in normal font style.");
    Tooltip tcbboldopts = new Tooltip("Options are in bold font style. Questions are in normal font style.");
    Tooltip tcbaudio = new Tooltip();
    Button restore = new Button("Restore Defaults");
    Tooltip trestore = new Tooltip("Change settings to default.");
    Button settingssave = new Button("Save Changes");
    Tooltip tsettingssave = new Tooltip("Apply changes to game layout.");
    int layoutindex = 0;	//0: Classic; 1: Eclipse; 2: Moonlight; 3: Red
    Boolean boldques = false;
    Boolean boldopts = false;
    HBox imagebox = new HBox();
    
    //game labels
    Label gamequestion = new Label();
    RadioButton gameopt1 = new RadioButton();
    RadioButton gameopt2 = new RadioButton();
    RadioButton gameopt3 = new RadioButton();
    RadioButton gameopt4 = new RadioButton();
    
    //game layouts below
    AnchorPane gamelayout = new AnchorPane();
    String quesfontnormal = "-fx-font-family: 'Aerial';"+"-fx-font-weight: normal;"+"-fx-font-size: 30px;";
    String optsfontnormal = "-fx-font-family: 'Aerial';"+"-fx-font-weight: normal;"+"-fx-font-size: 30px;";
    
    String quesfontbold = "-fx-font-family: 'Aerial';"+"-fx-font-weight: bold;"+"-fx-font-size: 30px;";
    String optsfontbold = "-fx-font-family: 'Aerial';"+"-fx-font-weight: bold;"+"-fx-font-size: 30px;";
    
    String layoutstyle0 = "-fx-background-color: '#D8D7D7';"+"-fx-text-fill: black;";
    String layoutstyle1 = "-fx-background-color: '#3874ED';"+"-fx-text-fill: goldenrod;";
    String layoutstyle2 = "-fx-background-color: '#535354';"+"-fx-text-fill: lightgray;";
    String layoutstyle3 = "-fx-background-color: '#48D6C8';"+"-fx-text-fill: red;";
    
    String timer;
    String timerstyle = "-fx-text-fill: black;";
    
    //preview box items
    Label boxquestion = new Label("Question xyz xyz xyz?");
    Label boxoption1 = new Label("Option1");
    Label boxoption2 = new Label("Option2");
    Label boxoption3 = new Label("Option3");
    Label boxoption4 = new Label("Option4");
    Label boxtime = new Label("00:13");
    Label boxcopyright = new Label("xxxx xxxx xx xxxxxxxx xxxxx.");
    Label dash = new Label();
    Label boxo1 = new Label("o");
    Label boxo2 = new Label("o");
    Label boxo3 = new Label("o");
    Label boxo4 = new Label("o");
    HBox box1 = new HBox();
    Separator box2 = new Separator();
    HBox box3 = new HBox();
    HBox rec0 = new HBox();
    HBox rec1 = new HBox();
    HBox rec2 = new HBox();
    HBox rec3 = new HBox();
    HBox rec4 = new HBox();
    HBox rec5 = new HBox();
    HBox rec6 = new HBox();
    HBox rec7 = new HBox();
    HBox rec8 = new HBox();
    HBox rec9 = new HBox();
    HBox recc = new HBox();
    HBox rece = new HBox();
    
    //game front page animation members
    TranslateTransition transition00 = new TranslateTransition();
	TranslateTransition transition01 = new TranslateTransition();
	TranslateTransition transition02 = new TranslateTransition();
	TranslateTransition transition03 = new TranslateTransition();
	TranslateTransition transition04 = new TranslateTransition();
	TranslateTransition transition05 = new TranslateTransition();
	TranslateTransition transition06 = new TranslateTransition();
	TranslateTransition transition07 = new TranslateTransition();
	TranslateTransition transition08 = new TranslateTransition();
	TranslateTransition transition09 = new TranslateTransition();
	TranslateTransition transition10 = new TranslateTransition();
    Circle cir00 = new Circle();
    Circle cir01 = new Circle();
    Circle cir02 = new Circle();
    Circle cir03 = new Circle();
    Circle cir04 = new Circle();
    Circle cir05 = new Circle();
    Circle cir06 = new Circle();
    Circle cir07 = new Circle();
    Circle cir08 = new Circle();
    Circle cir09 = new Circle();
    Circle cir10 = new Circle();
    //game glow
    TranslateTransition transition00g = new TranslateTransition();
	TranslateTransition transition01g = new TranslateTransition();
	TranslateTransition transition02g = new TranslateTransition();
	TranslateTransition transition03g = new TranslateTransition();
	TranslateTransition transition04g = new TranslateTransition();
	TranslateTransition transition05g = new TranslateTransition();
	TranslateTransition transition06g = new TranslateTransition();
	TranslateTransition transition07g = new TranslateTransition();
	TranslateTransition transition08g = new TranslateTransition();
	TranslateTransition transition09g= new TranslateTransition();
	TranslateTransition transition10g = new TranslateTransition();
    
    //Front page button animation
    TranslateTransition transitionS = new TranslateTransition();
	TranslateTransition transitionE = new TranslateTransition();
    
	//Main-Menu animation
	TranslateTransition transitionNG = new TranslateTransition();
	TranslateTransition transitionHS = new TranslateTransition();
	TranslateTransition transitionI = new TranslateTransition();
	TranslateTransition transitionSet = new TranslateTransition();
	TranslateTransition transitionBack = new TranslateTransition();
	TranslateTransition transitionNext = new TranslateTransition();
	TranslateTransition transitionExit = new TranslateTransition();
	
	//Game Display Questions
	String Q1, Q2, Q3, Q4, Q5, Q6, Q7, Q8, Q9, Q10;//stores 10 questions which are to be displayed in the game
	int ANSWER;//stores current CORRECT answer
	int UA;//stores current USER answer
	int SCORE = 0;//stores score made by the player each question: 10 points
	String QUESTION;//stores current question
	String OPTION1, OPTION2, OPTION3, OPTION4; //Stores options
	Label questionC = new Label();
	RadioButton OPT1C = new RadioButton("NULL");
    RadioButton OPT2C = new RadioButton("NULL");
    RadioButton OPT3C = new RadioButton("NULL");
    RadioButton OPT4C = new RadioButton("NULL");
    ToggleGroup OPT = new ToggleGroup();
	Button pause = new Button();
	
	//GamePage(s) boxes 
	Button lebx1 = new Button();
	Button lebx2 = new Button();
	Button lebx3 = new Button();
	Button lebx4 = new Button();
	Button lebx5 = new Button();
	Button lebx6 = new Button();
	Button lebx7 = new Button();
	Button lebx8 = new Button();
	Button lebx9 = new Button();
	Button lebx10 = new Button();
	
	//Members for txt file
	String month[] = {"Jan" , "Feb" , "Mar" , "Apr" , "May" , "Jun" , "Jul" , "Aug" , "Sep" , "Oct" , "Nov" , "Dec"};
    String day[] = {"Sun" , "Mon" , "Tue" , "Wed" , "Thu" , "Fri" , "Sat"};
    
    String time = "";
    String date = "";
    String bar = "x....................x";
	
    public TESTS()
    {
    	OPT1C.setToggleGroup(OPT);
    	OPT2C.setToggleGroup(OPT);
    	OPT3C.setToggleGroup(OPT);
    	OPT4C.setToggleGroup(OPT);
    	begin.setDisable(true);
    	o.setDisable(true);
    	
    	begin.setPrefHeight(115.0);
    	begin.setPrefWidth(590.0);
    	o.setPrefHeight(63.0);
    	o.setPrefWidth(590);
    	game.setOpacity(0.0);
    	dots.setOpacity(0.0);
    	
    	copyright.setText((char)169 + " All Rights Reserved by Ashutosh Paul.");
    	
    	//pause button Transition(3->2->1) window
    	pause.setText("| |");
    	pause.setPrefSize(50.0, 50.0);
    	
    	//Main-Menu
    	newgame.setPrefHeight(73.0);
    	newgame.setPrefWidth(590);
    	highscore.setPrefHeight(73.0);
    	highscore.setPrefWidth(590);
    	instructions.setPrefHeight(73.0);
    	instructions.setPrefWidth(590);
    	settings.setPrefHeight(73.0);
    	settings.setPrefWidth(590);
    	btnB.setPrefHeight(45.0);
    	btnB.setPrefWidth(100.0);
    	btnN.setPrefHeight(45.0);
    	btnN.setPrefWidth(100.0);
    	exit.setPrefHeight(45.0);
    	exit.setPrefWidth(100.0);
    	
    	//settings default
    	classic.setSelected(true);
    	cbboldques.setSelected(false);
    	cbboldopts.setSelected(false);
    	cbaudio.setSelected(true);
    	audio = true;
    	
    	choosecategorybox = new ComboBox<String>(categorytypes);
    	choosecategorybox.setValue("Miscellaneous");
    	
    	//NewGamePage1() member attributes
    	e.setStyle("-fx-font-family: 'Calibri';"+"-fx-font-size: 19px;");
    	n.setStyle("-fx-font-family: 'Calibri';"+"-fx-font-size: 19px;");
    	t.setStyle("-fx-font-family: 'Calibri';"+"-fx-font-size: 19px;");
    	e.setToggleGroup(ent);
    	n.setToggleGroup(ent);
    	t.setToggleGroup(ent);
    	n.setSelected(true);
    	
    	classic.setToggleGroup(layout);
    	eclipse.setToggleGroup(layout);
    	moonlight.setToggleGroup(layout);
    	red.setToggleGroup(layout);
    	classic.setSelected(true);
    	
    	cbhighscore.setSelected(true); 		//initially stores player data in .txt file
    	
    	//preview box in Settings(Stage s)
    	dash.setText("________________________________________");
    	imagebox.setStyle("-fx-border-color: black;"+"-fx-border-width: 3px;"+"-fx-background-color: gainsboro;");
    	dash.setStyle("-fx-text-fill: black;"+"-fx-background-color: gainsboro;"+"-fx-font-weight: bold;");
    	boxquestion.setStyle("-fx-font-size: 10px;");
    	boxoption1.setStyle("-fx-font-size: 10px;");
    	boxoption2.setStyle("-fx-font-size: 10px;");
    	boxoption3.setStyle("-fx-font-size: 10px;");
    	boxoption4.setStyle("-fx-font-size: 10px;");
    	boxcopyright.setStyle("-fx-text-fill:  purple;"+"-fx-font-size: 5px;");
    	boxtime.setStyle("-fx-text-fill: black;" + "-fx-font-size: 10px;" + "-fx-font-family: 'Aerial';");
    	boxo1.setStyle("-fx-text-fill: white;"+"-fx-font-size: 10px;"+"-fx-font-weight: normal;"+"-fx-font-family: 'Bauhaus 93';");
    	boxo2.setStyle("-fx-text-fill: white;"+"-fx-font-size: 10px;"+"-fx-font-weight: normal;"+"-fx-font-family: 'Bauhaus 93';");
    	boxo3.setStyle("-fx-text-fill: white;"+"-fx-font-size: 10px;"+"-fx-font-weight: normal;"+"-fx-font-family: 'Bauhaus 93';");
    	boxo4.setStyle("-fx-text-fill: white;"+"-fx-font-size: 10px;"+"-fx-font-weight: normal;"+"-fx-font-family: 'Bauhaus 93';");
    	box1.setStyle("-fx-border-color: black;");
    	box3.setStyle("-fx-border-color: black;");
    	rec0.setStyle("-fx-background-color: green;");
    	rec1.setStyle("-fx-background-color: green;");
    	rec2.setStyle("-fx-background-color: red;");
    	rec3.setStyle("-fx-background-color: green;");
    	rec4.setStyle("-fx-background-color: red;");
    	rec5.setStyle("-fx-background-color: green;");
    	rec6.setStyle("-fx-background-color: green;");
    	rec7.setStyle("-fx-background-color: blue;");
    	rec8.setStyle("-fx-background-color: '#1E90FF';");
    	rec9.setStyle("-fx-background-color: '#1E90FF';");
    	recc.setStyle("-fx-background-color: darkviolet;");
    	rece.setStyle("-fx-background-color: firebrick;");
    	
    	
    	
    	//default game layout
    	gamelayout.setStyle(layoutstyle0);
    	gamequestion.setStyle(quesfontnormal);
    	gameopt1.setStyle(optsfontnormal);
    	gameopt2.setStyle(optsfontnormal);
    	gameopt3.setStyle(optsfontnormal);
    	gameopt4.setStyle(optsfontnormal);
    	
    	//animation circle attributes
    	cir00.setRadius(43);
    	cir01.setRadius(43);
    	cir02.setRadius(43);
    	cir03.setRadius(43);
    	cir04.setRadius(43);
    	cir05.setRadius(43);
    	cir06.setRadius(43);
    	cir07.setRadius(43);
    	cir08.setRadius(43);
    	cir09.setRadius(43);
    	cir10.setRadius(43);
    	
    	cir00.setLayoutX(953);	cir00.setLayoutY(130);
		cir01.setLayoutX(953);	cir01.setLayoutY(130);
		cir02.setLayoutX(953);	cir02.setLayoutY(130);
		cir03.setLayoutX(953);	cir03.setLayoutY(130);
		cir04.setLayoutX(953);	cir04.setLayoutY(130);
		cir05.setLayoutX(953);	cir05.setLayoutY(130);
		cir06.setLayoutX(953);	cir06.setLayoutY(130);
		cir07.setLayoutX(953);	cir07.setLayoutY(130);
		cir08.setLayoutX(953);	cir08.setLayoutY(130);
		cir09.setLayoutX(953);	cir09.setLayoutY(130);
		cir10.setLayoutX(953);	cir10.setLayoutY(130);
    	
		begin.setLayoutX(-600);	begin.setLayoutY(270);
		o.setLayoutX(960);	o.setLayoutY(400);
		
		cir00.setFill(Color.INDIANRED);
    	cir01.setFill(Color.LIGHTGOLDENRODYELLOW);
    	cir02.setFill(Color.CADETBLUE);
    	cir03.setFill(Color.PALEVIOLETRED);
    	cir04.setFill(Color.TEAL);
    	cir05.setFill(Color.CHARTREUSE);
    	cir06.setFill(Color.PERU);
    	cir07.setFill(Color.DARKORANGE);
    	cir08.setFill(Color.KHAKI);
    	cir09.setFill(Color.OLIVE);
    	cir10.setFill(Color.LIGHTGREEN);
    	
    	transition00.setNode(cir00);
   	 	transition01.setNode(cir01);
   	 	transition02.setNode(cir02);
   	 	transition03.setNode(cir03);
   	 	transition04.setNode(cir04);
   	 	transition05.setNode(cir05);
   	 	transition06.setNode(cir06);
   	 	transition07.setNode(cir07);
   	 	transition08.setNode(cir08);
   	 	transition09.setNode(cir09);
   	 	transition10.setNode(cir10);
    	
   	 	transitionS.setNode(begin);
	 	transitionE.setNode(o);
   	 	
    	String triggerattr = "-fx-background-color: hotpink;" +
    			 		     "-fx-text-fill: #8a0000;" +
    			 		     "-fx-font-family: 'Bahnschrift Light SemiCondensed';" +
    			 		     "-fx-font-size: 40px;";
    	String triggerbackattr = "-fx-background-color: #8a0000;" + 
		 		 			 	 "-fx-text-fill: hotpink;" +
		 		 			 	 "-fx-font-family: 'Bahnschrift Light SemiCondensed';" +
		 		 			 	 "-fx-font-size: 25px;";
    	String settingsrbattr = "-fx-font-weight: normal;" +
		 		 			 	"-fx-text-fill: black;" +
    							"-fx-font-family: 'Courier New';" +
    							"-fx-font-size: 20px;";
    	String settingscbattr = "-fx-font-weight: normal;" +
    							"-fx-text-fill: black;" +
				                "-fx-font-family: 'Calibri';" +
				                "-fx-font-size: 18px;";
    	String settingaudiobattr = "-fx-font-weight: normal;" +
	 			 				   "-fx-text-fill: black;" +
                                   "-fx-font-family: 'Bauhaus 93';" +
                                   "-fx-font-size: 24px;";
    	
    	
    	trigger.setStyle(triggerattr);
    	triggerback.setStyle(triggerbackattr);
    	
    	//settings members
    	classic.setStyle(settingsrbattr);
    	eclipse.setStyle(settingsrbattr);
    	moonlight.setStyle(settingsrbattr);
    	red.setStyle(settingsrbattr);
    	
    	cbboldques.setStyle(settingscbattr);
    	cbboldopts.setStyle(settingscbattr);
    	
    	cbaudio.setStyle(settingaudiobattr);
    	//setting members ends.
    	
    	tf.setStyle("-fx-font-family: 'Bahnschrift Light';"+"-fx-font-size: 18px;"+"-fx-font-weight: bold;");
    	invalid.setStyle("-fx-text-fill: red;");
    	invalid.setVisible(false);
    	copyright.setStyle("-fx-text-fill: blue;");
    	tbtnB.setText("Press to Go Back.");
		tbtnN.setText("Press to Go to the Next Screen.");
		texit.setText("Press to Close the Window.");
		tsave.setText("Press to save entered data.");
    	tcbaudio.setText("Press to enable/disable audio.");
		
		//setStyle() in Tooltips.
    	String btnBNEattr = "-fx-background-color: white;"+"-fx-text-fill: black;"+"-fx-font-size: 13px;"+"-fx-font-weight: normal;"+
				 			"-fx-font-family: 'Aerial';";
    	tbtnB.setStyle(btnBNEattr);
    	tbtnN.setStyle(btnBNEattr);
    	texit.setStyle(btnBNEattr);
    	tsave.setStyle(btnBNEattr);
    	te.setStyle(btnBNEattr);
    	tn.setStyle(btnBNEattr);
    	tt.setStyle(btnBNEattr);
    	ttf.setStyle(btnBNEattr);
    	tcbhighscore.setStyle(btnBNEattr);
    	tchange.setStyle(btnBNEattr);
    	tcontents.setStyle(btnBNEattr);
    	tsettings.setStyle(btnBNEattr);
    	tcbboldques.setStyle(btnBNEattr);
    	tcbboldopts.setStyle(btnBNEattr);
    	tcbaudio.setStyle(btnBNEattr);
    	trestore.setStyle(btnBNEattr);
    	tsettingssave.setStyle(btnBNEattr);
    	tcredits.setStyle(btnBNEattr);
    	tdeleteall.setStyle(btnBNEattr);
    	
    	btnB.setTooltip(tbtnB);
    	btnN.setTooltip(tbtnN);
    	exit.setTooltip(texit);
    	save.setTooltip(tsave);
    	e.setTooltip(te);
    	n.setTooltip(tn);
    	t.setTooltip(tt);
    	tf.setTooltip(ttf);
    	cbhighscore.setTooltip(tcbhighscore);
    	change.setTooltip(tchange);
    	contents.setTooltip(tcontents);
    	restore.setTooltip(trestore);
    	cbboldques.setTooltip(tcbboldques);
    	cbboldopts.setTooltip(tcbboldopts);
    	cbaudio.setTooltip(tcbaudio);
    	settingssave.setTooltip(tsettingssave);
    	credits.setTooltip(tcredits);
    	deleteall.setTooltip(tdeleteall);
    	
    }
    public void Hovering(Button btn)
    {
    	String btnattr="-fx-background-color: deepskyblue;"+"-fx-text-fill: mediumblue;"+"-fx-font-weight: bold;"+
						"-fx-font-size: 20px;" + 
						"-fx-font-family: 'Cambria';";
		btn.setStyle(btnattr);
    }
    public void Pressed(Button btn)
    {
		String btnattr="-fx-background-color: mediumblue;"+"-fx-text-fill: white;"+"-fx-font-size: 22px;"+"-fx-font-weight: bold;"+
						"-fx-font-family: 'Cambria';";
    	btn.setStyle(btnattr);
		
    }
    public void Released()	//To setStyle() to btnN, btnB exit Default mode OR Released Mode
    {
    	String btnattr="-fx-background-color: lightskyblue;"+"-fx-text-fill: indigo;"+"-fx-font-size: 18px;"+
    					"-fx-font-family: 'Cambria';";
    	
    	btnN.setStyle(btnattr);
    	btnB.setStyle(btnattr);
		exit.setStyle(btnattr);
		
    }
    public void Instructions(Stage s)
    {
    	if(audio == true)
	   	 {
	   	 	URL resource = getClass().getResource("sound effects/open.mp3");
	   	     try
	   	     {
	   	 	   	Media media = new Media(resource.toString());
	   	 	   	if(media.getError() == null || media.getOnError() == null)
	   	 	   	{
	   	 	   		mediaPlayer = new MediaPlayer(media);
	   	 	   		mediaPlayer.setStartTime(Duration.seconds(1.61));
	   	 	   		mediaPlayer.setVolume(0.5);
	   	 	   		mediaPlayer.play();
	   	 	   	}
	   	     }
	   	     catch(Exception e)
	   	     {}
	   	 }
    	btnN.setDisable(true);
    	btnB.setOnAction(e-> Main_Menu(s));
    	
    	String content = " There are TEN questions in total.\n Each question holds TEN points.\n THREE levels are available\n EASY :  You have got  30  seconds to answer each question.\n NORMAL :  You have got  20  seconds to answer each question.\n TOUGH :  You have got  10  seconds to answer each question.\n Time exceeded will END the game.";
    	Text instructionlist =  new Text(content);
    	
    	HBox box = new HBox();
    	box.setStyle("-fx-background-color: linen;" + "-fx-border-color: black;" + "-fx-text-fill: black;");
    	box.getChildren().addAll(instructionlist);
    	
    	Label ins0 = new Label("instructions");
    	ins0.setStyle("-fx-text-fill: darkred;"+"-fx-font-size: 30px;"+"-fx-font-weight: bold;");
    	Separator ins0sep = new Separator();
    	ins0sep.setPrefWidth(width-50);
    	ins0sep.setStyle("-fx-background-color: darkred;");
    	
    	AnchorPane root = new AnchorPane();
    	
    	//Positioning ins0sep
    	AnchorPane.setTopAnchor(ins0sep, 49.0);
    	AnchorPane.setLeftAnchor(ins0sep, 25.0);
    	//Positioning ins0
    	AnchorPane.setTopAnchor(ins0, 12.0);
    	AnchorPane.setLeftAnchor(ins0, 30.0);
    	//Positioning box
    	AnchorPane.setTopAnchor(box, 69.0);
    	AnchorPane.setLeftAnchor(box, 33.0);
    	AnchorPane.setRightAnchor(box, 33.0);
    	AnchorPane.setBottomAnchor(box, 96.0);
    	
    	root.getChildren().addAll(ins0, ins0sep, box,btnB, btnN, sep, exit, copyright);
    	root.setStyle("-fx-background-color: bisque;");
    	Scene ins = new Scene(root, width, height);
    	s.setScene(ins);
    	s.show();
    }
    public void ViewCredits(Stage s)
    {
    	if(audio == true)
    	{
    		URL resource = getClass().getResource("sound effects/open.mp3");
    	    try
    	    {
    		   	Media media = new Media(resource.toString());
    		   	if(media.getError() == null || media.getOnError() == null)
    		   	{
    		   		mediaPlayer = new MediaPlayer(media);
    		   		mediaPlayer.setStartTime(Duration.seconds(1.61));
    		   		mediaPlayer.setVolume(0.5);
    		   		mediaPlayer.play();
    		   	}
    	    }
    	    catch(Exception e)
    	    {}
    	}
    	btnB.setDisable(false);
    	btnB.setOnAction(e-> Settings(s));
    	btnN.setDisable(true);
    	Label creditdisplay = new Label(" This game is developed by Ashutosh Paul.\n Date: July, 2018");
    	Label chead = new Label("credits");
    	chead.setStyle("-fx-text-fill: darkred;"+"-fx-font-size: 30px;"+"-fx-font-weight: bold;");
    	Separator cheadsep = new Separator();
    	cheadsep.setPrefWidth(width-50);
    	cheadsep.setStyle("-fx-background-color: darkred;");
    	HBox box = new HBox();
    	box.setStyle("-fx-background-color: linen;" + "-fx-border-color: black;" + "-fx-text-fill: black;");
    	box.getChildren().add(creditdisplay);
    	AnchorPane root = new AnchorPane();
    	//Positioning sheadsep
    	AnchorPane.setTopAnchor(cheadsep, 49.0);
    	AnchorPane.setLeftAnchor(cheadsep, 25.0);
    	//Positioning shead
    	AnchorPane.setTopAnchor(chead, 7.0);
    	AnchorPane.setLeftAnchor(chead, 30.0);
    	//Positioning box
    	AnchorPane.setTopAnchor(box, 69.0);
    	AnchorPane.setLeftAnchor(box, 33.0);
    	AnchorPane.setRightAnchor(box, 33.0);
    	AnchorPane.setBottomAnchor(box, 96.0);
    	root.setStyle("-fx-background-color: bisque;");
    	root.getChildren().addAll(chead, cheadsep, box, sep, copyright, btnB, btnN, exit);
    	Scene cscene = new Scene(root , width , height);
    	s.setScene(cscene);
    	s.show();
    }
    public void RestoreSettings()	//called from Settings()
    {
    	if(audio == true)
    	{
    		URL resource = getClass().getResource("sound effects/open.mp3");
    	    try
    	    {
    		   	Media media = new Media(resource.toString());
    		   	if(media.getError() == null || media.getOnError() == null)
    		   	{
    		   		mediaPlayer = new MediaPlayer(media);
    		   		mediaPlayer.setStartTime(Duration.seconds(1.61));
    		   		mediaPlayer.setVolume(0.5);
    		   		mediaPlayer.play();
    		   	}
    	    }
    	    catch(Exception e)
    	    {}
    	}
    	credits.setDisable(true);
    	btnB.setDisable(true);
    	settingsinvalid.setVisible(true);
    	imagebox.setStyle("-fx-border-color: black;"+"-fx-border-width: 3px;"+layoutstyle0);
		boxquestion.setStyle("-fx-text-fill: black;"+"-fx-font-size: 10px;");
		boxoption1.setStyle("-fx-text-fill: black;"+"-fx-font-size: 10px;");
		boxoption2.setStyle("-fx-text-fill: black;"+"-fx-font-size: 10px;");
		boxoption3.setStyle("-fx-text-fill: black;"+"-fx-font-size: 10px;");
		boxoption4.setStyle("-fx-text-fill: black;"+"-fx-font-size: 10px;");
		boxtime.setStyle("-fx-text-fill: black;" + "-fx-font-size: 10px;" + "-fx-font-family: 'Aerial';");
		dash.setStyle("-fx-background-color: gainsboro;");
		timerstyle = "-fx-text-fill: black;"; //timer text-fill-color
		classic.setSelected(true);
    	cbboldques.setSelected(false);
    	cbboldopts.setSelected(false);
    	cbaudio.setSelected(true);
    	audio = true;
    	settingssave.setDisable(false);
    	restore.setDisable(true);
    	box1.setStyle("-fx-border-color: black;");
		box3.setStyle("-fx-border-color: black;");
    }
    public void NextLayout()	//layout at which the game would run
    {
    	//changing layout
    	if(layoutindex == 0)
    		gamelayout.setStyle(layoutstyle0);
    	else if(layoutindex == 1)
    		gamelayout.setStyle(layoutstyle1);
    	else if(layoutindex == 2)
    		gamelayout.setStyle(layoutstyle2);
    	else if(layoutindex == 3)
    		gamelayout.setStyle(layoutstyle3);
    	
    	//question font weight
    	if(boldques == true)
    		gamequestion.setStyle(quesfontbold);
    	else if(boldques == false)
    		gamequestion.setStyle(quesfontnormal);
    	
    	//options font weight
    	if(boldopts == true)
    	{
    		gameopt1.setStyle(optsfontbold);
    		gameopt2.setStyle(optsfontbold);
    		gameopt3.setStyle(optsfontbold);
    		gameopt4.setStyle(optsfontbold);
    	}
    	else if(boldopts == false)
    	{
    		gameopt1.setStyle(optsfontnormal);
    		gameopt2.setStyle(optsfontnormal);
    		gameopt3.setStyle(optsfontnormal);
    		gameopt4.setStyle(optsfontnormal);
    	}
    	
    }
    public void SettingsSavePressed()
    {
    	if(audio == true)
    	{
    		URL resource = getClass().getResource("sound effects/open.mp3");
    	    try
    	    {
    		   	Media media = new Media(resource.toString());
    		   	if(media.getError() == null || media.getOnError() == null)
    		   	{
    		   		mediaPlayer = new MediaPlayer(media);
    		   		mediaPlayer.setStartTime(Duration.seconds(1.61));
    		   		mediaPlayer.setVolume(0.5);
    		   		mediaPlayer.play();
    		   	}
    	    }
    	    catch(Exception e)
    	    {}
    	}
    	credits.setDisable(false);
    	settingsinvalid.setVisible(false);
    	btnB.setDisable(false);
    	settingssave.setDisable(true);
    	RadioButton on = (RadioButton) layout.getSelectedToggle();
    	String selectedlayout = on.getText();
    	if(selectedlayout.equals("Classic") == true)
    		layoutindex = 0;
    	else if(selectedlayout.equals("Eclipse") == true)
    		layoutindex = 1;
    	else if(selectedlayout.equals("Moonlight") == true)
    		layoutindex = 2;
    	else if(selectedlayout.equals("Red") == true)
    		layoutindex = 3;
    	
    	if(cbboldques.isSelected() == true)
    		boldques= true;
    	else
    		boldques = false;
    	
    	if(cbboldopts.isSelected() == true)
    		boldopts = true;
    	else
    		boldopts = false;
    	
    	if(cbaudio.isSelected() == true)
    		audio = true;
    	else
    		audio = false;
    	
    	NextLayout();
    	
    }
    
    public void CurrentPreview(int s)	//displays the game layout in Settings(Stage s) of the selected radiobutton
    {
    	if(s == 0)	//classic
    	{
    		imagebox.setStyle("-fx-border-color: black;"+"-fx-border-width: 3px;"+layoutstyle0);
    		dash.setStyle("-fx-text-fill: black;"+"-fx-background-color: '#D8D7D7';"+"-fx-font-weight: bold;");
    		boxtime.setStyle("-fx-text-fill: black;" + "-fx-font-size: 10px;" + "-fx-font-family: 'Aerial';");
    		boxquestion.setStyle("-fx-text-fill: black;"+"-fx-font-size: 10px;");
    		boxoption1.setStyle("-fx-text-fill: black;"+"-fx-font-size: 10px;");
    		boxoption2.setStyle("-fx-text-fill: black;"+"-fx-font-size: 10px;");
    		boxoption3.setStyle("-fx-text-fill: black;"+"-fx-font-size: 10px;");
    		boxoption4.setStyle("-fx-text-fill: black;"+"-fx-font-size: 10px;");
    		box1.setStyle("-fx-border-color: black;");
    		box3.setStyle("-fx-border-color: black;");
    		timerstyle = "-fx-text-fill: black;"; //timer text-fill-color
    	}
    	else if(s == 1)	//eclipse
    	{
    		imagebox.setStyle("-fx-border-color: black;"+"-fx-border-width: 3px;"+layoutstyle1);
    		dash.setStyle("-fx-text-fill: '#EFD10F';"+"-fx-background-color: '#3874ED';"+"-fx-font-weight: bold;");
    		boxtime.setStyle("-fx-text-fill: '#EFD10F';" + "-fx-font-size: 10px;" + "-fx-font-family: 'Aerial';");
    		boxquestion.setStyle("-fx-text-fill: '#EFD10F';"+"-fx-font-size: 10px;");
    		boxoption1.setStyle("-fx-text-fill: '#EFD10F';"+"-fx-font-size: 10px;");
    		boxoption2.setStyle("-fx-text-fill: '#EFD10F';"+"-fx-font-size: 10px;");
    		boxoption3.setStyle("-fx-text-fill: '#EFD10F';"+"-fx-font-size: 10px;");
    		boxoption4.setStyle("-fx-text-fill: '#EFD10F';"+"-fx-font-size: 10px;");
    		box1.setStyle("-fx-border-color: '#EFD10F';");
    		box3.setStyle("-fx-border-color: '#EFD10F';");
    		timerstyle = "-fx-text-fill: black;"; //timer text-fill-color
    	}
    	else if(s == 2)	//moonlight
    	{
    		imagebox.setStyle("-fx-border-color: black;"+"-fx-border-width: 3px;"+layoutstyle2);
    		dash.setStyle("-fx-text-fill: '#CDCDCD';"+"-fx-background-color: '#535354';"+"-fx-font-weight: bold;");
    		boxtime.setStyle("-fx-text-fill: '#CDCDCD';" + "-fx-font-size: 10px;" + "-fx-font-family: 'Aerial';");
    		boxquestion.setStyle("-fx-text-fill: '#CDCDCD';"+"-fx-font-size: 10px;");
    		boxoption1.setStyle("-fx-text-fill: '#CDCDCD';"+"-fx-font-size: 10px;");
    		boxoption2.setStyle("-fx-text-fill: '#CDCDCD';"+"-fx-font-size: 10px;");
    		boxoption3.setStyle("-fx-text-fill: '#CDCDCD';"+"-fx-font-size: 10px;");
    		boxoption4.setStyle("-fx-text-fill: '#CDCDCD';"+"-fx-font-size: 10px;");
    		box1.setStyle("-fx-border-color: '#CDCDCD';");
    		box3.setStyle("-fx-border-color: '#CDCDCD';");
    		timerstyle = "-fx-text-fill: black;"; //timer text-fill-color
    	}
    	else if(s == 3)	//red
    	{
    		imagebox.setStyle("-fx-border-color: black;"+"-fx-border-width: 3px;"+layoutstyle3);
    		dash.setStyle("-fx-text-fill: '#BF0701';"+"-fx-background-color: '#48D6C8';"+"-fx-font-weight: bold;");
    		boxtime.setStyle("-fx-text-fill: '#BF0701';" + "-fx-font-size: 10px;" + "-fx-font-family: 'Aerial';");
    		boxquestion.setStyle("-fx-text-fill: '#BF0701';"+"-fx-font-size: 10px;");
    		boxoption1.setStyle("-fx-text-fill: '#BF0701';"+"-fx-font-size: 10px;");
    		boxoption2.setStyle("-fx-text-fill: '#BF0701';"+"-fx-font-size: 10px;");
    		boxoption3.setStyle("-fx-text-fill: '#BF0701';"+"-fx-font-size: 10px;");
    		boxoption4.setStyle("-fx-text-fill: '#BF0701';"+"-fx-font-size: 10px;");
    		box1.setStyle("-fx-border-color: '#BF0701';");
    		box3.setStyle("-fx-border-color: '#BF0701';");
    		timerstyle = "-fx-text-fill: red;";	//timer text-fill-color
    	}
    }
    public void SettingsChanged(Stage s , int h)
    {
    	credits.setDisable(true);
    	settingsinvalid.setVisible(true);
    	btnB.setDisable(true);
    	settingssave.setDisable(false);
    	restore.setDisable(false);
    	if(h>=0 && h<=3)
    	{
    		CurrentPreview(h);	//sets preview imagebox
    	}
    }
    public void Settings(Stage s)
    {
    	if(audio == true)
	   	 {
	   	 	URL resource = getClass().getResource("sound effects/open.mp3");
	   	     try
	   	     {
	   	 	   	Media media = new Media(resource.toString());
	   	 	   	if(media.getError() == null || media.getOnError() == null)
	   	 	   	{
	   	 	   		mediaPlayer = new MediaPlayer(media);
	   	 	   		mediaPlayer.setStartTime(Duration.seconds(1.61));
	   	 	   		mediaPlayer.setVolume(0.5);
	   	 	   		mediaPlayer.play();
	   	 	   	}
	   	     }
	   	     catch(Exception e)
	   	     {}
	   	 }
    	credits.setDisable(false);
    	settingsinvalid.setVisible(false);
    	settingssave.setDisable(true);
    	//restore button settings.
    	if(layoutindex == 0 && boldques == false && boldopts == false && audio == true)	//defaults are selected
    	{		
    		restore.setDisable(true);
    	}
    	else
    	{	
    		restore.setDisable(false);
    	}
    	btnN.setDisable(true);
    	btnB.setOnAction(e-> Main_Menu(s));
    	restore.setOnAction(e-> RestoreSettings());
    	settingssave.setOnAction(e-> SettingsSavePressed());
    	credits.setOnAction(e-> ViewCredits(s));
    	
    	classic.setOnAction(e-> SettingsChanged(s,0));
    	eclipse.setOnAction(e-> SettingsChanged(s,1));
    	moonlight.setOnAction(e-> SettingsChanged(s,2));
    	red.setOnAction(e-> SettingsChanged(s,3));
    	cbboldques.setOnAction(e-> SettingsChanged(s,9));
    	cbboldopts.setOnAction(e-> SettingsChanged(s,9));
    	cbaudio.setOnAction(e-> SettingsChanged(s,9));
    	
    	String restoreattrR = "-fx-background-color: indigo;" +
    						  "-fx-font-family: 'Calibri';" +
    						  "-fx-font-weight: normal;" +
    						  "-fx-font-size: 17px;" +
    						  "-fx-text-fill: white;";
    	String restoreattrH = "-fx-background-color: #3b0070;" +
    			              "-fx-font-family: 'Calibri';" +
    			              "-fx-font-weight: bold;" +
    						  "-fx-text-fill: white;"+
    			              "-fx-font-size: 18px;";
    	String restoreattrP = "-fx-background-color: #2b0060;" +
				              "-fx-font-family: 'Calibri';" +
				              "-fx-font-weight: bold;" +
    						  "-fx-text-fill: white;"+
				              "-fx-font-size: 19px;";
    	String settingssaveattrR = "-fx-background-color: forestgreen;"+
				                   "-fx-text-fill: white;"+
				                   "-fx-font-family: 'Aerial';"+
				                   "-fx-font-size: 15px;"+
				                   "-fx-font-weight: normal;";
    	String settingssaveattrH = "-fx-background-color: darkgreen;"+
    			                   "-fx-text-fill: white;"+
    			                   "-fx-font-family: 'Aerial';"+
    			                   "-fx-font-size: 16px;"+
    			                   "-fx-font-weight: bold;";
    	String settingssaveattrP = "-fx-background-color: #004400;"+
    			                   "-fx-text-fill: white;"+
    			                   "-fx-font-family: 'Aerial';"+
    			                   "-fx-font-size: 17px;"+
    			                   "-fx-font-weight: bold;";
    	String creditsattrR = "-fx-background-color: magenta;"+
                              "-fx-text-fill: white;"+
                              "-fx-font-family: 'Aerial';"+
                              "-fx-font-size: 15px;"+
                              "-fx-font-weight: normal;";
    	String creditsattrH = "-fx-background-color: deeppink;"+
                              "-fx-text-fill: white;"+
                              "-fx-font-family: 'Aerial';"+
                              "-fx-font-size: 16px;"+
                              "-fx-font-weight: bold;";
    	String creditsattrP = "-fx-background-color: mediumvioletred;"+
    						  "-fx-text-fill: white;"+
    						  "-fx-font-family: 'Aerial';"+
    						  "-fx-font-size: 17px;"+
    						  "-fx-font-weight: bold;";
    	
    	settingssave.setStyle(settingssaveattrR);	//initial
    	//settingssave attributes on released, hovering, pressed
    	settingssave.setOnMousePressed(e -> settingssave.setStyle(settingssaveattrP));
    	settingssave.setOnMouseReleased(e-> settingssave.setStyle(settingssaveattrR));
    	settingssave.setOnMouseMoved(e-> settingssave.setStyle(settingssaveattrH));
    	settingssave.setOnMouseExited(e-> settingssave.setStyle(settingssaveattrR));
    	
    	credits.setStyle(creditsattrR);	//initial
    	//credits attributes on released, hovering, pressed
    	credits.setOnMousePressed(e -> credits.setStyle(creditsattrP));
    	credits.setOnMouseReleased(e-> credits.setStyle(creditsattrR));
    	credits.setOnMouseMoved(e-> credits.setStyle(creditsattrH));
    	credits.setOnMouseExited(e-> credits.setStyle(creditsattrR));
    	
    	restore.setStyle(restoreattrR);	//initial
    	//save attributes on released, hovering, pressed
    	restore.setOnMousePressed(e -> restore.setStyle(restoreattrP));
    	restore.setOnMouseReleased(e-> restore.setStyle(restoreattrR));
    	restore.setOnMouseMoved(e-> restore.setStyle(restoreattrH));
    	restore.setOnMouseExited(e-> restore.setStyle(restoreattrR));
    	
    	Label shead = new Label("settings");
    	shead.setStyle("-fx-text-fill: darkred;"+"-fx-font-size: 30px;"+"-fx-font-weight: bold;");
    	Separator sheadsep = new Separator();
    	sheadsep.setPrefWidth(width-50);
    	sheadsep.setStyle("-fx-background-color: darkred;");
    	
    	String cglattr = "-fx-font-family: 'Calibri';" +
    					 "-fx-font-weight: normal;" +
    					 "-fx-text-fill: black;" +
    					 "-fx-font-size: 24px;";
    	String previewattr = "-fx-font-family: 'Aerial';" +
				 			 "-fx-font-weight: normal;" +
				 			 "-fx-text-fill: black;" +
				 			 "-fx-font-size: 24px;";
    	
    	Label cgl = new Label("Choose game layout:");
    	cgl.setStyle(cglattr);
    	Label preview = new Label("Preview");
    	preview.setStyle(previewattr);
    	Separator previewsep = new Separator();
    	previewsep.setPrefWidth(343);
    	previewsep.setStyle("-fx-background-color: black;");
    	if(layoutindex == 0)
    		imagebox.setStyle(layoutstyle0+"-fx-border-color: black;"+"-fx-border-width: 3px;");
    	else if(layoutindex == 1)
    		imagebox.setStyle(layoutstyle1+"-fx-border-color: black;"+"-fx-border-width: 3px;");
    	else if(layoutindex == 2)
    		imagebox.setStyle(layoutstyle2+"-fx-border-color: black;"+"-fx-border-width: 3px;");
    	else if(layoutindex == 3)
    		imagebox.setStyle(layoutstyle3+"-fx-border-color: black;"+"-fx-border-width: 3px;");
    	AnchorPane root = new AnchorPane();
    	//Positioning sheadsep
    	AnchorPane.setTopAnchor(sheadsep, 49.0);
    	AnchorPane.setLeftAnchor(sheadsep, 25.0);
    	//Positioning shead
    	AnchorPane.setTopAnchor(shead, 7.0);
    	AnchorPane.setLeftAnchor(shead, 30.0);
    	//Positioning cgl
    	AnchorPane.setTopAnchor(cgl, 63.5);
    	AnchorPane.setLeftAnchor(cgl, 63.0);
    	//Positioning preview
    	AnchorPane.setTopAnchor(preview, 61.0);
    	AnchorPane.setLeftAnchor(preview, 451.0);
    	//Positioning previewsep
    	AnchorPane.setTopAnchor(previewsep, 95.0);
    	AnchorPane.setLeftAnchor(previewsep, 444.0);
    	//Positioning classic
    	AnchorPane.setTopAnchor(classic, 126.0);
    	AnchorPane.setLeftAnchor(classic, 115.0);
    	//Positioning eclipse
    	AnchorPane.setTopAnchor(eclipse, 158.0);
    	AnchorPane.setLeftAnchor(eclipse, 115.0);
    	//Positioning moonlight
    	AnchorPane.setTopAnchor(moonlight, 190.0);
    	AnchorPane.setLeftAnchor(moonlight, 115.0);
    	//Positioning red
    	AnchorPane.setTopAnchor(red, 222.0);
    	AnchorPane.setLeftAnchor(red, 115.0);
    	//Positioning cbboldques
    	AnchorPane.setTopAnchor(cbboldques, 270.0);
    	AnchorPane.setLeftAnchor(cbboldques, 66.0);
    	//Positioning cbboldopts
    	AnchorPane.setTopAnchor(cbboldopts, 300.0);
    	AnchorPane.setLeftAnchor(cbboldopts, 66.0);
    	//Positioning cbaudio
    	AnchorPane.setTopAnchor(cbaudio, 340.0);
    	AnchorPane.setLeftAnchor(cbaudio, 62.0);
    	//Positioning imagebox
    	AnchorPane.setTopAnchor(imagebox, 122.0);
    	AnchorPane.setLeftAnchor(imagebox, 460.0);
    	AnchorPane.setRightAnchor(imagebox, 78.0);
    	AnchorPane.setBottomAnchor(imagebox, 203.0);
    	//Positioning boxcopyright
    	AnchorPane.setLeftAnchor(boxcopyright, 465.0);
    	AnchorPane.setBottomAnchor(boxcopyright, 208.0);
    	//Positioning restore
    	AnchorPane.setTopAnchor(restore, 353.0);
    	AnchorPane.setLeftAnchor(restore, 385.0);
    	AnchorPane.setRightAnchor(restore, 234.0);
    	AnchorPane.setBottomAnchor(restore, 102.0);
    	//Positioning settingssave
    	AnchorPane.setTopAnchor(settingssave , 353.0);
    	AnchorPane.setLeftAnchor(settingssave , 630.0);
    	AnchorPane.setRightAnchor(settingssave , 23.0);
    	AnchorPane.setBottomAnchor(settingssave , 102.0);
    	//Positioning settingsinvalid
    	AnchorPane.setRightAnchor(settingsinvalid , 28.0);
    	AnchorPane.setBottomAnchor(settingsinvalid , 157.0);
    	//Positioning credits
    	AnchorPane.setTopAnchor(credits , 353.0);
    	AnchorPane.setLeftAnchor(credits , 245.0);
    	AnchorPane.setRightAnchor(credits , 480.0);
    	AnchorPane.setBottomAnchor(credits , 102.0);
    	//Positioning box1
    	AnchorPane.setTopAnchor(box1 , 137.0);
    	AnchorPane.setLeftAnchor(box1 , 480.0);
    	AnchorPane.setRightAnchor(box1 , 94.0);
    	AnchorPane.setBottomAnchor(box1 , 348.0);
    	//Positioning dash
    	AnchorPane.setTopAnchor(dash , 180.0);
    	AnchorPane.setLeftAnchor(dash , 495.0);
    	//Positioning box3
    	AnchorPane.setTopAnchor(box3 , 174.0);
    	AnchorPane.setLeftAnchor(box3 , 480.0);
    	AnchorPane.setRightAnchor(box3 , 94.0);
    	AnchorPane.setBottomAnchor(box3 , 235.0);
    	//Positioning boxtime
    	AnchorPane.setTopAnchor(boxtime , 159.0);
    	AnchorPane.setRightAnchor(boxtime , 96.0);
    	//Positioning recc
    	AnchorPane.setTopAnchor(recc , 275.0);
    	AnchorPane.setLeftAnchor(recc , 670.0);
    	AnchorPane.setRightAnchor(recc , 119.0);
    	AnchorPane.setBottomAnchor(recc , 213.0);
    	//Positioning rece
    	AnchorPane.setTopAnchor(rece , 275.0);
    	AnchorPane.setLeftAnchor(rece , 735.0);
    	AnchorPane.setRightAnchor(rece , 86.0);
    	AnchorPane.setBottomAnchor(rece , 213.0);
    	//Positioning boxquestion
    	AnchorPane.setTopAnchor(boxquestion , 179.0);
    	AnchorPane.setLeftAnchor(boxquestion , 497.0);
    	//Positioning boxoption1
    	AnchorPane.setTopAnchor(boxoption1 , 203.0);
    	AnchorPane.setLeftAnchor(boxoption1 , 575.0);
    	//Positioning boxo1
    	AnchorPane.setTopAnchor(boxo1 , 203.0);
    	AnchorPane.setLeftAnchor(boxo1 , 568.0);
    	//Positioning boxoption2
    	AnchorPane.setTopAnchor(boxoption2 , 214.0);
    	AnchorPane.setLeftAnchor(boxoption2 , 575.0);
    	//Positioning boxo2
    	AnchorPane.setTopAnchor(boxo2 , 214.0);
    	AnchorPane.setLeftAnchor(boxo2 , 568.0);
    	//Positioning boxoption3
    	AnchorPane.setTopAnchor(boxoption3 , 225.0);
    	AnchorPane.setLeftAnchor(boxoption3 , 575.0);
    	//Positioning boxo3
    	AnchorPane.setTopAnchor(boxo3 , 225.0);
    	AnchorPane.setLeftAnchor(boxo3 , 568.0);
    	//Positioning boxoption4
    	AnchorPane.setTopAnchor(boxoption4 , 236.0);
    	AnchorPane.setLeftAnchor(boxoption4 , 575.0);
    	//Positioning boxo4
    	AnchorPane.setTopAnchor(boxo4 , 236.0);
    	AnchorPane.setLeftAnchor(boxo4 , 568.0);
    	//Positioning rec0
    	AnchorPane.setTopAnchor(rec0 , 141.0);
    	AnchorPane.setLeftAnchor(rec0 , 486.0);
    	AnchorPane.setRightAnchor(rec0 , 344.0);
    	AnchorPane.setBottomAnchor(rec0 , 352.0);
    	//Positioning rec1
    	AnchorPane.setTopAnchor(rec1 , 141.0);
    	AnchorPane.setLeftAnchor(rec1 , 513.0);
    	AnchorPane.setRightAnchor(rec1 , 317.0);
    	AnchorPane.setBottomAnchor(rec1 , 352.0);
    	//Positioning rec2
    	AnchorPane.setTopAnchor(rec2 , 141.0);
    	AnchorPane.setLeftAnchor(rec2 , 540.0);
    	AnchorPane.setRightAnchor(rec2 , 290.0);
    	AnchorPane.setBottomAnchor(rec2 , 352.0);
    	//Positioning rec3
    	AnchorPane.setTopAnchor(rec3 , 141.0);
    	AnchorPane.setLeftAnchor(rec3 , 567.0);
    	AnchorPane.setRightAnchor(rec3 , 263.0);
    	AnchorPane.setBottomAnchor(rec3 , 352.0);
    	//Positioning rec4
    	AnchorPane.setTopAnchor(rec4 , 141.0);
    	AnchorPane.setLeftAnchor(rec4 , 594.0);
    	AnchorPane.setRightAnchor(rec4 , 236.0);
    	AnchorPane.setBottomAnchor(rec4 , 352.0);
    	//Positioning rec5
    	AnchorPane.setTopAnchor(rec5 , 141.0);
    	AnchorPane.setLeftAnchor(rec5 , 621.0);
    	AnchorPane.setRightAnchor(rec5 , 209.0);
    	AnchorPane.setBottomAnchor(rec5 , 352.0);
    	//Positioning rec6
    	AnchorPane.setTopAnchor(rec6 , 141.0);
    	AnchorPane.setLeftAnchor(rec6 , 648.0);
    	AnchorPane.setRightAnchor(rec6 , 182.0);
    	AnchorPane.setBottomAnchor(rec6 , 352.0);
    	//Positioning rec7
    	AnchorPane.setTopAnchor(rec7 , 141.0);
    	AnchorPane.setLeftAnchor(rec7 , 675.0);
    	AnchorPane.setRightAnchor(rec7 , 155.0);
    	AnchorPane.setBottomAnchor(rec7 , 352.0);
    	//Positioning rec8
    	AnchorPane.setTopAnchor(rec8 , 141.0);
    	AnchorPane.setLeftAnchor(rec8 , 702.0);
    	AnchorPane.setRightAnchor(rec8 , 128.0);
    	AnchorPane.setBottomAnchor(rec8 , 352.0);
    	//Positioning rec9
    	AnchorPane.setTopAnchor(rec9 , 141.0);
    	AnchorPane.setLeftAnchor(rec9 , 729.0);
    	AnchorPane.setRightAnchor(rec9 , 101.0);
    	AnchorPane.setBottomAnchor(rec9 , 352.0);
    	root.setStyle("-fx-background-color: bisque;");
    	root.getChildren().addAll(imagebox,rec0, rec1,rec2,rec3,rec4,rec5,rec6,rec7,rec8,rec9,recc, rece, boxcopyright);
    	root.getChildren().addAll( box1, box3,boxtime,dash, boxo1, boxo2, boxo3, boxo4, boxquestion, boxoption1, boxoption2, boxoption3, boxoption4);
    	root.getChildren().addAll(shead, sheadsep, sep, btnB , btnN, exit , copyright, restore, settingssave, credits, settingsinvalid);
    	root.getChildren().addAll( cgl, preview, previewsep, classic, eclipse, moonlight, red, cbboldques, cbboldopts, cbaudio);
    	Scene ins = new Scene(root, width, height);
    	s.setScene(ins);
    	s.show();
    }
    public void EmptyTXT(Stage s)
    {
    	mediaPlayer.setMute(false);
    	if(audio == true)
	    {
    		URL resourceq = getClass().getResource("sound effects/Delete_Pressed.mp3");
		    try
		    {
			   	media = new Media(resourceq.toString());
			   	if(media.getError() == null || media.getOnError() == null)
			   	{
			   		mediaPlayer = new MediaPlayer(media);
			   		
			   		mediaPlayer.setVolume(1.0);
			   		mediaPlayer.play();
			   	}
		    }
		    catch(Exception e)
		    {}
	    }
		try(FileWriter f0 = new FileWriter("C:/Users/Public/Documents/The Quiz Game Data.txt"))
		{
			f0.write("null");
			deleteall.setDisable(true);
			HighScore(s);
		}
		catch(IOException e)
		{}
    }
    TableColumn tc0 = new TableColumn("Date");
	TableColumn tc1 = new TableColumn("Time");
	TableColumn tc2 = new TableColumn("Name");
	TableColumn tc3 = new TableColumn("Category");
	TableColumn tc4 = new TableColumn("Mode");
	TableColumn tc5 = new TableColumn("Score");
	String txt_datexz = "";
	String txt_timexz = "";
	String txt_namexz = "";
	String txt_categoryxz = "";
	String txt_modexz = "";
	String txt_scorexz = "";
	public void Table(String data) 
    {
    	String[] tokens = data.split("x....................x");
    	txt_datexz = tokens[0];
    	txt_timexz = tokens[1];
    	txt_namexz = tokens[2];
    	txt_categoryxz = tokens[3];
    	txt_modexz = tokens[4];
    	txt_scorexz = tokens[5];
    }
    public void HighScore(Stage s)
    {
    	if(audio == true)
	   	 {
	   	 	URL resource = getClass().getResource("sound effects/open.mp3");
	   	     try
	   	     {
	   	 	   	Media media = new Media(resource.toString());
	   	 	   	if(media.getError() == null || media.getOnError() == null)
	   	 	   	{
	   	 	   		mediaPlayer = new MediaPlayer(media);
	   	 	   		mediaPlayer.setStartTime(Duration.seconds(1.61));
	   	 	   		mediaPlayer.setVolume(0.5);
	   	 	   		mediaPlayer.play();
	   	 	   	}
	   	     }
	   	     catch(Exception e)
	   	     {}
	   	 }
    	TableView<Chart> table = new TableView<>();
        ObservableList<Chart> data = FXCollections.observableArrayList();
    	tc0.setMinWidth(100);
        tc0.setCellValueFactory(new PropertyValueFactory<>("Date"));
        tc0.setResizable(false);
        tc0.setSortable(false);
        tc1.setMinWidth(100);
        tc1.setCellValueFactory(new PropertyValueFactory<>("Time"));
        tc1.setResizable(false);
        tc1.setSortable(false);
        tc2.setMinWidth(180);
        tc2.setCellValueFactory(new PropertyValueFactory<>("Name"));
        tc2.setResizable(false);
        tc2.setSortable(false);
        tc3.setMinWidth(180);
        tc3.setCellValueFactory(new PropertyValueFactory<>("Category"));
        tc3.setResizable(false);
        tc3.setSortable(false);
        tc4.setMinWidth(133);
        tc4.setCellValueFactory(new PropertyValueFactory<>("Mode"));
        tc4.setResizable(false);
        tc4.setSortable(false);
        tc5.setPrefWidth(70);
        tc5.setCellValueFactory(new PropertyValueFactory<>("Score"));
        tc5.setResizable(false);
        tc5.setSortable(false);
        table.setItems(data);
        table.getColumns().addAll(tc0 , tc1 , tc2 , tc3 , tc4 , tc5);
    	VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(table);
    	int counter = 2;
    	int up = 0;
    	deleteall.setDisable(true);
    	//reading .txt down
    	try(FileReader fr = new FileReader("C:/Users/Public/Documents/The Quiz Game Data.txt"))
        {
    		String nul = "";
    		int c;
            while((c = fr.read()) != -1)
            {
            	if(c != 96)
            	{
            		if(counter == 2)
            			nul = nul.concat((char)c + "");
            		else
            			counter++;
            	}
            	else	//end of each line
                {		
                	if(nul.trim().equals("null") == false)
                	{
                		up = 1;
                		Table(nul);
                		data.add(new Chart(txt_datexz, txt_timexz , txt_namexz , txt_categoryxz , txt_modexz , txt_scorexz));
                	}
                	nul = "";
                	counter = 0;
                }
            }
            
            if(nul.trim().equals("null") == false || up == 1)
            	deleteall.setDisable(false);
            if(up == 0)
            	deleteall.setDisable(true);
        }
        catch(IOException e)
        {
        	deleteall.setDisable(true);
        }
    	//reading .txt up
    	btnN.setDisable(true);
    	btnB.setOnAction(e-> Main_Menu(s));
    	deleteall.setOnAction(e-> EmptyTXT(s));
    	String deleteallattrR = "-fx-background-color: firebrick;"+"-fx-text-fill: white;"+"-fx-font-family: 'Aerial';"+"-fx-font-size: 14px;"+"-fx-font-weight: normal;";
    	String deleteallattrH = "-fx-background-color: darkred;"+"-fx-text-fill: white;"+"-fx-font-family: 'Aerial';"+"-fx-font-size: 15px;"+"-fx-font-weight: bold;";
    	String deleteallattrP = "-fx-background-color: maroon;"+"-fx-text-fill: white;"+"-fx-font-family: 'Aerial';"+"-fx-font-size: 16px;"+"-fx-font-weight: bold;";
    	deleteall.setStyle(deleteallattrR);	//initial
    	//deleteall attributes on released, hovering, pressed
    	deleteall.setOnMousePressed(e -> deleteall.setStyle(deleteallattrP));
    	deleteall.setOnMouseReleased(e-> deleteall.setStyle(deleteallattrR));
    	deleteall.setOnMouseMoved(e-> deleteall.setStyle(deleteallattrH));
    	deleteall.setOnMouseExited(e-> deleteall.setStyle(deleteallattrR));
    	Label hhead = new Label("high scores");
    	hhead.setStyle("-fx-text-fill: darkred;"+"-fx-font-size: 30px;"+"-fx-font-weight: bold;");
    	Separator hheadsep = new Separator();
    	hheadsep.setPrefWidth(width-50);
    	hheadsep.setStyle("-fx-background-color: darkred;");
    	AnchorPane root = new AnchorPane();
    	//Positioning hheadsep
    	AnchorPane.setTopAnchor(hheadsep, 49.0);
    	AnchorPane.setLeftAnchor(hheadsep, 25.0);
    	//Positioning hhead
    	AnchorPane.setTopAnchor(hhead, 7.0);
    	AnchorPane.setLeftAnchor(hhead, 30.0);
    	//Positioning deleteall
    	AnchorPane.setTopAnchor(deleteall , 360.0);
    	AnchorPane.setLeftAnchor(deleteall , 650.0);
    	AnchorPane.setRightAnchor(deleteall , 27.0);
    	AnchorPane.setBottomAnchor(deleteall , 97.0);
    	//Positioning cuc
    	AnchorPane.setTopAnchor(cuc , 200.0);
    	AnchorPane.setLeftAnchor(cuc , 340.0);
    	//Positioning vbox
    	AnchorPane.setTopAnchor(vbox , 60.0); //20
    	AnchorPane.setLeftAnchor(vbox , 25.0);
    	AnchorPane.setRightAnchor(vbox , 30.0);
    	AnchorPane.setBottomAnchor(vbox , 155.0);
    	
    	root.setStyle("-fx-background-color: bisque;");
    	root.getChildren().addAll(hhead, hheadsep, deleteall, sep, btnB, btnN, exit , copyright, cuc , vbox);
    	Scene ins = new Scene(root, width, height);
    	s.setScene(ins);
    	s.show();
    }
    public static class Chart
    {
    	SimpleStringProperty txt_datex;
        SimpleStringProperty txt_timex;
        SimpleStringProperty txt_namex;
        SimpleStringProperty txt_categoryx;
        SimpleStringProperty txt_modex;
        SimpleStringProperty txt_scorex;
        private Chart(String datexx, String timexx , String namexx , String categoryxx , String modexx , String scorexx)
        {
            this.txt_datex = new SimpleStringProperty(datexx);
            this.txt_timex = new SimpleStringProperty(timexx);
            this.txt_namex = new SimpleStringProperty(namexx);
            this.txt_categoryx = new SimpleStringProperty(categoryxx);
            this.txt_modex = new SimpleStringProperty(modexx);
            this.txt_scorex = new SimpleStringProperty(scorexx);
        }
        public String getDate()
        {
            return txt_datex.get();
        }
        public String getTime()
        {
            return txt_timex.get();
        }
        public String getName()
        {
            return txt_namex.get();
        }
        public String getCategory()
        {
            return txt_categoryx.get();
        }
        public String getMode()
        {
            return txt_modex.get();
        }
        public String getScore()
        {
            return txt_scorex.get();
        }
    }
    public void entpressed()	//called from NewGamePage1()
    {
    	save.setDisable(false);
    	btnN.setDisable(true);
    }
    public void cbhighscorepressed()	//called from NewGamePage1()
    {
    	save.setDisable(false);
    	btnN.setDisable(true);
    	if(cbhighscore.isSelected() == true)
    		playerdetails = true;	//stores player data to .txt file
    	else
    		playerdetails = false;	//does not stores player in any .txt file
    }
    public void btnBpressed(Stage s)	//called from NewGamePage1()
    {
    	btnN.setDisable(true);
    	save.setDisable(false);
    	Main_Menu(s);
    }
    public void tfpressed()		//called from NewGamePage1()
    {
    	btnN.setDisable(true);
    	save.setDisable(false);
    	invalid.setVisible(false);
    	
    }
    public void savepressed(Stage s)	//called from NewGamePage1()
    {
    	if(audio == true)
    	{
    		URL resource = getClass().getResource("sound effects/open.mp3");
    	    try
    	    {
    		   	Media media = new Media(resource.toString());
    		   	if(media.getError() == null || media.getOnError() == null)
    		   	{
    		   		mediaPlayer = new MediaPlayer(media);
    		   		mediaPlayer.setStartTime(Duration.seconds(1.61));
    		   		mediaPlayer.setVolume(0.5);
    		   		mediaPlayer.play();
    		   	}
    	    }
    	    catch(Exception e)
    	    {}
    	}
    	btnN.setOnAction(e-> ChooseCategory(s));
    	String empty = "";
    	save.setDisable(true);
    	
    	playername = tf.getText();
    	playername = playername.trim();
    	
    	RadioButton selectedmode = (RadioButton) ent.getSelectedToggle();	//RadioButton type
    	String f = selectedmode.getText();	//String type
    	if(f.equals("Easy"))
    	{
    		playerchoice = 0;
    		mode = "Easy (30 seconds per question.)";
    	}
    	else if(f.equals("Normal"))
    	{
    		playerchoice = 1;
    		mode = "Normal (20 seconds per question.)";
    	}
    	else if(f.equals("Tough"))
    	{
    		playerchoice = 2;
    		mode = "Tough (10 seconds per question.)";
    	}
    	
    	if(playername.equals(empty))	//No name entered
    	{
    		valid = false;
    		save.setDisable(true);
    		btnN.setDisable(true);
    		invalid.setVisible(true);
    		invalid.setStyle("-fx-text-fill: red;");
    		if(audio == true)
    			Toolkit.getDefaultToolkit().beep();
    		invalid.setText("Player name is missing!");
    	}
    	else	//Player name is present
    	{
    		for(int i = 0 ; i < playername.length() ; i++)
    		{
    			char chz = playername.charAt(i);
    			if(chz == '`')
    			{
    				invalid.setStyle("-fx-text-fill: red;");
    				invalid.setText("` symbol is not allowed!");
    				invalid.setVisible(true);
    				return;
    			}	
    		}
    		valid = true;
    		save.setDisable(true);
    		btnN.setDisable(false);
    		invalid.setVisible(true);
    		invalid.setStyle("-fx-text-fill: black;");
    		invalid.setText("Press Next Button to Continue.");
    	}
    }
    int tag = 5;
    String S = "5";
    Label label = new Label("5");
    String gametimerattr = "-fx-text-fill: black;"+"-fx-font-size: 28px;"+"-fx-font-weight: bold;"+"-fx-font-family: 'HelvLight';";
    public void timelabel()
    {
    	if(tag > 1)
		{
			tag--;
		}
		S = tag + "";
		label.setText(S);
    }
    int Px; //set 1 if pause button is pressed. 0 (zero) if pause button is not pressed/released
    Timeline animation = new Timeline(new KeyFrame(Duration.seconds(1), e-> timelabel()));	//timer Transition window animation
    public void PAUSE()
    {
    	if(audio == true)
    	{
    		URL resource = getClass().getResource("sound effects/open.mp3");
    	    try
    	    {
    		   	Media media = new Media(resource.toString());
    		   	if(media.getError() == null || media.getOnError() == null)
    		   	{
    		   		mediaPlayer = new MediaPlayer(media);
    		   		mediaPlayer.setStartTime(Duration.seconds(1.61));
    	 	   		mediaPlayer.setVolume(0.5);
    		   		mediaPlayer.play();
    		   	}
    	    }
    	    catch(Exception e)
    	    {}
    	}
    	if(Px == 0)
    	{
    		animation.pause();
    		pause.setText(">");
    		Px = 1;
    	}
    	else
    	{
    		animation.play();
    		pause.setText("| |");
    		Px = 0;
    	}
    }
    String rootattr = "-fx-background-color: '#D8D7D7';";
    public void Transition(Stage s , char statusx)
    {
    	/*
    	 * If status = 'B' -> Before game starts BLUE
    	 * If status = 'R' -> Previous Answer Right GREEN
    	 * If status = 'W' -> Previous Answer Wrong RED
    	*/
    	Px = 0;	//set 1 if pause button is pressed. 0 (zero) if pause button is not pressed/released
    	pause.setDefaultButton(true);
    	Label gbi = new Label();    	   
    	Label leftx = new Label();
    	Label rightx = new Label();
    	Label middlex = new Label();
    	
    	String leftattr = "";
		String rightattr = "";
		String gbiattr = "";
		middlex.setStyle("-fx-border-width: 4px;"+"-fx-border-color: black;"+"-fx-background-color: '#D8D7D7';"); //grey
		middlex.setPrefSize(150.0 , 150.0);
		middlex.setRotate(45.0);
    	if(statusx == 'B')	//Before game starts
    	{
    		tag = 5;
    		S = "5";
    		label.setText(S);
    		gbi.setText("All the best");
    		gbiattr = "-fx-font-family: 'Arial Rounded MT Bold';"+"-fx-font-weight: normal;"+"-fx-font-size: 23px;"+"-fx-text-fill: '#2A08FA';";
    		leftattr = "-fx-border-width: 4px;"+"-fx-border-color: black;"+"-fx-background-color: '#35E11F';"; //green
    		rightattr = "-fx-border-width: 4px;"+"-fx-border-color: black;"+"-fx-background-color: '#DF1D1D';"; //red
    		animation.setCycleCount(5);
    	}
    	else if(statusx == 'R')	//Previous answer was Correct
    	{
    		tag = 3;
    		S = "3";
    		label.setText(S);
    		gbi.setText("Correct Answer");
    		gbiattr = "-fx-font-family: 'Arial Rounded MT Bold';"+"-fx-font-weight: normal;"+"-fx-font-size: 23px;"+"-fx-text-fill: '#35E11F';";
    		leftattr = "-fx-border-width: 4px;"+"-fx-border-color: black;"+"-fx-background-color: '#35E11F';"; //green
    		rightattr = "-fx-border-width: 4px;"+"-fx-border-color: black;"+"-fx-background-color: '#35E11F';"; //green
    		animation.setCycleCount(3);
    	}
    	else if(statusx == 'W')	//Previous answer was Wrong
    	{
    		tag = 3;
    		S = "3";
    		label.setText(S);
    		gbi.setText("Wrong Answer");
    		gbiattr = "-fx-font-family: 'Arial Rounded MT Bold';"+"-fx-font-weight: normal;"+"-fx-font-size: 23px;"+"-fx-text-fill: '#DF1D1D';";
    		leftattr = "-fx-border-width: 4px;"+"-fx-border-color: black;"+"-fx-background-color: '#DF1D1D';"; //red
    		rightattr = "-fx-border-width: 4px;"+"-fx-border-color: black;"+"-fx-background-color: '#DF1D1D';"; //red
    		animation.setCycleCount(3);
    	}
    	leftx.setStyle(leftattr);
		rightx.setStyle(rightattr);
    	gbi.setStyle(gbiattr);
    	pause.setOnAction(e-> PAUSE());
		String labelattrx = "-fx-font-weight: bold;"+
							"-fx-font-family: 'Baskerville Old Face';"+
							"-fx-font-size: 100px;"+
							"-fx-text-fill: black;";
		
		label.setStyle(labelattrx);
		label.setTranslateX(width/2 - 28);
		label.setTranslateY(height/4 + 23);
    	AnchorPane root = new AnchorPane();
    	//leftx
    	AnchorPane.setLeftAnchor(leftx, 110.0);
    	AnchorPane.setRightAnchor(leftx, width/2.0);
    	AnchorPane.setTopAnchor(leftx, 160.0);
    	AnchorPane.setBottomAnchor(leftx, 240.0);
    	//rightx
    	AnchorPane.setLeftAnchor(rightx, width/2.0);
    	AnchorPane.setRightAnchor(rightx, 110.0);
    	AnchorPane.setTopAnchor(rightx, 160.0);
    	AnchorPane.setBottomAnchor(rightx, 240.0);
    	//middlex
    	AnchorPane.setLeftAnchor(middlex, width/2.0 + 22.0 - 100.0);
    	AnchorPane.setTopAnchor(middlex, 135.0);
    	//pause button
    	AnchorPane.setRightAnchor(pause, 25.0);
    	AnchorPane.setBottomAnchor(pause, 25.0);
    	//gbi
    	AnchorPane.setTopAnchor(gbi, 370.0);
    	if(statusx == 'B')
    		AnchorPane.setLeftAnchor(gbi, width/2.0 - 53.0);
    	else if(statusx == 'W')
    		AnchorPane.setLeftAnchor(gbi, width/2.0 - 78.0);
    	else if(statusx == 'R')
    		AnchorPane.setLeftAnchor(gbi, width/2.0 - 80.0);
    	root.setStyle(rootattr);
    	root.getChildren().addAll(copyright , leftx , rightx , middlex , gbi , label , pause);
    	Scene ins = new Scene(root, width, height);
    	s.setScene(ins);
    	s.show();
    	animation.play();
    	if(COUNT == 0)
    	{
    		COUNT++;
    		Separator(Q1);
    		animation.setOnFinished(e-> GamePage(s));
    	}
    	else if(COUNT == 1)
    	{
    		COUNT++;
    		Separator(Q2);
    		animation.setOnFinished(e-> GamePage(s));
    	}
    	else if(COUNT == 2)
    	{
    		COUNT++;
    		Separator(Q3);
    		animation.setOnFinished(e-> GamePage(s));
    	}
    	else if(COUNT == 3)
    	{
    		COUNT++;
    		Separator(Q4);
    		animation.setOnFinished(e-> GamePage(s));
    	}
    	else if(COUNT == 4)
    	{
    		COUNT++;
    		Separator(Q5);
    		animation.setOnFinished(e-> GamePage(s));
    	}
    	else if(COUNT == 5)
    	{
    		COUNT++;
    		Separator(Q6);
    		animation.setOnFinished(e-> GamePage(s));
    	}
    	else if(COUNT == 6)
    	{
    		COUNT++;
    		Separator(Q7);
    		animation.setOnFinished(e-> GamePage(s));
    	}
    	else if(COUNT == 7)
    	{
    		COUNT++;
    		Separator(Q8);
    		animation.setOnFinished(e-> GamePage(s));
    	}
    	else if(COUNT == 8)
    	{
    		COUNT++;
    		Separator(Q9);
    		animation.setOnFinished(e-> GamePage(s));
    	}
    	else if(COUNT == 9)
    	{
    		COUNT++;
    		Separator(Q10);
    		animation.setOnFinished(e-> GamePage(s));
    	}
    }
    public void PlayAgain(Stage s , char typex)
    {
    	/*
    	 * typex: 't'	->	Called fron TimeOver()
    	 * typex: 'o'	->	Called fron GameOver()
    	 * typex: 'w'	->	Called fron GameWon()
    	 */
    	if(audio == true)
    	{
    		try
    		{
    			mediaPlayer.setMute(true);
    		}
    		catch(Exception e)
    		{}
    	
    		URL resourcex = getClass().getResource("sound effects/Claps.mp3");
    	    try
    	    {
    		   	Media media = new Media(resourcex.toString());
    		   	if(media.getError() == null || media.getOnError() == null)
    		   	{
    		   		mediaPlayer = new MediaPlayer(media);
    		   		mediaPlayer.setMute(false);
    		   		mediaPlayer.setVolume(1.0);
    		   		mediaPlayer.setStopTime(Duration.seconds(3.8));
    		   		mediaPlayer.play();
    		   	}
    	    }
    	    catch(Exception e)
    	    {}
    	}
    	String txt = "";
    	if(playerdetails == true)
    	{
	    	//reading
	        try(FileReader fr = new FileReader("C:/Users/Public/Documents/The Quiz Game Data.txt"))
	        {
	            int c;
	            while((c = fr.read()) != -1)
	            {
	                txt = txt.concat((char)c + "");
	            }
	        }
	        catch(IOException e)
	        {}
	        //writing
	        String cat = "";
	        if(mode.startsWith("Easy") == true)
	        	cat = "Easy";
	        else if(mode.startsWith("Normal") == true)
	        	cat = "Normal";
	        else if(mode.startsWith("Tough") == true)
	        	cat = "Tough";
	        //FORMAT: current date + current time + name + category + choice(time) + score
	        String source = date + bar + time + bar + playername + bar + category + bar + cat  + bar + SCORE + "`\r\n" + txt;
			char buffer[] = new char[source.length()];
			source.getChars(0, source.length(), buffer, 0);
			try(FileWriter fw = new FileWriter("C:/Users/Public/Documents/The Quiz Game Data.txt"))
			{
				fw.write(buffer);
			}
			catch(IOException e)
			{}
    	}
    	Tooltip pactt = new Tooltip();
    	Tooltip pastt = new Tooltip();
    	Tooltip paptt = new Tooltip();
    	pactt.setText("Go to the Content Window.");
    	pastt.setText("View High Scores Window.");
    	paptt.setText("Press to play again the game.");
    	pactt.setStyle(tooltipattr);
    	pastt.setStyle(tooltipattr);
    	paptt.setStyle(tooltipattr);
    	Button pac = new Button("Contents");
    	Button pas = new Button("High Scores");
    	Button pap = new Button("Play Again");
    	pac.setTooltip(pactt);
    	pas.setTooltip(pastt);
    	pap.setTooltip(paptt);
    	pac.setOnAction(e-> Main_Menu(s));
    	pas.setOnAction(e-> HighScore(s));
    	pap.setOnAction(e-> NewGamePage2(s));
    	pac.setPrefHeight(45.0);	pac.setPrefWidth(130.0);
    	pas.setPrefHeight(45.0);	pas.setPrefWidth(150.0);
    	pap.setPrefHeight(45.0);	pap.setPrefWidth(160.0);
    	pac.setStyle("-fx-text-fill: white;"+"-fx-font-weight: bold;"+"-fx-font-size: 15px;"+"-fx-background-color: '#DE01A2';");
    	pac.setOnMouseExited(e-> pac.setStyle("-fx-text-fill: white;"+"-fx-font-weight: bold;"+"-fx-font-size: 15px;"+"-fx-background-color: '#DE01A2';"));
    	pac.setOnMouseReleased(e-> pac.setStyle("-fx-text-fill: white;"+"-fx-font-weight: bold;"+"-fx-font-size: 15px;"+"-fx-background-color: '#DE01A2';"));
    	pac.setOnMouseEntered(e-> pac.setStyle("-fx-text-fill: white;"+"-fx-font-weight: bold;"+"-fx-font-size: 16px;"+"-fx-background-color: '#B50A7B';"));
    	pac.setOnMousePressed(e-> pac.setStyle("-fx-text-fill: white;"+"-fx-font-weight: bold;"+"-fx-font-size: 16.5px;"+"-fx-background-color: '#89075D';"));
    	pas.setStyle("-fx-text-fill: white;"+"-fx-font-weight: bold;"+"-fx-font-size: 15px;"+"-fx-background-color: '#4C15DD';");
    	pas.setOnMouseExited(e-> pas.setStyle("-fx-text-fill: white;"+"-fx-font-weight: bold;"+"-fx-font-size: 15px;"+"-fx-background-color: '#4C15DD';"));
    	pas.setOnMouseReleased(e-> pas.setStyle("-fx-text-fill: white;"+"-fx-font-weight: bold;"+"-fx-font-size: 15px;"+"-fx-background-color: '#4C15DD';"));
    	pas.setOnMouseEntered(e-> pas.setStyle("-fx-text-fill: white;"+"-fx-font-weight: bold;"+"-fx-font-size: 16px;"+"-fx-background-color: '#3C11B1';"));
    	pas.setOnMousePressed(e-> pas.setStyle("-fx-text-fill: white;"+"-fx-font-weight: bold;"+"-fx-font-size: 16.5px;"+"-fx-background-color: '#0A0D89';"));
    	pap.setStyle("-fx-text-fill: white;"+"-fx-font-weight: bold;"+"-fx-font-size: 15px;"+"-fx-background-color: '#42D10F';");
    	pap.setOnMouseExited(e-> pap.setStyle("-fx-text-fill: white;"+"-fx-font-weight: bold;"+"-fx-font-size: 15px;"+"-fx-background-color: '#42D10F';"));
    	pap.setOnMouseReleased(e-> pap.setStyle("-fx-text-fill: white;"+"-fx-font-weight: bold;"+"-fx-font-size: 15px;"+"-fx-background-color: '#42D10F';"));
    	pap.setOnMouseEntered(e-> pap.setStyle("-fx-text-fill: white;"+"-fx-font-weight: bold;"+"-fx-font-size: 16px;"+"-fx-background-color: '#32970E';"));
    	pap.setOnMousePressed(e-> pap.setStyle("-fx-text-fill: white;"+"-fx-font-weight: bold;"+"-fx-font-size: 16.5px;"+"-fx-background-color: '#226B08';"));
    	Button behindblue = new Button();
    	behindblue.setStyle("-fx-background-color: '#00A8FF';");
    	behindblue.setPrefSize(width - 50.0 , 300.0);
    	behindblue.setRotate(10.0);
    	Button behindyellow = new Button();
    	behindyellow.setStyle("-fx-background-color: '#FFB400';");
    	behindyellow.setPrefSize(width + 200.0 , 300.0);
    	behindyellow.setRotate(-8.0);
    	Button behindsep1 = new Button();
    	behindsep1.setStyle("-fx-background-color: white;"+"-fx-border-width: 3px;"+"-fx-border-color: '#1E7709';");
    	Button behindsep2 = new Button();
    	behindsep2.setStyle("-fx-background-color: white;"+"-fx-border-width: 3px;"+"-fx-border-color: '#1E7709';");
    	Button behindgreen0 = new Button();
    	behindgreen0.setStyle("-fx-background-color: '#AFE912';");
    	behindgreen0.setPrefSize(width - 50.0 , 300.0);
    	behindgreen0.setRotate(75.0);
    	Button behindgreen1 = new Button();
    	behindgreen1.setStyle("-fx-background-color: '#AFE912';");
    	behindgreen1.setPrefSize(400.0 , 400.0);
    	behindgreen1.setRotate(130.0);
    	Separator mark0 = new Separator();
    	mark0.setStyle("-fx-background-color: '#1E7709';"+"-fx-border-color: white;");
    	mark0.setPrefWidth(350.0);
    	Separator mark1 = new Separator();
    	mark1.setStyle("-fx-background-color: '#1E7709';"+"-fx-border-color: white;");
    	mark1.setPrefWidth(350.0);
    	TranslateTransition tt0 = new TranslateTransition();
    	TranslateTransition tt2 = new TranslateTransition();
    	TranslateTransition tt1 = new TranslateTransition();
    	pac.setTranslateX(width - 510.0);
    	pac.setTranslateY(height + 600.0);
    	tt0.setNode(pac);
    	tt0.setToY(height - 77.0);
    	pas.setTranslateX(width - 360.0);
    	pas.setTranslateY(height + 600.0);
    	tt1.setNode(pas);
    	tt1.setToY(height - 77.0);
    	pap.setTranslateX(width - 190.0);
    	pap.setTranslateY(height + 600.0);
    	tt2.setNode(pap);
    	tt2.setToY(height - 77.0);
    	tt0.setDuration(Duration.seconds(2.0));
    	tt1.setDuration(Duration.seconds(1.5));
    	tt2.setDuration(Duration.seconds(0.8));
    	Label displayscore = new Label();
    	displayscore.setText(SCORE + "");
    	displayscore.setStyle("-fx-text-fill: red;"+"-fx-font-weight: bold;"+"-fx-font-family: 'Algerian';"+"-fx-font-size: 70px;");
    	Label topscore = new Label();
    	topscore.setText("/ 100");
    	topscore.setStyle("-fx-text-fill: blue;"+"-fx-font-weight: bold;"+"-fx-font-family: 'Algerian';"+"-fx-font-size: 50px;");
    	Label line0 = new Label("Your game mode was");
    	Label line1 = new Label("Your game category was");
    	line0.setStyle("-fx-text-fill: black;"+"-fx-font-family: 'Bahnschrift SemiCondensed';"+"-fx-font-size: 17px;"+"-fx-font-weight: bold;");
    	line1.setStyle("-fx-text-fill: black;"+"-fx-font-family: 'Bahnschrift SemiCondensed';"+"-fx-font-size: 16px;"+"-fx-font-weight: bold;");
    	Label displaycategory = new Label();
    	displaycategory.setText(category);
    	displaycategory.setStyle(line0.getStyle());
    	Label displaymode = new Label();
    	String modeshort = "";
    	if(mode.contains("Normal") == true)
    		modeshort = "Normal";
    	else if(mode.contains("Easy") == true)
    		modeshort = "Easy";
    	else if(mode.contains("Tough") == true)
    		modeshort = "Tough";
    	displaymode.setText(modeshort);
    	displaymode.setStyle(line0.getStyle());
    	Label line2 = new Label("Your game score is");
    	line2.setStyle("-fx-text-fill: purple;"+"-fx-font-family: 'Consolas';"+"-fx-font-weight: bold;"+"-fx-font-size: 18px;");
    	Label displayhs = new Label();
    	if(playerdetails == true)
    		displayhs.setText("saved");
    	else
    		displayhs.setText("not saved");
    	displayhs.setStyle(line2.getStyle());
    	Label ysc = new Label();
    	ysc.setText(playername + " your score card");
    	ysc.setStyle("-fx-text-fill: red;"+"-fx-font-size: 35px;"+"-fx-font-family: 'Constantia';"+"-fx-font-weight: bold;");
    	Label rsep = new Label();
    	rsep.setStyle("-fx-border-color: red;" + "-fx-border-width: 2px;");
    	SCORE = 0;
    	AnchorPane root = new AnchorPane();
    	//behindblue
    	AnchorPane.setBottomAnchor(behindblue, -230.0);
    	AnchorPane.setLeftAnchor(behindblue, -155.0);
    	//behindyellow
    	AnchorPane.setTopAnchor(behindyellow, -210.0);
    	AnchorPane.setRightAnchor(behindyellow, -100.0);
    	//behindsep1
    	AnchorPane.setTopAnchor(behindsep1, 100.0);
    	AnchorPane.setLeftAnchor(behindsep1, 200.0);
    	AnchorPane.setRightAnchor(behindsep1, 200.0);
    	AnchorPane.setBottomAnchor(behindsep1, 280.0);
    	//behindsep2
    	AnchorPane.setTopAnchor(behindsep2, 240.0);
    	AnchorPane.setLeftAnchor(behindsep2, 200.0);
    	AnchorPane.setRightAnchor(behindsep2, 200.0);
    	AnchorPane.setBottomAnchor(behindsep2, 120.0);
    	//behindgreen0
    	AnchorPane.setBottomAnchor(behindgreen0, -240.0);
    	AnchorPane.setRightAnchor(behindgreen0, -510.0);
    	//behindgreen1
    	AnchorPane.setTopAnchor(behindgreen1, 19.0);
    	AnchorPane.setRightAnchor(behindgreen1, -343.0);
    	//mark0
    	AnchorPane.setTopAnchor(mark0, 290.0);
    	AnchorPane.setLeftAnchor(mark0, 250.0);
    	//mark1
    	AnchorPane.setTopAnchor(mark1, 330.0);
    	AnchorPane.setLeftAnchor(mark1, 250.0);
    	//displayscore
    	AnchorPane.setTopAnchor(displayscore, 125.0);
    	AnchorPane.setRightAnchor(displayscore, 450.0);
    	//topscore
    	AnchorPane.setTopAnchor(topscore , 145.0);
    	AnchorPane.setRightAnchor(topscore , 300.0);    	
    	//line0
    	AnchorPane.setTopAnchor(line0 , 265.0);
    	AnchorPane.setLeftAnchor(line0 , 230.0);
    	//line1
    	AnchorPane.setTopAnchor(line1 , 305.0);
    	AnchorPane.setLeftAnchor(line1 , 230.0);
    	//displaycategory
    	AnchorPane.setTopAnchor(displaycategory , 305.0);
    	AnchorPane.setRightAnchor(displaycategory , 230.0);
    	//displaymode
    	AnchorPane.setTopAnchor(displaymode , 265.0);
    	AnchorPane.setRightAnchor(displaymode, 230.0);
    	//line2
    	AnchorPane.setTopAnchor(line2 , 345.0);
    	AnchorPane.setLeftAnchor(line2 , 230.0);
    	//displayhs
    	AnchorPane.setTopAnchor(displayhs , 345.0);
    	AnchorPane.setRightAnchor(displayhs , 230.0);
    	//ysc
    	AnchorPane.setTopAnchor(ysc , 20.0);
    	AnchorPane.setLeftAnchor(ysc , 25.0);
    	//rsep
    	AnchorPane.setTopAnchor(rsep , 15.0);
    	AnchorPane.setLeftAnchor(rsep , 15.0);
    	AnchorPane.setRightAnchor(rsep , 15.0);
    	AnchorPane.setBottomAnchor(rsep , height - 70.0);
    	
    	root.setStyle("-fx-background-color: white;");
    	root.getChildren().addAll(behindblue , behindyellow , behindgreen0 , behindgreen1 , copyright  , behindsep1 , behindsep2 , mark0 , mark1 , pac , pas , pap);
    	root.getChildren().addAll(rsep , ysc , displayscore , topscore , line0 , line1 , displaycategory , displaymode , line2 , displayhs);
    	Scene ins = new Scene(root, width, height);
    	s.setScene(ins);
    	s.show();
    	tt0.play();
    	tt1.play();
    	tt2.play();
    }
    public void TimeOver(Stage s)
    {
    	if(audio == true)
    	{
    		URL resourcezz = getClass().getResource("sound effects/MDie.mp3");
    	    try
    	    {
    		   	media = new Media(resourcezz.toString());
    		   	if(media.getError() == null || media.getOnError() == null)
    		   	{
    		   		mediaPlayer = new MediaPlayer(media);
    		   		mediaPlayer.setVolume(0.4);
    		   		mediaPlayer.play();
    		   	}
    	    }
    	    catch(Exception e)
    	    {}
    	}
    	Label to = new Label("Time Over");
    	Label bto = new Label();
    	Label btt = new Label();
    	Button con = new Button();
    	con.setText("Continue");
    	con.setStyle("-fx-font-family: 'Franklin Gothic Medium';"+"-fx-text-fill: white;"+"-fx-border-color: white;"+"-fx-border-width: 3px;"+"-fx-font-size: 24px;"+"-fx-font-weight: bold;"+"-fx-background-color: '#4E0707';");
    	con.setPrefSize(270.0, 45.0);
    	con.setTranslateX(290.0);
    	con.setTranslateY(height + 200.0);
    	TranslateTransition ttcon = new TranslateTransition();
    	ttcon.setNode(con);
    	ttcon.setToY(height - 200);
    	ttcon.setDelay(Duration.seconds(0.5));
    	ttcon.setDuration(Duration.seconds(0.5));
    	FadeTransition fdx = new FadeTransition(Duration.seconds(0.8));
    	fdx.setFromValue(0.0);
    	fdx.setToValue(1.0);
    	fdx.setCycleCount(Animation.INDEFINITE);
    	fdx.setNode(to);
    	con.setOnAction(e-> PlayAgain(s , 't')); //o-> GameOver()	| w-> GameWon()	| t-> TimeOver()
    	AnchorPane root = new AnchorPane();
    	//to
    	AnchorPane.setTopAnchor(to, 120.0);
    	AnchorPane.setLeftAnchor(to, 230.0);
    	//bto
    	AnchorPane.setTopAnchor(bto, 90.0);
    	AnchorPane.setLeftAnchor(bto, 150.0);
    	AnchorPane.setRightAnchor(bto, 150.0);
    	AnchorPane.setBottomAnchor(bto, 295.0);
    	//btt
    	AnchorPane.setTopAnchor(btt, 80.0);
    	AnchorPane.setLeftAnchor(btt, 120.0);
    	AnchorPane.setRightAnchor(btt, 120.0);
    	AnchorPane.setBottomAnchor(btt, 285.0);
    	if(layoutindex == 0)
    	{
    		to.setStyle("-fx-border-width: 2px;"+"-fx-font-family: 'Goudy Stout';"+"-fx-font-size: 36px;"+"-fx-font-weight: bold;"+"-fx-text-fill: black;");
    		con.setStyle("-fx-font-family: 'Cooper Black';"+"-fx-font-weight: bold;"+"-fx-font-size: 19px;"+"-fx-text-fill: '#D8D7D7';"+"-fx-background-color: black;");
    		con.setOnMouseEntered(e-> con.setStyle("-fx-border-color: black;"+"-fx-border-width: 4.5px;"+"-fx-font-family: 'Cooper Black';"+"-fx-font-weight: bold;"+"-fx-font-size: 19px;"+"-fx-text-fill: black;"+"-fx-background-color: '#D8D7D7';"));
    		con.setOnMouseExited(e-> con.setStyle("-fx-font-family: 'Cooper Black';"+"-fx-font-weight: bold;"+"-fx-font-size: 19px;"+"-fx-text-fill: '#D8D7D7';"+"-fx-background-color: black;"));
    		bto.setStyle("-fx-border-color: black;"+"-fx-border-width: 3px;");
    		btt.setStyle("-fx-border-color: black;"+"-fx-border-width: 3px;");
    	}
    	else if(layoutindex == 1)
    	{
    		con.setStyle("-fx-font-family: 'Cooper Black';"+"-fx-font-weight: bold;"+"-fx-font-size: 19px;"+"-fx-text-fill: '#3874ED';"+"-fx-background-color: '#EFD10F';");
        	con.setOnMouseEntered(e-> con.setStyle("-fx-border-color: '#EFD10F';"+"-fx-border-width: 4.5px;"+"-fx-font-family: 'Cooper Black';"+"-fx-font-weight: bold;"+"-fx-font-size: 19px;"+"-fx-text-fill: '#EFD10F';"+"-fx-background-color: '#3874ED';"));
        	con.setOnMouseExited(e-> con.setStyle("-fx-font-family: 'Cooper Black';"+"-fx-font-weight: bold;"+"-fx-font-size: 19px;"+"-fx-text-fill: '#3874ED';"+"-fx-background-color: '#EFD10F';"));
    		to.setStyle("-fx-border-width: 2px;"+"-fx-font-family: 'Goudy Stout';"+"-fx-font-size: 36px;"+"-fx-font-weight: bold;"+"-fx-text-fill: '#EFD10F';");
    		bto.setStyle("-fx-border-color: '#EFD10F';"+"-fx-border-width: 3px;");
    		btt.setStyle("-fx-border-color: '#EFD10F';"+"-fx-border-width: 3px;");
    	}
    	else if(layoutindex == 2)
    	{
    		con.setStyle("-fx-font-family: 'Cooper Black';"+"-fx-font-weight: bold;"+"-fx-font-size: 19px;"+"-fx-text-fill: '#535354';"+"-fx-background-color: '#CDCDCD';");
        	con.setOnMouseEntered(e-> con.setStyle("-fx-border-color: '#CDCDCD';"+"-fx-border-width: 4.5px;"+"-fx-font-family: 'Cooper Black';"+"-fx-font-weight: bold;"+"-fx-font-size: 19px;"+"-fx-text-fill: '#CDCDCD';"+"-fx-background-color: '#535354';"));
        	con.setOnMouseExited(e-> con.setStyle("-fx-font-family: 'Cooper Black';"+"-fx-font-weight: bold;"+"-fx-font-size: 19px;"+"-fx-text-fill: '#535354';"+"-fx-background-color: '#CDCDCD';"));
    		to.setStyle("-fx-border-width: 2px;"+"-fx-font-family: 'Goudy Stout';"+"-fx-font-size: 36px;"+"-fx-font-weight: bold;"+"-fx-text-fill: '#CDCDCD';");
    		bto.setStyle("-fx-border-color: '#CDCDCD';"+"-fx-border-width: 3px;");
    		btt.setStyle("-fx-border-color: '#CDCDCD';"+"-fx-border-width: 3px;");
    	}
    	else if(layoutindex == 3)
    	{
    		con.setStyle("-fx-font-family: 'Cooper Black';"+"-fx-font-weight: bold;"+"-fx-font-size: 19px;"+"-fx-text-fill: '#48D6C8';"+"-fx-background-color: '#BF0701';");
        	con.setOnMouseEntered(e-> con.setStyle("-fx-border-color: '#BF0701';"+"-fx-border-width: 4.5px;"+"-fx-font-family: 'Cooper Black';"+"-fx-font-weight: bold;"+"-fx-font-size: 19px;"+"-fx-text-fill: '#BF0701';"+"-fx-background-color: '#48D6C8';"));
        	con.setOnMouseExited(e-> con.setStyle("-fx-font-family: 'Cooper Black';"+"-fx-font-weight: bold;"+"-fx-font-size: 19px;"+"-fx-text-fill: '#48D6C8';"+"-fx-background-color: '#BF0701';"));
    		to.setStyle("-fx-border-width: 2px;"+"-fx-font-family: 'Goudy Stout';"+"-fx-font-size: 36px;"+"-fx-font-weight: bold;"+"-fx-text-fill: '#BF0701';");
    		bto.setStyle("-fx-border-color: '#BF0701';"+"-fx-border-width: 3px;");
            btt.setStyle("-fx-border-color: '#BF0701';"+"-fx-border-width: 3px;");
    	}
    	root.setStyle(rootattr);
    	root.getChildren().addAll(copyright , btt , bto , to , con);
    	Scene ins = new Scene(root, width, height);
    	s.setScene(ins);
    	s.show();
    	fdx.play();
    	ttcon.play();
    }
    public void GameOver(Stage s)
    {
    	if(audio == true)
    	{
    		URL resourcezz = getClass().getResource("sound effects/gameover.mp3");
    	    try
    	    {
    		   	media = new Media(resourcezz.toString());
    		   	if(media.getError() == null || media.getOnError() == null)
    		   	{
    		   		mediaPlayer = new MediaPlayer(media);
    		   		mediaPlayer.setVolume(0.4);
    		   		mediaPlayer.play();
    		   	}
    	    }
    	    catch(Exception e)
    	    {}
    	}
    	Button con = new Button("Continue");
    	con.setOnAction(e-> PlayAgain(s , 'o'));
    	con.setStyle("-fx-font-family: 'Arial Black';"+"-fx-font-weight: bold;"+"-fx-font-size: 20px;"+"-fx-border-width: 4px;"+"-fx-border-color: '#00C614';"+"-fx-text-fill: '#00C614';"+"-fx-border-radius: 20px;"+"-fx-background-radius: 21px;");
    	con.setPrefSize(150.0, 50.0);
    	con.setTranslateX(width - 200.0);
    	con.setTranslateY(height + 100.0);
    	TranslateTransition ttcon = new TranslateTransition();
    	ttcon.setNode(con);
    	ttcon.setToY(height - 100);
    	ttcon.setDelay(Duration.seconds(0.5));
    	ttcon.setDuration(Duration.seconds(0.5));
    	Label go = new Label("Game Over...");
    	go.setStyle("-fx-text-fill: '#FB0303';"+"-fx-font-weight: bold;"+"-fx-font-family: 'Arial Black';"+"-fx-font-size: 46px;");
    	Button bottom = new Button();
    	bottom.setStyle("-fx-background-color: '#2D56FC';");
    	bottom.setRotate(-10.0);
    	AnchorPane root = new AnchorPane();
    	//bottom
    	AnchorPane.setTopAnchor(bottom, height/2.0 + 100.0);
    	AnchorPane.setRightAnchor(bottom, -100.0);
    	AnchorPane.setLeftAnchor(bottom, -100.0);
    	AnchorPane.setBottomAnchor(bottom, -200.0);
    	//go
    	AnchorPane.setTopAnchor(go, 170.0);
    	AnchorPane.setRightAnchor(go, width/2.0 - 160.0);
    	
    	if(layoutindex == 0)
    	{
    		go.setStyle("-fx-border-width: 2px;"+"-fx-font-family: 'Arial Black';"+"-fx-font-size: 46px;"+"-fx-font-weight: bold;"+"-fx-text-fill: black;");
    		con.setStyle("-fx-font-family: 'Cooper Black';"+"-fx-font-weight: bold;"+"-fx-font-size: 19px;"+"-fx-text-fill: '#2D56FC';"+"-fx-background-color: black;");
    		con.setOnMouseEntered(e-> con.setStyle("-fx-border-color: black;"+"-fx-border-width: 4.5px;"+"-fx-font-family: 'Cooper Black';"+"-fx-font-weight: bold;"+"-fx-font-size: 19px;"+"-fx-text-fill: black;"+"-fx-background-color: '#2D56FC';"));
    		con.setOnMouseExited(e-> con.setStyle("-fx-font-family: 'Cooper Black';"+"-fx-font-weight: bold;"+"-fx-font-size: 19px;"+"-fx-text-fill: '#2D56FC';"+"-fx-background-color: black;"));
    	}
    	else if(layoutindex == 1)
    	{
    		con.setStyle("-fx-font-family: 'Cooper Black';"+"-fx-font-weight: bold;"+"-fx-font-size: 19px;"+"-fx-text-fill: '#2D56FC';"+"-fx-background-color: '#EFD10F';");
        	con.setOnMouseEntered(e-> con.setStyle("-fx-border-color: '#EFD10F';"+"-fx-border-width: 4.5px;"+"-fx-font-family: 'Cooper Black';"+"-fx-font-weight: bold;"+"-fx-font-size: 19px;"+"-fx-text-fill: '#EFD10F';"+"-fx-background-color: '#2D56FC';"));
        	con.setOnMouseExited(e-> con.setStyle("-fx-font-family: 'Cooper Black';"+"-fx-font-weight: bold;"+"-fx-font-size: 19px;"+"-fx-text-fill: '#2D56FC';"+"-fx-background-color: '#EFD10F';"));
    		go.setStyle("-fx-border-width: 2px;"+"-fx-font-family: 'Arial Black';"+"-fx-font-size: 46px;"+"-fx-font-weight: bold;"+"-fx-text-fill: '#EFD10F';");
    	}
    	else if(layoutindex == 2)
    	{
    		con.setStyle("-fx-font-family: 'Cooper Black';"+"-fx-font-weight: bold;"+"-fx-font-size: 19px;"+"-fx-text-fill: '#2D56FC';"+"-fx-background-color: '#CDCDCD';");
        	con.setOnMouseEntered(e-> con.setStyle("-fx-border-color: '#CDCDCD';"+"-fx-border-width: 4.5px;"+"-fx-font-family: 'Cooper Black';"+"-fx-font-weight: bold;"+"-fx-font-size: 19px;"+"-fx-text-fill: '#CDCDCD';"+"-fx-background-color: '#2D56FC';"));
        	con.setOnMouseExited(e-> con.setStyle("-fx-font-family: 'Cooper Black';"+"-fx-font-weight: bold;"+"-fx-font-size: 19px;"+"-fx-text-fill: '#2D56FC';"+"-fx-background-color: '#CDCDCD';"));
    		go.setStyle("-fx-border-width: 2px;"+"-fx-font-family: 'Arial Black';"+"-fx-font-size: 46px;"+"-fx-font-weight: bold;"+"-fx-text-fill: '#CDCDCD';");
    	}
    	else if(layoutindex == 3)
    	{
    		con.setStyle("-fx-font-family: 'Cooper Black';"+"-fx-font-weight: bold;"+"-fx-font-size: 19px;"+"-fx-text-fill: '#2D56FC';"+"-fx-background-color: '#BF0701';");
        	con.setOnMouseEntered(e-> con.setStyle("-fx-border-color: '#BF0701';"+"-fx-border-width: 4.5px;"+"-fx-font-family: 'Cooper Black';"+"-fx-font-weight: bold;"+"-fx-font-size: 19px;"+"-fx-text-fill: '#BF0701';"+"-fx-background-color: '#2D56FC';"));
        	con.setOnMouseExited(e-> con.setStyle("-fx-font-family: 'Cooper Black';"+"-fx-font-weight: bold;"+"-fx-font-size: 19px;"+"-fx-text-fill: '#2D56FC';"+"-fx-background-color: '#BF0701';"));
    		go.setStyle("-fx-border-width: 2px;"+"-fx-font-family: 'Arial Black';"+"-fx-font-size: 46px;"+"-fx-font-weight: bold;"+"-fx-text-fill: '#BF0701';");
    	}
    	root.setStyle(rootattr);
    	root.getChildren().addAll(bottom , copyright , go , con);
    	Scene ins = new Scene(root, width, height);
    	s.setScene(ins);
    	s.show();
    	ttcon.play();
    }
    Button b1 = new Button();
	Button b2 = new Button();
	Button b3 = new Button();
	Button b4 = new Button();
    public void GameWon(Stage s)
    {
    	if(audio == true)
    	{
    		URL resourcez = getClass().getResource("sound effects/Win.mp3");
    	    try
    	    {
    		   	Media media = new Media(resourcez.toString());
    		   	if(media.getError() == null || media.getOnError() == null)
    		   	{
    		   		mediaPlayer = new MediaPlayer(media);
    		   		mediaPlayer.setVolume(0.7);
    		   		mediaPlayer.play();
    		   	}
    	    }
    	    catch(Exception e)
    	    {}
    	}
    	
    	Button conn = new Button("Continue");
    	conn.setStyle("-fx-font-weight: bold;"+"-fx-background-radius: 16px;"+"-fx-border-radius: 15px;"+"-fx-border-width: 3px;"+"-fx-font-family: 'Bodoni MT';"+"-fx-background-color: '#0B6617';"+"-fx-text-fill: white;"+"-fx-font-size: 19px;"+"-fx-border-color: white;");
    	conn.setOnAction(e-> PlayAgain(s , 'w'));
    	conn.setPrefWidth(200.0);
    	conn.setTranslateX(width/2.0 - 90.0);
    	conn.setTranslateY(height + 100.0);
    	TranslateTransition ttconn = new TranslateTransition();
    	ttconn.setNode(conn);
    	ttconn.setToY(height - 200);
    	ttconn.setDelay(Duration.seconds(0.7));
    	ttconn.setDuration(Duration.seconds(0.7));
    	conn.setOnMouseExited(e-> conn.setStyle("-fx-font-weight: bold;"+"-fx-background-radius: 16px;"+"-fx-border-radius: 15px;"+"-fx-border-width: 3px;"+"-fx-font-family: 'Bodoni MT';"+"-fx-background-color: '#0B6617';"+"-fx-text-fill: white;"+"-fx-font-size: 19px;"+"-fx-border-color: white;"));
    	conn.setOnMouseReleased(e-> conn.setStyle("-fx-font-weight: bold;"+"-fx-background-radius: 16px;"+"-fx-border-radius: 15px;"+"-fx-border-width: 3px;"+"-fx-font-family: 'Bodoni MT';"+"-fx-background-color: '#0B6617';"+"-fx-text-fill: white;"+"-fx-font-size: 19px;"+"-fx-border-color: white;"));
    	conn.setOnMouseEntered(e-> conn.setStyle("-fx-font-weight: bold;"+"-fx-background-radius: 16px;"+"-fx-border-radius: 15px;"+"-fx-border-width: 4px;"+"-fx-font-family: 'Bodoni MT';"+"-fx-background-color: white;"+"-fx-text-fill: '#0B6617';"+"-fx-font-size: 20px;"+"-fx-border-color: white;"));
    	conn.setOnMousePressed(e-> conn.setStyle("-fx-font-weight: bold;"+"-fx-background-radius: 16px;"+"-fx-border-radius: 15px;"+"-fx-border-width: 5px;"+"-fx-font-family: 'Bodoni MT';"+"-fx-background-color: white;"+"-fx-text-fill: '#0B6617';"+"-fx-font-size: 21px;"+"-fx-border-color: white;"));
    	Label cong = new Label("Congratulations!");
    	cong.setStyle("-fx-text-fill: white;"+"-fx-font-family: 'Arial Black';"+"-fx-font-size: 23px;");
    	FadeTransition fd = new FadeTransition(Duration.seconds(0.6));
    	fd.setFromValue(0.2);
    	fd.setToValue(1.0);
    	fd.setCycleCount(Animation.INDEFINITE);
    	fd.setNode(cong);
    	Label byw = new Label("           YOU WIN");
    	byw.setStyle("-fx-text-fill: white;"+"-fx-font-weight: bold;"+"-fx-font-family: 'Arial Black';"+"-fx-font-size: 46px;"+"-fx-border-color: white;"+"-fx-border-width: 5px;");
    	b1.setStyle("-fx-background-color: '#FB7D00';");	//orange
    	b2.setStyle("-fx-background-color: '#301292';");	//dark blue
    	b3.setStyle("-fx-background-color: '#FB0000';");	//red
    	b4.setStyle("-fx-background-color: '#EAFB00';");	//yellow
    	b2.setPrefSize(400.0, height + 700.0);
    	b2.setRotate(10.0);
    	b1.setPrefSize(width + 200.0, height - 200.0);
    	b1.setRotate(-6.0);
    	b3.setPrefSize(width/2.0, height + 300.0);
    	b3.setRotate(-30.0);
    	b4.setPrefSize(width + 300.0, height - 300.0);
    	b4.setRotate(-7.0);
    	AnchorPane root = new AnchorPane();
    	//b2
    	AnchorPane.setRightAnchor(b2, width - 60.0);
    	AnchorPane.setTopAnchor(b2, -100.0);
    	//b1
    	AnchorPane.setTopAnchor(b1, -220.0);
    	//b3
    	AnchorPane.setRightAnchor(b3, -250.0);
    	AnchorPane.setTopAnchor(b3, -100.0);
    	//b4
    	AnchorPane.setBottomAnchor(b4, -80.0);
    	//byw
    	AnchorPane.setTopAnchor(byw, 90.0);
    	AnchorPane.setLeftAnchor(byw, 150.0);
    	AnchorPane.setRightAnchor(byw, 150.0);
    	AnchorPane.setBottomAnchor(byw, 330.0);
    	//cong
    	AnchorPane.setTopAnchor(cong, 180.0);
    	AnchorPane.setLeftAnchor(cong, width/2.0 - 90.0);
    	root.setStyle("-fx-background-color: '#0B6617';");	//dark green
    	root.getChildren().addAll(b3 , b1 , b2 , b4 , copyright , byw , conn, cong);
    	Scene ins = new Scene(root, width, height);
    	s.setScene(ins);
    	s.show();
    	fd.play();
    	ttconn.play();
    }
    public void NewGamePage2(Stage s)
    {
    	if(audio == true)
    	{
    		URL resource = getClass().getResource("sound effects/open.mp3");
    	    try
    	    {
    		   	Media media = new Media(resource.toString());
    		   	if(media.getError() == null || media.getOnError() == null)
    		   	{
    		   		mediaPlayer = new MediaPlayer(media);
    		   		mediaPlayer.setStartTime(Duration.seconds(1.61));
    	 	   		mediaPlayer.setVolume(0.5);
    		   		mediaPlayer.play();
    		   	}
    	    }
    	    catch(Exception e)
    	    {}
    	}
    	COUNT = 0;
    	SCORE = 0;
    	btnN.setOnAction(e-> Flow(s));
    	change.setOnAction(e-> NewGamePage1(s));
    	//assigning maximum of 20 characters to playername via playernamex
    	playernamex.delete(0, 100);		//deleting previous playernamex
    	playernamex.insert(0,tf.getText().trim());	//inserting new text to pos0. tf.getText(). And trimming the text from tf.getText()
    	playernamex.setLength(20);	//setting a max of 20 characters and deleting the excess
    	playername = playernamex.toString();	//assigning the name to playername
    	Label lname = new Label("Name:");
    	Label lmode = new Label("Mode:");
    	Label entname = new Label(playername);
    	Label entmode = new Label(mode);
    	Label lcategory = new Label("Category:");
    	Label entcategory = new Label(category);
    	Label entremember = new Label();
    	if(cbhighscore.isSelected() == true)
    		entremember.setText("Your Score(s) will be saved.");
    	else
    		entremember.setText("Your Score(s) will not be saved.");
    	
    	String changeattrR = "-fx-background-color: firebrick;" + 
    					     "-fx-text-fill: bisque;" +
    					     "-fx-font-weight: normal;" +
    					     "-fx-font-family: 'Bahnschrift Light SemiCondensed';" +
    					     "-fx-font-size: 24px;";
    	String changeattrH = "-fx-background-color: #6a0000;" + 
    					     "-fx-text-fill: white;" +
    					     "-fx-font-weight: bold;" +
    					     "-fx-font-family: 'Bahnschrift Light SemiCondensed';" +
    					     "-fx-font-size: 25px;";
    	String changeattrP = "-fx-background-color: #5a0000;" + 
    				     	 "-fx-text-fill: white;" +
    				     	 "-fx-font-weight: bold;" +
    				     	 "-fx-font-family: 'Bahnschrift Light SemiCondensed';" +
    				     	 "-fx-font-size: 26px;";
    	String contentsattrR = "-fx-background-color: mediumorchid;" + 
    						   "-fx-text-fill: oldlace;" +
			                   "-fx-font-weight: normal;" +
			                   "-fx-font-family: 'Cambria';" +
			                   "-fx-font-size: 18px;";
    	String contentsattrH = "-fx-background-color: #900080;" + 
    			               "-fx-text-fill: white;" +
			                   "-fx-font-weight: bold;" +
			                   "-fx-font-family: 'Bahnschrift Light SemiCondensed';" +
			                   "-fx-font-size: 20px;";
    	String contentsattrP = "-fx-background-color: #800080;" + 
    			               "-fx-text-fill: white;" +
			                   "-fx-font-weight: bold;" +
			                   "-fx-font-family: 'Bahnschrift Light SemiCondensed';" +
			                   "-fx-font-size: 21px;";
    	
    	String lattr = "-fx-font-family: 'Rockwell';" + "-fx-font-size: 16px;";
    	String entattr = "-fx-font-family: 'Rockwell Extra Bold';" + "-fx-font-size: 17px;";
    	
    	lname.setStyle(lattr);
    	lmode.setStyle(lattr);
    	lcategory.setStyle(lattr);
    	entname.setStyle(entattr);
    	entmode.setStyle(entattr);
    	entremember.setStyle(entattr);
    	entcategory.setStyle(entattr);
    	
    	contents.setStyle(contentsattrR);
    	change.setStyle(changeattrR);
    	//change released, pressed, hovering attributes
    	change.setOnMouseReleased(e-> change.setStyle(changeattrR));
    	change.setOnMouseExited(e-> change.setStyle(changeattrR));
    	change.setOnMouseMoved(e-> change.setStyle(changeattrH));
    	change.setOnMousePressed(e-> change.setStyle(changeattrP));
    	//contents released, pressed, hovering attributes
    	contents.setOnMouseReleased(e-> contents.setStyle(contentsattrR));
    	contents.setOnMouseExited(e-> contents.setStyle(contentsattrR));
    	contents.setOnMouseMoved(e-> contents.setStyle(contentsattrH));
    	contents.setOnMousePressed(e-> contents.setStyle(contentsattrP));
    	
    	//heading
    	Label chead = new Label("confirmation");
    	chead.setStyle("-fx-text-fill: darkred;"+"-fx-font-size: 30px;"+"-fx-font-weight: bold;");
    	Separator cheadsep = new Separator();
    	cheadsep.setPrefWidth(width-50);
    	cheadsep.setStyle("-fx-background-color: darkred;");
    	
    	AnchorPane root = new AnchorPane();
    	
    	//Positioning cheadsep
    	AnchorPane.setTopAnchor(cheadsep, 49.0);
    	AnchorPane.setLeftAnchor(cheadsep, 25.0);
    	//Positioning chead
    	AnchorPane.setTopAnchor(chead, 7.0);
    	AnchorPane.setLeftAnchor(chead, 30.0);
    	//Positioning change
    	AnchorPane.setTopAnchor(change, 320.0);
    	AnchorPane.setLeftAnchor(change, 134.0);
    	AnchorPane.setRightAnchor(change, 134.0);
    	AnchorPane.setBottomAnchor(change, 109.0);
    	//Positioning contents
    	AnchorPane.setTopAnchor(contents, 440.0);
    	AnchorPane.setLeftAnchor(contents, 470.0);
    	AnchorPane.setRightAnchor(contents, 245.0);
    	AnchorPane.setBottomAnchor(contents, 15.0);
    	//Positioning lname
    	AnchorPane.setTopAnchor(lname, 110.0);
    	AnchorPane.setLeftAnchor(lname, 200.0);
    	//Positioning entname
    	AnchorPane.setTopAnchor(entname, 110.0);
    	AnchorPane.setLeftAnchor(entname, 300.0);
    	//Positioning lmode
    	AnchorPane.setTopAnchor(lmode, 142.0);
    	AnchorPane.setLeftAnchor(lmode, 201.0);
    	//Positioning entmode
    	AnchorPane.setTopAnchor(entmode, 140.0);
    	AnchorPane.setLeftAnchor(entmode, 300.0);
    	//Positioning lcategory
    	AnchorPane.setTopAnchor(lcategory, 172.0);
    	AnchorPane.setLeftAnchor(lcategory, 174.0);
    	//Positioning entcategory
    	AnchorPane.setTopAnchor(entcategory, 170.0);
    	AnchorPane.setLeftAnchor(entcategory, 300.0);
    	//Positioning entremember
    	if(cbhighscore.isSelected() == true)
    	{
    		AnchorPane.setTopAnchor(entremember, 240.0);
        	AnchorPane.setLeftAnchor(entremember, 278.0);
    	}
    	else
    	{
    		AnchorPane.setTopAnchor(entremember, 240.0);
    	    AnchorPane.setLeftAnchor(entremember, 270.0);
    	}
    	btnN.setText("Play");
    	root.setStyle("-fx-background-color: bisque;");
    	root.getChildren().addAll(chead, cheadsep, sep, contents, btnN,  exit , copyright , change , lname , lmode , entname , entmode , lcategory, entcategory, entremember);
    	Scene ins = new Scene(root, width, height);
    	s.setScene(ins);
    	s.show();
    }
    
    public void Separator(String sample)
    {
    	int qend = 0 , colon = 0;
    	QUESTION = "";
    	OPTION1 = "";
    	OPTION2 = "";
    	OPTION3 = "";
    	OPTION4 = "";
    	ANSWER = 0;
    	
    	int i=0;
    	char ch =sample.charAt(0);
    	while(ch != '*')
    	{
    		
    		ch=sample.charAt(i);
    		if(qend == 0)
    		{
    			if(ch != '?')
    				QUESTION = QUESTION.concat(ch+"");
    			else //question ends
    			{
    				QUESTION = QUESTION.concat(ch+"\0");
    				qend = 1;
    			}
    		}
    		
    		if(qend == 1)
    		{
    			if(colon == 0)	//bring out option 1
    			{
    				if(ch == ';')
    				{
    					colon++;i++;
    					continue;
    				}	
    				if(ch != '?')
    					OPTION1 = OPTION1.concat(ch+"");
    			}
    			else if(colon == 1)	//bring out option 2
    			{
    				if(ch == ';')
    				{
    					colon++;i++;
    					continue;
    				}	
    				OPTION2 = OPTION2.concat(ch+"");
    			}
    			else if(colon == 2)	//bring out option 3
    			{
    				if(ch == ';')
    				{
    					colon++;i++;
    					continue;
    				}	
    				OPTION3 = OPTION3.concat(ch+"");
    			}
    			else if(colon == 3)	//bring out option 4
    			{
    				if(ch == ';')
    				{
    					colon = 0;
    					ANSWER = (int)(sample.charAt(i+3) - 48);
    					return;
    				}	
    				OPTION4 = OPTION4.concat(ch+"");
    			}
    				
    		}
    			i++;
    	}
    	//Assigning the above to respective label and radio buttons
    	questionC.setText(QUESTION);
    	OPT1C.setText(OPTION1);
    	OPT2C.setText(OPTION2);
    	OPT3C.setText(OPTION3);
    	OPT4C.setText(OPTION4);
    }
    
    Timeline gameanimation;
    int gametag = 20;
    Label gamelabel = new Label("00:20");
    String gameS = "";
    
    public void gametimelabel()
    {
    	if(gametag > 1)
		{
			gametag--;
		}
    	if(gametag > 9)
    	{
    		gamelabel.setStyle(gametimerattr);
    		gameS = "00:" + gametag;
    	}
		else
    	{	
    		gameS = "00:0" + gametag;
    		if(gametag < 6)
    			gamelabel.setTextFill(Color.RED);
    	}
    	gamelabel.setText(gameS);
    }
    Label leb1 = new Label();
	Label leb2 = new Label();
	Separator qsep = new Separator();
	int yoac = 0;
	public void BluePrint()
    {
		yoac = 0;
		String optsNORMAL = "-fx-font-family: 'Constantia';"+"-fx-font-size: 18px;"+"-fx-font-weight: normal;";
		String optsBOLD = "-fx-font-family: 'Arial';"+"-fx-font-size: 18px;"+"-fx-font-weight: bold;";
		
		//setting game layout
    	if(layoutindex == 0)	//Classic
    	{
    		yoa.setStyle("-fx-font-size: 17px;"+"-fx-text-fill: black;");
    		pause.setStyle("-fx-font-family: 'Cooper Black';"+"-fx-font-weight: bold;"+"-fx-font-size: 17px;"+"-fx-text-fill: '#D8D7D7';"+"-fx-background-color: black;");
        	pause.setOnMouseEntered(e-> pause.setStyle("-fx-border-color: black;"+"-fx-border-width: 4.5px;"+"-fx-font-family: 'Cooper Black';"+"-fx-font-weight: bold;"+"-fx-font-size: 15px;"+"-fx-text-fill: black;"+"-fx-background-color: '#D8D7D7';"));
        	pause.setOnMouseExited(e-> pause.setStyle("-fx-font-family: 'Cooper Black';"+"-fx-font-weight: bold;"+"-fx-font-size: 17px;"+"-fx-text-fill: '#D8D7D7';"+"-fx-background-color: black;"));
        	gametimerattr = "-fx-text-fill: black;"+"-fx-font-size: 28px;"+"-fx-font-weight: bold;"+"-fx-font-family: 'HelvLight';";
    		gamelabel.setStyle(gametimerattr);
    		leb1.setStyle("-fx-border-color: black;"+"-fx-border-width: 3px;");
            leb2.setStyle("-fx-border-color: black;"+"-fx-border-width: 3px;");
            qsep.setStyle("-fx-background-color: black;");
            rootattr = "-fx-background-color: '#D8D7D7';";
            if(boldques == true)
        		questionC.setStyle("-fx-text-fill: black;"+"-fx-font-size: 18px;"+"-fx-font-weight: bold;"+"-fx-font-family: 'Arial';");
        	else
        		questionC.setStyle("-fx-text-fill: black;"+"-fx-font-size: 20px;"+"-fx-font-weight: normal;"+"-fx-font-family: 'Arial';");
            if(boldopts == false)
        	{
        		OPT1C.setStyle(optsNORMAL + "-fx-text-fill: black;");
        		OPT2C.setStyle(optsNORMAL + "-fx-text-fill: black;");
        		OPT3C.setStyle(optsNORMAL + "-fx-text-fill: black;");
        		OPT4C.setStyle(optsNORMAL + "-fx-text-fill: black;");
        		
        		OPT1C.setOnMouseExited(e-> OPT1C.setStyle(optsNORMAL + "-fx-text-fill: black;"));
            	OPT2C.setOnMouseExited(e-> OPT2C.setStyle(optsNORMAL + "-fx-text-fill: black;"));
            	OPT3C.setOnMouseExited(e-> OPT3C.setStyle(optsNORMAL + "-fx-text-fill: black;"));
            	OPT4C.setOnMouseExited(e-> OPT4C.setStyle(optsNORMAL + "-fx-text-fill: black;"));
            }
        	else
        	{
        		OPT1C.setStyle(optsBOLD + "-fx-text-fill: black;");
        		OPT2C.setStyle(optsBOLD + "-fx-text-fill: black;");
        		OPT3C.setStyle(optsBOLD + "-fx-text-fill: black;");
        		OPT4C.setStyle(optsBOLD + "-fx-text-fill: black;");
        	
        		OPT1C.setOnMouseExited(e-> OPT1C.setStyle(optsBOLD + "-fx-text-fill: black;"));
            	OPT2C.setOnMouseExited(e-> OPT2C.setStyle(optsBOLD + "-fx-text-fill: black;"));
            	OPT3C.setOnMouseExited(e-> OPT3C.setStyle(optsBOLD + "-fx-text-fill: black;"));
            	OPT4C.setOnMouseExited(e-> OPT4C.setStyle(optsBOLD + "-fx-text-fill: black;"));
        	}
            OPT1C.setOnMouseEntered(e-> OPT1C.setStyle("-fx-text-fill: '#0101FF';"+"-fx-font-family: 'Arial';"+"-fx-font-size: 20px;"+"-fx-font-weight: bold;"));
        	OPT2C.setOnMouseEntered(e-> OPT2C.setStyle("-fx-text-fill: '#0101FF';"+"-fx-font-family: 'Arial';"+"-fx-font-size: 20px;"+"-fx-font-weight: bold;"));
        	OPT3C.setOnMouseEntered(e-> OPT3C.setStyle("-fx-text-fill: '#0101FF';"+"-fx-font-family: 'Arial';"+"-fx-font-size: 20px;"+"-fx-font-weight: bold;"));
        	OPT4C.setOnMouseEntered(e-> OPT4C.setStyle("-fx-text-fill: '#0101FF';"+"-fx-font-family: 'Arial';"+"-fx-font-size: 20px;"+"-fx-font-weight: bold;"));
    	}
    	else if(layoutindex == 1)	//Eclipse
    	{
    		yoa.setStyle("-fx-font-size: 17px;"+"-fx-text-fill: '#EFD10F';");
    		pause.setStyle("-fx-font-family: 'Cooper Black';"+"-fx-font-weight: bold;"+"-fx-font-size: 17px;"+"-fx-text-fill: '#3874ED';"+"-fx-background-color: '#EFD10F';");
        	pause.setOnMouseEntered(e-> pause.setStyle("-fx-border-color: '#EFD10F';"+"-fx-border-width: 4.5px;"+"-fx-font-family: 'Cooper Black';"+"-fx-font-weight: bold;"+"-fx-font-size: 15px;"+"-fx-text-fill: '#EFD10F';"+"-fx-background-color: '#3874ED';"));
        	pause.setOnMouseExited(e-> pause.setStyle("-fx-font-family: 'Cooper Black';"+"-fx-font-weight: bold;"+"-fx-font-size: 17px;"+"-fx-text-fill: '#3874ED';"+"-fx-background-color: '#EFD10F';"));
    		gametimerattr = "-fx-text-fill: '#EFD10F';"+"-fx-font-size: 28px;"+"-fx-font-weight: bold;"+"-fx-font-family: 'HelvLight';";
    		gamelabel.setStyle(gametimerattr);
    		leb1.setStyle("-fx-border-color: '#EFD10F';"+"-fx-border-width: 3px;");
            leb2.setStyle("-fx-border-color: '#EFD10F';"+"-fx-border-width: 3px;");
            qsep.setStyle("-fx-background-color: '#EFD10F';");
            rootattr = "-fx-background-color: '#3874ED';";
            if(boldques == true)
        		questionC.setStyle("-fx-text-fill: '#EFD10F';"+"-fx-font-size: 18px;"+"-fx-font-weight: bold;"+"-fx-font-family: 'Arial';");
        	else
        		questionC.setStyle("-fx-text-fill: '#EFD10F';"+"-fx-font-size: 20px;"+"-fx-font-weight: normal;"+"-fx-font-family: 'Arial';");
            if(boldopts == false)
        	{
        		OPT1C.setStyle(optsNORMAL + "-fx-text-fill: '#EFD10F';");
        		OPT2C.setStyle(optsNORMAL + "-fx-text-fill: '#EFD10F';");
        		OPT3C.setStyle(optsNORMAL + "-fx-text-fill: '#EFD10F';");
        		OPT4C.setStyle(optsNORMAL + "-fx-text-fill: '#EFD10F';");
        		
        		OPT1C.setOnMouseExited(e-> OPT1C.setStyle(optsNORMAL + "-fx-text-fill: '#EFD10F';"));
            	OPT2C.setOnMouseExited(e-> OPT2C.setStyle(optsNORMAL + "-fx-text-fill: '#EFD10F';"));
            	OPT3C.setOnMouseExited(e-> OPT3C.setStyle(optsNORMAL + "-fx-text-fill: '#EFD10F';"));
            	OPT4C.setOnMouseExited(e-> OPT4C.setStyle(optsNORMAL + "-fx-text-fill: '#EFD10F';"));
            }
        	else
        	{
        		OPT1C.setStyle(optsBOLD + "-fx-text-fill: '#EFD10F';");
        		OPT2C.setStyle(optsBOLD + "-fx-text-fill: '#EFD10F';");
        		OPT3C.setStyle(optsBOLD + "-fx-text-fill: '#EFD10F';");
        		OPT4C.setStyle(optsBOLD + "-fx-text-fill: '#EFD10F';");
        	
        		OPT1C.setOnMouseExited(e-> OPT1C.setStyle(optsBOLD + "-fx-text-fill: '#EFD10F';"));
            	OPT2C.setOnMouseExited(e-> OPT2C.setStyle(optsBOLD + "-fx-text-fill: '#EFD10F';"));
            	OPT3C.setOnMouseExited(e-> OPT3C.setStyle(optsBOLD + "-fx-text-fill: '#EFD10F';"));
            	OPT4C.setOnMouseExited(e-> OPT4C.setStyle(optsBOLD + "-fx-text-fill: '#EFD10F';"));
        	}
            OPT1C.setOnMouseEntered(e-> OPT1C.setStyle("-fx-text-fill: '#FF0901';"+"-fx-font-family: 'Arial';"+"-fx-font-size: 20px;"+"-fx-font-weight: bold;"));
        	OPT2C.setOnMouseEntered(e-> OPT2C.setStyle("-fx-text-fill: '#FF0901';"+"-fx-font-family: 'Arial';"+"-fx-font-size: 20px;"+"-fx-font-weight: bold;"));
        	OPT3C.setOnMouseEntered(e-> OPT3C.setStyle("-fx-text-fill: '#FF0901';"+"-fx-font-family: 'Arial';"+"-fx-font-size: 20px;"+"-fx-font-weight: bold;"));
        	OPT4C.setOnMouseEntered(e-> OPT4C.setStyle("-fx-text-fill: '#FF0901';"+"-fx-font-family: 'Arial';"+"-fx-font-size: 20px;"+"-fx-font-weight: bold;"));
    	}
    	else if(layoutindex == 2)	//Moonlight
    	{
    		yoa.setStyle("-fx-font-size: 17px;"+"-fx-text-fill: '#CDCDCD';");
    		pause.setStyle("-fx-font-family: 'Cooper Black';"+"-fx-font-weight: bold;"+"-fx-font-size: 17px;"+"-fx-text-fill: '#535354';"+"-fx-background-color: '#CDCDCD';");
        	pause.setOnMouseEntered(e-> pause.setStyle("-fx-border-color: '#CDCDCD';"+"-fx-border-width: 4.5px;"+"-fx-font-family: 'Cooper Black';"+"-fx-font-weight: bold;"+"-fx-font-size: 15px;"+"-fx-text-fill: '#CDCDCD';"+"-fx-background-color: '#535354';"));
        	pause.setOnMouseExited(e-> pause.setStyle("-fx-font-family: 'Cooper Black';"+"-fx-font-weight: bold;"+"-fx-font-size: 17px;"+"-fx-text-fill: '#535354';"+"-fx-background-color: '#CDCDCD';"));
    		gametimerattr = "-fx-text-fill: '#CDCDCD';"+"-fx-font-size: 28px;"+"-fx-font-weight: bold;"+"-fx-font-family: 'HelvLight';";
    		gamelabel.setStyle(gametimerattr);
    		leb1.setStyle("-fx-border-color: '#CDCDCD';"+"-fx-border-width: 3px;");
            leb2.setStyle("-fx-border-color: '#CDCDCD';"+"-fx-border-width: 3px;");
            qsep.setStyle("-fx-background-color: '#CDCDCD';");
            rootattr = "-fx-background-color: '#535354';";
            if(boldques == true)
        		questionC.setStyle("-fx-text-fill: '#CDCDCD';"+"-fx-font-size: 18px;"+"-fx-font-weight: bold;"+"-fx-font-family: 'Arial';");
        	else
        		questionC.setStyle("-fx-text-fill: '#CDCDCD';"+"-fx-font-size: 20px;"+"-fx-font-weight: normal;"+"-fx-font-family: 'Arial';");
            if(boldopts == false)
        	{
        		OPT1C.setStyle(optsNORMAL + "-fx-text-fill: '#CDCDCD';");
        		OPT2C.setStyle(optsNORMAL + "-fx-text-fill: '#CDCDCD';");
        		OPT3C.setStyle(optsNORMAL + "-fx-text-fill: '#CDCDCD';");
        		OPT4C.setStyle(optsNORMAL + "-fx-text-fill: '#CDCDCD';");
        		
        		OPT1C.setOnMouseExited(e-> OPT1C.setStyle(optsNORMAL + "-fx-text-fill: '#CDCDCD';"));
            	OPT2C.setOnMouseExited(e-> OPT2C.setStyle(optsNORMAL + "-fx-text-fill: '#CDCDCD';"));
            	OPT3C.setOnMouseExited(e-> OPT3C.setStyle(optsNORMAL + "-fx-text-fill: '#CDCDCD';"));
            	OPT4C.setOnMouseExited(e-> OPT4C.setStyle(optsNORMAL + "-fx-text-fill: '#CDCDCD';"));
            }
        	else
        	{
        		OPT1C.setStyle(optsBOLD + "-fx-text-fill: '#CDCDCD';");
        		OPT2C.setStyle(optsBOLD + "-fx-text-fill: '#CDCDCD';");
        		OPT3C.setStyle(optsBOLD + "-fx-text-fill: '#CDCDCD';");
        		OPT4C.setStyle(optsBOLD + "-fx-text-fill: '#CDCDCD';");
        	
        		OPT1C.setOnMouseExited(e-> OPT1C.setStyle(optsBOLD + "-fx-text-fill: '#CDCDCD';"));
            	OPT2C.setOnMouseExited(e-> OPT2C.setStyle(optsBOLD + "-fx-text-fill: '#CDCDCD';"));
            	OPT3C.setOnMouseExited(e-> OPT3C.setStyle(optsBOLD + "-fx-text-fill: '#CDCDCD';"));
            	OPT4C.setOnMouseExited(e-> OPT4C.setStyle(optsBOLD + "-fx-text-fill: '#CDCDCD';"));
        	}
            OPT1C.setOnMouseEntered(e-> OPT1C.setStyle("-fx-text-fill: white;"+"-fx-font-family: 'Arial';"+"-fx-font-size: 20px;"+"-fx-font-weight: bold;"));
        	OPT2C.setOnMouseEntered(e-> OPT2C.setStyle("-fx-text-fill: white;"+"-fx-font-family: 'Arial';"+"-fx-font-size: 20px;"+"-fx-font-weight: bold;"));
        	OPT3C.setOnMouseEntered(e-> OPT3C.setStyle("-fx-text-fill: white;"+"-fx-font-family: 'Arial';"+"-fx-font-size: 20px;"+"-fx-font-weight: bold;"));
        	OPT4C.setOnMouseEntered(e-> OPT4C.setStyle("-fx-text-fill: white;"+"-fx-font-family: 'Arial';"+"-fx-font-size: 20px;"+"-fx-font-weight: bold;"));
    	}
    	else if(layoutindex == 3)	//Red
    	{
    		yoa.setStyle("-fx-font-size: 17px;"+"-fx-text-fill: '#BF0701';");
    		pause.setStyle("-fx-font-family: 'Cooper Black';"+"-fx-font-weight: bold;"+"-fx-font-size: 17px;"+"-fx-text-fill: '#48D6C8';"+"-fx-background-color: '#BF0701';");
        	pause.setOnMouseEntered(e-> pause.setStyle("-fx-border-color: '#BF0701';"+"-fx-border-width: 4.5px;"+"-fx-font-family: 'Cooper Black';"+"-fx-font-weight: bold;"+"-fx-font-size: 15px;"+"-fx-text-fill: '#BF0701';"+"-fx-background-color: '#48D6C8';"));
        	pause.setOnMouseExited(e-> pause.setStyle("-fx-font-family: 'Cooper Black';"+"-fx-font-weight: bold;"+"-fx-font-size: 17px;"+"-fx-text-fill: '#48D6C8';"+"-fx-background-color: '#BF0701';"));
    		gametimerattr = "-fx-text-fill: '#BF0701';"+"-fx-font-size: 28px;"+"-fx-font-weight: bold;"+"-fx-font-family: 'HelvLight';";
    		gamelabel.setStyle(gametimerattr);
    		leb1.setStyle("-fx-border-color: '#BF0701';"+"-fx-border-width: 3px;");
            leb2.setStyle("-fx-border-color: '#BF0701';"+"-fx-border-width: 3px;");
            qsep.setStyle("-fx-background-color: '#BF0701';");
            rootattr = "-fx-background-color: '#48D6C8';";
            if(boldques == true)
        		questionC.setStyle("-fx-text-fill: '#BF0701';"+"-fx-font-size: 18px;"+"-fx-font-weight: bold;"+"-fx-font-family: 'Arial';");
        	else
        		questionC.setStyle("-fx-text-fill: '#BF0701';"+"-fx-font-size: 20px;"+"-fx-font-weight: normal;"+"-fx-font-family: 'Arial';");
            if(boldopts == false)
        	{
        		OPT1C.setStyle(optsNORMAL + "-fx-text-fill: '#BF0701';");
        		OPT2C.setStyle(optsNORMAL + "-fx-text-fill: '#BF0701';");
        		OPT3C.setStyle(optsNORMAL + "-fx-text-fill: '#BF0701';");
        		OPT4C.setStyle(optsNORMAL + "-fx-text-fill: '#BF0701';");
        		
        		OPT1C.setOnMouseExited(e-> OPT1C.setStyle(optsNORMAL + "-fx-text-fill: '#BF0701';"));
            	OPT2C.setOnMouseExited(e-> OPT2C.setStyle(optsNORMAL + "-fx-text-fill: '#BF0701';"));
            	OPT3C.setOnMouseExited(e-> OPT3C.setStyle(optsNORMAL + "-fx-text-fill: '#BF0701';"));
            	OPT4C.setOnMouseExited(e-> OPT4C.setStyle(optsNORMAL + "-fx-text-fill: '#BF0701';"));
            }
        	else
        	{
        		OPT1C.setStyle(optsBOLD + "-fx-text-fill: '#BF0701';");
        		OPT2C.setStyle(optsBOLD + "-fx-text-fill: '#BF0701';");
        		OPT3C.setStyle(optsBOLD + "-fx-text-fill: '#BF0701';");
        		OPT4C.setStyle(optsBOLD + "-fx-text-fill: '#BF0701';");
        	
        		OPT1C.setOnMouseExited(e-> OPT1C.setStyle(optsBOLD + "-fx-text-fill: '#BF0701';"));
            	OPT2C.setOnMouseExited(e-> OPT2C.setStyle(optsBOLD + "-fx-text-fill: '#BF0701';"));
            	OPT3C.setOnMouseExited(e-> OPT3C.setStyle(optsBOLD + "-fx-text-fill: '#BF0701';"));
            	OPT4C.setOnMouseExited(e-> OPT4C.setStyle(optsBOLD + "-fx-text-fill: '#BF0701';"));
        	}
            OPT1C.setOnMouseEntered(e-> OPT1C.setStyle("-fx-text-fill: '#880500';"+"-fx-font-family: 'Arial';"+"-fx-font-size: 20px;"+"-fx-font-weight: bold;"));
        	OPT2C.setOnMouseEntered(e-> OPT2C.setStyle("-fx-text-fill: '#880500';"+"-fx-font-family: 'Arial';"+"-fx-font-size: 20px;"+"-fx-font-weight: bold;"));
        	OPT3C.setOnMouseEntered(e-> OPT3C.setStyle("-fx-text-fill: '#880500';"+"-fx-font-family: 'Arial';"+"-fx-font-size: 20px;"+"-fx-font-weight: bold;"));
        	OPT4C.setOnMouseEntered(e-> OPT4C.setStyle("-fx-text-fill: '#880500';"+"-fx-font-family: 'Arial';"+"-fx-font-size: 20px;"+"-fx-font-weight: bold;"));
    	}
    	
    	//GamePage(s) boxes
    	lebx1.setStyle("-fx-background-color: '1E90FF';"+"-fx-text-fill: white;"+"-fx-font-weight: bold;");
    	lebx2.setStyle("-fx-background-color: '1E90FF';"+"-fx-text-fill: white;"+"-fx-font-weight: bold;");
    	lebx3.setStyle("-fx-background-color: '1E90FF';"+"-fx-text-fill: white;"+"-fx-font-weight: bold;");
    	lebx4.setStyle("-fx-background-color: '1E90FF';"+"-fx-text-fill: white;"+"-fx-font-weight: bold;");
    	lebx5.setStyle("-fx-background-color: '1E90FF';"+"-fx-text-fill: white;"+"-fx-font-weight: bold;");
    	lebx6.setStyle("-fx-background-color: '1E90FF';"+"-fx-text-fill: white;"+"-fx-font-weight: bold;");
    	lebx7.setStyle("-fx-background-color: '1E90FF';"+"-fx-text-fill: white;"+"-fx-font-weight: bold;");
    	lebx8.setStyle("-fx-background-color: '1E90FF';"+"-fx-text-fill: white;"+"-fx-font-weight: bold;");
    	lebx9.setStyle("-fx-background-color: '1E90FF';"+"-fx-text-fill: white;"+"-fx-font-weight: bold;");
    	lebx10.setStyle("-fx-background-color: '1E90FF';"+"-fx-text-fill: white;"+"-fx-font-weight: bold;");
    	lebx1.setText("1");
    	lebx2.setText("2");
    	lebx3.setText("3");
    	lebx4.setText("4");
    	lebx5.setText("5");
    	lebx6.setText("6");
    	lebx7.setText("7");
    	lebx8.setText("8");
    	lebx9.setText("9");
    	lebx10.setText("10");
    	lebx1.setPrefHeight(30.0);		lebx1.setPrefWidth(67.0);//space 8.0
    	lebx2.setPrefHeight(30.0);		lebx2.setPrefWidth(67.0);
    	lebx3.setPrefHeight(30.0);		lebx3.setPrefWidth(67.0);
    	lebx4.setPrefHeight(30.0);		lebx4.setPrefWidth(67.0);
    	lebx5.setPrefHeight(30.0);		lebx5.setPrefWidth(67.0);
    	lebx6.setPrefHeight(30.0);		lebx6.setPrefWidth(67.0);
    	lebx7.setPrefHeight(30.0);		lebx7.setPrefWidth(67.0);
    	lebx8.setPrefHeight(30.0);		lebx8.setPrefWidth(67.0);
    	lebx9.setPrefHeight(30.0);		lebx9.setPrefWidth(67.0);
    	lebx10.setPrefHeight(30.0);		lebx10.setPrefWidth(67.0);
    	
    	qsep.setPrefWidth(width - 70.0 - 50.0);
    }
    
    Button confirm = new Button("Confirm");
    TranslateTransition confirmt = new TranslateTransition();
    Timeline ani = new Timeline(new KeyFrame(Duration.seconds(1) , e-> NoUse()));
    
    public void ConfirmPressed(Stage s)
    {
    	gameanimation.stop();
    	Flow(s);
    }
    public void EndPressed(Stage s)
    {
    	if(audio == true)
    	{
    		URL resource = getClass().getResource("sound effects/open.mp3");
    	    try
    	    {
    		   	Media media = new Media(resource.toString());
    		   	if(media.getError() == null || media.getOnError() == null)
    		   	{
    		   		mediaPlayer = new MediaPlayer(media);
    		   		mediaPlayer.setStartTime(Duration.seconds(1.61));
    		   		mediaPlayer.setVolume(0.5);
    		   		mediaPlayer.play();
    		   	}
    	    }
    	    catch(Exception e)
    	    {}
    	}
    	gameanimation.stop();
    	ani.stop();
    	Main_Menu(s);
    }
    public void OPTSelected(int optionS)
    {
    	UA = optionS;
    	confirm.setDisable(false);
    	confirmt.play();
    }
    public void ShowOpts()
    {
    	gamelabel.setVisible(true);
    	yoa.setVisible(false);
    	OPT1C.setVisible(true);
    	OPT2C.setVisible(true);
    	OPT3C.setVisible(true);
    	OPT4C.setVisible(true);
    	gameanimation.play();
    }
    Label yoa = new Label("Your options are");
    
    public void NoUse()
    {
    	if(yoac == 0)
    	{
    		yoa.setText("Your options are..");
    		yoac++;
    		
    	}
    	else if(yoac == 1)
    	{
    		yoa.setText("Your options are...");
    		yoac++;
    		
    	}
    	else if(yoac == 2)
    	{
    		yoa.setText("Your options are...");
    		yoac = 0;
    		
    	}
    }
    public void GamePage(Stage s)
    {
    	gamelabel.setVisible(false);
    	yoa.setText("Your options are.");
    	yoa.setVisible(true);
    	confirm.setDisable(true);
    	OPT1C.setSelected(false);
    	OPT2C.setSelected(false);
    	OPT3C.setSelected(false);
    	OPT4C.setSelected(false);
    	questionC.setText(QUESTION);
    	OPT1C.setText(OPTION1);
    	OPT2C.setText(OPTION2);
    	OPT3C.setText(OPTION3);
    	OPT4C.setText(OPTION4);
    	OPT1C.setOnAction(e-> OPTSelected(1));
    	OPT2C.setOnAction(e-> OPTSelected(2));
    	OPT3C.setOnAction(e-> OPTSelected(3));
    	OPT4C.setOnAction(e-> OPTSelected(4));
    	
    	confirm.setTranslateX(450.0);
    	confirm.setTranslateY(435.0 + 200.0);
    	confirmt.setNode(confirm);
    	confirmt.setToY(435.0);
    	confirmt.setDuration(Duration.seconds(0.4));
    	
    	Button end = new Button("End");
    	String tent = (ent.getSelectedToggle()).toString();
    	
    	confirm.setOnAction(e-> ConfirmPressed(s));
    	end.setOnAction(e-> EndPressed(s));
    	gameanimation = new Timeline(new KeyFrame(Duration.seconds(1), e-> gametimelabel()));
    	if(tent.endsWith("'Easy'") == true)
	    {
    		gametag = 30;
    	    gamelabel.setText("00:30");
    	    gameanimation.setCycleCount(30);
	    }
    	else if(tent.endsWith("'Normal'") == true)
    	{
    		gametag = 20;
    	    gamelabel.setText("00:20");
    	    gameanimation.setCycleCount(20);
    	}
    	else if(tent.endsWith("'Tough'") == true)
    	{
    		gametag = 10;
    	    gamelabel.setText("00:10");
    	    gameanimation.setCycleCount(10);
    	}
    	gameanimation.setOnFinished(e-> TimeOver(s));
    	OPT1C.setVisible(false);
    	OPT2C.setVisible(false);
    	OPT3C.setVisible(false);
    	OPT4C.setVisible(false);
    	ani.setCycleCount(3);
    	ani.setOnFinished(e-> ShowOpts());
    	confirm.setStyle("-fx-background-color: '#CC19F9';"+"-fx-text-fill: white;"+"-fx-font-family: 'Arial';"+"-fx-font-size: 16px;"+"-fx-font-weight: bold;");
    	confirm.setOnMouseExited(e-> confirm.setStyle("-fx-background-color: '#CC19F9';"+"-fx-text-fill: white;"+"-fx-font-family: 'Arial';"+"-fx-font-size: 16px;"+"-fx-font-weight: bold;"));
    	confirm.setOnMouseReleased(e-> confirm.setStyle("-fx-background-color: '#CC19F9';"+"-fx-text-fill: white;"+"-fx-font-family: 'Arial';"+"-fx-font-size: 16px;"+"-fx-font-weight: bold;"));
    	confirm.setOnMouseEntered(e-> confirm.setStyle("-fx-background-color: '#A912CF';"+"-fx-text-fill: white;"+"-fx-font-family: 'Arial';"+"-fx-font-size: 17px;"+"-fx-font-weight: bold;"));
    	confirm.setOnMousePressed(e-> confirm.setStyle("-fx-background-color: '#7F0C9C';"+"-fx-text-fill: white;"+"-fx-font-family: 'Arial';"+"-fx-font-size: 18px;"+"-fx-font-weight: bold;"));
    	end.setStyle("-fx-background-color: '#D2002A';"+"-fx-text-fill: white;"+"-fx-font-family: 'Arial';"+"-fx-font-size: 16px;"+"-fx-font-weight: bold;");
    	end.setOnMouseExited(e-> end.setStyle("-fx-background-color: '#D2002A';"+"-fx-text-fill: white;"+"-fx-font-family: 'Arial';"+"-fx-font-size: 16px;"+"-fx-font-weight: bold;"));
    	end.setOnMouseReleased(e-> end.setStyle("-fx-background-color: '#D2002A';"+"-fx-text-fill: white;"+"-fx-font-family: 'Arial';"+"-fx-font-size: 16px;"+"-fx-font-weight: bold;"));
    	end.setOnMouseEntered(e-> end.setStyle("-fx-background-color: '#A90425';"+"-fx-text-fill: white;"+"-fx-font-family: 'Arial';"+"-fx-font-size: 17px;"+"-fx-font-weight: bold;"));
    	end.setOnMousePressed(e-> end.setStyle("-fx-background-color: '#880620';"+"-fx-text-fill: white;"+"-fx-font-family: 'Arial';"+"-fx-font-size: 18px;"+"-fx-font-weight: bold;"));
    	confirm.setPrefWidth(width - 450.0 - 170.0);
    	confirm.setPrefHeight(height - 435.0 - 20.0);
    	AnchorPane root = new AnchorPane();
    	//leb1
        AnchorPane.setTopAnchor(leb1, 23.0);
        AnchorPane.setLeftAnchor(leb1, 35.0);
        AnchorPane.setRightAnchor(leb1, 35.0);
        AnchorPane.setBottomAnchor(leb1, height - 73.0);
        //leb2
        AnchorPane.setTopAnchor(leb2, 125.0);
        AnchorPane.setLeftAnchor(leb2, 35.0);
        AnchorPane.setRightAnchor(leb2, 35.0);
        AnchorPane.setBottomAnchor(leb2, 90.0);
        //qsep
        AnchorPane.setTopAnchor(qsep, 200.0);
        AnchorPane.setLeftAnchor(qsep, 60.0);
        //end
        AnchorPane.setTopAnchor(end, 435.0);
        AnchorPane.setLeftAnchor(end, 700.0);
        AnchorPane.setRightAnchor(end, 20.0);
        AnchorPane.setBottomAnchor(end, 20.0);
        //gamelabel
        AnchorPane.setTopAnchor(gamelabel, 90.0);
        AnchorPane.setRightAnchor(gamelabel, 35.0);
        //OPT1C
        AnchorPane.setTopAnchor(OPT1C, 250.0);
        AnchorPane.setLeftAnchor(OPT1C, 275.0);
        //OPT2C
        AnchorPane.setTopAnchor(OPT2C, 280.0);
        AnchorPane.setLeftAnchor(OPT2C, 275.0);
        //OPT3C
        AnchorPane.setTopAnchor(OPT3C, 310.0);
        AnchorPane.setLeftAnchor(OPT3C, 275.0);
        //OPT4C
        AnchorPane.setTopAnchor(OPT4C, 340.0);
        AnchorPane.setLeftAnchor(OPT4C, 275.0);
        //questionC
        AnchorPane.setTopAnchor(questionC, 165.0);
        AnchorPane.setLeftAnchor(questionC, 45.0);
        int space = 14;
        //lebx1
        AnchorPane.setTopAnchor(lebx1, 32.0);
        AnchorPane.setLeftAnchor(lebx1, 35.0 + (space * 1));
        //lebx2
        AnchorPane.setTopAnchor(lebx2, 32.0);
        AnchorPane.setLeftAnchor(lebx2, 35.0 + 76.0 + (space * 1));
        //lebx3
        AnchorPane.setTopAnchor(lebx3, 32.0);
        AnchorPane.setLeftAnchor(lebx3, 35.0 + 76.0 * 2 + (space * 1));
        //lebx4
        AnchorPane.setTopAnchor(lebx4, 32.0);
        AnchorPane.setLeftAnchor(lebx4, 35.0 + 76.0 * 3 +(space * 1));
        //lebx5
        AnchorPane.setTopAnchor(lebx5, 32.0);
        AnchorPane.setLeftAnchor(lebx5, 35.0 + 76.0 * 4 +(space * 1));
        //lebx6
        AnchorPane.setTopAnchor(lebx6, 32.0);
        AnchorPane.setLeftAnchor(lebx6, 35.0 + 76.0 * 5 +(space * 1));
        //lebx7
        AnchorPane.setTopAnchor(lebx7, 32.0);
        AnchorPane.setLeftAnchor(lebx7, 35.0 + 76.0 * 6 +(space * 1));
        //lebx8
        AnchorPane.setTopAnchor(lebx8, 32.0);
        AnchorPane.setLeftAnchor(lebx8, 35.0 + 76.0 * 7 +(space * 1));
        //lebx9
        AnchorPane.setTopAnchor(lebx9, 32.0);
        AnchorPane.setLeftAnchor(lebx9, 35.0 + 76.0 * 8 +(space * 1));
        //lebx10
        AnchorPane.setTopAnchor(lebx10, 32.0);
        AnchorPane.setLeftAnchor(lebx10, 35.0 + 76.0 * 9 +(space * 1));
        //yoa
        AnchorPane.setTopAnchor(yoa, 285.0);
        AnchorPane.setLeftAnchor(yoa, 340.0);
        root.setStyle(rootattr);
    	root.getChildren().addAll(copyright , leb1 , leb2 , qsep , confirm , end , gamelabel , OPT1C , OPT2C , OPT3C , OPT4C , questionC , yoa);
    	root.getChildren().addAll(lebx1 , lebx2 , lebx3 , lebx4 , lebx5 , lebx6 , lebx7 , lebx8 , lebx9 , lebx10);
        Scene ins = new Scene(root, width, height);
    	s.setScene(ins);
    	s.show();
    	ani.play();
    }
    public void Flow(Stage s)
    {
    	switch(COUNT)
    	{
    	case 0:
    		BluePrint();
    		GregorianCalendar gc = new GregorianCalendar();
    		//data for txt file down
    		gc.getTime();
        	if(gc.get(Calendar.AM_PM) == 0)		//AM
        	{
        		if(gc.get(Calendar.HOUR) == 0)
        		{
        			if(gc.get(Calendar.MINUTE) < 10)
                		time = "12" + ":0" + gc.get(Calendar.MINUTE) + " AM";
                	else
                		time = "12" + ":" + gc.get(Calendar.MINUTE) + " AM";
        		}
        		else if(gc.get(Calendar.MINUTE) < 10 && gc.get(Calendar.HOUR) != 0)
            		time = gc.get(Calendar.HOUR) + ":0" + gc.get(Calendar.MINUTE) + " AM";
            	else if(gc.get(Calendar.MINUTE) >= 10 && gc.get(Calendar.HOUR) != 0)
            		time = gc.get(Calendar.HOUR) + ":" + gc.get(Calendar.MINUTE) + " AM";
            	
            	date = "";
            	date = gc.get(Calendar.DATE) + " " + day[gc.get(Calendar.DAY_OF_WEEK) - 1] + " " + month[gc.get(Calendar.MONTH)];
        	}
            else	//PM
            {
            	if(gc.get(Calendar.HOUR) == 0)		//at 12 PM
            	{
            		if(gc.get(Calendar.MINUTE) < 10)
	            		time = "12" + ":0" + gc.get(Calendar.MINUTE) + " PM";
	            	else
	            		time = "12" + ":" + gc.get(Calendar.MINUTE) + " PM";
            	}
            	else
            	{
	            	if(gc.get(Calendar.MINUTE) < 10)
	            		time = gc.get(Calendar.HOUR) + ":0" + gc.get(Calendar.MINUTE) + " PM";
	            	else
	            		time = gc.get(Calendar.HOUR) + ":" + gc.get(Calendar.MINUTE) + " PM";
            	}
            	date = "";
            	date = gc.get(Calendar.DATE) + " " + day[gc.get(Calendar.DAY_OF_WEEK) - 1] + " " + month[gc.get(Calendar.MONTH)];
            }
            //data for txt file up
        	if(audio == true)
        	{
        		URL resource = getClass().getResource("sound effects/open.mp3");
        	    try
        	    {
        		   	Media media = new Media(resource.toString());
        		   	if(media.getError() == null || media.getOnError() == null)
        		   	{
        		   		mediaPlayer = new MediaPlayer(media);
        		   		mediaPlayer.setStartTime(Duration.seconds(1.61));
        		   		mediaPlayer.setVolume(0.5);
        		   		mediaPlayer.play();
        		   	}
        	    }
        	    catch(Exception e)
        	    {}
        	}
        	Transition(s , 'B');	//for first time before game starts (5 sec.)
    		lebx1.setStyle("-fx-background-color: blue;"+"-fx-text-fill: white;"+"-fx-font-weight: bold;");
    	break;
    	case 1:
    		if(UA == ANSWER)	//correct answer entered
        	{
        		SCORE += 10;
        		lebx1.setStyle("-fx-background-color: green;"+"-fx-text-fill: white;"+"-fx-font-weight: bold;");
        		if(audio == true)
        		{
        			try
        		    {
        			   	media = new Media(resourceC.toString());
        			   	if(media.getError() == null || media.getOnError() == null)
        			   	{
        			   		mediaPlayer = new MediaPlayer(media);
        			   		mediaPlayer.setStartTime(Duration.seconds(0.7));
        			   		mediaPlayer.setVolume(0.7);
        			   		mediaPlayer.play();
        			   	}
        		    }
        		    catch(Exception e)
        		    {}
        		}
        		Transition(s , 'R');
        	}
        	else	//wrong answer
        	{
        		lebx1.setStyle("-fx-background-color: red;"+"-fx-text-fill: white;"+"-fx-font-weight: bold;");
        		if(audio == true)
        		{
        			try
        		    {
        			   	media = new Media(resourceW.toString());
        			   	if(media.getError() == null || media.getOnError() == null)
        			   	{
        			   		mediaPlayer = new MediaPlayer(media);
        			   		mediaPlayer.setVolume(1.0);
        			   		mediaPlayer.setStartTime(Duration.seconds(0.5));
        			   		mediaPlayer.play();
        			   	}
        		    }
        		    catch(Exception e)
        		    {}
        		}
        		Transition(s , 'W');
        	}
    		lebx2.setStyle("-fx-background-color: blue;"+"-fx-text-fill: white;"+"-fx-font-weight: bold;");
        break;
    	case 2:
    		if(UA == ANSWER)	//correct answer entered
        	{
        		SCORE += 10;
        		lebx2.setStyle("-fx-background-color: green;"+"-fx-text-fill: white;"+"-fx-font-weight: bold;");
        		if(audio == true)
        		{
        			try
        		    {
        			   	media = new Media(resourceC.toString());
        			   	if(media.getError() == null || media.getOnError() == null)
        			   	{
        			   		mediaPlayer = new MediaPlayer(media);
        			   		mediaPlayer.setStartTime(Duration.seconds(0.7));
        			   		mediaPlayer.setVolume(0.7);
        			   		mediaPlayer.play();
        			   	}
        		    }
        		    catch(Exception e)
        		    {}
        		}
        		Transition(s , 'R');
        	}
        	else	//wrong answer
        	{
        		lebx2.setStyle("-fx-background-color: red;"+"-fx-text-fill: white;"+"-fx-font-weight: bold;");
        		if(audio == true)
        		{
        			try
        		    {
        			   	media = new Media(resourceW.toString());
        			   	if(media.getError() == null || media.getOnError() == null)
        			   	{
        			   		mediaPlayer = new MediaPlayer(media);
        			   		mediaPlayer.setVolume(1.0);
        			   		mediaPlayer.setStartTime(Duration.seconds(0.5));
        			   		mediaPlayer.play();
        			   	}
        		    }
        		    catch(Exception e)
        		    {}
        		}
        		Transition(s , 'W');
        	}
    		lebx3.setStyle("-fx-background-color: blue;"+"-fx-text-fill: white;"+"-fx-font-weight: bold;");
    	break;
    	case 3:
    		if(UA == ANSWER)	//correct answer entered
        	{
        		SCORE += 10;
        		lebx3.setStyle("-fx-background-color: green;"+"-fx-text-fill: white;"+"-fx-font-weight: bold;");
        		if(audio == true)
        		{
        			try
        		    {
        			   	media = new Media(resourceC.toString());
        			   	if(media.getError() == null || media.getOnError() == null)
        			   	{
        			   		mediaPlayer = new MediaPlayer(media);
        			   		mediaPlayer.setStartTime(Duration.seconds(0.7));
        			   		mediaPlayer.setVolume(0.7);
        			   		mediaPlayer.play();
        			   	}
        		    }
        		    catch(Exception e)
        		    {}
        		}
        		Transition(s , 'R');
        	}
        	else	//wrong answer
        	{
        		lebx3.setStyle("-fx-background-color: red;"+"-fx-text-fill: white;"+"-fx-font-weight: bold;");
        		if(audio == true)
        		{
        			try
        		    {
        			   	media = new Media(resourceW.toString());
        			   	if(media.getError() == null || media.getOnError() == null)
        			   	{
        			   		mediaPlayer = new MediaPlayer(media);
        			   		mediaPlayer.setVolume(1.0);
        			   		mediaPlayer.setStartTime(Duration.seconds(0.5));
        			   		mediaPlayer.play();
        			   	}
        		    }
        		    catch(Exception e)
        		    {}
        		}
        		Transition(s , 'W');
        	}
    		lebx4.setStyle("-fx-background-color: blue;"+"-fx-text-fill: white;"+"-fx-font-weight: bold;");
        break;
    	case 4:
    		if(UA == ANSWER)	//correct answer entered
        	{
        		SCORE += 10;
        		lebx4.setStyle("-fx-background-color: green;"+"-fx-text-fill: white;"+"-fx-font-weight: bold;");
        		if(audio == true)
        		{
        			try
        		    {
        			   	media = new Media(resourceC.toString());
        			   	if(media.getError() == null || media.getOnError() == null)
        			   	{
        			   		mediaPlayer = new MediaPlayer(media);
        			   		mediaPlayer.setStartTime(Duration.seconds(0.7));
        			   		mediaPlayer.setVolume(0.7);
        			   		mediaPlayer.play();
        			   	}
        		    }
        		    catch(Exception e)
        		    {}
        		}
        		Transition(s , 'R');
        	}
        	else	//wrong answer
        	{
        		lebx4.setStyle("-fx-background-color: red;"+"-fx-text-fill: white;"+"-fx-font-weight: bold;");
        		if(audio == true)
        		{
        			try
        		    {
        			   	media = new Media(resourceW.toString());
        			   	if(media.getError() == null || media.getOnError() == null)
        			   	{
        			   		mediaPlayer = new MediaPlayer(media);
        			   		mediaPlayer.setVolume(1.0);
        			   		mediaPlayer.setStartTime(Duration.seconds(0.5));
        			   		mediaPlayer.play();
        			   	}
        		    }
        		    catch(Exception e)
        		    {}
        		}
        		Transition(s , 'W');
        	}
    		lebx5.setStyle("-fx-background-color: blue;"+"-fx-text-fill: white;"+"-fx-font-weight: bold;");
        break;
    	case 5:
    		if(UA == ANSWER)	//correct answer entered
        	{
        		SCORE += 10;
        		lebx5.setStyle("-fx-background-color: green;"+"-fx-text-fill: white;"+"-fx-font-weight: bold;");
        		if(audio == true)
        		{
        			try
        		    {
        			   	media = new Media(resourceC.toString());
        			   	if(media.getError() == null || media.getOnError() == null)
        			   	{
        			   		mediaPlayer = new MediaPlayer(media);
        			   		mediaPlayer.setStartTime(Duration.seconds(0.7));
        			   		mediaPlayer.setVolume(0.7);
        			   		mediaPlayer.play();
        			   	}
        		    }
        		    catch(Exception e)
        		    {}
        		}
        		Transition(s , 'R');
        	}
        	else	//wrong answer
        	{
        		lebx5.setStyle("-fx-background-color: red;"+"-fx-text-fill: white;"+"-fx-font-weight: bold;");
        		if(audio == true)
        		{
        			try
        		    {
        			   	media = new Media(resourceW.toString());
        			   	if(media.getError() == null || media.getOnError() == null)
        			   	{
        			   		mediaPlayer = new MediaPlayer(media);
        			   		mediaPlayer.setVolume(1.0);
        			   		mediaPlayer.setStartTime(Duration.seconds(0.5));
        			   		mediaPlayer.play();
        			   	}
        		    }
        		    catch(Exception e)
        		    {}
        		}
        		Transition(s , 'W');
        	}
    		lebx6.setStyle("-fx-background-color: blue;"+"-fx-text-fill: white;"+"-fx-font-weight: bold;");
        break;
    	case 6:
    		if(UA == ANSWER)	//correct answer entered
        	{
        		SCORE += 10;
        		lebx6.setStyle("-fx-background-color: green;"+"-fx-text-fill: white;"+"-fx-font-weight: bold;");
        		if(audio == true)
        		{
        			try
        		    {
        			   	media = new Media(resourceC.toString());
        			   	if(media.getError() == null || media.getOnError() == null)
        			   	{
        			   		mediaPlayer = new MediaPlayer(media);
        			   		mediaPlayer.setStartTime(Duration.seconds(0.7));
        			   		mediaPlayer.setVolume(0.7);
        			   		mediaPlayer.play();
        			   	}
        		    }
        		    catch(Exception e)
        		    {}
        		}
        		Transition(s , 'R');
        	}
        	else	//wrong answer
        	{
        		lebx6.setStyle("-fx-background-color: red;"+"-fx-text-fill: white;"+"-fx-font-weight: bold;");
        		if(audio == true)
        		{
        			try
        		    {
        			   	media = new Media(resourceW.toString());
        			   	if(media.getError() == null || media.getOnError() == null)
        			   	{
        			   		mediaPlayer = new MediaPlayer(media);
        			   		mediaPlayer.setVolume(1.0);
        			   		mediaPlayer.setStartTime(Duration.seconds(0.5));
        			   		mediaPlayer.play();
        			   	}
        		    }
        		    catch(Exception e)
        		    {}
        		}
        		Transition(s , 'W');
        	}
    		lebx7.setStyle("-fx-background-color: blue;"+"-fx-text-fill: white;"+"-fx-font-weight: bold;");
        break;
    	case 7:
    		if(UA == ANSWER)	//correct answer entered
        	{
        		SCORE += 10;
        		lebx7.setStyle("-fx-background-color: green;"+"-fx-text-fill: white;"+"-fx-font-weight: bold;");
        		if(audio == true)
        		{
        			try
        		    {
        			   	media = new Media(resourceC.toString());
        			   	if(media.getError() == null || media.getOnError() == null)
        			   	{
        			   		mediaPlayer = new MediaPlayer(media);
        			   		mediaPlayer.setStartTime(Duration.seconds(0.7));
        			   		mediaPlayer.setVolume(0.7);
        			   		mediaPlayer.play();
        			   	}
        		    }
        		    catch(Exception e)
        		    {}
        		}
        		Transition(s , 'R');
        	}
        	else	//wrong answer
        	{
        		lebx7.setStyle("-fx-background-color: red;"+"-fx-text-fill: white;"+"-fx-font-weight: bold;");
        		if(audio == true)
        		{
        			try
        		    {
        			   	media = new Media(resourceW.toString());
        			   	if(media.getError() == null || media.getOnError() == null)
        			   	{
        			   		mediaPlayer = new MediaPlayer(media);
        			   		mediaPlayer.setVolume(1.0);
        			   		mediaPlayer.setStartTime(Duration.seconds(0.5));
        			   		mediaPlayer.play();
        			   	}
        		    }
        		    catch(Exception e)
        		    {}
        		}
        		Transition(s , 'W');
        	}
    		lebx8.setStyle("-fx-background-color: blue;"+"-fx-text-fill: white;"+"-fx-font-weight: bold;");
        break;
    	case 8:
    		if(UA == ANSWER)	//correct answer entered
        	{
        		SCORE += 10;
        		lebx8.setStyle("-fx-background-color: green;"+"-fx-text-fill: white;"+"-fx-font-weight: bold;");
        		if(audio == true)
        		{
        			try
        		    {
        			   	media = new Media(resourceC.toString());
        			   	if(media.getError() == null || media.getOnError() == null)
        			   	{
        			   		mediaPlayer = new MediaPlayer(media);
        			   		mediaPlayer.setStartTime(Duration.seconds(0.7));
        			   		mediaPlayer.setVolume(0.7);
        			   		mediaPlayer.play();
        			   	}
        		    }
        		    catch(Exception e)
        		    {}
        		}
        		Transition(s , 'R');
        	}
        	else	//wrong answer
        	{
        		lebx8.setStyle("-fx-background-color: red;"+"-fx-text-fill: white;"+"-fx-font-weight: bold;");
        		if(audio == true)
        		{
        			try
        		    {
        			   	media = new Media(resourceW.toString());
        			   	if(media.getError() == null || media.getOnError() == null)
        			   	{
        			   		mediaPlayer = new MediaPlayer(media);
        			   		mediaPlayer.setVolume(1.0);
        			   		mediaPlayer.setStartTime(Duration.seconds(0.5));
        			   		mediaPlayer.play();
        			   	}
        		    }
        		    catch(Exception e)
        		    {}
        		}
        		Transition(s , 'W');
        	}
    		lebx9.setStyle("-fx-background-color: blue;"+"-fx-text-fill: white;"+"-fx-font-weight: bold;");
        break;
    	case 9:
    		if(UA == ANSWER)	//correct answer entered
        	{
        		SCORE += 10;
        		lebx9.setStyle("-fx-background-color: green;"+"-fx-text-fill: white;"+"-fx-font-weight: bold;");
        		if(audio == true)
        		{
        			try
        		    {
        			   	media = new Media(resourceC.toString());
        			   	if(media.getError() == null || media.getOnError() == null)
        			   	{
        			   		mediaPlayer = new MediaPlayer(media);
        			   		mediaPlayer.setStartTime(Duration.seconds(0.7));
        			   		mediaPlayer.setVolume(0.7);
        			   		mediaPlayer.play();
        			   	}
        		    }
        		    catch(Exception e)
        		    {}
        		}
        		Transition(s , 'R');
        	}
        	else	//wrong answer
        	{
        		lebx9.setStyle("-fx-background-color: red;"+"-fx-text-fill: white;"+"-fx-font-weight: bold;");
        		if(audio == true)
        		{
        			try
        		    {
        			   	media = new Media(resourceW.toString());
        			   	if(media.getError() == null || media.getOnError() == null)
        			   	{
        			   		mediaPlayer = new MediaPlayer(media);
        			   		mediaPlayer.setVolume(1.0);
        			   		mediaPlayer.setStartTime(Duration.seconds(0.5));
        			   		mediaPlayer.play();
        			   	}
        		    }
        		    catch(Exception e)
        		    {}
        		}
        		Transition(s , 'W');
        	}
    		lebx10.setStyle("-fx-background-color: blue;"+"-fx-text-fill: white;"+"-fx-font-weight: bold;");
        break;
    	case 10:
    		if(UA == ANSWER)	//Q10 answer is correct
        		SCORE += 10;
        	if(SCORE == 100)	//All answers are correct
        		GameWon(s);
        	else	//Partial correct partial wrong answers
	        	GameOver(s);
        	COUNT = 0;
    	break;
    	default:
    		COUNT = 0;
    	}
    }
    int Randomizer(int max)
    {
    	int R, x;
    	R = (int)(Math.random()*100);
    	if(max == 4)
    	{
    		if(R <= 25)
    			x=0;
    		else if(R>25 && R<=50)
    			x=1;
    		else if(R>50 && R<=75)
    			x=2;
    		else //R>75
    			x=3;
    	}
    	else
    	{
    		if(R <= 50)
    			x = 0;
    		else
    			x = 1;
    	}
    	return(x);
    }
    
    public void CAT_M()//Question Bank for Misc. type
    {
    	int r;
    	//question 1
    	r=Randomizer(4);
    	if(r==0)
    		Q1="Cape Aghulas is the southernmost point in?South America;Europe;Africa;South Africa;A=1*";
    	else if(r==1)
    		Q1="In BRICS, 'I' stands for?Indonesia;Iraq;Istanbul;India;A=4*";
    	else if(r==2)
    		Q1="Who created Mickey Mouse?Charles Roy;Walt Disney;Shakespeare;Bill Gates;A=2*";
    	else
    		Q1="What is the speed of sound in air?330 m/s;450m/s;320m/s;540m/s;A=1*";
    	//question 2
    	r=Randomizer(4);
    	if(r==0)
    		Q2="What comes after Kilo, Mega, Giga?Tera;Peta;Beta;Exa;A=1*";
    	else if(r==1)
    		Q2="Which operating system was launched by Microsoft in 2015?Windows 9;Windows 10;Windows Vista;Windows 8;A=2*";
    	else if(r==2)
    		Q2="Who was the first person to step on the Moon?Kalpana Chawla;Santa Claus;Neil Armstrong;None of these;A=3*";
    	else
    		Q2="In which year the Second World War ended?1845;1950;1930;1945;A=4*";
    	//question 3
    	r=Randomizer(4);
    	if(r==0)
    		Q3="Which UN institution governs matters of education?FAO;UNESCO;WHO;UNICEF;A=2*";
    	else if(r==1)
    		Q3="Which international organisation is dedicated to wildlife conservation?FAO;UNICEF;PETA;WWF;A=4*";
    	else if(r==2)
    		Q3="What does 'www' stands for?World wide web;World world world;widest world web;whale wide world;A=1*";
    	else
    		Q3="Who created the Morse code?Samuel FB Morse;Alexander Graham Bell;John Logie Baird;Marc Andreessen;A=1*";
    	//question 4
    	r=Randomizer(4);
    	if(r==0)
    		Q4="Big Blue is a nickname associated with which company?Dominoes;Apple;IBM;Intel;A=3*";
    	else if(r==1)
    		Q4="Which of these is a protocol for peer-to-peer file sharing?FireFox;Bluetooth;Univac;BitTorrent;A=4*";
    	else if(r==2)
    		Q4="Who invented the world's first television?Marc Andreessen;John Logie Baird;Samuel FB Morse;None of these;A=2*";
    	else
    		Q4="Which famous character did Sir Arthur Conan Doyle created?Superman;Batman;Tintin;Sherlock Holmes;A=4*";
    	//question 5
    	r=Randomizer(4);
    	if(r==0)
    		Q5="Who played the character of Harry Potter in the film series?Daniel Radcliffe;Darsheel Safary;Harsh Mayar;Macaulay Culkin;A=1*";
    	else if(r==1)
    		Q5="Who  plays the character of Sheldon Cooper in the famous TV series The Big Theory?Howard Hilary;Andy Jokohoma;Jim Parson;Kunal Nayyar;A=3*";
    	else if(r==2)
    		Q5="Who is the Director of Avatar, Titanic, Aliens?Steven Spielberg;John Cajerov;James Cameron;James Gosling;A=3*";
    	else
    		Q5="Who is the Director of PK, 3 Idiots, Lage Raho Munna Bhai?Karan Johar;Zoya Akhtar;Rajkumar Hirani;Imitiaz Ali;A=3*";
    	//question 6
    	r=Randomizer(4);
    	if(r==0)
    		Q6="Haider is based on which Shakespearean play?Othello;Hamlet;Macbeth;King Lear;A=2*";
    	else if(r==1)
    		Q6="Preity Zinta made her debut in which film?Soldier;Dil Se;Kya Kehna;Sangharsh;A=2*";
    	else if(r==2)
    		Q6="In 1498, who reached the coast of Calicut in India?Columbus;Magellan;Armstrong;Vasco da Gama;A=4*";
    	else
    		Q6="In which game is the term 'free kick' used?Cycling;Football;Boxing;Cricket;A=2*";
    	//question 7
    	r=Randomizer(4);
    	if(r==0)
    		Q7="What is the name of the Bat-Hound introduced into Batman comics in the 1950's?Jack;Ace;Queen;King;A=2*";
    	else if(r==1)
    		Q7="By what name is the Marvel mutant Roberto Da Costa better known?Sunspot;Prodigy;Rictor;Sauron;A=1*";
    	else if(r==2)
    		Q7="Who was the first European to reach America in 1492?Columbus;Magellan;Vasco da Gama;Bartolomeu Dias;A=1*";
    	else
    		Q7="In which country did the game of polo originate?Persia;India;America;Korea;A=1*";
    	//question 8
    	r=Randomizer(4);
    	if(r==0)
    		Q8="Who is the CEO of Coca-Cola?Andre Cox;James Quincey;Sergio Marchionne;Satya Nadella;A=2*";
    	else if(r==1)
    		Q8="Who is the CEO of Dell?Michael Dell;Mark Thompson;Gray C. Kelly;Andre Cox;A=1*";
    	else if(r==2)
    		Q8="Which is the popular dance of Assam,India?Tap dance;Tango;Kathakali;Bihu;A=4*";
    	else
    		Q8="Which lively dance is a popular ballroom dance from Argentina?Flamenco;Hula;Tango;Hip-hop;A=3*";
    	//question 9
    	r=Randomizer(4);
    	if(r==0)
    		Q9="FYI stands for?For You Idiot;For Your Information;Forming Your Idea;For Your Idea;A=2*";
    	else if(r==1)
    		Q9="SUV stands for?Stylish Usage Vehicle;Sports Utility Vehicle;Sports Usage Vehicle;Sizeable Utility Vehicle;A=2*";
    	else if(r==2)
    		Q9="How many bones are there in an adult human body?198;314;206;306;A=3*";
    	else
    		Q9="Which part of our body has the maximum number of bones?Hand;Ear;Thigh;Skull;A=1*";
    	//question 10
    	r=Randomizer(4);
    	if(r==0)
    		Q10="Which is a supercomputer for the average person?Parallella;PARAM;Raspberry Pi;R2D2;A=1*";
    	else if(r==1)
    		Q10="What is the full form of IT?Induction Treatment;Industrial Technology;Industrial Tax;Information Technology;A=4*";
    	else if(r==2)
    		Q10="Where was the 2012 Olympic Games held?Madagascar;Germany;India;London;A=4*";
    	else
    		Q10="Who invented the steam engine in the 18th century?Wright Brothers;James Watt;Karl Benz;None of these;A=2*";
    }
    
    public void CAT_W()//Question Bank for Well-Known Brands type
    {
    	int r;
    	//question 1
    	r=Randomizer(2);
    	if(r==0)
    		Q1="Think differnet?Adidas;Apple;Levi's;IBM;A=2*";
    	else
    		Q1="Das Auto?Audi;BMW;Maruti;Volkswagen;A=4*";
    	//question 2
    	r=Randomizer(2);
    	if(r==0)
    		Q2="Just do it?Nike;Puma;Adidas;Reebok;A=1*";
    	else
    		Q2="Impossible is nothing?Reebok;Nike;Puma;Adidas;A=4*";
    	//question 3
    	r=Randomizer(2);
    	if(r==0)
    		Q3="Quality never goes out of style?Zodiac;Peter England;Levi's;Nike;A=3*";
    	else
    		Q3="Smarter planet?IBM;HCL;Lenevo;Apple;A=1*";
    	//question 4
    	r=Randomizer(2);
    	if(r==0)
    		Q4="Make believe?Samsung;Akai;Lenovo;Sony;A=4*";
    	else
    		Q4="The happiest place on earth?Las Vegas;Disneyland;Wonderla;Cartoon Network;A=2*";
    	//question 5
    	r=Randomizer(2);
    	if(r==0)
    		Q5="The ultimate driving machine?Volkswagen;BMW;Audi;Ferrari;A=2*";
    	else
    		Q5="Because you're worth it?Himalaya;VLCC;L'Oreal;Pizza Hut;A=3*";
    	//question 6
    	r=Randomizer(2);
    	if(r==0)
    		Q6="I'm lovin' it?Dominoes;McDonalds;Pizza Hut;Subway;A=2*";
    	else
    		Q6="Finger lickin' good?KFC;Pizza Hut;Subway;McDonalds;A=1*";
    	//question 7
    	r=Randomizer(2);
    	if(r==0)
    		Q7="Maybe she's born with it, maybe it's _____________?L'Oreal;John Lewis;Maybelline;Max Factor;A=3*";
    	else
    		Q7="The World's Local Bank?MSBC;HSBK;MSBK;HSBC;A=4*";
    	//question 8
    	r=Randomizer(2);
    	if(r==0)
    		Q8="For everything else, there's _________________?Visa;PayPal;Money Tree;MasterCard;A=4*";
    	else
    		Q8="Grace, Space, Pace?Audi;Jaguar;BMW;Ferrari;A=2*";
    	//question 9
    	r=Randomizer(2);
    	if(r==0)
    		Q9="Ideas for life?Panasonic;Google;Samsung;Phillips;A=1*";
    	else
    		Q9="Every little helps?John Lewis;Tesco;Red Bull;Carlsberg;A=2*";
    	//question 10
    	r=Randomizer(2);
    	if(r==0)
    		Q10="It gives you wiiiiings!?Kit Kat;Tuborg;Pepsi;Red Bull;A=4*";
    	else
    		Q10="Eat fresh?KFC;Pizza Hut;Dominoes;Subway;A=4*";
    }
    
    public void CAT_T()//Question Bank for Technology type
    {
    	int r;
    	//question 1
    	r=Randomizer(2);
    	if(r==0)
    		Q1="What is part of  database that holds only one type of information?Report;File;Record;Field;A=4*";
    	else
    		Q1="'OS' computer abbreviation usually means?Optical Sensor;Open Software;Operating System;Order of Significance;A=3*";
    	//question 2
    	r=Randomizer(2);
    	if(r==0)
    		Q2="In which decade with the first transatlantic radio broadcast occur?1850s;1900s;1870s;1860s;A=2*";
    	else
    		Q2="'.MOV' extension refers usually to what kind of life?Image File;Animation/moving file;Audio file;MS Office Document;A=2*";
    	//question 3
    	r=Randomizer(2);
    	if(r==0)
    		Q3="In which decade was the SPICE simulator introduced?1950s;1960s;1970s;1980s;A=3*";
    	else
    		Q3="Which is a type of Electrically-Erasable Programmable Read-Only Memory?Flash;Flange;Fury;FRAM;A=1*";
    	//question 4
    	r=Randomizer(2);
    	if(r==0)
    		Q4="The purpose of choke in tubelight is?To decrease the current;To increase the current;To decrease the voltage momentarily;To increase the voltage momentarily;A=4*";
    	else
    		Q4="'.MPG' extension refers usually to what kind of file?WordPerfect Document file;MS Office document;Animation/movie file;Image file;A=3*";
    	//question 5
    	r=Randomizer(2);
    	if(r==0)
    		Q5="Who developed Yahoo?Dennis Ritchie & Ken Thompson;David Filo & Jerry Yang;Vint Cerf & Robert Kahn;Steve Case & Jeff Bezos;A=2*";
    	else
    		Q5="Made from a variety of materials, such as carbon, which inhibits the flow of current...?Choke;Inductor;Resistor;Capacitor;A=3*";
    	//question 6
    	r=Randomizer(2);
    	if(r==0)
    		Q6="What does VVVF stand for?Variant Voltage Vile Frequency;Variable Velocity Variable Fun;Very Very Vicious Frequency;Variable Voltage Variable Frequency;A=4*";
    	else
    		Q6="What frequency range is the High Frequency band?100 kHz;1 GHz;30 to 300 MHz;3 to 30 MHz;A=4*";
    	//question 7
    	r=Randomizer(2);
    	if(r==0)
    		Q7="What is the relationship between resistivity r and conductivity s?R = s2;R = s;R > s;R = 1/s;A=4*";
    	else
    		Q7="Which motor is NOT suitable for use as a DC machine?Permanent magnet motor;Series motor;Squirrel cage motor;Synchronous motor;A=3*";
    	//question 8
    	r=Randomizer(2);
    	if(r==0)
    		Q8="A given signal's second harmonic is twice the given signal's _________ frequency?Fourier;Foundation;Fundamental;Field;A=3*";
    	else
    		Q8="'.TMP' extension refers usually to what kind of file?Compressed Archieve file;Image file;Temporary file;Audio file;A=3*";
    	//question 9
    	r=Randomizer(2);
    	if(r==0)
    		Q9="In the UK, what type of installation requires a fireman's switch?Neon Lighting;High Pressure Sodium Lighting;Water Features;Hotel Rooms;A=1*";
    	else
    		Q9="'.MP3' is what kind of file?Audio;Video;Image;Text;A=1*";
    	//question 10
    	r=Randomizer(2);
    	if(r==0)
    		Q10="How many bytes make 1 KB?124;1024;1240;1022;A=2*";
    	else
    		Q10="How many bytes make 1 GB?1024;Square of 1024;Cube of 1024;Four times power of 1024;A=3*";
    }
    
    public void CAT_C()//Question Bank for CEOs type
    {
    	int r;
    	//question 1
    	r=Randomizer(2);
    	if(r==0)
    		Q1="Who is the CEO of Bharti Enterprises as of 2018?Meg Whitman;Carlos Ghosn;Sunil Bharti Mittal;Sergio Marchionne;A=3*";
    	else
    		Q1="Who is the CEO of Coca-Cola as of 2018?Andre Cox;James Quincey;Sergio Marchionne;Satya Nadella;A=2*";
    	//question 2
    	r=Randomizer(2);
    	if(r==0)
    		Q2="Who is the CEO of Dell as of 2018?Michael Dell;Mark Thompson;Gray C. Kelly;Andre Cox;A=1*";
    	else
    		Q2="Who is the CEO of eBay as of 2018?Mark Thompson;Brian Cornell;Vince McMahon;Devin Wenig;A=4*";
    	//question 3
    	r=Randomizer(2);
    	if(r==0)
    		Q3="Who is the CEO of Airbus as of 2018?Robert Bakish;Bill Hilf;Akio Toyoda;Tom Enders;A=4*";
    	else
    		Q3="Who is the CEO of FedEx as of 2018?John Mackey;Sergio Marchionne;Vijay K. Thadani;Meg Whitman;A=2*";
    	//question 4
    	r=Randomizer(2);
    	if(r==0)
    		Q4="Who is the CEO of Google as of 2018?Tatsumi Kimishima;Rajeev Suri;Sundar Pichai;Greg Creed;A=3*";
    	else
    		Q4="Who is the CEO of HCL Technologies as of 2018?Rajeev Suri;Sergio Marchionne;C. Vijayakumar;Bob Iger;A=3*";
    	//question 5
    	r=Randomizer(2);
    	if(r==0)
    		Q5="Who is the CEO of Hewlett Packard Enterprise as of 2018?Meg Whitman;Michael Dell;Mark Thompson;Virginia M. Rometty;A=1*";
    	else
    		Q5="Who is the CEO of IBM as of 2018?Tom Enders;Mark Thompson;Virginia M. Rometty;Satya Nadella;A=3*";
    	//question 6
    	r=Randomizer(2);
    	if(r==0)
    		Q6="Who is the CEO of Infosys as of 2018?Salil Parekh;Tatsumi Kimishima;Mark Thompson;Satya Nadella;A=1*";
    	else
    		Q6="Who is the CEO of WWE as of 2018?Vijay K. Thadani;Sergio Marchionne;Vince McMahon;Satya Nadella;A=3*";
    	//question 7
    	r=Randomizer(2);
    	if(r==0)
    		Q7="Who is the CEO of The Walt Disney Company as of 2018?Bob Iger;Meg Whitman;Vijay K. Thadani;Sergio Marchionne;A=1*";
    	else
    		Q7="Who is the CEO of Sony as of 2018?Michael Dell;Mark Thompson;Sergio Marchionne;Kazuo Hirai;A=4*";
    	//question 8
    	r=Randomizer(2);
    	if(r==0)
    		Q8="Who is the CEO of PepsiCo as of 2018?Tom Enders;Indra Nooyi;Bob Iger;Sergio Marchionne;A=2*";
    	else
    		Q8="Who is the CEO of Nintendo as of 2018?Bob Iger;Satya Nadella;Tatsumi Kimishima;James Quincey;A=3*";
    	//question 9
    	r=Randomizer(2);
    	if(r==0)
    		Q9="Who is the CEO of Nokia as of 2018?Rajeev Suri;Tatsumi Kimishima;Kazuo Hirai;Virginia M. Rometty;A=1*";
    	else
    		Q9="Who is the CEO of Nike as of 2018?Vince McMahon;Rajeev Suri;Vijay K. Thadani;Tatsumi Kimishima;A=3*";
    	//question 10
    	r=Randomizer(2);
    	if(r==0)
    		Q10="Who is the CEO of New York Times Company as of 2018?Mark Thompson;Bob Iger;Vijay K. Thadani;C. Vijayakumar;A=1*";
    	else
    		Q10="Who is the CEO of Microsoft as of 2018?Michael Dell;Tom Enders;Meg Whitman;Satya Nadella;A=4*";
    }
    
    public void CAT_S()//Question Bank for Science type
    {
    	int r;
    	//question 1
    	r=Randomizer(2);
    	if(r==0)
    		Q1="Fishes are good sources of ____________?Lipids;Carbohydrates;Fats;Protein;A=4*";
    	else
    		Q1="The process of taking food into the body is called what?Absorption;Assimilation;Digestion;Ingestion;A=4*";
    	//question 2
    	r=Randomizer(2);
    	if(r==0)
    		Q2="The mode of nutrition in amoeba is __________?Holophytic;Holozoic;Parasitic;Saprophytic;A=4*";
    	else
    		Q2="Amoeba sent out undigested food from the body through ____________?Food Foot;Contractile Vacuole;False Foot;Body Surface;A=4*";
    	//question 3
    	r=Randomizer(2);
    	if(r==0)
    		Q3="The secretion of salivary gland is called _____________?Bile;Saliva;Mucus;Starch;A=2*";
    	else
    		Q3="An enzyme in the saliva is _______________?Pectinase;Mucin;Amylase;Pepsin;A=3*";
    	//question 4
    	r=Randomizer(2);
    	if(r==0)
    		Q4="Mycotrophic nutrition is observed in _______________?Algae;Euglena;Paramecium;Hydra;A=2*";
    	else
    		Q4="Amoeba belongs to the class of _____________?Sarcodina;Ciliata;Insecta;Monera;A=1*";
    	//question 5
    	r=Randomizer(2);
    	if(r==0)
    		Q5="All the unicellular eukaryotes are classified under _______________?Monera;Protista;Animalia;Plantae;A=2*";
    	else
    		Q5="The scientist belongs to Dutch was ______________?Carolinus Linnaeus;Charles Darwin;Aristotle;Anton Van Leeuwenhoek;A=4*";
    	//question 6
    	r=Randomizer(2);
    	if(r==0)
    		Q6="The father of bacteriology is ________________?Carolinus Linnaeus;Charles Darwin;Aristotle;Anton Van Leeuwenhoek;A=4*";
    	else
    		Q6="Bacteria was discovered in which year?1975;1675;1673;1670;A=2*";
    	//question 7
    	r=Randomizer(2);
    	if(r==0)
    		Q7="Unicellular algae grouped under the kingdom of _____________?Protista;Fungi;Plantae;Animalia;A=1*";
    	else
    		Q7="Multicellular algae grouped under _____________?Protista;Fungi;Plantae;Animalia;A=3*";
    	//question 8
    	r=Randomizer(2);
    	if(r==0)
    		Q8="The 'Queen of drugs' is ____________?Pencilin;Bromin;Insulin;Analin;A=1*";
    	else
    		Q8="Smoking can cause __________?Fever;Tooth Ache;Injury;Lung Cancer;A=4*";
    	//question 9
    	r=Randomizer(2);
    	if(r==0)
    		Q9="The father of medicine is ____________?Hippocrates;R. H. Whittakar;Carolus Linnaeus;Anton Van Leeuwenhoek;A=1*";
    	else
    		Q9="_________ helps to identify the living organisms easily?Nomenclature;Identification;Classification;Ordering;A=3*";
    	//question 10
    	r=Randomizer(2);
    	if(r==0)
    		Q10="Five Kingdom of classification was proposed by _____________?Carolus Linnaeus;John Roy;R. H. Whittaker;Anton Van Leeuwenhoek;A=3*";
    	else
    		Q10="Cynobacteria refers to _____________?Red Algae;Blue Green Algae;Brown Algae;Green Algae;A=2*";
    }
    
    public void CAT_CO()//Question Bank for Comics type
    {
    	int r;
    	//question 1
    	r=Randomizer(2);
    	if(r==0)
    		Q1="Which of the Outsider was an adventurer named Rex Mason?Geo-Force;Technocrat;Metamorpho;Faust;A=3*";
    	else
    		Q1="Which of The Endless is the oldest?Destruction;Dream;Death;Destiny;A=4*";
    	//question 2
    	r=Randomizer(2);
    	if(r==0)
    		Q2="Which Marvel superhero is known as the man without fear?Daredevil;Mr. Fantastic;Vision;Namor;A=1*";
    	else
    		Q2="Who is the creator and original artist on the series Spawn?Erik Larsen;Todd McFarlane;John Byrne;John Romita, Jr.;A=2*";
    	//question 3
    	r=Randomizer(2);
    	if(r==0)
    		Q3="Which of the Avengers began his career as a villain named Clint Barton?Starfox;Quicksilver;Hawkeye;Moon Knight;A=3*";
    	else
    		Q3="Which Marvel superhero is sometimes known as the 'Shield Slinger'?Hawkeye;Black Widow;Captain America;Hulk;A=3*";
    	//question 4
    	r=Randomizer(2);
    	if(r==0)
    		Q4="In which comic series did Elektra made her first appearance?Daredevil;Fantastic Four;Eternals;Journey Into Mystery;A=1*";
    	else
    		Q4="Which of the following superheroes has never been a member of the X-Men?Bishop;Cannonball;Marrow;Human Torch;A=4*";
    	//question 5
    	r=Randomizer(2);
    	if(r==0)
    		Q5="In which comic book series did the Silver Surfer make his first appearance?Avengers;Strange Tales;Marvel Team-Up;Fantastic Four;A=4*";
    	else
    		Q5="Which of Captain Carrot's Zoo Crew is a cat from Mew Orleans named Felina Furr?Pig Iron;Alley-Kat-Abra;Little Cheese;Feline Faust;A=2*";
    	//question 6
    	r=Randomizer(2);
    	if(r==0)
    		Q6="What is the name of the Bat-Hound introduced into Batman comics in the 1950's?Jack;Ace;Queen;King;A=2*";
    	else
    		Q6="By what name is the Marvel mutant Roberto Da Costa better known?Sunspot;Prodigy;Rictor;Sauron;A=1*";
    	//question 7
    	r=Randomizer(2);
    	if(r==0)
    		Q7="Which member of the Justice League wears the Helm of Nabu?Wonder Woman;Red Tomato;Doctor Fate;Aquaman;A=3*";
    	else
    		Q7="Which of these has never been a comic book series published by Marvel?Beauty And The Beast;Barbie;Bullwinkle And Rockie;Band Of Brothers;A=4*";
    	//question 8
    	r=Randomizer(2);
    	if(r==0)
    		Q8="In which comic book series did Gambit make his first appearance?New Mutants;Uncanny X-Men;X-Force;Longshot;A=2*";
    	else
    		Q8="What name did Walter Kovacs use during his time with the Watchmen?Rorschach;Question;Punisher;Wolverine;A=1*";
    	//question 9
    	r=Randomizer(2);
    	if(r==0)
    		Q9="Which of Batman's foes was born Oswald Cobblepot?Penguin;Woodpecker;Eagle;Vulture;A=1*";
    	else
    		Q9="By what name is the Marvel mutant James Proudstar beter known?Legion;Moonstar;Warpath;Elixir;A=3*";
    	//question 10
    	r=Randomizer(2);
    	if(r==0)
    		Q10="In which comic book series did the Green Arrow make his first appearance?Tales Of The Unexpected;Showcase;Brave And The Bold;More Fun Comics;A=4*";
    	else
    		Q10="What is the name of Flash?Henry Cliff;Barry Allen;Peter Parker;Steve Simon;A=2*";
    }
    
    public void CAT_CA()//Question Bank for Common Acronyms type
    {
    	int r;
    	//question 1
    	r=Randomizer(2);
    	if(r==0)
    		Q1="FBI stands for?Federal Bureaucracy of Investigation;Federation Bureaucracy of Investigation;Federal Bureau of Investigation;Federation Bureau of Investigation;A=3*";
    	else
    		Q1="NASA stands for?National Aerospace and Space Administration;National Aeronautics and Space Administration;National Aeronautics and Space Administrator;National Aeronautic and Space Administration;A=2*";
    	//question 2
    	r=Randomizer(2);
    	if(r==0)
    		Q2="POTUS stands for?Passengers of the United Seas;Players of the Union States;Players of the Union State;President of the United States;A=4*";
    	else
    		Q2="CSI stands for?Crime Scene Investigation;Criminals Scene Investigation;Criminal Scene Investigators;Crime Scene Investigators;A=1*";
    	//question 3
    	r=Randomizer(2);
    	if(r==0)
    		Q3="DOA stands for?Dead On Arrival;Deaths On Arrival;Deadly On Asking;Deaths On Air;A=1*";
    	else
    		Q3="HIV stands for?Human Indeficiency Virus;Human Immunodeficiency Virus;Head Iodine Virus;Humans Immunodeficiency Virus;A=2*";
    	//question 4
    	r=Randomizer(2);
    	if(r==0)
    		Q4="ADD stands for?Attention Defficiency Disorder;Attention Dead Disorder;Attention Deficit Disorder;A Defficiency Disorder;A=3*";
    	else
    		Q4="DOB stands for?Dates Of Births;Dates Of Birth;Date Of Births;Date Of Birth;A=4*";
    	//question 5
    	r=Randomizer(2);
    	if(r==0)
    		Q5="FYI stands for?For You Idiot;For Your Information;Forming Your Idea;For Your Idea;A=2*";
    	else
    		Q5="SUV stands for?Stylish Usage Vehicle;Sports Utility Vehicle;Sports Usage Vehicle;Sizeable Utility Vehicle;A=2*";
    	//question 6
    	r=Randomizer(2);
    	if(r==0)
    		Q6="UFO stands for?Unknown Flying Object;Unidentified Flying Object;Undetected Flying Object;Uncaught Flying Object;A=2*";
    	else
    		Q6="AKA stands for?Also Known As;Always Known After;Always Known As;Also Known After;A=1*";
    	//question 7
    	r=Randomizer(2);
    	if(r==0)
    		Q7="TED stands for?Talk to me, Explain to me, Describe to me;Talk to me, Explain to me, Describe with me;Tell me, Explain to me, Describe to me;Talk with me, Explain to me, Describe to me;A=3*";
    	else
    		Q7="SMART stands for?Specific, Measurable, Attainable, Realistic, Time-bound;Specific, Meassive, Attainable, Ready, Time-bound;Specially, Measurable, Allowable, Realistic, Time-bound;Specific, Measurable, Attainable, Realistic, Time;A=1*";
    	//question 8
    	r=Randomizer(2);
    	if(r==0)
    		Q8="TNT stands for?Tuned Network Television;Toon Network Television;Tuner Network Television;Time Network Television;A=3*";
    	else
    		Q8="LOL stands for?Laugh Out Loudest;Laughing Out Loudest;Laughing Out Loud;Laugh Out Loud;A=3*";
    	//question 9
    	r=Randomizer(2);
    	if(r==0)
    		Q9="MD stands for?Medical Date;Medical Diary;Medical Delay;Medical Doctor;A=4*";
    	else
    		Q9="JIT stands for?Just In Turn;Jack In Transmission;Jack In Trade;Just In Time;A=4*";
    	//question 10
    	r=Randomizer(2);
    	if(r==0)
    		Q10="BFFL stands for?Best Friends Forever in Life;Best Friends For Life;Best Frauds For Life;Best Friends Formed by Lasiness;A=3*";
    	else
    		Q10="KISS stands for?Keep It Simply Stylish;Keep It Simple and Stupid;Keep It Simple Stupid;Keep It Similarly Same;A=3*";
    }
    
    public void CAT_B()//Question Bank for Bollywood type
    {
    	int r;
    	//question 1
    	r=Randomizer(2);
    	if(r==0)
    		Q1="Haider is based on which Shakespearean play?Othello;Hamlet;Macbeth;King Lear;A=2*";
    	else
    		Q1="Which Bollywood actor played TV show host Prem Kumar in 'Slumdog Millionaire'?Anil Kapoor;Shahrukh Khan;Irrfan Khan;Kabir Bedi;A=1*";
    	//question 2
    	r=Randomizer(2);
    	if(r==0)
    		Q2="Which Rajesh Khanna film had the iconic dialogue 'Pushpa, I hate tears'?Aradhana;Kati Patang;Aap Ki Kasam;Amar Prem;A=4*";
    	else
    		Q2="Which actress debuted opposite Shahrukh Khan in 'Om Shanti Om'?Katrina Kaif;Asin;Deepika Padukone;Anushka Sharma;A=3*";
    	//question 3
    	r=Randomizer(2);
    	if(r==0)
    		Q3="Farhan Akhtar made his directorial debut with which film?Don;Dil Chahta Hai;Zindagi Na Milegi Dobara;Luck By Chance;A=2*";
    	else
    		Q3="Who played the infamous villain Gabbar in 'Sholay'?Pran;Ajit;Kader Khan;Amjad Khan;A=4*";
    	//question 4
    	r=Randomizer(2);
    	if(r==0)
    		Q4="Which film casting Amrish Puri had the dialogue 'Mogambo khush hua'?Nayak: The Real Hero;Mr. India;Damini;Diljale;A=2*";
    	else
    		Q4="Which famous actor made his acting debut in 'Dilwale Dulhania Le Jainge'?Karan Johar;Farhan Akhtar;Aditya Chopra;Pritam;A=1*";
    	//question 5
    	r=Randomizer(2);
    	if(r==0)
    		Q5="Who composed the music in 'Jodhaa Akbar'?A. R. Rahman;Anu Malik;Jatin-Lalit;Pritam;A=1*";
    	else
    		Q5="What profession does Sanjay Dutt fake in 'Lage Raho Munna Bhai'?Doctor;History Proffesor;Film Director;Software Engineer;A=2*";
    	//question 6
    	r=Randomizer(2);
    	if(r==0)
    		Q6="Which of these actors was not one of Priyanka Chopra's seven husbands in '7 Khoon Maaf'?John Abraham;Saif Ali Khan;Irrfan Khan;Neil Nitin Mukesh;A=2*";
    	else
    		Q6="Who played the role of Birju in the 1979 film 'Mother India'?Manoj Kumar;Raaj Kumar;Rajendra Kumar;Sunil Dutt;A=4*";
    	//question 7
    	r=Randomizer(2);
    	if(r==0)
    		Q7="Name Aamir Khan's character in Oscar-nominated film 'Lagaan'?Lallan;Arjan;Sajjan;Bhuvan;A=4*";
    	else
    		Q7="Who directed Devdas?Prakash Jha;Ashutosh Gowariker;Daniel Cliff;Sanjay Leela Bhansali;A=4*";
    	//question 8
    	r=Randomizer(2);
    	if(r==0)
    		Q8="Preity Zinta made her debut in which film?Soldier;Dil Se;Kya Kehna;Sangharsh;A=2*";
    	else
    		Q8="Which film launched Amitabh Bachchan as the 'angry young man' of Bollywood?Zanjeer;Deewar;Sholay;Don;A=1*";
    	//question 9
    	r=Randomizer(2);
    	if(r==0)
    		Q9="Shahrukh Khan is the starring cast of which of these films?Kuch Kuch Hota Hai;Dil Chata Hai;Soldier;Koi Mil Gaya;A=1*";
    	else
    		Q9="Jacqueline Fernandez first blockbuster was?Kick;Jaane Kahan Se Aayi Hai;Murder 2;Roy;A=3*";
    	//question 10
    	r=Randomizer(2);
    	if(r==0)
    		Q10="Jacqueline Fernandez made her debut in which film?Murder 2;Kick;Jaane Kahan Se Aayi Hai;Aladin;A=4*";
    	else
    		Q10="What was Jacqueline Fernandez's profession before becoming an actress?Teacher;Air Hostess;News Reporter;Author;A=3*";
    }
    
    public void CAT_F()//Question Bank for Fictions and Authors type
    {	
    	int r;
    	//question 1
    	r=Randomizer(2);
    	if(r==0)
    		Q1="Who is the writer of One Indian Girl?Pretti Shenoy;Chetan Bhagat;Durjoy Datta;Neeti Rastogi;A=2*";
    	else
    		Q1="Who wrote the Harry Potter Series?J. K. Rowling;Agatha Christi;Margaret Mitchell;Jane Eyre;A=1*";
    	//question 2
    	r=Randomizer(2);
    	if(r==0)
    		Q2="Who is the writer of A Suitable Boy?V. S. Naipaul;Mulk Raj Anand;Arundhati Roy;Vikram Seth;A=4*";
    	else
    		Q2="Who wrote Gitanjali?Satyajit Ray;Premchand;Rabindranath Tagore;Mulk Raj Anand;A=3*";
    	//question 3
    	r=Randomizer(2);
    	if(r==0)
    		Q3="Who created Tom Sawyer?Mark Twain;Charles Dickens;R. L. Stevenson;V. S. Naipaul;A=1*";
    	else
    		Q3="Who is the writer of Pride and Prejudice?Jane August;Jane Home;Jane Eyre;Jane Austen;A=4*";
    	//question 4
    	r=Randomizer(2);
    	if(r==0)
    		Q4="Lee Child created which famous charactor?Jack Reacher;Roman Spy;James Bond;Aunt Poly;A=1*";
    	else
    		Q4="Who is the writer of The Hobbit and the series The Lord of the Rings?J. R. R. Tolkien;Jules Verne;R. K. Narayan;Khushwant Singh;A=1*";
    	//question 5
    	r=Randomizer(2);
    	if(r==0)
    		Q5="Who is the writer of Black Beauty?Salman Rushdie;Anna Sewell;Jane Austen;Jane Eyre;A=2*";
    	else
    		Q5="Which Indian writer created Malgudi?Satyajit Ray;Rabindranath Tagore;Mulk Raj Anand;R. K. Narayan;A=4*";
    	//question 6
    	r=Randomizer(2);
    	if(r==0)
    		Q6="The story Life of Pie revolves around which animal?Lion;Elephant;Tiger;Dog;A=3*";
    	else
    		Q6="A Christmas Carol is written by which writer?Charles Dickens;R. L. Stevenson;Mark Twain;Anna Sewell;A=1*";
    	//question 7
    	r=Randomizer(2);
    	if(r==0)
    		Q7="'Narnia' is created by which author'?C. S. Lewis;Mark Twain;Jane Austen;Anna Sewell;A=1*";
    	else
    		Q7="Who is the writer of Midnight Children?Chetan Bhagat;Salman Rushdie;J. K. Rowling;jules Verne;A=2*";
    	//question 8
    	r=Randomizer(2);
    	if(r==0)
    		Q8="Margaret Mitchell wrote which famous Romantic?Me Before You;Mightier than the Sword;Titanic;Gone With the Wind;A=4*";
    	else
    		Q8="What is the name of the third book in the series Harry Potter?Goblet of Fire;Prisoner of Azkaban;Half Blood Prince;Chamber of Secrets;A=2*";
    	//question 9
    	r=Randomizer(2);
    	if(r==0)
    		Q9="Devdas was written in which language?Bangla;Kannada;Urdu;French;A=1*";
    	else
    		Q9="Journey to the Centre of the Earth is written by which writter?Jane Austen;Jules Verne;R. L, Stevenson;Ruskin Bond;A=2*";
    	//question 10
    	r=Randomizer(2);
    	if(r==0)
    		Q10="Leo Tolstoy wrote which Literature Fiction?Animal Farm;War and Peace;Harry Potter;Gone with the Wind;A=2*";
    	else
    		Q10="Frodo is a character of which famous series?Harry Potter;Game of Thrones;Lord of the Rings;Narnia;A=3*";
    }
    
    public void QuestionsSelector()//assigning questions acc. to category choosed
    {
    	if(category.equals("Miscellaneous"))
    	{
    		CAT_M();
    	}
    	else if(category.equals("Well-Known Brands"))
    	{
    		CAT_W();
    	}
    	else if(category.equals("Technology"))
    	{
    		CAT_T();
    	}
    	else if(category.equals("CEOs"))
    	{
    		CAT_C();
    	}
    	else if(category.equals("Science"))
    	{
    		CAT_S();
    	}
    	else if(category.equals("Comics"))
    	{
    		CAT_CO();
    	}
    	else if(category.equals("Common Acronyms"))
    	{
    		CAT_CA();
    	}
    	else if(category.equals("Bollywood"))
    	{
    		CAT_B();
    	}
    	else if(category.equals("Fictions and Authors"))
    	{
    		CAT_F();
    	}
    	
    }
    public void CategoryChoosed()
    {
    	category = choosecategorybox.getValue();
    	QuestionsSelector();
    }
    public void ChooseCategory(Stage s)
    {
    	if(audio == true)
    	{
    		URL resource = getClass().getResource("sound effects/open.mp3");
    	    try
    	    {
    		   	Media media = new Media(resource.toString());
    		   	if(media.getError() == null || media.getOnError() == null)
    		   	{
    		   		mediaPlayer = new MediaPlayer(media);
    		   		mediaPlayer.setStartTime(Duration.seconds(1.61));
    	 	   		mediaPlayer.setVolume(0.5);
    		   		mediaPlayer.play();
    		   	}
    	    }
    	    catch(Exception e)
    	    {}
    	}
    	btnN.setDisable(false);
    	btnB.setDisable(false);
    	btnN.setOnAction(e-> NewGamePage2(s));
    	btnB.setOnAction(e-> NewGamePage1(s));
    	
    	Label cat = new Label("category selection");
    	Label ending = new Label(" is my questions category.");
    	ending.setStyle("-fx-text-fill: black;");

    	cat.setStyle("-fx-text-fill: darkred;"+"-fx-font-size: 30px;"+"-fx-font-weight: bold;");
    	Separator catsep = new Separator();
    	catsep.setPrefWidth(width-50);
    	catsep.setStyle("-fx-background-color: darkred;");
    	QuestionsSelector();	//default questions for Misc. type
    	
    	choosecategorybox.setOnAction(e-> CategoryChoosed());
    	
    	AnchorPane root = new AnchorPane();
    	
    	//Positioning catsep
    	AnchorPane.setTopAnchor(catsep, 49.0);
    	AnchorPane.setLeftAnchor(catsep, 25.0);
    	//Positioning cat
    	AnchorPane.setTopAnchor(cat, 7.0);
    	AnchorPane.setLeftAnchor(cat, 30.0);
    	//Positioning choosecategorybox
    	AnchorPane.setTopAnchor(choosecategorybox, 197.0);
    	AnchorPane.setLeftAnchor(choosecategorybox, 260.0);
    	//Positioning ending
    	AnchorPane.setTopAnchor(ending, 200.0);
    	AnchorPane.setLeftAnchor(ending, 450.0);
    	
    	root.setStyle("-fx-background-color: bisque;");
    	root.getChildren().addAll(cat, catsep, choosecategorybox, ending, btnB , btnN, exit, sep);
    	Scene scene = new Scene(root, width , height);
    	s.setScene(scene);
    	s.show();
    }
    
    public void NewGamePage1(Stage s)
    {
    	if(audio == true)
	   	 {
	   	 	URL resource = getClass().getResource("sound effects/open.mp3");
	   	     try
	   	     {
	   	 	   	Media media = new Media(resource.toString());
	   	 	   	if(media.getError() == null || media.getOnError() == null)
	   	 	   	{
	   	 	   		mediaPlayer = new MediaPlayer(media);
	   	 	   		mediaPlayer.setStartTime(Duration.seconds(1.61));
	   	 	   		mediaPlayer.setVolume(0.5);
	   	 	   		mediaPlayer.play();
	   	 	   	}
	   	     }
	   	     catch(Exception e)
	   	     {}
	   	 }
    	btnN.setText("Next");
    	invalid.setVisible(false);
    	//functions of save , cbhighscore , tf , e , n, t, btnB, btnN
    	btnB.setOnAction(e-> btnBpressed(s));
    	btnN.setOnAction(e-> ChooseCategory(s));
    	
    	tf.setOnMouseClicked(e-> tfpressed());
    	tf.setOnKeyPressed(e-> tfpressed());
    	tf.setOnKeyTyped(e-> tfpressed());
    	tf.setOnAction(e-> tfpressed());	//When enter button from keyboard is pressed
    	
    	cbhighscore.setOnAction(e-> cbhighscorepressed());
    	if(valid == true) //previous entered player data is valid
    	{
    		btnN.setOnAction(e-> ChooseCategory(s));
    		btnN.setDisable(false);
    		invalid.setVisible(true);
    	}
    	else
    	{
    		btnN.setDisable(true);
    	}
    	save.setDisable(true);
    	btnB.setOnAction(e-> Main_Menu(s));
    	e.setOnAction(e-> entpressed());
    	n.setOnAction(e-> entpressed());
    	t.setOnAction(e-> entpressed());
    	
    	save.setOnAction(e-> savepressed(s));
    	
    	String promtname = "Max. 20 characters";
    	tf.setPromptText(promtname);
    	
    	String saveR = "-fx-background-color: forestgreen;"+"-fx-text-fill: white;"+"-fx-font-family: 'Aerial';"+"-fx-font-size: 15px;"+"-fx-font-weight: normal;";
    	String saveH = "-fx-background-color: darkgreen;"+"-fx-text-fill: white;"+"-fx-font-family: 'Aerial';"+"-fx-font-size: 17px;"+"-fx-font-weight: bold;";
    	String saveP = "-fx-background-color: #004400;"+"-fx-text-fill: white;"+"-fx-font-family: 'Aerial';"+"-fx-font-size: 20px;"+"-fx-font-weight: bold;";
    	
    	save.setStyle(saveR);	//initial
    	//save attributes on released, hovering, pressed
    	save.setOnMousePressed(e -> save.setStyle(saveP));
    	save.setOnMouseReleased(e-> save.setStyle(saveR));
    	save.setOnMouseMoved(e-> save.setStyle(saveH));
    	save.setOnMouseExited(e-> save.setStyle(saveR));
    	
    	Label pn = new Label("Player Name:");
    	pn.setStyle(""+""+"-fx-font-size: 17px;");
    	Label cpm = new Label("Choose play mode:");
    	cpm.setStyle(""+"-fx-font-family: 'Calibri';"+"-fx-font-size: 20px;");

    	VBox vb = new VBox();
    	vb.setStyle("-fx-border-color: black;");
    	
    	String infofill = "\n\n Please enter player name.\n Choose the desired play\n mode from the options\n" +
    					  " available.Tick the box to\n remember your game\n scores. At last click the\n Save button to store your\n data.";
    	Text infotext = new Text(infofill);
    	infotext.setStyle("-fx-font-size: 16px;");
    	
    	vb.getChildren().addAll(infotext);
    	
    	Label info = new Label("information");
    	info.setStyle("-fx-text-fill: black;"+"-fx-font-size: 20px;"+"-fx-font-weight: bold;");
    	Separator infosep = new Separator();
    	infosep.setPrefWidth(180);
    	infosep.setStyle("-fx-background-color: black;");
    	
    	Label nhead = new Label("new game");
    	nhead.setStyle("-fx-text-fill: darkred;"+"-fx-font-size: 30px;"+"-fx-font-weight: bold;");
    	Separator nheadsep = new Separator();
    	nheadsep.setPrefWidth(width-50);
    	nheadsep.setStyle("-fx-background-color: darkred;");
    	
    	AnchorPane root = new AnchorPane();
    	
    	//Positioning nheadsep
    	AnchorPane.setTopAnchor(nheadsep, 49.0);
    	AnchorPane.setLeftAnchor(nheadsep, 25.0);
    	//Positioning nhead
    	AnchorPane.setTopAnchor(nhead, 7.0);
    	AnchorPane.setLeftAnchor(nhead, 30.0);
    	//Positioning sep
    	AnchorPane.setTopAnchor(sep , 420.0);
    	AnchorPane.setLeftAnchor(sep , 25.0);
    	//Positioning cbhighscore
    	AnchorPane.setTopAnchor(cbhighscore , 384.0);
    	AnchorPane.setLeftAnchor(cbhighscore , 238.0);
    	//Positioning vb
    	AnchorPane.setTopAnchor(vb , 77.0);
    	AnchorPane.setLeftAnchor(vb , 25.0);
    	AnchorPane.setRightAnchor(vb, 625.0);
    	AnchorPane.setBottomAnchor(vb, 97.0);
    	//Positioning info
    	AnchorPane.setTopAnchor(info , 82.0);
    	AnchorPane.setLeftAnchor(info , 35.0);
    	//Positioning infosep
    	AnchorPane.setTopAnchor(infosep , 107.0);
    	AnchorPane.setLeftAnchor(infosep , 30.0);
    	//Positioning save
    	AnchorPane.setTopAnchor(save , 360.0);
    	AnchorPane.setLeftAnchor(save , 650.0);
    	AnchorPane.setRightAnchor(save , 27.0);
    	AnchorPane.setBottomAnchor(save , 97.0);
    	//Positioning invalid
    	AnchorPane.setTopAnchor(invalid , 325.0);
    	AnchorPane.setRightAnchor(invalid , 32.0);
    	//Positioning pn
    	AnchorPane.setTopAnchor(pn, 100.0);
    	AnchorPane.setLeftAnchor(pn, 280.0);
    	//Positioning tf
    	AnchorPane.setTopAnchor(tf, 90.0);
    	AnchorPane.setLeftAnchor(tf, 430.0);
    	AnchorPane.setRightAnchor(tf, 110.0);
    	//Positioning cpm
    	AnchorPane.setTopAnchor(cpm, 170.0);
    	AnchorPane.setLeftAnchor(cpm, 440.0);
    	//Positioning e EASY RADIOBUTTON
    	AnchorPane.setTopAnchor(e, 216.0);
    	AnchorPane.setLeftAnchor(e, 340.0);
    	//Positioning n NORMAL RADIO BUTTON
    	AnchorPane.setTopAnchor(n, 216.0);
    	AnchorPane.setLeftAnchor(n, 480.0);
    	//Positioning t TOUGH RADIO BUTTON
    	AnchorPane.setTopAnchor(t, 216.0);
    	AnchorPane.setLeftAnchor(t, 620.0);
    	
    	root.setStyle("-fx-background-color: bisque;");
    	root.getChildren().addAll(nhead, nheadsep, sep, btnB , btnN, exit , copyright , cbhighscore, vb, info, infosep, save, pn, tf, cpm, e, n, t, invalid);
    	Scene ins = new Scene(root, width, height);
    	s.setScene(ins);
    	s.show();
    }
    public void ResetAnimation3(Stage s)
    {
    	jack = false;
    	game.setOpacity(1);
    	dots.setOpacity(1);
    	CircleOpacity(1.0);
    	
    	begin.setTranslateX(735.0);
    	o.setTranslateX(-826.0);
    	
    	Scene0(s);
    }
    public void PreviousPositions()
    {
    	transitionNG.setNode(newgame);
	 	transitionHS.setNode(highscore);
	 	transitionI.setNode(instructions);
	 	transitionSet.setNode(settings);
	 	transitionBack.setNode(btnB);
	 	transitionNext.setNode(btnN);
	 	transitionExit.setNode(exit);
	 	newgame.setLayoutX(-605); newgame.setLayoutY(48);
		highscore.setLayoutX(965); highscore.setLayoutY(148);
		instructions.setLayoutX(-605); instructions.setLayoutY(248);
		settings.setLayoutX(965); settings.setLayoutY(347);
	 	
	 	btnB.setLayoutX(505); btnB.setLayoutY(550);
		btnN.setLayoutX(620); btnN.setLayoutY(550);
		exit.setLayoutX(735); exit.setLayoutY(550);
    }
    public void AnimationMM0()
    {
    	transitionNG.setDuration(Duration.seconds(0.7));
	    transitionHS.setDuration(Duration.seconds(0.7));
	    transitionI.setDuration(Duration.seconds(0.7));
	    transitionSet.setDuration(Duration.seconds(0.7));
	    
	    transitionBack.setDuration(Duration.seconds(0.5));
	    transitionNext.setDuration(Duration.seconds(0.5));
	    transitionExit.setDuration(Duration.seconds(0.5));
	    
 	    transitionNG.setDelay(Duration.seconds(0.4));
	    transitionHS.setDelay(Duration.seconds(0.8));
	    transitionI.setDelay(Duration.seconds(1.2));
	    transitionSet.setDelay(Duration.seconds(1.6));
	    
	    transitionBack.setDelay(Duration.seconds(1.9));
	    transitionNext.setDelay(Duration.seconds(2.1));
	    transitionExit.setDelay(Duration.seconds(2.3));
	    
	    transitionNG.setToX(729);
	    transitionHS.setToX(-841);
	    transitionI.setToX(729);
	    transitionSet.setToX(-841);
	    
	    transitionBack.setToY(-110);
	    transitionNext.setToY(-110);
	    transitionExit.setToY(-110);
	    
	    transitionNG.play();
	    transitionHS.play();
	    transitionI.play();
	    transitionSet.play();
	    
	    transitionBack.play();
	    transitionNext.play();
	    transitionExit.play();
    }
    public void Main_Menu(Stage s)  //Scene1 OR MAIN_MENU
    {
    	if(audio == true && playaudio == true)
    	{
    		URL resource = getClass().getResource("sound effects/open.mp3");
    	    try
    	    {
    		   	Media media = new Media(resource.toString());
    		   	if(media.getError() == null || media.getOnError() == null)
    		   	{
    		   		mediaPlayer = new MediaPlayer(media);
    		   		mediaPlayer.setStartTime(Duration.seconds(1.61));
    	 	   		mediaPlayer.setVolume(0.5);
    		   		mediaPlayer.play();
    		   	}
    	    }
    	    catch(Exception e)
    	    {}
    	}
    	playaudio = true;
    	btnN.setText("Next");
    	begin.setDisable(false);
   	 	o.setDisable(false);
    	PreviousPositions();
    	SceneNumber = 1;
    	btnN.setDisable(true);
    	btnB.setOnAction(e-> ResetAnimation3(s));
    	newgame.setOnAction(e-> NewGamePage1(s));
    	highscore.setOnAction(e-> HighScore(s));
    	instructions.setOnAction(e-> Instructions(s));
    	settings.setOnAction(e-> Settings(s));
    	String newgameattrR = "-fx-background-color: chartreuse;"+"-fx-font-size: 25px;"+"-fx-text-fill: darkred;"+"-fx-font-family: 'Cooper Black';"+"-fx-font-weight: normal;";
    	String newgameattrH = "-fx-background-color: green;"+"-fx-font-size: 29px;"+"-fx-text-fill: white;"+"-fx-font-family: 'Cooper Black';"+"-fx-font-weight: bold;";
    	String newgameattrP = "-fx-background-color: darkgreen;"+"-fx-font-size: 32px;"+"-fx-text-fill: white;"+"-fx-font-family: 'Cooper Black';"+"-fx-font-weight: bold;";
    	String highscoreattrR = "-fx-background-color: cyan;"+"-fx-font-size: 25px;"+"-fx-text-fill: navy;"+"-fx-font-family: 'Cooper Black';"+"-fx-font-weight: normal;";
    	String highscoreattrH = "-fx-background-color: mediumblue;"+"-fx-font-size: 29px;"+"-fx-text-fill: white;"+"-fx-font-family: 'Cooper Black';"+"-fx-font-weight: bold;";
    	String highscoreattrP = "-fx-background-color: darkblue;"+"-fx-font-size: 32px;"+"-fx-text-fill: white;"+"-fx-font-family: 'Cooper Black';"+"-fx-font-weight: bold;";
    	String instructionsattrR = "-fx-background-color: gold;"+"-fx-font-size: 25px;"+"-fx-text-fill: darkgreen;"+"-fx-font-family: 'Cooper Black';"+"-fx-font-weight: normal;";
    	String instructionsattrH = "-fx-background-color: darkorange;"+"-fx-font-size: 29px;"+"-fx-text-fill: white;"+"-fx-font-family: 'Cooper Black';"+"-fx-font-weight: bold;";
    	String instructionsattrP = "-fx-background-color: orangered;"+"-fx-font-size: 32px;"+"-fx-text-fill: white;"+"-fx-font-family: 'Cooper Black';"+"-fx-font-weight: bold;";
    	String settingsattrR = "-fx-background-color: blueviolet;"+"-fx-font-size: 25px;"+"-fx-text-fill: orange;"+"-fx-font-family: 'Cooper Black';"+"-fx-font-weight: normal;";
    	String settingsattrH = "-fx-background-color: darkmagenta;"+"-fx-font-size: 29px;"+"-fx-text-fill: white;"+"-fx-font-family: 'Cooper Black';"+"-fx-font-weight: bold;";
    	String settingsattrP = "-fx-background-color: indigo;"+"-fx-font-size: 32px;"+"-fx-text-fill: white;"+"-fx-font-family: 'Cooper Black';"+"-fx-font-weight: bold;";
    	newgame.setStyle(newgameattrR);
    	highscore.setStyle(highscoreattrR);
    	instructions.setStyle(instructionsattrR);
    	settings.setStyle(settingsattrR);
    	tnewgame.setText("Press Button to Play the Game.");
    	tnewgame.setStyle(tooltipattr);
    	newgame.setTooltip(tnewgame);
    	thighscore.setText("Press Button to view High-scores of recent Players.");
    	thighscore.setStyle(tooltipattr);
    	highscore.setTooltip(thighscore);
    	tinstructions.setText("Press Button to see Instructions.");
    	tinstructions.setStyle(tooltipattr);
    	instructions.setTooltip(tinstructions);
    	tsettings.setText("Press Button to change game settings.");
    	tsettings.setStyle(tooltipattr);
    	settings.setTooltip(tsettings);
    	//Released , Hovering , Pressed Scenarios
    	newgame.setOnMousePressed(e -> newgame.setStyle(newgameattrP));
    	newgame.setOnMouseReleased(e-> newgame.setStyle(newgameattrR));
    	newgame.setOnMouseMoved(e-> newgame.setStyle(newgameattrH));
    	newgame.setOnMouseExited(e-> newgame.setStyle(newgameattrR));
    	highscore.setOnMousePressed(e -> highscore.setStyle(highscoreattrP));
    	highscore.setOnMouseReleased(e-> highscore.setStyle(highscoreattrR));
    	highscore.setOnMouseMoved(e-> highscore.setStyle(highscoreattrH));
    	highscore.setOnMouseExited(e-> highscore.setStyle(highscoreattrR));
    	instructions.setOnMousePressed(e -> instructions.setStyle(instructionsattrP));
    	instructions.setOnMouseReleased(e-> instructions.setStyle(instructionsattrR));
    	instructions.setOnMouseMoved(e-> instructions.setStyle(instructionsattrH));
    	instructions.setOnMouseExited(e-> instructions.setStyle(instructionsattrR));
    	settings.setOnMousePressed(e -> settings.setStyle(settingsattrP));
    	settings.setOnMouseReleased(e-> settings.setStyle(settingsattrR));
    	settings.setOnMouseMoved(e-> settings.setStyle(settingsattrH));
    	settings.setOnMouseExited(e-> settings.setStyle(settingsattrR));
    	AnchorPane root = new AnchorPane();
    	//positioning COPYRIGHT
        AnchorPane.setLeftAnchor(copyright, 5.0);
        AnchorPane.setBottomAnchor(copyright, 5.0);
    	root.getChildren().addAll(newgame, highscore, instructions, settings, copyright,btnN, btnB, exit);
    	root.setStyle("-fx-background-color: #64b5f6;");
    	Scene scene1 = new Scene(root,width , height);
    	s.setScene(scene1);
    	s.show();
    	AnimationMM0();
    }
     public void CircleOpacity(double a)
     {		
    	 cir00.setOpacity(a);
    	 cir01.setOpacity(a);
    	 cir02.setOpacity(a);
    	 cir03.setOpacity(a);
    	 cir04.setOpacity(a);
    	 cir05.setOpacity(a);
    	 cir06.setOpacity(a);
    	 cir07.setOpacity(a);
    	 cir08.setOpacity(a);
    	 cir09.setOpacity(a);
    	 cir10.setOpacity(a);
     }
     public void Opacity01()
     {
    	 game.setOpacity(0.0);
    	 dots.setOpacity(0.0);
    	 CircleOpacity(0.0);
     }
     public void Opacity02()
     {
    	 game.setOpacity(0.1);
    	 dots.setOpacity(0.0);
    	 CircleOpacity(0.0);
     }
     public void Opacity03()
     {
    	 game.setOpacity(0.3);
    	 dots.setOpacity(0.0);
    	 CircleOpacity(0.3);
     }
     public void Opacity04()
     {
    	 game.setOpacity(0.4);
    	 dots.setOpacity(0.0);
    	 CircleOpacity(0.4);
     }
     public void Opacity05()
     {
    	 game.setOpacity(0.5);
    	 dots.setOpacity(0.0);
    	 CircleOpacity(0.5);
     }
     public void Opacity06()
     {
    	 game.setOpacity(0.6);
    	 dots.setOpacity(0.0);
    	 CircleOpacity(0.6);
     }
     public void Opacity07()
     {
    	 game.setOpacity(0.7);
    	 dots.setOpacity(0.3);
    	 CircleOpacity(0.7);
     }
     public void Opacity08()
     {
    	 game.setOpacity(0.8);
    	 dots.setOpacity(0.6);
    	 CircleOpacity(0.8);
     }
     public void Opacity09()
     {
    	 game.setOpacity(0.9);
    	 dots.setOpacity(0.9);
    	 CircleOpacity(0.9);
     }
     public void Opacity10()
     {
    	 game.setOpacity(1.0);
    	 dots.setOpacity(1.0);
     }
     public void Animation2()
     {	
    	 transition00.setDuration(Duration.seconds(0.3));
 	     transition01.setDuration(Duration.seconds(0.3));
 	     transition02.setDuration(Duration.seconds(0.3));
 	     transition03.setDuration(Duration.seconds(0.3));
 	     transition04.setDuration(Duration.seconds(0.3));
 	     transition05.setDuration(Duration.seconds(0.3));
 	     transition06.setDuration(Duration.seconds(0.3));
 	     transition07.setDuration(Duration.seconds(0.3));
 	     transition08.setDuration(Duration.seconds(0.3));
 	     transition09.setDuration(Duration.seconds(0.3));
 	     transition10.setDuration(Duration.seconds(0.3));
 	     transitionS.setDuration(Duration.seconds(1));
 	     transitionE.setDuration(Duration.seconds(1));
 	     transition00.setDelay(Duration.seconds(0.3));
 	     transitionS.setDelay(Duration.seconds(0.5));
 	     transition01.setDelay(Duration.seconds(0.6));
 	     transitionE.setDelay(Duration.seconds(0.8));
 	     transition02.setDelay(Duration.seconds(0.9));
 	     transition03.setDelay(Duration.seconds(1.2));
 	     transition04.setDelay(Duration.seconds(1.5));
 	     transition05.setDelay(Duration.seconds(1.8));
 	     transition06.setDelay(Duration.seconds(2.1));
 	     transition07.setDelay(Duration.seconds(2.4));
 	     transition08.setDelay(Duration.seconds(2.7));
 	     transition09.setDelay(Duration.seconds(3.0));
 	     transition10.setDelay(Duration.seconds(3.3));
 	     transition00.setToX(-826);
 	     transition01.setToX(-776);
 	     transition02.setToX(-726);
 	     transition03.setToX(-624);
 	     transition04.setToX(-564);
 	     transition05.setToX(-518);
 	     transition06.setToX(-468);
 	     transition07.setToX(-367);
 	     transition08.setToX(-310);
 	     transition09.setToX(-267);
 	     transition10.setToX(-210);
 	     transitionS.setToX(734);
 	     transitionE.setToX(-826);
 	 	 transition00.play();
 	     transition01.play();
 	     transition02.play();
 	     transition03.play();
 	     transition04.play();
 	     transition05.play();
 	     transition06.play();
 	     transition07.play();
 	     transition08.play();
 	     transition09.play();
 	     transition10.play();
 	     transitionS.play();
 	     transitionE.play();
 	     transition07.setOnFinished(e-> begin.setDisable(false));
 	     transition08.setOnFinished(e-> o.setDisable(false));
     }
     public void Animation()
     {	
    	firsttime = false;
    	transition00g.setNode(game);
    	transition01g.setNode(game);
    	transition02g.setNode(game);
    	transition03g.setNode(game);
    	transition04g.setNode(game);
    	transition05g.setNode(game);
    	transition06g.setNode(game);
    	transition07g.setNode(game);
    	transition08g.setNode(game);
    	transition09g.setNode(game);
    	transition10g.setNode(game);
    	transition01g.setOnFinished(e-> Opacity01());
    	transition02g.setOnFinished(e-> Opacity02());
    	transition03g.setOnFinished(e-> Opacity03());
    	transition04g.setOnFinished(e-> Opacity04());
    	transition05g.setOnFinished(e-> Opacity05());
    	transition06g.setOnFinished(e-> Opacity06());
    	transition07g.setOnFinished(e-> Opacity07());
    	transition08g.setOnFinished(e-> Opacity08());
    	transition09g.setOnFinished(e-> Opacity09());
    	transition10g.setOnFinished(e-> Opacity10());
    	transition00g.setOnFinished(e-> Animation2());
    	transition01g.setDelay(Duration.seconds(0.2));
    	transition02g.setDelay(Duration.seconds(0.4));
    	transition03g.setDelay(Duration.seconds(0.6));
    	transition04g.setDelay(Duration.seconds(0.8));
    	transition05g.setDelay(Duration.seconds(1.0));
    	transition06g.setDelay(Duration.seconds(1.2));
    	transition07g.setDelay(Duration.seconds(1.4));
    	transition08g.setDelay(Duration.seconds(1.6));
    	transition09g.setDelay(Duration.seconds(1.8));
    	transition10g.setDelay(Duration.seconds(2.0));
    	transition00g.setDelay(Duration.seconds(2.2));
    	transition01g.play();
    	transition02g.play();
    	transition03g.play();
    	transition04g.play();
    	transition05g.play();
    	transition06g.play();
    	transition07g.play();
    	transition08g.play();
    	transition09g.play();
    	transition10g.play();
    	transition00g.play();
    }
     public void Animation3(Stage s)
     {
    	 if(audio == true)
    	 {
    	 	URL resource = getClass().getResource("sound effects/open.mp3");
    	     try
    	     {
    	 	   	Media media = new Media(resource.toString());
    	 	   	if(media.getError() == null || media.getOnError() == null)
    	 	   	{
    	 	   		mediaPlayer = new MediaPlayer(media);
    	 	   		mediaPlayer.setStartTime(Duration.seconds(1.61));
    	 	   		mediaPlayer.setVolume(0.5);
    	 	   		mediaPlayer.play();
    	 	   	}
    	     }
    	     catch(Exception e)
    	     {}
    	 }
    	 begin.setDisable(true);
    	 o.setDisable(true);
    	 transition01g.setOnFinished(e-> Opacity09());
    	 transition02g.setOnFinished(e-> Opacity08());
    	 transition03g.setOnFinished(e-> Opacity07());
    	 transition04g.setOnFinished(e-> Opacity06());
    	 transition05g.setOnFinished(e-> Opacity05());
    	 transition06g.setOnFinished(e-> Opacity04());
    	 transition07g.setOnFinished(e-> Opacity03());
    	 transition08g.setOnFinished(e-> Opacity02());
    	 transition09g.setOnFinished(e-> Opacity01());
    	 transition01g.setDelay(Duration.seconds(0.2));
     	 transition02g.setDelay(Duration.seconds(0.4));
     	 transition03g.setDelay(Duration.seconds(0.6));
     	 transition04g.setDelay(Duration.seconds(0.8));
     	 transition05g.setDelay(Duration.seconds(1.0));
     	 transition06g.setDelay(Duration.seconds(1.2));
     	 transition07g.setDelay(Duration.seconds(1.4));
     	 transition08g.setDelay(Duration.seconds(1.6));
     	 transition09g.setDelay(Duration.seconds(1.8));
    	 transitionS.setToX(1600);
    	 transitionE.setToX(-1900);
    	 transitionS.setDuration(Duration.seconds(2));
    	 transitionE.setDuration(Duration.seconds(2));
    	 transitionE.setDelay(Duration.seconds(0.8));
    	 transitionS.play();
    	 transitionE.play();
    	 transition01g.play();
    	 transition02g.play();
    	 transition03g.play();
    	 transition04g.play();
    	 transition05g.play();
    	 transition06g.play();
    	 transition07g.play();
    	 transition08g.play();
    	 transition09g.play();
    	 transitionS.setOnFinished(e-> Main_Menu(s));
    }
    public void Scene0(Stage s)
    {	
    	playaudio = false;
    	try
    	{
    		mediaPlayer.setMute(true);
    	}
    	catch(Exception e)
    	{}
    	if(audio == true)
    	{
    		URL resource = getClass().getResource("sound effects/open.mp3");
    	    try
    	    {
    		   	Media media = new Media(resource.toString());
    		   	if(media.getError() == null || media.getOnError() == null)
    		   	{
    		   		mediaPlayer = new MediaPlayer(media);
    		   		mediaPlayer.setStartTime(Duration.seconds(1.61));
    		   		mediaPlayer.setVolume(0.5);
    		   		mediaPlayer.play();
    		   	}
    	    }
    	    catch(Exception e)
    	    {}
    	}
    	o.setOnAction(e-> System.exit(0));
    	begin.setOnAction(e-> Animation3(s));	//SETONACTION BUTTON 'begin'
    	SceneNumber = 0;
    	String textattr  = "-fx-text-fill: red;"+"-fx-font-size: 85px;"+"-fx-font-family: 'Courier New';"+"-fx-font-weight: bold;";
    	String beginattr = "-fx-background-color: lightblue;"+"-fx-text-fill: blue;"+"-fx-font-weight: bold;"+"-fx-font-size: 30px;";
        String beginattrP = "-fx-background-color: navy;"+"-fx-text-fill: white;"+"-fx-font-weight: bold;"+"-fx-font-size: 38px;";
        String beginattrH = "-fx-background-color: blue;"+"-fx-text-fill: white;"+"-fx-font-weight: bold;"+"-fx-font-size: 35px;";
        
        String oattr = "-fx-background-color: hotpink;"+"-fx-text-fill: darkred;"+"-fx-font-size: 25px;"+"-fx-font-family: Cambria;";
        String oattrP = "-fx-background-color: maroon;"+"-fx-text-fill: white;"+"-fx-font-size: 30px;"+"-fx-font-family: Cambria";
        String oattrH = "-fx-background-color: red;"+"-fx-text-fill: white;"+"-fx-font-size: 26px;"+"-fx-font-family: Cambria;";
        
        game.setText("THE QUIZ GAME");
        game.setStyle(textattr);
        
        dots.setText(".......................................");
        dots.setStyle("-fx-font-size: 80px;" + "-fx-text-fill: orange;");
        
        
        String toattr = "-fx-background-color: white;"+"-fx-text-fill: black;"+"-fx-font-size: 15px;"+"-fx-font-weight: normal;"+
				 		"-fx-font-family: 'Aerial';";
        Tooltip to = new Tooltip();
        to.setText("Press Button to Close the Window.");
        to.setStyle(toattr);
        o.setTooltip(to);
        
        Tooltip tbegin = new Tooltip();
        tbegin.setText("Press Button to START THE GAME.");
        tbegin.setStyle("-fx-background-color: white;"+"-fx-text-fill: black;"+"-fx-font-size: 15px;"+"-fx-font-weight: normal;");
        begin.setTooltip(tbegin);
        begin.setStyle(beginattr);
        o.setStyle(oattr);
        o.setOnMousePressed(e-> o.setStyle(oattrP));
        begin.setOnMousePressed(e -> begin.setStyle(beginattrP));
        o.setOnMouseReleased(e -> o.setStyle(oattr));
        begin.setOnMouseReleased(e-> begin.setStyle(beginattr));
        o.setOnMouseMoved(e-> o.setStyle(oattrH));
        begin.setOnMouseMoved(e-> begin.setStyle(beginattrH));
        o.setOnMouseExited(e-> o.setStyle(oattr));
        begin.setOnMouseExited(e-> begin.setStyle(beginattr));
        
        AnchorPane root = new AnchorPane();
        //positioning text
        AnchorPane.setTopAnchor(game, 87.0);
        AnchorPane.setLeftAnchor(game, 99.0);
        //positioning dots
        AnchorPane.setTopAnchor(dots, 105.0);
        AnchorPane.setLeftAnchor(dots, 96.0);
      	//positioning COPYRIGHT
        AnchorPane.setLeftAnchor(copyright, 5.0);
        AnchorPane.setBottomAnchor(copyright, 5.0);
        //Positioning sep
    	AnchorPane.setTopAnchor(sep , 420.0);
    	AnchorPane.setLeftAnchor(sep , 25.0);
        
    	root.getChildren().addAll(cir00, cir01, cir02, cir03, cir04, cir05, cir06, cir07, cir08, cir09, cir10);
        root.getChildren().addAll(game, dots ,begin , o, copyright);
        Scene scene0 = new Scene(root,width, height );
        root.setStyle("-fx-background-color: #64b5f6;");
        s.setResizable(false);
        s.setTitle("The Quiz Game");
        s.setScene(scene0);
        s.show();
        if(firsttime == true)
        {
        	Animation();
        	firsttime = false;
        }
    }
    public void Scene0N(Stage s)
    {
    	URL resource = getClass().getResource("sound effects/Electricity.mp3");
	    try
	    {
		   	media = new Media(resource.toString());
		   	if(media.getError() == null || media.getOnError() == null)
		   	{
		   		mediaPlayer = new MediaPlayer(media);
		   		mediaPlayer.setVolume(1.0);
		   		
		   	}
	    }
	    catch(Exception e)
	    {}
    	Button start = new Button("Open");
    	HBox rec = new HBox();
    	rec.setStyle("-fx-border-color: #202020;" + "-fx-border-width: 3px;");
    	TranslateTransition recs = new TranslateTransition();
    	recs.setNode(rec);
    	
    	String nsattr = "-fx-text-fill: white;" + "-fx-font-size: 35px;" +"-fx-font-family: 'Felix Titling';" + "-fx-font-weight: bold;";
    	String nnsattr = "-fx-text-fill: #252525;" + "-fx-font-size: 35px;" +"-fx-font-family: 'Felix Titling';" + "-fx-font-weight: bold;"; 
    	
    	Label ns1 = new Label("T");
    	Label ns2 = new Label("H");
    	Label ns3 = new Label("E");
    	Label ns4 = new Label(" ");
    	Label ns5 = new Label("Q");
    	Label ns6 = new Label("U");
    	Label ns7 = new Label("I");
    	Label ns8 = new Label("Z");
    	Label ns9 = new Label(" ");
    	Label ns10 = new Label("G");
    	Label ns11 = new Label("A");
    	Label ns12 = new Label("M");
    	Label ns13 = new Label("E");
    	
    	ns1.setStyle(nnsattr);
    	ns2.setStyle(nnsattr);
    	ns3.setStyle(nnsattr);
    	ns4.setStyle(nnsattr);
    	ns5.setStyle(nnsattr);
    	ns6.setStyle(nnsattr);
    	ns7.setStyle(nnsattr);
    	ns8.setStyle(nnsattr);
    	ns9.setStyle(nnsattr);
    	ns10.setStyle(nnsattr);
    	ns11.setStyle(nnsattr);
    	ns12.setStyle(nnsattr);
    	ns13.setStyle(nnsattr);
    	
    	TranslateTransition n1 = new TranslateTransition();
    	TranslateTransition n2 = new TranslateTransition();
    	TranslateTransition n3 = new TranslateTransition();
    	TranslateTransition n4 = new TranslateTransition();
    	TranslateTransition n5 = new TranslateTransition();
    	TranslateTransition n6 = new TranslateTransition();
    	TranslateTransition n7 = new TranslateTransition();
    	TranslateTransition n8 = new TranslateTransition();
    	TranslateTransition n9 = new TranslateTransition();
    	TranslateTransition n10 = new TranslateTransition();
    	TranslateTransition n11 = new TranslateTransition();
    	TranslateTransition n12 = new TranslateTransition();
    	TranslateTransition n13 = new TranslateTransition();
    	
    	n1.setNode(ns1);
    	n2.setNode(ns2);
    	n3.setNode(ns3);
    	n4.setNode(ns4);
    	n5.setNode(ns5);
    	n6.setNode(ns6);
    	n7.setNode(ns7);
    	n8.setNode(ns8);
    	n9.setNode(ns9);
    	n10.setNode(ns10);
    	n11.setNode(ns11);
    	n12.setNode(ns12);
    	n13.setNode(ns13);
    	
    	Bloom bloom = new Bloom();
    	ns1.setEffect(bloom);
    	ns2.setEffect(bloom);
    	ns3.setEffect(bloom);
    	ns4.setEffect(bloom);
    	ns5.setEffect(bloom);
    	ns6.setEffect(bloom);
    	ns7.setEffect(bloom);
    	ns8.setEffect(bloom);
    	ns9.setEffect(bloom);
    	ns10.setEffect(bloom);
    	ns11.setEffect(bloom);
    	ns12.setEffect(bloom);
    	ns13.setEffect(bloom);
    	
    	start.setOnAction(e-> Scene0(s));
    	
    	start.setPrefHeight(40.0);
    	start.setPrefWidth(130.0);
    	start.setOnMouseMoved(e-> start.setStyle("-fx-background-color: grey;"+"-fx-font-weight: bold;"+"-fx-text-fill: white;"+"-fx-font-size: 17px;"));
    	start.setOnMouseExited(e-> start.setStyle("-fx-background-color: white;"+"-fx-font-weight: normal;"+"-fx-text-fill: black;"+"-fx-font-size: 16px;"));
    	start.setOnMousePressed(e-> start.setStyle("-fx-background-color: #606060;"+"-fx-font-weight: bold;"+"-fx-text-fill: white;"+"-fx-font-size: 18px;"));
    	start.setOnMouseReleased(e-> start.setStyle("-fx-background-color: white;"+"-fx-font-weight: normal;"+"-fx-text-fill: black;"+"-fx-font-size: 16px;"));
    	start.setStyle("-fx-background-color: white;"+"-fx-text-fill: black;"+"-fx-font-size: 16px;");	//Initial
    	TranslateTransition tts = new TranslateTransition();
    	tts.setNode(start);
    	start.setLayoutX(682.0);
    	start.setLayoutY(507.0);
    	tts.setToY(-120);
    	tts.setDelay(Duration.seconds(4.0));
    	tts.setDuration(Duration.seconds(1.0));
    	Label hint = new Label("Press Open button to continue.");
    	hint.setStyle("-fx-text-fill: white;");
    	hint.setLayoutX(607.0);
    	hint.setLayoutY(436);
    	hint.setStyle("-fx-text-fill: black;");
    	TranslateTransition tth = new TranslateTransition();
    	tth.setNode(hint);
    	tth.setDuration(Duration.seconds(0.5));
    	tth.setDelay(Duration.seconds(4.2));
    	tts.setOnFinished(e-> hint.setStyle("-fx-text-fill: white;"));
    	
    	AnchorPane root = new AnchorPane();
    	root.setStyle("-fx-background-color: black;");
    	
    	//Positioning ns1
    	AnchorPane.setTopAnchor(ns1, 100.0);
    	AnchorPane.setLeftAnchor(ns1, 260.0);
    	//Positioning ns2
    	AnchorPane.setTopAnchor(ns2, 100.0);
    	AnchorPane.setLeftAnchor(ns2, 284.0);
    	//Positioning ns3
    	AnchorPane.setTopAnchor(ns3, 100.0);
    	AnchorPane.setLeftAnchor(ns3, 313.0);
    	//Positioning ns5
    	AnchorPane.setTopAnchor(ns5, 100.0);
    	AnchorPane.setLeftAnchor(ns5, 356.0);
    	//Positioning ns6
    	AnchorPane.setTopAnchor(ns6, 100.0);
    	AnchorPane.setLeftAnchor(ns6, 387.0);
    	//Positioning ns7
    	AnchorPane.setTopAnchor(ns7, 100.0);
    	AnchorPane.setLeftAnchor(ns7, 416.0);
    	//Positioning ns8
    	AnchorPane.setTopAnchor(ns8, 100.0);
    	AnchorPane.setLeftAnchor(ns8, 430.0);
    	//Positioning ns10
    	AnchorPane.setTopAnchor(ns10, 100.0);
    	AnchorPane.setLeftAnchor(ns10, 475.0);
    	//Positioning ns11
    	AnchorPane.setTopAnchor(ns11, 100.0);
    	AnchorPane.setLeftAnchor(ns11, 505.0);
    	//Positioning ns12
    	AnchorPane.setTopAnchor(ns12, 100.0);
    	AnchorPane.setLeftAnchor(ns12, 534.0);
    	//Positioning ns13
    	AnchorPane.setTopAnchor(ns13, 100.0);
    	AnchorPane.setLeftAnchor(ns13, 568.0);
    	//Positioning rec
    	AnchorPane.setTopAnchor(rec, 85.0);
    	AnchorPane.setLeftAnchor(rec, 230.0);
    	AnchorPane.setRightAnchor(rec, 230.0);
    	AnchorPane.setBottomAnchor(rec, 340.0);
    	
    	//Animation
    	Label pseudo0 = new Label("T");
    	Label pseudo1 = new Label("T");
    	pseudo0.setStyle(nsattr);
    	pseudo1.setStyle(nsattr);
    	
    	//Positioning pseudo0
    	AnchorPane.setTopAnchor(pseudo0, 100.0);
    	AnchorPane.setLeftAnchor(pseudo0, 260.0);
    	//Positioning pseudo1
    	AnchorPane.setTopAnchor(pseudo1, 100.0);
    	AnchorPane.setLeftAnchor(pseudo1, 260.0);
    	
    	TranslateTransition p0 = new TranslateTransition();
    	TranslateTransition p1 = new TranslateTransition();
    	TranslateTransition p2 = new TranslateTransition();
    	TranslateTransition p3 = new TranslateTransition();
    	p0.setNode(pseudo0);
    	p1.setNode(pseudo1);
    	p2.setNode(pseudo0);
    	p3.setNode(pseudo1);
    	pseudo0.setVisible(false);
    	pseudo1.setVisible(false);
    	p0.setDelay(Duration.seconds(1.0));
    	p2.setDelay(Duration.seconds(1.4));
    	p1.setDelay(Duration.seconds(1.8));
    	p3.setDelay(Duration.seconds(2.0));
    	p0.setOnFinished(e-> pseudo0.setVisible(true));
    	p2.setOnFinished(e-> pseudo0.setVisible(false));
    	p1.setOnFinished(e-> pseudo1.setVisible(true));
    	p3.setOnFinished(e-> pseudo1.setVisible(false));
    	n1.setOnFinished(e-> ns1.setStyle(nsattr));
    	n2.setOnFinished(e-> ns2.setStyle(nsattr));
    	n3.setOnFinished(e-> ns3.setStyle(nsattr));
    	n4.setOnFinished(e-> ns4.setStyle(nsattr));
    	n5.setOnFinished(e-> ns5.setStyle(nsattr));
    	n6.setOnFinished(e-> ns6.setStyle(nsattr));
    	n7.setOnFinished(e-> ns7.setStyle(nsattr));
    	n8.setOnFinished(e-> ns8.setStyle(nsattr));
    	n9.setOnFinished(e-> ns9.setStyle(nsattr));
    	n10.setOnFinished(e-> ns10.setStyle(nsattr));
    	n11.setOnFinished(e-> ns11.setStyle(nsattr));
    	n12.setOnFinished(e-> ns12.setStyle(nsattr));
    	n13.setOnFinished(e-> ns13.setStyle(nsattr));
    	recs.setOnFinished(e-> rec.setStyle("-fx-border-color: white;"+"-fx-border-width: 3px;"));
    	n1.setDelay(Duration.seconds(2.3));
    	n2.setDelay(Duration.seconds(2.4));
    	n3.setDelay(Duration.seconds(2.5));
    	n4.setDelay(Duration.seconds(2.6));
    	n5.setDelay(Duration.seconds(2.7));
    	n6.setDelay(Duration.seconds(2.8));
    	n7.setDelay(Duration.seconds(2.9));
    	n8.setDelay(Duration.seconds(3.0));
    	n9.setDelay(Duration.seconds(3.1));
    	n10.setDelay(Duration.seconds(3.2));
    	n11.setDelay(Duration.seconds(3.3));
    	n12.setDelay(Duration.seconds(3.4));
    	n13.setDelay(Duration.seconds(3.5));
    	recs.setDelay(Duration.seconds(3.6));
    	FadeTransition fd = new FadeTransition(Duration.seconds(0.8));
    	fd.setFromValue(1.0);
    	fd.setToValue(0.0);
    	fd.setCycleCount(Animation.INDEFINITE);
    	fd.setNode(hint);
    	rec.setEffect(bloom);
    	root.getChildren().addAll(rec, ns1, ns2, ns3, ns4, ns5, ns6, ns7, ns8, ns9, ns10, ns11, ns12, ns13, hint, start, pseudo0, pseudo1);
    	Scene scene = new Scene(root , width - 12.0 , height - 12.0);
    	s.setResizable(false);
    	s.setTitle("The Quiz Game");
    	s.setScene(scene);
    	s.show();
    	p0.play();
    	p2.play();
    	p1.play();
    	p3.play();
    	n1.play();
    	n2.play();
    	n3.play();
    	n4.play();
    	n5.play();
    	n6.play();
    	n7.play();
    	n8.play();
    	n9.play();
    	n10.play();
    	n11.play();
    	n12.play();
    	n13.play();
    	recs.play();
    	tts.play();
    	tth.play();
    	fd.play();
    	try
    	{
    		mediaPlayer.play();
    	}
    	catch(Exception e)
    	{}
    }
    
    public void start(Stage s)
    {
    	Image img = new Image("Data/The_Quiz_Game_Icon.png");
       	s.getIcons().add(img);
    	//sep attributes
    	sep.setPrefWidth(width-50);
    	sep.setStyle("-fx-background-color: blue;");
    	exit.setOnAction(e-> System.exit(0));	  //Exit Button in all the scenes except scene0
        contents.setOnAction(e-> Main_Menu(s));
    	Released();
    	//If btnB Or btnN Or btnE is PRESSED
    	btnN.setOnMousePressed(e->Pressed(btnN));
    	btnB.setOnMousePressed(e->Pressed(btnB));
    	exit.setOnMousePressed(e->Pressed(exit));
    	//If btnB Or btnN Or btnE is HOVERED
    	//Part 1:
    	btnN.setOnMouseMoved(e->Hovering(btnN));
    	btnB.setOnMouseMoved(e->Hovering(btnB));
    	exit.setOnMouseMoved(e->Hovering(exit));
    	//Part 2:
    	btnN.setOnMouseExited(e->Released());
    	btnB.setOnMouseExited(e->Released());
    	exit.setOnMouseExited(e->Released());
    	//When btnB Or btnN Or BtnE is RELEASED
    	btnN.setOnMouseReleased(e->Released());
    	btnB.setOnMouseReleased(e->Released());
    	exit.setOnMouseReleased(e->Released());
    	Scene0N(s);
    }
    public static void main(String args[])
    {
    	launch(args);
    }    
}