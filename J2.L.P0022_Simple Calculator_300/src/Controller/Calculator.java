/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.math.BigDecimal;
import javax.swing.JButton;
import javax.swing.JTextField;

/**
 *
 * @author TASS
 */
public class Calculator {

    private BigDecimal memory;
    private BigDecimal firstNumber;
    private BigDecimal secondNumber;
    private JTextField txt;
    private int operator;
    private boolean isProcessing;

    public Calculator(JTextField txt) {
        this.txt = txt;
        memory = new BigDecimal("0");
        firstNumber = new BigDecimal("0");
        secondNumber = new BigDecimal("0");
        operator = -1;
        isProcessing = false;
    }

    public void pressClear() {
        clearScreen();
        firstNumber = new BigDecimal("0");
        secondNumber = new BigDecimal("0");
        operator = -1;
        isProcessing = false;
    }

    public void pressNumber(int number) {
        if (isProcessing || isERROR()) {
            txt.setText(number + "");
            isProcessing = false;
        } else {
            BigDecimal temp = new BigDecimal(txt.getText() + number);
            txt.setText(temp + "");
        }

    }

    public void pressDot() {
        if (isProcessing) {
            txt.setText("0.");
            isProcessing = false;
        }

        if (!txt.getText().contains(".")) {
            txt.setText(txt.getText() + ".");
        }
    }

    public void pressNegate() {
        if (isERROR()) {
            txt.setText("-0");
        } else {
            txt.setText(getValueFromScreen().negate() + "");

        }
        isProcessing = false;
    }

    public void calculate() {
        if (!isProcessing) {
            secondNumber = getValueFromScreen();
            switch (operator) {
                case 1:
                    firstNumber = firstNumber.add(secondNumber);
                    break;
                case 2:
                    firstNumber = firstNumber.subtract(secondNumber);
                    break;
                case 3:
                    firstNumber = firstNumber.multiply(secondNumber);
                    break;
                case 4:
                    if (secondNumber.toString().equals("0")) {
                        txt.setText("ERROR");
                        isProcessing = false;
                        return;
                    } else {
                        firstNumber = firstNumber.divide(secondNumber);
                    }
                    break;
                default:
                    firstNumber = getValueFromScreen();
            }
            txt.setText(firstNumber + "");
            isProcessing = true;
        }

    }

    public void pressResult() {
        if (!isERROR()) {
            calculate();
            operator = -1;
        }
    }

    public void pressSqrt() {
        if (!isERROR()) {
            try {
                double value = getValueFromScreen().doubleValue();
                String valueString = Math.sqrt(value) + "";
                txt.setText(new BigDecimal(valueString).stripTrailingZeros() + "");
            } catch (Exception e) {
                txt.setText("ERROR");
            }
        } else {
            txt.setText("0");
        }
        isProcessing = true;
    }

    public void pressPercent() {
        if (!isERROR()) {
            try {
                BigDecimal bd100 = new BigDecimal("100");
                txt.setText(getValueFromScreen().divide(bd100) + "");
            } catch (Exception e) {
                txt.setText("ERROR");
            }
        } else {
            txt.setText("0");
        }
        isProcessing = true;
    }

    public void pressInverse() {
        if (!isERROR()) {
            try {
                BigDecimal bd1 = new BigDecimal("1");
                System.out.println(bd1.divide(getValueFromScreen()));
                txt.setText(bd1.divide(getValueFromScreen()) + "");
               
            } catch (Exception e) {
                txt.setText("ERROR");
                System.out.println(e.toString());
            }
        } else {
            txt.setText("0");
        }
        isProcessing = true;
    }

    //Get/Set
    private boolean isERROR() {
        return txt.getText().equalsIgnoreCase("ERROR");
    }

    private BigDecimal getValueFromScreen() {
        try {
            return new BigDecimal(txt.getText());
        } catch (Exception e) {
            return firstNumber;
        }
    }

    private void clearScreen() {
        txt.setText("0");
    }

    public void setOperator(int operator) {
        this.operator = operator;
    }

}
