package application;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.Writer;
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
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;

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
		
		Collections.sort(this.arrList);
		
		//Let user choose a file
		FileChooser chooser = new FileChooser();
		
		FileChooser.ExtensionFilter exFilter = new FileChooser.ExtensionFilter("TEXT files", "*.txt");		
		chooser.getExtensionFilters().add(exFilter);
		
		Window win = btnAdd.getScene().getWindow();
		File fileDesc = chooser.showOpenDialog(win);		
		
		//Write file using arraylist
		if(fileDesc != null) {
			PrintWriter writer = null;
			
			try {
				writer = new PrintWriter(fileDesc);
				
				for(Student s : this.arrList) {
					writer.print(s._fullName +"," +s._address +"," +s._gpa +"\n");
				}
				System.out.println("Write successful");
			}
			catch(FileNotFoundException e) {
				e.printStackTrace();
			}
			finally {
				if(writer != null) {
					writer.close();
				}
			}
		}
		else {
			System.out.println("File not found");
		}
		
		
		//Print arraylist elements to the console
		for(Student s: arrList) {
			System.out.println(s);
		}
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
