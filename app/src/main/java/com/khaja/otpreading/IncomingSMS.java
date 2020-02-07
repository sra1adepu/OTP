package com.khaja.otpreading;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.util.Log;

import androidx.localbroadcastmanager.content.LocalBroadcastManager;

public class IncomingSMS extends BroadcastReceiver {
    final SmsManager sms = SmsManager.getDefault();
    SmsMessage[] msgs = null;

    @Override
    public void onReceive(Context context, Intent intent) {
        final Bundle bundle = intent.getExtras();
        try {

            if (bundle != null) {


                try {
                    Object[] pdus = (Object[]) bundle.get("pdus");
                    msgs = new SmsMessage[pdus.length];
                    for (int i = 0; i < msgs.length; i++) {
                        msgs[i] = SmsMessage
                                .createFromPdu((byte[]) pdus[i]);
                        String msgBody = msgs[i].getMessageBody();

                        Intent myIntent = new Intent("otp");
                        myIntent.putExtra("message", msgBody + "");
                        LocalBroadcastManager.getInstance(context).sendBroadcast(myIntent);

                    }
                } catch (Exception e) {

                }

            }


        } catch (Exception e) {
            Log.e("SmsReceiver", "Exception smsReceiver" + e);

        }
    }
}
