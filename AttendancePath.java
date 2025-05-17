package com.example.test;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.component.UI;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

@Route(value = "Page2")

//Attendance
public class AttendancePath extends VerticalLayout{

	 ArrayList <Profile> profiles = new ArrayList<Profile>();
	
	
	public AttendancePath(@Autowired GreetService service) {

		Button defaultSort = new Button("Generate Attendance by default");
		defaultSort.addThemeVariants(ButtonVariant.LUMO_LARGE);
	    defaultSort.addClickListener(clickEvent -> {
	    	UI.getCurrent().navigate("Page9");
	});
		Button alphaSort = new Button("Generate Attendance in Alphabetical Order");
		alphaSort.addThemeVariants(ButtonVariant.LUMO_LARGE);
	    alphaSort.addClickListener(clickEvent -> {
	    	UI.getCurrent().navigate("Page10");
	});
		Button numberSort = new Button("Generate Attendance in Student Number Order");
		numberSort.addThemeVariants(ButtonVariant.LUMO_LARGE);
	    numberSort.addClickListener(clickEvent -> {
	    	UI.getCurrent().navigate("Page11");
	});
		Button scoreSort = new Button("Generate Attendance in Score Order");
		scoreSort.addThemeVariants(ButtonVariant.LUMO_LARGE);
	    scoreSort.addClickListener(clickEvent -> {
	    	UI.getCurrent().navigate("Page12");
	});
		Button find = new Button("Find a certain profile");
		find.addThemeVariants(ButtonVariant.LUMO_LARGE);
	    find.addClickListener(clickEvent -> {
	    	UI.getCurrent().navigate("Page13");
	});
	    
		Button back = new Button("Quit");
		back.addThemeVariants(ButtonVariant.LUMO_LARGE);
	    back.addClickListener(clickEvent -> {
	    	UI.getCurrent().navigate("Page1");
	    	
	});
    	Image image = new Image("Images/Generate.png","Title");
    	HorizontalLayout hlay = new HorizontalLayout(defaultSort, find);
    	HorizontalLayout hlay2 = new HorizontalLayout(alphaSort, numberSort, scoreSort);
	    VerticalLayout Vlay = new VerticalLayout(hlay,hlay2, image, back);
	    
	    Vlay.setDefaultHorizontalComponentAlignment(Alignment.CENTER);
	    add(Vlay);
	}
}
