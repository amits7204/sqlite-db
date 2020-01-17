package com.example.sqlitedb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText lFirstName = findViewById(R.id.first_name);
        final EditText lLastName = findViewById(R.id.last_name);
        final EditText lFullAddress = findViewById(R.id.address);
        Button lButton = findViewById(R.id.submit_button);
        lButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.w(TAG,"On Click Submit Button");
                insertData(lFirstName, lLastName, lFullAddress);
            }
        });
    }

    public void insertData(EditText aFirstName, EditText aLastName, EditText aFullAddress){
        UserDataBaseHelper dbHelper = new UserDataBaseHelper(getApplicationContext());
        SQLiteDatabase lDb = dbHelper.getWritableDatabase();
        ContentValues lValues = new ContentValues();
        lValues.put(UserContract.UserEntry.FIRST_NAME, aFirstName.getText().toString());
        lValues.put(UserContract.UserEntry.LAST_NAME, aLastName.getText().toString());
        lValues.put(UserContract.UserEntry.ADDRESS, aFullAddress.getText().toString());

        long lRowId = lDb.insert(UserContract.UserEntry.TABLE_NAME, null, lValues);
        Toast.makeText(getApplicationContext(),"RowId: "+lRowId, Toast.LENGTH_SHORT).show();
    }
}
