package net.vincenthoang.dotatracker.injection.component;

import android.app.Application;
import android.content.Context;

import net.vincenthoang.dotatracker.data.DataManager;
import net.vincenthoang.dotatracker.injection.ApplicationContext;
import net.vincenthoang.dotatracker.injection.module.AppModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {

    @ApplicationContext
    Context context();

    Application application();

    DataManager apiManager();
}
