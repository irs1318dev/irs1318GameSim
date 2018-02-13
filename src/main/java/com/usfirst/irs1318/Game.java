package com.usfirst.irs1318;

import java.awt.Event;
import java.util.stream.Stream;
import com.google.inject.AbstractModule;

public class Game extends AbstractModule {
	
	public void configure() {
		this.bind(SimulationSetup.class).to(DummySimulationSetup.class);
		this.bind(MatchSimulator.class).to(DummyMatchSimulator.class);
		this.bind(SimulatorVisualization.class).to(DummySimulatorVisualization.class);


	}

	/*
	 * private Object bind(Class<ISimulatorDummy> class1) { // TODO Auto-generated
	 * method stub return null; }
	 */

	// IMatchEngine to DummyMatchEngine


	public interface SimulationSetup {
		public Stream<Event> getEventStream();
		
	}

	public class DummySimulationSetup implements SimulationSetup {

		@Override
		public Stream<Event> getEventStream() {
			return Stream.of();
		}
	}


	public class DummyMatchSimulator implements MatchSimulator {

		@Override
		public MatchResults runMatch(Match match) {
			return null;
		}

	}

	public interface SimulatorVisulization {
		public void initializeEvent(Event event);

		public void displayMatchResults(MatchResults matchResults);
	}


}
