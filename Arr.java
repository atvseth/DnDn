package dnd;
import dnd.GUIs.creationGUI;
import javax.swing.*;

public class Arr {

    /**
     * "new String Array" : Returns a new string array, putting variable "newItem" into "originalArray"
     */
    public static String[] nSA(String[] originalArray, String nameIsIdentifier, String newItem, int verbose) {
            if (verbose == 1) { 
            Say.out("I received a String array for " + originalArray.toString() + ". Here's the orginal: ");
            if (originalArray.length > 0) {
                for (int i = 0; i < originalArray.length; i++) {
                Say.out("Item " + i + ": " + originalArray[i]);
                } 
            } else if (originalArray.length == 0) {
                Say.out("The original string is empty.");
            }
            int currentSize;
            currentSize = originalArray.length;
            int newSize = currentSize + 2;
            String[] tempArray = new String[newSize];
            for (int i=0; i < currentSize; i++)
            {
                tempArray[i] = originalArray [i];
            }
            tempArray[newSize - 2] = nameIsIdentifier;
            tempArray[newSize - 1] = newItem;
            if (tempArray[newSize - 2] == tempArray[newSize - 1]) {
                String[] trimmer = new String[tempArray.length - 1];
                for (int i = 0; i < (tempArray.length - 1); i++) {
                    trimmer[i] = tempArray[i];
                }
                tempArray = trimmer;
            }
            Say.out(originalArray.length + ", " + tempArray.length);
            originalArray = tempArray;
            //Say.out("The string now contains: ");
            for (int i = 0; i < tempArray.length; i++) {
                Say.out("Item " + i + ": "  + originalArray[i]);
            }
            } 
            
            else if (verbose == 0) {
            int currentSize;
            currentSize = originalArray.length;
            int newSize = currentSize + 2;
            String[] tempArray = new String[newSize];
            for (int i=0; i < currentSize; i++)
            {
                tempArray[i] = originalArray [i];
            }
            tempArray[newSize - 2] = nameIsIdentifier;
            tempArray[newSize - 1] = newItem;
            if (tempArray[newSize - 2] == tempArray[newSize - 1]) {
                String[] trimmer = new String[tempArray.length - 1];
                for (int i = 0; i < (tempArray.length - 1); i++) {
                    trimmer[i] = tempArray[i];
                }
                tempArray = trimmer;
            }
            originalArray = tempArray;
            }
            return originalArray;
        }
    
    /**
     * "new String Array To Another Array" : Like rNSA, but used to copy one array into another
     */
    public static String[] nSA2AA(String[] originalArray, String nameIsIdentifier, String[] newArray) {
        int posCount = 0;
        int newArrayPos = 0;
        int currentSize = originalArray.length;
        int newSize = newArray.length;
        int expandedSize = (currentSize + newSize);
        String[] tempArray = new String[expandedSize];
        if (originalArray.length == 0) {
            for (int i = posCount; i < tempArray.length; i++) {
                tempArray[i] = newArray[i];
            }
            originalArray = tempArray;
            return originalArray;
        }
        else {
            for (int j = 0; j < currentSize; j++) {
                tempArray[j] = originalArray[j];
                posCount++;
            }
            for (int i = posCount; i < expandedSize; i++) {
                tempArray[i] = newArray[newArrayPos];

                newArrayPos++;
            }
            originalArray = tempArray;
            return originalArray;
        }
    }
    
