package asac.com.example.songr.Controllers;


import asac.com.example.songr.Models.Album;
import asac.com.example.songr.Repositories.AlbumRepostitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;

@Controller
@RequestMapping("/albumController")
public class AlbumController {
    @Autowired
    AlbumRepostitory albumRepostitory;

    @GetMapping("/album4")
    public RedirectView addAlbum(){
        Album album1=new Album("Divide","Ed Sheeran",10,300,"https://upload.wikimedia.org/wikipedia/en/4/45/Divide_cover.png");
        Album album2=new Album("Lover","Taylor swift ",75,455,"https://media.pitchfork.com/photos/5f1e2abad421092dd8f6c7ca/1:1/w_320/Taylor_Swift_folklore.jpeg");
        Album album3=new Album("Room 93","Halsey",53,99,"https://m.media-amazon.com/images/I/41c0TtkGnBL.jpg");
            albumRepostitory.save(album1);
            albumRepostitory.save(album2);
        albumRepostitory.save(album3);
        return new RedirectView("v2/albums");

    }

    @GetMapping("v2/albums")
    public String getAlbums(Model model){
        ArrayList<Album> albums1= (ArrayList<Album>) albumRepostitory.findAll();


        model.addAttribute("albums1",albums1);
        return "Home";
    }

    @PostMapping("v2/newAlbums")
    public RedirectView userAlbum(Model model,@RequestParam(value = "title") String title,
                                               @RequestParam(value="artist") String artist,
                                                 @RequestParam(value = "songCount") int songCount,
                                                    @RequestParam(value = "length") int length,
                                                    @RequestParam(value = "imageUrl") String imageUrl){
        Album album=new Album(title,artist,songCount,length,imageUrl);
        albumRepostitory.save(album);
        return new RedirectView("v2/newAlbums");
    }


    @GetMapping("v2/newAlbums")
    public String newAlbums(Model model){
        ArrayList<Album> albums2= (ArrayList<Album>) albumRepostitory.findAll();

        model.addAttribute("newAlbum",albums2);
        return "Home";
    }






}
