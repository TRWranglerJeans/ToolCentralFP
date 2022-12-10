package application;
/**
 * This class is the controller class that connects the GUI with the rest of the
 * logic of the application. The initial GUI is set, followed by the events upon pressing
 * buttons.
 * @author Masrur Azmal
 */

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class ShopController {
	
	Stage applicationStage;
	Application app;

    @FXML
    private Label welcomeLabel;
    
    @FXML
    private Label menuLabel;
    
    public ShopController() {
    	app = new Application();
    }

	/**
	 * The "List All Tools" button. It writes into the "Order.txt" file. Was unable 
	 * to add fully functioning file IO, and my previous logic failed so could not 
	 * implement it, but it will write into the existing Order.txt file.
	 */
    @FXML
    void listAllTools(ActionEvent event) throws IOException {
    	Scene mainScene = applicationStage.getScene();
    	applicationStage.setWidth(600);
    	applicationStage.setHeight(600);
    	
    	VBox toolsList = new VBox();
    	
    	BufferedWriter writer = new BufferedWriter(new FileWriter("Order.txt"));
    	ArrayList<Item> items = app.getTools();
    	String res = "";
    	for (int i = 0; i < items.size(); i++) {
    		res += items.get(i).tool() + "\n";
    	}
    	writer.write(res);
    	writer.close();
    	
    	Label toolsLabel = new Label(res);
    	
    	Button back = new Button("Back");
    	back.setOnAction(doneEvent -> applicationStage.setScene(mainScene));
    	
    	toolsList.getChildren().addAll(toolsLabel, back);
    	
    	Scene listAllTools = new Scene(toolsList);
    	applicationStage.setScene(listAllTools); 
    }

	/**
	 * The "Check Item Quantity" button. Displays the Quantity of items alongside names.
	 */
    @FXML
    void checkItemQuantity(ActionEvent event) {
    	Scene mainScene = applicationStage.getScene();
    	applicationStage.setWidth(600);
    	applicationStage.setHeight(600);
    	
    	VBox toolsList = new VBox();
    	
    	ArrayList<Item> items = app.getTools();
    	String res = "";
    	for (int i = 0; i < items.size(); i++) {
    		res += items.get(i).tool() + "Quantity: " + items.get(i).getQuantity() + "\n";
    	}
    	Label toolsLabel = new Label(res);
    	
    	Button back = new Button("Back");
    	back.setOnAction(doneEvent -> applicationStage.setScene(mainScene));
    	
    	toolsList.getChildren().addAll(toolsLabel, back);
    	
    	Scene listAllTools = new Scene(toolsList);
    	applicationStage.setScene(listAllTools); 
    	

    }

	/**
	 * The "Add Item" button. It will add the item and write it into Order.txt.
	 */
    @FXML
    void addAnItem(ActionEvent event) throws IOException {
        Scene mainScene = applicationStage.getScene();
    	applicationStage.setWidth(600);
    	applicationStage.setHeight(600);
        
    	VBox toolsList = new VBox();
    	Button back = new Button("Back");
    	back.setOnAction(doneEvent -> applicationStage.setScene(mainScene));
    	
    	Label toolsLabel = new Label("Please enter the name of the tool to add: ");
    	TextField toolsTextField = new TextField();
    	Label toolIDLabel = new Label("Please enter the ID of the tool to add: ");
    	TextField toolsIDTextField = new TextField();
    	Label toolsSuppIDLabel = new Label("Please enter the supplier's ID: ");
    	TextField toolsSuppIDTextField = new TextField();
    	
    	Button submit = new Button("Submit");
    	
    	Label itemAddedLabel = new Label();
    	
    	submit.setOnAction(someEvent ->{ 
    		int toolsID = Integer.parseInt(toolsIDTextField.getText());
    		int toolsSuppID = Integer.parseInt(toolsSuppIDTextField.getText());
    		app.getShop().addItem(toolsTextField.getText(), toolsID, toolsSuppID, 0, 0);
    		itemAddedLabel.setText("Item added!");
        	System.out.println(toolsTextField.getText());
        	BufferedWriter writer;
			try {
				writer = new BufferedWriter(new FileWriter("Order.txt"));
				writer.write(toolsTextField.getText() + "\n" + toolsID + "\n" + toolsSuppID);
				writer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		
    	});
    	
    	toolsList.getChildren().addAll(toolsLabel, toolsTextField, toolIDLabel, toolsIDTextField, toolsSuppIDLabel, toolsSuppIDTextField, itemAddedLabel, submit, back);
    	
    	Scene listAllTools = new Scene(toolsList);
    	applicationStage.setScene(listAllTools); 

    }

	/**
	 * The "Remove an Item" button. Removes the item name inputed by the user.
	 */
    @FXML
    void removeAnItem(ActionEvent event) {
    	Scene mainScene = applicationStage.getScene();
    	applicationStage.setWidth(600);
    	applicationStage.setHeight(600);
    	
    	VBox toolsList = new VBox();
    	
    	Label toolsLabel = new Label("Please enter the name of the tool to remove: ");
    	TextField toolsTextField = new TextField();
    	
    	Label itemRemovedLabel = new Label();
       	Button enter = new Button("Enter");
    	enter.setOnAction(someEvent ->{
    	app.getShop().removeTool(toolsTextField.getText());
    	itemRemovedLabel.setText("Item removed!");
    	});
    	
    	Button back = new Button("Back");
    	back.setOnAction(doneEvent -> applicationStage.setScene(mainScene));

    	toolsList.getChildren().addAll(toolsLabel, toolsTextField, itemRemovedLabel, enter, back);
    	
    	Scene listAllTools = new Scene(toolsList);
    	applicationStage.setScene(listAllTools); 

    }

	/**
	 * The "Search Tool Name" button. Matches the user's inputed name with the array list stored
	 * into the program containing the item information.
	 */
    @FXML
    void searchToolName(ActionEvent event) {
    	Scene mainScene = applicationStage.getScene();
    	applicationStage.setWidth(600);
    	applicationStage.setHeight(600);
    	
    	VBox toolsList = new VBox();
    	
    	Label toolsLabel = new Label("Please enter the name of the tool to search: ");
    	TextField toolsTextField = new TextField();
    	
    	Label itemFoundLabel = new Label();
     	Button enter = new Button("Enter");
    	enter.setOnAction(someEvent -> {
    	    String result = app.searchTool(toolsTextField.getText());
    		itemFoundLabel.setText(result);		
        });
    	
    	Button back = new Button("Back");
    	back.setOnAction(doneEvent -> applicationStage.setScene(mainScene));
    	
    	toolsList.getChildren().addAll(toolsLabel, toolsTextField, itemFoundLabel, enter, back);
    	
    	Scene listAllTools = new Scene(toolsList);
    	applicationStage.setScene(listAllTools); 

    }

	/**
	 * The "Search Tool ID" button. Matches inputed tool ID with the tool ID stored
	 * in the stored array list.
	 */
    @FXML
    void searchToolID(ActionEvent event) {
    	Scene mainScene = applicationStage.getScene();
    	applicationStage.setWidth(600);
    	applicationStage.setHeight(600);
    	
    	VBox toolsList = new VBox();
    
    	
    	Label toolsLabel = new Label("Please enter the tool ID to search: ");
    	TextField toolsTextField = new TextField();
    	
    	Label itemFoundLabel = new Label();
    	
     	Button enter = new Button("Enter");
    	enter.setOnAction(someEvent -> {
    		int toolsID = Integer.parseInt(toolsTextField.getText());
    	    String result = app.searchTool(toolsID);
    		itemFoundLabel.setText(result);		
        });
    	
    	Button back = new Button("Back");
    	back.setOnAction(doneEvent -> applicationStage.setScene(mainScene));
    	
    	toolsList.getChildren().addAll(toolsLabel, toolsTextField, itemFoundLabel, enter, back);
    	
    	Scene listAllTools = new Scene(toolsList);
    	applicationStage.setScene(listAllTools); 

    }

	/**
	 * The "Decrease Item Quantity" button. Takes away from the stored item quantity.
	 */
    @FXML
    void decreaseAnItem(ActionEvent event) {
    	Scene mainScene = applicationStage.getScene();
    	applicationStage.setWidth(600);
    	applicationStage.setHeight(600);
    	
    	VBox toolsList = new VBox();
    	Button back = new Button("Back");
    	back.setOnAction(doneEvent -> applicationStage.setScene(mainScene));
    	
    	Label toolsNameLabel = new Label("Please enter the name of the tool you want to decrease: ");
    	TextField toolsNameTextField = new TextField();
    	Label decreaseLabel =  new Label("Please enter the amount to decrease by: ");
    	TextField decreasedTextField = new TextField();
    	
    	Label itemDecreasedLabel = new Label();
    	
    	Button submit = new Button("Submit");
    	submit.setOnAction(someEvent -> {
    	
    	int quantity = Integer.parseInt(decreasedTextField.getText());
    	String result = app.decreaseQuantity(toolsNameTextField.getText(), quantity);
        System.out.println(result);
    	itemDecreasedLabel.setText(result);
    	});
    	toolsList.getChildren().addAll(toolsNameLabel, toolsNameTextField, decreaseLabel, decreasedTextField, itemDecreasedLabel, submit, back);
    	
    	Scene listAllTools = new Scene(toolsList);
    	applicationStage.setScene(listAllTools); 

    }
    
	/**
	 * The "Quit" button. Exits program.
	 */
    @FXML
    void quit(ActionEvent event) {
    	Platform.exit();
    }

}
