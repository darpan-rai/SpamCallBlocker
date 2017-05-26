package com.darpan.scba;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;

/**
 * Created by Darpan on 2-Mar-16.
 *
 * The CallListener class detects the change of state of the phone when the phone is ringing.  It
 * is the extension of the BroadcastReceiver class which helps with the handling of phone calls.
 * The CallListener class will then alert the Manager class which is responsible for the logical
 * implementation of the software.
 */


abstract class CallListener extends BroadcastReceiver
{
    private static int state = TelephonyManager.CALL_STATE_IDLE;
    private static boolean incomingCall = false;
    private static String number;

    @Override
    public void onReceive(Context context, Intent intent)
    {
        /*
         * Checks the state of the phone and in the event of an incoming call it assigns a new value
         * to the 'state' variable, whose initial value is 'idle' (0), and stores the incoming phone
         * number in the 'number' variable.
         */
        if(this.state != TelephonyManager.CALL_STATE_IDLE)
        {
            state = TelephonyManager.CALL_STATE_RINGING;
            this.number = TelephonyManager.EXTRA_INCOMING_NUMBER;
        }
        onCallStateChanged(context, state, number);
    }


    protected abstract void onIncomingCallReceived(Context context, String number);


    public void onCallStateChanged(Context context, int state, String number)
    {
        //TelephonyManager.CALL_STATE_RINGING
        this.incomingCall = true;
        this.number = number;
        onIncomingCallReceived(context, number);
    }

    public static int getState()
    {
        return state;
    }



}
