/**
 * 
 * @author Evan Otero
 * 
 * The driver class for ApplicationFrame GUI.  Contains initialization
 * functions and the main method for users to run.
 * 
 * @author John Donaldson
 * @author Benjamin Kuperman
 * @author Alexa Sharp * 
 * 
*/

package com.evanotero.footballcheatsheet;

import java.awt.*;
import java.awt.event.*;

import com.evanotero.footballcontainer.*;
import com.evanotero.footballdata.*;
import com.google.gson.Gson;

public class MainApplication {
   boolean packFrame = false;
   
   //Construct the application
   public MainApplication() {
      final ApplicationFrame frame = new ApplicationFrame();
      //Validate frames that have preset sizes
      //Pack frames that have useful preferred size info, e.g. from their layout
      if (packFrame) {
         frame.pack();
      }
      else {
         frame.validate();
      }
      
      //Center the window
      Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
      Dimension frameSize = frame.getSize();
      if (frameSize.height > screenSize.height) {
         frameSize.height = screenSize.height;
      }
      if (frameSize.width > screenSize.width) {
         frameSize.width = screenSize.width;
      }
      frame.setLocation((screenSize.width - frameSize.width) / 2,
                        (screenSize.height - frameSize.height) / 2);
      frame.setVisible(true);
      
      // -- Initialize the ActionListener for buttons ---------------------
      
      // League ComboBox
      frame.addActionListener( new ActionListener() {
    	  public void actionPerformed(ActionEvent e) {
    		  if ((frame.cbLeagues.getSelectedItem()+"").equals("Premier League 2015/16")) {
    			  frame.cbSpanish.setVisible(false);
    			  frame.cbEnglish.setVisible(true);
    		  }
    		  if ((frame.cbLeagues.getSelectedItem()+"").equals("Primera Division 2015/16")) {
    			  frame.cbEnglish.setVisible(false);
    			  frame.cbSpanish.setVisible(true);
    		  }
    	  }
      });
      
      // Load Button
      frame.addButtonListener(0, new ActionListener(){
         public void actionPerformed(ActionEvent e) {
        	String selected;
        	if ((frame.cbLeagues.getSelectedItem()+"").equals("Premier League 2015/16")) {
        		selected  = frame.cbEnglish.getSelectedItem()+"";
        	} else {
        		selected  = frame.cbSpanish.getSelectedItem()+"";
        	}
        	int teamValue=-1;
        	int tableValue=-1;
        	String output="";
        	String output2="";
        	String url = "http://api.football-data.org/v1/teams/";
        	String url2 = "/fixtures";
        	String urlT = "http://api.football-data.org/v1/soccerseasons/";
        	String urlT2 = "/leagueTable";
        	
        	/* Assign selected team a value */
        	if (selected.equals("Athletic Club")) { 
        		teamValue = 77;
        		tableValue = 399;
        	}
        	if (selected.equals("Club Atlético de Madrid")) { 
        		teamValue = 78;
        		tableValue = 399;
        	}
        	if (selected.equals("FC Barcelona")) { 
        		teamValue = 81; 
        		tableValue = 399;
        	}
        	if (selected.equals("Real Betis")) { 
        		teamValue = 90; 
        		tableValue = 399;
        	}
        	if (selected.equals("RC Celta de Vigo")) { 
        		teamValue = 558;
        		tableValue = 399;
        	}
        	if (selected.equals("RC Deportivo La Coruna")) { 
        		teamValue = 560; 
        		tableValue = 399;
        	}
        	if (selected.equals("SD Eibar")) { 
        		teamValue = 278;
        		tableValue = 399;
        	}
        	if (selected.equals("RCD Espanyol")) { 
        		teamValue = 80;
        		tableValue = 399;
        	}
        	if (selected.equals("Getafe CF")) { 
        		teamValue = 82;
        		tableValue = 399;
        	}
        	if (selected.equals("Granada CF")) { 
        		teamValue = 83;
        		tableValue = 399;
        	}
        	if (selected.equals("Málaga CF")) { 
        		teamValue = 84;
        		tableValue = 399;
        	}
        	if (selected.equals("Rayo Vallecano de Madrid")) { 
        		teamValue = 87;
        		tableValue = 399;
        	}
        	if (selected.equals("Real Madrid CF")) { 
        		teamValue = 86;
        		tableValue = 399;
        	}
        	if (selected.equals("Real Sociedad de Fútbol")) { 
        		teamValue = 92;
        		tableValue = 399;
        	}
        	if (selected.equals("Sevilla FC")) { 
        		teamValue = 559;
        		tableValue = 399;
        	}
        	if (selected.equals("Sporting Gijón")) { 
        		teamValue = 96;
        		tableValue = 399;
        	}
        	if (selected.equals("Valencia CF")) { 
        		teamValue = 95;
        		tableValue = 399;
        	}
        	if (selected.equals("Villarreal CF")) { 
        		teamValue = 94;
        		tableValue = 399;
        	}
        	/* ----- Prem League ----- */
        	if (selected.equals("Arsenal FC")) { 
        		teamValue = 57;
        		tableValue = 398;
        	}
        	if (selected.equals("Aston Villa FC")) { 
        		teamValue = 58;
        		tableValue = 398;
        	}
        	if (selected.equals("AFC Bournemouth")) { 
        		teamValue = 1044;
        		tableValue = 398;
        	}
        	if (selected.equals("Chelsea FC")) { 
        		teamValue = 61;
        		tableValue = 398;
        	}
        	if (selected.equals("Crystal Palace FC")) { 
        		teamValue = 354;
        		tableValue = 398;
        	}
        	if (selected.equals("Everton FC")) { 
        		teamValue = 62;
        		tableValue = 398;
        	}
        	if (selected.equals("Leicester City FC")) { 
        		teamValue = 338;
        		tableValue = 398;
        	}
        	if (selected.equals("Liverpool FC")) { 
        		teamValue = 64;
        		tableValue = 398;
        	}
        	if (selected.equals("Manchester City FC")) { 
        		teamValue = 65;
        		tableValue = 398;
        	}
        	if (selected.equals("Manchester United FC")) { 
        		teamValue = 66;
        		tableValue = 398;
        	}
        	if (selected.equals("Newcastle United FC")) { 
        		teamValue = 67;
        		tableValue = 398;
        	}
        	if (selected.equals("Norwich City FC")) { 
        		teamValue = 68;
        		tableValue = 398;
        	}
        	if (selected.equals("Southampton FC")) { 
        		teamValue = 340;
        		tableValue = 398;
        	}
        	if (selected.equals("Stoke City FC")) { 
        		teamValue = 70;
        		tableValue = 398;
        	}
        	if (selected.equals("Sunderland AFC")) { 
        		teamValue = 71;
        		tableValue = 398;
        	}
        	if (selected.equals("Swansea City FC")) { 
        		teamValue = 72;
        		tableValue = 398;
        	}
        	if (selected.equals("Tottenham Hotspur FC")) { 
        		teamValue = 73;
        		tableValue = 398;
        	}
        	if (selected.equals("Watford FC")) { 
        		teamValue = 346;
        		tableValue = 398;
        	}
        	if (selected.equals("West Bromwich Albion FC")) { 
        		teamValue = 74;
        		tableValue = 398;
        	}
        	if (selected.equals("West Ham United FC")) { 
        		teamValue = 563;
        		tableValue = 398;
        	}
        	/**/
        	
        	/* Create url for team and collect data on schedule */
        	if (teamValue != -1) {
            	url += teamValue+url2; // contruct url based on selected team
	            String jsonFixture = collectData.getJSON(url, 2000); // Request json data
	      	  	ScheduleDataContainer dataFixture = new Gson().fromJson(jsonFixture, ScheduleDataContainer.class); // Organize json data
	      	  	for(Fixtures fixture : dataFixture.fixtures) {
	      	  		output+=(fixture.toString(frame.tz.getSelectedItem()+"",selected)+"\n");
	      	  	}	            
	            frame.setScheduleArea(output);
            } else frame.setScheduleArea("error");
        	
        	/* Create url for team and collect data on table */
        	if (tableValue != -1) {
        		output2+=("#   Club                      GP    PTS    W    D    L    GF    GA    GD"+"\n"); // Header
        		urlT += tableValue+urlT2; // contruct url based on selected team
	      	  	String jsonTable = collectData.getJSON(urlT, 2000); // Request json data
	      	  	TableDataContainer dataTable = new Gson().fromJson(jsonTable, TableDataContainer.class); // Organize json data
	    	  	for(Standing team : dataTable.standing) {
	    	  		output2+=(team+"\n");
	    	  	}	            
	            frame.setTableDisplayArea(output2);
        	} else frame.setTableDisplayArea("error");
            
         }
      });
      
      // Clear Button
      frame.addButtonListener(1, new ActionListener() {
         public void actionPerformed(ActionEvent e){
        	 frame.setTableDisplayArea("");
        	 frame.setScheduleArea("");
         }
      });
      
      // Quit Button
      frame.addButtonListener(2, new ActionListener() {
         public void actionPerformed(ActionEvent e){
            System.exit(0);
         }
      });
      
   }
   
   // Main method
   public static void main(String[] args) {
      new MainApplication();
   }
}
