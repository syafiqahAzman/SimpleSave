package sg.edu.rp.c346.simplesave;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    @Override
    protected void onPause() {
        super.onPause();

        //Obtain an instance of the sharedPreferences
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);

        //Obtain an instance of the SharedPreference Editor for update later
        SharedPreferences.Editor prefEdit = prefs.edit();

        //Add the key-value pair
        prefEdit.putString("greeting", "Hello!");

        //Call commit() method to save the changes into the SharedPreferences
        prefEdit.commit();





    }

    @Override
    protected void onResume() {
        super.onResume();

        //String msg = "No greetings!";

        //Obtain an instance of the SharedPreferences
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);

        //Retrieve the saved data witht he key "greeting" from the SharedPreferenes Object
        String msg = prefs.getString("greeting", "No greetings!");
        Toast toast = Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG);
        toast.show();
    }
}
