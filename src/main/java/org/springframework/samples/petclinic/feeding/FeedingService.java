package org.springframework.samples.petclinic.feeding;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class FeedingService {
	@Autowired
	private FeedingRepository fR;
    public List<Feeding> getAll(){
        return fR.findAll();
    }

    public List<FeedingType> getAllFeedingTypes(){
        return null;
    }

    public FeedingType getFeedingType(String typeName) {
        return fR.getFeedingType(typeName);
    }

    public Feeding save(Feeding p) throws UnfeasibleFeedingException {
    	if(p.getPet()!= fR.findById(p.getId()).get().getPet()||p.getId()==null) {
    		
    		throw new UnfeasibleFeedingException();
    	}
    	Feeding test = fR.save(p);
    	
        return test;       
    }

    
}
