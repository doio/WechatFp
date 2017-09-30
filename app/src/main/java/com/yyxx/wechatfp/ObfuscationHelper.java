package com.yyxx.wechatfp;

import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage.LoadPackageParam;

public class ObfuscationHelper {
    public static int versionint=0;
    public static int version_code=0;

    public static class MM_Classes {
        public static Class<?> PayUI,FetchUI,Payview,WalletBaseUI;

        private static void init(int idx, LoadPackageParam lpparam) throws Throwable {
            PayUI = XposedHelpers.findClass("com.tencent.mm.plugin.wallet.pay.ui." + new String[]{
                    "WalletPayUI",
                    "WalletPayUI",
                    "WalletPayUI",
                    "WalletPayUI",
                    "WalletPayUI",
                    "WalletPayUI"
            }[idx], lpparam.classLoader);
            Payview = XposedHelpers.findClass("com.tencent.mm.plugin.wallet_core.ui." + new String[]{
                    "l",
                    "l",
                    "l",
                    "l",
                    "l",
                    "l"
            }[idx], lpparam.classLoader);
            FetchUI = XposedHelpers.findClass("com.tencent.mm.plugin.wallet.balance.ui." + new String[]{
                    "WalletBalanceFetchPwdInputUI",
                    "WalletBalanceFetchPwdInputUI",
                    "WalletBalanceFetchPwdInputUI",
                    "WalletBalanceFetchPwdInputUI",
                    "WalletBalanceFetchPwdInputUI",
                    "WalletBalanceFetchPwdInputUI"
            }[idx], lpparam.classLoader);
            WalletBaseUI = XposedHelpers.findClass("com.tencent.mm.wallet_core.ui." + new String[]{
                    "WalletBaseUI",
                    "WalletBaseUI",
                    "WalletBaseUI",
                    "WalletBaseUI",
                    "WalletBaseUI",
                    "WalletBaseUI"
            }[idx], lpparam.classLoader);
        }
    }

    public static class MM_Fields {
        public static String PaypwdEditText;
        public static String PaypwdView;
        public static String PayInputView;
        public static String PayTitle;
        public static String Passwd_Text;

        private static void init(int idx) throws Throwable {
            PaypwdView = new String[]{
                    "qVO",
                    "ryk",
                    "ryM",
                    "rLB",
                    "rNe",
                    "rWo"
            }[idx];
            PaypwdEditText = new String[]{
                    "vyO",
                    "wjm",
                    "wjX",
                    "wDJ",
                    "wFP",
                    "xhU"
            }[idx];
            PayInputView = new String[]{
                    "mOL",
                    "nnG",
                    "nnZ",
                    "nol",
                    "npM",
                    "nzg"
            }[idx];
            PayTitle = new String[]{
                    "qVK",
                    "ryg",
                    "ryI",
                    "rLw",
                    "rMZ",
                    "rWj"
            }[idx];
            Passwd_Text = new String[]{
                    "qVK",
                    "ryz",
                    "rzb",
                    "rLQ",
                    "rNt",
                    "rWD"
            }[idx];
        }
    }
    public static class MM_Res {
        public static int Finger_icon;
        public static int Finger_title;
        public static int passwd_title;

        private static void init(int idx) throws Throwable {
            Finger_icon=new int[]{
                    2130838280,
                    2130838289,
                    2130838289,
                    2130838298,
                    2130838298,
                    2130838246
            }[idx];
            Finger_title=new int[]{
                    2131236833,
                    2131236918,
                    2131236918,
                    2131236964,
                    2131236963,
                    2131237043
            }[idx];
            passwd_title=new int[]{
                    2131236838,
                    2131236923,
                    2131236923,
                    2131236969,
                    2131236968,
                    2131237048
            }[idx];
        }
    }


    public static boolean init(int versioncode, String versionName, LoadPackageParam lpparam) throws Throwable {
        version_code = versioncode;
        int versionIndex = isSupportedVersion(versioncode, versionName);
        if (versionIndex < 0) {
            return false;
        }
        MM_Classes.init(versionIndex, lpparam);
        MM_Fields.init(versionIndex);
        MM_Res.init(versionIndex);
        return true;
    }


    public static int isSupportedVersion(int versioncode, String versionName) {
        if(versionName.contains("6.5.8")){
            versionint=0;
            return 0;
        }
        if(versionName.contains("6.5.10") && versioncode == 1080){
            versionint=1;
            return 1;
        }
        if(versionName.contains("6.5.10") && versioncode == 1061){
            versionint=2;
            return 2;
        }
        if(versionName.contains("6.5.13") && versioncode == 1100){
            versionint=3;
            return 3;
        }
        if(versionName.contains("6.5.13") && versioncode == 1081){
            versionint=4;
            return 4;
        }
        if(versionName.contains("6.5.16") && versioncode == 1120){
            versionint=5;
            return 5;
        }
        return -1;
    }
}
