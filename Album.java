import java.util.*;
public class Album {
	private String name;
	private String artist;
	private ArrayList<Song> songs;
	public Album(String name, String artist) {
		this.songs=new ArrayList<Song>();
		this.name = name;
		this.artist = artist;
	}
	public boolean addSong(String title,double duration) {
		if(findsong(title)==null) {
			this.songs.add(new Song(title, duration));
		 return true;
		}
		return false;
	}
	private Song findsong(String title) {
		for(Song checkedsong:this.songs) {
			if(checkedsong.getTitle().equals(title)) {
				return checkedsong;
			}
		}
		return null;
	}
	public boolean addToPlayList(int tracknumber,LinkedList<Song> playlist) {
		int index=tracknumber-1;
		if(index>=0&&index<=this.songs.size()) {
			playlist.add(this.songs.get(index));
			return true;
		}
		System.out.println("Then song is not in album");
		return false;
	}
	public boolean addToPlayList(String title,LinkedList<Song> playlist) {
		Song chekedSong=findsong(title);
		if(chekedSong!=null) {
			playlist.add(chekedSong);
			return true;
		}
		System.out.println("The song "+title+" is not in the album");
		return false;
	}
	
}
