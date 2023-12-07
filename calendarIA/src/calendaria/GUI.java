package calendaria;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import java.text.SimpleDateFormat;  


public class GUI implements ActionListener, MouseListener{
    
    JFrame window = new JFrame("Schalendar");
    CardLayout cl = new CardLayout();
    JPanel container = new JPanel(cl);
    JPanel startScreen = new JPanel(new GridLayout(2,1));
    JButton open = new JButton("Open Schalander");
    JPanel fullScr = new JPanel(new BorderLayout());
    JPanel calendar = new JPanel(new BorderLayout());
    JPanel addScreen = new JPanel(new GridLayout(4,2));
    JPanel viewScreen = new JPanel(new BorderLayout());
    int viewYCount = 0;
    ArrayList <JLabel> assignmentLBL = new ArrayList<>();
    JPanel viewPanel = new JPanel(new GridLayout(3,1));
    JPanel viewsAsi = new JPanel(new GridLayout(viewYCount, 4));
    JPanel daysMonths = new JPanel(new BorderLayout());
    JPanel options = new JPanel(new GridLayout(2,1));
    JButton add = new JButton("Add Assignment");
    JLabel enterName = new JLabel("Enter Title of Assignment Here");
    JTextField titleOfAssignment = new JTextField("");
    JLabel enterDate = new JLabel("Enter Due Date Here (Do not put 0 in front of single digit months)  (DD/M/YYYY)");
    JTextField dueDate = new JTextField("");
    String[] allNames= {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    
    JLabel categoryType = new JLabel("Enter Category Type Here");
    String[] allTypes = {"Test", "Homework", "Classwork", "Project"};
    JComboBox categoryBox = new JComboBox(allTypes);
    JButton finishAssi = new JButton("Finish Adding Assignment");
    JButton view = new JButton("View Upcoming Assignments");
    JButton back = new JButton("Back");
    JLabel title = new JLabel("Schalander", JLabel.CENTER);
    JPanel days = new JPanel(new GridLayout(1,7));
    JLabel[] dotw = new JLabel[7];
    JLabel monthLBL = new JLabel();
    JLabel yearLBL = new JLabel();
    JButton nextMonth = new JButton(">");
    JButton backMonth = new JButton("<");
    JPanel currentMonthPanel = new JPanel(new GridLayout(1,3));
    JLabel mon = new JLabel("Monday", JLabel.CENTER);
    JLabel tue = new JLabel("Tuesday", JLabel.CENTER);
    JLabel wed = new JLabel("Wednesday", JLabel.CENTER);
    JLabel thu = new JLabel("Thursday", JLabel.CENTER);
    JLabel fri = new JLabel("Friday", JLabel.CENTER);
    JLabel sat = new JLabel("Saturday", JLabel.CENTER);
    JLabel sun = new JLabel("Sunday", JLabel.CENTER);
    JLabel currentMonth = new JLabel();
    JLabel[] monthNames = new JLabel[12];
    
    ArrayList<String> dateArr = new ArrayList<>();
    
    JPanel grid = new JPanel(new GridLayout(6,7));
    
    JPanel [][] gridArray = new JPanel[6][7];
    JLabel [][] numbering = new JLabel[6][7];
    
    int year = 2018;
    int month;
    int day;
    int dayOfWeek;
    int firstDayOfMonth;
    int numCal;
    int counter = 1;
    int lastDay;
    
    ArrayList<file> filesArray = new ArrayList<>();
    
    BufferedReader buff;
    
    
    
    public GUI() throws FileNotFoundException, IOException{
        this.buff = new BufferedReader(new FileReader("src//texts//assignments"));
        
        BufferedReader br = null;
        BufferedWriter bw = null;
        
        
        
        
        window.add(container);
        container.add(startScreen, "start");
        container.add(fullScr, "full");
        container.add(addScreen, "newA");
        
        startScreen.add(title);
        startScreen.add(open);
        open.addActionListener(this);
        
        days.add(sun);
        days.add(mon);
        days.add(tue);
        days.add(wed);
        days.add(thu);
        days.add(fri);
        days.add(sat);
        
        for(int i = 0; i<12; i++){
            monthNames[i] = new JLabel();
            monthNames[i].setText(allNames[i]);
        }

        
        for(int i=0;i<6;i++){
            for(int j = 0; j<7;j++){
                gridArray[i][j] = new JPanel();
                numbering[i][j] = new JLabel();
                gridArray[i][j].setBorder(BorderFactory.createLineBorder(Color.black));
                gridArray[i][j].add(numbering[i][j]);
                gridArray[i][j].addMouseListener(this);

                grid.add(gridArray[i][j]);
            }
        }
        
        currentMonth.setHorizontalAlignment(JLabel.CENTER);
        currentMonth.setText(monthNames[Calendar.MONTH].getText() + " " + year);
        
        currentMonthPanel.add(backMonth);
        currentMonthPanel.add(currentMonth);
        currentMonthPanel.add(nextMonth);
        
        backMonth.addActionListener(this);
        nextMonth.addActionListener(this);
        
        daysMonths.add(currentMonthPanel, BorderLayout.NORTH);
        daysMonths.add(days, BorderLayout.SOUTH);
        
        add.addActionListener(this);
        view.addActionListener(this);
        
        options.add(add);
        options.add(viewPanel);
        
        calendar.add(daysMonths, BorderLayout.NORTH);
        calendar.add(grid, BorderLayout.CENTER);
        
        fullScr.add(calendar, BorderLayout.CENTER);
        fullScr.add(options, BorderLayout.EAST);
        
        viewScreen.add(back, BorderLayout.NORTH);
        viewScreen.add(viewsAsi, BorderLayout.CENTER);
        back.addActionListener(this);
        
        window.setSize(1000,750);
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cl.show(container, "start");
        
    }    
        
        public void getDate() throws FileNotFoundException, IOException{
            BufferedReader br = new BufferedReader(new FileReader("src//texts//assignments"));
            
            String line = br.readLine();
            while(line != null){
                filesArray.add(new file(line,br.readLine(), br.readLine()));
                line = br.readLine();
            }
            for(int i = 0; i<filesArray.size(); i++){
                System.out.println(filesArray.get(i).getDate());
                System.out.println(filesArray.get(i).getTitle());
                System.out.println(filesArray.get(i).getCategory());
            }
            
            
            
            Date date = new Date();
            Calendar dateCal = Calendar.getInstance();
            dateCal.set(Calendar.DAY_OF_MONTH, 1);
            firstDayOfMonth = dateCal.get(Calendar.DAY_OF_WEEK);
            System.out.println("First day of month: " + firstDayOfMonth);
            dateCal.setTime(date);
            int currentHour = dateCal.get(Calendar.HOUR_OF_DAY);
            System.out.println("Hour: " + currentHour);
            int currentDayOfWeek = dateCal.get(Calendar.DAY_OF_WEEK);
            System.out.println("Day of Week: " + currentDayOfWeek);
            int currentDate = dateCal.get(Calendar.DATE);
            System.out.println("Date: " + currentDate);
            year = dateCal.get(Calendar.YEAR);
            month = dateCal.get(Calendar.MONTH);
            day = dateCal.get(Calendar.DAY_OF_MONTH);
            dayOfWeek = dateCal.get(Calendar.DAY_OF_WEEK);
            System.out.println("Month: " + month);
            numCal = firstDayOfMonth;
            lastDay = Calendar.getInstance().getActualMaximum(Calendar.DAY_OF_MONTH);
            System.out.println("Last day of month: "+ lastDay);
            
            for(int i = 0; i<6; i++){
                for(int j = 0; j<7; j++){
                    if(counter <= lastDay){
                        if(j == numCal-1 && i== 0){
                            numbering[i][j].setText(Integer.toString(counter));
                            counter++;
                            if(numCal<7){
                                numCal++;
                            }else{
                                numCal = 0;
                            }
                        }else if(i!=0){
                            numbering[i][j].setText(Integer.toString(counter));
                            counter++;
                        }
                    }
                }
            }
        }
        
        public void addAssignmentScreen(){
            cl.show(container, "newA"); 
            addScreen.add(enterDate);
            addScreen.add(dueDate);
            addScreen.add(enterName);
            addScreen.add(titleOfAssignment);
            
            
            addScreen.add(categoryType);
            addScreen.add(categoryBox);
            addScreen.add(back);
            addScreen.add(finishAssi);
            finishAssi.addActionListener(this);
            back.addActionListener(this); 
        }
        
        public void addAssignment() throws IOException, ParseException{
            String name = titleOfAssignment.getText();
            String type= categoryBox.getSelectedItem().toString();
            String dateEntered = dueDate.getText(); 
            
                BufferedWriter bw = new BufferedWriter(new FileWriter("src//texts//assignments", true));
                
                bw.write(dateEntered);
                bw.newLine();
                bw.write(name);
                bw.newLine();
                bw.write(type);
                bw.newLine();
                bw.close();

            filesArray.clear();
            
            BufferedReader br = new BufferedReader(new FileReader("src//texts//assignments"));
            
            String line = br.readLine();
            while(line != null){
                filesArray.add(new file(line,br.readLine(), br.readLine()));
                line = br.readLine();
            }
            for(int i = 0; i<filesArray.size(); i++){
                System.out.println(filesArray.get(i).getDate());
                System.out.println(filesArray.get(i).getTitle());
                System.out.println(filesArray.get(i).getCategory());
            }
        }
        
        public void editCalendar() throws FileNotFoundException, IOException{
            
            BufferedReader br = new BufferedReader(new FileReader("src//texts//assignments"));
            
            String currLine = br.readLine();
            
            while(currLine != null){
                String [] nums = currLine.split("/");
                for(int i = 0; i<nums.length; i++){
                    dateArr.add(nums[i]);
                }
                
                currLine = br.readLine();
                currLine = br.readLine();
                currLine = br.readLine();
            }
            br.close();
            for(int i = 0; i<dateArr.size(); i++){
                System.out.println(dateArr.get(i));
            }
            
            for(int x = 0; x<6; x++){
                for(int y = 0; y<7; y++){
                    for(int i = 0; i<dateArr.size()-2; i++){
                        if(!"".equals(numbering[x][y].getText()) && year == Integer.parseInt(dateArr.get(i+2)) && month == (Integer.parseInt((dateArr.get(i+1))) - 1) && Integer.parseInt(numbering[x][y].getText()) == Integer.parseInt(dateArr.get(i))){
                            numbering[x][y].setForeground(Color.RED);
                            grid.updateUI();
                        }
                    }
                }
            }
            
        }
        
        public void nextMonth(){
            if(month <11){
                month++;
            }else{
                month = 0;
                year++;
            }
            currentMonth.setText(monthNames[month].getText() + " " + year);
            currentMonthPanel.updateUI();
            int count = 1;
            Calendar cal = Calendar.getInstance();
            cal.set(Calendar.MONTH, month);
            cal.set(Calendar.YEAR, year);
            lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
            
            cal.set(Calendar.DAY_OF_MONTH, 1);
            int firstDOM = cal.get(Calendar.DAY_OF_WEEK);
            for(int i = 0; i<6; i++){
                for(int j = 0; j<7; j++){
                    numbering[i][j].setText("");
                    numbering[i][j].setForeground(Color.BLACK);
                }
            }
            
            
            for(int i = 0; i<6; i++){
                for(int j = 0; j<7; j++){
                    if(count <= lastDay){
                        if(j == firstDOM-1 && i== 0){
                            numbering[i][j].setText(Integer.toString(count));
                            count++;
                            if(firstDOM<7){
                                firstDOM++;
                            }else{
                                firstDOM = 0;
                            }
                        }else if(i!=0){
                            numbering[i][j].setText(Integer.toString(count));
                            count++;
                        }
                    }
                }
            }
        }
        
        public void backMonth(){
            if(month >0){
                month--;
            }else{
                month = 11;
                year--;
            }
            currentMonth.setText(monthNames[month].getText() + " " + year);
            currentMonthPanel.updateUI();
            
            
            int count = 1;
            Calendar cal = Calendar.getInstance();
            cal.set(Calendar.MONTH, month);
            lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
            
            cal.set(Calendar.DAY_OF_MONTH, 1);
            cal.set(Calendar.YEAR, year);
            int firstDOM = cal.get(Calendar.DAY_OF_WEEK);
            for(int i = 0; i<6; i++){
                for(int j = 0; j<7; j++){
                    numbering[i][j].setText("");
                    numbering[i][j].setForeground(Color.BLACK);
                }
            }
            
            
            for(int i = 0; i<6; i++){
                for(int j = 0; j<7; j++){
                    if(count <= lastDay){
                        if(j == firstDOM-1 && i== 0){
                            numbering[i][j].setText(Integer.toString(count));
                            count++;
                            if(firstDOM<7){
                                firstDOM++;
                            }else{
                                firstDOM = 0;
                            }
                        }else if(i!=0){
                            numbering[i][j].setText(Integer.toString(count));
                            count++;
                        }
                    }
                }
            }
        }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == open){
            try {
                getDate();
            } catch (IOException ex) {
                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                editCalendar();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            cl.show(container, "full");
        }
        if(e.getSource() == add){
            addAssignmentScreen();
            try {
                editCalendar();
            } catch (IOException ex) {
                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        if(e.getSource() == back){
            cl.show(container, "full");
            try {
                editCalendar();
            } catch (IOException ex) {
                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        if(e.getSource() == nextMonth){
            nextMonth();
            try {
                editCalendar();
            } catch (IOException ex) {
                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(e.getSource() == backMonth){
            backMonth();
            try {
                editCalendar();
            } catch (IOException ex) {
                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }

        if(e.getSource() == finishAssi){
            try {
                addAssignment();
                viewYCount++;
                editCalendar();
                cl.show(container, "full");
            } catch (IOException ex) {
                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        assignmentLBL.clear();
        viewPanel.removeAll();
        String line = null;
        
        for(int x = 0; x<6; x++){
            for(int y = 0; y<7; y++){
                if(e.getSource() == gridArray[x][y] && numbering[x][y].getForeground() == Color.RED){
                    for(int i = 0; i<dateArr.size()-2; i++){
                            if(month + 1 == Integer.parseInt(dateArr.get(i+1)) && year == Integer.parseInt(dateArr.get(i+2))){
                                if(Integer.parseInt(numbering[x][y].getText()) == Integer.parseInt(dateArr.get(i))){
                                    for(int z = 0; z<filesArray.size(); z++){
                                        if(filesArray.get(z).getDate().equals(numbering[x][y].getText() + "/" + (month+1) + "/" + year)){
                                            assignmentLBL.add(new JLabel(filesArray.get(z).getDate(), JLabel.CENTER));
                                            assignmentLBL.add(new JLabel(filesArray.get(z).getTitle(), JLabel.CENTER));
                                            assignmentLBL.add(new JLabel(filesArray.get(z).getCategory(), JLabel.CENTER));
                                        }
                                    }
                                        for(int d = 0; d<3; d++){
                                            viewPanel.add(assignmentLBL.get(d));
                                        }
                                viewPanel.updateUI();
                        }
                    }
                }
            }
        }
    }
}

    @Override
    public void mousePressed(MouseEvent e) {
       
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }
}
