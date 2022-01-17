package de.mcreloaded.custom.items;

import java.util.ArrayList;
import java.util.List;

public class LoreBuilder {

	@SuppressWarnings("unused")
	private final CustomItem customitem;
	private final List<String> descriptionlines;
	
	
	public LoreBuilder(CustomItem customitem) {
		this.customitem = customitem; 
		this.descriptionlines = new ArrayList<>();
	}
	
	public final LoreBuilder addDescriptionLine(String content) {
		descriptionlines.add("§f"+content);
		return this;
	}
	
	public final LoreBuilder setDescriptionLines(String... content) {
		descriptionlines.clear();
		for(String line : content) {
			descriptionlines.add("§f"+line);
		}
		return this;
	}
	
	public final LoreBuilder clearDescriptionLines() {
		descriptionlines.clear();
		return this;
	}
	
	public final List<String> build(){
		final List<String> finishlines = new ArrayList<>();
		
		finishlines.add(" ");
		finishlines.addAll(descriptionlines);
		
		return finishlines;
	}
	
}
