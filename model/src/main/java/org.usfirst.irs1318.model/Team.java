package org.usfirst.irs1318.model;

import com.google.common.collect.ImmutableSet;

import java.util.HashSet;
import java.util.Set;

public class Team {
	
	private final TeamRobot robot;
	private final ImmutableSet<TeamPerson> people;
	
	private Team(TeamRobot robot, ImmutableSet<TeamPerson> people) { // create TeamRobot and TeamPerson class
		this.robot = robot;
		this.people = people;
	}
	
	public TeamRobot getRobot() {
		return this.robot;
	}
	
	public ImmutableSet<TeamPerson> getPeople() {

	    return this.people;
	}
	
	public static class Builder {
		
		private TeamRobot robot;
		private Set<TeamPerson> people;
		
		public Builder() {
			this.people = new HashSet<TeamPerson>();
		}

		public Builder setRobot(TeamRobot robot) {
			this.robot = robot;
			return this;
		}
		
		public Builder setPeople(Set<TeamPerson> people) {
			this.people = people;
			return this;
		}
		
		public Team build() {
			return new Team(robot, ImmutableSet.copyOf(people));
		}
	}
}
