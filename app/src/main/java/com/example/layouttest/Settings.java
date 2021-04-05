package com.example.layouttest;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.preference.CheckBoxPreference;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceActivity;

import android.os.Bundle;
import android.preference.PreferenceManager;

public class Settings extends PreferenceActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);
        loadSettigns();
    }

    private void loadSettigns() {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);

        boolean checkBox_night = sp.getBoolean("checkBoxIdNight", false);
        if (checkBox_night) {
            getListView().setBackgroundColor(Color.parseColor("#424242"));
        } else {
            getListView().setBackgroundColor(Color.parseColor("#FFFFFF"));
        }

        CheckBoxPreference checkBox_night_instant = (CheckBoxPreference) findPreference("checkBoxIdNight");
        checkBox_night_instant.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(Preference prefs, Object obj) {

                boolean yes = (boolean) obj;

                if (yes) {
                    getListView().setBackgroundColor(Color.parseColor("#424242"));
                } else {
                    getListView().setBackgroundColor(Color.parseColor("#FFFFFF"));
                }
                return true;
            }
        });

        ListPreference LP = (ListPreference) findPreference("checkBoxIdOrientation");
        String orientation = sp.getString("checkBoxIdOrientation", "false");

        if ("1".equals(orientation)) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_BEHIND);
            LP.setSummary(LP.getEntry());
        } else {
            if ("2".equals(orientation)) {
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
                LP.setSummary(LP.getEntry());
            } else {
                if ("3".equals(orientation)) {
                    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
                    LP.setSummary(LP.getEntry());
                }
            }
        }

        LP.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(Preference prefs, Object obj) {

                String items = (String) obj;
                if (prefs.getKey().equals("checkBoxIdOrientation")) {
                    switch (items) {
                        case "1":
                            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_BEHIND);
                            break;
                        case "2":
                            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
                            break;
                        case "3":
                            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
                            break;
                    }
                }
                return true;
            }
        });
    }

    @Override
    protected void onResume() {
        loadSettigns();
        super.onResume();
    }
}