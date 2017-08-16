package com.makartara.data;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "style")
public class Style {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id",nullable = false)
    private long id;
	
	@Column(name = "name")
    private String name;
	
	@OneToMany(mappedBy = "style")
	 private List<MMAFighter> fighters;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<MMAFighter> getFighters() {
		return fighters;
	}

	public void setFighters(List<MMAFighter> fighters) {
		this.fighters = fighters;
	}
}
