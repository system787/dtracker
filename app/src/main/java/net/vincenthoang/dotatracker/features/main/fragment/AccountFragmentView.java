package net.vincenthoang.dotatracker.features.main.fragment;

import net.vincenthoang.dotatracker.features.base.MvpView;

/**
 * Created by vincenthoang on 12/10/17.
 */

public interface AccountFragmentView extends MvpView {
    void showProfileDetails();
    void showWinPercentage();
    void showError();

    void onClickProfileDetails();
    void onRefresh();
}
