package asac.com.example.songr;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class SongrApplicationTests {

	@Test
	void contextLoads() {
	}
	@Test
	public void testConstructor () {
		Album album1=new Album("Divide","Ed Sheeran",10,300,"https://upload.wikimedia.org/wikipedia/en/4/45/Divide_cover.png");
		String title = "Divide";
		String artist = "Ed Sheeran";
		int length = 300;
		int songCount = 10;
		String imageUrl = "https://upload.wikimedia.org/wikipedia/en/4/45/Divide_cover.png";

		assertEquals(title,album1.getTitle());
		assertEquals(artist,album1.getArtist());
		assertEquals(imageUrl,album1.getImageUrl());
		assertEquals(length,album1.getLength());
		assertEquals(songCount,album1.getSongCount());
	}

	@Test
	public void testSetters () {
		Album album1=new Album("Divide","Ed Sheeran",10,300,"https://upload.wikimedia.org/wikipedia/en/4/45/Divide_cover.png");
		album1.setTitle("Divide");
		assertEquals("Divide",album1.getTitle());
	}

	@Test
	public void testGetters () {
		Album album1=new Album("Divide","Ed Sheeran",10,300,"https://upload.wikimedia.org/wikipedia/en/4/45/Divide_cover.png");

		assertEquals("Ed Sheeran",album1.getArtist());
	}



}
