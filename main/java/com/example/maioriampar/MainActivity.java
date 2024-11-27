package com.example.seuprojeto;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;  // Certifique-se de importar AppCompatActivity

import com.example.maioriampar.Controlador;
import com.example.myapplication.R;

public class MainActivity extends AppCompatActivity {
    private EditText editText1, editText2;
    private TextView resultTextView, sumTextView;
    private Button maiorButton, somarButton;
    private Controlador controlador;  // Referência para a classe de controle

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);  // Define o layout da activity

        // Inicialização dos componentes da interface
        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);
        resultTextView = findViewById(R.id.resultTextView);
        sumTextView = findViewById(R.id.sumTextView);
        maiorButton = findViewById(R.id.maiorButton);
        somarButton = findViewById(R.id.somarButton);

        controlador = new Controlador();  // Instancia a classe Controlador

        // Ação para o botão "Verificar Maior Número"
        maiorButton.setOnClickListener(v -> {
            try {
                int num1 = Integer.parseInt(editText1.getText().toString());
                int num2 = Integer.parseInt(editText2.getText().toString());
                int maior = controlador.verificarMaior(num1, num2);
                resultTextView.setText("Maior: " + maior);
            } catch (NumberFormatException e) {
                resultTextView.setText("Por favor, insira números válidos.");
            }
        });

        // Ação para o botão "Somar Números Ímpares"
        somarButton.setOnClickListener(v -> {
            try {
                int num1 = Integer.parseInt(editText1.getText().toString());
                int num2 = Integer.parseInt(editText2.getText().toString());
                int somaImpares = controlador.somarImpares(num1, num2);
                sumTextView.setText("Soma dos números ímpares: " + somaImpares);
            } catch (NumberFormatException e) {
                sumTextView.setText("Por favor, insira números válidos.");
            }
        });
    }
}
