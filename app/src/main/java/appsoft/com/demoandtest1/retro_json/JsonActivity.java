package appsoft.com.demoandtest1.retro_json;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import org.json.JSONException;
import org.json.JSONObject;

import appsoft.com.demoandtest1.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class JsonActivity extends AppCompatActivity {

    private EditText userName, passWord;
    private Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json);

        save = findViewById(R.id.save);
        userName = findViewById(R.id.etUsername);
        passWord = findViewById(R.id.etPassword);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                JSONObject object = new JSONObject();
                try {
                    object.put("username", userName.getText().toString());
                    object.put("password", passWord.getText().toString());
                    Log.i("DEBUG", "JSON: "+object.toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                RetroApi retroApi = ClientApi.getRetrofit().create(RetroApi.class);
                Call<Post> call = retroApi.savePost(object);

                call.enqueue(new Callback<Post>() {
                    @Override
                    public void onResponse(Call<Post> call, Response<Post> response) {

                        //Log.i("DEBUG", "Response: "+response.toString());
                        if (response.isSuccessful()){
                            Post res = response.body();
                            Toast.makeText(getApplicationContext(), "Response: "+res.getRes(), Toast.LENGTH_SHORT).show();
                            Log.i("DEBUG", "Response: " + response.toString());
                        }else{
                            Toast.makeText(getApplicationContext(), "Data not posted.", Toast.LENGTH_SHORT).show();
                            Log.i("DEBUG", "Response: "+response.toString());
                        }
                    }

                    @Override
                    public void onFailure(Call<Post> call, Throwable t) {
                        Log.i("DEBUG", "Response Failure: "+t.toString());
                    }
                });
            }
        });
    }
}