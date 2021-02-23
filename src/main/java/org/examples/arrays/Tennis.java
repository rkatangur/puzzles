package org.examples.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * Right now Tennis supports a game between two players.
 * 
 * @author Raja Krishna
 *
 */

public class Tennis {

	private static final String ALL = "All";
	private static final String DEUCE = "Deuce";

	// Scores are recored in the player object
	private Player player_1;
	private Player player_2;

	public Tennis(Player player1, Player player2) {
		this.player_1 = player1;
		this.player_2 = player2;
	}

	// Incrementing points of a player by one
	private void incrementPoints(String playerName) {
		if (player_1.getName().equals(playerName)) {
			player_1.incrementPoints();
		} else if (player_2.getName().equals(playerName)) {
			player_2.incrementPoints();
		} else {
			throw new RuntimeException("No player found with name " + playerName + " to record points.");
		}
	}

	// Setting score for a specific player identified by name
	private void setScore(String playerName, int points) {
		if (player_1.getName().equals(playerName)) {
			player_1.setPoints(points);
		} else if (player_2.getName().equals(playerName)) {
			player_2.setPoints(points);
		} else {
			throw new RuntimeException("No player found with name " + playerName + " to record points.");
		}
	}

	// Incrementing points by id
	private void incrementPoints(Integer playerId) {
		if (player_1.getId() == playerId) {
			player_1.incrementPoints();
		} else if (player_2.getId() == playerId) {
			player_2.incrementPoints();
		} else {
			throw new RuntimeException("No player found with id " + playerId + " to record score.");
		}
	}

	String getFormattedScore() {
		int minusResult = Math.abs(this.player_1.getPoints() - this.player_2.getPoints());
		ScoreEnum pl1Score = ScoreEnum.getScoreEnum(player_1.getPoints());
		ScoreEnum pl2Score = ScoreEnum.getScoreEnum(player_2.getPoints());

		if (this.player_1.getPoints() < 3 && this.player_2.getPoints() < 3) {
			if (minusResult == 0) {
				ScoreEnum scoreEnum = ScoreEnum.getScoreEnum(player_1.getPoints());
				return buildScoreStrOnEqualPoints(scoreEnum);
			} else {
				return buildScoreStr(pl1Score, pl2Score);
			}
		} else {
			if (minusResult == 0) {
				return DEUCE;
			} else {
				Player playerLeading = (player_1.getPoints() > this.player_2.getPoints()) ? player_1 : player_2;

				if (playerLeading.getPoints() > 3) {
					if (minusResult == 1) {
						return String.format("Advantage %s", playerLeading.getName());
					} else {
						return String.format("Win for %s", playerLeading.getName());
					}
				} else {
					return buildScoreStr(pl1Score, pl2Score);
				}
			}
		}
	}

	private String buildScoreStrOnEqualPoints(ScoreEnum scoreEnum) {
		if (scoreEnum != null) {
			return String.format("%s-%s", scoreEnum.getName(), ALL);
		}
		return "";
	}

	private String buildScoreStr(ScoreEnum scoreEnum1, ScoreEnum scoreEnum2) {
		if (scoreEnum1 != null && scoreEnum2 != null) {
			return String.format("%s-%s", scoreEnum1.getName(), scoreEnum2.getName());
		}
		return "";
	}

	private static class Player {
		private final int id;
		private final String name;
		private int points;

		public Player(int id, String name) {
			this.id = id;
			this.name = name;
		}

		public int getId() {
			return id;
		}

		public void setPoints(int points2) {
			this.points = points2;
		}

		public String getName() {
			return name;
		}

		public int getPoints() {
			return points;
		}

		public void incrementPoints() {
			points = points + 1;
		}
	}

	private enum ScoreEnum {
		LOVE(0, "0", "Love"), FIFTEEN(1, "15", "Fifteen"), THIRTY(2, "30", "Thirty"), FORTY(3, "40", "Forty");

		private final int points;
		private final String scoreStr;
		private final String name;

		static Map<Integer, ScoreEnum> scoreMap = new HashMap<>();
		static {
			for (ScoreEnum sEnum : values()) {
				scoreMap.put(sEnum.points, sEnum);
			}
		}

		private ScoreEnum(int points, String scoreStr, String name) {
			this.points = points;
			this.scoreStr = scoreStr;
			this.name = name;
		}

		public String getName() {
			return name;
		}

		public static ScoreEnum getScoreEnum(int points) {
			ScoreEnum scoreEnum = scoreMap.get(points);
			return scoreEnum;
		}
	}

	public static void main(String[] args) {

		String PLAYER1 = "Player1";
		String PLAYER2 = "Player2";

		Object[][] sampleData = new Object[][] { { 0, 0, "Love-All" }, { 1, 1, "Fifteen-All" }, { 2, 2, "Thirty-All" },
				{ 3, 3, "Deuce" }, { 4, 4, "Deuce" }, { 1, 0, "Fifteen-Love" }, { 0, 1, "Love-Fifteen" },
				{ 2, 0, "Thirty-Love" }, { 0, 2, "Love-Thirty" }, { 3, 0, "Forty-Love" }, { 0, 3, "Love-Forty" },
				{ 4, 0, "Win for Player1" }, { 0, 4, "Win for Player2" }, { 4, 3, "Advantage Player1" },
				{ 3, 4, "Advantage Player2" }, { 5, 4, "Advantage Player1" }, { 4, 5, "Advantage Player2" },
				{ 15, 14, "Advantage Player1" }, { 14, 15, "Advantage Player2" }, { 6, 4, "Win for Player1" },
				{ 4, 6, "Win for Player2" }, { 16, 14, "Win for Player1" }, { 14, 16, "Win for Player2" } };

		for (int i = 0; i < sampleData.length; i++) {
			Player pl1 = new Player(1, PLAYER1);
			Player pl2 = new Player(2, PLAYER2);
			Tennis game = new Tennis(pl1, pl2);

			for (int j = 0; j < sampleData[i].length; j++) {
				if (j == 0) {
					game.setScore(PLAYER1, (int) sampleData[i][j]);
				} else if (j == 1) {
					game.setScore(PLAYER2, (int) sampleData[i][j]);
				} else {
					String formattedScore = game.getFormattedScore();
					if (!formattedScore.equals((String) sampleData[i][j])) {
						System.out.println("Score Result did not match " + formattedScore + " - " + sampleData[i][j]
								+ " for data at index " + i);
					} else {
						System.out.println("Score Result matched for sample data at index " + i);
					}
				}
			}
		}
	}

}
