package com.universitaskuningan.modul2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int gajiStatus, gajiGolongan;
    RadioGroup golongan;
    CheckBox status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void calculate(View v) {
        EditText nama = findViewById(R.id.et_your_name);
        TextView outputNama = findViewById(R.id.et_output_name);
        TextView outputStatus = findViewById(R.id.et_output_status);
        TextView outputGolongan = findViewById(R.id.et_output_golongan);

        String name = nama.getText().toString();
        outputNama.setText(name);

        TextView hasilPerhitungan = findViewById(R.id.tv_calculate_result);
        hasilPerhitungan.setVisibility(View.VISIBLE);

        status = findViewById(R.id.cb_married);
        if (status.isChecked()) {
            gajiStatus = 500000;
            outputStatus.setText("Menikah");
        } else {
            gajiStatus = 0;
            outputStatus.setText("Single");
        }

        golongan = findViewById(R.id.rg_Golongan);
        int gol = golongan.getCheckedRadioButtonId();
        RadioButton selectedGolongan = findViewById(gol);
        if (gol == R.id.rb_Golongan1) {
            gajiGolongan = 1000000;
            outputGolongan.setText(selectedGolongan.getText());
        } else if (gol == R.id.rb_Golongan2) {
            gajiGolongan = 2000000;
            outputGolongan.setText(selectedGolongan.getText());
        }

        int totalGaji = gajiStatus + gajiGolongan;
        TextView total = findViewById(R.id.et_output_salary);
        total.setText(String.valueOf(totalGaji));
    }
}
