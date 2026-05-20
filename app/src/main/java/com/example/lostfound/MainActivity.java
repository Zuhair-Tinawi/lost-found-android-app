package com.example.lostfound;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;


public class MainActivity extends AppCompatActivity {

    Button buttonSignIn;

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

        // Link Sign In button
        buttonSignIn = findViewById(R.id.buttonSignIn);

        // Open ActivityLogin on click
        buttonSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ActivityLogin.class);
                startActivity(intent);
                finish(); // Close MainActivity so user can't go back
            }
        });

        TextView textViewTrouble = findViewById(R.id.textViewTrouble);

        textViewTrouble.setOnClickListener(v -> {
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("Trouble Signing In?")
                    .setMessage("Please contact support@lostfoundapp.com to reset your password.")
                    .setPositiveButton("OK", null)
                    .show();
        });

    }
}
