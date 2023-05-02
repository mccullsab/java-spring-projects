package com.abbymcculloch.lookify.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abbymcculloch.lookify.models.Song;
import com.abbymcculloch.lookify.repositories.SongRepository;

@Service
public class SongService {
	
	
	@Autowired
	private SongRepository songRepository;
	
    // find all - returns all the songs
    public List<Song> allSongs() {
        return songRepository.findAll();
    }
    
    
    // find one - retrieves a song
    public Song findSong(Long id) {
        Optional<Song> optionalSong = songRepository.findById(id);
        if(optionalSong.isPresent()) {
            return optionalSong.get();
        } else {
            return null;
        }
    }
    
    // create - creates a song
    public Song createSong(Song b) {
        return songRepository.save(b);
    }
    
    // update - update a song
    public Song updateSong(Song b) {
        return songRepository.save(b);
    }
    
    //	delete - delete song
	public void removeSong(Long id) {
		songRepository.deleteById(id);
	}
	
//	artist search
	public List<Song> findByArtist(String artist) {
		return songRepository.findByArtistContaining(artist);
	}
	
	
}
