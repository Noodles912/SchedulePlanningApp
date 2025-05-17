package com.example.test;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.component.UI;

import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

@Route(value = "Page13")

//Attendance
public class Find extends VerticalLayout{

	 ArrayList <Profile> profiles = new ArrayList<Profile>();
	
	public Find(@Autowired GreetService service) {
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

		TextField searchName = new TextField();
		searchName.setLabel("Search by Initials");
		searchName.setClearButtonVisible(true);
		
		NumberField searchID = new NumberField();
		searchID.setLabel("Search by studentID");
		searchID.setWidth("180px");
		searchID.setClearButtonVisible(true);
		
    	VerticalLayout slot1 = new VerticalLayout(searchName);
    	VerticalLayout slot2 = new VerticalLayout(searchID);
    	
		Button nameSearch = new Button("Search by Initials");
		nameSearch.addThemeVariants(ButtonVariant.LUMO_LARGE);
	    nameSearch.addClickListener(clickEvent -> {
	    	
	    	//for loop (linear search comparing condition with each index
			for(int i = 0; i < profiles.size();i++) {
				if(profiles.get(i).getInitials().equals(searchName.getValue())) {
					H4 spot = new H4(profiles.get(i).toString());
					slot1.add(spot);
					nameSearch.setEnabled(false);
				}
			}
	});
	    
		Button IDSearch = new Button("Search by Student ID");
		IDSearch.addThemeVariants(ButtonVariant.LUMO_LARGE);
	    IDSearch.addClickListener(clickEvent -> {
			for(int i = 0; i < profiles.size();i++) {
				if(profiles.get(i).getID()==searchID.getValue()) {
					H4 spot1 = new H4(profiles.get(i).toString());
					slot2.add(spot1);
					IDSearch.setEnabled(false);
					break;
				}
			}
	});

		Button back = new Button("Quit");
		back.addThemeVariants(ButtonVariant.LUMO_LARGE);
	    back.addClickListener(clickEvent -> {
	    	UI.getCurrent().navigate("Page2");
	    	
	});
	    
    	HorizontalLayout hlay = new HorizontalLayout(nameSearch, IDSearch, back);
    	HorizontalLayout hlay2 = new HorizontalLayout(slot1, slot2);
	    VerticalLayout Vlay = new VerticalLayout(hlay,hlay2);
	    Vlay.setDefaultHorizontalComponentAlignment(Alignment.CENTER);
	    add(Vlay);
	}
}
