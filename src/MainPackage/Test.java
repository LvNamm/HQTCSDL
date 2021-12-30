/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MainPackage;

/**
 *
 * @author Luong Nam
 */
 
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
 
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
 
public class Test {
    private JFrame mainFrame;
    private JLabel headerLabel;
    private JLabel statusLabel;
    private JPanel controlPanel;
 
    public Test(){
       prepareGUI();
    }
 
    public static void main(String[] args) {
        Test demo = new Test();
        demo.showKeyListenerDemo();
    }
 
    private void prepareGUI() {
        mainFrame = new JFrame();
        mainFrame.setSize(400, 300);
        mainFrame.setLayout(new GridLayout(3, 1));
        headerLabel = new JLabel("", JLabel.CENTER);
        statusLabel = new JLabel("", JLabel.CENTER);
        statusLabel.setSize(350, 100);
        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });
        controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());
        mainFrame.add(headerLabel);
        mainFrame.add(controlPanel);
        mainFrame.add(statusLabel);
        mainFrame.setVisible(true);
        mainFrame.setTitle("Ví dụ KeyListener trong Java Swing");
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
 
    private JTextField textField;
 
    private void showKeyListenerDemo() {
        headerLabel.setText("Listener in action: KeyListener");
        textField = new JTextField(10);
        textField.addKeyListener(new CustomKeyListener());
        JButton okButton = new JButton("OK");
        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                statusLabel.setText("Entered text: " + textField.getText());
            }
        });
        controlPanel.add(textField);
        controlPanel.add(okButton);
        mainFrame.setVisible(true);
    }
 
    class CustomKeyListener implements KeyListener {
        public void keyTyped(KeyEvent e) {
            
        }
 
        public void keyPressed(KeyEvent e) {
            
                
            
        }
 
        public void keyReleased(KeyEvent e) {
            statusLabel.setText("Entered text: " + textField.getText());
        }
    }
}
