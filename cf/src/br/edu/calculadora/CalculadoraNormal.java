package br.edu.calculadora;

import br.edu.calculadora.telas.TelaCalculadora;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JLabel;
import javax.swing.JTextField;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Alunos
 */
public class CalculadoraNormal {

    private javax.swing.JTextField display;
    protected double num1;
    protected double num2;
    protected Boolean selectNum2 = false;
    protected double res;
    protected String symbol;
    protected ArrayList<String> history = new ArrayList<String>();
    protected TelaCalculadora telaCalculadora;

    public String isNotDivZero = "Não é possivel dividir por 0";

    public Boolean checkEnabledButtons() {
        return getDisplayText().equals("NaN") || getDisplayText().equals(isNotDivZero) || getDisplayText().equals("Infinity");
    }

    public String getDisplayText() {
        return display.getText();
    }

    public void setDisplayText(String str) {
        display.setText(str);
    }

    public void resetButtonsEnabledDisplayFont(String number) {
        setDisplayText(number);
        display.setFont(new Font("Dialog", Font.BOLD, 32));
    }

    public void onChangeDisplay() {
        try {
            if (getDisplayText().length() > 16) {
                String displayText = getDisplayText().replace(",", ".");

                BigDecimal number = new BigDecimal(displayText);

                if (number.compareTo(BigDecimal.ZERO) != 0) {
                    int exponent = number.precision() - number.scale() - 1;
                    BigDecimal scientificNumber = number.movePointLeft(exponent).setScale(2, RoundingMode.HALF_UP);
                    setDisplayText(scientificNumber + "x10^" + exponent);
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Erro ao converter número: " + e.getMessage());
        }
    }

    public double tranformNumToScientificNotation(String input) {
        Pattern pattern = Pattern.compile("([\\d\\.]+)x10\\^(-?\\d+)");
        Matcher matcher = pattern.matcher(input);

        if (matcher.matches()) {
            BigDecimal base = new BigDecimal(matcher.group(1));
            int exponent = Integer.parseInt(matcher.group(2));
            return base.movePointRight(exponent).doubleValue();
        }

        return Double.parseDouble(input.replace(",", "."));
    }

    public void onClickNumber(java.awt.event.ActionEvent e) {
        if (checkEnabledButtons()) {
            telaCalculadora.setEnabledIfDivZero(true);
            resetButtonsEnabledDisplayFont(e.getActionCommand());
        } else {
            if (getDisplayText().length() < 16) {
                String num;
                if (getDisplayText().equals("0")) {
                    num = e.getActionCommand();
                } else {
                    num = getDisplayText() + e.getActionCommand();
                }
                setDisplayText(num);
                onChangeDisplay();
            }

        }

    }

    public void onClickDelete() {
        if (checkEnabledButtons()) {
            telaCalculadora.setEnabledIfDivZero(true);
            resetButtonsEnabledDisplayFont("0");
        } else {
            String num = getDisplayText();
            if (!num.equals("")) {
                setDisplayText(num.length() == 1 ? "0" : num.substring(0, num.length() - 1));
            }
        }
    }

    public void onClickAC() {
        if (checkEnabledButtons()) {
            telaCalculadora.setEnabledIfDivZero(true);
            resetButtonsEnabledDisplayFont("0");
        }
        num1 = 0;
        num2 = 0;
        setDisplayText("0");
        display.setText("0");
    }

    public void onClickOperator(java.awt.event.ActionEvent e) {
        if (checkEnabledButtons()) {
            telaCalculadora.setEnabledIfDivZero(true);
            resetButtonsEnabledDisplayFont("0");
        } else {
            if (!getDisplayText().replaceAll(" ", "").equals("")) {
                String displayText = getDisplayText().replace(",", ".");
                num1 = tranformNumToScientificNotation(displayText);
                selectNum2 = false;
            }
            setDisplayText("");
            symbol = e.getActionCommand();
        }

    }

    public void onClickPoint(java.awt.event.ActionEvent e) {
        if (checkEnabledButtons()) {
            telaCalculadora.setEnabledIfDivZero(true);
            resetButtonsEnabledDisplayFont("0,");
        } else {
            onChangeDisplay();
            String num = "";
            if (getDisplayText().replaceAll(" ", "").equals("")) {
                num = "0,";
            } else if (!getDisplayText().contains(",")) {
                num = getDisplayText() + e.getActionCommand();
            } else {
                num = getDisplayText();
            }

            setDisplayText(num);
        }

    }

    public void onClickResult(java.awt.event.ActionEvent e) {
        if (!getDisplayText().replaceAll(" ", "").equals("") && !checkEnabledButtons()) {
            String displayText = getDisplayText().replace(",", ".");

            if (selectNum2) {
                num1 = tranformNumToScientificNotation(displayText);
            } else {
                num2 = tranformNumToScientificNotation(displayText);
                selectNum2 = true;
            }

            if (symbol != null) {
                switch (symbol) {
                    case "+":
                        res = num1 + num2;
                        break;
                    case "-":
                        res = num1 - num2;
                        break;
                    case "×":
                        res = num1 * num2;
                        break;
                    case "÷":
                        try {
                            if (selectNum2 && (int) num2 == 0) {
                                setDisplayText(isNotDivZero);
                                display.setText(isNotDivZero);
                                display.setFont(new Font("Dialog", Font.BOLD, 18));
                                telaCalculadora.setEnabledIfDivZero(false);
                            } else {
                                res = num1 / num2;
                            }
                        } catch (ArithmeticException err) {
                            setDisplayText(isNotDivZero);
                            display.setText(isNotDivZero);
                            display.setFont(new Font("Dialog", Font.BOLD, 18));
                            telaCalculadora.setEnabledIfDivZero(false);
                            err.printStackTrace();
                        }
                        break;
                    case "%":
                        res = (num1 * num2) / 100.0;
                        break;
                    default:
                        res = 0.0;
                }
                if (!checkEnabledButtons()) {
                    String result = String.format("%.2f", res);
                    if (result.endsWith("00")) {
                        result = String.format("%.0f", res);
                    }
                    if (result.length() > 16) {
                        setDisplayText(result);
                        onChangeDisplay();
                    } else {
                        setDisplayText(result);
                    }
                    if (!symbol.equals("")) {
                        history.add(num1 + " " + symbol + " " + num2 + " = " + res);
                    }
                }
            }
        } else {
            telaCalculadora.setEnabledIfDivZero(true);
            resetButtonsEnabledDisplayFont("0");
            num1 = 0;
            num2 = 0;
            symbol = "";
        }

    }

    public double somar() {
        res = num1 + num2;
        return res;
    }

    public double subtrair() {
        res = num1 - num2;
        return res;
    }

    public double multiplicar() {
        res = num1 * num2;
        return res;
    }

    public double dividir() {
        res = num1 / num2;
        return res;
    }

    public double porcentagem() {
        res = (num1 * num2) / 100.0;
        return res;
    }

    public JTextField getDisplay() {
        return display;
    }

    public ArrayList<String> getHistory() {
        return history;
    }

    public void setHistory(ArrayList<String> history) {
        this.history = history;
    }

    public void setTelaCalculadora(TelaCalculadora telaCalculadora) {
        this.telaCalculadora = telaCalculadora;
    }

    public void setDisplay(javax.swing.JTextField display) {
        this.display = display;
    }

    public double getNum1() {
        return num1;
    }

    public void setNum1(double num1) {
        this.num1 = num1;
    }

    public double getNum2() {
        return num2;
    }

    public void setNum2(double num2) {
        this.num2 = num2;
    }

    public double getRes() {
        return res;
    }

    public void setRes(double res) {
        this.res = res;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
}
