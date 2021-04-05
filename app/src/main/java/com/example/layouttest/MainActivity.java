package com.example.layouttest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ConstraintLayout cl;
    private ListView listView;
    private TextView tv_phones;

    View mainView;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String cars[] = { "BMW", "Audi", "Mercedes-Benz", "Ford", "Kia", "Bentley", "Ferrari", "Toyota", "Porsche", "Volkswagen", "Skoda", "Cupra"};
        //list of cars

        cl = findViewById(R.id.info_edit_text);
        listView = findViewById(R.id.listPhones);
        tv_phones = findViewById(R.id.phoneInfo);


        ArrayAdapter<String>  phonesAdapter= new ArrayAdapter(this, android.R.layout.simple_list_item_1, cars);
        //creating the adapter
        listView.setAdapter(phonesAdapter);
        listView.setOnItemClickListener(this);

        load_setting();

    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.d("lifecycle","onStart invoked");
    }
    @Override
    protected void onResume() {
        super.onResume();
        //load_setting();
        Log.d("lifecycle","onResume invoked");
    }
    @Override
    protected void onPause() {
        super.onPause();
        Log.d("lifecycle","onPause invoked");
    }
    @Override
    protected void onStop() {
        super.onStop();
        Log.d("lifecycle","onStop invoked");
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("lifecycle","onRestart invoked");
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("lifecycle","onDestroy invoked");
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //function for the listView(
        String car = parent.getItemAtPosition(position).toString();
        Toast.makeText(getApplicationContext(), "Clicked: " + car, Toast.LENGTH_SHORT).show();

        TextView phoneInfo = findViewById(R.id.phoneInfo);
        //"BMW", "Audi", "Mercedes-Benz", "Ford", "Kia", "Bentley", "Ferrari", "Toyota", "Porsche", "Volkswagen", "Skoda", "Cupra"
        switch(car) {
            case "BMW":
                phoneInfo.setText("Model: 8 Series M Competition \n"  + "Price: 120000 euro \n" + "Engine: 4.4L V8 \n" + "Power: 625 hp \n" );
                Log.d("lifecycle", car);
                break;
            case "Audi":
                phoneInfo.setText("Model: R8 \n"  + "Price: 220000 euro \n" + "Engine: 5.2L V10 \n" + "Power: 525 hp \n" );
                Log.d("lifecycle", car);
                break;
            case "Mercedes-Benz":
                phoneInfo.setText("Model: G Class AMG \n"  + "Price: 155000 euro \n" + "Engine: 4.0L V8 \n" + "Power: 575 hp \n" );
                Log.d("lifecycle", car);
                break;
            case "Ford":
                phoneInfo.setText("Model: Focus RS \n"  + "Price: 55000 euro \n" + "Engine: 2.0L I4 \n" + "Power: 310 hp \n" );
                Log.d("lifecycle", car);
                break;
            case "Kia":
                phoneInfo.setText("Model: Stinger GT  \n"  + "Price: 48000 euro \n" + "Engine: 3.3 V6 \n" + "Power: 365 hp \n" );
                Log.d("lifecycle", car);
                break;
            case "Porsche":
                phoneInfo.setText("Model: 911 Turbo S \n"  + "Price: 225000 euro \n" + "Engine: 3.8L \n" + "Power: 575 hp \n" );
                Log.d("lifecycle", car);
                break;
            case "Bentley":
                phoneInfo.setText("Model: Continental GT \n"  + "Price: 280000 euro \n" + "Engine: 6.0L V12 \n" + "Power: 600 hp \n" );
                Log.d("lifecycle", car);
                break;
            case "Toyota":
                phoneInfo.setText("Model: Supra \n"  + "Price: 60000 euro \n" + "Engine: 3.0L I6 \n" + "Power: 360 hp \n" );
                Log.d("lifecycle", car);
                break;
            case "Volkswagen":
                phoneInfo.setText("Model: Golf R \n"  + "Price: 49000 euro \n" + "Engine: 2.0L I4 \n" + "Power: 320 hp \n" );
                Log.d("lifecycle", car);
                break;
            case "Skoda":
                phoneInfo.setText("Model: Superb \n"  + "Price: 58000 euro \n" + "Engine: 2.0 I4 \n" + "Power: 286 hp \n" );
                Log.d("lifecycle", car);
                break;
            case "Ferrari":
                phoneInfo.setText("Model: LaFerrari \n"  + "Price: 2500000 euro \n" + "Engine: 6.3L V12 \n" + "Power: 789 hp \n" );
                Log.d("lifecycle", car);
                break;
            case "Cupra":
                phoneInfo.setText("Model: Formentor \n"  + "Price: 55000 euro \n" + "Engine: 2.0 I4 \n" + "Power: 310 hp \n" );
                Log.d("lifecycle", car);
                break;
            default:
                phoneInfo.setText("");
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @SuppressLint({"ShowToast", "NonConstantResourceId"})
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.itemSettings:
                Toast.makeText(this, "Settings selected", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, Settings.class);
                startActivity(intent);
                return true;
            case R.id.item2:
                Toast.makeText(this, "Item 2 selected", Toast.LENGTH_SHORT).show();
                sendMessage(mainView);
                return true;
            case R.id.item3:
                Toast.makeText(this, "Item 3 selected", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.subitem1:
                Toast.makeText(this, "Sub item 1 selected", Toast.LENGTH_SHORT).show();
                saveFile(mainView);
                return true;
            case R.id.subitem2:
                Toast.makeText(this, "Sub item 2 selected", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    //second activity
    public void sendMessage(View View){
        Intent intent = new Intent(this, send_msg_2_activity.class);
        startActivity(intent);

    }

    private void load_setting(){
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);

        boolean checkBox_night = sp.getBoolean("checkBoxIdNight", false);

        if (checkBox_night) {
            cl.setBackgroundColor(Color.parseColor("#424242"));
            tv_phones.setBackgroundColor(Color.parseColor("#424242"));
            tv_phones.setTextColor(Color.parseColor("#ffffff"));
            listView.setBackgroundColor(Color.parseColor("#424242"));

        } else {
            cl.setBackgroundColor(Color.parseColor("#ffffff"));
            tv_phones.setBackgroundColor(Color.parseColor("#424242"));
            listView.setBackgroundColor(Color.parseColor("#424242"));
        }
    }

    public void saveFile(View view){
        Intent intent = new Intent(this, save_file4.class);
        startActivity(intent);
    }

    private void openDialog() {
        Dialog dialog = new Dialog();
        dialog.show(getSupportFragmentManager(), "example dialog");
    }
}