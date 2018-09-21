package appsoft.com.demoandtest1.fragment_transition;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import appsoft.com.demoandtest1.R;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        getSupportFragmentManager().beginTransaction().add(R.id.fragmentContainer, new StartFragment()).addToBackStack(null).commit();
    }
}
