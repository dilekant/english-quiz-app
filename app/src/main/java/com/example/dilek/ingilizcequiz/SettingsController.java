package com.example.dilek.ingilizcequiz;

import android.content.Context;
import android.content.SharedPreferences;

public class SettingsController {

    SharedPreferences mSharedPreferences;
    SharedPreferences.Editor mEditor;
    Context mContext;
    static SettingsController setttingsObject = null;

    private SettingsController(Context mContext) {
        this.mContext = mContext;
        mSharedPreferences = mContext.getSharedPreferences("Settings", 0);
        mEditor = mSharedPreferences.edit();
    }

    public static SettingsController getInstance(Context context) {
        if (setttingsObject == null)
            setttingsObject = new SettingsController(context);

        return setttingsObject;
    }

    public void setCurrentCount(int currentCount){
        mEditor.putInt("CurrentCount", currentCount);
        mEditor.commit();
    }

    public int getCurrentCount(){
        int currentCount = mSharedPreferences.getInt("CurrentCount", 1);
        return currentCount;
    }

    public int getDogruCevap() {
        int dogruCevap = mSharedPreferences.getInt("DogruCevap", 1);
        return dogruCevap;
    }

    public void setDogruCevap(int dogruCevap) {
        mEditor.putInt("DogruCevap", dogruCevap);
        mEditor.commit();
    }

    public int getDogruCevapRenk() {
        int dogruCevapRenk = mSharedPreferences.getInt("DogruCevapRenk", 1);
        return dogruCevapRenk;
    }

    public void setDogruCevapRenk(int dogruCevapRenk) {
        mEditor.putInt("DogruCevapRenk", dogruCevapRenk);
        mEditor.commit();
    }

    public int getToplamCevapp() {
        int toplamCevapp = mSharedPreferences.getInt("ToplamCevap", 1);
        return toplamCevapp;
    }

    public void setToplamCevapp(int toplamCevapp) {
        mEditor.putInt("ToplamCevap", toplamCevapp);
        mEditor.commit();
    }
}
