package com.example.musicapphibernate.model;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


public class SongForm {
    private int id;

    @NotEmpty
    @NotBlank(message = "Name is required")
    @Size(max = 800,message = "Name must be less than 800 characters")
    @Pattern(regexp = "^\\w+$", message = "Name contains invalid characters")
    private String name;

    @NotBlank(message = "Artist is required")
    @Size(max = 300, message = "Artist must be less than 300 characters")
    @Pattern(regexp = "^\\w+$",message = "Artist contains invalid characters")
    private String artist;

    @NotBlank(message = "Genres is required")
    @Size(max = 1000,message = "Genre must be less than 1000 characters")
    @Pattern(regexp = "^\\w+$",message = "Genre contains invalid characters")
    private String genre;
    private MultipartFile filePath;

    public SongForm() {
    }

    public SongForm(int id, String name, String artist, String genre, MultipartFile filePath) {
        this.id = id;
        this.name = name;
        this.artist = artist;
        this.genre = genre;
        this.filePath = filePath;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public MultipartFile getFilePath() {
        return filePath;
    }

    public void setFilePath(MultipartFile filePath) {
        this.filePath = filePath;
    }
}
