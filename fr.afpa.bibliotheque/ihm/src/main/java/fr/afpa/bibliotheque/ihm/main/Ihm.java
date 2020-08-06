package fr.afpa.bibliotheque.ihm.main;




import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
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
			ImageView iv = new ImageView("img/Enchanting_Table.gif");
			GridPane grid = new GridPane();
			grid.setAlignment(Pos.CENTER);
			grid.add(iv,0,0,2,1);
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
