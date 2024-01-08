package com.example.musicapphibernate.controller;

import com.example.musicapphibernate.model.Song;
import com.example.musicapphibernate.model.SongForm;
import com.example.musicapphibernate.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/songs")
public class SongController {

    @Autowired
    private ISongService songService;
    @Value("${file-upload}")
    private String fileUpload;

    @GetMapping("/list")
    public String showAllSongs(Model model) {
        List<Song> songs = songService.findAll();
        model.addAttribute("songs", songs);
        return "list";
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("songForm", new SongForm());
        return modelAndView;
    }

    @PostMapping("/save")
    public ModelAndView saveSong(@Valid @ModelAttribute SongForm songForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            ModelAndView modelAndView = new ModelAndView("create");

            modelAndView.addObject("songForm", songForm);
            return modelAndView;
        }
        MultipartFile multipartFile = songForm.getFilePath();
        String fileName = multipartFile.getOriginalFilename();
        try {
            FileCopyUtils.copy(songForm.getFilePath().getBytes(), new File(fileUpload + fileName));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        Song song = new Song(songForm.getId(), songForm.getName(),
                songForm.getArtist(), songForm.getGenre(), fileName);
        songService.save(song);
        ModelAndView modelAndView = new ModelAndView("redirect:/songs/list");
        modelAndView.addObject("message", "Created new song successfully !");
        return modelAndView;
    }

    @PostMapping("/delete")
    public String deleteSong(@ModelAttribute Song song, RedirectAttributes redirect) {
        songService.remove(song.getId());
        redirect.addFlashAttribute("success", "Removed song successfully!");
        return "redirect:/songs/list";
    }

    @GetMapping("/{id}/edit")
    public String editSong(@PathVariable int id, Model model) {
        model.addAttribute("songForm", songService.findById(id));
        return "edit";
    }

    @PostMapping("/update")
    public String updateSong(@Valid @ModelAttribute("songForm") SongForm songForm, RedirectAttributes redirect, BindingResult result) {
        if(result.hasErrors()){
            return "edit";
        }

        MultipartFile multipartFile = songForm.getFilePath();

        if (multipartFile == null || multipartFile.isEmpty()) {
            redirect.addFlashAttribute("error", "Vui lòng chọn một file.");
            return "redirect:/songs/"+ songForm.getId()+"/edit";
        }

        String fileName = multipartFile.getOriginalFilename();
        System.out.println("File name: " + fileName);

        String fileExtension = getFileExtension(fileName);
        System.out.println("File extension: " + fileExtension);

        boolean validExtension = isValidFileExtension(fileExtension);
        System.out.println("Is valid extension: " + validExtension);

        if (!validExtension) {
            redirect.addFlashAttribute("error", "Chỉ chấp nhận file có đuôi .mp3, .wav, .ogg, .m4p");
            return "redirect:/songs/"+ songForm.getId()+"/edit";
        }
        else {
            try {
                FileCopyUtils.copy(songForm.getFilePath().getBytes(), new File(fileUpload + fileName));
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            Song song = new Song(songForm.getId(), songForm.getName(), songForm.getArtist(), songForm.getGenre(), fileName);
            songService.save(song);

            redirect.addFlashAttribute("success", "Update song successfully!");
            return "redirect:/songs/list";
        }
    }


    private String getFileExtension(String fileName) {
        String[] parts = fileName.split("\\.");
        return parts.length > 1 ? parts[parts.length - 1].toLowerCase() : "";
    }

    private boolean isValidFileExtension(String fileExtension) {
        return fileExtension.equals("mp3") ||
                fileExtension.equals("wav") ||
                fileExtension.equals("ogg") ||
                fileExtension.equals("m4p");
    }

}