    /**
     * "new Integer Array" : Same as rNSA, but for Integers
     */
    public static int[] nIA(int[] originalArray, int nameIsIdentifier, int newItem, int verbose) {
            if (verbose == 1) { Say.out("I received a String array for " + originalArray.toString() + ". Here's the orginal: ");}
            if (originalArray.length > 0) {
                for (int i = 0; i < originalArray.length; i++) {
                if (verbose == 1) { Say.out("Item " + i + ": " + originalArray[i]);}
                } 
            } else if (originalArray.length == 0) {
                if (verbose == 1) { Say.out("The original string is empty.");}
            }
            int currentSize;
            currentSize = originalArray.length;
            int newSize = currentSize + 2;
            int[] tempArray = new int[newSize];
            for (int i=0; i < currentSize; i++)
            {
                tempArray[i] = originalArray[i];
            }
            tempArray[newSize - 2] = nameIsIdentifier;
            if (verbose == 1) { Say.out("nameIsIdentifier: " + nameIsIdentifier);}
            tempArray[newSize - 1] = newItem;
            if (verbose == 1) { Say.out("newItem: " + newItem);}
            if (tempArray[newSize - 2] == tempArray[newSize - 1]) {
                int[] trimmer = new int[tempArray.length - 1];
                if (verbose == 1) { Say.out("Trimmer Length: " + trimmer.length);}
                if (verbose == 1) { Say.out("tempArray.length - 1: " + (tempArray.length - 1));}
                for (int j = 0; j < (tempArray.length - 1); j++) {
                    if (verbose == 1) { Say.out("Trimmer [" + j + "]" +
                    " equals tempArray [" + tempArray[j] + "]");}
                    trimmer[j] = tempArray[j];
                }
                tempArray = trimmer;
            }
            if (verbose == 1) { Say.out("Original length: " + originalArray.length + ", temp Length: " + tempArray.length);}
            originalArray = tempArray;
            if (verbose == 1) { Say.out("The string now contains: ");}
            for (int i = 0; i < tempArray.length; i++) {
                if (verbose == 1) { Say.out("Item " + i + ": "  + originalArray[i]);}
            }
            return originalArray;
        }
    
    /**
     * "new Object Array" : Same as rNSA, but for objects
     */
    public static Object[] nOA(Object[] originalArray, Object newItem) {
            int currentSize;
            currentSize = originalArray.length;
            int newSize = currentSize + 1;
            Object[] tempArray = new Object[newSize];
            for (int i=0; i < currentSize; i++)
            {
                tempArray[i] = originalArray [i];
            }
            tempArray[newSize - 1] = newItem;
            return tempArray;
        }
    
    public static JLabel[] nJA(JLabel[] originalArray, JLabel newItem) {
            int currentSize;
            currentSize = originalArray.length;
            int newSize = currentSize + 1;
            JLabel[] tempArray = new JLabel[newSize];
            for (int i=0; i < currentSize; i++)
            {
                tempArray[i] = originalArray[i];
            }
            tempArray[newSize - 1] = newItem;
            return tempArray;
        }
    
    /**
     * Resets a String[] array to empty
     */
    public static void rString(String[] originalArray) {
        String[] tempArray = new String[0];
        originalArray = tempArray;
    }
    
    /**
     * Resets an Object[] array to empty
     */
    public static Object[] rObject(Object[] originalArray) {
        Object [] tempArray = new Object[0];
        originalArray = tempArray;
        return originalArray;
    }
    
    /**
     * return String[] from Int[]
     * @param original
     * @return 
     */
    public static String[] rSAFIA(int[] original) {
        String[] returnable = new String[original.length];
        for (int i=0; i < original.length; i++) {
            returnable[i] = Integer.toString(original[i]);
        }
        return returnable;
    }
    
    /**
     * Prints everything in a String[] array.  
     * "options" determine verbosity: Use "v" for output of steps, "s" for silent
     */
    public static void printArray (String nameOfArray, String[] var, String options) {
        switch (options) {
            case "v": {
                System.out.println("Array type: String[]. " + 
                        "Beginning PrintArray for " + nameOfArray);
                for (int i  = 0; i < var.length; i++) {
                    System.out.println("Item " + i + ": " + var[i]);
                }
                System.out.println("PrintArray for " + nameOfArray + " is done.");
                break;
            }
            case "s": {
                for (int i  = 0; i < var.length; i++) {
                    System.out.println("Item " + (i + 1) + ": " + var[i]);
                }
                break;
            }
        }
    }
    
