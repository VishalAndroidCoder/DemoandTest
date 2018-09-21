package appsoft.com.demoandtest1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView appList;
    List<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        appList = findViewById(R.id.app_list);
        list = ListArrayText.getList();
        ListAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);
        appList.setAdapter(adapter);

        appList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        Intent intent = new Intent(MainActivity.this, OkHttpActivity.class);
                        startActivity(intent);
                        break;
                    case 1:

                        break;
                    case 2:

                        break;
                    default:

                        break;
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.exit){
            finish();
            return true;
        }
        return false;
    }

    @Override
    protected void onPause() throws UnsupportedOperationException{
        super.onPause();
        list.clear();
    }

    @Override
    protected void onStop() {
        super.onStop();
        list.clear();
    }
}