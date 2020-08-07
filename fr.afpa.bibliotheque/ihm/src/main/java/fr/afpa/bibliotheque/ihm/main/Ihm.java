package fr.afpa.bibliotheque.ihm.main;




import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Ihm extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
			Group root = new Group();
			primaryStage.setTitle("Bibliothèque");
	        primaryStage.getIcons().add(new Image("img/Bibliothèque.png"));
	        primaryStage.setMaximized(true);
			
			//scene login
			Scene login = new Scene(root);
			primaryStage.setScene(login);
			GridPane grid = new GridPane();
			grid.setHgap(10);
			grid.setVgap(10);
			
			ImageView iv = new ImageView("img/Enchanting_Table.gif");
			grid.add(iv,0,0,2,1);
			
			Label userName = new Label("Nom d'utilisateur :");
			grid.add(userName, 0, 1);

			TextField userTextField = new TextField();
			grid.add(userTextField, 1, 1);

			Label pw = new Label("Mot de passe :");
			grid.add(pw, 0, 2);

			PasswordField pwBox = new PasswordField();
			grid.add(pwBox, 1, 2);
			
			Button btn = new Button("Sign in");
			HBox hbBtn = new HBox(10);
			hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
			hbBtn.getChildren().add(btn);
			grid.add(hbBtn, 1, 4);
			
			root.getChildren().addAll(grid);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void startIhm() {
		launch();
	}
}
