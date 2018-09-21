package appsoft.com.demoandtest1.recycle_test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import aar.erp.appsoft.androidlog.AndroidLog;
import appsoft.com.demoandtest1.R;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        testAndroidLogLibrary();
    }

    private void testAndroidLogLibrary() {
        AndroidLog.debug("TAG", "Constructor Call");
        AndroidLog.error("TAG", "Constructor Call");
        AndroidLog.warn("TAG", "Constructor Call");
        AndroidLog.info("TAG", "Constructor Call");
        AndroidLog.verbose("TAG", "Constructor Call");
    }

    public void callListOne(View v){
        Intent osIntent = new Intent(this, ListActivity.class);
        osIntent.putExtra("INTENT_FLAG", Constants.OS_INTENT_FLAG);
        startActivity(osIntent);
    }

    public void callListTwo(View v){
        Intent devIntent = new Intent(this, ListActivity.class);
        devIntent.putExtra("INTENT_FLAG", Constants.DEVELOPER_INTENT_FLAG);
        startActivity(devIntent);
    }
}
