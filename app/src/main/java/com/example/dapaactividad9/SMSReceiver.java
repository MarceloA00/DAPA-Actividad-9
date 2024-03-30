package com.example.dapaactividad9;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import android.telephony.SmsMessage;

import java.util.Objects;

public class SMSReceiver extends BroadcastReceiver {

    private static final String SMS_REVECIVED = "android.provider.Telephony.SMS_RECEIVED";
    String msg, phoneNo = "";
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("Test", "Here");
        if (Objects.equals(intent.getAction(), SMS_REVECIVED)) {
            Bundle dataBundle = intent.getExtras();
            if (dataBundle != null) {
                Object[] mypdu = (Object[])dataBundle.get("pdus");
                final SmsMessage[] message = new SmsMessage[mypdu.length];

                for (int i = 0; i < mypdu.length; i++) {

                    if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        String format  = dataBundle.getString("format");
                        message[i] = SmsMessage.createFromPdu((byte[])mypdu[i], format);
                    } else {
                        message[i] = SmsMessage.createFromPdu((byte[])mypdu[i]);
                    }
                    msg = message[i].getMessageBody();
                    phoneNo = message[i].getOriginatingAddress();
                }
                Toast.makeText(context, phoneNo + ": " + msg , Toast.LENGTH_LONG).show();
            }
        }
    }
}