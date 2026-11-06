package com.example.room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface FilmDAO {
    @Insert
    public void wstawDoBazyFilmy(Film film);

    @Insert
    public void wstawListeFilmowDoBazy(Film ... film);

    @Delete
    public void usunZBazy(Film film);

    @Update
    public void aktualizujFilmWBazie(Film film);

    @Query("SELECT * FROM film")
    public List<Film> zwrocWszystkieFilmyZBazy();

    @Query("SELECT tytul FROM film where rok >:rokParametr")
    public List<String> zwrocTytulyFilmowODanymRoku(int rokParametr);
}