package org.example.testsql;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import model.User;
import service.UserService;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class UserController implements Initializable {
    @FXML
    private TableView<User> userTable;

    @FXML
    private TableColumn<User, Integer> idColumn;
    @FXML
    private TableColumn<User, String> usernameColumn;
    @FXML
    private TableColumn<User, String> passwordColumn;
    @FXML
    private TableColumn<User, String> emailColumn;
    @FXML
    private TableColumn<User, String> createdDataColumn;

    private ObservableList<User> listUsers;
    @FXML
    private TextField usernameText;
    @FXML
    private TextField passwordText;
    @FXML
    private TextField emailText;
    @FXML
    Button btnAdd;

    UserService userService = new UserService();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        usernameColumn.setCellValueFactory(new PropertyValueFactory<>("username"));
        passwordColumn.setCellValueFactory(new PropertyValueFactory<>("password"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        createdDataColumn.setCellValueFactory(new PropertyValueFactory<>("created_at"));

        listUsers = FXCollections.observableArrayList(userService.getAllUsers());
        userTable.setItems(listUsers);
    }
    public void addUser(ActionEvent event) {
        String username = usernameText.getText();
        String password = passwordText.getText();
        String email = emailText.getText();
        if (username.isEmpty() || password.isEmpty() || email.isEmpty()) {
            System.out.println("Please fill in all fields.");
            return;
        }
        User newUser = new User();
        newUser.setUsername(username);
        newUser.setPassword(password);
        newUser.setEmail(email);
        newUser.setCreated_at(LocalDate.now().toString());
        userService.addUser(newUser);

        ObservableList<User> listUsers = userTable.getItems();
        listUsers.add(newUser);
        userTable.refresh();


        usernameText.clear();
        passwordText.clear();
        emailText.clear();
    }
    @FXML
    public void deleteUser(ActionEvent event) {
        // Lấy người dùng được chọn
        User selectedUser = userTable.getSelectionModel().getSelectedItem();

        if (selectedUser != null) {
            // Hiển thị hộp thoại xác nhận xóa
            Alert confirmationAlert = new Alert(Alert.AlertType.CONFIRMATION);
            confirmationAlert.setTitle("Delete Confirmation");
            confirmationAlert.setHeaderText("Are you sure you want to delete this user?");
            confirmationAlert.setContentText("Username: " + selectedUser.getUsername());

            // Nếu người dùng xác nhận xóa
            if (confirmationAlert.showAndWait().get() == ButtonType.OK) {
//                userService.deleteUser(selectedUser.getId());
                listUsers.remove(selectedUser);
                userTable.refresh();
            }
        } else {
            // Nếu không có người dùng nào được chọn, hiển thị thông báo lỗi
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("No Selection");
            alert.setHeaderText("No User Selected");
            alert.setContentText("Please select a user in the table.");
            alert.showAndWait();
        }
    }
}
