package com.makartara.data;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StyleRepository extends JpaRepository<Style, Long> {
	Style findByName(String name);
}
