package com.faobruzen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;




import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

@SpringBootApplication
public class FalcodeApplication extends Application {
	
	 private ConfigurableApplicationContext springContext;
	 private Parent rootNode;
	 
	public static void main(String[] args) {
		
			Application.launch(args);
			//SpringApplication.run(FalcodeApplication.class, args);
	}	 
	
	@Override
	public void init() throws Exception {
		springContext = SpringApplication.run(FalcodeApplication.class);
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/Shell.fxml"));
		fxmlLoader.setControllerFactory(springContext::getBean);
		rootNode = fxmlLoader.load();
		//super.init();
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setScene(new Scene(rootNode));
		primaryStage.show();
	}
	
	@Override
	public void stop() throws Exception {
		springContext.close();
		
	}


}
