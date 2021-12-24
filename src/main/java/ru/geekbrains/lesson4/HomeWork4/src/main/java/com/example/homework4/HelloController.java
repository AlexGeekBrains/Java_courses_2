package com.example.homework4;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;


public class HelloController {

    @FXML
    TextField textMessage;

    @FXML
    TextArea textArea;


    public void sendClick() {
        textArea.appendText(textMessage.getText() + "\n");
        textMessage.clear();
    }

    public void enter(KeyEvent e) {
        if (e.getCode() == KeyCode.ENTER) {
            sendClick();
        }
    }
}

