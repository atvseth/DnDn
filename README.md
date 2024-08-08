# DnDn
A DnD monster generator / multitool

Current code language: Perl based

Java branch kept until it can be reviewed for tools to pull into Perl


Use case:
	CLI for after combat letting someone pop off loot for a party
	should map to the DMG PDF as close as possible
	$1 - Number of people in party
	$2 - Avg. lvl of Party
	$3 - Number of enemies
	$4 - Avg. CR of enemies
System
	Take those args, and spit out Gold, and if it's passed into a Gold converter, spot out Items based on Gold thresholds
World Classifications:
	1 Commoner makes 1GP per day (Modest living)
	Cat (CR 0) has somewhat less than a 50/50 chance of killing a commoner
	Cat (CR = 0) is worth 1gp for a Commoner to kill it
	Therefore CR 0 = 1GP

TO DO: determine who CR scales (how do you go from 1GP for a Cat to x? GP for a Dragon?)

###
party
	1 person (lvl7)
	1 person (lvl7)
	1 person (lvl7)
	1 person (lvl7)

monster (CR 3)
	money
	items

monster (CR 3)
	money
	items

monster (CR 3)
	money
	items

monster (CR 3)
	money
	items

CR 3 -> Result x 4 = End Result
