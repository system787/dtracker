package net.vincenthoang.dotatracker.features.main.herodetail;

import android.os.Bundle;

import net.vincenthoang.dotatracker.features.base.BaseActivity;
import net.vincenthoang.dotatracker.injection.component.ActivityComponent;

/**
 * Created by vincenthoang on 12/12/17.
 */

public class HeroDetailActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayout() {
        return 0;
    }

    @Override
    protected void inject(ActivityComponent activityComponent) {

    }

    @Override
    protected void attachView() {

    }

    @Override
    protected void detachPresenter() {

    }
}
