package com.luis.gwtinterview.client.application;

import com.luis.gwtinterview.client.application.hobbies.HobbiesModule;
import com.luis.gwtinterview.client.application.hobby1.FirstHobbyModule;
import com.luis.gwtinterview.client.application.hobby2.SecondHobbyModule;
import com.luis.gwtinterview.client.application.home.HomeModule;
import com.luis.gwtinterview.client.application.reset.ResetModule;
import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class ApplicationModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
        install(new HomeModule());
		install(new SecondHobbyModule());
		install(new FirstHobbyModule());
		install(new HobbiesModule());
		install(new ResetModule());
        bindPresenter(ApplicationPresenter.class, ApplicationPresenter.MyView.class, ApplicationView.class,
                ApplicationPresenter.MyProxy.class);
    }
}