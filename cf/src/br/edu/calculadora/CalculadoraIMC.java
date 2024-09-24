package br.edu.calculadora;

import javax.swing.JTextField;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Alunos
 */
public class CalculadoraIMC {

    private double altura;
    private double pesokg;
    private double imc;
    public String FaixaPeso = "0";

    public void calcularImc(String alturaMStr, String pesoKgStr) throws NumberFormatException {
        altura = Double.parseDouble(alturaMStr.replaceAll(",", "."));
        pesokg = Double.parseDouble(pesoKgStr);
        imc = pesokg / (Math.pow(altura, 2));

        if (imc < 16) {
            FaixaPeso = "Magreza grave";
        } else if (imc >= 16 && imc <= 16.9) {
            FaixaPeso = "Magreza moderada";
        } else if (imc >= 17 && imc <= 18.5) {
            FaixaPeso = "Magreza leve";
        } else if (imc >= 18.6 && imc <= 24.9) {
            FaixaPeso = "Peso ideal";
        } else if (imc >= 25 && imc <= 29.9) {
            FaixaPeso = "Sobrepeso";
        } else if (imc >= 30 && imc <= 34.9) {
            FaixaPeso = "Obesidade grau I";
        } else if (imc >= 35 && imc <= 39.9) {
            FaixaPeso = "Obesidade grau II ou severa";
        } else if (imc > 40) {
            FaixaPeso = "Obesidade grau III ou mórbida";
        }
    }

    public double getImc() {
        return imc;
    }

    public double getAltura() {
        return altura;
    }

    public double getPesokg() {
        return pesokg;
    }
}
