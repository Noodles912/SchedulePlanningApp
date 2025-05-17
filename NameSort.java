package com.example.test;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H2;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.FileNotFoundException;

@Route(value = "Page10")

//Attendance
public class NameSort extends VerticalLayout{

	 ArrayList <Profile> profiles = new ArrayList<Profile>();
	
	
	public NameSort(@Autowired GreetService service) {
		
			H2 message = new H2("Here is Your Attendance");


			Scanner s1 = null;
			int studentID;
			String initials;
			double score;
			Profile you = null;
		    try {
		    s1 = new Scanner(new File("ChessAttendance.txt"));
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
			
			//nested for loop (bubble sort)
			for(int i = 0; i<profiles.size();i++) {
				for (int j = i + 1; j < profiles.size(); j++) { 
	                if (profiles.get(i).getInitials().compareTo(profiles.get(j).getInitials()) > 0) {
	                    Profile temp = profiles.get(i);
	                    profiles.set(i,profiles.get(j));
	                    profiles.set(j,temp);
	                }
				}
			}
			Grid <Profile> grid = new Grid <>(Profile.class, false);
	    	grid.addColumn(Profile::getID).setHeader("Student ID");
	    	grid.addColumn(Profile::getInitials).setHeader("Sudent Initials");
	    	grid.addColumn(Profile::getScore).setHeader("Score");
	    	grid.setSelectionMode(Grid.SelectionMode.MULTI);
	    	grid.setItems(profiles);  	
	    	add(grid);
	

		Button back = new Button("Quit");
		back.addThemeVariants(ButtonVariant.LUMO_LARGE);
	    back.addClickListener(clickEvent -> {
	    	UI.getCurrent().navigate("Page2");
	    	
	});
	    VerticalLayout Vlay = new VerticalLayout(message, grid, back);
	    Vlay.setDefaultHorizontalComponentAlignment(Alignment.CENTER);
	    add(Vlay);
	}
}
