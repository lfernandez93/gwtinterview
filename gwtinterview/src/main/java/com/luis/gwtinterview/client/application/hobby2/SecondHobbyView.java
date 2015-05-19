package com.luis.gwtinterview.client.application.hobby2;

import javax.inject.Inject;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RichTextArea;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;
import com.luis.gwtinterview.client.utils.Configuration;

class SecondHobbyView extends ViewImpl implements SecondHobbyPresenter.MyView {
    interface Binder extends UiBinder<Widget, SecondHobbyView> {
    }


    @UiField
    FlexTable hobbies;
    @UiField
    VerticalPanel hobbiesPanel;
    private final Image secondHobbyImage = new Image();
    @Inject
    SecondHobbyView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
        initializeUI();
    }
    
    private void initializeUI(){
    	Label secondHobbyLbl = new Label(Configuration.HOBBY2);
    	
    	RichTextArea hobby2Desc = new RichTextArea();
    	hobby2Desc.setText(Configuration.HOBBY2_DESCRIPTION);
    	hobby2Desc.setSize("200px", "160px");
    	hobby2Desc.setEnabled(false);
    	
    	secondHobbyImage.setPixelSize(250, 250);
    	secondHobbyImage.setUrl(Configuration.HOBBY2_IMAGE);
    	
    	hobbies.setWidget(0, 0, secondHobbyImage);
		hobbies.getFlexCellFormatter().setRowSpan(0, 0, 2);
		VerticalPanel panelSecondHobby = new VerticalPanel();
		panelSecondHobby.add(secondHobbyLbl);
		panelSecondHobby.add(hobby2Desc);
		hobbies.setWidget(0, 1, panelSecondHobby);
		hobbies.getFlexCellFormatter().setRowSpan(0, 1, 2);
    }


}