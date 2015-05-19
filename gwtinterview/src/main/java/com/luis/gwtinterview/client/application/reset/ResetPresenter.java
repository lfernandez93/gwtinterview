package com.luis.gwtinterview.client.application.reset;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.inject.Inject;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.GwtEvent.Type;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.datepicker.client.DatePicker;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.ContentSlot;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.Proxy;
import com.gwtplatform.mvp.client.proxy.RevealContentHandler;

public class ResetPresenter extends Presenter<ResetPresenter.MyView, ResetPresenter.MyProxy> {
    interface MyView extends View {
    	public Button getResetButton();
    	public DatePicker getDatePicker();
    	public TextBox getTextBox();
    }
    Logger logger = Logger.getLogger(getClass().getName());
    @ContentSlot
    public static final Type<RevealContentHandler<?>> SLOT_SetMainContent = new Type<>();

    @ProxyStandard
    interface MyProxy extends Proxy<ResetPresenter> {
    }

    @Inject
    ResetPresenter(EventBus eventBus,
                         MyView view,
                         MyProxy proxy) {
        super(eventBus, view, proxy, RevealType.Root);
        buildEvents();
    }
    
    private void buildEvents(){
    	getView().getResetButton().addClickHandler(new onResetPressed());
    }
    
    private class onResetPressed implements ClickHandler{

		@Override
		public void onClick(ClickEvent event) {
			// TODO Auto-generated method stub
			String textbox = getView().getTextBox().getText();
			Date date = getView().getDatePicker().getValue();
			logger.log(Level.SEVERE, "Logging Data= "+textbox+" Date="+date.toString());
		}
    	
    }
}