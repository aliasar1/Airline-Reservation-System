/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airline.reservation.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 *
 * @author aliar
 */
public class Route {
    JFrame frame = new JFrame();
    JButton addTextField = new JButton();
    
    static int y = 27;
    static int x;
    static int z;
    static int fields = 1;
    
    public Route(){
        
        addTextField.setText("Add more");
        addTextField.setBounds(420, 510, 150, 30);
        addTextField.setFont(new Font("Serif", Font.BOLD, 20));
        addTextField.setForeground(Color.BLACK);
        addTextField.addActionListener((ae) -> {
            if(ae.getSource() == addTextField){
              addMoreFields();   
            }
        });
        
        frame.add(addTextField);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.requestFocusInWindow();
        frame.setSize(650, 600);
        frame.setVisible(true);
    }
    
    private void addMoreFields(){

        fields = fields + 1;
        JTextField tf = new JTextField();
        
        tf.setBounds(10, 147 + x, 190, 25);
         z = 120 + y;
            z = x;
            x = x + y;
            
            frame.add(tf);
    
    }
    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addTextField){
            addMoreFields();
        }
    }
}
