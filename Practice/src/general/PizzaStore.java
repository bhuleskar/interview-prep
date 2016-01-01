package general;

public class PizzaStore {

	SimplePizzaFactory factory;
	
	public PizzaStore(SimplePizzaFactory factory) {
		this.factory = factory;
	}
	
	
	Pizza OrderPizza(String type){
		Pizza pizza;
		pizza = factory.createPizza(type);
		
		pizza.prepare();
		pizza.bake();
		pizza.deliver();
		
		return pizza;
	}
}

//Another benefit of using Factory design pattern in Java is that it encourages consistency in Code 
//since every time object is created using Factory rather than using different constructor at 
//different client side. I can have multiple pizzastore and if something changes in the SimplePizzaFactory, 
//cliens won't get affected. 

//Easy to extend the SimplePzzafactory rather extending all PizzaStore clients when you want to add more 
//pizza types or delete any pizza type. Don't need to make changes in every pizzastroe clients


