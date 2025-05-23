package com.example;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class HomeController implements Initializable {

    ObservableList<User> mylist = FXCollections.observableArrayList();
    
    @FXML
    Label usernameLabel;

    @FXML
    private TableColumn<User, String> accountColumn;

    @FXML
    private Button createButton;

    @FXML
    private Button deleteButton;

    @FXML
    private TableColumn<User, String> passwordColumn;

    @FXML
    private TextField passwordField;

    @FXML
    private ChoiceBox<String> statusChoice;

    @FXML
    private TableColumn<User, String> statusColumn;

    @FXML
    private TableView<User> table;

    @FXML
    private Button updateButton;

    @FXML
    private TableColumn<User, String> usernameColumn;

    @FXML
    private TextField usernameField;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initializeCol();
        loadData();

        statusChoice.getItems().addAll("Active", "Inactive");

        // TODO Auto-generated method stub
        String username = LoginController.user.getUsername();
        usernameLabel.setText(username);
    }

    private void initializeCol(){
        usernameColumn.setCellValueFactory(new PropertyValueFactory<>("username"));
        passwordColumn.setCellValueFactory(new PropertyValueFactory<>("password"));
        accountColumn.setCellValueFactory(new PropertyValueFactory<>("accountcreated"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("accountstatus"));
    }

    private void loadData(){

        mylist.clear();

        try {
            // Create object from File class
            File myFile = new File("accounts.txt");

            // .exists() method checks if a file exists in the pathname
            if (myFile.exists()) {

                Scanner filescanner = new Scanner(myFile);

                while (filescanner.hasNextLine()) {

                    String data = filescanner.nextLine();
        
                    String username = data.split(",")[0];
                    String password = data.split(",")[1];
                    String dcreated = data.split(",")[2];
                    String status = data.split(",")[3];

                    mylist.add(new User(username, password, dcreated, status));
                } 
                table.setItems(mylist);

                filescanner.close();
            }
            else {
                System.out.println(myFile.getName() + " does not exist!");
            }
        } catch (Exception e) {
            System.out.println("There is an error");
        } 
    }
}