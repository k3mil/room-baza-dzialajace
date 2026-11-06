package com.example.room;
import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Film.class}, version = 1)
public abstract class FilmyDataBaseYo extends RoomDatabase {
    public abstract FilmDAO zwrocFilmyDao();
}
