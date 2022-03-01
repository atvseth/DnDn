package dnd.GUIs;
import dnd.*;
import java.awt.*;
import java.util.*;
import javax.swing.*;

public class editGUI extends JFrame {
    public static int namePlace = creationGUI.mCycleCount;
    public static String mName =  Stats.nameArray[namePlace];
    Listener editGuiOut = new Listener(this);
    public static GridLayout defLay = new GridLayout(0, 1);
    public static JPanel input = new JPanel(defLay);
    public static JPanel output = new JPanel(defLay);
    public static JPanel outputHeader = new JPanel(defLay);
    public static JLabel current = new JLabel("", JLabel.CENTER);
    public static String[] display = new String[0];
    JScrollPane outputScroller = new JScrollPane(output);
    
    JLabel name = new JLabel("Name:");
    public static JTextField nameSet = new JTextField(mName, 20); 
    
    
    public editGUI(String[] args, boolean test, boolean verbose) {
        super("DnDn editor");
        setLocation(1000, 0);
        setSize(800, 800);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(defLay);
        input();
        output();
        setVisible(true);
    }
    public static void revamp() {
        namePlace = creationGUI.mCycleCount;
        mName =  Stats.nameArray[namePlace];
        nameSet.setText(editGUI.mName);
    }
    void input() {
        input.removeAll();
        inputVars("Save");
        add(input);
    }
    void inputVars(String array) {
        JButton var = new JButton(array);
        input.add(var);
        var.addActionListener(editGuiOut);
    }
    void outputVars(String text) {
        JButton var = new JButton(text);
        output.add(var);
        var.addActionListener(editGuiOut);
        
    }
    public void output() {
        GridLayout editing = new GridLayout(0, 2);
        outputHeader.removeAll();
        output.removeAll();
        current.setText(mName);
        if (current.getText() != "") {
            outputHeader.add(current);
        }
        /*
        if (display.length == 1) {
           JLabel text = new JLabel("Item " + 0 + ": " + display[0]);
        }
        */
        output.setLayout(editing);
        
        output.add(name);
        output.add(nameSet);
        
        
        add(outputHeader);
        add(outputScroller);
        
        repaint();
        //pack();
        setVisible(true);
    }
    public static void save() {
        String name = editGUI.nameSet.getText();
        String oName = Stats.nameArray[namePlace];
        if (Arr.monNameNoExist(name)) {
            Stats.nameArray[namePlace] = name;
            
            //do the rest for name dependants
            
            Arr.replStringVals(Stats.armorClassItemsArray, oName, name);
            Arr.replStringVals(Stats.attributesArray, oName, name);
            Arr.replStringVals(Stats.actionsArray, oName, name);
            Arr.replStringVals(Stats.reactionsArray, oName, name);
        }
        
        if (Arr.monIDNoExist(Stats.idArray[namePlace])) {
            Stats.idArray[namePlace] = name;
            
            //do the rest for ID dependants
        }
        
        else {
            Say.out(name + " already exists.  Changes not saved.");
        }
        dnd.Listener.editingGUIPointer.dispose();
        dnd.Listener.editorIsOpen = false;
    }
}