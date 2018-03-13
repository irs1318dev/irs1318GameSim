package org.usfirst.irs1318.model;

import java.util.Objects;

public class MatchPerson {

    private final TeamPerson teamPerson;
    private final FieldSquare location; // make FieldSquare class
    private final String role;

    private MatchPerson(TeamPerson teamPerson, FieldSquare location, String role) {
        this.teamPerson = teamPerson;
        this.location = location;
        this.role = role;
    }

    public TeamPerson getTeamPerson() {
        return teamPerson;
    }

    public FieldSquare getLocation() {
        return location;
    }

    public String getRole() {
        return role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MatchPerson that = (MatchPerson) o;
        return Objects.equals(teamPerson, that.teamPerson) &&
                Objects.equals(location, that.location) &&
                Objects.equals(role, that.role);
    }

    @Override
    public int hashCode() {

        return Objects.hash(teamPerson, location, role);
    }

    @Override
    public String toString() {
        return "MatchPerson{" +
                "teamPerson=" + teamPerson +
                ", location=" + location +
                ", role='" + role + '\'' +
                '}';
    }

    public static class Builder {

        private TeamPerson teamPerson;
        private FieldSquare location; // make FieldSquare class
        private String role;

        public Builder setTeamPerson(TeamPerson teamPerson) {
            this.teamPerson = teamPerson;
            return this;
        }

        public Builder setLocation(FieldSquare location) {
            this.location = location;
            return this;
        }

        public Builder setRole(String role) {
            this.role = role;
            return this;
        }
        public MatchPerson build() {
            return new MatchPerson(teamPerson, location, role);
        }
    }
}
