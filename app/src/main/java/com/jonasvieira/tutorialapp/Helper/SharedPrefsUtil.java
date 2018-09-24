package com.jonasvieira.tutorialapp.Helper;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPrefsUtil {

    private static SharedPreferences getPreferences(Context context) {
        String KEY_SHARED = "CONT_TUTORIAL";
        return context.getSharedPreferences(KEY_SHARED, Context.MODE_PRIVATE);
    }

    private static SharedPreferences.Editor getPreferencesEditor(Context context) {
        return getPreferences(context).edit();
    }


    public static String getPreferenceValue(Context context, String key, String defValue) {
        return getPreferences(context).getString(key, defValue);
    }

    public static void setPreferenceValue(Context context, String key, String prefsValue) {
        getPreferencesEditor(context).putString(key, prefsValue).apply();
    }
}
