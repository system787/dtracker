package net.vincenthoang.dotatracker.data.model.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import net.vincenthoang.dotatracker.data.model.response.MmrEstimate;
import net.vincenthoang.dotatracker.data.model.response.Profile;

public class PlayerProfile {

    @SerializedName("tracked_until")
    @Expose
    private String trackedUntil;
    @SerializedName("solo_competitive_rank")
    @Expose
    private String soloCompetitiveRank;
    @SerializedName("competitive_rank")
    @Expose
    private String competitiveRank;
    @SerializedName("rank_tier")
    @Expose
    private int rankTier;
    @SerializedName("leaderboard_rank")
    @Expose
    private int leaderboardRank;
    @SerializedName("mmr_estimate")
    @Expose
    private MmrEstimate mmrEstimate;
    @SerializedName("profile")
    @Expose
    private Profile profile;

    /**
     * No args constructor for use in serialization
     */
    public PlayerProfile() {
    }

    /**
     * @param leaderboardRank
     * @param competitiveRank
     * @param rankTier
     * @param soloCompetitiveRank
     * @param trackedUntil
     * @param mmrEstimate
     * @param profile
     */
    public PlayerProfile(String trackedUntil, String soloCompetitiveRank, String competitiveRank, int rankTier, int leaderboardRank, MmrEstimate mmrEstimate, Profile profile) {
        super();
        this.trackedUntil = trackedUntil;
        this.soloCompetitiveRank = soloCompetitiveRank;
        this.competitiveRank = competitiveRank;
        this.rankTier = rankTier;
        this.leaderboardRank = leaderboardRank;
        this.mmrEstimate = mmrEstimate;
        this.profile = profile;
    }

    public String getTrackedUntil() {
        return trackedUntil;
    }

    public void setTrackedUntil(String trackedUntil) {
        this.trackedUntil = trackedUntil;
    }

    public PlayerProfile withTrackedUntil(String trackedUntil) {
        this.trackedUntil = trackedUntil;
        return this;
    }

    public String getSoloCompetitiveRank() {
        return soloCompetitiveRank;
    }

    public void setSoloCompetitiveRank(String soloCompetitiveRank) {
        this.soloCompetitiveRank = soloCompetitiveRank;
    }

    public PlayerProfile withSoloCompetitiveRank(String soloCompetitiveRank) {
        this.soloCompetitiveRank = soloCompetitiveRank;
        return this;
    }

    public String getCompetitiveRank() {
        return competitiveRank;
    }

    public void setCompetitiveRank(String competitiveRank) {
        this.competitiveRank = competitiveRank;
    }

    public PlayerProfile withCompetitiveRank(String competitiveRank) {
        this.competitiveRank = competitiveRank;
        return this;
    }

    public int getRankTier() {
        return rankTier;
    }

    public void setRankTier(int rankTier) {
        this.rankTier = rankTier;
    }

    public PlayerProfile withRankTier(int rankTier) {
        this.rankTier = rankTier;
        return this;
    }

    public int getLeaderboardRank() {
        return leaderboardRank;
    }

    public void setLeaderboardRank(int leaderboardRank) {
        this.leaderboardRank = leaderboardRank;
    }

    public PlayerProfile withLeaderboardRank(int leaderboardRank) {
        this.leaderboardRank = leaderboardRank;
        return this;
    }

    public MmrEstimate getMmrEstimate() {
        return mmrEstimate;
    }

    public void setMmrEstimate(MmrEstimate mmrEstimate) {
        this.mmrEstimate = mmrEstimate;
    }

    public PlayerProfile withMmrEstimate(MmrEstimate mmrEstimate) {
        this.mmrEstimate = mmrEstimate;
        return this;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public PlayerProfile withProfile(Profile profile) {
        this.profile = profile;
        return this;
    }
}
