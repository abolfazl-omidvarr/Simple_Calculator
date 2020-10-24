package calculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import java.net.URL;
import java.util.ResourceBundle;


public class Controller2 implements Initializable {


    @FXML
    private TextField calcmonb;
    @FXML
    private TextField calcmona;
    @FXML
    private Button btn1, btn2, btn3, btn4,
            btn5, btn6, btn7, btn8, btn9, btn0,
            btnp, btnm, btnpr, btnd, btneq,
            btndot, btncl, btnbac, btnplmi;

    private int state = 1; //1 = fist num 2 = second num 3 = loop
    private double result;
    private double starter;
    private String op;
    calculation calc = new calculation();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    @FXML
    private void digitbtn(ActionEvent actionEvent) {
        /*if(state == 4){
            calc.setB(Double.parseDouble(calcmonb.getText()));
        }else*/
        if (state == 1 || state == 3) {

            Button btn = (Button) actionEvent.getSource();
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
            calc.setA(Double.parseDouble(calcmonb.getText()));
        } else if (state == 2 || state == 4) {
            Button btn = (Button) actionEvent.getSource();
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
            calc.setB(Double.parseDouble(calcmonb.getText()));
        }
    }

    @FXML
    private void operators(ActionEvent actionEvent) {
        if (state == 3) {
            state = 4;
            calcmona.setText(result + " " + op);
            calc.setA(result);
            equals(actionEvent);


        }
        Button btn = (Button) actionEvent.getSource();
        op = btn.getText();
        calcmona.setText(calc.getA() + " " + op);
        calcmonb.setText("");
        if (calc.getB() == 0) starter = calc.getA();
        if (state == 3) starter = calc.getB();
        state = 2;

    }

    @FXML
    private void clr(ActionEvent actionEvent) {
        calc.setA(0);
        calc.setB(0);
        result = 0;
        starter = 0;
        calcmona.setText("");
        calcmonb.setText("0");
        state = 1;
    }

    @FXML
    private void equals(ActionEvent actionEvent) {
        if (calc.getB() == 0 & !(state == 1)) {

            double loopV = calc.getA();
            calcmona.setText(" = " + calc.loop1(loopV, starter, op));
            calc.setA(calc.loop1(loopV, starter, op));
        } else if (state == 3) {
            double loopV = result;
            starter = calc.getB();
            calcmona.setText(" = " + calc.loop1(loopV, starter, op));
            result = calc.loop1(loopV, starter, op);
        } else if (state == 1) {
            calcmona.setText(calc.getA() + " = " + calc.getA());
        } else {
            switchstat(op);
            String str = calcmona.getText();
            calcmona.setText(str + " " + calc.getB() + " = " + +result);
            calcmonb.setText("");
        }
    }

    @FXML
    private void switchstat(String op) {
        switch (op) {
            case "+" -> {
                result = calc.plus();
                state = 3;
            }
            case "-" -> {
                result = calc.minus();
                state = 3;
            }
            case "*" -> {
                result = calc.prod();
                state = 3;
            }
            case "/" -> {
                result = calc.devis();
                state = 3;
            }
        }
    }

    @FXML
    private void plusminus(ActionEvent actionEvent) {
        String str = calcmonb.getText();
        if (state == 1 ) {
            if (str.startsWith("-")) {
                str = str.substring(1);
                calcmonb.setText(str);
                calc.setA(Double.parseDouble(calcmonb.getText()));
            } else{
                if (str.equals("0")) {
                    calcmonb.setText("-");
                } else {
                    str = "-" + str;
                    calcmonb.setText(str);
                    calc.setA(Double.parseDouble(calcmonb.getText()));
                }
            }

        }
        if (state == 2 ) {
            if (str.startsWith("-")) {
                str = str.substring(1);
                calcmonb.setText(str);
                calc.setB(Double.parseDouble(calcmonb.getText()));
            } else{
                if (str.equals("0")) {
                    calcmonb.setText("-");
                } else {
                    str = "-" + str;
                    calcmonb.setText(str);
                    calc.setB(Double.parseDouble(calcmonb.getText()));
                }
            }
        }
    }
}

