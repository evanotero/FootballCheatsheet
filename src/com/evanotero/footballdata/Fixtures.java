/**
 * 
 * @author evanotero
 *
 * The class Fixtures holds all data for the list of fixtures
 * 
 */

package com.evanotero.footballdata;

public class Fixtures {
	
	public class Result {
		int goalsHomeTeam;
		int goalsAwayTeam;
	}
	
    private String date;
    private String status;
    private Integer matchday;
    private String homeTeamName;
    private String awayTeamName;
	private Result result;

    public String getDate() { return date; }
    public String getStatus() { return status; }
    public Integer getMatchday() { return matchday; }
    public String getHomeTeamName() { return homeTeamName; }
    public String getAwayTeamName() { return awayTeamName; }
    public Result getResult() { return result; }

    public void setDate(String date) { this.date = date; }
    public void setStatus(String status) { this.status = status; }
    public void setMatchday(Integer matchday) { this.matchday = matchday; }
    public void setHomeTeamName(String homeTeamName) { this.homeTeamName = homeTeamName; }
    public void setAwayTeamName(String awayTeamName) { this.awayTeamName = awayTeamName; }
    public void setResult(Result result) { this.result = result; }

    public String winLoss(String club) {
    	if (homeTeamName.equals(club) && result.goalsHomeTeam>result.goalsAwayTeam) {
    		return "W";
    	} else if (awayTeamName.equals(club) && result.goalsHomeTeam<result.goalsAwayTeam) {
    		return "W";
    	} else if (result.goalsHomeTeam==result.goalsAwayTeam) {
    		return "D";
    	} else {
    		return "L";
    	}
    }
    
    public String score() {
    	if (status.equals("FINISHED")) {
    		return result.goalsHomeTeam+"-"+result.goalsAwayTeam;
    	} else return null;
    }
    
    public String convertDate(String timezone) {
    	int usHour;
    	int conversion = 0; //GMT
    	String convertedDate;
    	
    	if (timezone.equals("CET")) { conversion = 1; }
    	if (timezone.equals("GMT")) { conversion = 0; }
    	if (timezone.equals("AST")) { conversion = -4; }
    	if (timezone.equals("EST")) { conversion = -5; }
    	if (timezone.equals("CST")) { conversion = -6; }
    	if (timezone.equals("MST")) { conversion = -7; }
    	if (timezone.equals("PST")) { conversion = -8; }
    	if (timezone.equals("AKST")) { conversion = -9; }
    	if (timezone.equals("HST")) { conversion = -10; } 	
    	
    	if (date!=null) {
	    	String[] split = date.split("T");
	    	String[] split2 = split[0].split("-");
	    	convertedDate = split2[1]+"/"+split2[2]+"/"+split2[0];
	    	String[] split3 = split[1].split(":");
	    	Integer hour = Integer.parseInt(split3[0])+conversion; //convert to timezone
	    	if (hour > 12) usHour = hour - 12;
	    	else usHour = hour;
	    	convertedDate += " @ "+usHour+":"+split3[1];
	    	
	    	if (hour<12) convertedDate += " am";
	    	else convertedDate += " pm";
	    	
	    	return convertedDate;
    	} return null;
    }
    
    public String toString(String timezone, String club) {
    	if (status.equals("FINISHED")) {    		
    		/* Include Matchday // Disabled by default
    		return String.format("Matchday:%-3d Score:%-20s %24s vs. %s", matchday, score, homeTeamName, awayTeamName);*/
    		return String.format("Score:%-5s %-14s %24s vs. %s", score(), winLoss(club), homeTeamName, awayTeamName);
    	} else {
    		/* Include Matchday // Disabled by default
    		return String.format("Matchday:%-3d Date:%-21s %24s vs. %s", matchday, date, homeTeamName, awayTeamName);*/
    		return String.format("Date:%-21s %24s vs. %s", convertDate(timezone), homeTeamName, awayTeamName);
    	}
    }
}
