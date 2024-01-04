package com.example.musicapphibernate.service;

import com.example.musicapphibernate.model.Song;

import java.util.List;

public interface ISongService {
    List<Song> findAll();
    Song findById(int id);
    void save(Song song);
    void remove(int id);
}
