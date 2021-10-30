package asac.com.example.songr.Controllers;


import asac.com.example.songr.Models.Album;
import asac.com.example.songr.Models.Song;
import asac.com.example.songr.Repositories.AlbumRepostitory;
import asac.com.example.songr.Repositories.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

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

    @GetMapping("/albums/{id}")
    public String getSongs(@PathVariable("id") int id,Model model){
            model.addAttribute("album",albumRepostitory.findById(id).get());
            return "Album";
    }


    @PostMapping("/addingSong/{id}")
    public RedirectView addSong(@ModelAttribute Song song,@PathVariable("id") int id){
        song.setAlbum(albumRepostitory.findById(id).get());
        songRepository.save(song);
        return new RedirectView("/albums/{id}");
    }





}
