package de.mcreloaded.custom.achievements;

public enum Achievements {
	
	FIRSTJOIN(1,"Hello there!", "Join the server for the first time!", 0, 0, AchievementCategory.BASIC),
	FIRSTCHAT(2, "Let the world hear your voice!", "Use the chat for the first time!", 0, 0, AchievementCategory.BASIC),
	ANTIBATMAN(3, "Anti-Batman","Murder a bat", 0, 0, AchievementCategory.COMBAT),
	MOOTATED(4, "Mootated", "Murder a mutated cow", 0, 0, AchievementCategory.FARMING),
	COLLECTIVESECURITY(5, "Collective Security" ,"Witness the collective power of zombified piglins", 0, 0, AchievementCategory.COMBAT),
	MINESPAWNER(6, "Unthinkable" ,"Break a spawner" ,0 ,0, AchievementCategory.MINING),
	NEWBEDROCK(7, "Bedrock 2.0" ,"Break a obsidian block with your hand" ,30 ,0, AchievementCategory.MINING),
	BUILDING(8, "Building" ,"Your only limit is your imagination... and resources" ,0 ,0, AchievementCategory.BUILDING),
	KILLVILLAGER(9, "Now I'm the Pillager!" ,"Murder a villager" ,0 ,0, AchievementCategory.COMBAT),
	FORCEOFNATURE(10, "Force of Nature", "Craft the scepter of the Forest", 0, 0, AchievementCategory.COMBAT),
	FORCEOFEARTH(11, "Force of Earth", "Craft the scepter of the Earth", 10, 0, AchievementCategory.MAGIC),
	SATANSSCEPTER(12, "Satans Scepter", "Craft the scepter of Hell", 30, 0, AchievementCategory.MAGIC),
	OLDONESSCEPTER(13, "The Old Ones Scepter", "Optain the Scepter of the Wise", 40, 0, AchievementCategory.MAGIC),
	VOIDSCEPTER(14, "Void Scepter", "Craft the Scepter of the End", 50, 0, AchievementCategory.MAGIC),
	ALLMIGTHYSCEPTER(15, "Sceptrum Omnipotentis", "Craft the thing that can destroy the FUCKING universe!!!", 150, 0, AchievementCategory.MAGIC),
	MAGICRENFORCMENT(16, "Magic Renforcement", "Consume a Manaheart", 10, 0, AchievementCategory.MAGIC);
	
	private final int databaseid;
	private final String name;
	private final String text;
	private final int exp;
	private final int rarity;
	private final AchievementCategory category;
	
	Achievements(int databaseid, String name, String text, int exp, int rarity, AchievementCategory category) {
		this.databaseid = databaseid;
		this.name = name;
		this.text = text;
		this.exp = exp;
		this.rarity = rarity;
		this.category = category;
	}
	
	public int getDatabaseID() {
		return this.databaseid;
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
	
	public AchievementCategory getCategory() {
		return this.category;
	}
}
