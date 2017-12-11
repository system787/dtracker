package net.vincenthoang.dotatracker.injection.component;

import dagger.Subcomponent;

import net.vincenthoang.dotatracker.features.main.MainActivity;
import net.vincenthoang.dotatracker.injection.PerFragment;
import net.vincenthoang.dotatracker.injection.module.FragmentModule;

/**
 * This component inject dependencies to all Fragments across the application
 */
@PerFragment
@Subcomponent(modules = FragmentModule.class)
public interface FragmentComponent {
    void inject(MainActivity mainActivity);
}
