package pl.edu.agh.iisg.customer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import pl.edu.agh.iisg.pizzadelivery.IPizzaDelivery;
import pl.edu.agh.iisg.pizzadelivery.Pizza;

public class Activator implements BundleActivator {

	@Override
	public void start(BundleContext context) throws Exception {
		
		IPizzaDelivery service = context.getService(context.getServiceReference(IPizzaDelivery.class));
		for (Pizza p : service.getAllPizzas()) {
			System.out.println(p.getName());
		}

	}

	@Override
	public void stop(BundleContext context) throws Exception {
		// TODO Auto-generated method stub

	}

}
