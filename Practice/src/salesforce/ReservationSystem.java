package salesforce;

import java.util.HashMap;
import java.util.Map;

public class ReservationSystem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class Train {
	private String trainName;
	private String trainId;
	private int capacity;
	private int numberOfACCoaches;
	private int numberOfNonACCoaches;
	private Map<Station,Double> trainStationsWithFares;
	
	public Train(String traiString,String traiId,int capacity,int numberOfACCoaches,int numberOfNonACCoaches,
			Station[] stations) {
		// Initialize ID,name,capacity,numberOfACCoaches etc. and create a hashmap with all stations and
        // zero fare initially for all stations.
       
        trainStationsWithFares = new HashMap<Station, Double>();
        for(Station s : stations) 
        	trainStationsWithFares.put(s, new Double(0.0));
    

    // Getters and Setters (including methods to add new stations with fares and
    // update fares of existing stations
		
	}
}

class Station {
	private String stationName;
	private String stationId;
}

class TicketDetails {
	private Train t;
	private Passenger p;
	private String stationFrom;
	private String stationTo;
	
	public TicketDetails(Train t,Passenger p,String stationFrom,String stationTo) {
		
	}
	//Getters and Setters to change the ticket details
}

class Passenger {
	private String Name; 
	private int citizenID; 
	private int age; 
	private String gender;
	
	public Passenger(String name,int id,int age,String gender) {
		
	}
}

class TrainTicket {
	private int ID;
	private TicketDetails ticketDetails;
	private Double fare;
	
	public TrainTicket(int ID,TicketDetails ticketDetails) {
		calculateFare();
	}
	
	public void calculateFare(){
		
	}
}

