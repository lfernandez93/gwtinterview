package com.luis.gwtinterview.client.application.hobby1;

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

class FirstHobbyView extends ViewImpl implements FirstHobbyPresenter.MyView {
    interface Binder extends UiBinder<Widget, FirstHobbyView> {
    }

    @UiField
    FlexTable hobbies;
    @UiField
    VerticalPanel hobbiesPanel;
    
    private final Image firstHobbyImage = new Image();
    @Inject
    FirstHobbyView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
        initializeUI();
    }

    private void initializeUI(){
    	Label firstHobbyLbl = new Label(Configuration.HOBBY1);
    	
    	RichTextArea hobby1Desc = new RichTextArea();
    	hobby1Desc.setText(Configuration.HOBBY1_DESCRIPTION);
    	hobby1Desc.setSize("200px", "160px");
    	hobby1Desc.setEnabled(false);
    	
    	firstHobbyImage.setPixelSize(250, 250);
    	firstHobbyImage.setUrl(Configuration.HOBBY1_IMAGE);
    	
    	hobbies.setWidget(0, 0, firstHobbyImage);
		hobbies.getFlexCellFormatter().setRowSpan(0, 0, 2);
		VerticalPanel panelFirstHobby = new VerticalPanel();
		panelFirstHobby.add(firstHobbyLbl);
		panelFirstHobby.add(hobby1Desc);
		hobbies.setWidget(0, 1, panelFirstHobby);
		hobbies.getFlexCellFormatter().setRowSpan(0, 1, 2);
		
    }
}