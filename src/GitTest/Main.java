package GitTest;

public class Main {

	public static void main(String[] args) {		
	
		Media media = new Media();
		
		// media.AddMedia(null);
		media.AddMedia("path to video");
		media.AddMedia("path to picture");
		media.AddMedia("path to audio");
		
		media.ShowAllPaths();
		
		media.DeleteMedia("path to audio");
		
		media.ShowAllPaths();
		
		media.RemoveMedia("path to picture");
		
		media.ShowAllPaths();

	}
}