package com.sample.test;
import com.sample.implementation.*;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class testPlaylist {
    public Playlist playlist;

    @BeforeMethod
    public void setup() {
        playlist = new Playlist(3);
    }
   
    @Test
    public void testPlaylistOrderAfterSongsPlayed() {
        playlist.playSong("S1");
        playlist.playSong("S2");
        playlist.playSong("S3");
        Assert.assertEquals(playlist.getCurrentPlaylist(), "S3,S2,S1,");

        playlist.playSong("S4");
        Assert.assertEquals(playlist.getCurrentPlaylist(), "S4,S3,S2,");

        playlist.playSong("S2");
        Assert.assertEquals(playlist.getCurrentPlaylist(), "S2,S4,S3,");

        playlist.playSong("S1");
        Assert.assertEquals(playlist.getCurrentPlaylist(), "S1,S2,S4,");
    }

    @Test
    public void testPlaylistWithRepeatedSong() {
        playlist.playSong("S1");
        playlist.playSong("S2");
        playlist.playSong("S3");
        Assert.assertEquals(playlist.getCurrentPlaylist(), "S3,S2,S1,");

        playlist.playSong("S2");
        Assert.assertEquals(playlist.getCurrentPlaylist(), "S2,S3,S1,");

        playlist.playSong("S1");
        Assert.assertEquals(playlist.getCurrentPlaylist(), "S1,S2,S3,");
    }

	
	}


 