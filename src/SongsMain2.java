import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class SongsMain2 {
	public void manageUserSongs() {
		
	
		Scanner sc= new Scanner(System.in); 
//Creating user-song pairs
		
		Map<String,List<String>> usersongpairs=new HashMap<>();
		usersongpairs.put("U1", Arrays.asList("S1","S2","S3","S4"));
		usersongpairs.put("U2", Arrays.asList("S5","S6","S7","S8"));
		usersongpairs.put("U3", Arrays.asList("S1","S9"));
		

// Choosing user and his songs
		
		System.out.println("Which user do you choose: ");
		String user= sc.next();
		List<String> songs=new ArrayList<>();
		songs=retrieveSongsForUser(usersongpairs,user);
	
		
//Creating playlist
		
		
		System.out.println("Enter the initial capacity: ");
		int initialcapacity= sc.nextInt();
		
		List<String> playlist=new ArrayList<>();
		playlist=playlistCreation(initialcapacity,songs);
		
//Managing playlist	
		managePlaylist(initialcapacity,playlist);
		
		
		
	}
	public List<String> retrieveSongsForUser(Map<String,List<String>> usersongpairs,String user) {
		List<String> songs=new ArrayList<>();
		Iterator hmIterator = usersongpairs.entrySet().iterator();
		while (hmIterator.hasNext()) {
			
			 Map.Entry mapElement
             = (Map.Entry)hmIterator.next();
			 System.out.println(mapElement.getKey());
			 if(mapElement.getKey().toString().equalsIgnoreCase(user)) {
				 songs=(List<String>) mapElement.getValue();
				 break;
			 }
		}
		
		System.out.println("The songs are : "+ songs);
		return songs;
		
	}
	public List<String> playlistCreation(int initialcapacity,List<String> songs){
		List<String> playlist=new ArrayList<>();
		for(int i =0;i<initialcapacity;i++) {
			playlist.add(songs.get(i));
		}
		System.out.println("playlist"+playlist);
		return playlist;
		
	}
	public void managePlaylist(int initialcapacity,List<String> playlist) {
		Scanner sc= new Scanner(System.in); 
		String c="Y";
		while(c.equalsIgnoreCase("Y")) {
			System.out.println("Choose a song to play");
			String playedSong= sc.next();
			for(int i =0;i<initialcapacity-1;i++) {
				playlist.set(i, playlist.get(i+1));
			}
			playlist.set(initialcapacity-1, playedSong);
			System.out.println("Your current playlist :"+playlist);
			System.out.println("Do you want to continue(Y/N): ");
			c= sc.next();
			//c=c1;
			
		}
		
		
	}

	
}
