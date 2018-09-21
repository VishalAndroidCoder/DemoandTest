package appsoft.com.demoandtest1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import appsoft.com.demoandtest1.models.Assignment;
import appsoft.com.demoandtest1.retrofit_assign.ClientApi;
import appsoft.com.demoandtest1.retrofit_assign.RetroApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class IsyncAssignmentActivity extends AppCompatActivity {

    private TextView text_assignment;
    private Button button_assignment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_isync_assignment);
        text_assignment = findViewById(R.id.assignment_text);
        button_assignment = findViewById(R.id.assignment_button);

        RetroApi api = ClientApi.getRetrofit().create(RetroApi.class);
        Call<List<Assignment>> call = api.getStudentAssignmentList(10004);
        call.enqueue(new Callback<List<Assignment>>() {
            @Override
            public void onResponse(Call<List<Assignment>> call, Response<List<Assignment>> response) {
                try{
                    List<Assignment> list = response.body();
                    StringBuilder builder = new StringBuilder();
                    builder.append(list.get(0).getSubject());
                    builder.append("\n");
                    builder.append(list.get(0).getTitle());
                    text_assignment.setText(builder.toString());
                }catch (NullPointerException npe){
                    Toast.makeText(IsyncAssignmentActivity.this, "Exception Occuered", Toast.LENGTH_SHORT).show();
                }catch (Exception exp){
                    Toast.makeText(IsyncAssignmentActivity.this, "Null Occured", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Assignment>> call, Throwable t) {
                Toast.makeText(IsyncAssignmentActivity.this, "Failure Occured", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
