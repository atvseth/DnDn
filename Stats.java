package dnd;

import java.util.*;
import javax.swing.*;

public class Stats {
    public String name;
    public static JLabel[] monImg = new JLabel[0];
    public String monsterType;
    public String description;
    public String alignment;
    public int armorClass;
    public String[] armorClassItems = new String[0];
    public int hitPoints;
    public int hitPointDefault;
    public String hitPointDescription;
    public int hitPointRoll;
    public int speed;
    public int strength;
    public int dexterity;
    public int constitution;
    public int intelligence = 0;
    public int wisdom = 0;
    public int charisma = 0;
    public String[] skills = new String[0];
    public String[] senses = new String[0];
    public String[] languages = new String[0];
    public double challengeRating;
    public int experience;
    public String[] attributes = new String[0];
    public String[] actions = new String[0];
    public String[] reactions = new String[0];
    
    public static int monsterCount = 0;
    public static int monsterWasCreated = 0;
    
    public static String[] idArray = new String[0];
    public static int[] mCountArray = new int[0];
    public static String[] nameArray = new String[0];
    public static String[] typeArray = new String[0];
    public static String[] descriptionArray = new String[0];
    public static String[] alignmentArray = new String[0];
    public static int[] armorClassArray = new int[0];
    public static String[] armorClassItemsArray = new String[0];
    public static int[] hitPointsArray = new int[0];
    public static int[] hitPointDefaultArray = new int[0];
    public static String[] hitPointDescriptionArray = new String[0];
    public static int[] hitPointRollArray = new int[0];
    
    public static int[] speedArray = new int[0];
    public static int[] strengthArray = new int[0];
    public static int[] dexterityArray = new int[0];
    public static int[] constitutionArray = new int[0];
    public static int[] intelligenceArray = new int[0];
    public static int[] wisdomArray = new int[0];
    public static int[] charismaArray = new int[0];
    public static String[] skillsArray = new String[0];
    public static String[] sensesArray = new String[0];
    public static String[] languagesArray = new String[0];
    public static String[] challengeRatingArray = new String[0];
    public static int[] experienceArray = new int[0];
    public static String[] attributesArray = new String[0];
    public static String[] actionsArray = new String[0];
    public static String[] reactionsArray = new String[0];
    
    public int abilityScore (int stat) {
        int result = (stat - 10) / 2;
        return result;
    }

    public static void createFromArgs (String name, int type, boolean verbose) {
        if (verbose) { Say.out("Received name: " + name); }
        if (verbose) { Say.out("Received type: " + type); }
        if (Arr.monNameNoExist(name)) {
            monsterWasCreated = 1;
            switch (type) {
            case 0 : {
                Monsters.goblin(name);
                break;
                }
            case 1 : {
                Monsters.goblinBoss(name);
                break;
                }
            default : {
                Say.out("Type of creature not found: " + type + " not created.");
                monsterWasCreated = 0;
                }
            }
        }
        else {
            Say.out("Name of creature found: " + name + " not created.  Use different name!");
            monsterWasCreated = 0;
        }
    }
    
    
    
    
    
}