    /**
     * Prints everything in an int[] array.  
     * "options" determine verbosity: Use "v" for output of steps, "s" for silent
     */
    public static void printArray (String nameOfArray, int[] var, String options) {
        switch (options) {
            case "v": {
                System.out.println("Array type: String[]. " + 
                        "Beginning PrintArray for " + nameOfArray);
                for (int i  = 0; i < var.length; i++) {
                    System.out.println("Item " + i + ": " + var[i]);
                }
                System.out.println("PrintArray for " + nameOfArray + " is done.");
                break;
            }
            case "s": {
                for (int i  = 0; i < var.length; i++) {
                    System.out.println("Item " + (i + 1) + ": " + var[i]);
                }
                break;
            }
        }
    }
    
    /**
     * Prints everything in an Object[] array.  
     * "options" determine verbosity: Use "v" for output of steps, "s" for silent
     */
    public static void printArray (String nameOfArray, Object[] var, String options) {
        switch (options) {
            case "v": {
                System.out.println("Array type: Object[]. " +
                        "Beginning PrintArray for " + nameOfArray);
                for (int i  = 0; i < var.length; i++) {
                    System.out.println("Item " + (i + 1) + ": " + var[i]);
                }
                System.out.println("PrintArray for " + nameOfArray + " is done.");
                break;
            }
            case "s": {
                for (int i  = 0; i < var.length; i++) {
                    System.out.println("Item " + (i + 1) + ": " + var[i]);
                }
                break;
            }
        }
    }
    
    /**
     * Prints everything in a double[] array.  
     * "options" determine verbosity: Use "v" for output of steps, "s" for silent
     */
    public static void printArray (double[] var, String options) {
        switch (options) {
            case "v": {
                System.out.println("Array type: double[]. " +
                        "Beginning PrintArray for " + var);
                for (int i  = 0; i < var.length; i++) {
                    System.out.println("Item " + (i + 1) + ": " + var[i]);
                }
                System.out.println("PrintArray for " + var + " is done.");
                break;
            }
            case "s": {
                for (int i  = 0; i < var.length; i++) {
                    System.out.println("Item " + (i + 1) + ": " + var[i]);
                }
                break;
            }
        }
    }
    
    /**
     * Prints everything in a float[] array.  
     * "options" determine verbosity: Use "v" for output of steps, "s" for silent
     */
    public static void printArray (float[] var, String options) {
        switch (options) {
            case "v": {
                System.out.println("Array type: float[]. " +
                        "Beginning PrintArray for " + var);
                for (int i  = 0; i < var.length; i++) {
                    System.out.println("Item " + (i + 1) + ": " + var[i]);
                }
                System.out.println("PrintArray for " + var + " is done.");
                break;
            }
            case "s": {
                for (int i  = 0; i < var.length; i++) {
                    System.out.println("Item " + (i + 1) + ": " + var[i]);
                }
                break;
            }
        }
    }
    
    /**
     * Prints every monster's name to the logger.  Add "1" to option for ID as well.
     */
    public static void printMonNames (int option) {
        int itemCount = 0;
        for (int i = 0; i < Stats.monsterCount + 1; i = i + 2) {
            itemCount++;
            Say.out("Monster " + itemCount + ": " + 
                    Stats.idArray[i]);
            if (option == 1) {
                Say.out(Stats.idArray[i] + " ID: " + Stats.idArray[i + 1]);
            }
        }
    }
    
    /**
     * Partially finished printer of all "stats" arrays!  USE WITH CAUTION!
     */
    public static void checkAllMonsInStats() {
        Arr.printArray("idArray", Stats.idArray, "v");
        Arr.printArray("nameArray", Stats.nameArray, "v");
        Arr.printArray("typeArray", Stats.typeArray, "v");
        Arr.printArray("descriptionArray", Stats.descriptionArray, "v");
        Arr.printArray("alignmentArray", Stats.alignmentArray, "v");
        printArray("armorClassArray", Stats.armorClassArray, "v");
        Arr.printArray("armorClassItemsArray", Stats.armorClassItemsArray, "v");
    }
    
