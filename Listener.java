package dnd;
import dnd.GUIs.debuggingGUI;
import dnd.GUIs.creationGUI;
import dnd.GUIs.editGUI;
import java.awt.event.*;
import javax.swing.*;

public class Listener extends JFrame implements Action {
    String[] emptyArgs = new String[0];
    public static creationGUI ListenGui;
    public static debuggingGUI debugger;
    public static editGUI editor;
    public static boolean easyGenSwitch = false;
    public static int easyGen = 0;
    public static boolean debuggerOneInstance = false;
    public static debuggingGUI debugGUIPointer;
    public static boolean editorIsOpen = false;
    public static editGUI editingGUIPointer;
    
    public Listener(creationGUI in) {
        ListenGui = in;
    }
    public Listener(debuggingGUI in) {
        debugger = in;
    }
    public Listener(editGUI in) {
        editor = in;
    }
    public void takeMonsterArgs(String name, int type) {
        if (name != "" && type != 9999) {
            Stats.createFromArgs(name, type, false);
        }
        else {
            String newName = ListenGui.nInput.getText();
            int newType = ListenGui.tInput.getSelectedIndex();
            Stats.createFromArgs(newName, newType, false);
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        int namePlace = creationGUI.mCycleCount;
        if (Stats.nameArray.length != 0) {
            String mName =  Stats.nameArray[namePlace];
        }
        if (command.equals("Submit")) {
            takeMonsterArgs(creationGUI.nInput.getText(), creationGUI.tInput.getSelectedIndex());
            ListenGui.addMonsterToMonsterPanel(false);
            ListenGui.cycleMons();
            if (easyGenSwitch) {
                switch (easyGen) {
                    case 0: {
                        creationGUI.nInput.setText("Tootsie");
                        creationGUI.tInput.setSelectedIndex(0);
                        easyGen++;
                        break;
                        }
                    case 1: {
                        creationGUI.nInput.setText("Wimbley");
                        creationGUI.tInput.setSelectedIndex(1);
                        easyGen++;
                        break;
                        }
                    case 2: {
                        creationGUI.nInput.setText("Nurble");
                        creationGUI.tInput.setSelectedIndex(1);
                        easyGen++;
                        break;
                        }
                    case 3: {
                        creationGUI.nInput.setText("Brangle");
                        creationGUI.tInput.setSelectedIndex(0);
                        easyGen++;
                        break;
                        }
                    }
                }
            }
        else if (command.equals("Check")) {
            if (!debuggerOneInstance) {
                debuggerOneInstance = true;
                debuggingGUI debugIT = new debuggingGUI(emptyArgs);
                debugGUIPointer = debugIT;
            }
            else {
                if (!debugGUIPointer.isDisplayable()) {
                    debuggerOneInstance = true;
                    debuggingGUI debugIT = new debuggingGUI(emptyArgs);
                    debugGUIPointer = debugIT;
                }
            }
        }
        else if (command.equals("Edit")) {
            if (!editorIsOpen) {
                editorIsOpen = true;
                editGUI.revamp();
                editGUI editIT = new editGUI(emptyArgs, true, true);
                editingGUIPointer = editIT;
            }
            else {
                if (!editingGUIPointer.isDisplayable()) {
                    editorIsOpen = true;
                    editGUI.revamp();
                    editGUI editIT = new editGUI(emptyArgs, true, true);
                    editingGUIPointer = editIT;
                }
            }
        }
        else if (command.equals("Save")) {
            editGUI.save();
            ListenGui.cycleMons();
        }
        else if (command.equals("Cycle Left")) {
            if (creationGUI.mCycleCount != 0) {
                creationGUI.mCycleCount--;
            }
            ListenGui.cycleMons();
        }
        else if (command.equals("Cycle Right")) {
            if (creationGUI.mCycleCount < Stats.monsterCount - 1) {
                creationGUI.mCycleCount++;
            }
            ListenGui.cycleMons();
        }
        else if (command.equals("Delete Monster")) {
            if (Stats.monsterCount != 0) {
            Arr.removeMon(true);
            if (creationGUI.mCycleCount == Stats.monsterCount) {
                creationGUI.mCycleCount--;
            }
            if (creationGUI.mCycleCount < 0) {
                creationGUI.mCycleCount++;
            }
            ListenGui.cycleMons();
            }
            else { System.out.println("CAUTION! Deleting a void is the equivelant"
                + " of putting a bag of holding in a bag of holding!");
                }
        }
        else if (command.equals("Configs")) {
                String[] config = new String[2];
                
                String monsterCount = Integer.toString(Stats.monsterCount);
                String count = Integer.toString(creationGUI.mCycleCount);
                config[0] = ("monsterCount: " + monsterCount);
                config[1] = ("mCycleCount: " + count);
                
                debuggingGUI.current.setText("Configs");
                debuggingGUI.display = config;
                debugger.output();
            }
        else if (command.equals("idArray")) {
                debuggingGUI.current.setText("idArray");
                debuggingGUI.display = Stats.idArray;
                debugger.output();
            }
        else if (command.equals("mCountArray")) {
                debuggingGUI.current.setText("mCountArray");
                debuggingGUI.display = Arr.rSAFIA(Stats.mCountArray);
                debugger.output();
            }
        else if (command.equals("nameArray")) {
                debuggingGUI.current.setText("nameArray");
                debuggingGUI.display = Stats.nameArray;
                debugger.output();
            }
        else if (command.equals("typeArray")) {
                debuggingGUI.current.setText("typeArray");
                debuggingGUI.display = Stats.typeArray;
                debugger.output();
            }
        else if (command.equals("descriptionArray")) {
                debuggingGUI.current.setText("descriptionArray");
                debuggingGUI.display = Stats.descriptionArray;
                debugger.output();
            }
        else if (command.equals("alignmentArray")) {
                debuggingGUI.current.setText("alignmentArray");
                debuggingGUI.display = Stats.alignmentArray;
                debugger.output();
            }
        else if (command.equals("armorClassArray")) {
                debuggingGUI.current.setText("armorClassArray");
                debuggingGUI.display = Arr.rSAFIA(Stats.armorClassArray);
                debugger.output();
            }
        else if (command.equals("armorClassItemsArray")) {
                debuggingGUI.current.setText("armorClassItemsArray");
                debuggingGUI.display = Stats.armorClassItemsArray;
                debugger.output();
            }
        else if (command.equals("hitPointsArray")) {
                debuggingGUI.current.setText("hitPointsArray");
                debuggingGUI.display = Arr.rSAFIA(Stats.hitPointsArray);
                debugger.output();
            }
        else if (command.equals("hitPointDefaultArray")) {
                debuggingGUI.current.setText("hitPointDefaultArray");
                debuggingGUI.display = Arr.rSAFIA(Stats.hitPointDefaultArray);
                debugger.output();
            }
        else if (command.equals("hitPointDescriptionArray")) {
                debuggingGUI.current.setText("hitPointDescriptionArray");
                debuggingGUI.display = Stats.hitPointDescriptionArray;
                debugger.output();
            }
        else if (command.equals("hitPointRollArray")) {
                debuggingGUI.current.setText("hitPointRollArray");
                debuggingGUI.display = Arr.rSAFIA(Stats.hitPointRollArray);
                debugger.output();
            }
        else if (command.equals("speedArray")) {
                debuggingGUI.current.setText("speedArray");
                debuggingGUI.display = Arr.rSAFIA(Stats.speedArray);
                debugger.output();
            }
        else if (command.equals("strengthArray")) {
                debuggingGUI.current.setText("strengthArray");
                debuggingGUI.display = Arr.rSAFIA(Stats.strengthArray);
                debugger.output();
            }
        else if (command.equals("dexterityArray")) {
                debuggingGUI.current.setText("dexterityArray");
                debuggingGUI.display = Arr.rSAFIA(Stats.dexterityArray);
                debugger.output();
            }
        else if (command.equals("constitutionArray")) {
                debuggingGUI.current.setText("constitutionArray");
                debuggingGUI.display = Arr.rSAFIA(Stats.constitutionArray);
                debugger.output();
            }
        else if (command.equals("intelligenceArray")) {
                debuggingGUI.current.setText("intelligenceArray");
                debuggingGUI.display = Arr.rSAFIA(Stats.intelligenceArray);
                debugger.output();
            }
        else if (command.equals("wisdomArray")) {
                debuggingGUI.current.setText("wisdomArray");
                debuggingGUI.display = Arr.rSAFIA(Stats.wisdomArray);
                debugger.output();
            }
        else if (command.equals("charismaArray")) {
                debuggingGUI.current.setText("charismaArray");
                debuggingGUI.display = Arr.rSAFIA(Stats.charismaArray);
                debugger.output();
            }
        else if (command.equals("skillsArray")) {
                debuggingGUI.current.setText("skillsArray");
                debuggingGUI.display = Stats.skillsArray;
                debugger.output();
            }
        else if (command.equals("sensesArray")) {
                debuggingGUI.current.setText("sensesArray");
                debuggingGUI.display = Stats.sensesArray;
                debugger.output();
            }
        else if (command.equals("languagesArray")) {
                debuggingGUI.current.setText("languagesArray");
                debuggingGUI.display = Stats.languagesArray;
                debugger.output();
            }
        else if (command.equals("challengeRatingArray")) {
                debuggingGUI.current.setText("challengeRatingArray");
                debuggingGUI.display = Stats.challengeRatingArray;
                debugger.output();
            }
        else if (command.equals("experienceArray")) {
                debuggingGUI.current.setText("experienceArray");
                debuggingGUI.display = Arr.rSAFIA(Stats.experienceArray);
                debugger.output();
            }
        else if (command.equals("attributesArray")) {
                debuggingGUI.current.setText("attributesArray");
                debuggingGUI.display = Stats.attributesArray;
                debugger.output();
            }
        else if (command.equals("actionsArray")) {
                debuggingGUI.current.setText("actionsArray");
                debuggingGUI.display = Stats.actionsArray;
                debugger.output();
            }
        else if (command.equals("reactionsArray")) {
                debuggingGUI.current.setText("reactionsArray");
                debuggingGUI.display = Stats.reactionsArray;
                debugger.output();
            }
        else if (Tasks.monsterButton(command)) {
            creationGUI.mCycleCount = Tasks.returnMonsterCycle(command);
            ListenGui.cycleMons();
        }
        else {
            Say.out("Got action: " + e.getActionCommand());
            Say.out("In other words, got: " + e.paramString());            
            throw new UnsupportedOperationException("N=This action is not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }
    
    @Override
    public Object getValue(String key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void putValue(String key, Object value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}