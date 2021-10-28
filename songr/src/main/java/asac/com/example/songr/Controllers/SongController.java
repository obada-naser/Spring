package asac.com.example.songr.Controllers;


import asac.com.example.songr.Models.Album;
import asac.com.example.songr.Models.Song;
import asac.com.example.songr.Repositories.AlbumRepostitory;
import asac.com.example.songr.Repositories.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Controller
public class SongController {

    @Autowired
    SongRepository songRepository;
    @Autowired
    AlbumRepostitory albumRepostitory;


    @GetMapping("/allSongs")
    public String getAlbums(Model model){
        ArrayList<Song> songs= (ArrayList<Song>) songRepository.findAll();


        model.addAttribute("songs",songs);
        return "songs";
    }

    @





}
