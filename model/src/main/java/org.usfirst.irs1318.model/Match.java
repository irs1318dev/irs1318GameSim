package org.usfirst.irs1318.model;

import java.util.Objects;

public class Match {

	private final MatchAlliance blueAlliance;
	private final MatchAlliance redAlliance;
	private final MatchActor field; // create MatchField class

    public Match(MatchAlliance blueAlliance, MatchAlliance redAlliance, MatchActor field) {
        this.blueAlliance = blueAlliance;
        this.redAlliance = redAlliance;
        this.field = field;
    }

    public MatchAlliance getBlueAlliance() {
        return blueAlliance;
    }

    public MatchAlliance getRedAlliance() {
        return redAlliance;
    }

    public MatchActor getField() {
        return field;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Match match = (Match) o;
        return Objects.equals(blueAlliance, match.blueAlliance) &&
                Objects.equals(redAlliance, match.redAlliance) &&
                Objects.equals(field, match.field);
    }

    @Override
    public int hashCode() {

        return Objects.hash(blueAlliance, redAlliance, field);
    }

    @Override
    public String toString() {
        return "Match{" +
                "blueAlliance=" + blueAlliance +
                ", redAlliance=" + redAlliance +
                ", field=" + field +
                '}';
    }

    public static class Builder {

		private MatchAlliance blueAlliance;
		private MatchAlliance redAlliance;
        private MatchActor field;

        public Builder setBlueAlliance(MatchAlliance blueAlliance) {
            this.blueAlliance = blueAlliance;
            return this;
        }

        public Builder setRedAlliance(MatchAlliance redAlliance) {
            this.redAlliance = redAlliance;
            return this;
        }

        public Builder setField(MatchActor field) {
            this.field = field;
            return this;
        }

        public Match build() {
			return new Match(blueAlliance, redAlliance, field);
		}
	}
}
