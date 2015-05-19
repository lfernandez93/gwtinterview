package com.luis.gwtinterview.client.application.home;

import javax.inject.Inject;

import com.gargoylesoftware.htmlunit.javascript.host.html.HTMLListElement;
import com.google.gwt.dom.client.HeadingElement;
import com.google.gwt.dom.client.LIElement;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RichTextArea;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;
import com.luis.gwtinterview.client.application.hobbies.HobbiesPresenter;
import com.luis.gwtinterview.client.utils.Configuration;

class HomePageView extends ViewImpl implements HomePagePresenter.MyView {
    interface Binder extends UiBinder<Widget, HomePageView> {
    }
    
    @Inject
    HobbiesPresenter hobbiesPresenter;
    
    @UiField
    HeadingElement devName;
    @UiField
    Anchor hobby1;
    @UiField
    Anchor hobby2;
    @UiField 
    Anchor homeMenu;
    @UiField
    Anchor reset;
    @UiField
    HTMLPanel content;
    
    @Inject
    HomePageView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
        initializeUI();
    }
    
    private void initializeUI(){
    	devName.setId("devName");
    	devName.setInnerText(Configuration.DEV_NAME);
    	hobby1.setText(Configuration.HOBBY1);
    	hobby2.setText(Configuration.HOBBY2);
    	homeMenu.setText("Home");
    	reset.setText("Reset");
    	
    }

	@Override
	public void setInSlot(Object slot, IsWidget content) {
		if (slot == HomePagePresenter.SLOT_mainContentSlot) {
			this.content.clear();
			if (content != null) {
				this.content.add(content);
			}
		} else {
			super.setInSlot(slot, content);
		}

	}
	
    @Override
	public Anchor getFirstHobby() {
		// TODO Auto-generated method stub
		return hobby1;
	}
	
	@Override
	public Anchor getSecondHobby() {
		// TODO Auto-generated method stub
		return hobby2;
	}

	@Override
	public Anchor getHome() {
		// TODO Auto-generated method stub
		return homeMenu;
	}

	@Override
	public Anchor getReset() {
		// TODO Auto-generated method stub
		return reset;
	}
}