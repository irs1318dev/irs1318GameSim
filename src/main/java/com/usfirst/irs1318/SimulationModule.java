package com.usfirst.irs1318;

import com.google.inject.AbstractModule;

public class SimulationModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(SimulationSetup.class).to(DummySimulationSetup.class);
		bind(MatchSimulator.class).to(DummyMatchSimulator.class);
		bind(SimulatorVisualization.class).to(DummySimulatorVisualization.class);
		bind(Logger.class).to(SystemOutLogger.class);
	}

}
