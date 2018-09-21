package appsoft.com.demoandtest1.custom_nav_bar.helper;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import appsoft.com.demoandtest1.BuildConfig;
import appsoft.com.demoandtest1.R;
import appsoft.com.demoandtest1.custom_nav_bar.FragmentContent;
import appsoft.com.demoandtest1.custom_nav_bar.StartingActivity;
import appsoft.com.demoandtest1.custom_nav_bar.interfaces.NavigationManager;

public class FragmentNavigationManager implements NavigationManager{

    private static FragmentNavigationManager mInstance;
    private FragmentManager mManager;
    private StartingActivity mStartingActivity;

    public static FragmentNavigationManager getmInstance(StartingActivity mStartingActivity){

        if (mInstance == null){
            mInstance = new FragmentNavigationManager();
        }
        mInstance.configure(mStartingActivity);
        return mInstance;
    }

    @Override
    public void showFragment(String title) {

        showFragment(FragmentContent.getInstance(title), false);
    }

    private void showFragment(Fragment fragment, boolean b){
        FragmentManager manager = mManager;
        FragmentTransaction mTransaction = mManager.beginTransaction().replace(R.id.container, fragment);
        mTransaction.addToBackStack(null);

        if (b || !BuildConfig.DEBUG){
            mTransaction.commitAllowingStateLoss();
        }else{
            mTransaction.commit();
        }
        manager.executePendingTransactions();
    }

    private void configure(StartingActivity mStartingActivity) {
        this.mStartingActivity = mStartingActivity;
        mManager = mStartingActivity.getSupportFragmentManager();
    }
}
