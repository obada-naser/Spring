package asac.com.example.songr;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@Controller
//@RequestMapping("/homeController")
public class HomeController {

    @RequestMapping(value="/hello", method=RequestMethod.GET)
    @ResponseBody
    public String test(){

        return "Hello world";

    }

    @GetMapping("/")
    public String captilizingName(){


        return "Home" ;


    }

    @GetMapping("/captilizing/{name}")
//    @ResponseBody
    public String captilizingName(@PathVariable String name, Model model){

        name=name.toUpperCase(Locale.ROOT);
        model.addAttribute("name",name);


        return "Home" ;


    }

    @GetMapping("/album/gettingAlbum")
    public String addingAlbum(Model model){

        ArrayList songsList=new ArrayList();

        Album album1=new Album("Divide","Ed Sheeran",10,300,"https://upload.wikimedia.org/wikipedia/en/4/45/Divide_cover.png");
        Album album2=new Album("Lover","Taylor swift ",75,455,"https://media.pitchfork.com/photos/5f1e2abad421092dd8f6c7ca/1:1/w_320/Taylor_Swift_folklore.jpeg");
        Album album3=new Album("Room 93","Halsey",53,99,"https://m.media-amazon.com/images/I/41c0TtkGnBL.jpg");

        songsList.add(album1);

        songsList.add(album2);
        songsList.add(album3);


        model.addAttribute("albums",songsList);

        return "Home";




    }




}
