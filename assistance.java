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
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.orderedlayout.VerticalLayout; 
import com.vaadin.flow.router.Route;

@Route(value = "Page5")
public class assistance extends VerticalLayout {
	
	ArrayList<Profile> profiles = new ArrayList<Profile>();
	
	public assistance(@Autowired GreetService service) {
	H4 message = new H4("These Students Would Like Assistance");
	Scanner s1 = null;
    try {
    	s1 = new Scanner(new File("RequestList.txt"));
    } 
    catch (FileNotFoundException e) {
    	System.out.println("ok");

    }
	while (s1.hasNextLine()) { 
		
    	int studentID = Integer.parseInt(s1.nextLine());
    	String initials = s1.nextLine();
    	double score = Double.parseDouble(s1.nextLine());
    	String request = s1.nextLine();
    	
    	//if star count matches, accept. Otherwise reject
    	if(request.equals("*")) {
    	Profile you = new Profile(studentID, initials, score, request);
    	profiles.add(you);
    	}
	}	

	//Grid displays all players requesting assistance
	Grid <Profile> grid = new Grid <>(Profile.class, false);
	grid.addColumn(Profile::getID).setHeader("Student ID");
	grid.addColumn(Profile::getInitials).setHeader("Sudent Initials");
	grid.addColumn(Profile::getScore).setHeader("Score");
	grid.setSelectionMode(Grid.SelectionMode.MULTI);
	grid.setItems(profiles);  	

	Button back = new Button("Back");
	back.addThemeVariants(ButtonVariant.LUMO_LARGE);
    back.addClickListener(clickEvent -> {
    	UI.getCurrent().navigate("Page4");
	});
    VerticalLayout Vlay = new VerticalLayout(message, grid, back);
    Vlay.setDefaultHorizontalComponentAlignment(Alignment.CENTER);
    add(Vlay);
	}
}
