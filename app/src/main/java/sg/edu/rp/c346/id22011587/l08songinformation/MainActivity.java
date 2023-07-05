package sg.edu.rp.c346.id22011587.l08songinformation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText etTitle, etSingers, etYear, etStars;
    Button btnInsert, btnShowList;

    TextView tvResults;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Initialize views
        etTitle = findViewById(R.id.editTextTitle);
        etSingers = findViewById(R.id.editTextSingers);
        etYear = findViewById(R.id.editTextYear);
        etStars = findViewById(R.id.editTextStars);
        btnInsert = findViewById(R.id.btnInsert);
        btnShowList = findViewById(R.id.btnShowList);
        tvResults = findViewById(R.id.tvResults);

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper db = new DBHelper(MainActivity.this);
                db.insertSong(etTitle.getText().toString(), etSingers.getText().toString(), etYear.getText().toString(), etStars.getText().toString());

            }
        });
        // Set click listener for Show List button
        btnShowList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper db = new DBHelper(MainActivity.this);
                ArrayList<String> data = db.getSongContent();
                db.close();

                String txt = "";
                for (int i = 0; i < data.size(); i++) {
                    Log.d("Database Content", i +". "+data.get(i));
                    txt += i + ". " + data.get(i) + "\n";
                }
                tvResults.setText(txt);
            }
        });
    }
}