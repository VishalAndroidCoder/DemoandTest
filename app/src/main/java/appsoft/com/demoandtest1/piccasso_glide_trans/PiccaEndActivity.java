package appsoft.com.demoandtest1.piccasso_glide_trans;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import appsoft.com.demoandtest1.R;

public class PiccaEndActivity extends AppCompatActivity {

    private ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picca_end);

        img= findViewById(R.id.image);

        supportPostponeEnterTransition();

        Picasso.get()
                .load("https://i.ytimg.com/vi/mJaqhRLJ_7w/maxresdefault.jpg")
                .fit()
                .noFade()
                .into(img, new Callback() {
                    @Override
                    public void onSuccess() {
                        supportStartPostponedEnterTransition();
                    }

                    @Override
                    public void onError(Exception e) {
                        supportStartPostponedEnterTransition();
                    }
                });
    }
}
