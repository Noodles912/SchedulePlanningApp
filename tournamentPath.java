package com.example.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.H3;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route(value = "Page3")


public class tournamentPath extends VerticalLayout{
	ArrayList<Profile>profiles = new ArrayList<Profile>();
	
	public tournamentPath(@Autowired GreetService service) {
	VerticalLayout single = new VerticalLayout();
	VerticalLayout pair = new VerticalLayout();
	HorizontalLayout parts = new HorizontalLayout(single, pair);
	H2 title = new H2("Press a Button to Perform Action");
	H3 title1 = new H3("- Found opponent - - - - - - - - - - - - - - -"
			+ " - - - - - - - - - - - - - - - - - - - - - - - -"
			+ " - - - - - - - - - - - - - - - - - - - - - - - - - -");
	H3 title2 = new H3("Single Match - - - - - - - -");
	HorizontalLayout Titles = new HorizontalLayout(title1,title2);
	single.setWidth("1000px");
	pair.setWidth("800px");

		
	Button opponent1 = new Button("Find Opponent");
	opponent1.addThemeVariants(ButtonVariant.LUMO_LARGE);
	opponent1.addClickListener(clickEvent -> {
		
		 //file reading method
		finder();
		
		//calculate random integer, store value, remove from ArrayList
		int int1 = 0 + (int)(Math.random() * ((profiles.size() - 1) + 1));
		Profile placehold1 = profiles.get(int1);
		H3 message = new H3(placehold1.toString());
		single.add(message);
});
	Button match = new Button("Create Single Match");
	 match.addThemeVariants(ButtonVariant.LUMO_LARGE);
	 match.addClickListener(clickEvent -> {
		 
		 //file reading method
		finder();
		
		//calculate random integer, store value, remove from ArrayList
		int int1 = 0 + (int)(Math.random() * ((profiles.size() - 1) + 1));
		Profile placehold1 = profiles.get(int1);
		profiles.remove(int1);
		
		//calculate random integer, store value, remove from ArrayList
		int1 = 0 + (int)(Math.random() * ((profiles.size() - 1) + 1));
		Profile placehold2 = profiles.get(int1);
		profiles.remove(int1);
		H3 message2 = new H3(placehold1.toString()+"   vs   "+placehold2.toString());
		pair.add(message2);
});
	Button tournament = new Button("Create Tournament");
	tournament.addThemeVariants(ButtonVariant.LUMO_LARGE);
	tournament.addClickListener(clickEvent -> {
		UI.getCurrent().navigate("Page7");
});
	Button RoundRobin = new Button("Make Round Robin");
	RoundRobin.addThemeVariants(ButtonVariant.LUMO_LARGE);
	RoundRobin.addClickListener(clickEvent -> {
    	UI.getCurrent().navigate("Page8");
});
	
	Button back = new Button("Quit");
	back.addThemeVariants(ButtonVariant.LUMO_LARGE);
    back.addClickListener(clickEvent -> {
    	UI.getCurrent().navigate("Page1");
});

    HorizontalLayout hlay = new HorizontalLayout(opponent1, match, tournament, RoundRobin, back);
    HorizontalLayout h = new HorizontalLayout(title);
    add(h);
    add(hlay);
	add(Titles);
    add(parts);
	}
	
	public void finder() {
		Scanner s1 = null;
		int studentID;
		String initials;
		double score;
		Profile you = null;
	    try {
	    s1 = new Scanner(new File("TournamentParticipants.txt"));
	    } 
	    catch (FileNotFoundException e) {
	      System.out.println("ok");
	      //System.exit(0);
	    }
		while (s1.hasNextLine()) {
			studentID = Integer.parseInt(s1.nextLine());
	    	initials = s1.nextLine();
	    	score = Double.parseDouble(s1.nextLine());
			you = new Profile(studentID, initials, score);
			profiles.add(you);
		}
	}	
}
