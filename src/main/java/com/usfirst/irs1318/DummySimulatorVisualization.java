package com.usfirst.irs1318;

public class DummySimulatorVisualization implements SimulatorVisualization{

	@Override
	public void initializeEvent(Event event) {
		// TODO Auto-generated method stub
		System.out.println("initialize event method has been called.");
	}

	@Override
	public void displayMatchResults(MatchResults matchResults) {
		// TODO Auto-generated method stub
		System.out.println("display match results has been called" + matchResults.getMatch().getName() );
		
	}


}
