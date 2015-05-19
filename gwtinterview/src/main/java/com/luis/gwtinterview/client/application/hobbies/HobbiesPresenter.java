package com.luis.gwtinterview.client.application.hobbies;

import javax.inject.Inject;

import com.google.gwt.dom.client.Style.Cursor;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.GwtEvent.Type;
import com.google.gwt.user.client.ui.Label;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.ContentSlot;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.Proxy;
import com.gwtplatform.mvp.client.proxy.RevealContentHandler;
import com.luis.gwtinterview.client.application.hobby1.FirstHobbyPresenter;
import com.luis.gwtinterview.client.application.hobby2.SecondHobbyPresenter;
import com.luis.gwtinterview.client.application.home.HomePagePresenter;

public class HobbiesPresenter extends Presenter<HobbiesPresenter.MyView, HobbiesPresenter.MyProxy> {
    public interface MyView extends View {
    	public Label getFirstHobbyLbl();
    	public Label getSecondHobbyLbl();
    }

    @ContentSlot
    public static final Type<RevealContentHandler<?>> SLOT_SetMainContent = new Type<>();

    @ProxyStandard
    interface MyProxy extends Proxy<HobbiesPresenter> {
    }

    @Inject
    HobbiesPresenter(EventBus eventBus,
                         MyView view,
                         MyProxy proxy) {
        super(eventBus, view, proxy, RevealType.Root);
    }
    
    @Override
    protected void onBind() {
    	// TODO Auto-generated method stub
    	getView().getFirstHobbyLbl().getElement().getStyle().setCursor(Cursor.POINTER);
    	getView().getSecondHobbyLbl().getElement().getStyle().setCursor(Cursor.POINTER);
    	
    }
    

    

}