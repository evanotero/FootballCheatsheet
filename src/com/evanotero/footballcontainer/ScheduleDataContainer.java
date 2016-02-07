/**
 * 
 * @author evanotero
 *
 * The class ScheduleDataContainer is a container 
 * of the JSON response that represents the outer object.
 *
 */

package com.evanotero.footballcontainer;

import com.evanotero.footballdata.Fixtures;

public class ScheduleDataContainer {
	private int count;
	public Fixtures[] fixtures;
	
	public int getCount() {
		return count;		
	}
	
	public void setCount(int count) {
		this.count = count;
	}
	
	public Fixtures[] getFixtures() {
		return fixtures;
	}
	
	public void setFixtures(Fixtures[] fixtures) {
		this.fixtures = fixtures;
	}	
}
