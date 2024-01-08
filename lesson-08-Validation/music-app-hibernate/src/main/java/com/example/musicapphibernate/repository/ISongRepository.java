package com.example.musicapphibernate.repository;

import com.example.musicapphibernate.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISongRepository extends JpaRepository<Song,Integer> {
}
