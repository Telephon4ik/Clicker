package com.example.clicker;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private Integer count = 0;
    private android.util.Log Log;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.d("onStart", "onStart");
        Toast.makeText(this, "onStart",Toast.LENGTH_LONG).show();
    }
    @Override
    protected void onResume() {
        super.onResume();
        Log.d("onResume", "onResume");
        Toast.makeText(this, "onResume",Toast.LENGTH_LONG).show();
    }
    @Override
    protected void onPause() {
        super.onPause();
        Log.d("onPause", "onPause");
        Toast.makeText(this, "onPause",Toast.LENGTH_LONG).show();
    }
    @Override
    protected void onSaveInstanceState(Bundle autState){
        super.onSaveInstanceState(autState);
        autState.putInt("Тык", count);
        Log.d("Instens","onSave");
        Toast.makeText(this, "onSave",Toast.LENGTH_LONG).show();
    }
    @Override
    protected void onRestoreInstanceState(Bundle SavedState){
        super.onRestoreInstanceState(SavedState);
        if(SavedState != null && SavedState.containsKey("Тык")){
            count = SavedState.getInt("Тык");
        }
        TextView txt = findViewById(R.id.txtCounter);
        txt.setText(count.toString());
        Log.d("Instens","get");
        Toast.makeText(this, "get",Toast.LENGTH_LONG).show();
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.d("onDestroy", "onDestroy");
        Toast.makeText(this, "onDestroy!",Toast.LENGTH_LONG).show();
    }
    @Override
    protected void onStop(){
        super.onStop();
        Log.d("onStop", "onStop");
        Toast.makeText(this, "onStop!",Toast.LENGTH_LONG).show();
    }
    public void onClickButton(View view) {
        count++;
        TextView txt= findViewById(R.id.txtCounter);
        txt.setText(count.toString());
    }
    public void onClickButton2(View view) {
        count--;
        TextView txt= findViewById(R.id.txtCounter);
        txt.setText(count.toString());
    }
}