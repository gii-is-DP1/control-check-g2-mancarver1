package org.springframework.samples.petclinic.feeding;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface FeedingRepository extends CrudRepository<Feeding, Integer>{
    
	 @Query("SELECT p FROM FeedingType p")
    List<FeedingType> findAllFeedingTypes();
	 @Query("SELECT p FROM Feeding p")
	    List<Feeding> findAll();
	 
	 @Query("SELECT p FROM FeedingType p WHERE p.name =:typeName")
	   public FeedingType getFeedingType(@Param("typeName") String typeName);
		 
    Optional<Feeding> findById(int id);
   // Feeding save(Feeding p);
}
