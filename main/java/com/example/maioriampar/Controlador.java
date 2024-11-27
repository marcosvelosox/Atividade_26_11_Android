package com.example.maioriampar;

public class Controlador {

    // Função para verificar o maior número entre dois
    public int verificarMaior(int num1, int num2) {
        return (num1 > num2) ? num1 : num2;
    }

    // Função para somar os números ímpares entre dois valores
    public int somarImpares(int num1, int num2) {
        int soma = 0;

        // Garantir que num1 seja o menor e num2 o maior
        if (num1 > num2) {
            int temp = num1;
            num1 = num2;
            num2 = temp;
        }

        // Somar os números ímpares entre num1 e num2
        for (int i = num1; i <= num2; i++) {
            if (i % 2 != 0) {
                soma += i;
            }
        }

        return soma;
    }
}
