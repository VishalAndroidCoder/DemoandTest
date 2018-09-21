package appsoft.com.demoandtest1.retrofit_assign;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ClientApi {

    public static final String BASE_URL = "https://isyncerp.com/app_rest/"; //https://eastpointschool.in/app_rest/
    public static final String USERNAME = "admin";
    public static final String PASSWORD = "1234";

    private static Retrofit retrofit = null;
    private static Gson gson = new GsonBuilder().setLenient().create();

    public static Retrofit getRetrofit() {
        final OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new BasicAuthInterceptor(USERNAME, PASSWORD))
                .connectTimeout(30000, TimeUnit.SECONDS)
                .readTimeout(30000, TimeUnit.SECONDS)
                .writeTimeout(30000, TimeUnit.SECONDS)
                .build();

        if (retrofit == null) {
            retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .client(okHttpClient)
                    .build();
        }
        return retrofit;
    }
}
