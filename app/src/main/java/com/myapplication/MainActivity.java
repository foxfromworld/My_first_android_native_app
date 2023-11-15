package com.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.EditText;
import android.widget.TextView;

import com.myapplication.databinding.ActivityMainBinding;

import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    float x1, x2, y1, y2;
    // Used to load the 'myapplication' library on application startup.
    static {
        System.loadLibrary("myapplication");
    }

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Example of a call to a native method
        TextView tv = binding.sampleText;
        EditText nb = binding.editTextNumber;
        tv.setText(stringFromJNI());
        nb.setText(intFromJNI());
    }
    public boolean onTouchEvent(MotionEvent touchEvent){
        switch(touchEvent.getAction()){
            case MotionEvent.ACTION_DOWN:
                x1 = touchEvent.getX();
                y1 = touchEvent.getY();
            case MotionEvent.ACTION_UP:
                x2 = touchEvent.getX();
                y2 = touchEvent.getY();
                if(x1 < x2){
                    Toast.makeText(getApplicationContext(), "Swipe right", Toast.LENGTH_SHORT).show();
                }else if(x1 > x2){
                    Toast.makeText(getApplicationContext(), "Swipe left", Toast.LENGTH_SHORT).show();
                }
        }
        return false;
    }

    /**
     * A native method that is implemented by the 'myapplication' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
    public native String intFromJNI();
}