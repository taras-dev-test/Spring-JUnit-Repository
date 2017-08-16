package com.makartara.data;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MMAServiceImplement implements MMAService {
	
	@Autowired
	FighterRepository FR;
	@Autowired
	StyleRepository SR;
	
	public MMAFighter createFighter(String name, double wins, String style) {
		Style s=SR.findByName(style);
		if(s==null){
		s=new Style();
		s.setName(style);
		SR.save(s);
		}
		MMAFighter m=new MMAFighter();
		m.setName(name);
		m.setStyle(s);
		m.setWins(wins);
		FR.save(m);
		return m;
	}

	public void killFighterByID(long id) {
		FR.delete(id);

	}
	public void killFighterByName(String name){
		MMAFighter m=FR.findByName(name);
		FR.delete(m);
	}
	
	public void killAll() {
		FR.deleteAll();
	}

	public boolean isThereName(String name) {
		MMAFighter m=FR.findByName(name);
		return m!=null;
	}

	public List<MMAFighter> findByStyle(String styleName) {
		Style style=SR.findByName(styleName);
		return style!=null?style.getFighters():null;
	}

	public void clearStyles() {
		SR.deleteAll();
		
	}
}
