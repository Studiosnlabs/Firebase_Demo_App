package com.example.firebasedemoapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Database;

import android.os.Bundle;
import android.renderscript.Sampler;
import android.telephony.CellSignalStrength;
import android.util.Log;

import com.google.android.gms.ads.AdView;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       DatabaseReference dbref= FirebaseDatabase.getInstance().getReference();

       Map<String , String> values = new HashMap<>();

       values.put("name","Kofi");

       dbref.push().setValue(values, new DatabaseReference.CompletionListener() {
           @Override
           public void onComplete(@Nullable DatabaseError error, @NonNull DatabaseReference ref) {
               if (error==null){
                   Log.i("DAtabase update","Save Succesful");
               }
               else{
                   Log.i("DAtabase update","Save Failed");
               }
           }
       });






    }
}