package pl.edu.agh.iisg.toik.customer;

import java.util.ArrayList;
import java.util.Collection;

import pl.edu.agh.iisg.pizzadelivery.IPizzaDelivery;

public class Customer {
	private Collection<IPizzaDelivery> pizzaDelivery = new ArrayList<>();

	public void activate() {
		System.out.println("Activate. Check all available pizzas.");
		listAll();
	}
	
	public void deactivate() {
		System.out.println("Deactivate. Check all available pizzas.");
		listAll();
	}

	public synchronized void setPizzaDelivery(IPizzaDelivery newPizzaDelivery) {
		System.out.println("setPizzaDelivery: " + newPizzaDelivery);
		this.pizzaDelivery.add(newPizzaDelivery);
	}

	public synchronized void unsetPizzaDelivery(IPizzaDelivery newPizzaDelivery) {
		System.out.println("remove: " + newPizzaDelivery);
		pizzaDelivery.remove(newPizzaDelivery);
	}
	
	public synchronized void listAll() {
		for(IPizzaDelivery delivery : pizzaDelivery) {
			System.out.println(delivery + ":\t" + delivery.getAllPizzas());			
		}
	}
}
