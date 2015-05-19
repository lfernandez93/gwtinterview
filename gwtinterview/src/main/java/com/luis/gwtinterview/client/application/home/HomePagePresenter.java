package com.luis.gwtinterview.client.application.home;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.appengine.repackaged.org.apache.commons.logging.Log;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.GwtEvent.Type;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Anchor;

import javax.inject.Inject;

import com.luis.gwtinterview.client.application.ApplicationPresenter;
import com.luis.gwtinterview.client.application.hobbies.HobbiesPresenter;
import com.luis.gwtinterview.client.application.hobby1.FirstHobbyPresenter;
import com.luis.gwtinterview.client.application.hobby2.SecondHobbyModule;
import com.luis.gwtinterview.client.application.hobby2.SecondHobbyPresenter;
import com.luis.gwtinterview.client.application.reset.ResetPresenter;
import com.luis.gwtinterview.client.place.NameTokens;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.dom.client.LIElement;
import com.google.gwt.dom.client.Style.Cursor;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.ContentSlot;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.client.proxy.RevealContentHandler;
import com.gwtplatform.mvp.client.proxy.RevealRootContentEvent;

public class HomePagePresenter extends
		Presenter<HomePagePresenter.MyView, HomePagePresenter.MyProxy> {
	@ContentSlot
	public static final Type<RevealContentHandler<?>> SLOT_mainContentSlot = new Type<RevealContentHandler<?>>();
	public Logger log = Logger.getLogger(getClass().getName());

	@Inject
	FirstHobbyPresenter firstHobbyPresenter;
	@Inject
	HobbiesPresenter hobbiesPresenter;
	@Inject
	SecondHobbyPresenter secondHobbyPresenter;
	@Inject
	ResetPresenter resetPresenter;
	
	interface MyView extends View {
		public Anchor getFirstHobby();

		public Anchor getSecondHobby();

		public Anchor getHome();

		public Anchor getReset();
	}

	@ProxyStandard
	@NameToken(NameTokens.home)
	interface MyProxy extends ProxyPlace<HomePagePresenter> {
	}

	@Override
	protected void revealInParent() {
		RevealRootContentEvent.fire(this, this);
	}

	@Inject
	HomePagePresenter(EventBus eventBus, MyView view, MyProxy proxy) {
		super(eventBus, view, proxy, ApplicationPresenter.SLOT_SetMainContent);
	}

	@Override
	protected void onBind() {
		// TODO Auto-generated method stub
		manageEvents();
	}

	private void manageEvents() {
		getView().getHome().getElement().getStyle().setCursor(Cursor.POINTER);
		getView().getFirstHobby().getElement().getStyle().setCursor(Cursor.POINTER);
		getView().getSecondHobby().getElement().getStyle().setCursor(Cursor.POINTER);
		getView().getReset().getElement().getStyle().setCursor(Cursor.POINTER);
		setInSlot(SLOT_mainContentSlot, hobbiesPresenter);
		getView().getFirstHobby().addClickHandler(new onFirstHobbyPressed());
		getView().getSecondHobby().addClickHandler(new onSecondHobbyPressed());
		getView().getHome().addClickHandler(new onHomePressed());
		getView().getReset().addClickHandler(new onResetPressed());
		hobbiesPresenter.getView().getFirstHobbyLbl().addClickHandler(new onFirstHobbyPressed());
		hobbiesPresenter.getView().getSecondHobbyLbl().addClickHandler(new onSecondHobbyPressed());
	}

	private class onFirstHobbyPressed implements ClickHandler {

		@Override
		public void onClick(ClickEvent event) {
			// TODO Auto-generated method stub
			setInSlot(SLOT_mainContentSlot, firstHobbyPresenter);

		}

	}
	
	private class onSecondHobbyPressed implements ClickHandler {

		@Override
		public void onClick(ClickEvent event) {
			// TODO Auto-generated method stub
			setInSlot(SLOT_mainContentSlot, secondHobbyPresenter);
		}

	}
	
	private class onResetPressed implements ClickHandler {

		@Override
		public void onClick(ClickEvent event) {
			// TODO Auto-generated method stub
			setInSlot(SLOT_mainContentSlot, resetPresenter);

		}

	}
	
	public class onHomePressed implements ClickHandler {

		@Override
		public void onClick(ClickEvent event) {
			// TODO Auto-generated method stub
			setInSlot(SLOT_mainContentSlot, hobbiesPresenter);
		}

	}

}