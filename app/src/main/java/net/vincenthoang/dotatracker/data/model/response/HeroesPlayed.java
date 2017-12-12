package net.vincenthoang.dotatracker.data.model.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HeroesPlayed {

    @SerializedName("hero_id")
    @Expose
    private int heroId;
    @SerializedName("last_played")
    @Expose
    private int lastPlayed;
    @SerializedName("games")
    @Expose
    private int games;
    @SerializedName("win")
    @Expose
    private int win;
    @SerializedName("with_games")
    @Expose
    private int withGames;
    @SerializedName("with_win")
    @Expose
    private int withWin;
    @SerializedName("against_games")
    @Expose
    private int againstGames;
    @SerializedName("against_win")
    @Expose
    private int againstWin;

    /**
     * No args constructor for use in serialization
     */
    //public HeroesPlayed() {
    //}

    /**
     * @param againstWin
     * @param games
     * @param againstGames
     * @param withGames
     * @param lastPlayed
     * @param win
     * @param withWin
     * @param heroId
     */

    public HeroesPlayed(int heroId, int lastPlayed, int games, int win, int withGames, int withWin, int againstGames, int againstWin) {
        super();
        this.heroId = heroId;
        this.lastPlayed = lastPlayed;
        this.games = games;
        this.win = win;
        this.withGames = withGames;
        this.withWin = withWin;
        this.againstGames = againstGames;
        this.againstWin = againstWin;
    }

    public HeroesPlayed(HeroesPlayed hp) {
        this.heroId = hp.getHeroId();
        this.lastPlayed = hp.getLastPlayed();
        this.games = hp.getGames();
        this.win = hp.getWin();
        this.withGames = hp.getWithGames();
        this.withWin = hp.getWithWin();
        this.againstGames = hp.getAgainstGames();
        this.againstWin = hp.getAgainstWin();
    }

    public int getHeroId() {
        return heroId;
    }

    public void setHeroId(int heroId) {
        this.heroId = heroId;
    }

    public HeroesPlayed withHeroId(int heroId) {
        this.heroId = heroId;
        return this;
    }

    public int getLastPlayed() {
        return lastPlayed;
    }

    public void setLastPlayed(int lastPlayed) {
        this.lastPlayed = lastPlayed;
    }

    public HeroesPlayed withLastPlayed(int lastPlayed) {
        this.lastPlayed = lastPlayed;
        return this;
    }

    public int getGames() {
        return games;
    }

    public void setGames(int games) {
        this.games = games;
    }

    public HeroesPlayed withGames(int games) {
        this.games = games;
        return this;
    }

    public int getWin() {
        return win;
    }

    public void setWin(int win) {
        this.win = win;
    }

    public HeroesPlayed withWin(int win) {
        this.win = win;
        return this;
    }

    public int getWithGames() {
        return withGames;
    }

    public void setWithGames(int withGames) {
        this.withGames = withGames;
    }

    public HeroesPlayed withWithGames(int withGames) {
        this.withGames = withGames;
        return this;
    }

    public int getWithWin() {
        return withWin;
    }

    public void setWithWin(int withWin) {
        this.withWin = withWin;
    }

    public HeroesPlayed withWithWin(int withWin) {
        this.withWin = withWin;
        return this;
    }

    public int getAgainstGames() {
        return againstGames;
    }

    public void setAgainstGames(int againstGames) {
        this.againstGames = againstGames;
    }

    public HeroesPlayed withAgainstGames(int againstGames) {
        this.againstGames = againstGames;
        return this;
    }

    public int getAgainstWin() {
        return againstWin;
    }

    public void setAgainstWin(int againstWin) {
        this.againstWin = againstWin;
    }

    public HeroesPlayed withAgainstWin(int againstWin) {
        this.againstWin = againstWin;
        return this;
    }

    @Override
    public String toString() {
        return "HeroesPlayed{" +
                "heroId=" + heroId +
                ", lastPlayed=" + lastPlayed +
                ", games=" + games +
                ", win=" + win +
                ", withGames=" + withGames +
                ", withWin=" + withWin +
                ", againstGames=" + againstGames +
                ", againstWin=" + againstWin +
                '}';
    }
}