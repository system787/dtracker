
package net.vincenthoang.dotatracker.data.model.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Profile {

    @SerializedName("account_id")
    @Expose
    private int accountId;
    @SerializedName("personaname")
    @Expose
    private String personaname;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("cheese")
    @Expose
    private int cheese;
    @SerializedName("steamid")
    @Expose
    private String steamid;
    @SerializedName("avatar")
    @Expose
    private String avatar;
    @SerializedName("avatarmedium")
    @Expose
    private String avatarmedium;
    @SerializedName("avatarfull")
    @Expose
    private String avatarfull;
    @SerializedName("profileurl")
    @Expose
    private String profileurl;
    @SerializedName("last_login")
    @Expose
    private String lastLogin;
    @SerializedName("loccountrycode")
    @Expose
    private String loccountrycode;

    /**
     * No args constructor for use in serialization
     *
     */
    public Profile() {
    }

    /**
     *
     * @param lastLogin
     * @param avatarmedium
     * @param steamid
     * @param accountId
     * @param name
     * @param personaname
     * @param cheese
     * @param avatar
     * @param avatarfull
     * @param loccountrycode
     * @param profileurl
     */
    public Profile(int accountId, String personaname, String name, int cheese, String steamid, String avatar, String avatarmedium, String avatarfull, String profileurl, String lastLogin, String loccountrycode) {
        super();
        this.accountId = accountId;
        this.personaname = personaname;
        this.name = name;
        this.cheese = cheese;
        this.steamid = steamid;
        this.avatar = avatar;
        this.avatarmedium = avatarmedium;
        this.avatarfull = avatarfull;
        this.profileurl = profileurl;
        this.lastLogin = lastLogin;
        this.loccountrycode = loccountrycode;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public Profile withAccountId(int accountId) {
        this.accountId = accountId;
        return this;
    }

    public String getPersonaname() {
        return personaname;
    }

    public void setPersonaname(String personaname) {
        this.personaname = personaname;
    }

    public Profile withPersonaname(String personaname) {
        this.personaname = personaname;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Profile withName(String name) {
        this.name = name;
        return this;
    }

    public int getCheese() {
        return cheese;
    }

    public void setCheese(int cheese) {
        this.cheese = cheese;
    }

    public Profile withCheese(int cheese) {
        this.cheese = cheese;
        return this;
    }

    public String getSteamid() {
        return steamid;
    }

    public void setSteamid(String steamid) {
        this.steamid = steamid;
    }

    public Profile withSteamid(String steamid) {
        this.steamid = steamid;
        return this;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Profile withAvatar(String avatar) {
        this.avatar = avatar;
        return this;
    }

    public String getAvatarmedium() {
        return avatarmedium;
    }

    public void setAvatarmedium(String avatarmedium) {
        this.avatarmedium = avatarmedium;
    }

    public Profile withAvatarmedium(String avatarmedium) {
        this.avatarmedium = avatarmedium;
        return this;
    }

    public String getAvatarfull() {
        return avatarfull;
    }

    public void setAvatarfull(String avatarfull) {
        this.avatarfull = avatarfull;
    }

    public Profile withAvatarfull(String avatarfull) {
        this.avatarfull = avatarfull;
        return this;
    }

    public String getProfileurl() {
        return profileurl;
    }

    public void setProfileurl(String profileurl) {
        this.profileurl = profileurl;
    }

    public Profile withProfileurl(String profileurl) {
        this.profileurl = profileurl;
        return this;
    }

    public String getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(String lastLogin) {
        this.lastLogin = lastLogin;
    }

    public Profile withLastLogin(String lastLogin) {
        this.lastLogin = lastLogin;
        return this;
    }

    public String getLoccountrycode() {
        return loccountrycode;
    }

    public void setLoccountrycode(String loccountrycode) {
        this.loccountrycode = loccountrycode;
    }

    public Profile withLoccountrycode(String loccountrycode) {
        this.loccountrycode = loccountrycode;
        return this;
    }

    @Override
    public String toString() {
        return "Profile{" +
                "accountId=" + accountId +
                ", personaname='" + personaname + '\'' +
                ", name='" + name + '\'' +
                ", cheese=" + cheese +
                ", steamid='" + steamid + '\'' +
                ", avatar='" + avatar + '\'' +
                ", avatarmedium='" + avatarmedium + '\'' +
                ", avatarfull='" + avatarfull + '\'' +
                ", profileurl='" + profileurl + '\'' +
                ", lastLogin='" + lastLogin + '\'' +
                ", loccountrycode='" + loccountrycode + '\'' +
                '}';
    }
}