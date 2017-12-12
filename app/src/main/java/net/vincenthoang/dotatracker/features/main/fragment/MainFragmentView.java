package net.vincenthoang.dotatracker.features.main.fragment;

import net.vincenthoang.dotatracker.data.model.response.HeroesPlayed;
import net.vincenthoang.dotatracker.data.model.response.PlayerProfile;
import net.vincenthoang.dotatracker.data.model.response.WinLoss;
import net.vincenthoang.dotatracker.features.base.MvpView;

import java.util.List;

/**
 * Created by vincenthoang on 12/11/17.
 */

public interface MainFragmentView extends MvpView {

    void showProgress(boolean show);

    void showError(Throwable error);

    void getHeroesPlayed(List<HeroesPlayed> heroesPlayedList);

    void getWinLoss(WinLoss winLoss);

    void getPlayerProfile(PlayerProfile playerProfile);

    void getRefreshAll(List<HeroesPlayed> heroesPlayedList, PlayerProfile playerProfile, WinLoss winLoss);

}
