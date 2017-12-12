package net.vincenthoang.dotatracker.features.main.module;

import android.content.Context;
import android.support.v4.app.Fragment;

import net.vincenthoang.dotatracker.features.main.HeroAdapter;
import net.vincenthoang.dotatracker.features.main.fragment.AccountFragment;
import net.vincenthoang.dotatracker.injection.ActivityContext;
import net.vincenthoang.dotatracker.injection.PerFragment;
import net.vincenthoang.dotatracker.injection.module.FragmentModule;

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

    private AccountFragment mAccountFragment;

    @Provides
    @PerFragment
    HeroAdapter provideHeroAdapter(AccountFragment accountFragment) {
        return new HeroAdapter(accountFragment);
    }

    @Provides
    @ActivityContext
    Context providesContext() {
        return mFragment.getActivity();
    }
}
