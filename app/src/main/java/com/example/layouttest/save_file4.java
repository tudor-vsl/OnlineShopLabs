package com.example.layouttest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class save_file4 extends AppCompatActivity {
    private static final String FILE_NAME = "example.txt";
    EditText fileEditText;
    public static View aux_view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_file4);

        fileEditText = findViewById(R.id.idFileText);

        openDialog();

        Button saveBtn = findViewById(R.id.idSaveBtn);
        Button loadBtn = findViewById(R.id.idLoadBtn);

        saveBtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {

                save(view);
            }
        });

        loadBtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                load(view);
            }
        });
    }

    private void openDialog() {
        Dialog dialog = new Dialog();
        dialog.show(getSupportFragmentManager(), "example dialog");
    }

    public void save(View view){
        String txt = fileEditText.getText().toString();
        FileOutputStream FOS = null;

        try {
            FOS = openFileOutput(FILE_NAME, MODE_PRIVATE);
            FOS.write(txt.getBytes());
            fileEditText.getText().clear();
            Toast.makeText(this, "Saved to " + getFilesDir() + "/" + FILE_NAME, Toast.LENGTH_LONG).show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(FOS != null)
            {
                try {
                    FOS.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public void load(View view){
        FileInputStream FIS = null;

        try {
            FIS = openFileInput(FILE_NAME);
            InputStreamReader ISR = new InputStreamReader(FIS);
            BufferedReader br = new BufferedReader(ISR);
            StringBuilder sb = new StringBuilder();
            String text;

            while((text = br.readLine()) != null){
                sb.append(text).append("\n");
            }
            fileEditText.setText(sb.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(FIS != null){
                try {
                    FIS.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}