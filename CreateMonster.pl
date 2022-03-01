#!/usr/bin/perl -w

use strict;

#open the MonsterTemplate and increase the ID count
print "CreateMonster.pl opened\n";
print "Opening CreateMonster.txt\n";
open (inMonsterTemplate, '<', "MonsterTemplate.txt");
my @File = <inMonsterTemplate>;
my $fileLength = scalar @File;
print "Length of file is: $fileLength lines\n";

#increase the ID
open outMonsterTemplate, ">MonsterTemplate.txt";
foreach my $value (@File) {
	no warnings 'numeric';
	if ($value == $File[1]) {
		$File[1]++;
		print outMonsterTemplate "$value\n";
	} else {
	print outMonsterTemplate "$value";
	}
};

close inMonsterTemplate;
close outMonsterTemplate;

#give the ID
my $mID = $File[1];
chomp $mID;
print "New monster created with ID: $mID\n";

print "Please name the monster\n";
my $mName = <STDIN>;
chomp $mName;

print "Specify monster type:\n";
my $mType = <STDIN>;
chomp $mType;

#create the creature
my $fileName = "Monsters/ID: $mID - $mName the $mType.txt";
open newMonster, ">$fileName" or die "Can't open $fileName: $!";
print "$fileName created.";
print newMonster "ID\n";
print newMonster "$mID\n";
close newMonster or die "Couldn't close $fileName";