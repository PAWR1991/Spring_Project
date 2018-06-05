package com.springIntro.displayDate.controllers;
import java.util.GregorianCalendar;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HomeController {

	SimpleDateFormat time = new SimpleDateFormat("HH:mm:ss");
	SimpleDateFormat date = new SimpleDateFormat("yyyy MMM dd");
	Calendar calendar = new GregorianCalendar();
	
	@RequestMapping("/")
	  public String index() {
		return "index";
    }
	
	@RequestMapping("/date")
	public String date(Model model) {
		
		System.out.println(date);
		model.addAttribute("date", date.format(calendar.getTime()));
		return"date";
	}
	
	@RequestMapping("/time")
	public String time(Model model) {
		
		model.addAttribute("date", time.format(calendar.getTime()));
		return "time";
	}
	
}