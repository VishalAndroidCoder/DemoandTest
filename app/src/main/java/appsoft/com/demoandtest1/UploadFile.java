package appsoft.com.demoandtest1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class UploadFile extends AppCompatActivity {

    private ImageView image;
    private EditText name;
    private Button send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_file);

        image = findViewById(R.id.image);
        name = findViewById(R.id.name);
        send = findViewById(R.id.send);


    }
}
