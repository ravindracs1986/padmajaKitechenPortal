package com.padmaja.kitchen.controller;

import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

import com.padmaja.kitchen.configuration.ConfigConstants;
import com.padmaja.kitchen.googleapi.model.GoogleApiResponse;
import com.padmaja.kitchen.persist.entity.VideoDetails;
import com.padmaja.kitchen.service.BlogDetailsService;
import com.padmaja.kitchen.service.HomeVideoService;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class YouTubeSchedularController {
	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired BlogDetailsService blogDetailsService;
	@Autowired HomeVideoService homeVideoService;
	@Autowired private Environment environment;
	//part=snippet,contentDetails,statistics
	//https://www.googleapis.com/youtube/v3/videos?id=Db3tAbE5IBc&part=snippet%2CcontentDetails%2Cstatistics%20&key=AIzaSyD-b8Rs9pichKOTlRcZ2AoinomFWR7thh0
	//https://www.googleapis.com/youtube/v3/videos?id=hQm9E53_NOo&part=statistics%20&key=AIzaSyD-b8Rs9pichKOTlRcZ2AoinomFWR7thh0
	//https://www.googleapis.com/youtube/v3/videos?id=hQm9E53_NOo,Db3tAbE5IBc&part=statistics%20&key=AIzaSyD-b8Rs9pichKOTlRcZ2AoinomFWR7thh0
	
	/*@Value("${" + ConfigConstants.CRON_JOB_SCHEDULER + "}")
	private String cronTime;*/
	 
	   @Scheduled(cron = "${batch.job.schedular}")//Fires every 20 seconds
	 //@Scheduled(cron = "0 0 12 * * ?")//Fires at 12 PM every day:
	    public void updateLikeViewComments() {
	        System.out.println("I am called by Spring scheduler ");
	        String day1=environment.getRequiredProperty("day1");
	        String day2=environment.getRequiredProperty("day2");
	        System.out.println("days ,day1--> "+day1+"day2-->"+day2);
	        //http://demo7563629.mockable.io/getYoutubeDetails
	        List<VideoDetails> results= homeVideoService.findVideoForYouTubeUpdate(Integer.parseInt(day1),Integer.parseInt(day2));
	        for (VideoDetails videoDetails : results) {
	        	 System.out.println("youtube Id==>>"+videoDetails.getYoutubeId());
			}
	        String uri = "http://demo7563629.mockable.io/getYoutubeDetails";
	        
	        RestTemplate restTemplate = new RestTemplate();
	        String result = restTemplate.getForObject(uri, String.class);
	         if(result!=null){
	        	 ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	        	
	        	 try {
					GoogleApiResponse gogleResp= mapper.readValue(result, GoogleApiResponse.class);
					 System.out.println("google id::"+gogleResp.getItems().get(0).getId());
				} catch (JsonParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (JsonMappingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	         }
	       
	        
	        
	    }


}
