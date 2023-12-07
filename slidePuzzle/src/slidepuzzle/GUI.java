package slidepuzzle;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.*;
import javax.swing.border.LineBorder;


public class GUI implements ActionListener{
    JFrame window = new JFrame("Puzzle");
    CardLayout cl = new CardLayout();
    JPanel container = new JPanel(cl);
    JPanel startScreen = new JPanel(new GridLayout(3,1));
    JLabel title = new JLabel("Slide Puzzle");
    JTextField numberChoice = new JTextField();
    JButton startButton = new JButton("Start");
    JPanel gridPanel = new JPanel();
    ArrayList<JButton> pieces = new ArrayList<>();
    //ArrayList<Integer> numbers = new ArrayList<>();
    int listSize = 0;
    boolean secondClick = false;
    String swapper = new String();
    int swapperIndex;
    
    public GUI(){
        window.add(container);
        container.add(startScreen, "start");
        container.add(gridPanel, "grid");
        
        startScreen.add(title);
        startScreen.add(numberChoice);
        startScreen.add(startButton);
        startButton.addActionListener(this);
        
        window.setSize(500,500);
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cl.show(container, "start");
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       
        if (e.getSource() == startButton){
            int size = Integer.parseInt(numberChoice.getText());
            listSize = size*size;
            gridPanel.setLayout(new GridLayout(size,size));
            //pieces = new JButton[listSize];
            for(int i = 0; i<listSize; i++){
                //numbers.add(i);
                pieces.add(new JButton(Integer.toString(i)));
            }
            Collections.shuffle(pieces);
            
            for(int i = 0; i<listSize; i++){
                //pieces[i] = new JButton(Integer.toString(numbers.get(i)));
                pieces.get(i).addActionListener(this);
                pieces.get(i).setBorder(new LineBorder(Color.BLACK));
                //pieces[i].addActionListener(this);
                if(pieces.get(i).getText().equals("0")){
                    System.out.println("white");
                    pieces.get(i).setBackground(Color.WHITE);
                }else{
                    pieces.get(i).setBackground(Color.CYAN);
                    System.out.println("cyan");
                }
                pieces.get(i).setOpaque(true);
                //pieces.get(i).setBorderPainted(false);
                gridPanel.add(pieces.get(i));
            }
            
            
            cl.show(container, "grid");
        }
        for(int i = 0; i<listSize; i++){
            if(e.getSource() == pieces.get(i)){
                System.out.println("Click");
                if(!pieces.get(i).getText().equals("0") && secondClick == false){
                    System.out.println("non zero");
                    secondClick = true;
                    //swapper = pieces[i].getText();
                    swapperIndex = i;
                    System.out.println(swapper);
                    System.out.println(secondClick);
                }
                if(pieces.get(i).getText().equals("0") && secondClick == true){
                    System.out.println("zero");
                    Collections.swap(pieces,swapperIndex, i);
                    secondClick = false;
                }
                
            }
            gridPanel.removeAll();
            for(int j = 0; j<listSize; j++){
                gridPanel.add(pieces.get(j)); 
            }
                           
            gridPanel.updateUI();
        }
           
        
        
    }
}
