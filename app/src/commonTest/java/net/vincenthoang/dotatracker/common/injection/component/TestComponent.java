package net.vincenthoang.dotatracker.common.injection.component;

import javax.inject.Singleton;

import dagger.Component;
import net.vincenthoang.dotatracker.common.injection.module.ApplicationTestModule;
import net.vincenthoang.dotatracker.injection.component.AppComponent;

@Singleton
@Component(modules = ApplicationTestModule.class)
public interface TestComponent extends AppComponent {
}
