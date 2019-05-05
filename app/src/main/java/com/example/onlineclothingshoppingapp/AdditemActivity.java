package com.example.onlineclothingshoppingapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class AdditemActivity extends AppCompatActivity{
    private EditText etName,etPrice,etDescription;
    private Spinner spinImg;
    private Button btnView,btnAddItem;
    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_additem);

        etName = findViewById(R.id.etName);
        etPrice = findViewById(R.id.etPrice);
        etDescription = findViewById(R.id.etDescription);
        spinImg = findViewById(R.id.spinImg);
        btnView = findViewById(R.id.btnView);
        btnAddItem = findViewById(R.id.btnAdd);
        img = findViewById(R.id.img);

        btnAddItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save();
            }
        });


        String image[] = {"i1","i2","i3","i4","i5","i6","i7","i8","i9","i10"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,image);
        spinImg.setAdapter(adapter);

        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String spinnerString = spinImg.getSelectedItem().toString();

                switch (spinnerString){
                    case "i1":
                        img.setImageResource(R.drawable.i1);
                        break;
                    case "i2":
                        img.setImageResource(R.drawable.i2);
                        break;
                    case "i3":
                        img.setImageResource(R.drawable.i3);
                        break;
                    case "i4":
                        img.setImageResource(R.drawable.i4);
                        break;
                    case "i5":
                        img.setImageResource(R.drawable.i5);
                        break;
                    case "i6":
                        img.setImageResource(R.drawable.i6);
                        break;
                    case "i7":
                        img.setImageResource(R.drawable.i7);
                        break;
                    case "i8":
                        img.setImageResource(R.drawable.i8);
                        break;
                    case "i9":
                        img.setImageResource(R.drawable.i9);
                        break;
                    case "i10":
                        img.setImageResource(R.drawable.i10);
                        break;
                }
            }
        });

    }
    private void save(){
        PrintStream printStream = null;
        try {
            printStream = new PrintStream(openFileOutput("Items.txt",MODE_PRIVATE | MODE_APPEND));
            printStream.println(etName.getText().toString() + "->" + etPrice.getText().toString()+ "->"
                    + spinImg.getSelectedItem().toString()+ "->" + etDescription.getText().toString());
            Toast.makeText(this,"saved to " +getFilesDir(), Toast.LENGTH_LONG).show();
            printStream.close();
        } catch (FileNotFoundException e) {
            Log.d("Online Shopping" , "Error: "+e.toString());
            e.printStackTrace();
        }

    }
}
