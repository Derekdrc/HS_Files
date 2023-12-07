package may2017ia;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class GUI implements ActionListener { 
    int numTeams = 1;
    int goals;
    int assists;
    int points;
    int g1 = 0;
    int g2 = 0;
    int g3 = 0;
    int g4 = 0;
    int g5 = 0;
    int g6 = 0;
    int g7 = 0;
    int g8 = 0;
    int g9 = 0;
    int g10 = 0;
    int a1 = 0;
    int a2 = 0;
    int a3 = 0;
    int a4 = 0;
    int a5 = 0;
    int a6 = 0;
    int a7 = 0;
    int a8 = 0;
    int a9 = 0;
    int a10 = 0;
    JFrame window = new JFrame("Stats");
    JPanel main = new JPanel(new GridLayout(3,2));
    JPanel ovr = new JPanel(new GridLayout(3,2));
    JPanel tmBttn = new JPanel(new GridLayout(2,numTeams));
    JPanel tmName = new JPanel(new GridLayout(2,2));
    JPanel tm1 = new JPanel(new GridLayout(3,2));
    JPanel tm2 = new JPanel(new GridLayout(3,2));
    JPanel tm3 = new JPanel(new GridLayout(3,2));
    JPanel tm4 = new JPanel(new GridLayout(3,2));
    JPanel tm5 = new JPanel(new GridLayout(3,2));
    JPanel tm6 = new JPanel(new GridLayout(3,2));
    JPanel tm7 = new JPanel(new GridLayout(3,2));
    JPanel tm8 = new JPanel(new GridLayout(3,2));
    JPanel tm9 = new JPanel(new GridLayout(3,2));
    JPanel tm10 = new JPanel(new GridLayout(3,2));
    JPanel gameEntry = new JPanel(new GridLayout(5,2));
    JLabel title = new JLabel ("Stats Tracker");
    JLabel nTeamName = new JLabel("Please Name your team");
    JButton view = new JButton("View Overall Stats");
    JButton addEntry = new JButton("Add game entry");
    JButton newTeam = new JButton("Create new team");
    JButton cnfTeam = new JButton("Confirm Team Name");
    JLabel gtt = new JLabel("Go to Team:");
    JButton[] teams = new JButton[10]; //Limit of 10 teams for formatting
    JButton back = new JButton("Back");
    JLabel gs = new JLabel("Goals: " + goals);
    JLabel as = new JLabel("Assists: " + assists);
    JLabel pts = new JLabel("Points: ");
    JLabel gs1 = new JLabel("Goals: " + g1);
    JLabel as1 = new JLabel("Assists: " + a1);
    JLabel pts1 = new JLabel("Points: ");
    JLabel gs2 = new JLabel("Goals: " + g2);
    JLabel as2 = new JLabel("Assists: " + a2);
    JLabel pts2 = new JLabel("Points: ");
    JLabel gs3 = new JLabel("Goals: " + g3);
    JLabel as3 = new JLabel("Assists: " + a3);
    JLabel pts3 = new JLabel("Points: ");
    JLabel gs4 = new JLabel("Goals: " + g4);
    JLabel as4 = new JLabel("Assists: " + a4);
    JLabel pts4 = new JLabel("Points: ");
    JLabel gs5 = new JLabel("Goals: " + g5);
    JLabel as5 = new JLabel("Assists: " + a5);
    JLabel pts5 = new JLabel("Points: ");
    JLabel gs6 = new JLabel("Goals: " + g6);
    JLabel as6 = new JLabel("Assists: " + a6);
    JLabel pts6 = new JLabel("Points: ");
    JLabel gs7 = new JLabel("Goals: " + g7);
    JLabel as7 = new JLabel("Assists: " + a7);
    JLabel pts7 = new JLabel("Points: ");
    JLabel gs8 = new JLabel("Goals: " + g8);
    JLabel as8 = new JLabel("Assists: " + a8);
    JLabel pts8 = new JLabel("Points: ");
    JLabel gs9 = new JLabel("Goals: " + g9);
    JLabel as9 = new JLabel("Assists: " + a9);
    JLabel pts9 = new JLabel("Points: ");
    JLabel gs10 = new JLabel("Goals: " + g10);
    JLabel as10 = new JLabel("Assists: " + a10);
    JLabel pts10 = new JLabel("Points: ");
    JLabel gsOvr = new JLabel("Goals: " + goals);
    JLabel asOvr = new JLabel("Assists: " + assists);
    JLabel ptsOvr = new JLabel("Points: ");
    JLabel tm = new JLabel("Team");
    JTextField nameHere = new JTextField(20);
    String[] stringTeams = {"Team 1", "Team 2", "Team 3", "Team 4", "Team 5", "Team 6", "Team 7", "Team 8", "Team 9", "Team 10"}; 
    ArrayList<String> comboBox = new ArrayList<>();
    JComboBox teamsBox = new JComboBox(stringTeams);
    JButton gsbtn = new JButton("+1");
    JButton asbtn = new JButton("+1");
    JLabel ptsDisp = new JLabel("0");
    JButton finEnt = new JButton("Finish Entry");
    int[] txtGoals = new int[10];
    int[] txtAssists = new int[10];
    
    int gTot = 0;
    int aTot = 0;
    String name;
    
    
    
     
    
    
    public GUI() throws FileNotFoundException, IOException{
        main.add(title);
        main.add(view);
        view.addActionListener(this);
        main.add(addEntry);
        addEntry.addActionListener(this);
        main.add(newTeam);
        newTeam.addActionListener(this);
        main.add(gtt);
        main.add(tmBttn);
        window.add(main);
        window.setVisible(true);
        window.setSize(850,650);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        BufferedReader gbr = null;
        BufferedReader abr = null;
        
        gbr = new BufferedReader(new FileReader("src//texts//g1.txt"));
        g1 = Integer.parseInt(gbr.readLine());
        
        abr = new BufferedReader(new FileReader("src//texts//a1.txt"));
        a1 = Integer.parseInt(abr.readLine());
        if (new File("src//texts//teamnames.team").exists()){
            BufferedReader br = new BufferedReader(new FileReader("src//texts//teamnames.team"));
            name = br.readLine(); 
        
        while(name != null){
            teams[numTeams-1] = new JButton(name);
            tmBttn.add(teams[numTeams-1]);
            name = br.readLine();
            numTeams++;
            tmBttn.updateUI();
            main.updateUI();
        }
        if(numTeams!= 0){
            for (int i = 0; i < numTeams-1; i++){
                teams[i].addActionListener(this);
            }
        }
        br.close();
        if(numTeams > 10){
            newTeam.removeActionListener(this);
        }
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == newTeam){
            newTeam();
        }
        if (e.getSource() == cnfTeam){
            try {
                confirmTeam();
            } catch (IOException ex) {
                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource() == addEntry){
            addEntry();
        }
        if (e.getSource() == gsbtn){
            goals++;
            gs.setText("Goals: " + goals);
            ptsDisp.setText(Integer.toString(goals + assists));
        }
        if (e.getSource() == asbtn){
            assists++;
            as.setText("Assists: " + assists);
            ptsDisp.setText(Integer.toString(goals + assists));
        }
        if(e.getSource() == view){
            try {
                view();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(e.getSource() == back){
            goals = 0;
            assists = 0;
            gsbtn.removeActionListener(this);
            asbtn.removeActionListener(this);
            window.remove(gsbtn);
            window.remove(asbtn);
            window.remove(ovr);
            window.remove(gameEntry);
            window.remove(tm1);
            window.remove(tm2);
            window.remove(tm3);
            window.remove(tm4);
            window.remove(tm5);
            window.remove(tm6);
            window.remove(tm7);
            window.remove(tm8);
            window.remove(tm9);
            window.remove(tm10);
            window.remove(tmName);
            window.add(main);
            gs.setText("Goals: " + goals);
            as.setText("Assists: " + assists);
            pts.setText("Points: ");
            ptsDisp.setText(Integer.toString(goals + assists));
            main.updateUI();
        }
        if(e.getSource() == finEnt){
            try {
                finishEntry();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            window.remove(gameEntry);
            window.add(main);
            main.updateUI();
        }
        if (e.getSource() == teams[0]){
            try {
                BufferedReader gbr = null;
                BufferedReader abr = null;
                
                gbr = new BufferedReader(new FileReader("src//texts//g1.txt"));
                g1 = Integer.parseInt(gbr.readLine());
                
                abr = new BufferedReader(new FileReader("src//texts//a1.txt"));
                a1 = Integer.parseInt(abr.readLine());
                tm1();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource() == teams[1]){
            try {
                BufferedReader gbr = null;
                BufferedReader abr = null;
                
                gbr = new BufferedReader(new FileReader("src//texts//g2.txt"));
                g2 = Integer.parseInt(gbr.readLine());
                
                abr = new BufferedReader(new FileReader("src//texts//a2.txt"));
                a2 = Integer.parseInt(abr.readLine());
                tm2();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource() == teams[2]){
            try {
                BufferedReader gbr = null;
                BufferedReader abr = null;
                
                gbr = new BufferedReader(new FileReader("src//texts//g3.txt"));
                g3 = Integer.parseInt(gbr.readLine());
                
                abr = new BufferedReader(new FileReader("src//texts//a3.txt"));
                a3 = Integer.parseInt(abr.readLine());
                tm3();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource() == teams[3]){
            try {
                BufferedReader gbr = null;
                BufferedReader abr = null;
                
                gbr = new BufferedReader(new FileReader("src//texts//g4.txt"));
                g4 = Integer.parseInt(gbr.readLine());
                
                abr = new BufferedReader(new FileReader("src//texts//a4.txt"));
                a4 = Integer.parseInt(abr.readLine());
                tm4();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource() == teams[4]){
            try {
                BufferedReader gbr = null;
                BufferedReader abr = null;
                
                gbr = new BufferedReader(new FileReader("src//texts//g5.txt"));
                g5 = Integer.parseInt(gbr.readLine());
                
                abr = new BufferedReader(new FileReader("src//texts//a5.txt"));
                a5 = Integer.parseInt(abr.readLine());
                tm5();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource() == teams[5]){
            try {
                BufferedReader gbr = null;
                BufferedReader abr = null;
                
                gbr = new BufferedReader(new FileReader("src//texts//g6.txt"));
                g6 = Integer.parseInt(gbr.readLine());
                
                abr = new BufferedReader(new FileReader("src//texts//a6.txt"));
                a6 = Integer.parseInt(abr.readLine());
                tm6();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource() == teams[6]){
            try {
                BufferedReader gbr = null;
                BufferedReader abr = null;
                
                gbr = new BufferedReader(new FileReader("src//texts//g7.txt"));
                g7 = Integer.parseInt(gbr.readLine());
                
                abr = new BufferedReader(new FileReader("src//texts//a7.txt"));
                a7 = Integer.parseInt(abr.readLine());
                tm7();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource() == teams[7]){
            try {
                BufferedReader gbr = null;
                BufferedReader abr = null;
                
                gbr = new BufferedReader(new FileReader("src//texts//g8.txt"));
                g8 = Integer.parseInt(gbr.readLine());
                
                abr = new BufferedReader(new FileReader("src//texts//a8.txt"));
                a8 = Integer.parseInt(abr.readLine());
                tm8();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource() == teams[8]){
            try {
                BufferedReader gbr = null;
                BufferedReader abr = null;
                
                gbr = new BufferedReader(new FileReader("src//texts//g9.txt"));
                g9 = Integer.parseInt(gbr.readLine());
                
                abr = new BufferedReader(new FileReader("src//texts//a9.txt"));
                a9 = Integer.parseInt(abr.readLine());
                tm9();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource() == teams[9]){
            try {
                BufferedReader gbr = null;
                BufferedReader abr = null;
                
                gbr = new BufferedReader(new FileReader("src//texts//g10.txt"));
                g10 = Integer.parseInt(gbr.readLine());
                
                abr = new BufferedReader(new FileReader("src//texts//a10.txt"));
                a10 = Integer.parseInt(abr.readLine());
                tm10();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    public void newTeam(){
        window.remove(ovr);
        window.remove(gameEntry);
        window.remove(tm1);
        window.remove(tm2);
        window.remove(tm3);
        window.remove(tm4);
        window.remove(tm5);
        window.remove(tm6);
        window.remove(tm7);
        window.remove(tm8);
        window.remove(tm9);
        window.remove(tm10);
        window.remove(main);
        window.add(tmName);
        tmName.add(nTeamName);
        tmName.add(nameHere);
        tmName.add(back);
        tmName.add(cnfTeam);
        back.addActionListener(this);
        cnfTeam.addActionListener(this);
        tmName.updateUI();
    }
    
    public void confirmTeam() throws IOException{
        if (new File("src//texts//teamnames.team").exists()){
        BufferedWriter bw = new BufferedWriter(new FileWriter("src//texts//teamnames.team", true));
        BufferedReader br = new BufferedReader(new FileReader("src//texts//teamnames.team"));
        bw.write(nameHere.getText());
        bw.newLine();
        for(int i = 1; i <= numTeams-1; i++){
            name = br.readLine();
        }
            while(name != null){
            teams[numTeams-1] = new JButton(nameHere.getText());
            tmBttn.add(teams[numTeams-1]);
            name = br.readLine();
            teams[numTeams-1].addActionListener(this);
            numTeams++;
            tmBttn.updateUI();
            main.updateUI();
            }
        bw.close();
        br.close();
        if(numTeams > 10){
            newTeam.removeActionListener(this);
        }
        
        cnfTeam.removeActionListener(this);
        nameHere.setText(null);
        window.remove(tmName);
        window.add(main);
        main.updateUI();
    }else{
            BufferedWriter bw = new BufferedWriter(new FileWriter("src//texts//teamnames.team", true));
            bw.write(nameHere.getText());
            bw.newLine();
            teams[0] = new JButton(nameHere.getText());
            tmBttn.add(teams[0]);
            teams[0].addActionListener(this);
            numTeams++;
            tmBttn.updateUI();
            main.updateUI();
        }
    }
    
    public void view() throws FileNotFoundException{
        int pregTot = 0;
        int preaTot = 0;
        
        window.remove(main);
        window.add(ovr);
        ovr.updateUI();
        ovr.add(gsOvr);
        ovr.add(asOvr);
        ovr.add(ptsOvr);
        ovr.add(back);
        back.addActionListener(this);
        for(int i = 0; i<10; i++){
        Scanner sc = new Scanner(new File("src//texts//g"+(i+1)+".txt"));
        Scanner sc2 = new Scanner(new File("src//texts//a"+(i+1)+".txt"));
        txtGoals[i] = (sc.nextInt());
        txtAssists[i] = (sc2.nextInt());
        }
        for(int i = 0; i<10; i++){
            pregTot += txtGoals[i];
            preaTot += txtAssists[i];
        }
        gTot = pregTot;
        aTot = preaTot;
        gsOvr.setText("Goals: " + gTot);
        asOvr.setText("Assists: " + aTot);
        ptsOvr.setText("Points: " + (gTot+aTot));
    }
    
    public void addEntry(){
        window.remove(main);
        window.add(gameEntry);
        gameEntry.updateUI();
        gameEntry.add(tm);
        gameEntry.add(teamsBox);
        gameEntry.add(gs);
        gameEntry.add(gsbtn);
        gameEntry.add(as);
        gameEntry.add(asbtn);
        gameEntry.add(pts);
        gameEntry.add(ptsDisp);
        gameEntry.add(back);
        gameEntry.add(finEnt);
        goals = 0;
        assists = 0;
        points = 0;
        gs.setText("Goals: " + goals);
        as.setText("Assists: " + assists);
        pts.setText("Points: ");
        ptsDisp.setText(Integer.toString(goals + assists));
        back.addActionListener(this);
        teamsBox.addActionListener(this);
        gsbtn.addActionListener(this);
        asbtn.addActionListener(this);
        finEnt.addActionListener(this);
        
    }
    public void finishEntry() throws FileNotFoundException, IOException{
        int x = teamsBox.getSelectedIndex()+1;
        BufferedReader gbr = null;
        BufferedReader abr = null;
        if(x == 1){
            gbr = new BufferedReader(new FileReader("src//texts//g1.txt"));
            g1 = Integer.parseInt(gbr.readLine());
            int newg1 = goals + g1;
            PrintStream gWriter = new PrintStream("src//texts//g1.txt");
            gWriter.println(Integer.toString(newg1));
            
            abr = new BufferedReader(new FileReader("src//texts//a1.txt"));
            a1 = Integer.parseInt(abr.readLine());
            int newa1 = assists + a1;
            PrintStream aWriter = new PrintStream("src//texts//a1.txt");
            aWriter.println(Integer.toString(newa1));
            

        }else if(x == 2){
            gbr = new BufferedReader(new FileReader("src//texts//g2.txt"));
            g2 = Integer.parseInt(gbr.readLine());
            int newg2 = goals + g2;
            PrintStream gWriter = new PrintStream("src//texts//g2.txt");
            gWriter.println(Integer.toString(newg2));
            
            abr = new BufferedReader(new FileReader("src//texts//a2.txt"));
            a2 = Integer.parseInt(abr.readLine());
            int newa2 = assists + a2;
            PrintStream aWriter = new PrintStream("src//texts//a2.txt");
            aWriter.println(Integer.toString(newa2));
        }else if(x == 3){
            gbr = new BufferedReader(new FileReader("src//texts//g3.txt"));
            g3 = Integer.parseInt(gbr.readLine());
            int newg3 = goals + g3;
            PrintStream gWriter = new PrintStream("src//texts//g3.txt");
            gWriter.println(Integer.toString(newg3));
            
            abr = new BufferedReader(new FileReader("src//texts//a3.txt"));
            a3 = Integer.parseInt(abr.readLine());
            int newa3 = assists + a3;
            PrintStream aWriter = new PrintStream("src//texts//a3.txt");
            aWriter.println(Integer.toString(newa3));
        }else if(x == 4){
            gbr = new BufferedReader(new FileReader("src//texts//g4.txt"));
            g4 = Integer.parseInt(gbr.readLine());
            int newg4 = goals + g4;
            PrintStream gWriter = new PrintStream("src//texts//g4.txt");
            gWriter.println(Integer.toString(newg4));
            
            abr = new BufferedReader(new FileReader("src//texts//a4.txt"));
            a4 = Integer.parseInt(abr.readLine());
            int newa4 = assists + a4;
            PrintStream aWriter = new PrintStream("src//texts//a4.txt");
            aWriter.println(Integer.toString(newa4));
        }else if(x == 5){
            gbr = new BufferedReader(new FileReader("src//texts//g5.txt"));
            g5 = Integer.parseInt(gbr.readLine());
            int newg5 = goals + g5;
            PrintStream gWriter = new PrintStream("src//texts//g5.txt");
            gWriter.println(Integer.toString(newg5));
            
            abr = new BufferedReader(new FileReader("src//texts//a5.txt"));
            a5 = Integer.parseInt(abr.readLine());
            int newa5 = assists + a5;
            PrintStream aWriter = new PrintStream("src//texts//a5.txt");
            aWriter.println(Integer.toString(newa5));
        }else if(x == 6){
            gbr = new BufferedReader(new FileReader("src//texts//g6.txt"));
            g6 = Integer.parseInt(gbr.readLine());
            int newg6 = goals + g6;
            PrintStream gWriter = new PrintStream("src//texts//g6.txt");
            gWriter.println(Integer.toString(newg6));
            
            abr = new BufferedReader(new FileReader("src//texts//a6.txt"));
            a6 = Integer.parseInt(abr.readLine());
            int newa6 = assists + a6;
            PrintStream aWriter = new PrintStream("src//texts//a6.txt");
            aWriter.println(Integer.toString(newa6));
        }else if(x == 7){
            gbr = new BufferedReader(new FileReader("src//texts//g7.txt"));
            g7 = Integer.parseInt(gbr.readLine());
            int newg7 = goals + g7;
            PrintStream gWriter = new PrintStream("src//texts//g7.txt");
            gWriter.println(Integer.toString(newg7));
            
            abr = new BufferedReader(new FileReader("src//texts//a7.txt"));
            a7 = Integer.parseInt(abr.readLine());
            int newa7 = assists + a7;
            PrintStream aWriter = new PrintStream("src//texts//a7.txt");
            aWriter.println(Integer.toString(newa7));
        }else if(x == 8){
            gbr = new BufferedReader(new FileReader("src//texts//g8.txt"));
            g8 = Integer.parseInt(gbr.readLine());
            int newg8 = goals + g8;
            PrintStream gWriter = new PrintStream("src//texts//g8.txt");
            gWriter.println(Integer.toString(newg8));
            
            abr = new BufferedReader(new FileReader("src//texts//a8.txt"));
            a8 = Integer.parseInt(abr.readLine());
            int newa8 = assists + a8;
            PrintStream aWriter = new PrintStream("src//texts//a8.txt");
            aWriter.println(Integer.toString(newa8));
        }else if(x == 9){
            gbr = new BufferedReader(new FileReader("src//texts//g9.txt"));
            g9 = Integer.parseInt(gbr.readLine());
            int newg9 = goals + g9;
            PrintStream gWriter = new PrintStream("src//texts//g9.txt");
            gWriter.println(Integer.toString(newg9));
            
            abr = new BufferedReader(new FileReader("src//texts//a9.txt"));
            a9 = Integer.parseInt(abr.readLine());
            int newa9 = assists + a9;
            PrintStream aWriter = new PrintStream("src//texts//a9.txt");
            aWriter.println(Integer.toString(newa9));
        }else if(x == 10){
            gbr = new BufferedReader(new FileReader("src//texts//g10.txt"));
            g10 = Integer.parseInt(gbr.readLine());
            int newg10 = goals + g10;
            PrintStream gWriter = new PrintStream("src//texts//g10.txt");
            gWriter.println(Integer.toString(newg10));
            
            abr = new BufferedReader(new FileReader("src//texts//a10.txt"));
            a10 = Integer.parseInt(abr.readLine());
            int newa10 = assists + a10;
            PrintStream aWriter = new PrintStream("src//texts//a10.txt");
            aWriter.println(Integer.toString(newa10));
        }
        
        goals = 0;
        assists = 0;
        points = 0;
        gs.setText("Goals: " + goals);
        as.setText("Assists: " + assists);
        pts.setText("Points: ");
        ptsDisp.setText(Integer.toString(goals + assists));
        gsbtn.removeActionListener(this);
        asbtn.removeActionListener(this);
        window.remove(gsbtn);
        window.remove(asbtn);
    }
    
    public void tm1(){
        window.remove(main);
        window.add(tm1);
        
        tm1.updateUI();        
        tm1.add(gs1);
        gs1.setText("Goals: " + g1);
        tm1.add(as1);
        as1.setText("Assists: " + a1);
        tm1.add(pts1);
        pts1.setText("Points: " + (a1+g1));
        tm1.add(back);
        back.addActionListener(this);
    }
    
    public void tm2(){
        window.remove(main);
        window.add(tm2);
        tm2.updateUI();        
        tm2.add(gs2);
        gs2.setText("Goals: " + g2);
        tm2.add(as2);
        as2.setText("Assists: " + a2);
        tm2.add(pts2);
        pts2.setText("Points: " + (a2+g2));
        tm2.add(back);
        back.addActionListener(this);
    }
    
    public void tm3(){
        window.remove(main);
        window.add(tm3);
        tm3.updateUI();        
        tm3.add(gs3);
        gs3.setText("Goals: " + g3);
        tm3.add(as3);
        as3.setText("Assists: " + a3);
        tm3.add(pts3);
        pts3.setText("Points: " + (a3+g3));
        tm3.add(back);
        back.addActionListener(this);
    }
    
    public void tm4(){
        window.remove(main);
        window.add(tm4);
        tm4.updateUI();        
        tm4.add(gs4);
        gs4.setText("Goals: " + g4);
        tm4.add(as4);
        as4.setText("Assists: " + a4);
        tm4.add(pts4);
        pts4.setText("Points: " + (a4+g4));
        tm4.add(back);
        back.addActionListener(this);
    }
    
    public void tm5(){
        window.remove(main);
        window.add(tm5);
        tm5.updateUI();        
        tm5.add(gs5);
        gs5.setText("Goals: " + g5);
        tm5.add(as5);
        as5.setText("Assists: " + a5);
        tm5.add(pts5);
        pts5.setText("Points: " + (a5+g5));
        tm5.add(back);
        back.addActionListener(this);
    }
    
    public void tm6(){
        window.remove(main);
        window.add(tm6);
        tm6.updateUI();        
        tm6.add(gs6);
        gs6.setText("Goals: " + g6);
        tm6.add(as6);
        as6.setText("Assists: " + a6);
        tm6.add(pts6);
        pts6.setText("Points: " + (a6+g6));
        tm6.add(back);
        back.addActionListener(this);
    }
    
    public void tm7(){
        window.remove(main);
        window.add(tm7);
        tm7.updateUI();        
        tm7.add(gs7);
        gs7.setText("Goals: " + g7);
        tm7.add(as7);
        as7.setText("Assists: " + a7);
        tm7.add(pts7);
        pts7.setText("Points: " + (a7+g7));
        tm7.add(back);
        back.addActionListener(this);
    }
    
    public void tm8(){
        window.remove(main);
        window.add(tm8);
        tm8.updateUI();        
        tm8.add(gs8);
        gs8.setText("Goals: " + g8);
        tm8.add(as8);
        as8.setText("Assists: " + a8);
        tm8.add(pts8);
        pts8.setText("Points: " + (a8+g8));
        tm8.add(back);
        back.addActionListener(this);
    }
    
    public void tm9(){
        window.remove(main);
        window.add(tm9);
        tm9.updateUI();        
        tm9.add(gs9);
        gs9.setText("Goals: " + g9);
        tm9.add(as9);
        as9.setText("Assists: " + a9);
        tm9.add(pts9);
        pts9.setText("Points: " + (a9+g9));
        tm9.add(back);
        back.addActionListener(this);
    }
    
    public void tm10(){
        window.remove(main);
        window.add(tm10);
        tm10.updateUI();        
        tm10.add(gs10);
        gs10.setText("Goals: " + g10);
        tm10.add(as10);
        as10.setText("Assists: " + a10);
        tm10.add(pts10);
        pts10.setText("Points: " + (a10+g10));
        tm10.add(back);
        back.addActionListener(this);
    }

    private BufferedReader newBufferedReader(FileReader fileReader) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
