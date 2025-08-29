package com.mycompany.ejerciciomodelos1;


class Binario extends Calculadora {

    public Binario() {
        super();
    }

    // Sobrescribir el método convertir para binario con metodo propio de java (este metodo no existe con Double, toca hacer un casteo
    @Override
    public String convertir() {
        return Integer.toBinaryString((int) this.resultado);
    }

    // Método específico para establecer números binarios en decimal para operaciones
    public void setNumerosBinarios(String num1Bin, String num2Bin) {
        this.num1 = convertirADecimal(num1Bin, 2);
        this.num2 = convertirADecimal(num2Bin, 2);
    }
}
