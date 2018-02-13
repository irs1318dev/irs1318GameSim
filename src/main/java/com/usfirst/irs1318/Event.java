package com.usfirst.irs1318;

import java.util.List;
import java.util.ArrayList;

public class Event {
	private final String name;
	private final List<Match> matches = new ArrayList<>();
	public Event(String name) {
		this.name = name;
		for (int i=0; i<5; i++) {
			matches.add(new Match("Event " + name +", match "+i));
		}
	}
	
	public String getName() {
		return name;
	}
	
	public List<Match>  getMatches() {
		return matches;
	}
}
