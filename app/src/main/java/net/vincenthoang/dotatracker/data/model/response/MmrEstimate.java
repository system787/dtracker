package net.vincenthoang.dotatracker.data.model.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MmrEstimate {

    @SerializedName("estimate")
    @Expose
    private int estimate;
    @SerializedName("stdDev")
    @Expose
    private int stdDev;
    @SerializedName("n")
    @Expose
    private int n;

    /**
     * No args constructor for use in serialization
     *
     */
    public MmrEstimate() {
    }

    /**
     *
     * @param n
     * @param estimate
     * @param stdDev
     */
    public MmrEstimate(int estimate, int stdDev, int n) {
        super();
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

    public MmrEstimate withEstimate(int estimate) {
        this.estimate = estimate;
        return this;
    }

    public int getStdDev() {
        return stdDev;
    }

    public void setStdDev(int stdDev) {
        this.stdDev = stdDev;
    }

    public MmrEstimate withStdDev(int stdDev) {
        this.stdDev = stdDev;
        return this;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public MmrEstimate withN(int n) {
        this.n = n;
        return this;
    }

}