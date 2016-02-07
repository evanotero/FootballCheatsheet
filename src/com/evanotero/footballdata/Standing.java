/**
 * 
 * @author evanotero
 *
 * The class Standing holds all data for the list of teams in the standings
 * 
 */

package com.evanotero.footballdata;

public class Standing {
	
	public class home {
		int goals;
		int goalsAgainst;
		int wins;
		int draws;
		int losses;
	}
	
	public class away {
		int goals;
		int goalsAgainst;
		int wins;
		int draws;
		int losses;
	}
	
    private Integer position;
    private String teamName;
    private Integer playedGames;
    private Integer points;
    private Integer goals;
	private Integer goalsAgainst;
	private Integer goalDifference;
	private Integer wins;
	private Integer draws;
	private Integer losses;
	
	
	public Integer getPosition() { return position; }
	public String getTeamName() { return teamName; }
	public Integer getPlayedGames() { return playedGames; }
	public Integer getPoints() { return points; }
	public Integer getGoals() { return goals; }
	public Integer getGoalsAgainst() { return goalsAgainst; }
	public Integer getGoalDifference() { return goalDifference; }
	public Integer getWins() { return wins; }
	public Integer getDraws() { return draws; }
	public Integer getLosses() { return losses; }
	
    public void setPosition(Integer position) { this.position = position; }
    public void setTeamName(String teamName) { this.teamName = teamName; }
    public void setPlayedGames(Integer playedGames) { this.playedGames = playedGames; }
    public void setPoints(Integer points) { this.points = points; }
    public void setGoals(Integer goals) { this.goals = goals; }
    public void setGoalsAgainst(Integer goalsAgainst) { this.goalsAgainst = goalsAgainst; }
    public void setGoalDifference(Integer goalDifference) { this.goalDifference = goalDifference; }
    public void setWins(Integer wins) { this.wins = wins; }
    public void setDraws(Integer draws) { this.draws = draws; }
    public void setLosses(Integer losses) { this.losses = losses; }
    
    public String toString() {
    	return String.format("%-3d %-25s %-5d %-6d %-4d %-4d %-4d %-5d %-5d %d",
    			position, teamName, playedGames, points, wins, draws, losses, goals, goalsAgainst, goalDifference);
    }

}
