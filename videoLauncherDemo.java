package special;

import java.util.Scanner;

 class Video {
	String videoName;
	boolean checkout;
	int rating;
	
	Video(String name){
		videoName=name;
	}
	
	public String getName() {
		return videoName;
	}
	
	public void doCheckout() {
		checkout = true;
	}
	
	public void doReturn() {
		checkout = false;
	}
	
	public void receiveRating(int rating) {
		this.rating = rating;
	}
	
	public int getRating() {
		return rating;
	}
	
	public boolean getCheckout() {
		return checkout;
	}	
}

 class VideoStore {
	Video[] store;
	
	public int checkVideo(String name) {
		int flag = 0;
		
		for(Video video:store) {
				if(video.getName().equals(name))
					flag = 1;
		}
		return flag;
	}
	
	public void addVideo(String name) {
		int size;
		Video video = new Video(name);
		try {
			size = store.length;
		} catch (Exception e) {
			size = 0;
		}
		Video[] newStore = new Video[size + 1];
		newStore[size] = video;
		store = newStore;
	}
	
	public void doCheckout(String name) {
		if(store==null || store.length==0) {
			System.out.println("Store is empty");
			return;
		}
		for(Video video :store) {
			if(video.getName().equals(name)) {
				video.doCheckout();
			}
		}
	}
		
	public void doReturn(String name) {
		if(store==null || store.length==0) {
			System.out.println("Store is empty");
			return;
		}
		for(Video video :store) {
			if(video.getName().equals(name)) {
				video.doReturn();
			}
		}
	}
	
	public void receiveRating(String name , int rating) {
		if(store==null || store.length==0) {
			System.out.println("Store is empty");
			return;
		}
		for(Video video :store) {
			if(video.getName().equals(name)) {
				video.receiveRating(rating);
			}
		}
	}
	
	public void listInventory() {
		if (store == null || store.length == 0) {
			System.out.println("Store is empty");
			return;
		}
		for (Video video : store) {
			System.out.print("---------------------------------------------------------------------------");
			System.out.printf("\n\t%-20s\t|\t%-10s\t|\t%-15s\n", "Video Name","Checkout Status","Rating");
			System.out.printf("\n\t%-20s\t|\t%-10s\t|\t%-15s\n", video.getName(), video.getCheckout(),video.getRating());
			System.out.println("---------------------------------------------------------------------------");
		}
	}
}


public class videoLauncherDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int input = 0;
		Scanner scan = new Scanner(System.in);
		VideoStore videoStore = new VideoStore();

		while(input !=6) {
			System.out.println("\n1. Add Videos : "+"\n"+"2. Check Out Video : "+"\n"+"3. Return Video : "+
					   "\n"+"4. Receive Rating : "+"\n"+"5. List Inventory : "+"\n"+"6. Exit : ");
			System.out.print("Enter Your Choice (1..6) : ");
			
			String name;
			input = scan.nextInt();
			scan.nextLine();
			
			switch(input) {
			case 1: 
				System.out.print("Enter the name of video you want to add: ");
				name = scan.nextLine();
				videoStore.addVideo(name);
				System.err.print("video "+ name + " added successfully.");
				break;
					
			case 2: 
				System.out.print("Enter the name of video you want to check out: ");
				name = scan.nextLine();
				if(videoStore.checkVideo(name) == 0) {
					System.err.print("Video does not exist");
				}
				else {
					videoStore.doCheckout(name);
					System.err.print("video "+ name + " checked out successfully.");
				}
				break;
					
			case 3: 
				System.out.print("Enter the name of video you want to return: ");
				name = scan.nextLine();
				if(videoStore.checkVideo(name) == 0) {
					System.err.print("Video does not exist");
				}
				else {
					videoStore.doReturn(name);
					System.err.print("video "+ name + " returned successfully.");
				}			
				break;
				
			case 4: 
				System.out.print("Enter the name of video you want to rate: ");
					name = scan.nextLine();
					if(videoStore.checkVideo(name) == 0) {
						System.err.print("Video does not exist");
					}
					else{
						System.out.print("Enter the rating for this video: ");
						int rating = scan.nextInt();
						videoStore.receiveRating(name, rating);
						System.err.print("Rating "+rating+" has been mapped to video "+ name +".");
					}
					break;
					
			case 5: 
				videoStore.listInventory();
				break;
				
			default:
				System.out.println("Exiting the page...!! Thanks for using this page.");
				break;
			}
		}
	}

 }