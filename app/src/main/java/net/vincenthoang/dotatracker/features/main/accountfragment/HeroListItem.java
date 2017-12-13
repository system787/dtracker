package net.vincenthoang.dotatracker.features.main.accountfragment;

import android.graphics.drawable.Drawable;

/**
 * Created by vincenthoang on 12/11/17.
 */

public class HeroListItem extends HeroListData {
    String mHeroName, mGamesPlayed, mGamesWon;
    Drawable mHeroImage;
    int mGamesPlayedProgress;

    public String getHeroName() {
        return mHeroName;
    }

    public void setHeroName(String heroName) {
        mHeroName = heroName;
    }

    public int getGamesPlayedProgress() {
        return mGamesPlayedProgress;
    }

    public void setGamesPlayedProgress(int gamesPlayedProgress) {
        mGamesPlayedProgress = gamesPlayedProgress;
    }

    public String getGamesPlayed() {
        return mGamesPlayed;
    }

    public void setGamesPlayed(String gamesPlayed) {
        mGamesPlayed = gamesPlayed;
    }

    public String getGamesWon() {
        return mGamesWon;
    }

    public void setGamesWon(String gamesWon) {
        mGamesWon = gamesWon;
    }

    public Drawable getHeroImage() {
        return mHeroImage;
    }

    public void setHeroImage(Drawable heroImage) {
        mHeroImage = heroImage;
    }
}
