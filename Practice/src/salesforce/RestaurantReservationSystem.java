package salesforce;

public class RestaurantReservationSystem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class Table {
	private int tableID;
	private int capacity;
	
	public Table(int tableID,int capacity) {
		
	}
}	
//	int CheckTableAvailability(int NumPeople, time_t TimeOfBooking, int *tableNumber, time_t *alternativeTime) 
//	{
//	if(isTable_Available(NumPeople,TimeOfBooking))
//	{
//	*tableNUmber=isTable_Available(NumPeople,TimeOfBooking);
//	return 1;
//	}
//	if(alternate_time(NumPeople,TimeOfBooking))
//	{
//	alternatetime=alternate_time(NumPeople,TimeOfBooking)
//	return 2;
//	}
//	else
//	{
//	cout<<"no Booking possible";
//	return 0;
//	}
//
//	}
	//getters and setters


class Booking {
	private String bookingID;
	private Table t;
	private Double startTime;
	private CustomerDetails customerDeails;
	
}

class CustomerDetails {
	private String headPerson;
	private int totalPerson;
}
