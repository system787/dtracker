package net.vincenthoang.dotatracker.data.model;

/**
 * Created by vincenthoang on 12/10/17.
 */

public class Hero {
    private String mLocalizedName;
    private String mTokenName;
    private int mId;

    public String getLocalizedName() {
        return mLocalizedName;
    }

    public void setLocalizedName(String localizedName) {
        mLocalizedName = localizedName;
    }

    public String getTokenName() {
        return mTokenName;
    }

    public void setTokenName(String tokenName) {
        mTokenName = tokenName;
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public String getFileName() {
        return "file:///android_asset/" + mTokenName + ".png";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Hero hero = (Hero) o;

        if (mId != hero.mId) return false;
        if (mLocalizedName != null ? !mLocalizedName.equals(hero.mLocalizedName) : hero.mLocalizedName != null)
            return false;
        return mTokenName != null ? mTokenName.equals(hero.mTokenName) : hero.mTokenName == null;
    }

    @Override
    public int hashCode() {
        int result = mLocalizedName != null ? mLocalizedName.hashCode() : 0;
        result = 31 * result + (mTokenName != null ? mTokenName.hashCode() : 0);
        result = 31 * result + mId;
        return result;
    }

    @Override
    public String toString() {
        return "Hero{" +
                "mLocalizedName='" + mLocalizedName + '\'' +
                ", mTokenName='" + mTokenName + '\'' +
                ", mId=" + mId +
                '}';
    }
}
