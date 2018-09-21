package appsoft.com.demoandtest1;

import android.content.Intent;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class FromActivityTransition extends AppCompatActivity {

    private ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_from_transition);
        image = findViewById(R.id.image);
    }

    public void animateMe(View view){
        Intent i = new Intent(this, ToActivityTransition.class);
        ActivityOptionsCompat opt = ActivityOptionsCompat.makeSceneTransitionAnimation(
                this,
                image,
                ViewCompat.getTransitionName(image)
        );

        startActivity(i, opt.toBundle());
    }
}
