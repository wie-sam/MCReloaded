package de.mcreloaded.custom.achievements;

public class AchievementCache{
	
	private final Achievements achievement;
	private final Long timeclaimed;
	
	public AchievementCache(Achievements achievement, Long timeclaimed) {
		this.achievement = achievement;
		this.timeclaimed = timeclaimed;
	}
	
	public final Achievements getAchievement() {
		return this.achievement;
	}
	
	public final Long getTimeClaimed() {
		return this.timeclaimed;
	}
}
