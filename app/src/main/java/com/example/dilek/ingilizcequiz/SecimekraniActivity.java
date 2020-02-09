package com.example.dilek.ingilizcequiz;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class SecimekraniActivity extends AppCompatActivity {

    private String gelenveri;
    private List<String> genelListe,soruListesi;
    private RelativeLayout soruContainer;
    private LinearLayout butonContainer;
    private TextView ilerleme_tv, soru_tv;
    private Random random;
    private String dogruCevap;
    //private int TOPLAM_SORU_SAYISI = 10;
    private Handler handler;
    private int quiz;
    private int toplamCevapSayisi,dogruCevapSayisi,kacinciDenemedeBildi;

    private View.OnClickListener butonDinleyicisi = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            toplamCevapSayisi++;
            Button button= (Button) v;
            String verilenCevap=button.getText().toString();


            if (verilenCevap.equals(dogruCevap)){
                //verilen cevap doğruysa
                tebrikEt(kacinciDenemedeBildi);
                kacinciDenemedeBildi=1;
                butunButonlariEtkisizlestir();
                dogruCevapSayisi++;

                gelenveri = getIntent().getExtras().getString("veri");

                if (dogruCevapSayisi==Integer.valueOf(gelenveri)){

                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            dialog();
                        }
                    },1500);

                } else{
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            sonrakiSoru();
                        }
                    },2500);
                }



            }else{
                //verilen cevap yanlışsa
                kacinciDenemedeBildi++;
                button.setEnabled(false);
                Animasyonlar.titremeAnimasyonu(soruContainer);

            }
        }
    };

    private void dialog() {

        gelenveri = getIntent().getExtras().getString("veri");

        new AlertDialog.Builder(SecimekraniActivity.this)
                .setTitle("Testi Bitirdiniz")
                .setMessage(gelenveri + " soruluk teste " + toplamCevapSayisi + " cevap vererek tamamladınız.")
                .setPositiveButton("Tekrar Dene", new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        resetQuiz();
                        dialog.dismiss();
                    }
                })
                .setNegativeButton("Şimdilik yeter", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                        dialog.cancel();
                    }
                }).show();
    }

    private void tebrikEt(int kacinciDenemedeBildi) {

        String tebrikMesaji="";
        switch (kacinciDenemedeBildi){
            case 1:
                tebrikMesaji="Mükemmelsin";
                break;
            case 2:
                tebrikMesaji="İyisin";
                break;
            case 3:
                tebrikMesaji="Fena Değil";
                break;
            case 4:
                tebrikMesaji="Nihayet";
                break;
        }

        soru_tv.setText(tebrikMesaji);
        soru_tv.setTextColor(Color.RED);
        soru_tv.setTextSize(40);
        Animasyonlar.tebrikAnimasyonu(soru_tv);
    }

    private void butunButonlariEtkisizlestir() {
        for (int satir=0;satir<butonContainer.getChildCount();satir++){
            Button button= (Button) butonContainer.getChildAt(satir);
            button.setEnabled(false);
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secimekrani);

        quiz=getIntent().getIntExtra(MainActivity.QUIZ_KEY,MainActivity.SAYILAR);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        genelListe=new ArrayList<String>();
        soruListesi=new ArrayList<String>();
        random=new Random();
        handler=new Handler();
        kacinciDenemedeBildi=1;

        soruContainer= (RelativeLayout) findViewById(R.id.rl);
        butonContainer= (LinearLayout) findViewById(R.id.buton_container);
        ilerleme_tv= (TextView) findViewById(R.id.ilerleme_tv);
        soru_tv= (TextView) findViewById(R.id.soru_tv);

        ilerleme_tv.setText("1 / "+getIntent().getExtras().getString("veri"));



        for (int satir=0;satir<butonContainer.getChildCount();satir++){
            Button button= (Button) butonContainer.getChildAt(satir);
            button.setOnClickListener(butonDinleyicisi);
        }


        //ilerleme_tv.setText("1 / "+getIntent().getExtras().getInt("veri"));

        switch (quiz){
            case MainActivity.SAYILAR:
                soru_tv.setTextSize(40);
                String[] dizi=getResources().getStringArray(R.array.serbestcalisma);
                for (String s:dizi){
                    genelListe.add(s);
                }
                break;
        }
        resetQuiz();

    }

    private void resetQuiz() {

        toplamCevapSayisi=0;
        dogruCevapSayisi=0;

        soruListesi.clear();

        int soruSayisi=1;
        int listedekiElemanSayisi=genelListe.size();

        gelenveri = getIntent().getExtras().getString("veri");

       while (soruSayisi <= Integer.valueOf(gelenveri)){

            int index = random.nextInt(listedekiElemanSayisi);
            String soru = genelListe.get(index);

            if (!soruListesi.contains(soru)){
                soruListesi.add(soru);
                soruSayisi++;
            }
        }

        sonrakiSoru();

    }

    private void sonrakiSoru() {


        if (quiz == MainActivity.SAYILAR){
            soru_tv.setTextSize(40);
        }

        soru_tv.setTextColor(Color.parseColor("#444444"));
        gelenveri = getIntent().getExtras().getString("veri");
        ilerleme_tv.setText(dogruCevapSayisi+1 +" / "+ Integer.valueOf(gelenveri));

        String soru = soruListesi.remove(0);
        soru_tv.setText(getSoru(soru));
        dogruCevap=getCevap(soru);


        Collections.shuffle(genelListe);
        int dogruCevabinIndisi=genelListe.indexOf(soru);


        genelListe.add(genelListe.remove(dogruCevabinIndisi));

        for (int satir=0;satir<butonContainer.getChildCount();satir++){
            Button button= (Button) butonContainer.getChildAt(satir);
            String secenek = genelListe.get(satir);
            button.setText(getCevap(secenek));
            button.setEnabled(true);
        }

        int rastgeleIndis=random.nextInt(4);
        ((Button)butonContainer.getChildAt(rastgeleIndis)).setText(dogruCevap);

        soruAnimasyonu();
    }

    private void soruAnimasyonu() {

        List<View> butonlar = new ArrayList<View>();

        for (int satir=0;satir<butonContainer.getChildCount();satir++){
            Button button= (Button) butonContainer.getChildAt(satir);
            butonlar.add(button);

        }
        Animasyonlar.yaziAnimasyonu(soru_tv,random.nextInt(29));
        Animasyonlar.butonlarAnimasyonu(butonlar);
    }


    private String getSoru(String soru) {
        soru=soru.substring(0,soru.indexOf("-"));
        return soru;
    }


    private String getCevap(String soru) {
        soru=soru.substring(soru.indexOf("-")+1,soru.length());
        return soru;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId() == android.R.id.home){
            Intent intent = new Intent(getApplicationContext(), SorusayisisecmeActivity.class);
            NavUtils.navigateUpTo(this, intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
