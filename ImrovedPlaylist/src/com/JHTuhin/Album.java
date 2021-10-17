package com.JHTuhin;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Album {
    private String name;
    private String artist;
    private SongList songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs=new SongList();
    }

    public boolean addSong(String title, double duration){
        return this.songs.add(new Song(title,duration));
    }

    public boolean addToPlaylist(int trackNumber, LinkedList<Song> playList){
        Song checkedSong=this.songs.findSong(trackNumber);
        if(checkedSong!=null){
            playList.add(checkedSong);
            return true;
        }
        System.out.println("This album does not have a track "+trackNumber);
        return false;
    }

    public boolean addToPlaylist(String title, LinkedList<Song> playList){
        Song checkedSong= songs.findSong(title);
        if(checkedSong!=null){
            playList.add(checkedSong);
            System.out.println("Song: "+title+" is added to the play list");
            return true;
        }
        System.out.println("Song: "+title+" Does not exist");
        return false;
    }

    private class SongList{
        private ArrayList<Song> songs;

        public SongList() {
            this.songs=new ArrayList<Song>();
        }

        public boolean add(Song song){
            if(this.songs.contains(song)){
                return false;
            }
            this.songs.add(song);
            return true;
        }

        private Song findSong(String title){
            for(Song checkedSong: this.songs){
                if(checkedSong.getTitle().equals(title)){
                    return checkedSong;
                }
            }
            return null;
        }

        public Song findSong(int trackNumber){
            int index=trackNumber-1;
            if((index>=0) && (index<this.songs.size())){
                    return songs.get(index);
                }
            return null;
        }
    }
}

