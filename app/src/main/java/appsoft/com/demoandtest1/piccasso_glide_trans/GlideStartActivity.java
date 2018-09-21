package appsoft.com.demoandtest1.piccasso_glide_trans;

import android.content.Intent;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import appsoft.com.demoandtest1.R;

public class GlideStartActivity extends AppCompatActivity {

    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glide_start);

        img = findViewById(R.id.imagefrom);
        Glide.with(getApplicationContext())
                .load("https://i.ytimg.com/vi/mJaqhRLJ_7w/maxresdefault.jpg")
                .centerCrop()
                .into(img);

        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(GlideStartActivity.this, GlideEndActivity.class);
                ActivityOptionsCompat compat = ActivityOptionsCompat.makeSceneTransitionAnimation(
                        GlideStartActivity.this
                        ,img
                        , ViewCompat.getTransitionName(img)
                );
                startActivity(i, compat.toBundle());
            }
        });
    }
}