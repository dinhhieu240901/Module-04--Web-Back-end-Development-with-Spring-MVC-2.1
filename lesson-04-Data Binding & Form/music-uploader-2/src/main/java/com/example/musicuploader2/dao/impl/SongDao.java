package com.example.musicuploader2.dao.impl;


import com.example.musicuploader2.dao.ISongDao;
import com.example.musicuploader2.model.Song;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class SongDao implements ISongDao {
    private static List<Song> songList ;
    static {
        songList= new ArrayList<>();
    }
    @Override
    public List<Song> findAll() {
        return songList;
    }

    @Override
    public void save(Song song) {
        songList.add(song);
    }

    @Override
    public void edit(int id, Song song) {
        int index = songList.indexOf(findById(id));
        songList.set(index,song);
    }

    @Override
    public Song findById(int id) {
        return songList.get(id);
    }

    @Override
    public void remove(int id) {
        songList.remove(id);
    }
}
