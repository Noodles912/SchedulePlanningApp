package com.example.test;


import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.UI;

import org.springframework.beans.factory.annotation.Autowired;

@Route(value = "Page1")

public class MainView extends VerticalLayout{


	public MainView(@Autowired GreetService service) {
		 
	H3 message = new H3("Please select an option!");
	Image attendanceImage = new Image("Images/Attendance.png","Attendance Button");
	Image tournamentImage = new Image("Images/Tournament.png","Tournament Button");
	Image requestImage = new Image("Images/Request.png","Request Button");
    attendanceImage.setWidth("175px");
    tournamentImage.setWidth("175px");
    requestImage.setWidth("175px");
        
	Button AttendanceButton = new Button("Attendance");
	AttendanceButton.addThemeVariants(ButtonVariant.LUMO_LARGE);
	AttendanceButton.setWidth("10em");
    AttendanceButton.addClickListener(clickEvent -> {
        UI.getCurrent().navigate("Page2");
});
	Button TournamentButton = new Button("Tournaments");
	TournamentButton.addThemeVariants(ButtonVariant.LUMO_LARGE);
	TournamentButton.setWidth("10em");
    TournamentButton.addClickListener(clickEvent -> {
        UI.getCurrent().navigate("Page3");
});
	Button RequestsButton = new Button("Requests");
	RequestsButton.addThemeVariants(ButtonVariant.LUMO_LARGE);
	RequestsButton.setWidth("10em");
    RequestsButton.addClickListener(clickEvent -> {
        UI.getCurrent().navigate("Page4");
});
	Button QuitButton = new Button("Sign Off");
	QuitButton.addThemeVariants(ButtonVariant.LUMO_LARGE);
    QuitButton.addClickListener(clickEvent -> {
    	UI.getCurrent().navigate("");

});
    //horizontal layout of images only
    HorizontalLayout images = new HorizontalLayout(attendanceImage, tournamentImage, requestImage);
    images.setDefaultVerticalComponentAlignment(Alignment.END);

    //horizontal layout of buttons only
    HorizontalLayout horizontalLayout = new HorizontalLayout();
    horizontalLayout.setJustifyContentMode(FlexComponent.JustifyContentMode.BETWEEN);
	horizontalLayout.add(AttendanceButton,TournamentButton,RequestsButton,QuitButton);
    HorizontalLayout horizontalLayout2 = new HorizontalLayout(QuitButton);
    
    //vertical layout with horizontal layouts
    VerticalLayout Vlay = new VerticalLayout(message,images, horizontalLayout, horizontalLayout2);
    Vlay.setDefaultHorizontalComponentAlignment(Alignment.CENTER);
    add(Vlay);
 
    
    
    
	} 	 
}

