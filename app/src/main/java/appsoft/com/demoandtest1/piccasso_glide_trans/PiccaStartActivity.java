package appsoft.com.demoandtest1.piccasso_glide_trans;

import android.content.Intent;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import appsoft.com.demoandtest1.R;

public class PiccaStartActivity extends AppCompatActivity {

    private ImageView image;
    private Button btnOk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picca_start);
        image = findViewById(R.id.image);
        btnOk = findViewById(R.id.ok);
        loadIntoPiccasa();
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(PiccaStartActivity.this, PiccaEndActivity.class);
                ActivityOptionsCompat opt = ActivityOptionsCompat
                        .makeSceneTransitionAnimation(PiccaStartActivity.this, image, ViewCompat.getTransitionName(image));
                startActivity(i, opt.toBundle());
            }
        });
    }

    private void loadIntoPiccasa(){
        Picasso.get()
                .load("https://i.ytimg.com/vi/mJaqhRLJ_7w/maxresdefault.jpg")
                .fit()
                .noFade()
                .into(image, new Callback() {
                    @Override
                    public void onSuccess() {

                    }

                    @Override
                    public void onError(Exception e) {

                    }
                });
    }
}
