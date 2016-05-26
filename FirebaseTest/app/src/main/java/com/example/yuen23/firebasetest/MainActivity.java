package com.example.yuen23.firebasetest;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    EditText etID;
    EditText etName;
    EditText etGender;
    EditText etAge;
    EditText etLoginType;
    EditText etPhoneNum;
    EditText etRegion;
    Button btSignUp;
    Button btHelloWorld;
    Button btCheckAccExist;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        etID = (EditText)findViewById(R.id.etID);
        etName = (EditText)findViewById(R.id.etName);
        etGender = (EditText)findViewById(R.id.etGender);
        etAge = (EditText)findViewById(R.id.etAge);
        etLoginType = (EditText)findViewById(R.id.etLoginType);
        etPhoneNum = (EditText)findViewById(R.id.etPhoneNum);
        etRegion = (EditText)findViewById(R.id.etRegion);
        btSignUp = (Button) findViewById(R.id.btSignUp);
        btHelloWorld = (Button)findViewById(R.id.btHelloWorld);
        btCheckAccExist = (Button)findViewById(R.id.btCheckAccExist);

        btSignUp.setOnClickListener(this);
        btHelloWorld.setOnClickListener(this);
        btCheckAccExist.setOnClickListener(this);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }




    @Override
    public void onClick(View v) {
        String id = etID.getText().toString();
        String name = etName.getText().toString();
        String gender = etGender.getText().toString();
        String age = etAge.getText().toString();
        String loginType = etLoginType.getText().toString();
        String phoneNum = etPhoneNum.getText().toString();
        String region = etRegion.getText().toString();

        switch (v.getId()){
            case R.id.btSignUp:
                Toast.makeText(MainActivity.this, "btSignUp", Toast.LENGTH_LONG).show();
                //TODO post data
                break;
            case R.id.btHelloWorld:
                Toast.makeText(MainActivity.this, "btHelloWorld", Toast.LENGTH_LONG).show();
                DatabaseReference myRef = FirebaseDatabase.getInstance()
                        .getReferenceFromUrl("https://gullscrash.firebaseio.com/path/to/data");
//        ref.child("message").setValue("Do you have data? You'll love Firebase.");

//        FirebaseDatabase database = FirebaseDatabase.getInstance();
//        DatabaseReference myRef = database.getReference("message");

                myRef.setValue("Hello, World!1");
                myRef.child("message").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        Log.v("HI","HI");
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
                break;
            case R.id.btCheckAccExist:
                Toast.makeText(MainActivity.this, "btCheckAccExist", Toast.LENGTH_LONG).show();
                //TODO check ID exist
                break;
        }

    }
}
