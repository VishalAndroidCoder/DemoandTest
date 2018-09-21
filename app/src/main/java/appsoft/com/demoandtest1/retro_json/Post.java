package appsoft.com.demoandtest1.retro_json;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Post {

    @SerializedName("username")
    String username;
    @SerializedName("password")
    String password;
    @SerializedName("res")
    String res;

    public Post(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Post(String res) {
        this.res = res;
    }

    public String getRes() {
        return res;
    }

    public void setRes(String res) {
        this.res = res;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
