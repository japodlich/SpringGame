package josh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import josh.beans.Games;

@Repository
public interface GamesRepository extends JpaRepository<Games, Long> { }

	
	
	

