package GitTest;

import java.util.ArrayList;
import java.util.List;

import lombok.NonNull;

public class Media implements IMedia {
	
	public List<String> mediaCollection = new ArrayList<String>();

	@Override
	public void AddMedia(@NonNull String path) {
		
		this.mediaCollection.add(path);	
		
	}
	

	/**
	 * @deprecated (Use RemoveMedia instead)
	 */
	@Deprecated
	@Override
	public void DeleteMedia(@NonNull String path) {
		
		for(int i = 0 ; i < mediaCollection.size(); ++i) {
			if(mediaCollection.get(i) == path) {
				mediaCollection.remove(i);
			}
		}
		
	}
	

	@Override
	public void RemoveMedia(@NonNull String path) {
		
		if(mediaCollection.indexOf(path) != -1) {
			mediaCollection.remove(mediaCollection.indexOf(path));
		}
		
	}
	
	
	public void ShowAllPaths() {
		
		System.out.println("\n ************** \n");
		
		for(String str : mediaCollection) {
			System.out.println(str);
		}
		
		System.out.println("\n ************** \n");
	}

}
