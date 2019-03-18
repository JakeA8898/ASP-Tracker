package asp_Tracker;



import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.shape.ClosePath;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.PathElement;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;


public class GUI extends Application {
	
	private static ASP_Data data = new ASP_Data();
	
	private static Label macNumbers;
	private static Label pcNumbers;
	private static Label tabletNumbers;
	private static Label smartphoneNumbers;
	private static Label printerNumbers;
	
	private static Label macASP;
	private static Label pcASP;
	private static Label tabletsASP;
	private static Label smartphonesASP;
	private static Label printersASP;
	
	private static Label liveASP;
	private static Label weeklyASP;
	
	
	public static void reset() {
		
		macASP.setText((data.calculate("Mac")).toString());
		pcASP.setText((data.calculate("PC")).toString());
		tabletsASP.setText((data.calculate("Tablets")).toString());
		smartphonesASP.setText((data.calculate("Smartphones")).toString());
		printersASP.setText((data.calculate("Printers")).toString());
		
		macNumbers.setText(Integer.toString(data.get("Mac")[0]));
		pcNumbers.setText(Integer.toString(data.get("PC")[0]));
		tabletNumbers.setText(Integer.toString(data.get("Tablets")[0]));
		smartphoneNumbers.setText(Integer.toString(data.get("Smartphones")[0]));
		printerNumbers.setText(Integer.toString(data.get("Printers")[0]));
		
		liveASP.setText(String.valueOf(data.calculate("Mac")+ data.calculate("PC") + data.calculate("Tablets") + 
				data.calculate("Smartphones") + data.calculate("Printers")));
		
		weeklyASP.setText(String.valueOf(data.calculate("MacW")+ data.calculate("PCW") + data.calculate("TabletW") + 
				data.calculate("SmartphoneW") + data.calculate("PrinterW")));
		
	}
	
	

	
	@Override
	public void start(Stage primaryStage) throws Exception{
		
		
		
		primaryStage.setTitle("ASP Tracker");
		ImageView parrot = new ImageView();
		//parrot image obtained from https://cultofthepartyparrot.com/
		parrot.setImage(new Image(this.getClass().getResource("/res/parrot.gif").toExternalForm()));
		parrot.setFitWidth(250);
		parrot.setFitHeight(250);
		Group test = new Group();
		int height = 400;
		int width = 550;
		
		
		AnchorPane ap = new AnchorPane();
		BorderPane layout = new BorderPane();
		HBox leftBox = new HBox(20);
		HBox bottomBox = new HBox(20);
		HBox topBox = new HBox(20);
		VBox centerBox = new VBox(20);
		
		layout.setStyle("-fx-background-color: #FFFFFF;");
		

		
		
		//left box start
		leftBox.setPadding(new Insets(20, 20, 20, 10));
		
		Text units = new Text("Units Sold");
		Text aspT = new Text("ASP");
		
		units.setFont(Font.font("Arial", FontWeight.BOLD, 14));
		aspT.setFont(Font.font("Arial", FontWeight.BOLD, 14));
		
		
		VBox unitType = new VBox(20);
		VBox unitsSold = new VBox(20);
		VBox unitASP = new VBox(20);
		
		Text unit = new Text("Unit");
		Text mac = new Text("Mac");
		Text pc = new Text("PC");
		Text tablets = new Text("Tablets");
		Text smartphones = new Text("Smartphones");
		Text printers = new Text("Printers");
		
		unitType.getChildren().addAll(unit,mac,pc,tablets,smartphones,printers);
		
		macNumbers = new Label(Integer.toString(data.get("Mac")[0]));
		pcNumbers = new Label(Integer.toString(data.get("PC")[0]));
		tabletNumbers = new Label(Integer.toString(data.get("Tablets")[0]));
		smartphoneNumbers = new Label(Integer.toString(data.get("Smartphones")[0]));
		printerNumbers = new Label(Integer.toString(data.get("Printers")[0]));
		
		unitsSold.getChildren().addAll(units,macNumbers,pcNumbers,tabletNumbers,smartphoneNumbers,printerNumbers);
		
		
		macASP = new Label((data.calculate("Mac")).toString());
		pcASP = new Label((data.calculate("PC")).toString());
		tabletsASP = new Label((data.calculate("Tablets")).toString());
		smartphonesASP = new Label((data.calculate("Smartphones")).toString());
		printersASP = new Label((data.calculate("Printers")).toString());
		
		
		
		
		unitASP.getChildren().addAll(aspT,macASP,pcASP,tabletsASP,smartphonesASP,printersASP);
		
		
		unit.setFont(Font.font("Arial", FontWeight.BOLD, 14));
		mac.setFont(Font.font("Arial", FontWeight.BOLD, 14));
		pc.setFont(Font.font("Arial", FontWeight.BOLD, 14));
		tablets.setFont(Font.font("Arial", FontWeight.BOLD, 14));
		smartphones.setFont(Font.font("Arial", FontWeight.BOLD, 14));
		printers.setFont(Font.font("Arial", FontWeight.BOLD, 14));
		
		
		leftBox.getChildren().addAll(unitType,unitsSold,unitASP);
		
		
		//left box end
		
		//center box start
		
		Text tASP = new Text("Daily ASP");
		tASP.setFont(Font.font("Arial", FontWeight.BOLD, 14));
		liveASP = new Label(String.valueOf(data.calculate("Mac")+ data.calculate("PC") + data.calculate("Tablets") + 
				data.calculate("Smartphones") + data.calculate("Printers")));
		Text week = new Text("Weekly ASP");
		week.setFont(Font.font("Arial",FontWeight.BOLD,14));
		
		weeklyASP = new Label(String.valueOf(data.calculate("MacW")+ data.calculate("PCW") + data.calculate("TabletW") + 
				data.calculate("SmartphoneW") + data.calculate("PrinterW")));
		
		

		
		centerBox.setAlignment(Pos.CENTER);
		centerBox.getChildren().addAll(tASP,liveASP,week,weeklyASP);
		
		
		//center box end
		
		//top box start
		Text asp = new Text("ASP Tracker");
		topBox.setPadding(new Insets(20,20,20,10));
		asp.setFont(Font.font("Arial", FontWeight.BOLD, 14));
		
		HBox radio = new HBox(20);
		ToggleGroup toggle = new ToggleGroup();
		RadioButton daily = new RadioButton("Daily");
		RadioButton weekly = new RadioButton("Weekly");
		daily.setToggleGroup(toggle);
		weekly.setToggleGroup(toggle);
		daily.setSelected(true);
		
		daily.setOnAction(e ->{
			
			//The calculated ASP of the current day
			macASP.setText((data.calculate("Mac")).toString());
			pcASP.setText((data.calculate("PC")).toString());
			tabletsASP.setText((data.calculate("Tablets")).toString());
			smartphonesASP.setText((data.calculate("Smartphones")).toString());
			printersASP.setText((data.calculate("Printers")).toString());
			
			//The number of items sold for the day
			macNumbers.setText(Integer.toString(data.get("Mac")[0]));
			pcNumbers.setText(Integer.toString(data.get("PC")[0]));
			tabletNumbers.setText(Integer.toString(data.get("Tablets")[0]));
			smartphoneNumbers.setText(Integer.toString(data.get("Smartphones")[0]));
			printerNumbers.setText(Integer.toString(data.get("Mac")[0]));
			
		});
		
		weekly.setOnAction(e-> {
			
			//The calculated ASP number for weekly
			macASP.setText((data.calculate("MacW")).toString());
			pcASP.setText((data.calculate("PCW")).toString());
			tabletsASP.setText((data.calculate("TabletW")).toString());
			smartphonesASP.setText((data.calculate("SmartphoneW")).toString());
			printersASP.setText((data.calculate("PrinterW")).toString());
			
			//The number of items sold in the week
			macNumbers.setText(Integer.toString(data.get("MacW")[0]));
			pcNumbers.setText(Integer.toString(data.get("PCW")[0]));
			tabletNumbers.setText(Integer.toString(data.get("TabletW")[0]));
			smartphoneNumbers.setText(Integer.toString(data.get("SmartphoneW")[0]));
			printerNumbers.setText(Integer.toString(data.get("PrinterW")[0]));
			
		});
		
		radio.getChildren().addAll(daily,weekly);
		
		Region region1 = new Region();
		HBox.setHgrow(region1, Priority.ALWAYS);
		
		
		topBox.getChildren().addAll(asp,region1,radio);
		//top box end
		
		//Bottom Box start
		bottomBox.setPadding(new Insets(20, 20, 20, 20));
		ChoiceBox<String> choice = new ChoiceBox<>();
		choice.getItems().addAll("-Select-","Mac","PC","Tablets","Smartphones","Printers");
		choice.setValue("-Select-");
		bottomBox.getChildren().add(choice);
		
		Spinner<Integer> spinner = new Spinner<Integer>();
		SpinnerValueFactory<Integer> value = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 99, 0);
		spinner.setValueFactory(value);
		spinner.setMaxWidth(55);
		bottomBox.getChildren().add(spinner);
		
