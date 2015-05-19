package com.luis.gwtinterview.client.application.hobby1;

import com.luis.gwtinterview.client.application.home.HomeModule;
import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class FirstHobbyModule extends AbstractPresenterModule {
    @Override
    protected void configure() {

        bindPresenter(FirstHobbyPresenter.class, FirstHobbyPresenter.MyView.class, FirstHobbyView.class,
                FirstHobbyPresenter.MyProxy.class);
    }
}