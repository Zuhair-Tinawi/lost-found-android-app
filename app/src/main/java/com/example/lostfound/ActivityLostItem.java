package com.example.lostfound;

import android.os.Bundle;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.app.DatePickerDialog;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;
import java.util.Calendar;

public class ActivityLostItem extends AppCompatActivity {
    EditText editTextDateLost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_lost_item);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.mainLost), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Date picker setup
        editTextDateLost = findViewById(R.id.editTextDateLost);
        editTextDateLost.setOnClickListener(v -> showDatePicker());

        Button buttonBackLost = findViewById(R.id.buttonBackLost);
        buttonBackLost.setOnClickListener(v -> {
            Intent intent = new Intent(ActivityLostItem.this, Activity2.class);
            startActivity(intent);
            finish();
        });
    }

    private void showDatePicker() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(
                ActivityLostItem.this,
                (view, selectedYear, selectedMonth, selectedDay) -> {
                    String formattedDate = String.format("%04d-%02d-%02d", selectedYear, selectedMonth + 1, selectedDay);
                    editTextDateLost.setText(formattedDate);
                },
                year, month, day
        );

        datePickerDialog.show();
    }
}
