package net.vincenthoang.dotatracker.injection.component;

import net.vincenthoang.dotatracker.features.main.MainActivity;
import net.vincenthoang.dotatracker.features.main.accountfragment.AccountFragment;
import net.vincenthoang.dotatracker.injection.PerFragment;
import net.vincenthoang.dotatracker.injection.module.FragmentModule;

import dagger.Subcomponent;

/**
 * This component inject dependencies to all Fragments across the application
 */
@PerFragment
@Subcomponent(modules = FragmentModule.class)
public interface FragmentComponent {
    void inject(MainActivity mainActivity);
    void inject(AccountFragment accountFragment);
    void inject(FragmentComponent fragmentComponent);
}
