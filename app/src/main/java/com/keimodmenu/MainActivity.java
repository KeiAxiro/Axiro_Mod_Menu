package com.keimodmenu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.keimodmenu.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'keimodmenu' library on application startup.
    static {
        System.loadLibrary("keimodmenu");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        com.keimodmenu.databinding.ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Example of a call to a native method
        TextView tv = binding.sampleText;
        tv.setText(stringFromJNI());
    }

    /**
     * A native method that is implemented by the 'keimodmenu' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
}