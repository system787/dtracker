package net.vincenthoang.dotatracker.injection.module;

import android.support.v4.app.Fragment;

import net.vincenthoang.dotatracker.features.main.HeroAdapter;
import net.vincenthoang.dotatracker.features.main.accountfragment.AccountFragment;
import net.vincenthoang.dotatracker.injection.PerActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by vincenthoang on 12/10/17.
 */
@Module
public class AccountFragmentModule extends FragmentModule {
    private Fragment mFragment;

    public AccountFragmentModule(Fragment fragment) {
        super(fragment);
        mFragment = fragment;
    }

    @Provides
    @PerActivity
    HeroAdapter provideHeroAdapter(AccountFragment accountFragment) {
        return new HeroAdapter(accountFragment);
    }
}
