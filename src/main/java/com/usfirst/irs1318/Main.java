package com.usfirst.irs1318;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class Main {
	public static void main(String [] args) {
		Injector injector = Guice.createInjector(new SimulationModule());
		Controller controller = injector.getInstance(Controller.class);
		controller.run();
	} 
}
