package com.example.musicuploader2.controller;


import com.example.musicuploader2.model.Song;
import com.example.musicuploader2.model.SongForm;
import com.example.musicuploader2.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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


    @PostMapping("/save")
    public ModelAndView saveProduct(@ModelAttribute SongForm songForm,
                                    BindingResult bindingResult,
                                    RedirectAttributes redirectAttributes) {

        MultipartFile multipartFile = songForm.getFile();
        if (multipartFile == null || multipartFile.isEmpty()) {
            bindingResult.rejectValue("file", "file.empty", "Vui lòng chọn một file.");
            return new ModelAndView("uploadForm");
        }

        String fileName = multipartFile.getOriginalFilename();
        if (!isValidFileExtension(fileName)) {
            bindingResult.rejectValue("file", "file.invalid", "Chỉ chấp nhận file có đuôi .mp3, .wav, .ogg, .m4p");
            return new ModelAndView("uploadForm");
        }
        try {
            FileCopyUtils.copy(multipartFile.getBytes(), new File(fileUpload + fileName));
        } catch (IOException ex) {
            ex.printStackTrace();
            redirectAttributes.addFlashAttribute("message", "Lỗi khi lưu trữ file.");
            return new ModelAndView("redirect:/song");
        }
        Song song = new Song(songForm.getId(), songForm.getName(),
                songForm.getArtist(),songForm.getGenre(), fileName);
        songService.save(song);
        ModelAndView modelAndView = new ModelAndView("redirect:/song/list");
        modelAndView.addObject("songForm", songForm);
        modelAndView.addObject("message", "Tải lên bài hát thành công!");
        return modelAndView;
    }

    private boolean isValidFileExtension(String fileName) {
        return fileName.toLowerCase().endsWith(".mp3") ||
                fileName.toLowerCase().endsWith(".wav") ||
                fileName.toLowerCase().endsWith(".ogg") ||
                fileName.toLowerCase().endsWith(".m4p");
    }
    @GetMapping("/list")
    public ModelAndView showSongList(){
        ModelAndView modelAndView = new ModelAndView("songLis" +
                "t");
        List<Song> songs = songService.findAll();
        modelAndView.addObject("songs", songs);
        return modelAndView;
    }
}
