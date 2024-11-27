package com.example.numerosprimosapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

public class MainActivity extends AppCompatActivity {

    private EditText etNum1, etNum2;
    private Button btnCalcularPrimos, btnLimpar;
    private TextView tvErro, tvPrimos;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicializando os componentes
        etNum1 = findViewById(R.id.etNum1);
        etNum2 = findViewById(R.id.etNum2);
        btnCalcularPrimos = findViewById(R.id.btnCalcularPrimos);
        btnLimpar = findViewById(R.id.btnLimpar);
        tvErro = findViewById(R.id.tvErro);
        tvPrimos = findViewById(R.id.tvPrimos);

        // Ação do botão para calcular os primos
        btnCalcularPrimos.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                // Obter os números inseridos
                String num1Str = etNum1.getText().toString();
                String num2Str = etNum2.getText().toString();

                // Verificar se os campos não estão vazios
                if (num1Str.isEmpty() || num2Str.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Por favor, preencha ambos os campos.", Toast.LENGTH_SHORT).show();
                    return;
                }

                int num1 = Integer.parseInt(num1Str);
                int num2 = Integer.parseInt(num2Str);

                // Validar os números
                if (num1 < 0 || num2 > 50 || num1 > num2) {
                    tvErro.setText("Os números devem ser entre 0 e 50, com o primeiro menor ou igual ao segundo.");
                    tvErro.setVisibility(View.VISIBLE);
                    etNum1.setText("");
                    etNum2.setText("");
                    tvPrimos.setText("");
                    return;
                }

                tvErro.setVisibility(View.GONE); // Esconde o erro se a validação for bem-sucedida

                // Chama a operação para encontrar os números primos
                Controlador controlador = new Controlador();
                String primos = controlador.encontrarPrimos(num1, num2);

                // Exibe os números primos
                tvPrimos.setText(primos);
            }
        });

        // Ação do botão para limpar os campos
        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etNum1.setText("");
                etNum2.setText("");
                tvErro.setVisibility(View.GONE);
                tvPrimos.setText("");
            }
        });
    }
}
