package de.mcreloaded.custom.items;

import java.util.ArrayList;
import java.util.List;

import de.mcreloaded.custom.items.types.IronHammer;
import de.mcreloaded.tools.ConsoleLogger;

public class ItemManager {

	private final List<CustomItem> cilist;
	
	public ItemManager() {
		this.cilist = new ArrayList<CustomItem>();
		initItems();
	}
	
	private void initItems() {
		this.cilist.add(new IronHammer());
	}
	
	public CustomItem getCustomItemByID(ItemType itemtype){
		
		for(CustomItem ci : cilist) {
			if(ci.getItemType().equals(itemtype)) {
				return new CustomItem(ci);
			}
		}
		ConsoleLogger.error("ItemManager", itemtype.name()+" not found!!!");
		return null;
	}
	
}
