package com.example.dilek.ingilizcequiz;

import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class SorusayisisecmeActivity extends AppCompatActivity {

    SeekBar sb;
    TextView sayici;
    Button sorusecimi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sorusayisisecme);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        sb = (SeekBar) findViewById(R.id.seekbar);
        sayici = (TextView) findViewById(R.id.tv_value);
        sorusecimi = (Button) findViewById(R.id.tv_basla);

        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar sb, int progress, boolean fromUser) {
                sayici.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar sb) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar sb) {

            }
        });

        sorusecimi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(SorusayisisecmeActivity.this, SecimekraniActivity.class);
                intent.putExtra("veri", sayici.getText().toString());
                startActivity(intent);

            }
        });

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
