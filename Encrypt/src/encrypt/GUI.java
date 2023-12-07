
package encrypt;

import javax.swing.*;


class GUI {
    JFrame window = new JFrame();
    JPanel panel = new JPanel();
    JTextArea input = new JTextArea("");
    JButton button = new JButton();
    
    
    public GUI(){
        window.add(panel);
        panel.add(input);
        panel.add(button);
        
        window.setSize(500,500);
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
