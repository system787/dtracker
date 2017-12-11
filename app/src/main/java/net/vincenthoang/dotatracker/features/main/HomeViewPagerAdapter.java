package net.vincenthoang.dotatracker.features.main;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import net.vincenthoang.dotatracker.features.main.fragment.AccountFragment;

/**
 * Created by vincenthoang on 12/11/17.
 */

public class HomeViewPagerAdapter extends FragmentPagerAdapter {

    public HomeViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }


    @Override
    public int getItemPosition(Object object) {
        return super.getItemPosition(object);
    }

    /**
     * This method may be called by the ViewPager to obtain a title string
     * to describe the specified page. This method may return null
     * indicating no title for this page. The default implementation returns
     * null.
     *
     * @param position The position of the title requested
     * @return A title for the requested page
     */
    @Override
    public CharSequence getPageTitle(int position) {
        String title = null;
        if (position == 1) {
            title = "Activity Feed";
        }
        if (position == 0) {
            title = "Account";
        }
        return title;
    }

    /**
     * Return the number of views available.
     */
    @Override
    public int getCount() {
        return 1;
    }

    /**
     * Return the Fragment associated with a specified position.
     *
     * @param position
     */
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new AccountFragment();
            case 1:
                return null;
        }

        return null;
    }
}
