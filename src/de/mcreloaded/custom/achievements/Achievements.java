package de.mcreloaded.custom.achievements;

public enum Achievements {
	
	FIRSTJOIN(1,"Hello there!", "Join the server for the first time!", 0, 0),
	FIRSTCHAT(2, "Let the world hear your voice!", "Use the chat for the first time!", 0, 0),
	ANTIBATMAN(3, "Anti-Batman","Murder a bat", 0, 0),
	MOOTATED(4, "Mootated", "Murder a mutated cow", 0, 1),
	COLLECTIVESECURITY(5, "Collective Security" ,"Witness the collective power of zombified piglins", 0, 1),
	MINESPAWNER(6, "Unthinkable" ,"Break a spawner" ,0 ,1),
	NEWBEDROCK(7, "Bedrock 2.0" ,"Break a obsidian block with your hand" ,0 ,1),
	BUILDING(8, "Building" ,"Your only limit is your imagination... and resources" ,0 ,0),
	KILLVILLAGER(9, "Now I'm the Pillager!" ,"Murder a villager" ,0 ,0);
	
	final int databaseid;
	final String name;
	final String text;
	final int exp;
	final int rarity;

	Achievements(int databaseid, String name, String text, int exp, int rarity) {
		this.databaseid = databaseid;
		this.name = name;
		this.text = text;
		this.exp = exp;
		this.rarity = rarity;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getText() {
		return this.text;
	}
	
	public int getExp(){
		return this.exp;
	}
	
	public int getRarity(){
		return this.rarity;
	}
}
