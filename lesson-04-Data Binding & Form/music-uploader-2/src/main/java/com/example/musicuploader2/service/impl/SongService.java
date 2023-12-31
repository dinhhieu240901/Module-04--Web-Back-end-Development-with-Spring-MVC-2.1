package com.example.musicuploader2.service.impl;

import com.example.musicuploader2.dao.ISongDao;
import com.example.musicuploader2.model.Song;
import com.example.musicuploader2.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SongService implements ISongService {
    @Autowired
    private ISongDao songDao;
    @Override
    public List<Song> findAll() {
        return songDao.findAll();
    }

    @Override
    public void save(Song song) {
        songDao.save(song);
    }

    @Override
    public void edit(int id, Song song) {
        songDao.edit(id,song);
    }

    @Override
    public Song findById(int id) {
        return songDao.findById(id);
    }

    @Override
    public void remove(int id) {
        songDao.remove(id);
    }
}
