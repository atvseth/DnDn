package dnd.GUIs;
import dnd.*;
import java.awt.*;
import java.util.*;
import javax.swing.*;

public class creationGUI extends JFrame {
    Listener GuiOut = new Listener(this);
    Listener ButtonGuiOut = new Listener(this);
    static String[] argsTemp = null;
    JLabel inputName = new JLabel("Enter your monster name:");
    JLabel inputType = new JLabel("Enter your monster type:");
    JButton submit = new JButton("Submit");
    JButton check = new JButton("Check");
    JButton edit = new JButton("Edit");
    public static JTextField nInput = new JTextField("Girnak", 20);
    public static JComboBox tInput = new JComboBox(Monsters.monsterTypes);
    public static JButton lefter = new JButton("Cycle Left");
    public static JButton righter = new JButton("Cycle Right");
    public static JButton deleter = new JButton("Delete Monster");
    public static JPanel mInput = new JPanel();
    public static JPanel mCycle = new JPanel();
    public static JPanel mOutput = new JPanel();
    public static JPanel mOutput2 = new JPanel();
    public static int mCycleCount = 0;
    public static JPanel monsterPanel = new JPanel();
    public static JScrollPane monsterScroller = new JScrollPane(monsterPanel);
    public static JScrollPane mOutputScroller = new JScrollPane(mOutput2);
    public static HashMap<String, JButton> monsterLabels = new HashMap<String,JButton>();
    public static HashMap<String, JLabel> monsterImages = new HashMap<String,JLabel>();
    void fillArgsTemp(String[] args, String option) {
        if (option == "keep") {
            if (args.length != 0) {
            argsTemp = args;
            } else {
                Say.out("args was empty.  Filling values.");
                String[] argsTempNew = new String[2];
                argsTempNew[0] = "Obby";
                argsTempNew[1] = "Goblin";
                nInput = new JTextField("Obby", 20);
                //tInput = new JTextField("Goblin", 20);
                Arr.printArray("ArgsTempNew", argsTempNew, "v");
                argsTemp = argsTempNew;
                }
        } else if (option == "overwrite") {
            String[] argsTempNew = new String[2];
            argsTempNew[0] = "Obby";
            argsTempNew[1] = "Goblin";
            argsTemp = argsTempNew;
            //Stats.createFromArgs(argsTempNew[0], argsTempNew[1], false);
        } else if (option == "empty") {
            argsTemp = new String[0];
        }
    }
    public creationGUI(String[] args, boolean test, boolean easyGen) {
        super("DnDn Gui");
        setSize(1000, 800);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        GridLayout layout = new GridLayout(5, 5);
        setLayout(layout);
        fillArgsTemp(args, "empty");
        mInput();
        mOutput();
        setVisible(true);
        if (test) { 
        Stats.createFromArgs("Glicknon", 0, false);
        addMonsterToMonsterPanel(false);
        Stats.createFromArgs("Praddil", 0, false);
        addMonsterToMonsterPanel(false);
        Stats.createFromArgs("Nurtoth", 1, false);
        addMonsterToMonsterPanel(false);
        cycleMons();
        Stats.createFromArgs("Birgle", 0, false);
        addMonsterToMonsterPanel(false);
        cycleMons();
        Stats.createFromArgs("Billybong", 1, false);
        addMonsterToMonsterPanel(false);
        cycleMons();
        Stats.createFromArgs("Brackle", 0, false);
        addMonsterToMonsterPanel(false);
        cycleMons();
        }
        if (easyGen) {
            Listener.easyGenSwitch = true;
        }
    }
    void mInput() {
        GridLayout monLay = new GridLayout(0, 2);
                
        mInput.add(inputName);
        mInput.add(nInput);
        mInput.add(inputType);
        mInput.add(tInput);
        mInput.add(submit);
        mInput.add(check);
        mInput.add(edit);
        submit.addActionListener(GuiOut);
        check.addActionListener(GuiOut);
        edit.addActionListener(GuiOut);
        add(mInput);
        monsterPanel.setLayout(monLay);
        add(monsterScroller);
    }
    void mOutput() {
        mCycle.add(lefter);
        mCycle.add(deleter);
        mCycle.add(righter);
        lefter.addActionListener(GuiOut);
        deleter.addActionListener(GuiOut);
        righter.addActionListener(GuiOut);
        add(mCycle);
        add(mOutput);
        add(mOutputScroller);
    }
    public void cycleMons() {
        if (Stats.monsterCount != 0) {
        mOutput.removeAll();
        GridLayout layout = new GridLayout(10, 20);
        mOutput.setLayout(layout);
        //"place" integer jumps every second spot and starts at 1
        int place = (mCycleCount * 2) + 1;
        
        JLabel monNum = new JLabel("Count: " + (mCycleCount));
            mOutput.add(monNum);
        JLabel placer = new JLabel("\"Place\": " + place);
            mOutput.add(placer);    
        JLabel id = new JLabel("ID: " + Stats.idArray[place]);
            mOutput.add(id);
        JLabel mCount = new JLabel("Count ID: " + Stats.mCountArray[mCycleCount]);
            mOutput.add(mCount);
        JLabel monster = new JLabel("Name: " + Stats.nameArray[mCycleCount]);
            mOutput.add(monster);
        JLabel type = new JLabel("Type: " + Stats.typeArray[place]);
            mOutput.add(type);
        JLabel description = new JLabel("Description: " + Stats.descriptionArray[place]);
            mOutput.add(description);
        JLabel alignment = new JLabel("Alignment: " + Stats.alignmentArray[place]);
             mOutput.add(alignment);
        JLabel armorClass = new JLabel("ArmorClass: " + Stats.armorClassArray[place]);
            mOutput.add(armorClass);
        JLabel hitPoints = new JLabel("Hit Points: " + Stats.hitPointsArray[place]);
            mOutput.add(hitPoints);
        JLabel hitPointDefault = new JLabel("Default Hit Points: " + Stats.hitPointDefaultArray[place]);
            mOutput.add(hitPointDefault);
        JLabel hitPointDescription = new JLabel("Hit Point description: " + Stats.hitPointDescriptionArray[place]);
            mOutput.add(hitPointDescription);
        JLabel hitPointRoll = new JLabel("Hit Point Roll: " + Stats.hitPointRollArray[place]);
            mOutput.add(hitPointRoll);
        JLabel speed = new JLabel("Speed: " + Stats.speedArray[place] + " ft.");
            mOutput.add(speed);
        JLabel strength = new JLabel("Strength: " + Stats.strengthArray[place]);
            mOutput.add(strength);
        JLabel dexterity = new JLabel("Dexterity: " + Stats.dexterityArray[place]);
            mOutput.add(dexterity);
        JLabel constitution = new JLabel("Constitution: " + Stats.constitutionArray[place]);
            mOutput.add(constitution);
        JLabel intelligence = new JLabel("Intelligence: " + Stats.intelligenceArray[place]);
            mOutput.add(intelligence);
        JLabel wisdom = new JLabel("Wisdom: " + Stats.wisdomArray[place]);
            mOutput.add(wisdom);
        JLabel charisma = new JLabel("Charisma: " + Stats.charismaArray[place]);
            mOutput.add(charisma);
        String skillsString = Arr.concatMonArray(Stats.skillsArray, Stats.nameArray[mCycleCount]);
        JLabel skills = new JLabel("Skills: " + skillsString);
            mOutput.add(skills);
        String sensesString = Arr.concatMonArray(Stats.sensesArray, Stats.nameArray[mCycleCount]);
        JLabel senses = new JLabel("Senses: " + sensesString);
            mOutput.add(senses);
        String languagesString = Arr.concatMonArray(Stats.languagesArray, Stats.nameArray[mCycleCount]);
        JLabel languages = new JLabel("Languages: " + languagesString);
            mOutput.add(languages);
        String challengeString = Arr.concatMonArray(Stats.challengeRatingArray, Stats.nameArray[mCycleCount]);
        JLabel challenge = new JLabel("Challenge rating: " + challengeString);
            mOutput.add(challenge);
        JLabel experience = new JLabel("Experience: " + Stats.experienceArray[place]);
            mOutput.add(experience);
            
        mOutput2.removeAll();
        mOutput2.setLayout(layout);
        
        String[] acItemValues = Arr.monStringArray(Stats.armorClassItemsArray, Stats.nameArray[mCycleCount]);
            for (int i = 0; i < acItemValues.length; i++) {
                JLabel armorClassItems = new JLabel("Armor Class Item: " + acItemValues[i]);
                mOutput2.add(armorClassItems);
            }
        String[] attributesValues = Arr.monStringArray(Stats.attributesArray, Stats.nameArray[mCycleCount]);
        for (int i = 0; i < attributesValues.length; i++) {
            JLabel attributes = new JLabel("Attribute: " + attributesValues[i]);
            mOutput2.add(attributes);
        }
         
        String[] actionValues = Arr.monStringArray(Stats.actionsArray, Stats.nameArray[mCycleCount]);
            for (int i = 0; i < actionValues.length; i++) {
                JLabel actions = new JLabel("Action: " + actionValues[i]);
                mOutput2.add(actions);
            }
             
        String[] reactionsValues = Arr.monStringArray(Stats.reactionsArray, Stats.nameArray[mCycleCount]);
            for (int i = 0; i < reactionsValues.length; i++) {
                JLabel reactions = new JLabel("Reaction: " + reactionsValues[i]);
                mOutput2.add(reactions);
            }
        
        repaint();
        
        setVisible(true);
        }
        else if (Stats.monsterCount == 0) {
            monsterPanel.removeAll();
            mOutput.removeAll();
            mOutput2.removeAll();
            repaint();
            setVisible(true);
        }
    }
    public void addMonsterToMonsterPanel(boolean verbose) {
        int namePlace = Stats.monsterCount - 1;
        if (Stats.monsterWasCreated == 1) {
            
            String mName = Stats.nameArray[namePlace];
            JLabel image = Stats.monImg[namePlace];
            if (verbose) { Say.out("mName: " + mName);}
            JButton monster = new JButton(mName);
            monster.setAlignmentY(JButton.LEFT);
            if (verbose) { Say.out("Icon data: " + image);}
            monster.addActionListener(ButtonGuiOut);
            monsterLabels.put(mName, monster);
            monsterImages.put(mName, image);
            monsterPanel.add(monster);
            monsterPanel.add(image);
        }
        setVisible(true);
    }
    public static void removeMonsterFromMonsterPanel(String name, boolean verbose) {
        if (monsterLabels.containsKey(name)) {
            if (verbose) { Say.out("monsterLabels contains: " + name);}
            if (verbose) { Say.out("Attempting to remove monsterPanel.");}
            if (verbose) { Say.out("monsterLabels JPanel value: " + monsterLabels.get(name));}
            monsterPanel.remove(monsterLabels.get(name));
            monsterPanel.remove(monsterImages.get(name));
            
            monsterLabels.remove(name);
            monsterImages.remove(name);
            monsterPanel.repaint();
        }
    }
}