		Button addButton = new Button();
		Button customInput = new Button();
		Button resetButton = new Button();
		addButton.setText("Add Sale");
		customInput.setText("Custom Input");
		resetButton.setText("Reset");
		bottomBox.getChildren().addAll(addButton,customInput,resetButton);
		
		//paths
		//animation for the parrot
		Path line = new Path();
		PathElement[] path = {new MoveTo(width/2,height + 250), new LineTo(width/2,-250),new ClosePath()};
		line.getElements().addAll(path);
		line.setStrokeWidth(0);
		PathTransition anim = new PathTransition();
		anim.setNode(parrot);
		anim.setPath(line);
	    anim.setDuration(new Duration(9500));
	    anim.setOnFinished(e -> {
	    	ap.getChildren().remove(test);
	    });
	    anim.setCycleCount(1);
	    test.getChildren().addAll(parrot,line);
		
		//paths end
		
		//Add button
		addButton.setOnAction(e -> {
			if(choice.getValue() != "-Select-") {
				if(choice.getValue() == "Mac") {
					data.add("Mac", (int) spinner.getValue());
					data.add("MacW", (int) spinner.getValue());
					if(daily.isSelected()) {
						macASP.setText((data.calculate("Mac")).toString());
						macNumbers.setText(Integer.toString(data.get("Mac")[0]));
					}else {
						macASP.setText((data.calculate("MacW")).toString());
						macNumbers.setText(Integer.toString(data.get("MacW")[0]));
					}
					
				}else if(choice.getValue() == "PC") {
					data.add("PC", (int) spinner.getValue());
					data.add("PCW", (int) spinner.getValue());
					if(daily.isSelected()) {
						pcASP.setText((data.calculate("PC")).toString());
						pcNumbers.setText(Integer.toString(data.get("PC")[0]));
					}else {
						pcASP.setText((data.calculate("PCW")).toString());
						pcNumbers.setText(Integer.toString(data.get("PCW")[0]));
					}
					
				}else if(choice.getValue() == "Tablets") {
					data.add("Tablets", (int) spinner.getValue());
					data.add("TabletW", (int) spinner.getValue());
					if(daily.isSelected()) {
						tabletsASP.setText((data.calculate("Tablets")).toString());
						tabletNumbers.setText(Integer.toString(data.get("Tablets")[0]));
					}else {
						tabletsASP.setText((data.calculate("TabletW")).toString());
						tabletNumbers.setText(Integer.toString(data.get("TabletW")[0]));
					}
					
				}else if(choice.getValue() == "Smartphones") {
					data.add("Smartphones", (int) spinner.getValue());
					data.add("SmartphoneW", (int) spinner.getValue());
					if(daily.isSelected()) {
						smartphonesASP.setText((data.calculate("Smartphones")).toString());
						smartphoneNumbers.setText(Integer.toString(data.get("Smartphones")[0]));
					}else {
						smartphonesASP.setText((data.calculate("SmartphoneW")).toString());
						smartphoneNumbers.setText(Integer.toString(data.get("SmartphoneW")[0]));
					}
					
				}else if(choice.getValue() == "Printers") {
					data.add("Printers", (int) spinner.getValue());
					data.add("PrinterW", (int) spinner.getValue());
					if(daily.isSelected()) {
						printersASP.setText((data.calculate("Printers")).toString());
						printerNumbers.setText(Integer.toString(data.get("Printers")[0]));
					}else {
						printersASP.setText((data.calculate("PrinterW")).toString());
						printerNumbers.setText(Integer.toString(data.get("PrinterW")[0]));
					}
					
				
					
				}
				
				liveASP.setText(String.valueOf(data.calculate("Mac")+ data.calculate("PC") + data.calculate("Tablets") + 
						data.calculate("Smartphones") + data.calculate("Printers")));
				
				weeklyASP.setText(String.valueOf(data.calculate("MacW")+ data.calculate("PCW") + data.calculate("TabletW") + 
						data.calculate("SmartphoneW") + data.calculate("PrinterW")));
				
				if(spinner.getValue() >7) {
					
					
					parrot.setTranslateX(1);
					parrot.setTranslateY(1);
					
					
					ap.getChildren().addAll(test);
					anim.play();
					
				}
				spinner.getValueFactory().setValue(0);
				choice.setValue("-Select-");
				
				
			}else {
				System.out.println("Error");
			}
		});
		
