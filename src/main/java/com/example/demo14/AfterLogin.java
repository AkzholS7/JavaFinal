package com.example.demo14;


import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class AfterLogin {

    @FXML
    Button logOut;


    public void userLogOut() throws IOException {
        Main m = new Main();
        m.changeScene("sample.fxml");
    }
}
