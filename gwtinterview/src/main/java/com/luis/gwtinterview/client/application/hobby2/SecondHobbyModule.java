package com.luis.gwtinterview.client.application.hobby2;

import com.luis.gwtinterview.client.application.home.HomeModule;
import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class SecondHobbyModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
        bindPresenter(SecondHobbyPresenter.class, SecondHobbyPresenter.MyView.class, SecondHobbyView.class,
                SecondHobbyPresenter.MyProxy.class);
    }
}