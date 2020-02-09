package com.example.dilek.ingilizcequiz;

import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public static final String QUIZ_KEY = "key";
    public static final int SAYILAR = 1;
    public static final int RENKLER = 2;
    public static final int HAYVANLAR = 3;
    public static final int MEYVELER = 4;
    public static final int YIYECEKLER = 5;
    public static final int ULKELER = 6;
    public static final int MESLEKLER = 7;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
    public void testClick(View v){
        Intent intent = new Intent(getApplicationContext(), Quiz.class);

        switch (v.getId()){
            case R.id.fab1:
                intent.putExtra(QUIZ_KEY, SAYILAR);
                startActivity(intent);
                break;
            case R.id.fab2:
                intent.putExtra(QUIZ_KEY, RENKLER);
                startActivity(intent);
                break;
            case R.id.fab3:
                intent.putExtra(QUIZ_KEY, HAYVANLAR);
                startActivity(intent);
                break;
            case R.id.fab4:
                intent.putExtra(QUIZ_KEY, MEYVELER);
                startActivity(intent);
                break;
            case R.id.fab5:
                intent.putExtra(QUIZ_KEY, YIYECEKLER);
                startActivity(intent);
                break;
            case R.id.fab6:
                intent.putExtra(QUIZ_KEY, ULKELER);
                startActivity(intent);
                break;
            case R.id.fab7:
                intent.putExtra(QUIZ_KEY, MESLEKLER);
                startActivity(intent);
                break;
        }
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId() == android.R.id.home){
            Intent intent = new Intent(getApplicationContext(), GirisActivity.class);
            NavUtils.navigateUpTo(this, intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
