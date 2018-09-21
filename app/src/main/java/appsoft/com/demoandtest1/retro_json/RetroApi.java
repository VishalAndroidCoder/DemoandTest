package appsoft.com.demoandtest1.retro_json;

import org.json.JSONObject;

import java.util.List;

import appsoft.com.demoandtest1.models.Assignment;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface RetroApi {

    @POST("posts/login.php")
    @FormUrlEncoded
    Call<Post> savePost(@Field("json_str") JSONObject json_str);
}
