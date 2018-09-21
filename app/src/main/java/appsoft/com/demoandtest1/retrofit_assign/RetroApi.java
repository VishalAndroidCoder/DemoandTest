package appsoft.com.demoandtest1.retrofit_assign;

import java.util.List;

import appsoft.com.demoandtest1.models.Assignment;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RetroApi {

    @GET("parents/assignment/{student_id}")
    Call<List<Assignment>> getStudentAssignmentList(@Path("student_id") int student_id);
}
