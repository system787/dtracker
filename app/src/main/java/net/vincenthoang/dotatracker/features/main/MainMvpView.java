package net.vincenthoang.dotatracker.features.main;

import java.util.List;

import net.vincenthoang.dotatracker.data.model.response.HeroesPlayed;
import net.vincenthoang.dotatracker.data.model.response.PlayerProfile;
import net.vincenthoang.dotatracker.data.model.response.WinLoss;
import net.vincenthoang.dotatracker.features.base.MvpView;

public interface MainMvpView extends MvpView {

    void showProgress(boolean show);

    void showError(Throwable error);

    void getHeroesPlayed(List<HeroesPlayed> heroesPlayedList);

    void getWinLoss(WinLoss winLoss);

    void getPlayerProfile(PlayerProfile playerProfile);
}
