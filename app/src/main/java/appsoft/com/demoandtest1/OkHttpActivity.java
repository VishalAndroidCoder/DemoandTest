package appsoft.com.demoandtest1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OkHttpActivity extends AppCompatActivity {

    private TextView responseString;
    private String url= "https://reqres.in/api/users/2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ok_http_activity);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        responseString = findViewById(R.id.textResponse);
        try {
            myfun();
        }catch (IOException e){
            Log.i("DEBUG", e.toString());
        }
    }

    public void myfun() throws IOException{
        OkHttpClient client = new OkHttpClient();
        final Request request = new Request.Builder()
                .url(url)
                .build();

        final ProgressBar progress = findViewById(R.id.progressBar);
        progress.setVisibility(View.VISIBLE);

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        progress.setVisibility(View.GONE);
                    }
                });
                call.cancel();
            }

            @Override
            public void onResponse(Call call, final Response response) throws NullPointerException {
                if (response.isSuccessful()){
                    Log.i("DEBUG", response.toString());
                    runOnUiThread(new Runnable(){
                        @Override
                        public void run() {
                            progress.setVisibility(View.GONE);
                            responseString.setText("Welcome: "+response.body());
                        }
                    });
                }
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            finish();
            return true;
        }
        return false;
    }

    @Override
    protected void onPause() {
        super.onPause();
    }
}

