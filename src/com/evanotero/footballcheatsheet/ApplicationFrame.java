/**
 * 
 * @author Evan Otero
 * 
 * The main frame for the GUI.
 *
 * @author John Donaldson
 * @author Benjamin Kuperman (Spring 2007)
 */

package com.evanotero.footballcheatsheet;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ApplicationFrame extends JFrame {

 private static final long serialVersionUID = 1L;

 final static String[] buttonLabels = {"Load", "Clear", "Quit" };
 final static String[] timezones = {"CET","GMT","AST","EST","CST","MST","PST","AKST","HST"};
 final static String[] leagues = {"Premier League 2015/16","Primera Division 2015/16"};
 final static String[] choicesS = {"Athletic Club","Club Atlético de Madrid","FC Barcelona",
		 "Real Betis","RC Celta de Vigo","RC Deportivo La Coruna","SD Eibar","RCD Espanyol","Getafe CF",
		 "Granada CF","Málaga CF","Rayo Vallecano de Madrid","Real Madrid CF","Real Sociedad de Fútbol",
		 "Sevilla FC","Sporting Gijón","Valencia CF","Villarreal CF"};
 final static String[] choicesE = {"Arsenal FC","Aston Villa FC","AFC Bournemouth","Chelsea FC","Crystal Palace FC",
		 "Everton FC","Leicester City FC","Liverpool FC","Manchester City FC","Manchester United FC","Newcastle United FC",
		 "Norwich City FC","Southampton FC","Stoke City FC","Sunderland AFC","Swansea City FC","Tottenham Hotspur FC",
		 "Watford FC","West Bromwich Albion FC","West Ham United FC"};
    int nbuttons = 3;
    JButton[] button = new JButton[nbuttons];
    JLabel lbTimezone = new JLabel("Timezone:");
    JLabel lbLeague = new JLabel("League:");
    JLabel lbTeam = new JLabel("Club:");
    JComboBox<String> tz = new JComboBox<String>(timezones);
    JComboBox<String> cbSpanish = new JComboBox<String>(choicesS);
    JComboBox<String> cbEnglish = new JComboBox<String>(choicesE);
    JComboBox<String> cbLeagues = new JComboBox<String>(leagues);
    JTextArea tableDisplayArea = new JTextArea();
    JTextArea scheduleArea = new JTextArea();

    //Construct the frame
    public ApplicationFrame() {
        try {
            init();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    //Component initialization
    @SuppressWarnings("static-access")
	private void init() throws Exception  {

        // Some temp vars to handle the sub-panels
        JPanel jPanel1 = new JPanel();
        JPanel jPanel2 = new JPanel();

        // Basic properties for the window
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setDefaultLookAndFeelDecorated(true);
        this.setSize(new Dimension(1280, 720));
        this.setTitle("Football Cheatsheet");

        // Set up the overall window space
        JPanel contentPane = (JPanel) this.getContentPane();
        contentPane.setLayout(new BorderLayout());
        contentPane.setPreferredSize(new Dimension(1200, 280));
        contentPane.add(jPanel1, BorderLayout.CENTER);
        contentPane.add(jPanel2, BorderLayout.SOUTH);

        // Set up the top window for displaying data
        GridLayout gridLayout1 = new GridLayout();
        gridLayout1.setColumns(2);
        gridLayout1.setHgap(6);

        jPanel1.setLayout(gridLayout1);
        jPanel1.add(new JScrollPane(tableDisplayArea), null);
        jPanel1.add(new JScrollPane(scheduleArea), null);

        Font monospace = new Font("Monospaced", Font.PLAIN, 11);
        tableDisplayArea.setBorder(BorderFactory.createLoweredBevelBorder());
        //tableDisplayArea.setPreferredSize(new Dimension(140, 200));
        tableDisplayArea.setEditable(false);
        tableDisplayArea.setFont(monospace);

        scheduleArea.setBorder(BorderFactory.createLoweredBevelBorder());
        //scheduleArea.setPreferredSize(new Dimension(140, 200));
        scheduleArea.setEditable(false);
        scheduleArea.setFont(monospace);
        
        // Set up the button bar
        jPanel2.setLayout(new FlowLayout());
        jPanel2.setPreferredSize(new Dimension(1055, 40));
        // Add timezone label
        lbTimezone.setVisible(true);
        jPanel2.add(lbTimezone);
        // Add timezone combobox
        tz.setVisible(true);
        jPanel2.add(tz);
        // Add league label
        lbLeague.setVisible(true);
        jPanel2.add(lbLeague);
        // Add league combobox
        cbLeagues.setVisible(true);
        jPanel2.add(cbLeagues);
        // Add Team label
        lbTeam.setVisible(true);
        jPanel2.add(lbTeam);
        // Add Spanish teams combobox
        cbSpanish.setVisible(false); // Not visible by default      
        jPanel2.add(cbSpanish);
        //Add English teams combobox
        cbEnglish.setVisible(true); // Visible by default
        jPanel2.add(cbEnglish);
        
        for(int i=0; i<nbuttons; i++){
            button[i] = new JButton(buttonLabels[i]);
            jPanel2.add(button[i]);
        }
        button[nbuttons-1].setBackground(Color.RED);
        button[nbuttons-1].setForeground(Color.RED); // Quit button text is red
        
        button[nbuttons-2].setBackground(Color.RED);
        button[nbuttons-2].setForeground(Color.blue); // Clear button text is red
    }
    
    void addButtonListener(int buttonIndex, ActionListener listener){
        button[buttonIndex].addActionListener(listener);
    }
    
    void addActionListener(ActionListener listener) {
    	cbLeagues.addActionListener(listener);
    }

    void setScheduleArea(String text){
        scheduleArea.setText(text);
    }

    void setTableDisplayArea(String text){
        tableDisplayArea.setText(text);
    }
}
