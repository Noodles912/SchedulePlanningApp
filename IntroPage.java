package com.example.test;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.PWA;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.UI;

import org.springframework.beans.factory.annotation.Autowired;



@Route(value = "")

@PWA(name = "Vaadin Application",
        shortName = "Vaadin App",
        description = "This is an example Vaadin application.",
        enableInstallPrompt = false)
@CssImport("./styles/shared-styles.css")
@CssImport(value = "./styles/vaadin-text-field-styles.css", themeFor = "vaadin-text-field")
public class IntroPage extends VerticalLayout {


    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public IntroPage(@Autowired GreetService service) {
    	H2 greet = new H2 ("CHESS CLUB MANAGER");
    	
    	Button button = new Button("Press to Start");
        button.addClickListener(clickEvent -> {
        UI.getCurrent().navigate("Page1");

    });
        HorizontalLayout horizontalLayout = new HorizontalLayout(button);
        horizontalLayout.setAlignItems(FlexComponent.Alignment.CENTER);
        add(horizontalLayout);
        
    	Image image = new Image("Images/Title.png","Title");
    	image.setWidth("500px");       
    	VerticalLayout Vlay = new VerticalLayout(greet, image, horizontalLayout);
        Vlay.setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        add(Vlay);
        
    }
    
}
