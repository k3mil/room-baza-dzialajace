package com.example.room;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.room.Room;

public class MainActivity extends AppCompatActivity {

    FilmyDataBaseYo filmyDataBase;
    Button buttonDodaj;
    EditText editTextTytul;
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
        filmyDataBase = Room.databaseBuilder(
                getApplicationContext(),
                FilmyDataBaseYo.class,
                "kino_db"
        ).allowMainThreadQueries()
                .build();
        //filmyDataBase.zwrocFilmyDao().wstawDoBazyFilmy(
                //new Film("Eyes wide shut", 2007,"dokument")
        buttonDodaj = findViewById(R.id.button);
        editTextTytul = findViewById(R.id.editTextText);
        buttonDodaj.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Film film = new Film(editTextTytul.getText().toString(),
                                2000,
                                "dokument");
                        filmyDataBase.zwrocFilmyDao().wstawDoBazyFilmy(film);
                    }
                }
        );
    }
}