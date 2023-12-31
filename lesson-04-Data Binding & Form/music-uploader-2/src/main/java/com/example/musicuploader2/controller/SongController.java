package com.example.musicuploader2.controller;


import com.example.musicuploader2.model.Song;
import com.example.musicuploader2.model.SongForm;
import com.example.musicuploader2.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/song")
public class SongController {

    @Autowired
    private ISongService songService;
    @Value("${file-upload}")
    private String fileUpload;

    @GetMapping("")
    public ModelAndView showUploadForm() {
        ModelAndView modelAndView = new ModelAndView("uploadForm");
        modelAndView.addObject("songForm", new SongForm());
        return modelAndView;
    }

    @PostMapping("/upload")
    public ModelAndView handelFileUpload(@ModelAttribute("songForm") SongForm songForm) {
        MultipartFile multipartFile = songForm.getFile();
        if (!multipartFile.getOriginalFilename().endsWith(".mp3")
                && !multipartFile.getOriginalFilename().endsWith(".wav")
                && !multipartFile.getOriginalFilename().endsWith(".ogg")
                && !multipartFile.getOriginalFilename().endsWith(".m4p")
        ){
            ModelAndView modelAndView = new ModelAndView("redirect:/song");
            modelAndView.addObject("message","Only receive files with format .mp3, .wav, .ogg, .m4p");
            return modelAndView;
        }
        Song newSong = new Song(songForm.getId(),songForm.getName(), songForm.getArtist(), songForm.getGenre(), multipartFile.getOriginalFilename());
        songService.save(newSong);
        try {
            FileCopyUtils.copy(songForm.getFile().getBytes(), new File(fileUpload + multipartFile.getOriginalFilename()));
        }catch (IOException e){
            e.printStackTrace();
        }
        ModelAndView modelAndView = new ModelAndView("redirect:/songList");
        modelAndView.addObject("message", "Uploaded song successfully !");
        return modelAndView;
    }
    @GetMapping("/songlist")
    public ModelAndView showSongList(){
        ModelAndView modelAndView = new ModelAndView("songList");
        List<Song> songs = songService.findAll();
        modelAndView.addObject("songs", songs);
        return modelAndView;
    }
}
