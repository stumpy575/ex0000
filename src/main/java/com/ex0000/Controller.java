package com.ex0000;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Controller {

    @FXML
    private Button btnum0;

    @FXML
    private Button btnum1;

    @FXML
    private Button btnum2;

    @FXML
    private Button btnum3;

    @FXML
    private Button btnum4;
    
    @FXML
    private Button btnum5;
    
    @FXML
    private Button btnum6;
    
    @FXML
    private Button btnum7;
    
    @FXML
    private Button btnum8;
    
    @FXML
    private Button btnum9;
    
    @FXML
    private Button btfuncclear;
    
    @FXML
    private Button btfuncequals;

    
    @FXML
    private Button btfuncadd;

    @FXML
    private Button btfuncminus;
    
    @FXML
    private Button btfuncdiv;
    
    @FXML
    private Button btfuncmult;

    @FXML
    private Label calcscreen;

    private enum Func {ADD, MINUS, MULT, DIV, NULL};
    private Func func = Func.NULL;
    private int firstnum=0;
    private int secondnum=0;

    @FXML 
    private void addnum(ActionEvent event) {
        Button clickedButton = (Button) event.getSource();
        String buttonText = clickedButton.getText();
        if (func==Func.NULL) {
            firstnum = firstnum * 10 + Integer.parseInt(buttonText);
        } else {
            secondnum = secondnum * 10 + Integer.parseInt(buttonText);
        }
        calcscreen.setText(calcscreen.getText() + buttonText);
    }
    @FXML 
    private void addfunc(ActionEvent event) {
        Button clickedButton = (Button) event.getSource();
        String buttonText = "";
        String buttonFunc = clickedButton.getId();
        if (secondnum != 0) {
            calculate(); // si ja hi ha un segon numero fa el calcul i despres posa la funcio nova
        }
        switch (buttonFunc) {
            default:
                func = Func.NULL;
                break;
            case "btnfuncadd":
                buttonText = "+";
                func = Func.ADD;
                break;
            case "btnfuncminus":
                buttonText = "-";
                func = Func.MINUS;
                break;
            case "btnfuncmult":
                buttonText = "*";
                func = Func.MULT;
                break;
            case "btnfuncdiv":
                buttonText = "/";
                func = Func.DIV;
                break;
        }
        calcscreen.setText(calcscreen.getText() + buttonText);
    }
    @FXML
    private void clearcalc() {
        firstnum = 0;
        secondnum = 0;
        func = Func.NULL;
        calcscreen.setText("");
    }
    @FXML
    private void calculate() {
        int result = 0;
        switch (func) {
            case ADD:
                result = firstnum + secondnum;
                break;
            case MINUS:
                result = firstnum - secondnum;
                break;
            case MULT:
                result = firstnum * secondnum;
                break;
            case DIV:
                if (secondnum != 0) {
                    result = firstnum / secondnum;
                } else {
                    calcscreen.setText("no es pot dividir per 0");
                    return;
                }
                break;
            default:
                return;
        }
        calcscreen.setText(String.valueOf(result));
        firstnum = result; // desa el resultat com a primer numero per a fer mes calculs seguit d'aquest
        secondnum = 0; 
        func = Func.NULL; 
    }
}
