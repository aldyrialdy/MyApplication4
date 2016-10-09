package pertemuan.lat.mobpro.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import java.util.HashMap;

/**
 * Created by aldyrialdy on 30/09/16.
 */
public class SessionManager {
    String u,p,e,ph;
    boolean stat;

    Context _context;

    SharedPreferences sharedpreferences;

    SharedPreferences.Editor editor;
    public static final String MyPref = "MyPrefs" ;
    public static final String MyUsername = "MyUsername";
    public static final String MyPassword = "MyPassword";
    public static final String MyEmail = "MyEmail";
    public static final String MyPhone = "MyPhone";
    public static final String MyStat = "MyStatus";

    public SessionManager(Context context){
        this._context = context;
        sharedpreferences = context.getSharedPreferences(MyPref,Context.MODE_PRIVATE);
        editor = sharedpreferences.edit();
    }

    public void createLoginSession(String usern, String pwd, String email, String phone, boolean status){
        editor.putString(MyUsername,usern);
        editor.putString(MyPassword,pwd);
        editor.putString(MyEmail,email);
        editor.putString(MyPhone,phone);
        editor.putBoolean(MyStat, status);
        editor.commit();
    }

    public void setLogStatus(boolean status){
        editor.putBoolean(MyStat,status);
        editor.commit();
    }

    public void checkLogin(){
        if(!this.isLoggedIn()){
            // user is not logged in redirect him to Login Activity
            Intent i = new Intent(_context, LoginActivity.class);
            // Closing all the Activities
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

            // Add new Flag to start new Activity
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            // Staring Login Activity
            _context.startActivity(i);
        }
    }

    public void logOutUser(){
        editor.clear();
        editor.commit();

        Intent i = new Intent(_context, LoginActivity.class);
        // Closing all the Activities
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        // Add new Flag to start new Activity
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        // Staring Login Activity
        _context.startActivity(i);
    }

    /**
     * Get stored session data
     * */
    public HashMap<String, String> getUserDetails(){
        HashMap<String, String> user = new HashMap<String, String>();
        // user name
        user.put(MyUsername, sharedpreferences.getString(MyUsername, null));

        // user email id
        user.put(MyEmail, sharedpreferences.getString(MyEmail, null));

        // user email id
        user.put(MyPassword, sharedpreferences.getString(MyPassword, null));

        // return user
        return user;
    }


    public boolean isLoggedIn() {
        return sharedpreferences.getBoolean(MyStat,false);
    }
}
