package com.darpan.scba;

import android.app.Activity;
import android.content.Context;


/**
 * Created by Darpan on 8-Mar-16.
 *
 * This class holds the logical part of the software.
 * The Logic includes algorithms for searching database, terminating processes, handling information
 * supplied by the users
 */


public class Manager extends CallListener
{
    private String storedName = "unknown";
    private boolean noUserInteraction = true;
    private boolean incomingCall = false;
    int state = 0;
    String number;




    @Override
    protected void onIncomingCallReceived(Context ctx, String number)
    {
        this.number = number;

        /* check the Phone Book.  If found, change recordNotFound to 'false' and terminate the
         * process.  If not found, check the local database.  If found, change the recordNotFound
         * to 'false' and terminate the process; else continue searching for the record in the
         * 3rd party data base and display the result.  If not found, request for information to
         * the users.
         */


        while(noUserInteraction == true )
        {

            Phonebook.checkPhoneBook(Activity activity, number); //starts searching the phone book
            if(Phonebook.contactDoNotExist == true) //name not found
            {
                //terminate call
            }
            else if ()//starts searching the local database
            {




            }
            else
            {
                //name found
            }
        }


    }




}
