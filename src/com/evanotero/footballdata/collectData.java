/**
 * @author Evan Otero
 * 
 * This class collects JSON responses from the football-data API in regards to current
 * fixtures and standings in the BPL and LFP.  Using the GSON library,
 * the JSON is deserialized.
 * 
 */

package com.evanotero.footballdata;

import java.io.*;
import java.net.*;
import javax.swing.*;

import com.evanotero.footballcontainer.*;
import com.google.gson.*;

public class collectData {
	
  /* Makes request at entered url and returns JSON response as a string */
  public static String getJSON(String url, int timeout) {
    HttpURLConnection c = null;
    try {
      URL u = new URL(url);
      c = (HttpURLConnection) u.openConnection();
      c.setRequestMethod("GET");
      c.setRequestProperty("Content-length", "0");
      c.setRequestProperty("X-Auth-Token", "602b52033cea415eb549b2cacc9a1cc0"); // API Token
      c.setUseCaches(false);
      c.setAllowUserInteraction(false);
      c.setConnectTimeout(timeout);
      c.setReadTimeout(timeout);
      c.connect();
      int status = c.getResponseCode();
      
      switch (status) {
        case 200:
        case 201:
          BufferedReader br = new BufferedReader(new InputStreamReader(c.getInputStream()));
          StringBuilder sb = new StringBuilder();
          String line;
          while ((line = br.readLine()) != null) {
            sb.append(line+"\n");
          }
          br.close();
          return sb.toString();
      }
      
    } catch (IOException ex) {
		JOptionPane.showMessageDialog(new JFrame(), ex.getMessage()+" - closing application.","Error",JOptionPane.ERROR_MESSAGE);
		System.exit(1);
    } finally {
      if (c != null) {
        try {
          c.disconnect();
        } catch (Exception ex) {
        	JOptionPane.showMessageDialog(new JFrame(), ex.getMessage()+" - closing application.","Error",JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
      }
    }
    return null;
  }
  
  /* For Testing - Prints out formatted Schedule and Standings */
  public static void main(String[] args) {
	  
	  System.out.println("-------------------------------------------------------------------------");
	  System.out.println("--------------------- FC Barcelona 2015/16 Schedule ---------------------");
	  System.out.println("-------------------------------------------------------------------------");
	  
	  String jsonFixture = getJSON("http://api.football-data.org/v1/teams/81/fixtures", 500);
	  ScheduleDataContainer dataFixture = new Gson().fromJson(jsonFixture, ScheduleDataContainer.class);
	  for(Fixtures fixture : dataFixture.fixtures) {
		  System.out.println(fixture);
	  }
	  
	  System.out.println();
	  System.out.println("-------------------------------------------------------------------------");
	  System.out.println("----------------- Primera Division 2015/16 League Table -----------------");
	  System.out.println("-------------------------------------------------------------------------");
	  System.out.println("#   Club                      GP    PTS    W    D    L    GF    GA    GD");
	  
	  String jsonTable = getJSON("http://api.football-data.org/v1/soccerseasons/399/leagueTable", 500);
	  TableDataContainer dataTable = new Gson().fromJson(jsonTable, TableDataContainer.class);
	  for(Standing team : dataTable.standing) {
		  System.out.println(team);
	  }
  }
}