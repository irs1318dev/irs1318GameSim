package org.usfirst.irs1318.model;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;

import java.util.*;

public class Event {

	private final ImmutableList<Match> qualifiers;
	private final ImmutableList<Match> playoffs;
	private final ImmutableMap<String, Team> teams;

    public Event(ImmutableList<Match> qualifiers, ImmutableList<Match> playoffs, ImmutableMap<String, Team> teams) {
        this.qualifiers = qualifiers;
        this.playoffs = playoffs;
        this.teams = teams;
    }

	public ImmutableList<Match> getQualifiers() {

	    return qualifiers;
	}

	public ImmutableList<Match> getPlayoffs() {
		return playoffs;
	}

    public ImmutableMap<String, Team> getTeams() {
        return teams;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return Objects.equals(qualifiers, event.qualifiers) &&
                Objects.equals(playoffs, event.playoffs) &&
                Objects.equals(teams, event.teams);
    }

    @Override
    public int hashCode() {

        return Objects.hash(qualifiers, playoffs, teams);
    }

    @Override
    public String toString() {
        return "Event{" +
                "qualifiers=" + qualifiers +
                ", playoffs=" + playoffs +
                ", teams=" + teams +
                '}';
    }

    public static class Builder {

		private List<Match> qualifiers;
		private List<Match> playoffs;
		private Map<String, Team> teams;

		public Builder() {
			qualifiers = new ArrayList<>();
			playoffs = new ArrayList<>();
			teams = new HashMap<String, Team>();
		}

		public Builder setQualifiers(List<Match> qualifiers) {
			this.qualifiers = qualifiers;
			return this;
		}

		public Builder setPlayoffs(List<Match> playoffs) {
			this.playoffs = playoffs;
			return this;
		}

        public Builder setTeams(Map<String, Team> teams) {
            this.teams = teams;
            return this;
        }

        public Event build() {
			return new Event(ImmutableList.copyOf(qualifiers), ImmutableList.copyOf(playoffs), ImmutableMap.copyOf(teams));
		}
	}
}
