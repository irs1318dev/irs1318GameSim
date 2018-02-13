package com.usfirst.irs1318;

import java.util.stream.Stream;

import com.google.inject.Inject;

public class Controller {
	
	private final MatchSimulator simulator; 
	private final SimulationSetup setup; 
	private final SimulatorVisualization visualization;
	private final Logger logger;
	
	@Inject
	public Controller(MatchSimulator simulator, SimulationSetup setup, SimulatorVisualization visualization, Logger logger) {
		this.simulator = simulator;
		this.setup = setup;
		this.visualization = visualization;
		this.logger = logger;
		
	}
	public void run() {
		Stream<Event> events = setup.getEventStream(); 
		events.forEach(event -> 
		    event.getMatches().stream().forEach(match -> {
		    		MatchResults matchResults = simulator.runMatch(match);
		    		visualization.displayMatchResults(matchResults);
		    }
		  )
		);
		
//		// Event event = events.findFirst().get();
//		// event needs a collection of qualifier matches and playoff matches
//		// for each match, call runMatch
//		Match match = null;
//		MatchResults matchResults = simulator.runMatch(match);
//		visualization.displayMatchResults(matchResults);
		
	}
}
