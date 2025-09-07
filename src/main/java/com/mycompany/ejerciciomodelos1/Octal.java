package com.mycompany.ejerciciomodelos1;

class Octal extends Calculadora {

    public Octal() {
        super();
    }

    // Sobrescribir el método convertir para octal el metodo no existe en Double, toca hacer un casteo para el acceso al metodo
    @Override
    public String convertir() {
        return Integer.toOctalString((int) this.resultado);
    }

    // Método específico para establecer números octales a decimal para las operaciones
    public void setNumerosOctales(String num1Oct, String num2Oct) {
        this.num1 = convertirADecimal(num1Oct, 8);
        this.num2 = convertirADecimal(num2Oct, 8);
    }
}

