package net.vincenthoang.dotatracker.data.model.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WinLoss {

    @SerializedName("win")
    @Expose
    private int win;
    @SerializedName("lose")
    @Expose
    private int lose;

    /**
     * No args constructor for use in serialization
     *
     */
    public WinLoss() {
    }

    /**
     *
     * @param lose
     * @param win
     */
    public WinLoss(int win, int lose) {
        super();
        this.win = win;
        this.lose = lose;
    }

    public int getWin() {
        return win;
    }

    public void setWin(int win) {
        this.win = win;
    }

    public WinLoss withWin(int win) {
        this.win = win;
        return this;
    }

    public int getLose() {
        return lose;
    }

    public void setLose(int lose) {
        this.lose = lose;
    }

    public WinLoss withLose(int lose) {
        this.lose = lose;
        return this;
    }

}