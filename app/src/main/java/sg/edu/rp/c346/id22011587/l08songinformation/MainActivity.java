package sg.edu.rp.c346.id22011587.l08songinformation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText etTitle, etSingers, etYear, etStars;
    Button btnInsert, btnShowList;
    ListView lv;

    ArrayList<Song> al;
    ArrayAdapter<Song> aa;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Initialize views
        etTitle = findViewById(R.id.editTextTitle);
        etSingers = findViewById(R.id.editTextSingers);
        etYear = findViewById(R.id.editTextYear);
        etStars = findViewById(R.id.editTextStars);
        btnInsert = findViewById(R.id.btnUpdate);
        btnShowList = findViewById(R.id.btnDelete);
        lv = findViewById(R.id.lv);

        al = new ArrayList<Song>();
        aa = new ArrayAdapter<Song>(this,
                android.R.layout.simple_list_item_1, al);
        lv.setAdapter(aa);


        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                DBHelper db = new DBHelper(MainActivity.this);
//                db.insertSong(etTitle.getText().toString(), etSingers.getText().toString(), etYear.getText().toString(), etStars.getText().toString());
//                db.close();
//                Toast.makeText(MainActivity.this, "Song inserted successfully", Toast.LENGTH_SHORT).show();
                insertSongRecord();
            }
        });

        // Set click listener for Show List button
        btnShowList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                DBHelper db = new DBHelper(MainActivity.this);
//                al.addAll(db.getAllSongs());
//                db.close();
//                aa.notifyDataSetChanged();
//                startActivity(new Intent(MainActivity.this, MainActivity2.class));
                launchDisplayActivity();
            }
        });

//        btnShowList.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(MainActivity.this, MainActivity2.class));
//            }
//        });
    }
    private void insertSongRecord() {
        // Get the song details from the user input
        String title = "Song Title";
        String singers = "Song Singers";
        String year = "2021";
        String stars = "5";

        // Create an instance of the DBHelper class
        DBHelper dbHelper = new DBHelper(MainActivity.this);
        // Insert the song record into the database
        dbHelper.insertSong(title, singers, year, stars);
        dbHelper.close();

        // Show a success message to the user
        Toast.makeText(MainActivity.this, "Song record inserted successfully", Toast.LENGTH_SHORT).show();
    }

    private void launchDisplayActivity() {
        // Launch the DisplayActivity
        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
        startActivity(intent);
    }
}