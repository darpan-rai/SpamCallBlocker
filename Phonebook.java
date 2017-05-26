package com.darpan.scba;

import android.app.Activity;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;

/**
 * Created by Darpan on 18-Apr-16.
 *
 * This class is called by the Manager Class to check the availability of the incoming number in the
 * users' phone book.
 *
 */
public class Phonebook
{


    static boolean contactDoNotExist = true;

    public static boolean checkPhoneBook(Activity activity, String number)
    {
        Uri uri = Uri.withAppendedPath(ContactsContract.PhoneLookup.CONTENT_FILTER_URI, Uri.encode(number));
        String[] findPhoneNumber = { ContactsContract.PhoneLookup._ID, ContactsContract.PhoneLookup.NUMBER, ContactsContract.PhoneLookup.DISPLAY_NAME };
        Cursor cursor = activity.getContentResolver().query(uri, findPhoneNumber, null, null, null);
        try
        {
            if (cursor.moveToFirst())
            {
                return contactDoNotExist = false; //number found
            }
        }
        finally
        {
            if (cursor != null)
            {
                cursor.close();
            }
        }
        return contactDoNotExist = true; //number not found

    }


}
