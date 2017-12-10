package net.vincenthoang.dotatracker.data.model;

/**
 * Created by vincenthoang on 12/10/17.
 */

public class RatingEstimate {
    int estimate;
    int stdDev;
    int n;

    public RatingEstimate(int estimate, int stdDev, int n) {
        this.estimate = estimate;
        this.stdDev = stdDev;
        this.n = n;
    }

    public int getEstimate() {
        return estimate;
    }

    public void setEstimate(int estimate) {
        this.estimate = estimate;
    }

    public int getStdDev() {
        return stdDev;
    }

    public void setStdDev(int stdDev) {
        this.stdDev = stdDev;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }
}
