package observer;

public class CurrentConditionDisplay implements Observer {

	private float temp;
	private Subject weatherData;   //store a reference to the subject. in future if we want un-register the observer
	
	public CurrentConditionDisplay(Subject weatherData) {
		this.weatherData = weatherData;
		weatherData.registerObserver(this);
	}
	
	public void update(float temp) {
		this.temp = temp;
	}
	
	public void display(){
		System.out.println(this.temp);
	}
}
