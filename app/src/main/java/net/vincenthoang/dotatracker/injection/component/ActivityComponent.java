package net.vincenthoang.dotatracker.injection.component;

import net.vincenthoang.dotatracker.features.main.MainActivity;
import net.vincenthoang.dotatracker.features.main.fragment.AccountFragment;
import net.vincenthoang.dotatracker.injection.PerActivity;
import net.vincenthoang.dotatracker.injection.module.ActivityModule;
import net.vincenthoang.dotatracker.injection.module.FragmentModule;

import dagger.Subcomponent;

@PerActivity
@Subcomponent(modules = { ActivityModule.class, FragmentModule.class })
public interface ActivityComponent {

    void inject(MainActivity mainActivity);
    void inject(AccountFragment accountFragment);
}
