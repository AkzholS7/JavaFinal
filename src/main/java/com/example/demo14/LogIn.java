package com.example.demo14;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import java.sql.*;


import java.io.IOException;
public class LogIn {

    public LogIn() {

    }

    @FXML
    Button button;
    @FXML
    private Label wrongLogIn;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    Statement statement;
    Connection connection;


    public void userLogIn() throws IOException, SQLException {
        connect();
        checkLogin();
    }

    private void checkLogin() throws SQLException, IOException {
        Main m = new Main();
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String query = "SELECT * FROM users WHERE login = '" +  username.getText() + "'";
        ResultSet rs = statement.executeQuery(query);
        if(rs.next()){
            String password1 = rs.getString("password");
            if(password1.equals(password.getText())){
                m.changeScene("afterLogin.fxml");
            }
            else {
                wrongLogIn.setText("Incorrect password");
            }
        }else {
            wrongLogIn.setText("There is no user with this name");
        }
    }

    public void connect () {
        String jdbcURL = "jdbc:postgresql://localhost:5432/company";
        String username = "postgres";
        String password = "1234";
        try {
            connection = DriverManager.getConnection(jdbcURL,username,password);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}