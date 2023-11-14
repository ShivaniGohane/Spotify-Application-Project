package Listenify;

import java.util.ArrayList;
import java.util.List;

public class Album {
    private String singerName;
    private List<Song> songList;

    public Album(String singerName){
        this.singerName = singerName;
        this.songList = new ArrayList<>();
    }
    public Album(String singerName, List<Song> songList) {
        this.singerName = singerName;
        this.songList = songList;
    }
    public boolean findSongInAlbum(String songName){
        //return t/f
        for(Song s : songList){
            if(s.getSongName().equals(songName)){
                return true;
            }
        }
        return false;
    }
    public String addSongToAlbum(String songName, double duration){
        if(findSongInAlbum(songName)){
            return "Song is already present in Album";
        }
        Song newSong = new Song(songName, duration);
        songList.add(newSong);
        return "New Song has been added";
    }
    public String addSongToPlayList(int songNo, List<Song> playList){
        int index = songNo -1;
        if(index>=0 && index<songList.size()){
            Song songObj = songList.get(index);
            playList.add(songObj);
            return "Song has been added to the playList";
        }
        return "Song no entered is Invalid";
    }
    public String addSongToPlayList(String songName, List<Song> playList){
        for(Song s : songList){
            if(s.getSongName().equals(songName)){
                playList.add(s);
                return "Song added to PlayList";
            }
        }
        return "No song with songName existed in album SongList";
    }
}