    /**
     * Used in the GUI to tie a list of items in an array into a comma delimited
     * string.  Discontinued by "returnAMonsterStringArray"
     */
    public static String concatMonArray (String[] array, String monName) {
        String temp = "";
        int firstCount = 0;
        for (int i = 0; i < array.length; i++) {
            if (i == 0 && array[i] == monName) {
                temp = temp + array[i + 1];
                firstCount = 1;
            }
            else if (array[i] == monName) {
                if (firstCount == 0) {
                    temp = temp + array[i + 1];
                    firstCount = 1;
                }
                else {
                    temp = temp + ", " + array[i + 1];
                }
            }
        }
        return temp;
    }
    
    /**
     * Counts the number of time a monster has values in a String[].  Used
     * in the GUI "MonCycle" to determine the number of JLabels needed for creating
     * stats in the JPanel.
     */
    public static int countForMonCycle (String[] array, String monName) {
        int values = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == monName) {
                values++;
            }
        }
        return values;
    }
    
    /**
     * Returns a String[] where monster values were found
     * @param array A Stats public static String[] to be searched
     * @param monName The name to find in Stats String[]
     * @return A String[] with values in Stats String[]
     */
    public static String[] monStringArray (String[] array, String monName) {
        int count = Arr.countForMonCycle(array, monName);
        String[] temp = new String[count];
        int pos = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == monName) {
                temp[pos] = array[i + 1];
                pos++;
            }
        }
        return temp;
    }
    
    /**
     * Turns a double into a String
     * @param input double variable (i.e. 1.75)
     * @return (i.e. "1.75")
     */
    public static String double2String (double input) {
        String output = Double.toString(input);
        return output;
    }
    
    /**
     * Used in the Listener to find out if a monster's name already exists.
     * If found, will not allow monster to be created, while also sending
     * error to logger.
     * @param name The name to check against the name array: Stats.nameArray[] 
     * which is a String[]
     * @return true or false statement to the instance asking for whether the
     * name is there.
     */
    public static boolean monNameNoExist (String name) {
        boolean notExist = true;
        for (int i = 0; i < Stats.nameArray.length; i++) {
            //Say.out("Comparing " + Stats.nameArray[i].toString() + " to " + name);
            if (Stats.nameArray[i].contains(name)) {
                notExist = false;
            }
        }
        return notExist;
    }
    
    public static boolean monIDNoExist (String ID) {
        boolean notExist = true;
        for (int i = 0; i < Stats.idArray.length; i++) {
            //Say.out("Comparing " + Stats.nameArray[i].toString() + " to " + name);
            if (Stats.idArray[i].contains(ID)) {
                notExist = false;
            }
        }
        return notExist;
    }
    
    /**
     * Remove monster from stats.  Calls many references.  Very complicated...
     * Only genius could figure this out...
     */
    public static void removeMon(boolean verbose) {
        Stats.monsterCount--;
        int count = creationGUI.mCycleCount;
        String name = Stats.nameArray[count];
        int ID = Stats.mCountArray[count];
        if (verbose) { Say.out("Deleting monster at ID: " + count);
        Say.out("Monster's name: " + name); }
        creationGUI.removeMonsterFromMonsterPanel(name, false);
        removeFromID(name, false);
        removeFromNameArray(name, false);
        Stats.mCountArray = removeFromMCountArray(name, Stats.mCountArray, count, false);
        Stats.typeArray = rFSA(name, Stats.typeArray, false);
        Stats.descriptionArray = rFSA(name, Stats.descriptionArray, false);
        Stats.alignmentArray = rFSA(name, Stats.alignmentArray, false);
        Stats.armorClassArray = rFIA(ID, Stats.armorClassArray, false);
        Stats.armorClassItemsArray = mRFSA(name, Stats.armorClassItemsArray, false);
        Stats.hitPointsArray = rFIA(ID, Stats.hitPointsArray, false);
        Stats.hitPointDefaultArray = rFIA(ID, Stats.hitPointDefaultArray, false);
        Stats.hitPointDescriptionArray = rFSA(name, Stats.hitPointDescriptionArray, false);
        Stats.hitPointRollArray = rFIA(ID, Stats.hitPointRollArray, false);
        Stats.speedArray = rFIA(ID, Stats.speedArray, false);
        Stats.strengthArray = rFIA(ID, Stats.strengthArray, false);
        Stats.dexterityArray = rFIA(ID, Stats.dexterityArray, false);
        Stats.constitutionArray = rFIA(ID, Stats.constitutionArray, false);
        Stats.intelligenceArray = rFIA(ID, Stats.intelligenceArray, false);
        Stats.wisdomArray = rFIA(ID, Stats.wisdomArray, false);
        Stats.charismaArray = rFIA(ID, Stats.charismaArray, false);
        Stats.skillsArray = oMRFSA(name, Stats.skillsArray, false);
        Stats.sensesArray = mRFSA(name, Stats.sensesArray, false);
        Stats.languagesArray = mRFSA(name, Stats.languagesArray, false);
        Stats.challengeRatingArray = rFSA(name, Stats.challengeRatingArray, false);
        Stats.experienceArray = rFIA(ID, Stats.experienceArray, false);
        Stats.attributesArray = oMRFSA(name, Stats.attributesArray, false);
        Stats.actionsArray = mRFSA2(name, Stats.actionsArray, false);
        Stats.reactionsArray = oMRFSA(name, Stats.reactionsArray, false);
    }
    
    /**
     * Subset of removeMon for removing from stats.idArray
     * @param name
     * @param verbose 
     */
    public static void removeFromID(String name, boolean verbose) {
        if (verbose) { Say.out("Stats.idArray length: " + Stats.idArray.length);}
        String[] array = Stats.idArray;
        int currentSize = array.length;
        int j = 0;
        String[] newArray = new String[currentSize - 2];
        if (verbose) { Say.out("newArray's length: " + newArray.length);}
        for (int i=0; i < currentSize; i++)
        {
            if (array[i] == name) {
                if (verbose) { Say.out(array[i] + " equals given name: " + name);
                Say.out("Replacing the object string: " + array[i+1] + " with \"" + name + "\"");}
                array[i+1] = array[i];
                i++;
            }
        }
        if (newArray.length > 0) {
            for (int i=0; i < currentSize; i++)
            {
                if (verbose) { Say.out("Cycle: " + (i+1)); }
                if (verbose) { Say.out("Item: " + array[i]);
                }
                if (array[i] != name) {
                    if (verbose) { Say.out(array[i] + " does not equal: " + name);}
                    newArray[j] = array[i];
                    j++;
                }
            }
        }
        Stats.idArray = newArray;
        if (verbose) { printArray("idArray", Stats.idArray, "s");}
    }
    public static void removeFromNameArray(String name, boolean verbose) {
        String[] array = Stats.nameArray;
        String[] newArray = new String[Stats.nameArray.length - 1];
        int newArrayPos = 0;
        for (int i=0; i < array.length; i++) {
            if (array[i] != name) {
                newArray[newArrayPos] = array[i];
                newArrayPos++;
            }
        }
        Stats.nameArray = newArray;
        if (verbose) { Arr.printArray("new Stats.nameArray", Stats.nameArray, "v"); }
    }
    public static int[] removeFromMCountArray (String name, int[] array, int place, boolean verbose) {
        int ID = Stats.mCountArray[place];
        if (verbose) { Say.out("Place: " + place); }
        if (verbose) { Say.out("ID: " + ID); }
        int[] newArray = new int[array.length - 1];
        int newArrayPos = 0;
        for (int i=0; i<array.length; i++) {
            if (array[i] != ID) {
                newArray[newArrayPos] = array[i];
                newArrayPos++;
            }
        }
        return newArray;
    }
    public static String[] rFSA(String name, String[] array, boolean verbose) {
        String[] newArray = new String[array.length - 2];
        int pos = 0;
        for (int i=0; i<array.length; i++) {
            if (array[i] == name) {
                array[i+1] = name;
                break;
            }
        }
        for (int i=0; i<array.length; i++) {
            if (array[i] != name) {
                newArray[pos] = array[i];
                pos++;
            }
        }
        return newArray;
    }
    public static String[] mRFSA(String name, String[] array, boolean verbose) {
        int pingCount = 1;
        int pos = 0;
        for (int i=0; i<array.length; i++) {
            if (array[i] == name) {
                pingCount++;
            }
        }
        String[] newArray = new String[array.length - ((pingCount - 1) * 2)];
        if (verbose) { Say.out("Array length: " + array.length);
            Say.out("pingCount: " + pingCount);
            Say.out("newArray length: " + newArray.length);
            }
        //this requires array item identifiers to be in a row
        for (int i=0; i<array.length; i++) {
            if (array[i] == name) {
                if (pingCount != 0) {
                    array[i+1] = name;
                    pingCount--;
                }
            }
        }
        for (int i=0; i<array.length; i++) {
            if (array[i] != name) {
                newArray[pos] = array[i];
                if (verbose) { Say.out("Added to newArray: " + newArray[pos]); }
                pos++;
            }
        }
        return newArray;
    }
    public static String[] mRFSA2(String name, String[] array, boolean verbose) {
        boolean greater = false;
        int pingCount = 1;
        int pos = 0;
        for (int i=0; i<array.length; i++) {
            if (array[i] == name) {
                pingCount++;
            }
        }
        if (pingCount>3) {
            greater = true;
        }
        String[] newArray = new String[array.length - ((pingCount - 1) * 2)];
        if (verbose) { Say.out("Array length: " + array.length);
            Say.out("pingCount: " + pingCount);
            Say.out("newArray length: " + newArray.length);
            }
        //this requires array item identifiers to be in a row
        for (int i=0; i<array.length; i++) {
            if (array[i] == name) {
                if (!greater && pingCount != 0) {
                    array[i+1] = name;
                    pingCount--;
                }
                else if (greater && pingCount != -1) {
                    array[i+1] = name;
                    pingCount--;
                }
            }
        }
        for (int i=0; i<array.length; i++) {
            if (array[i] != name) {
                if (verbose) { Say.out("newArray[pos]: " + pos);}
                if (verbose) { Say.out("array[i]: " + i);}
                if (greater) {
                    newArray[pos] = array[i];
                }
                else if (!greater) {
                    newArray[pos] = array[i];
                }
                if (verbose) { Say.out("Added to newArray: " + newArray[pos]); }
                pos++;
            }
        }
        return newArray;
    }
    public static String[] oMRFSA(String name, String[] array, boolean verbose) {
       int pingCount = 1;
        int pos = 0;
        for (int i=0; i<array.length; i++) {
            if (array[i] == name) {
                pingCount++;
            }
        }
        String[] newArray = new String[array.length - ((pingCount - 1) * 2)];
        if (verbose) { Say.out("Array length: " + array.length);
            Say.out("pingCount: " + pingCount);
            Say.out("newArray length: " + newArray.length);
            }
        //this requires array item identifiers to be in a row
        for (int i=0; i<array.length; i++) {
            if (array[i] == name) {
                if (pingCount != 1) {
                    if (verbose) { Say.out("Array Item: " + array[i+1] + " becomes: " + name); }
                    array[i+1] = name;
                    if (verbose) { Say.out("pingCount: " + pingCount);}
                    pingCount--;
                    if (verbose) { Say.out("pingCount becomes: " + pingCount);}
                }
            }
        }
        for (int i=0; i<array.length; i++) {
            if (array[i] != name) {
                newArray[pos] = array[i];
                if (verbose) { Say.out("Added to newArray: " + newArray[pos]); }
                pos++;
            }
        }
        return newArray;
    }
    public static int[] rFIA(int ID, int[] array, boolean verbose) {
        int[] newArray = new int[array.length - 2];
        int pos = 0;
        for (int i=0; i<array.length; i++) {
            if (array[i] == ID) {
                array[i+1] = ID;
                break;
            }
        }
        for (int i=0; i<array.length; i++) {
            if (array[i] != ID) {
                newArray[pos] = array[i];
                pos++;
            }
        }
        return newArray;
    }
    public static String[] replStringVals(String[] array, String original, String newVal) {
        String[] temp = array;
        for (int i=0; i < array.length; i++) {
            if (array[i] == original) {
                temp[i] = newVal;
            }
        }
        return temp;
    }
}