package com.faubruzen.ui.controller;


import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import org.controlsfx.control.spreadsheet.GridBase;
import org.controlsfx.control.spreadsheet.SpreadsheetCell;
import org.controlsfx.control.spreadsheet.SpreadsheetCellType;
import org.controlsfx.control.spreadsheet.SpreadsheetView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.faobruzen.entity.Model;
import com.faobruzen.repository.ModelRepository;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;


@Component
public class ShellController implements Initializable{
	

	private final ModelRepository repository;
	
	@FXML
	private Button btnAdd;
	
	@FXML
	private Button btnSave;
	
	@FXML
	private TableView<Model> tblModel;
	
	@FXML
	private TableColumn<Model, String> colName;
	
	@FXML
	private SpreadsheetView spreadsheet;
	
	private ObservableList<Model> models = null;
	private List<Model> list = null;
	
	@FXML
	public void OnAdd(ActionEvent e)
	{
		/*
		repository.save(new Model("fred"));
		repository.save(new Model("Steve"));
		*/
		models.add(new Model("Malcolm"));
	}
	
	@FXML
	public void onSave(ActionEvent e)
	{
		repository.save(list);
	}
	
	@Autowired
	public ShellController(ModelRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
		
		/* creating the database etc 
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Information Dialog");
		alert.setHeaderText("Look, an Information Dialog");
		alert.setContentText("I have a great message for you!");
		alert.showAndWait();			
		*/
		
		
		colName.setCellFactory(TextFieldTableCell.forTableColumn());
		colName.setCellValueFactory((e) -> new SimpleStringProperty(e.getValue().getName()));
		
		colName.setOnEditCommit(
			    new EventHandler<CellEditEvent<Model, String>>() {
			        @Override
			        public void handle(CellEditEvent<Model, String> t) {
			            ((Model) t.getTableView().getItems().get(
			                t.getTablePosition().getRow())
			                ).setName(t.getNewValue());
			        }
			    }
			);
		
		list = repository.findAll();
        models = FXCollections.observableList(list);
        tblModel.setItems(models);
        
        
        GridBase grid = new GridBase(7, 1);
       

        ObservableList<ObservableList<SpreadsheetCell>> rows = FXCollections.observableArrayList();
        for (int row = 0; row < grid.getRowCount(); ++row) {
            final ObservableList<SpreadsheetCell> list = FXCollections.observableArrayList();
            for (int column = 0; column < grid.getColumnCount(); ++column) {
                list.add(SpreadsheetCellType.STRING.createCell(row, column, 1, 1,"value"));
            }
            rows.add(list);
        }
        grid.setRows(rows);
        spreadsheet.setShowRowHeader(false);
        
        spreadsheet.setGrid(grid);        
        
    }

}
