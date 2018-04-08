/** Program: Milestone5
 * File:Draft.java
 * Summary: Draft Class that extends Application, has the panes of each player
 * Author: Brandon Labat
 * Date: April 8, 2018
 */
import javafx.event.ActionEvent;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;


public class Draft extends Application {
	Manager players = new Manager();
	
	public static void main(String[] args) {
		Application.launch(args);
	}
	@Override
	
	public void start(Stage primaryStage) {
		Manager player = new Manager();
		Pane start = new VBox(15);
		start.setPadding(new Insets(15,15,15,15));
		((VBox)start).setAlignment(Pos.CENTER);
		
		Image logo = new Image(getClass().getResourceAsStream("draft/nfl.jpg"));
		ImageView logo1 = new ImageView(logo);
		start.getChildren().add(logo1);
		
		Font impact = Font.font("Impact", FontWeight.BOLD, 25);
		String startMenu = new String("Welcome to the NFL Draft");
		Label startLabel = new Label(startMenu);
		startLabel.setFont(impact);
		start.getChildren().add(startLabel);
		
		Button startbutton = new Button("Begin");
		start.getChildren().add(startbutton);
		
		Scene scene = new Scene(start, 500, 500);
		primaryStage.setTitle("NFL Draft");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		Pane main = new VBox(20);
		main.setPadding(new Insets(20,20,20,20));
		((VBox)main).setAlignment(Pos.CENTER);
		
		Button offense = new Button("Choose an Offensive Player");
		Button defense = new Button ("Choose a Defensive Player");
		Button roster = new Button("See Your Current Roster");
		
		ImageView logo2 = new ImageView(logo);
		logo2.setPreserveRatio(true);
		logo2.setFitHeight(200);
		
		main.getChildren().addAll(logo2, offense,defense,roster);
		
		Scene mainScene = new Scene(main, 500, 500);
		
		startbutton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				primaryStage.setScene(mainScene);
				primaryStage.show();
			}
		});
		// Roster Scene
		Pane rosPane = new VBox(20);
		rosPane.setPadding(new Insets(20,20,20,20));
		((VBox) rosPane).setAlignment(Pos.CENTER);
		Label rosTitle = new Label(new String("Your Roster"));
		rosTitle.setFont(impact);
		rosPane.getChildren().add(rosTitle);
		Button back1 = new Button("Return to Main Menu");
		rosPane.getChildren().add(back1);
		
		Button bradyRos = new Button("Tom Brady");
		Button riversRos = new Button ("Philip Rivers");
		Button huntRos  = new Button("Kareem Hunt");
		Button gurlRos = new Button("Todd Gurley");
		Button brownRos = new Button("Preston Brown");
		Button martinezRos = new Button("Blake Martinez");
		
		Scene rosScene = new Scene(rosPane, 500, 500);
		
		roster.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				primaryStage.setScene(rosScene);
				primaryStage.show();
			}
		});
		//back to main menu
		back1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				primaryStage.setScene(mainScene);
				primaryStage.show();
			}
		});
		// Tom Brady Scene
		GridPane bradyPane = new GridPane();
		bradyPane.setAlignment(Pos.TOP_LEFT);
		bradyPane.setPadding(new Insets(10,10,10,10));
		bradyPane.setHgap(20);
		bradyPane.setVgap(20);
		
		Label bradyName = new Label(new String(players.offenseList.get(0).getName()));
		bradyName.setFont(impact);
		bradyPane.add(bradyName,0,0);
		bradyPane.add(new Label(new String("Age: " + players.offenseList.get(0).getAge())),0,2);
		bradyPane.add(new Label(new String(players.offenseList.get(0).getPosition())),0,1);
		bradyPane.add(new Label(new String("# " + players.offenseList.get(0).getNumber())), 2, 1);
		bradyPane.add(new Label(new String("HighSchool: " + players.offenseList.get(0).getHighschool())), 2, 2);
		bradyPane.add(new Label(new String("College: " + players.offenseList.get(0).getCollege())), 1, 2);
		bradyPane.add(new Label(new String("TEAM: " + (players.offenseList.get(0).getTeam()))),1,1);
		bradyPane.add(new Label(new String("Seasons " + (players.offenseList.get(0).getExperience()))),3,1);
		bradyPane.add(new Label(new String("Weight: " + (players.offenseList.get(0).getWeight()))),3,2);
		bradyPane.add(new Label(new String("Height: " + (players.offenseList.get(0).getHeight()))),4,1);
		bradyPane.add(new Label(new String("TEAM: " + (players.offenseList.get(0).getTeam()))),4,2);
		bradyPane.add(new Label(new String("Rushing Yards:  " + (players.offenseList.get(0).getRushYard()))),1,3);
		bradyPane.add(new Label(new String("Passing Yards: " + (players.offenseList.get(0).getPassYard()))),0,3);
		// buttons after viewing player
		Button bradyadd = new Button("Add to Roster");
		bradyPane.add(bradyadd, 0, 6);
		Button back2 = new Button("Return to Main Menu");
		bradyPane.add(back2, 1, 6);
		//buttons after adding to the roster
		Scene bradyScene = new Scene(bradyPane,500, 500);
		Button bradyRemove = new Button("Remove from roster");
		Button rosBack = new Button("Return to Main Menu");
		//action for clicking add to roster
		bradyadd.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e){
				bradyPane.getChildren().remove(bradyadd);
				bradyPane.add(bradyRemove, 0, 6);
				bradyPane.add(rosBack, 1, 7);
				rosPane.getChildren().remove(back1);
				rosPane.getChildren().add(bradyRos);
				rosPane.getChildren().add(rosBack);
				primaryStage.setScene(rosScene);
				primaryStage.show();
				
			}
		});
		//Action for removing from roster
		bradyRemove.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				bradyPane.add(rosBack, 1, 7);
				bradyPane.getChildren().remove(bradyadd);
				bradyPane.add(bradyRemove, 0, 6);
				rosPane.getChildren().remove(back2);
				rosPane.getChildren().add(bradyRos);
				rosPane.getChildren().add(back2);
				primaryStage.setScene(rosScene);
				primaryStage.show();
				
			}
		});
		
		bradyRemove.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				bradyPane.getChildren().remove(rosBack);
				bradyPane.getChildren().remove(bradyRemove);
				bradyPane.add(bradyadd, 0, 6);
				rosPane.getChildren().remove(bradyRos);
				primaryStage.setScene(rosScene);
				primaryStage.show();
			}
		});
		
		bradyRos.setOnAction( new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				primaryStage.setScene(bradyScene);
				primaryStage.show();
			}
		});
		
		rosBack.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				primaryStage.setScene(mainScene);
				primaryStage.show();
			}
		});
		
		back2.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle (ActionEvent e) {
				primaryStage.setScene(mainScene);
				primaryStage.show();
			}
		});
		// New Player Scene
		GridPane riversPane = new GridPane();
		riversPane.setAlignment(Pos.TOP_LEFT);
		riversPane.setPadding(new Insets(10,10,10,10));
		riversPane.setHgap(20);
		riversPane.setVgap(20);
		
		Label riversName = new Label(new String(players.offenseList.get(1).getName()));
		riversName.setFont(impact);
		riversPane.add(riversName,0,0);
		riversPane.add(new Label(new String("Age: " + players.offenseList.get(1).getAge())),0,2);
		riversPane.add(new Label(new String(players.offenseList.get(1).getPosition())),0,1);
		riversPane.add(new Label(new String("# " + players.offenseList.get(1).getNumber())), 2, 1);
		riversPane.add(new Label(new String("HighSchool: " + players.offenseList.get(1).getHighschool())), 2, 2);
		riversPane.add(new Label(new String("College: " + players.offenseList.get(1).getCollege())), 1, 2);
		riversPane.add(new Label(new String("TEAM: " + (players.offenseList.get(1).getTeam()))),1,1);
		riversPane.add(new Label(new String("Seasons " + (players.offenseList.get(1).getExperience()))),3,1);
		riversPane.add(new Label(new String("Weight: " + (players.offenseList.get(1).getWeight()))),3,2);
		riversPane.add(new Label(new String("Height: " + (players.offenseList.get(1).getHeight()))),4,1);
		riversPane.add(new Label(new String("TEAM: " + (players.offenseList.get(1).getTeam()))),4,2);
		riversPane.add(new Label(new String("Rushing Yards:  " + (players.offenseList.get(1).getRushYard()))),1,3);
		riversPane.add(new Label(new String("Passing Yards: " + (players.offenseList.get(1).getPassYard()))),0,3);
		
		Button riversadd = new Button("Add to Roster");
		riversPane.add(riversadd, 0, 6);
		Button back3 = new Button("Return to Main Menu");
		riversPane.add(back3, 1, 6);
		
		Scene riversScene = new Scene(riversPane,500, 500);
		Button riversRemove = new Button("Remove from roster");
		
		
		riversadd.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e){
				riversPane.getChildren().remove(riversadd);
				riversPane.add(riversRemove, 0, 6);
				riversPane.add(rosBack, 1, 7);
				rosPane.getChildren().remove(back1);
				rosPane.getChildren().add(riversRos);
				rosPane.getChildren().add(rosBack);
				primaryStage.setScene(rosScene);
				primaryStage.show();
				
			}
		});
		
		riversRemove.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				riversPane.add(rosBack, 1, 7);
				riversPane.getChildren().remove(riversadd);
				riversPane.add(riversRemove, 0, 6);
				rosPane.getChildren().remove(back3);
				rosPane.getChildren().add(riversRos);
				rosPane.getChildren().add(back3);
				primaryStage.setScene(rosScene);
				primaryStage.show();
				
			}
		});
		
		riversRemove.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				riversPane.getChildren().remove(rosBack);
				riversPane.getChildren().remove(riversRemove);
				riversPane.add(riversadd, 0, 6);
				rosPane.getChildren().remove(riversRos);
				primaryStage.setScene(rosScene);
				primaryStage.show();
			}
		});
		
		riversRos.setOnAction( new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				primaryStage.setScene(riversScene);
				primaryStage.show();
			}
		});
		
		rosBack.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				primaryStage.setScene(rosScene);
				primaryStage.show();
			}
		});
		
		back3.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle (ActionEvent e) {
				primaryStage.setScene(mainScene);
				primaryStage.show();
			}
			});
		// New Player Scene
		GridPane huntPane = new GridPane();
		huntPane.setAlignment(Pos.TOP_LEFT);
		huntPane.setPadding(new Insets(10,10,10,10));
		huntPane.setHgap(20);
		huntPane.setVgap(20);
		
		Label huntName = new Label(new String(players.offenseList.get(2).getName()));
		huntName.setFont(impact);
		huntPane.add(huntName,0,0);
		huntPane.add(new Label(new String("Age: " + players.offenseList.get(2).getAge())),0,2);
		huntPane.add(new Label(new String(players.offenseList.get(2).getPosition())),0,1);
		huntPane.add(new Label(new String("# " + players.offenseList.get(2).getNumber())), 2, 1);
		huntPane.add(new Label(new String("HighSchool: " + players.offenseList.get(2).getHighschool())), 2, 2);
		huntPane.add(new Label(new String("College: " + players.offenseList.get(2).getCollege())), 1, 2);
		huntPane.add(new Label(new String("TEAM: " + (players.offenseList.get(2).getTeam()))),1,1);
		huntPane.add(new Label(new String("Seasons " + (players.offenseList.get(2).getExperience()))),3,1);
		huntPane.add(new Label(new String("Weight: " + (players.offenseList.get(2).getWeight()))),3,2);
		huntPane.add(new Label(new String("Height: " + (players.offenseList.get(2).getHeight()))),4,1);
		huntPane.add(new Label(new String("TEAM: " + (players.offenseList.get(2).getTeam()))),4,2);
		huntPane.add(new Label(new String("Rushing Yards:  " + (players.offenseList.get(2).getRushYard()))),1,3);
		huntPane.add(new Label(new String("Recieving Yards: " + (players.offenseList.get(2).getRecYard()))),0,3);
		
		Button huntadd = new Button("Add to Roster");
		huntPane.add(huntadd, 0, 6);
		Button back4 = new Button("Return to Main Menu");
		huntPane.add(back4, 1, 6);
		
		Scene huntScene = new Scene(huntPane,500, 500);
		Button huntRemove = new Button("Remove from roster");
		Button huntBack = new Button("Return to roster");
		
		huntadd.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e){
				huntPane.getChildren().remove(huntadd);
				huntPane.add(huntRemove, 0, 6);
				huntPane.add(rosBack, 1, 7);
				rosPane.getChildren().remove(back4);
				rosPane.getChildren().add(huntRos);
				rosPane.getChildren().add(rosBack);
				primaryStage.setScene(rosScene);
				primaryStage.show();
				
			}
		});
		
		huntRemove.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				huntPane.add(rosBack, 1, 7);
				huntPane.getChildren().remove(huntadd);
				huntPane.add(huntRemove, 0, 6);
				rosPane.getChildren().remove(back4);
				rosPane.getChildren().add(huntRos);
				rosPane.getChildren().add(back4);
				primaryStage.setScene(rosScene);
				primaryStage.show();
				
			}
		});
		
		huntRemove.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				huntPane.getChildren().remove(rosBack);
				huntPane.getChildren().remove(huntRemove);
				huntPane.add(huntadd, 0, 6);
				rosPane.getChildren().remove(huntRos);
				primaryStage.setScene(rosScene);
				primaryStage.show();
			}
		});
		
		huntRos.setOnAction( new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				primaryStage.setScene(huntScene);
				primaryStage.show();
			}
		});
		
		rosBack.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				primaryStage.setScene(rosScene);
				primaryStage.show();
			}
		});
		
		back4.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle (ActionEvent e) {
				primaryStage.setScene(mainScene);
				primaryStage.show();
			}
		});
	// new player scene
		
		GridPane gurlPane = new GridPane();
		gurlPane.setAlignment(Pos.TOP_LEFT);
		gurlPane.setPadding(new Insets(10,10,10,10));
		gurlPane.setHgap(20);
		gurlPane.setVgap(20);
		
		Label gurlName = new Label(new String(players.offenseList.get(3).getName()));
		gurlName.setFont(impact);
		gurlPane.add(gurlName,0,0);
		gurlPane.add(new Label(new String("Age: " + players.offenseList.get(3).getAge())),0,2);
		gurlPane.add(new Label(new String(players.offenseList.get(3).getPosition())),0,1);
		gurlPane.add(new Label(new String("# " + players.offenseList.get(3).getNumber())), 2, 1);
		gurlPane.add(new Label(new String("HighSchool: " + players.offenseList.get(3).getHighschool())), 2, 2);
		gurlPane.add(new Label(new String("College: " + players.offenseList.get(3).getCollege())), 1, 2);
		gurlPane.add(new Label(new String("Seasons " + (players.offenseList.get(3).getExperience()))),3,1);
		gurlPane.add(new Label(new String("Weight: " + (players.offenseList.get(3).getWeight()))),3,2);
		gurlPane.add(new Label(new String("Height: " + (players.offenseList.get(3).getHeight()))),4,1);
		gurlPane.add(new Label(new String("TEAM: " + (players.offenseList.get(3).getTeam()))),4,2);
		gurlPane.add(new Label(new String("Rushing Yards:  " + (players.offenseList.get(3).getRushYard()))),1,3);
		gurlPane.add(new Label(new String("Recieving Yards: " + (players.offenseList.get(3).getRecYard()))),0,3);
		
		Button gurladd = new Button("Add to Roster");
		gurlPane.add(gurladd, 0, 6);
		Button back5 = new Button("Return to Main Menu");
		gurlPane.add(back5, 1, 6);
		
		Scene gurlScene = new Scene(gurlPane,500, 500);
		Button gurlRemove = new Button("Remove from roster");
		Button gurlBack = new Button("Return to roster");
		
		gurladd.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e){
				gurlPane.getChildren().remove(gurladd);
				gurlPane.add(gurlRemove, 0, 6);
				gurlPane.add(rosBack, 1, 7);
				rosPane.getChildren().remove(back5);
				rosPane.getChildren().add(gurlRos);
				rosPane.getChildren().add(rosBack);
				primaryStage.setScene(rosScene);
				primaryStage.show();
				
			}
		});
		
		gurlRemove.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				gurlPane.add(rosBack, 1, 7);
				gurlPane.getChildren().remove(gurladd);
				gurlPane.add(gurlRemove, 0, 6);
				gurlPane.getChildren().remove(back5);
				gurlPane.getChildren().add(gurlRos);
				rosPane.getChildren().add(back5);
				primaryStage.setScene(rosScene);
				primaryStage.show();
				
			}
		});
		
		gurlRemove.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				gurlPane.getChildren().remove(rosBack);
				gurlPane.getChildren().remove(gurlRemove);
				gurlPane.add(gurladd, 0, 6);
				rosPane.getChildren().remove(gurlRos);
				primaryStage.setScene(rosScene);
				primaryStage.show();
			}
		});
		
		gurlRos.setOnAction( new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				primaryStage.setScene(gurlScene);
				primaryStage.show();
			}
		});
		
		rosBack.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				primaryStage.setScene(rosScene);
				primaryStage.show();
			}
		});
		
		back5.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle (ActionEvent e) {
				primaryStage.setScene(mainScene);
				primaryStage.show();
			}
		});
		// offensive player scene, adds all offensive players to the scene
		
		Pane offenseplayers = new VBox(25);
		offenseplayers.setPadding(new Insets(20,20,20,20));
		((VBox)offenseplayers).setAlignment(Pos.CENTER);
		
		Label offensetitle = new Label(new String ( "Select a player to see their stats"));
		offensetitle.setFont(impact);
		offenseplayers.getChildren().add(offensetitle);
		
		Button offensBrady = new Button(players.offenseList.get(0).getName());
		offenseplayers.getChildren().add(offensBrady);
		
		Button offensRivers = new Button(players.offenseList.get(1).getName());
		offenseplayers.getChildren().add(offensRivers);
		
		Button offensHunt = new Button(players.offenseList.get(2).getName());
		offenseplayers.getChildren().add(offensHunt);
		
		Button offensGurl = new Button (players.offenseList.get(3).getName());
		offenseplayers.getChildren().add(offensGurl);
		
		Button back12 = new Button("Return to Main Menu");
		back12.setAlignment(Pos.BOTTOM_RIGHT);
		offenseplayers.getChildren().add(back12);
		
		Scene offenseplayersScene = new Scene(offenseplayers, 500, 500);
		
		offensBrady.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				primaryStage.setScene(bradyScene);
				primaryStage.show();
			}
		});
		offensRivers.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				primaryStage.setScene(riversScene);
				primaryStage.show();
			}
		});
		offensHunt.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				primaryStage.setScene(huntScene);
				primaryStage.show();
			}
		});
		offensGurl.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				primaryStage.setScene(gurlScene);
				primaryStage.show();
			}
		});
		
		offense.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				primaryStage.setScene(offenseplayersScene);
				primaryStage.show();
			}
		});
		back12.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				primaryStage.setScene(mainScene);
				primaryStage.show();
			}
		});
		// Defense scene and each defensive players scenes
		GridPane brownPane = new GridPane();
		brownPane.setAlignment(Pos.TOP_LEFT);
		brownPane.setPadding(new Insets(10,10,10,10));
		brownPane.setHgap(20);
		brownPane.setVgap(20);
		
		Label brownName = new Label(new String(players.defenseList.get(0).getName()));
		brownName.setFont(impact);
		brownPane.add(brownName,0,0);
		brownPane.add(new Label(new String("Age: " + players.defenseList.get(0).getAge())),0,2);
		brownPane.add(new Label(new String(players.defenseList.get(0).getPosition())),0,1);
		brownPane.add(new Label(new String("# " + players.defenseList.get(0).getNumber())), 2, 1);
		brownPane.add(new Label(new String("HighSchool: " + players.defenseList.get(0).getHighschool())), 2, 2);
		brownPane.add(new Label(new String("College: " + players.defenseList.get(0).getCollege())), 1, 2);
		brownPane.add(new Label(new String("TEAM: " + (players.defenseList.get(0).getTeam()))),1,1);
		brownPane.add(new Label(new String("Seasons " + (players.defenseList.get(0).getExperience()))),3,1);
		brownPane.add(new Label(new String("Weight: " + (players.defenseList.get(0).getWeight()))),3,2);
		brownPane.add(new Label(new String("Height: " + (players.defenseList.get(0).getHeight()))),4,1);
		brownPane.add(new Label(new String("TEAM: " + (players.defenseList.get(0).getTeam()))),4,2);
		brownPane.add(new Label(new String("Interceptions:  " + (players.defenseList.get(0).getInterceptions()))),1,3);
		brownPane.add(new Label(new String("Tackles: " + (players.defenseList.get(0).getTackles()))),0,3);
		brownPane.add(new Label(new String("Sacks: " + (players.defenseList.get(0).getSacks()))), 2, 3);
		Button brownadd = new Button("Add to Roster");
		brownPane.add(brownadd, 0, 6);
		Button back6 = new Button("Return to Main Menu");
		brownPane.add(back6, 1, 6);
		
		Scene bownScene = new Scene(brownPane,500, 500);
		Button brownRemove = new Button("Remove from roster");
		Button brownBack = new Button("Return to roster");
		
		brownadd.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e){
				brownPane.getChildren().remove(brownadd);
				brownPane.add(brownRemove, 0, 6);
				brownPane.add(rosBack, 1, 7);
				rosPane.getChildren().remove(back6);
				rosPane.getChildren().add(brownRos);
				rosPane.getChildren().add(rosBack);
				primaryStage.setScene(rosScene);
				primaryStage.show();
				
			}
		});
		
		brownRemove.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				brownPane.add(rosBack, 1, 7);
				brownPane.getChildren().remove(brownadd);
				brownPane.add(brownRemove, 0, 6);
				rosPane.getChildren().remove(back6);
				rosPane.getChildren().add(brownRos);
				rosPane.getChildren().add(back6);
				primaryStage.setScene(rosScene);
				primaryStage.show();
				
			}
		});
		brownRemove.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				bradyPane.getChildren().remove(rosBack);
				bradyPane.getChildren().remove(brownRemove);
				bradyPane.add(brownadd, 0, 6);
				rosPane.getChildren().remove(brownRos);
				primaryStage.setScene(rosScene);
				primaryStage.show();
			}
		});
		
	
		
		brownRos.setOnAction( new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				primaryStage.setScene(bownScene);
				primaryStage.show();
			}
		});
		
		rosBack.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				primaryStage.setScene(rosScene);
				primaryStage.show();
			}
		});
		
		back6.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle (ActionEvent e) {
				primaryStage.setScene(mainScene);
				primaryStage.show();
			}
		});
		GridPane martinezPane = new GridPane();
		martinezPane.setAlignment(Pos.TOP_LEFT);
		martinezPane.setPadding(new Insets(10,10,10,10));
		martinezPane.setHgap(20);
		martinezPane.setVgap(20);
		
		Label martinezName = new Label(new String(players.defenseList.get(1).getName()));
		martinezName.setFont(impact);
		martinezPane.add(martinezName,0,0);
		martinezPane.add(new Label(new String("Age: " + players.defenseList.get(1).getAge())),0,2);
		martinezPane.add(new Label(new String(players.defenseList.get(1).getPosition())),0,1);
		martinezPane.add(new Label(new String("# " + players.defenseList.get(1).getNumber())), 2, 1);
		martinezPane.add(new Label(new String("HighSchool: " + players.defenseList.get(1).getHighschool())), 2, 2);
		martinezPane.add(new Label(new String("College: " + players.defenseList.get(1).getCollege())), 1, 2);
		martinezPane.add(new Label(new String("TEAM: " + (players.defenseList.get(1).getTeam()))),1,1);
		martinezPane.add(new Label(new String("Seasons " + (players.defenseList.get(1).getExperience()))),3,1);
		martinezPane.add(new Label(new String("Weight: " + (players.defenseList.get(1).getWeight()))),3,2);
		martinezPane.add(new Label(new String("Height: " + (players.defenseList.get(1).getHeight()))),4,1);
		martinezPane.add(new Label(new String("TEAM: " + (players.defenseList.get(1).getTeam()))),4,2);
		martinezPane.add(new Label(new String("Interceptions:  " + (players.defenseList.get(1).getInterceptions()))),1,3);
		martinezPane.add(new Label(new String("Tackles: " + (players.defenseList.get(1).getTackles()))),0,3);
		martinezPane.add(new Label(new String("Sacks: " + (players.defenseList.get(1).getSacks()))), 2, 3);
		Button martinezadd = new Button("Add to Roster");
		martinezPane.add(martinezadd, 0, 6);
		Button back7 = new Button("Return to Main Menu");
		martinezPane.add(back7, 1, 6);
		
		Scene martinezScene = new Scene(martinezPane,500, 500);
		Button martinezRemove = new Button("Remove from roster");
		Button martinezBack = new Button("Return to roster");
		
		martinezadd.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e){
				martinezPane.getChildren().remove(martinezadd);
				martinezPane.add(martinezRemove, 0, 6);
				martinezPane.add(rosBack, 1, 7);
				rosPane.getChildren().remove(back7);
				rosPane.getChildren().add(martinezRos);
				rosPane.getChildren().add(rosBack);
				primaryStage.setScene(rosScene);
				primaryStage.show();
				
			}
		});
		
		martinezRemove.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				martinezPane.add(rosBack, 1, 7);
				martinezPane.getChildren().remove(martinezadd);
				martinezPane.add(martinezRemove, 0, 6);
				rosPane.getChildren().remove(back7);
				rosPane.getChildren().add(martinezRos);
				rosPane.getChildren().add(back7);
				primaryStage.setScene(rosScene);
				primaryStage.show();
				
			}
		});
		martinezRemove.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				martinezPane.getChildren().remove(rosBack);
				martinezPane.getChildren().remove(martinezRemove);
				martinezPane.add(bradyadd, 0, 6);
				rosPane.getChildren().remove(martinezRos);
				primaryStage.setScene(rosScene);
				primaryStage.show();
			}
		});
	
		
		martinezRos.setOnAction( new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				primaryStage.setScene(martinezScene);
				primaryStage.show();
			}
		});
		
		rosBack.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				primaryStage.setScene(rosScene);
				primaryStage.show();
			}
		});
		
		back7.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle (ActionEvent e) {
				primaryStage.setScene(mainScene);
				primaryStage.show();
			}
		});
		
		Pane defenseplayers = new VBox(25);
		defenseplayers.setPadding(new Insets(20,20,20,20));
		((VBox)defenseplayers).setAlignment(Pos.CENTER);
		Scene defenseplayersScene = new Scene(defenseplayers, 500, 500);
		
		Label defensetitle = new Label(new String ( "Select a player to see their stats"));
		defensetitle.setFont(impact);
		defenseplayers.getChildren().add(defensetitle);
		
		Button defenseBrown = new Button(players.defenseList.get(0).getName());
		defenseplayers.getChildren().add(defenseBrown);
		
		Button defenseMartinez = new Button(players.defenseList.get(1).getName());
		defenseplayers.getChildren().add(defenseMartinez);
		
		Button back13 = new Button("Return to Main Menu");
		back13.setAlignment(Pos.BOTTOM_RIGHT);
		defenseplayers.getChildren().add(back13);
		
		defense.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				primaryStage.setScene(defenseplayersScene);
				primaryStage.show();
			}
		});
		back13.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				primaryStage.setScene(mainScene);
				primaryStage.show();
			}
		});
		
		defenseBrown.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				primaryStage.setScene(bownScene);
				primaryStage.show();
			}
		});
		
		defenseMartinez.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				primaryStage.setScene(martinezScene);
				primaryStage.show();
			}
			});
	}	
	}
	


