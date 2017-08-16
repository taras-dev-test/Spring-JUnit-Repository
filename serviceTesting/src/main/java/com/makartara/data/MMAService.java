package com.makartara.data;

import java.util.List;

public interface MMAService {
	MMAFighter createFighter(String name,double wins, String style);
	void killFighterByID(long id);
	void killFighterByName(String name);
	void killAll();
	void clearStyles();
	boolean isThereName(String name);
	List<MMAFighter> findByStyle(String styleName);
	
	}
