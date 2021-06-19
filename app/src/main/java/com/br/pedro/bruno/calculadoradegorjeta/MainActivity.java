package com.br.pedro.bruno.calculadoradegorjeta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editValor;
    private TextView txtPorcentagem,txtGorgeta,txtTotal;
    private SeekBar seekBarGorgeta;

    private double porcentangem = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editValor = findViewById(R.id.editVl);
        txtPorcentagem = findViewById(R.id.txtPorcentagem);
        txtGorgeta = findViewById(R.id.txtGorgeta);
        txtTotal = findViewById(R.id.txtTotal);
        seekBarGorgeta = findViewById(R.id.seekBarGorgeta);

        //Listener SeekBar

        seekBarGorgeta.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                porcentangem = progress;
                txtPorcentagem.setText(Math.round(porcentangem)+" %");
                calcular();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


    }
    public void calcular(){
        String valorRecuperado = editValor.getText().toString();

        if(valorRecuperado==null || valorRecuperado.equals("")){
            Toast.makeText(
                    getApplicationContext(),
                    "Digite um valor primeiro!!!",
                    Toast.LENGTH_LONG
            ).show();
        }else{

            double valorDigitado = Double.parseDouble(valorRecuperado);

            double gorgeta = valorDigitado * (porcentangem/100);

            txtGorgeta.setText("R$ "+Math.round(gorgeta));

            double total = valorDigitado + gorgeta;

            txtTotal.setText("R$ "+Math.round(total));

        }
    }
}