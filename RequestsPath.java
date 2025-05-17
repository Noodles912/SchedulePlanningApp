package com.example.test;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route(value = "Page4")
public class RequestsPath extends VerticalLayout{
	ArrayList<Profile> profiles = new ArrayList<Profile>();
	
	public RequestsPath(@Autowired GreetService service) {
	H3 message = new H3("Please select an option!");
	Image assistanceImage = new Image("Images/Assistance.png","Attendance Button");
	Image invitationImage = new Image("Images/Invitation.png","Tournament Button");
	assistanceImage.setWidth("310px");
	assistanceImage.setHeight("300px");
	invitationImage.setWidth("300px");
	invitationImage.setHeight("300px");
	
	Button assistance = new Button("Generate Assistance Table");
	assistance.addThemeVariants(ButtonVariant.LUMO_LARGE);
    assistance.addClickListener(clickEvent -> {
    	UI.getCurrent().navigate("Page5");

    	
});
	Button invitation = new Button("Generate Invitation Table");
	invitation.addThemeVariants(ButtonVariant.LUMO_LARGE);
	invitation.addClickListener(clickEvent -> {
		UI.getCurrent().navigate("Page6");

});
	Button back = new Button("Quit");
	back.addThemeVariants(ButtonVariant.LUMO_LARGE);
    back.addClickListener(clickEvent -> {
    	UI.getCurrent().navigate("Page1");
});
    HorizontalLayout images = new HorizontalLayout(assistanceImage, invitationImage);
    HorizontalLayout main = new HorizontalLayout(assistance, invitation);
    VerticalLayout Vlay = new VerticalLayout(message, images, main, back);
    Vlay.setDefaultHorizontalComponentAlignment(Alignment.CENTER);
    add(Vlay);
	}
}
