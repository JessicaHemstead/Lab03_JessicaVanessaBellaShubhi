package com.example.profilemanagerlab3;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

   // private Button OpenInGoogleMaps;
   // private EditText ZipCode;
    //private EditText teamName;
    //private ImageView originalImage;

    private static final String TAG = "MyActivity";

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //OpenInGoogleMaps = findViewById(R.id.OpenInGoogleMaps);
       // ZipCode = findViewById(R.id.ZipCode);
        //teamName = findViewById(R.id.teamName);
        //originalImage = findViewById(R.id.originalImage);

    }

    public void onOpenInGoogleMaps(View view) {
        EditText teamAddress = (EditText) findViewById(R.id.ZipCode);
        // Create a Uri from an intent string. Use the result to create an Intent.
        Uri gmmIntentUri = Uri.parse("http://maps.google.co.in/maps?q=" + teamAddress.getText());
        // Create an Intent from gmmIntentUri. Set the action to ACTION_VIEW
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        // Make the Intent explicit by setting the Google Mapspackage
        mapIntent.setPackage("com.google.android.apps.maps");
        // Attempt to start an activity that can handle theIntent
        startActivity(mapIntent);
    }

    protected void onStart(){ super.onStart();}

    public void OnSetAvatarButton(View view) {
        //Application Context and Activity
        Intent intent = new Intent(getApplicationContext(), MainActivity2.class);
        startActivityForResult(intent, 0);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_CANCELED) return;
//Getting the Avatar Image we show to our users
        ImageView avatarImage = (ImageView) findViewById(R.id.originalImage);
//Figuring out the correct image
        String drawableName = "ic_logo_00";
        switch (data.getIntExtra("imageID", R.id.teamid00)) {
            case R.id.teamid00:
                drawableName = "ic_logo_00";
                break;
            case R.id.teamid01:
                drawableName = "ic_logo_01";
                break;
            case R.id.teamid02:
                drawableName = "ic_logo_02";
                break;
            case R.id.teamid03:
                drawableName = "ic_logo_03";
                break;
            case R.id.teamid04:
                drawableName = "ic_logo_04";
                break;
            case R.id.teamid05:
                drawableName = "ic_logo_05";
                break;
            default:
                drawableName = "ic_logo_00";
                break;
        }
        int resID = getResources().getIdentifier(drawableName, "drawable", getPackageName());
        avatarImage.setImageResource(resID);
    }

}