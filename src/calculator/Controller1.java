package calculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;


public class Controller1 implements Initializable {

    @Override
    public void initialize(URL location, ResourceBundle resources) {


    }
    private String state = "null";
    private String op = "";
    private double a;
    private double b;
    private double result;
    private String str2 = "";


    @FXML
    private TextField calcmonb;
    @FXML
    private TextField calcmona;
    @FXML
    private Button btn1,btn2,btn3,btn4,
            btn5,btn6,btn7,btn8,btn9,btn0,
            btnp,btnm,btnpr,btnd,btneq,
            btndot,btncl,btnbac;
    @FXML
    private void digitbtn(ActionEvent actionEvent) {
        Button btn = (Button) actionEvent.getSource();
        if (state.equals("operator") && btn == btndot) {

        } else if (calcmona.getText().contains("=") && !(btn == btndot)) {
            clr(actionEvent);
            calcmonb.setText(btn.getText());
        } else {
            String str = calcmonb.getText();
            if (str.equals("0") && !(btn == btndot)) str = "";
            if (btn == btndot) {
                if (!str.contains(".")) {
                    str = str + ".";
                }
            } else {
                str = str + btn.getText();
            }
            calcmonb.setText(str);
        }
    }



    @FXML
    private void operators(ActionEvent actionEvent) {
        state = "preeq";
        Button btn = (Button) actionEvent.getSource();
        op = btn.getText();
        if (calcmona.getText().contains("=")) {
            a = result;
            calcmona.setText(a + " " + btn.getText());


        } else {
            if (!(calcmona.getText().equals(""))) {
                calcmona.setText(str2 + " " + btn.getText());
            } else {
                str2 = calcmonb.getText();
                a = Double.parseDouble(calcmonb.getText());
                calcmona.setText(str2 + " " + btn.getText());
                calcmonb.setText("0");
            }
        }
    }




    @FXML
    private void equals(ActionEvent actionEvent) {
        if (calcmona.getText().contains("=")) {
            System.out.println("if 2");
            switch (op) {
                case "+" -> {
                    result += b;
                    calcmona.setText("on loop :  ans = " + result);
                }
                case "-" -> {
                    result -= b;
                    calcmona.setText("on loop :  ans = " + result);
                }
                case "*" -> {
                    result *= b;
                    calcmona.setText("on loop :  ans = " + result);
                }
                case "/" -> {
                    result /= b;
                    calcmona.setText("on loop :  ans = " + result);
                }
            }

        } else {
        b = Double.parseDouble(calcmonb.getText());
        String str ;
            switch (op) {
                case "+" -> {
                    result = a + b;
                    str = calcmona.getText() + " " + calcmonb.getText();
                    calcmona.setText(str + " = " + result);
                    calcmonb.setText("");
                }
                case "-" -> {
                    result = a - b;
                    str = calcmona.getText() + " " + calcmonb.getText();
                    calcmona.setText(str + " = " + result);
                    calcmonb.setText("");
                }
                case "*" -> {
                    result = a * b;
                    str = calcmona.getText() + " " + calcmonb.getText();
                    calcmona.setText(str + " = " + result);
                    calcmonb.setText("");
                }
                case "/" -> {
                    result = a / b;
                    str = calcmona.getText() + " " + calcmonb.getText();
                    calcmona.setText(str + " = " + result);
                    calcmonb.setText("");
                }
                case "" -> calcmona.setText(calcmonb.getText() + " = " + calcmonb.getText());
            }
        }
    }
    @FXML
    private void clr(ActionEvent actionEvent) {
        calcmonb.setText("0");
        calcmona.setText("");
        a = b = 0;
        result = 0;
        str2 = "";
        op = "";
        state = "null";
    }
    @FXML
    private void back(ActionEvent actionEvent) {
    }

}
