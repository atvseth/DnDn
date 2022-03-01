package dnd;

public class Tasks {
    public static void increaseMonsterCount(int verbose) {
        if (verbose == 1) { Say.out("monsterCount: " + Stats.monsterCount);}
        Stats.monsterCount++;
        Monsters.nameCount++;
        if (verbose == 1) { Say.out("monsterCount increased to: " + Stats.monsterCount);}
    }
    public static boolean monsterButton(String name) {
        boolean found = false;
        for (int i=0; i<Stats.monsterCount; i++) {
            if (Stats.nameArray[i] == name) {
                found = true;
            }
        }
        return found;
    }
    public static int returnMonsterCycle(String name) {
        int count = 0;
        for (int i=0; i<Stats.nameArray.length; i++) {
            if (Stats.nameArray[i] == name) {
                count = i;
            }
        }
        return count;
    }
}