package application;

import java.util.ArrayList;
import java.util.Collections;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MainController {
	//Fields
	@FXML private TextField txtName;
	@FXML private TextField txtAdd;
	@FXML private TextField txtGpa;
	@FXML private Button btnAdd;
	@FXML private Button btnSort;
	@FXML private Button btnDis;

	//Static arraylist to be accessed by SecondController.java
	static ArrayList<Student> arrList = new ArrayList<Student>();

	//Access methods when control clicked
	@FXML private void initialize() {
		btnAdd.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				addEntry();
			}
		});

		btnSort.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				sortEntry();
			}
		});

		btnDis.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent e) {
				display();
			}
		});
	}

	//Add elements to arraylist
	private void addEntry() {
		//Save elements from GUI to variables 
		String name = txtName.getText();
		String address = txtAdd.getText();
		double gpa = Double.parseDouble(txtGpa.getText());
		
		//Add elements into the arraylist
		this.arrList.add(new Student(name, address, gpa));
		
		//Print arraylist elements to the console
		for(Student s: arrList) {
			System.out.println(s);
		}
	}

	//Sort elements in the arraylist
	private void sortEntry() {
		System.out.println("Sort");
		
		Collections.sort(this.arrList);
		System.out.println(this.arrList);
		
	}
	
	//Display elements in a separate window 
	private void display() {
		System.out.println("Display");
		
		//Create new window
		Stage secondaryStage = new Stage(); 
		try {
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("Second.fxml"));
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			secondaryStage.setScene(scene);
			secondaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
