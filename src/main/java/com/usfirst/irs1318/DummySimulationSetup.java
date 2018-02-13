package com.usfirst.irs1318;

import java.util.stream.Stream;
import java.util.List;
import java.util.ArrayList;

public class DummySimulationSetup implements SimulationSetup{

	@Override
	public Stream<Event> getEventStream() {
		System.out.println("Simulation Setup has been called");
		List<Event> events = new ArrayList<>();
		for (int i=0; i<2; i++) {
			events.add(new Event(""+i));
		}
		
		return events.stream();
	
	}

}
