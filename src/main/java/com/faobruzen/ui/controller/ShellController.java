package com.faobruzen.ui.controller;


import java.net.URL;
import java.util.ResourceBundle;

import org.springframework.stereotype.Component;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;


@Component
public class ShellController implements Initializable{
	

	@FXML
	Button btnTest;
	
	@FXML
	public void OnTest()
	{
		
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Information Dialog");
		alert.setHeaderText("Look, an Information Dialog");
		alert.setContentText("I have a great message for you!");
		alert.showAndWait();			

	}
	
	public ShellController() {
		
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
			

    }

}

