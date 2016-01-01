package salesforce;

import static org.junit.Assert.assertEquals;
import org.junit.*;
import java.util.ArrayList;
import java.util.List;

public class Friend {

	private String name;
	private List<Friend> Friends;
	
	public Friend(String name){
		this.name = name;
		Friends = new ArrayList<Friend>(); 
	}
	
	public void makeFriend(Friend friend) {
		if(friend == null) {
			System.err.println("friend is null");
			return;
		}
		if(!this.Friends.contains(friend))
			this.Friends.add(friend);
		if(!friend.Friends.contains(this))
			friend.Friends.add(this);
	}
	
	public void unmakeFriend(Friend friend) {
		if(friend == null) {
			System.err.println("friend is null");
			return;
		}
		if(this.Friends.contains(friend))
			this.Friends.remove(friend);
		if(friend.Friends.contains(this))
			friend.Friends.remove(this);
	}
	
	public List<Friend> getDirectFriends() {
		return this.Friends;
		
	}
	
	public List<Friend> getIndirectFriends() {
		List<Friend> indirectFriends = new ArrayList<Friend>();
		indirectFriends.add(this);
		indirectFriends  = getIndirectFriendsRecursice(this, indirectFriends);
		indirectFriends.remove(this);
		for(Friend indirectFriend : indirectFriends) {
			if(this.Friends.contains(indirectFriend))
				indirectFriends.remove(indirectFriend);
		}
		
		return indirectFriends;
	}
	
	public List<Friend> getIndirectFriendsRecursice(Friend friend,List<Friend> indirectFriends){
		for(Friend directFriend : friend.Friends) {
			if(!indirectFriends.contains(directFriend)) {
				indirectFriends.add(directFriend);
				getIndirectFriendsRecursice(directFriend, indirectFriends);
			}
		}
		return indirectFriends;
		
	}
	
	
	public static void main(String[] args) {
		// Create friends
        Friend aaron = new Friend("Aaron");
        Friend bella = new Friend("Bella");
        Friend cindy = new Friend("Cindy");
        Friend david = new Friend("David");
        Friend elizabeth = new Friend("Elizabeth");
        Friend frank = new Friend("Frank");
        
        // call makeFriend on "Aaron" and "Bella"
        aaron.makeFriend(bella);

        // call makeFriend on "Bella" and "Cindy"
        bella.makeFriend(cindy);

        // call makeFriend on "Bella" and "David"
        bella.makeFriend(david);

        // call makeFriend on "David" and "Elizabeth"
        david.makeFriend(elizabeth);

        // call makeFriend on "Cindy" and "Frank"
        cindy.makeFriend(frank);
        
     // call getDirectFriends with "David" as the argument
        List<Friend> direct = david.getDirectFriends();
        
     // assert that David's direct friends are "Bella" and "Elizabeth"
        Assert.assertTrue(direct.size()==2);
        Assert.assertTrue(direct.contains(frank));
        Assert.assertTrue(direct.contains(elizabeth));


	}

}
