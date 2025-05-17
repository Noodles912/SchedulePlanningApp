package com.example.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route(value = "Page7")
public class tournament extends VerticalLayout{
	

	ArrayList<Profile>profiles = new ArrayList<Profile>();
	ArrayList<Profile> slot1 = new ArrayList<Profile>();
	ArrayList<Profile> slot2 = new ArrayList<Profile>();
	
	public tournament(@Autowired GreetService service) {
	H3 sign = new H3(" VS ");
	H4 message = new H4("Here Are The Participants For The Current Round:");
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
	
	// calculating logarithm to ensure enough players
	if(Math.log(profiles.size())/Math.log(2) == (int)(Math.log(profiles.size())/Math.log(2))) {
		int matches = profiles.size()/2;
	
		for(int i = 0; i < matches; i++) {
			//calculate random integer, store value, remove from ArrayList
			int int1 = 0 + (int)(Math.random() * ((profiles.size() - 1) + 1));
			slot1.add(profiles.get(int1));
			profiles.remove(int1);
			
			//calculate random integer, store value, remove from ArrayList
			int1 = 0 + (int)(Math.random() * ((profiles.size() - 1) + 1));
			slot2.add(profiles.get(int1));
			profiles.remove(int1);
			}
		}
	
	//outputs all slot1 players
	Grid <Profile> grid = new Grid <>(Profile.class, false);
	grid.setSelectionMode(Grid.SelectionMode.MULTI);
	grid.addColumn(Profile::getID).setHeader("Student ID");
	grid.addColumn(Profile::getInitials).setHeader("Sudent Initials");
	grid.addColumn(Profile::getScore).setHeader("Score");
	grid.setWidth("650px");
	grid.setItems(slot1);  	
	
	//outputs all slot2 players
	Grid <Profile> grid2 = new Grid <>(Profile.class, false);
	grid2.addColumn(Profile::getID).setHeader("Student ID");
	grid2.addColumn(Profile::getInitials).setHeader("Sudent Initials");
	grid2.addColumn(Profile::getScore).setHeader("Score");
	grid2.setWidth("650px");
	grid2.setItems(slot2);  
	
	HorizontalLayout Hlayout = new HorizontalLayout(grid, sign, grid2);
	add(Hlayout);
	Button back = new Button("Quit");
	back.addThemeVariants(ButtonVariant.LUMO_LARGE);
    back.addClickListener(clickEvent -> {
    	UI.getCurrent().navigate("Page3");
});

    VerticalLayout Vlay = new VerticalLayout(message, Hlayout, back);
    Vlay.setDefaultHorizontalComponentAlignment(Alignment.CENTER);
    add(Vlay);

	
	}	
}
