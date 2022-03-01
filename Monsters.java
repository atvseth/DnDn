package dnd;

import java.awt.image.BufferedImage;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Monsters {
    public static int nameCount = 1000 + Stats.monsterCount;
    public static String[] monsterTypes = {
        "Goblin",
        "Goblin Boss"
    };
    public static void goblin(String name) {
        Tasks.increaseMonsterCount(0);
        Stats Goblin = new Stats();
        Goblin.name = name;
        Goblin.monsterType = "Goblin";
        Goblin.description = "Small humanoid (goblinoid)";
        Goblin.alignment = "neutral evil";
        Goblin.armorClass = 15;
        Goblin.armorClassItems = Arr.nSA(Goblin.armorClassItems, name, "leather armor", 0);
        Goblin.armorClassItems = Arr.nSA(Goblin.armorClassItems, name, "shield", 0);
        Goblin.hitPointDefault = 7;
        Goblin.hitPointDescription = "2d6";
        Goblin.hitPointRoll = Dice.d6(2);
        Goblin.speed = 30;
        Goblin.strength = 8;
        Goblin.dexterity = 14;
        Goblin.constitution = 10;
        Goblin.intelligence = 10;
        Goblin.wisdom = 8;
        Goblin.charisma = 8;
        Goblin.skills = Arr.nSA(Goblin.skills, name, "Stealth +6", 0);
        Goblin.attributes = Arr.nSA(Goblin.attributes, name, "Nimble Escape. The goblin can take the Disengage or Hide action as a bonus action on each of its turns", 0);
        Goblin.senses = Arr.nSA(Goblin.senses, name, "darkvision 60ft.", 0);
        Goblin.senses = Arr.nSA(Goblin.senses, name, "passive Perception 9", 0);
        Goblin.languages = Arr.nSA(Goblin.languages, name, "Common", 0);
        Goblin.languages = Arr.nSA(Goblin.languages, name, "Goblin", 0);
        Goblin.challengeRating = .25;
        Goblin.experience = 50;
        Goblin.actions = Arr.nSA(Goblin.actions, name, "Scimitar. Melee Weapon Attack: +4 to hit, reach 5 ft., one target. Hit: 5 (1d6 + 2) slashing damage", 0);
        Goblin.actions = Arr.nSA(Goblin.actions, name, "Shortbow. Ranged Weapon Attack: +4 to hit, range 80/320ft., one target. Hit: 5 (1d6 + 2) piercing damage", 0);
        Goblin.reactions = Arr.nSA(Goblin.reactions, name, "None", 0);
        
        Stats.idArray = Arr.nSA(Stats.idArray, name, Goblin.toString(), 0);
        Stats.mCountArray = Arr.nIA(Stats.mCountArray, nameCount, nameCount, 0);
        Stats.nameArray = Arr.nSA(Stats.nameArray, name, Goblin.name, 0);
        Stats.typeArray = Arr.nSA(Stats.typeArray, name, Goblin.monsterType, 0);
        Stats.descriptionArray = Arr.nSA(Stats.descriptionArray, name, Goblin.description, 0);
        Stats.alignmentArray = Arr.nSA(Stats.alignmentArray, name, Goblin.alignment, 0);
        Stats.armorClassArray = Arr.nIA(Stats.armorClassArray, nameCount, Goblin.armorClass, 0);
        Stats.armorClassItemsArray = Arr.nSA2AA(Stats.armorClassItemsArray, name, Goblin.armorClassItems);
        Stats.hitPointsArray = Arr.nIA(Stats.hitPointsArray, nameCount, Goblin.hitPointRoll, 0);
        Stats.hitPointDefaultArray = Arr.nIA(Stats.hitPointDefaultArray, nameCount, Goblin.hitPointDefault, 0);
        Stats.hitPointDescriptionArray = Arr.nSA(Stats.hitPointDescriptionArray, name, Goblin.hitPointDescription, 0);
        Stats.hitPointRollArray = Arr.nIA(Stats.hitPointRollArray, nameCount, Goblin.hitPointRoll, 0);
        Stats.speedArray = Arr.nIA(Stats.speedArray, nameCount, Goblin.speed, 0);
        Stats.strengthArray = Arr.nIA(Stats.strengthArray, nameCount, Goblin.strength, 0);
        Stats.dexterityArray = Arr.nIA(Stats.dexterityArray, nameCount, Goblin.dexterity, 0);
        Stats.constitutionArray = Arr.nIA(Stats.constitutionArray, nameCount, Goblin.constitution, 0);
        Stats.intelligenceArray = Arr.nIA(Stats.intelligenceArray, nameCount, Goblin.intelligence, 0);
        Stats.wisdomArray = Arr.nIA(Stats.wisdomArray, nameCount, Goblin.wisdom, 0);
        Stats.charismaArray = Arr.nIA(Stats.charismaArray, nameCount, Goblin.charisma, 0);
        Stats.skillsArray = Arr.nSA2AA(Stats.skillsArray, name, Goblin.skills);
        Stats.sensesArray = Arr.nSA2AA(Stats.sensesArray, name, Goblin.senses);
        Stats.languagesArray = Arr.nSA2AA(Stats.languagesArray, name, Goblin.languages);
        Stats.challengeRatingArray = Arr.nSA(Stats.challengeRatingArray, name, Double.toString(Goblin.challengeRating), 0);
        Stats.experienceArray = Arr.nIA(Stats.experienceArray, nameCount, Goblin.experience, 0);
        Stats.attributesArray = Arr.nSA2AA(Stats.attributesArray, name, Goblin.attributes);
        Stats.actionsArray = Arr.nSA2AA(Stats.actionsArray, name, Goblin.actions);
        Stats.reactionsArray = Arr.nSA2AA(Stats.reactionsArray, name, Goblin.reactions);
        
        JLabel image = new JLabel(name + " the Goblin", new ImageIcon("src/dnd/images/goblin.png"), JLabel.LEFT);
        Stats.monImg = Arr.nJA(Stats.monImg, image);
    }
    public static void goblinBoss(String name) {    
        Tasks.increaseMonsterCount(0);
        Stats goblinBoss = new Stats();
        goblinBoss.name = name;
        goblinBoss.monsterType = "Goblin Boss";
        goblinBoss.description = "Small humanoid (goblinoid boss)";
        goblinBoss.alignment = "neutral evil";
        goblinBoss.armorClass = 17;
        goblinBoss.armorClassItems = Arr.nSA(goblinBoss.armorClassItems, name, "chain shirt", 0);
        goblinBoss.armorClassItems = Arr.nSA(goblinBoss.armorClassItems, name, "shield", 0);
        goblinBoss.hitPointDefault = 21;
        goblinBoss.hitPointDescription = "6d6";
        goblinBoss.hitPointRoll = Dice.d6(6);
        goblinBoss.speed = 30;
        goblinBoss.strength = 10;
        goblinBoss.dexterity = 14;
        goblinBoss.constitution = 10;
        goblinBoss.intelligence = 10;
        goblinBoss.wisdom = 8;
        goblinBoss.charisma = 10;
        goblinBoss.skills = Arr.nSA(goblinBoss.skills, name, "Stealth +6", 0);
        goblinBoss.attributes = Arr.nSA(goblinBoss.attributes, name, "Nimble Escape. The goblin can take the Disengage or Hide action as a bonus action on each of its turns", 0);
        goblinBoss.senses = Arr.nSA(goblinBoss.senses, name, "darkvision 60ft.", 0);
        goblinBoss.senses = Arr.nSA(goblinBoss.senses, name, "passive Perception 9", 0);
        goblinBoss.languages = Arr.nSA(goblinBoss.languages, name, "Common", 0);
        goblinBoss.languages = Arr.nSA(goblinBoss.languages, name, "Goblin", 0);
        goblinBoss.challengeRating = 1;
        goblinBoss.experience = 200;
        goblinBoss.actions = Arr.nSA(goblinBoss.actions, name, "Multiattack. The goblin makes two attacks with its scimitar. The second attack has disadvantage.", 0);
        goblinBoss.actions = Arr.nSA(goblinBoss.actions, name, "Scimitar. Melee Weapon Attack: +4 to hit, reach 5 ft., one target. Hit: 5 (1d6 + 2) slashing damage)", 0);
        goblinBoss.actions = Arr.nSA(goblinBoss.actions, name, "Javelin. Melee or Ranged Weapon Attack: +4 to hit, reach 5 ft. or range 30/120 ft., one target. Hit: 5 (1d6 + 2) piercing damage.", 0);
        goblinBoss.reactions = Arr.nSA(goblinBoss.reactions, name, "Redirect Attack. When a creature the goblin can see targets an attack, the goblin chooses another goblin within 5 feet of it. The two goblins swap places, and the chosen goblin becomes the target instead.", 0);
        
        Stats.idArray = Arr.nSA(Stats.idArray, name, goblinBoss.toString(), 0);
        Stats.mCountArray = Arr.nIA(Stats.mCountArray, nameCount, nameCount, 0);
        Stats.nameArray = Arr.nSA(Stats.nameArray, name, goblinBoss.name, 0);
        Stats.typeArray = Arr.nSA(Stats.typeArray, name, goblinBoss.monsterType, 0);
        Stats.descriptionArray = Arr.nSA(Stats.descriptionArray, name, goblinBoss.description, 0);
        Stats.alignmentArray = Arr.nSA(Stats.alignmentArray, name, goblinBoss.alignment, 0);
        Stats.armorClassArray = Arr.nIA(Stats.armorClassArray, nameCount, goblinBoss.armorClass, 0);
        Stats.armorClassItemsArray = Arr.nSA2AA(Stats.armorClassItemsArray, name, goblinBoss.armorClassItems);
        Stats.hitPointsArray = Arr.nIA(Stats.hitPointsArray, nameCount, goblinBoss.hitPointRoll, 0);
        Stats.hitPointDefaultArray = Arr.nIA(Stats.hitPointDefaultArray, nameCount, goblinBoss.hitPointDefault, 0);
        Stats.hitPointDescriptionArray = Arr.nSA(Stats.hitPointDescriptionArray, name, goblinBoss.hitPointDescription, 0);
        Stats.hitPointRollArray = Arr.nIA(Stats.hitPointRollArray, nameCount, goblinBoss.hitPointRoll, 0);
        Stats.speedArray = Arr.nIA(Stats.speedArray, nameCount, goblinBoss.speed, 0);
        Stats.strengthArray = Arr.nIA(Stats.strengthArray, nameCount, goblinBoss.strength, 0);
        Stats.dexterityArray = Arr.nIA(Stats.dexterityArray, nameCount, goblinBoss.dexterity, 0);
        Stats.constitutionArray = Arr.nIA(Stats.constitutionArray, nameCount, goblinBoss.constitution, 0);
        Stats.intelligenceArray = Arr.nIA(Stats.intelligenceArray, nameCount, goblinBoss.intelligence, 0);
        Stats.wisdomArray = Arr.nIA(Stats.wisdomArray, nameCount, goblinBoss.wisdom, 0);
        Stats.charismaArray = Arr.nIA(Stats.charismaArray, nameCount, goblinBoss.charisma, 0);
        Stats.skillsArray = Arr.nSA2AA(Stats.skillsArray, name, goblinBoss.skills);
        Stats.sensesArray = Arr.nSA2AA(Stats.sensesArray, name, goblinBoss.senses);
        Stats.languagesArray = Arr.nSA2AA(Stats.languagesArray, name, goblinBoss.languages);
        Stats.challengeRatingArray = Arr.nSA(Stats.challengeRatingArray, name, Double.toString(goblinBoss.challengeRating), 0);
        Stats.experienceArray = Arr.nIA(Stats.experienceArray, nameCount, goblinBoss.experience, 0);
        Stats.attributesArray = Arr.nSA2AA(Stats.attributesArray, name, goblinBoss.attributes);
        Stats.actionsArray = Arr.nSA2AA(Stats.actionsArray, name, goblinBoss.actions);
        Stats.reactionsArray = Arr.nSA2AA(Stats.reactionsArray, name, goblinBoss.reactions);
        
        JLabel image = new JLabel(name + " the Goblin Boss", new ImageIcon("src/dnd/images/goblin boss.png"), JLabel.LEFT);
        Stats.monImg = Arr.nJA(Stats.monImg, image);
    }
}