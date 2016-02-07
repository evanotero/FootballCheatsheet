/**
 * 
 * @author evanotero
 *
 * The class Fixtures holds all data for the individual team
 * 
 */

package com.evanotero.footballdata;


public class Team {
	String name;
	String code;
	String shortName;
	String squadMarketValue;
	String crestUrl;
	
	public String getName() { return name; }
	public String getCode() { return code; }
	public String getShortName() { return shortName; }
	public String getSquadMarketVale() { return squadMarketValue; }
	public String getCrestUrl() { return crestUrl; }
	
	public void setName(String name) { this.name = name; }
	public void setCode(String code) { this.code = code; }
	public void setShortName(String shortName) { this.shortName = shortName; }
	public void setSquadMarketValue(String squadMarketValue) { this.squadMarketValue = squadMarketValue; }
	public void setCrestUrl(String crestUrl) { this.crestUrl = crestUrl; }
	
}
