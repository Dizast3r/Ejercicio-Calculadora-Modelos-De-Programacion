package com.mycompany.ejerciciomodelos1;


class Calculadora {

    protected double num1;
    protected double num2;
    protected double resultado;

    // Constructor
    public Calculadora() {
        this.num1 = 0;
        this.num2 = 0;
        this.resultado = 0;
    }

    public void setNumeros(double num1, double num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    public void sumar() {
        resultado = num1 + num2;
    }

    // Método restar
    public void restar() {
        resultado = num1 - num2;
    }

    // Método convertir (para decimal no hace conversión, se deja para sobreescribirlo en la herencia :D)
    public String convertir() {
        return null;
    }

    // Método para convertir de cualquier base a decimal y hacer las operaciones
    protected double convertirADecimal(String numero, int base) {
        try {
            return Integer.parseInt(numero, base);
        } catch (NumberFormatException e) {
            System.out.println("Error: Número inválido para la base " + base);
            return 0;
        }
    }

    // Getters
    public double getResultado() {
        return this.resultado;
    }
}
