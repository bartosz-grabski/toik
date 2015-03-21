package pl.edu.agh.iisg.pizzadelivery.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import pl.edu.agh.iisg.pizzadelivery.IPizzaDelivery;
import pl.edu.agh.iisg.pizzadelivery.Pizza;

public class PizzaChut implements IPizzaDelivery {
	
	private List<Pizza> pizzas;
	
	public PizzaChut() {
		// TODO Auto-generated constructor stub
		this.pizzas = new ArrayList<>();
		this.pizzas.add(new Pizza("Pizza1", 10));
		this.pizzas.add(new Pizza("Pizza2", 20));
		this.pizzas.add(new Pizza("Pizza3", 30));
	}

	@Override
	public Collection<Pizza> getAllPizzas() {
		// TODO Auto-generated method stub
		return this.pizzas;
	}

}
