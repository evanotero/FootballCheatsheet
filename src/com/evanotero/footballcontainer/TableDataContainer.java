/**
 * 
 * @author evanotero
 *
 * The class TableDataContainer is a container 
 * of the JSON response that represents the outer object.
 *
 */

package com.evanotero.footballcontainer;

import com.evanotero.footballdata.Standing;

public class TableDataContainer {
	private String leagueCaption;
	private int matchday;
	public Standing[] standing;
	
	public String getLeagueCaption() { return leagueCaption; }
	public void setLeagueCaption(String leagueCaption) { this.leagueCaption = leagueCaption; }
	
	public int getMatchday() { return matchday; }
	public void setMatchday(int matchday) { this.matchday = matchday; }
	
	public Standing[] getStanding() { return standing; }
	public void setStanding(Standing[] standing) { this.standing = standing; }
}
