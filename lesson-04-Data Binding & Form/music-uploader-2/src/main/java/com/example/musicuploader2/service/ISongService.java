package com.example.musicuploader2.service;



import com.example.musicuploader2.model.Song;

import java.util.List;

public interface ISongService {
    List<Song> findAll();
    void save(Song song);
    void edit(int id, Song song);
    Song findById(int id);
    void remove(int id);
}
