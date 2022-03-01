#!/usr/bin/perl -w

use strict;

print "Welcome to DnDn.  What would you like to do:
1. Create monster from scratch
2. Create monster from template (MUCH MUCH quicker)
3. Look up monster
4. Delete monster
5. Edit monster
6. Exit
Please answer with the number corresponding to the choices listed.\n";

my $choice = <STDIN>;

if ($choice == 1) {
	#creating new monster from scratch
	print "Opening CreateMonster.pl\n";
	do "./CreateMonster.pl" or die "Couldn't open CreateMonster.pl\nPlease consult that file for errors.";
}

if ($choice == 2) {
	#creating new monster from template
	print "Opening CopyMonster.pl\n";
	do "./CopyMonster.pl" or die "Couldn't open CopyMonster.pl\nPlease consult that file for errors.";
}

if ($choice == 3) {

}

if ($choice == 4) {
	# do nothing and exit
}