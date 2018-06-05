package com.springFund.ninjaGold.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Random;

@Controller
public class NinjaGoldControllers {
	@RequestMapping("")
	public String index(HttpSession session) {
		
		Integer gold = (Integer) session.getAttribute("gold");
		if (gold == null) {
			gold = 0;
			session.setAttribute("gold", gold);
		}
//		System.out.println(gold);
		return "index";
	}
	
	@PostMapping("makeGold")
	public String makeGold(HttpSession session, @RequestParam(value="action") String action) {
//		System.out.println(action);
		ArrayList<String> activaties = (ArrayList<String>) session.getAttribute("activaties");
		if (activaties == null) {
			activaties = new ArrayList<String>();
		}
		Random rand = new Random();
		Integer gold = (Integer) session.getAttribute("gold");
		Integer n;
		if (action.equals("farm")) {
			n = rand.nextInt(10)+10;
			gold += n;
			activaties.add("You have earn "+ n +" gold from farming");
			System.out.println(gold);
			System.out.println(activaties);
		}
		else if (action.equals("cave")) {
			n = rand.nextInt(5)+5;
			gold += n;
			activaties.add("You have earn "+ n +" gold from caving");
			System.out.println(gold);
			System.out.println(activaties);
		}
		else if (action.equals("house")) {
			n = rand.nextInt(2)+3;
			gold += n;
			activaties.add("You have earn "+ n +" gold from housing");
			System.out.println(gold);
			System.out.println(activaties);
		}
		else if (action.equals("casino")) {
			n = rand.nextInt(100)-50;
			gold += n;
			if (n>=0) {
				activaties.add("You have earn "+ n +" gold from the casino");
			}
			else {
				activaties.add("You have loss "+ n +" gold from the casino");
			}
			
			System.out.println(gold);
			System.out.println(activaties);
		}
		session.setAttribute("gold", gold);
		session.setAttribute("activaties", activaties);
		return "redirect:/";
	}

}
