package net.vincenthoang.dotatracker.data.model;

/**
 * Created by vincenthoang on 12/10/17.
 */

public class OpenDotaUser {

    private String tracked_until;
    private String solo_competitive_rank;
    private String competitive_rank;
    private int rank_tier;
    private int leaderboard_rank;

    private SteamProfile profile;

    public OpenDotaUser(String tracked_until, String solo_competitive_rank, String competitive_rank, int rank_tier, int leaderboard_rank, SteamProfile profile) {
        this.tracked_until = tracked_until;
        this.solo_competitive_rank = solo_competitive_rank;
        this.competitive_rank = competitive_rank;
        this.rank_tier = rank_tier;
        this.leaderboard_rank = leaderboard_rank;
        this.profile = profile;
    }

    public String getTracked_until() {
        return tracked_until;
    }

    public void setTracked_until(String tracked_until) {
        this.tracked_until = tracked_until;
    }

    public String getSolo_competitive_rank() {
        return solo_competitive_rank;
    }

    public void setSolo_competitive_rank(String solo_competitive_rank) {
        this.solo_competitive_rank = solo_competitive_rank;
    }

    public String getCompetitive_rank() {
        return competitive_rank;
    }

    public void setCompetitive_rank(String competitive_rank) {
        this.competitive_rank = competitive_rank;
    }

    public int getRank_tier() {
        return rank_tier;
    }

    public void setRank_tier(int rank_tier) {
        this.rank_tier = rank_tier;
    }

    public int getLeaderboard_rank() {
        return leaderboard_rank;
    }

    public void setLeaderboard_rank(int leaderboard_rank) {
        this.leaderboard_rank = leaderboard_rank;
    }

    public SteamProfile getProfile() {
        return profile;
    }

    public void setProfile(SteamProfile profile) {
        this.profile = profile;
    }
}
