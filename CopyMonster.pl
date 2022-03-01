#!/usr/bin/perl -w

use strict;

my $monCount=0;
my $mName="";
my $mType = "";
my $mSize = "";
my $mAlignment = "";
my $mAC = "";
my $mHP = "";

sub incMonCount {
#open the MonsterTemplate and increase the ID count
open (inMonsterTemplate, '<', "MonsterTemplate.txt");
my @File = <inMonsterTemplate>;
my $fileLength = scalar @File;

#increase the ID
open outMonsterTemplate, ">MonsterTemplate.txt";
foreach my $value (@File) {
	no warnings 'numeric';
	if ($value == $File[1]) {
		$File[1]++;
		$monCount = $value;
		print outMonsterTemplate "$value\n";
	} else {
	print outMonsterTemplate "$value";
	}
};

close inMonsterTemplate;
close outMonsterTemplate;
}

sub monFileCreation {
my $fileName = "Monsters/id $monCount - $mName the $mType.txt";
open newMonster, ">$fileName" or die "Can't open $fileName: $!";
print "id $monCount - $mName the $mType created.\n";
print newMonster "ID:\n";
print newMonster "$monCount\n";
print newMonster "Name:\n";
print newMonster "$mName\n";
print newMonster "Type:\n";
print newMonster "$mType\n";
print newMonster "Size:\n";
print newMonster "$mSize\n";
print newMonster "Alignment:\n";
print newMonster "$mAlignment\n";
print newMonster "Armor Class:\n";
print newMonster "$mAC\n";
print newMonster "Hit Points:\n";
print newMonster "$mHP";
close newMonster or die "Couldn't close $fileName";
}

print "What type of monster are you creating?  Punctuation matters:\n";
my $monsterType = <STDIN>;
chomp $monsterType;

if ($monsterType eq "Goblin") {
	print "Please name the creature\n";
	my $monsterName = <STDIN>;
	chomp $monsterName;
	$mName = $monsterName;
	do incMonCount;
	$mType = "Goblin";
	$mSize = "Humanoid";
	$mAlignment = "Neutral Evil";
	$mAC = "15";
	$mHP = "7";
	do monFileCreation;
}

else {
	print "Your type of monster is not implemented in this script yet.
Would you like to consider helping add it?! :P";
	}
	
do "./FrontDoor.pl"