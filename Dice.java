package dnd;

public class Dice {
    public static int d2 () {
        int roll = (int) (Math.random() * 2 + 1);
        return roll;
    }
    public static int d3 () {
        int roll = (int) (Math.random() * 3 + 1);
        return roll;
    }
    public static int d4 () {
        int roll = (int) (Math.random() * 4 + 1);
        return roll;
    }
    public static int d6 (int num) {
        int roll = 0;
        for (int i = 0; i < num; i++) {
            roll = (int) (roll + ((Math.random() * 6 + 1)));
        }
        return roll;
    }
    public static int d8 () {
        int roll = (int) (Math.random() * 8 + 1);
        return roll;
    }
    public static int d12 () {
        int roll = (int) (Math.random() * 12 + 1);
        return roll;
    }
    public static int d20 () {
        int roll = (int) (Math.random() * 20 + 1);
        return roll;
    }
    public static int d100 () {
        int roll = (int) (Math.random() * 100 + 1);
        return roll;
    }
}