		//reset button
		resetButton.setOnAction(e -> {
			AlertBox.confirmbox(data);
			macASP.setText((data.calculate("Mac")).toString());
			pcASP.setText((data.calculate("PC")).toString());
			tabletsASP.setText((data.calculate("Tablets")).toString());
			smartphonesASP.setText((data.calculate("Smartphones")).toString());
			printersASP.setText((data.calculate("Printers")).toString());
			
			macNumbers.setText(Integer.toString(data.get("Mac")[0]));
			pcNumbers.setText(Integer.toString(data.get("PC")[0]));
			tabletNumbers.setText(Integer.toString(data.get("Tablets")[0]));
			smartphoneNumbers.setText(Integer.toString(data.get("Smartphones")[0]));
			printerNumbers.setText(Integer.toString(data.get("Printers")[0]));
			
			liveASP.setText(String.valueOf(data.calculate("Mac")+ data.calculate("PC") + data.calculate("Tablets") + 
					data.calculate("Smartphones") + data.calculate("Printers")));
			
			weeklyASP.setText(String.valueOf(data.calculate("MacW")+ data.calculate("PCW") + data.calculate("TabletW") + 
					data.calculate("SmartphoneW") + data.calculate("PrinterW")));
		});
		
		//custom input button
		customInput.setOnAction(e -> {
			CustomBox.customInput(data);
			if(daily.isSelected()) {
				macASP.setText((data.calculate("Mac")).toString());
				pcASP.setText((data.calculate("PC")).toString());
				tabletsASP.setText((data.calculate("Tablets")).toString());
				smartphonesASP.setText((data.calculate("Smartphones")).toString());
				printersASP.setText((data.calculate("Printers")).toString());
				
				macNumbers.setText(Integer.toString(data.get("Mac")[0]));
				pcNumbers.setText(Integer.toString(data.get("PC")[0]));
				tabletNumbers.setText(Integer.toString(data.get("Tablets")[0]));
				smartphoneNumbers.setText(Integer.toString(data.get("Smartphones")[0]));
				printerNumbers.setText(Integer.toString(data.get("Printers")[0]));
			}else {
				macASP.setText((data.calculate("MacW")).toString());
				pcASP.setText((data.calculate("PCW")).toString());
				tabletsASP.setText((data.calculate("TabletW")).toString());
				smartphonesASP.setText((data.calculate("SmartphoneW")).toString());
				printersASP.setText((data.calculate("PrinterW")).toString());
				
				macNumbers.setText(Integer.toString(data.get("MacW")[0]));
				pcNumbers.setText(Integer.toString(data.get("PCW")[0]));
				tabletNumbers.setText(Integer.toString(data.get("TabletW")[0]));
				smartphoneNumbers.setText(Integer.toString(data.get("SmartphoneW")[0]));
				printerNumbers.setText(Integer.toString(data.get("PrinterW")[0]));
			}
			
			
			liveASP.setText(String.valueOf(data.calculate("Mac")+ data.calculate("PC") + data.calculate("Tablets") + 
					data.calculate("Smartphones") + data.calculate("Printers")));
			
			weeklyASP.setText(String.valueOf(data.calculate("MacW")+ data.calculate("PCW") + data.calculate("TabletW") + 
					data.calculate("SmartphoneW") + data.calculate("PrinterW")));
		});
		//bottom box end
		
		
		
		
		
		
		layout.setTop(topBox);
		layout.setLeft(leftBox);
		layout.setBottom(bottomBox);
		layout.setCenter(centerBox);
		AnchorPane.setBottomAnchor(layout, 0.0);
		AnchorPane.setLeftAnchor(layout, 0.0);
		AnchorPane.setRightAnchor(layout, 0.0);
		AnchorPane.setTopAnchor(layout, 0.0);
		
		
		
		ap.getChildren().addAll(layout);
		Scene scene = new Scene(ap,width,height);
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();
		//@SuppressWarnings("unused")
		//ResetTimer timer = new ResetTimer(data);

	}
	
	
	
	public static void main(String[] args) {
		launch(args);

	}
	
	

}


