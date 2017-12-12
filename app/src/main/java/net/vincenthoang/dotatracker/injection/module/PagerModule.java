package net.vincenthoang.dotatracker.injection.module;

import net.vincenthoang.dotatracker.features.main.HomeViewPagerAdapter;
import net.vincenthoang.dotatracker.features.main.MainActivity;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by vincenthoang on 12/11/17.
 */

@Module
public class PagerModule extends MainActivity {

    @Singleton
    @Provides
    protected HomeViewPagerAdapter provideAdapter() {
        return new HomeViewPagerAdapter(getSupportFragmentManager());
    }
}
