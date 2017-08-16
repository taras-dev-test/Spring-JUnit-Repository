package com.makartara.data;

import javax.persistence.*;

@Entity
@Table(name="fighter")
public class MMAFighter {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id",nullable = false)
    private long id;
 
    @Column(name = "wins")
    private double wins;
 
    @Column(name = "name")
    private String name;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "style_id",nullable=true)
    private Style style;

	public double getWins() {
		return wins;
	}

	public void setWins(double wins) {
		this.wins = wins;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Style getStyle() {
		return style;
	}

	public void setStyle(Style style) {
		this.style = style;
	}
    
    
}
