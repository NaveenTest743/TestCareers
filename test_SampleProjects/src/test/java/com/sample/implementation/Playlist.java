package com.sample.implementation;
import java.util.LinkedList;

public class Playlist {
    private LinkedList<String> songs;
    private int capacity;

    public Playlist(int capacity) {
        this.songs = new LinkedList<>();
        this.capacity = capacity;
    }

    public void playSong(String song) {
        if (songs.contains(song)) {
            songs.remove(song);
        }

        songs.addFirst(song);

        if (songs.size() > capacity) {
            songs.removeLast();
        }
    }

    public void displayPlaylist() {
        System.out.println("Current playlist:");
        for (String song : songs) {
            System.out.print(song + ",");
        }
        System.out.println();
    }

    public String getCurrentPlaylist() {
        StringBuilder playlistBuilder = new StringBuilder();
        for (String song : songs) {
            playlistBuilder.append(song).append(",");
        }
        return playlistBuilder.toString();
    }
}
