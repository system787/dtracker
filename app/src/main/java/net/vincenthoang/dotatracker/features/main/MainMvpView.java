package net.vincenthoang.dotatracker.features.main;

import net.vincenthoang.dotatracker.features.base.MvpView;

public interface MainMvpView extends MvpView {

    void showProgress(boolean show);

    void showError(Throwable error);
}
