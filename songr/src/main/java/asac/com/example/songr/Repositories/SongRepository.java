package asac.com.example.songr.Repositories;

import asac.com.example.songr.Models.Song;
import org.springframework.data.repository.CrudRepository;

public interface SongRepository extends CrudRepository<Song,Integer> {


}
