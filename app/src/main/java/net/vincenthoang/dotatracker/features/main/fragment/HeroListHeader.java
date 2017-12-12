package net.vincenthoang.dotatracker.features.main.fragment;

import android.graphics.drawable.Drawable;

/**
 * Created by vincenthoang on 12/11/17.
 */

public class HeroListHeader extends HeroListData {
    String mUsername, mWinPercentage;
    Drawable mDrawable;

    public String getUsername() {
        return mUsername;
    }

    public void setUsername(String username) {
        mUsername = username;
    }

    public String getWinPercentage() {
        return mWinPercentage;
    }

    public void setWinPercentage(String winPercentage) {
        mWinPercentage = winPercentage;
    }

    public Drawable getDrawable() {
        return mDrawable;
    }

    public void setDrawable(Drawable drawable) {
        mDrawable = drawable;
    }

}
