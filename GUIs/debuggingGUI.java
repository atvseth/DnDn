package dnd.GUIs;
import dnd.*;
import java.awt.*;
import java.util.*;
import javax.swing.*;

public class debuggingGUI extends JFrame {
    Listener debugGUIOut = new Listener(this);
    public static GridLayout defLay = new GridLayout(0, 1);
    public static JPanel inputPanel = new JPanel(defLay);
    public static JPanel outputPanel = new JPanel(defLay);
    public static JPanel outputHeader = new JPanel(defLay);
    public static JLabel current = new JLabel("", JLabel.CENTER);
    public static String[] display = new String[0];
    JScrollPane outputScroller = new JScrollPane(outputPanel);
    JScrollPane inputScroller = new JScrollPane(inputPanel);
    public debuggingGUI(String[] args) {
        super("DnDn debugger");
        Listener.debuggerOneInstance = true;
        setLocation(1000, 0);
        setSize(800, 800);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(defLay);
        inputPanel.removeAll();
        input();
        output();
        setVisible(true);
    }
    void input() {
        inputVars("Configs");
        inputVars("idArray");
        inputVars("mCountArray");
        inputVars("nameArray");
        inputVars("typeArray");
        inputVars("descriptionArray");
        inputVars("alignmentArray");
        inputVars("armorClassArray");
        inputVars("armorClassItemsArray");
        inputVars("hitPointsArray");
        inputVars("hitPointDefaultArray");
        inputVars("hitPointDescriptionArray");
        inputVars("hitPointRollArray");
        inputVars("speedArray");
        inputVars("strengthArray");
        inputVars("dexterityArray");
        inputVars("constitutionArray");
        inputVars("intelligenceArray");
        inputVars("wisdomArray");
        inputVars("charismaArray");
        inputVars("skillsArray");
        inputVars("sensesArray");
        inputVars("languagesArray");
        inputVars("challengeRatingArray");
        inputVars("experienceArray");
        inputVars("attributesArray");
        inputVars("actionsArray");
        inputVars("reactionsArray");
        add(inputScroller);
    }
    void inputVars(String text) {
        JButton var = new JButton(text);
        inputPanel.add(var);
        var.addActionListener(debugGUIOut);
        
    }
    public void output() {
        outputHeader.removeAll();
        outputPanel.removeAll();
        
        outputHeader.add(current);
        
        if (display.length == 1) {
           JLabel text = new JLabel("Item " + 0 + ": " + display[0]);
        }
        
        for (int i=0; i < display.length; i++) {
            JLabel text = new JLabel("Item " + i + ": " + display[i]);
            outputPanel.add(text);
        }
        outputScroller.setAutoscrolls(true);
        add(outputHeader);
        add(outputScroller);
        
        repaint();
        //pack();
        setVisible(true);
    }
}