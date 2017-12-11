package net.vincenthoang.dotatracker.features.main.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import net.vincenthoang.dotatracker.R;
import net.vincenthoang.dotatracker.data.model.response.PlayerProfile;
import net.vincenthoang.dotatracker.data.model.response.WinLoss;
import net.vincenthoang.dotatracker.features.base.BaseFragment;
import net.vincenthoang.dotatracker.injection.component.FragmentComponent;

/**
 * Created by vincenthoang on 12/10/17.
 */

public class AccountFragment extends BaseFragment {
    private FragmentComponent mFragmentComponent;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private ListView mListView;
    private Context mContext;
    private View mView;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        mView = inflater.inflate(R.layout.fragment_account, container, false);


        mSwipeRefreshLayout = mView.findViewById(R.id.accountRefreshLayout);
        mListView = mView.findViewById(R.id.heroesPlayedListView);


        return mView;
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_account;
    }

    @Override
    protected void inject(FragmentComponent fragmentComponent) {
    }

    @Override
    protected void attachView() {
    }

    @Override
    protected void detachPresenter() {

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    public interface Item {
        public boolean isHeader();
    }

    public interface onApiReceive {
        public void onReceive(PlayerProfile playerProfile, WinLoss winLoss);
    }
}
