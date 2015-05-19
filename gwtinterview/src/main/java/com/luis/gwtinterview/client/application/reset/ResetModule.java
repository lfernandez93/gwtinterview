package com.luis.gwtinterview.client.application.reset;

import com.luis.gwtinterview.client.application.home.HomeModule;
import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class ResetModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
        bindPresenter(ResetPresenter.class, ResetPresenter.MyView.class, ResetView.class,
                ResetPresenter.MyProxy.class);
    }
}