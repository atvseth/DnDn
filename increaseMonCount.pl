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