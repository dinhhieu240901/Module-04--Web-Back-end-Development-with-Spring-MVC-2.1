package com.example.musicapphibernate.service.impl;

import com.example.musicapphibernate.model.Song;
import com.example.musicapphibernate.repository.ISongRepository;
import com.example.musicapphibernate.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SongService implements ISongService {

    @Autowired
    private ISongRepository songRepository;
    @Override
    public List<Song> findAll() {

        return songRepository.findAll();

    }

    @Override
    public Song findById(int id) {

        return songRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Song song) {
       songRepository.save(song);
    }


    @Override
    public void remove(Integer id) {
        songRepository.deleteById(id);
    }
}
