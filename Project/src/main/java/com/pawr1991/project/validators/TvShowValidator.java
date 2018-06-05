package com.pawr1991.project.validators;

import java.util.List;

import org.springframework.stereotype.Component;

import com.pawr1991.project.models.TvShow;
import com.pawr1991.project.services.TvShowService;

@Component
public class TvShowValidator {
	private TvShowService tvService;
	
	public TvShowValidator(TvShowService tvService) {
		this.tvService = tvService;
	}
	
	public Boolean isUnique(TvShow tvShow) {
		
		List<TvShow> checkTitle = this.tvService.findAllByTitle(tvShow.getTitle());
		
		for(TvShow rev: checkTitle) {
			return false;
//    		if (rev.getNetwork().equals(tvShow.getNetwork())) {
//    			return false;
//    		}
    	}
		
		return true;
	}
}
