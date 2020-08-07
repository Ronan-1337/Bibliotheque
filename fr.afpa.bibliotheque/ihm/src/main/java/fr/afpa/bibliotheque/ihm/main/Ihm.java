package fr.afpa.bibliotheque.ihm.main;




import java.sql.Date;

import fr.afpa.bibliotheque.data.Utilisateur;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Ihm extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
			Utilisateur currentUser = new Utilisateur("invité", "invité");
			primaryStage.setTitle("Bibliothèque");
	        primaryStage.getIcons().add(new Image("img/Bibliothèque.png"));
			
			//scene login
			GridPane grd_login = new GridPane();
			Scene sc_login = new Scene(grd_login);
			grd_login.setHgap(10);
			grd_login.setVgap(10);
			grd_login.setPadding(new Insets(25,25,25,25));
			
			ImageView iv = new ImageView("img/Enchanting_Table.gif");
			grd_login.add(iv,0,0,2,1);
			
			Label userName = new Label("Nom d'utilisateur :");
			grd_login.add(userName, 0, 1);

			TextField userTextField = new TextField();
			grd_login.add(userTextField, 1, 1);

			Label pw = new Label("Mot de passe :");
			grd_login.add(pw, 0, 2);

			PasswordField pwBox = new PasswordField();
			grd_login.add(pwBox, 1, 2);
			
			Button credentialsConnectBtn = new Button("Connexion avec identifiants");
			grd_login.add(credentialsConnectBtn, 1, 4);
			
			Button guestConnectBtn = new Button("Connexion invité");
			grd_login.add(guestConnectBtn, 0, 4);
			
			Button testUserGetBtn = new Button("test du get de user");
			
			primaryStage.setScene(sc_login);
			primaryStage.show();
			
			//scene recherche
			GridPane grd_search = new GridPane();
			grd_search.setHgap(10);
			grd_search.setVgap(10);
			grd_search.setPadding(new Insets(25,25,25,25));
			Scene sc_search = new Scene(grd_search);
	
//			TextField searchTextField = new TextField();
//			searchTextField.setPromptText("Tapez votre recherche");
//			grd_search.add(searchTextField, 0, 1, 4, 1);

			// modif scene search pour tester get user
			Text testu = new Text();
			testu.setText(currentUser.toString());
			grd_search.add(testu, 0, 1, 4, 1);
			
			// action des bouttons
			guestConnectBtn.setOnAction(new EventHandler<ActionEvent>() {
				@Override
	            public void handle(ActionEvent e) {
					grd_search.add(iv,0,0,4,1);
					primaryStage.setScene(sc_search);
					primaryStage.setTitle("Bibliothèque - Recherche");
				}
			});
			
			testUserGetBtn.setOnAction(new EventHandler<ActionEvent>() {
				@Override
	            public void handle(ActionEvent e) {
					grd_search.add(iv,0,0,4,1);
					primaryStage.setScene(sc_search);
					primaryStage.setTitle("Bibliothèque - Recherche");
				}
			});
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void startIhm() {
		launch();
	}
}
