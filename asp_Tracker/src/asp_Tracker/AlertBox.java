package asp_Tracker;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AlertBox {
	
	public static void confirmbox(ASP_Data data){
		Stage window = new Stage();
		
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("Confirm Reset");
		window.setMinWidth(300);
		
		Label confirm = new Label();
		confirm.setText("Please confirm ASP Reset");
		
		Button confirmD = new Button();
		confirmD.setText("Reset Daily");
		
		Button confirmW = new Button();
		confirmW.setText("Reset Daily and Weekly");
		
		Button deny = new Button();
		deny.setText("Deny");
		
		deny.setOnAction(e->{
			window.close();
		});
		
		confirmD.setOnAction(e -> {
			data.reset();
			window.close();
		});
		
		confirmW.setOnAction(e -> {
			data.resetW();
			window.close();
		});
		
		VBox vbox = new VBox(20);
		HBox hbox = new HBox(20);
		
		hbox.getChildren().addAll(confirmD,confirmW,deny);
		hbox.setAlignment(Pos.CENTER);
		
		vbox.getChildren().addAll(confirm,hbox);
		vbox.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(vbox);
		window.setScene(scene);
		window.showAndWait();
		
		
		
		
		
		
	}

}
