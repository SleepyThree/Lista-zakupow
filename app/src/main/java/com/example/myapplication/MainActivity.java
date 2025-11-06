package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    String zwierze ="kot";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<String> zwierzeta = new ArrayList<>();
        zwierzeta.add("pies");
        zwierzeta.add("kot");
        zwierzeta.add("świnka morska");
        ListView listView = findViewById(R.id.listViewZwierzeta);
        SeekBar seekBar = findViewById(R.id.seekBar);
        Button buttonOk = findViewById(R.id.button);
        EditText editTextImieNazwisko = findViewById(R.id.editTextTextPersonName);
        EditText editTextCel = findViewById(R.id.editTextTextPersonName2);
        EditText editTextCzas = findViewById(R.id.editTextTime);
        TextView textViewWiek = findViewById(R.id.textView2);

        ArrayAdapter<String> arrayAdapter =new ArrayAdapter<>(
                MainActivity.this,
                android.R.layout.simple_list_item_1,
                zwierzeta);
        listView.setAdapter(arrayAdapter);
        int[]wiek = new int[]{18,20,9};
        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        Toast.makeText(MainActivity.this, "Kliknięto wiek "+wiek[i], Toast.LENGTH_SHORT).show();
                        seekBar.setMax(wiek[i]);
                        zwierze = zwierzeta.get(i);
                    }
                }
        );
        seekBar.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                        textViewWiek.setText("Ile ma lat? "+i);
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }
                }
        );
        buttonOk.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String komunikat = editTextImieNazwisko.getText().toString()
                                +", "+editTextCel.getText().toString()
                                +", "+zwierze;
                        Toast.makeText(MainActivity.this, komunikat, Toast.LENGTH_SHORT).show();
                    }
                }
        );
    }
}