package com.example.musicapphibernate.service;

import com.example.musicapphibernate.model.Song;

import java.util.List;
import java.util.Optional;

public interface ISongService {
    List<Song> findAll();
    Song findById(int id);
    void save(Song song);
    void remove(Integer id);
}
