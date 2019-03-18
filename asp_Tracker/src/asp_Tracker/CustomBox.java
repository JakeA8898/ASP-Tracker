package asp_Tracker;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class CustomBox {
	
	public static void customInput(ASP_Data data) {
		
		Stage window = new Stage();
		
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("Custom Input");
		window.setMinWidth(500);
		
		
		VBox vbox = new VBox(20);
		vbox.setPadding(new Insets(20,20,20,20));
		vbox.setStyle("-fx-background-color: #FFFFFF;");
		
		Label title = new Label("Custom Sale Input");
		title.setFont(Font.font("Arial", FontWeight.BOLD, 14));
		
		HBox vHolder = new HBox(20);
		
		VBox unitT = new VBox(30);
		VBox unitS = new VBox(20);
		VBox unitA = new VBox(20);
		
		Label macL = new Label("Mac");
		Label pcL = new Label("PC");
		Label tabletL = new Label("Tablets");
		Label smartphoneL = new Label("Smartphones");
		Label printerL = new Label("Printers");
		
		macL.setFont(Font.font("Arial", FontWeight.BOLD, 14));
		pcL.setFont(Font.font("Arial", FontWeight.BOLD, 14));
		tabletL.setFont(Font.font("Arial", FontWeight.BOLD, 14));
		smartphoneL.setFont(Font.font("Arial", FontWeight.BOLD, 14));
		printerL.setFont(Font.font("Arial", FontWeight.BOLD, 14));
		
		unitT.getChildren().addAll(macL,pcL,tabletL,smartphoneL,printerL);
		
		Spinner<Integer> macS = new Spinner<Integer>();
		Spinner<Integer> pcS = new Spinner<Integer>();
		Spinner<Integer> tabletS = new Spinner<Integer>();
		Spinner<Integer> smartphoneS = new Spinner<Integer>();
		Spinner<Integer> printerS = new Spinner<Integer>();
		
		SpinnerValueFactory<Integer> valueM = new SpinnerValueFactory.IntegerSpinnerValueFactory(-20, 99, 0);
		SpinnerValueFactory<Integer> valuePC = new SpinnerValueFactory.IntegerSpinnerValueFactory(-20, 99, 0);
		SpinnerValueFactory<Integer> valueT = new SpinnerValueFactory.IntegerSpinnerValueFactory(-20, 99, 0);
		SpinnerValueFactory<Integer> valueS = new SpinnerValueFactory.IntegerSpinnerValueFactory(-20, 99, 0);
		SpinnerValueFactory<Integer> valueP = new SpinnerValueFactory.IntegerSpinnerValueFactory(-20, 99, 0);
		
		macS.setValueFactory(valueM);
		pcS.setValueFactory(valuePC);
		tabletS.setValueFactory(valueT);
		smartphoneS.setValueFactory(valueS);
		printerS.setValueFactory(valueP);
		
		unitS.getChildren().addAll(macS,pcS,tabletS,smartphoneS,printerS);
		
		Spinner<Integer> macA = new Spinner<Integer>();
		Spinner<Integer> pcA = new Spinner<Integer>();
		Spinner<Integer> tabletA = new Spinner<Integer>();
		Spinner<Integer> smartphoneA = new Spinner<Integer>();
		Spinner<Integer> printerA = new Spinner<Integer>();
		
		SpinnerValueFactory<Integer> valueMA = new SpinnerValueFactory.IntegerSpinnerValueFactory(-20, 99, 0);
		SpinnerValueFactory<Integer> valuePCA = new SpinnerValueFactory.IntegerSpinnerValueFactory(-20, 99, 0);
		SpinnerValueFactory<Integer> valueTA = new SpinnerValueFactory.IntegerSpinnerValueFactory(-20, 99, 0);
		SpinnerValueFactory<Integer> valueSA = new SpinnerValueFactory.IntegerSpinnerValueFactory(-20, 99, 0);
		SpinnerValueFactory<Integer> valuePA = new SpinnerValueFactory.IntegerSpinnerValueFactory(-20, 99, 0);
		
		macA.setValueFactory(valueMA);
		pcA.setValueFactory(valuePCA);
		tabletA.setValueFactory(valueTA);
		smartphoneA.setValueFactory(valueSA);
		printerA.setValueFactory(valuePA);
		
		unitA.getChildren().addAll(macA,pcA,tabletA,smartphoneA,printerA);
		
		
		vHolder.getChildren().addAll(unitT,unitS,unitA);
		
		
		Button confirm = new Button();
		confirm.setText("Confirm");
		Button cancel = new Button();
		cancel.setText("Cancel");
		
		confirm.setOnAction(e -> {
			data.add("Mac", macS.getValue(), macA.getValue());
			data.add("PC", pcS.getValue(), pcA.getValue());
			data.add("Tablets", tabletS.getValue(), tabletA.getValue());
			data.add("Smartphones", smartphoneS.getValue(), smartphoneA.getValue());
			data.add("Printers", printerS.getValue(), printerA.getValue());
			
			data.add("MacW", macS.getValue(), macA.getValue());
			data.add("PCW", pcS.getValue(), pcA.getValue());
			data.add("TabletW", tabletS.getValue(), tabletA.getValue());
			data.add("SmartphoneW", smartphoneS.getValue(), smartphoneA.getValue());
			data.add("PrinterW", printerS.getValue(), printerA.getValue());
			window.close();
		});
		
		cancel.setOnAction(e -> window.close());
		
		HBox buttons = new HBox(20);
		buttons.getChildren().addAll(confirm,cancel);
		
		vbox.getChildren().addAll(title,vHolder,buttons);
		
		
		Scene scene = new Scene(vbox);
		window.setScene(scene);
		window.showAndWait();
		
		
	}

}
