package thread;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Room {
	private boolean isAvailable = true;
	private Lock lock = new ReentrantLock();
	static Random random = new Random();
 // To do .. Boolean arr[24].. lock on arr[0] and arr[1] to lock the room for 2 hours
	
	public boolean reserve() throws InterruptedException {
		if (!isAvailable) {
			return false;
		}
		boolean gotLock = false;
		try {
			if (gotLock = lock.tryLock(5, TimeUnit.SECONDS)) {
				if (!isAvailable) {
					return false;
				}
				Thread.sleep(random.nextInt(10000));
				isAvailable = false;
				return true;
			}
			else {
				System.out.println("cannot obtain lock");
			}
		} catch (Exception e) {
			//handle exception
			return false;
		}
		finally {
			if (gotLock) {
				lock.unlock();
			}
		}
		
		return false;
	}
}

public class ConferenceReservation extends Thread {

	private Room room;
	
	public ConferenceReservation(Room room) {
		this.room = room;
	}
	
	public static void main(String[] args) {
		Room r = new Room();
		ConferenceReservation cr1 = new ConferenceReservation(r);
		ConferenceReservation cr2 = new ConferenceReservation(r);
		
		cr1.bookRoom();
		cr2.bookRoom();
	}
	
	public void bookRoom() {
		start();
	}
	
	public void run(){
		try {
			if(room.reserve()) {
				System.out.println("Room Reserved by "+Thread.currentThread().getName());
			} else {
				System.out.println(Thread.currentThread().getName()+" cannot reserve room");
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
