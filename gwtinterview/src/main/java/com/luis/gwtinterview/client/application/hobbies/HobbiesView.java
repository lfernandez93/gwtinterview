package com.luis.gwtinterview.client.application.hobbies;

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

class HobbiesView extends ViewImpl implements HobbiesPresenter.MyView {
    interface Binder extends UiBinder<Widget, HobbiesView> {
    }

    @UiField
    FlexTable hobbies;
    @UiField
    VerticalPanel hobbiesPanel;
    Label firstHobbyLbl;
    Label secondHobbyLbl;
    private final Image firstHobbyImage = new Image();
    private final Image secondHobbyImage = new Image();
    @Inject
    HobbiesView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
        initializeUI();
    }

    private void initializeUI(){
    	 firstHobbyLbl = new Label(Configuration.HOBBY1);
    	 secondHobbyLbl = new Label(Configuration.HOBBY2);
    	
    	RichTextArea hobby1Desc = new RichTextArea();
    	hobby1Desc.setText(Configuration.HOBBY1_DESCRIPTION);
    	hobby1Desc.setSize("170px", "130px");
    	hobby1Desc.setEnabled(false);
    	RichTextArea hobby2Desc = new RichTextArea();
    	hobby2Desc.setText(Configuration.HOBBY2_DESCRIPTION);
    	hobby2Desc.setSize("170px", "130px");
    	hobby2Desc.setEnabled(false);
    	
    	firstHobbyImage.setPixelSize(200, 200);
    	firstHobbyImage.setUrl(Configuration.HOBBY1_IMAGE);
    	secondHobbyImage.setPixelSize(200, 200);
    	secondHobbyImage.setUrl(Configuration.HOBBY2_IMAGE);
    	
    	hobbies.setWidget(0, 0, firstHobbyImage);
		hobbies.getFlexCellFormatter().setRowSpan(0, 0, 2);
		VerticalPanel panelFirstHobby = new VerticalPanel();
		panelFirstHobby.add(firstHobbyLbl);
		panelFirstHobby.add(hobby1Desc);
		hobbies.setWidget(0, 1, panelFirstHobby);
		hobbies.getFlexCellFormatter().setRowSpan(0, 1, 2);
		
		hobbies.getFlexCellFormatter().setRowSpan(0, 2, 2);
		
		VerticalPanel panelSecondHobby = new VerticalPanel();

		hobbies.setWidget(0, 3, secondHobbyImage);
		hobbies.getFlexCellFormatter().setRowSpan(0, 3, 2);
		panelSecondHobby.add(secondHobbyLbl);
		panelSecondHobby.add(hobby2Desc);
		hobbies.setWidget(0, 4, panelSecondHobby);
		hobbies.getFlexCellFormatter().setRowSpan(0, 4, 2);
		
    }

	@Override
	public Label getFirstHobbyLbl() {
		// TODO Auto-generated method stub
		return firstHobbyLbl;
	}

	@Override
	public Label getSecondHobbyLbl() {
		// TODO Auto-generated method stub
		return secondHobbyLbl;
	}
}