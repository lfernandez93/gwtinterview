package com.luis.gwtinterview.client.application.hobbies;

import com.luis.gwtinterview.client.application.home.HomeModule;
import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class HobbiesModule extends AbstractPresenterModule {
    @Override
    protected void configure() {

        bindPresenter(HobbiesPresenter.class, HobbiesPresenter.MyView.class, HobbiesView.class,
                HobbiesPresenter.MyProxy.class);
    }
}