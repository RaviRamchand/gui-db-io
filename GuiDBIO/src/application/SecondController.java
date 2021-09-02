package application;

import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class SecondController {
	//Fields
	@FXML private TextArea _txtArea;
	
	@FXML private void initialize() {
		//Access static arrList from MainController and save it to a new arraylist
		ArrayList<Student> arrList = MainController.arrList;
		
		//Print elements from the arraylist to the textarea
		for(Student s : arrList) {
			this._txtArea.appendText(s +"\n");
		}
		
	}
}
