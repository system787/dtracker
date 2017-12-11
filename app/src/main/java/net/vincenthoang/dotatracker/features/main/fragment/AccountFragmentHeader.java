package net.vincenthoang.dotatracker.features.main.fragment;

import android.content.Context;
import android.graphics.Color;
import android.widget.ImageView;
import android.widget.TextView;

import com.koushikdutta.ion.Ion;

import net.vincenthoang.dotatracker.R;
import net.vincenthoang.dotatracker.data.model.response.PlayerProfile;
import net.vincenthoang.dotatracker.data.model.response.WinLoss;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import butterknife.BindView;
import io.netopen.hotbitmapgg.library.view.RingProgressBar;


public class AccountFragmentHeader implements AccountFragment.Item, AccountFragmentView {

    @BindView(R.id.profilePicture)
    ImageView mProfileImageView;

    @BindView(R.id.frag_userName)
    TextView mUserNameTextView;

    @BindView(R.id.winRingProgressBar)
    RingProgressBar mRingProgressBar;

    @BindView(R.id.winPercentageTextView)
    TextView mWinPercentageTextView;

    private Context mContext;
    private PlayerProfile mPlayerProfile;
    private WinLoss mWinLoss;

    public AccountFragmentHeader(Context context, PlayerProfile playerProfile, WinLoss winLoss) {
        this.mContext = context;
        this.mPlayerProfile = playerProfile;
        this.mWinLoss = winLoss;

        onRefresh();
    }

    @Override
    public void showProfileDetails() {
        Ion.with(mContext).load(mPlayerProfile.getProfile().getAvatarmedium()).intoImageView(mProfileImageView);
        mUserNameTextView.setText(mPlayerProfile.getProfile().getPersonaname());
    }

    @Override
    public void showWinPercentage() {
        String winPercentage = getWinPercentage(mWinLoss.getWin(), mWinLoss.getLose());
        mWinPercentageTextView.setText(winPercentage);

        double winPercent = Double.parseDouble(winPercentage);

        if (winPercent >= 55.0) {
            mWinPercentageTextView.setTextColor(Color.CYAN);
        } else if (winPercent >= 53.0) {
            mWinPercentageTextView.setTextColor(Color.GREEN);
        } else if (winPercent >= 47) {
            mWinPercentageTextView.setTextColor(Color.WHITE);
        } else {
            mWinPercentageTextView.setTextColor(Color.RED);
        }

        mRingProgressBar.setProgress((int) winPercent);
    }

    @Override
    public void showError() {

    }

    @Override
    public void onClickProfileDetails() {

    }

    @Override
    public void onRefresh() {
        showProfileDetails();
        showWinPercentage();
    }

    @Override
    public boolean isHeader() {
        return true;
    }

    private String getWinPercentage(int wins, int losses) {
        NumberFormat nf = DecimalFormat.getPercentInstance();
        nf.setMaximumFractionDigits(1);

        double winPercent = 100 * wins / (wins + losses);

        return nf.format(winPercent);
    }

}
