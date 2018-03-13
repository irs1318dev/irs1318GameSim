package org.usfirst.irs1318.model;

import java.util.Objects;

public class MatchRobot {

    private final TeamRobot teamRobot;
    private final FieldSquare location; // make FieldSquare class
    private final RobotNumber robotNumber;

    private MatchRobot(TeamRobot teamRobot, FieldSquare location, RobotNumber robotNumber) {
        this.teamRobot = teamRobot;
        this.location = location;
        this.robotNumber = robotNumber;
    }

    public TeamRobot getTeamRobot() {
        return teamRobot;
    }

    public FieldSquare getLocation() {
        return location;
    }

    public RobotNumber getRobotNumber() {
        return robotNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MatchRobot that = (MatchRobot) o;
        return Objects.equals(teamRobot, that.teamRobot) &&
                Objects.equals(location, that.location) &&
                Objects.equals(robotNumber, that.robotNumber);
    }

    @Override
    public int hashCode() {

        return Objects.hash(teamRobot, location, robotNumber);
    }

    @Override
    public String toString() {
        return "MatchRobot{" +
                "teamRobot=" + teamRobot +
                ", location=" + location +
                ", position='" + robotNumber + '\'' +
                '}';
    }

    public class Builder {

        private TeamRobot teamRobot;
        private FieldSquare location; // make FieldSquare class
        private RobotNumber robotNumber;

        public Builder setTeamRobot(TeamRobot teamRobot) {
            this.teamRobot = teamRobot;
            return this;
        }

        public Builder setLocation(FieldSquare location) {
            this.location = location;
            return this;
        }

        public Builder setRobotNumber(RobotNumber robotNumber) {
            this.robotNumber = robotNumber;
            return this;
        }

        public MatchRobot build() {
            return new MatchRobot(teamRobot, location, robotNumber);
        }
    }
}
