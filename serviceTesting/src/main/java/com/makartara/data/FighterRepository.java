package com.makartara.data;


import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface FighterRepository extends JpaRepository<MMAFighter, Long> {
	MMAFighter findByName(String name);
	
}
