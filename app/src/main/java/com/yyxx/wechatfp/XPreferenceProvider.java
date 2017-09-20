package com.yyxx.wechatfp;

import android.content.Context;
import android.content.SharedPreferences;
import com.crossbowffs.remotepreferences.RemotePreferenceProvider;
import com.crossbowffs.remotepreferences.RemotePreferences;

public class XPreferenceProvider extends RemotePreferenceProvider {
    public static final String AUTHORITY = "com.yyxx.wechatfp.XPreferenceProvider";
    public static final String PREF_NAME = "main_prefs";
    private static SharedPreferences sSharedPreferenceInstance;

    public XPreferenceProvider() {
        super(AUTHORITY, new String[] { PREF_NAME });
    }

    public static SharedPreferences getRemoteSharedPreference(Context context) {
        if (sSharedPreferenceInstance == null) {
            sSharedPreferenceInstance = new RemotePreferences(context, AUTHORITY, PREF_NAME);
        }
        return sSharedPreferenceInstance;
    }
}
