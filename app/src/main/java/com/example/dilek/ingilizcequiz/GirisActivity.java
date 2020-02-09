package com.example.dilek.ingilizcequiz;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class GirisActivity extends AppCompatActivity {

    Button test;
    Button serbestcalisma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giris);

        test = (Button)findViewById(R.id.btn_test);
        serbestcalisma = (Button)findViewById(R.id.btn_calisma);

        test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(GirisActivity.this, MainActivity.class);
                startActivity(i);
            }
        });

        serbestcalisma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                /*final String[] listItems = {"one", "two", "three", "four", "five"};

                AlertDialog.Builder builder = new AlertDialog.Builder(GirisActivity.this);
                builder.setTitle("Choose item");

                int checkedItem = 0; //this will checked the item when user open the dialog
                builder.setSingleChoiceItems(listItems, checkedItem, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(GirisActivity.this, "Position: " + which + " Value: " + listItems[which], Toast.LENGTH_LONG).show();
                    }
                });

                builder.setPositiveButton("Done", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

                AlertDialog dialog = builder.create();
                dialog.show();*/



                Intent intent = new Intent(GirisActivity.this, SorusayisisecmeActivity.class);
                startActivity(intent);
            }
        });


    }
}
