package net.vincenthoang.dotatracker.injection.component;

import dagger.Subcomponent;
import net.vincenthoang.dotatracker.features.detail.DetailActivity;
import net.vincenthoang.dotatracker.features.main.MainActivity;
import net.vincenthoang.dotatracker.injection.PerActivity;
import net.vincenthoang.dotatracker.injection.module.ActivityModule;

@PerActivity
@Subcomponent(modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(MainActivity mainActivity);

    void inject(DetailActivity detailActivity);
}
