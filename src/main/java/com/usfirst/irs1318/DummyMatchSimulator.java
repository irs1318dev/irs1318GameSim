package com.usfirst.irs1318;

public class DummyMatchSimulator implements MatchSimulator
{
	@Override
	public MatchResults runMatch(Match match) {
	System.out.println("Match Simulator been called for "+match.getName());
	return new MatchResults(match); 
	}
}