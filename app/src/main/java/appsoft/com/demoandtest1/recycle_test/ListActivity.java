package appsoft.com.demoandtest1.recycle_test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import appsoft.com.demoandtest1.R;

public class ListActivity extends AppCompatActivity {

    int receivedFlag = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        receivedFlag = getIntent().getIntExtra("INTENT_FLAG", 0);
        selectedFragment(receivedFlag);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    private void selectedFragment(int receivedFlag){
        switch (receivedFlag){
            case Constants.OS_INTENT_FLAG:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragContainer, new OSListFragment())
                        .addToBackStack(null)
                        .commit();
                return;
            case Constants.DEVELOPER_INTENT_FLAG:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragContainer, new DeveloperListFragment())
                        .addToBackStack(null)
                        .commit();
                return;
            default:
                return;
        }
    }
}