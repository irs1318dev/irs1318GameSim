package org.usfirst.irs1318.model;

import java.util.Objects;

public class Match {

	private final MatchAlliance blueAlliance;
	private final MatchAlliance redAlliance;

	private Match(MatchAlliance blueAlliance, MatchAlliance redAlliance) {
		this.blueAlliance = blueAlliance;
		this.redAlliance = redAlliance;
	}

	public MatchAlliance getBlue() {
		return this.blueAlliance;
	}

	public MatchAlliance getRed() {
		return this.redAlliance;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Match match = (Match) o;
		return Objects.equals(blueAlliance, match.blueAlliance) &&
				Objects.equals(redAlliance, match.redAlliance);
	}

	@Override
	public int hashCode() {

		return Objects.hash(blueAlliance, redAlliance);
	}

	@Override
	public String toString() {
		return "Match{" +
				"blueAlliance=" + blueAlliance +
				", redAlliance=" + redAlliance +
				'}';
	}

	public static class Builder {

		private MatchAlliance blueAlliance = new MatchAlliance.Builder().build();
		private MatchAlliance redAlliance = new MatchAlliance.Builder().build();

		public Builder() {

		}

		public Builder setBlue(MatchAlliance blue) {
			this.blueAlliance = blue;
			return this;
		}

		public Builder setRed(MatchAlliance red) {
			this.redAlliance = red;
			return this;
		}

		public Match build() {
			return new Match(blueAlliance, redAlliance);
		}
	}
}
