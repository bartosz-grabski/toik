package pl.edu.agh.iisg.toik.pizzadelivery.impl;

import java.util.ArrayList;
import java.util.Collection;

import pl.edu.agh.iisg.pizzadelivery.IPizzaDelivery;
import pl.edu.agh.iisg.pizzadelivery.Pizza;

public class PizzaOlimp implements IPizzaDelivery {

	Collection<Pizza> pizzas;

	public PizzaOlimp() {
		System.out.println("PizzaOlimp created.");
		pizzas = new ArrayList<>();
		pizzas.add(new Pizza("Olimp", 20));
	}

	@Override
	public Collection<Pizza> getAllPizzas() {
		return pizzas;
	}
	
	@Override
	public String toString() {
		return "PizzaOlimp";
	}

}
