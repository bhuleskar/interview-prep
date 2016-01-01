package salesforce;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Friendship {

	private static HashMap<String, ArrayList> frindship = new HashMap<String, ArrayList>();
	
	public static void makeFriend(String name1,String name2) {
		if(name1 == null || name2 == null) {
			System.err.println("Cannot make friendship. name value is null");
			return;
		}
		if(name1.length() == 0 || name2.length() == 0) {
			System.err.println("Cannot make friendship. name not specified");
			return;
		}
		if(frindship.containsKey(name1)) {
			ArrayList<String> myList = frindship.get(name1);
			myList.add(name2);
			frindship.put(name1, myList);
		}
		else {
			ArrayList<String> myList = new ArrayList<String>();
			myList.add(name2);
			frindship.put(name1,myList);
		}
		if(frindship.containsKey(name2)) {
			ArrayList<String> myList = frindship.get(name2);
			myList.add(name1);
			frindship.put(name2, myList);
		}
		else {
			ArrayList<String> myList = new ArrayList<String>();
			myList.add(name1);
			frindship.put(name2,myList);
		}
		
	}
	
	public static void unmakeFriend(String name1,String name2) {
		if(name1 == null || name2 == null) {
			System.err.println("Cannot make friendship. name value is null");
			return;
		}
		if(name1.length() == 0 || name2.length() == 0 || !frindship.containsKey(name1) || !frindship.containsKey(name2)) {
			System.err.println("Cannot make friendship. name not specified or not present");
			return;
		}
		//delete name2 from name1's friendlist
		if(frindship.containsKey(name1)) {
			ArrayList<String> myList = frindship.get(name1);
			myList.remove(name2);
			frindship.put(name1,myList);
		}
		else {
			System.err.println(name1+" doesn't exist");
		}
		//delete name1 from name2's friendlist
		if(frindship.containsKey(name2)) {
			ArrayList<String> myList = frindship.get(name2);
			myList.remove(name1);
			frindship.put(name2,myList);
		}
		else {
			System.err.println(name2+" doesn't exist");
		}
	}
	
	public static List<String> getDirectFriends(String name) {
		if(name == null) {
			System.err.println("name is null");
			return null;
		}
		if(name.length() == 0) {
			System.err.println("name value empty");
			return null;
		}
		return frindship.get(name);
	}
	
	public static List<String> getIndirectFriends(String name) {
		if(name == null) {
			System.err.println("name is null");
			return null;
		}
		if(name.length() == 0 || !frindship.containsKey(name) ) {
			System.err.println("name value empty or not present");
			return null;
		}
		
		List<String> indirectFriends = new ArrayList<String>();
		indirectFriends.add(name);
		indirectFriends =  getIndirectRecursive(name, indirectFriends);
		indirectFriends.remove(name);
		List<String> myFriends = frindship.get(name);
		for(int i=0 ;i<myFriends.size(); i++) {
			if(indirectFriends.contains(myFriends.get(i))) {
				indirectFriends.remove(myFriends.get(i));
			}
			else {
				continue;
			}
		}
		return indirectFriends;
		
	}
	
	private static List<String> getIndirectRecursive(String name,List<String> totalFriends) {
		List<String> directFriends = frindship.get(name);
		for(String friend : directFriends) {
			if(!totalFriends.contains(friend)){
				totalFriends.add(friend);
				getIndirectRecursive(friend, totalFriends);
			}
		}
		return totalFriends;
	}
	
	public static void main(String[] args) {
		makeFriend("Aaron", "Bella");
		makeFriend("Bella", "Cindy");
		makeFriend("Bella", "David");
		makeFriend("David", "Elizabeth");
		makeFriend("Cindy", "Frank");
		
		
		System.out.println(getIndirectFriends("Cindy"));
		

	}

}
