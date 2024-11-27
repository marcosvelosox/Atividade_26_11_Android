package com.example.numerosprimosapp;

public class Controlador {

    // Função para encontrar números primos em um intervalo
    public String encontrarPrimos(int num1, int num2) {
        StringBuilder primos = new StringBuilder();
        for (int i = num1; i <= num2; i++) {
            if (isPrimo(i)) {
                primos.append(i).append(" ");
            }
        }
        return primos.toString().isEmpty() ? "Nenhum número primo encontrado." : primos.toString();
    }

    // Função para verificar se um número é primo
    private boolean isPrimo(int num) {
        if (num <= 1) return false; // Números menores ou iguais a 1 não são primos
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
