package appsoft.com.demoandtest1.custom_nav_bar;

import android.content.res.Configuration;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import appsoft.com.demoandtest1.R;
import appsoft.com.demoandtest1.custom_nav_bar.adapter.CustomExpandableListAdapter;
import appsoft.com.demoandtest1.custom_nav_bar.helper.FragmentNavigationManager;
import appsoft.com.demoandtest1.custom_nav_bar.interfaces.NavigationManager;

public class StartingActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private String activityTitle;
    private String[] items;
    private ExpandableListView expandableListView;
    private ExpandableListAdapter adapter;
    private List<String> lstTitle;
    private Map<String, List<String>> lstChild;
    private NavigationManager navigationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starting);
        // Init all views
        initAllView();
        initItem();
        addHeaderView();
        generateData();
        addDrawerItem();
        setupDrawer();

        if (savedInstanceState == null){
            selectFirstItemAsSelected();
        }

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle("Nav App");
    }

    @Override
    public void onPostCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onPostCreate(savedInstanceState, persistentState);
        actionBarDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        actionBarDrawerToggle.onConfigurationChanged(newConfig);
    }

    private void selectFirstItemAsSelected() {
        if (navigationManager != null){
            String firstItem = lstTitle.get(0);
            navigationManager.showFragment(firstItem);
            getSupportActionBar().setTitle(firstItem);
        }
    }

    private void setupDrawer() {

        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close){

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                //getSupportActionBar().setTitle("Nav App");
                invalidateOptionsMenu();
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                //getSupportActionBar().setTitle(activityTitle);
                invalidateOptionsMenu();
            }
        };

        actionBarDrawerToggle.setDrawerIndicatorEnabled(true);
        drawerLayout.setDrawerListener(actionBarDrawerToggle);
    }

    private void addDrawerItem() {

        adapter = new CustomExpandableListAdapter(this, lstTitle, lstChild);
        expandableListView.setAdapter(adapter);

        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {
                getSupportActionBar().setTitle(lstTitle.get(groupPosition));
            }
        });

        expandableListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
            @Override
            public void onGroupCollapse(int groupPosition) {
                getSupportActionBar().setTitle("Nav App");
            }
        });

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {

                String selectedItem = ((List) (lstChild.get(lstTitle.get(groupPosition))))
                        .get(childPosition).toString();

                getSupportActionBar().setTitle(selectedItem);

                if (items[groupPosition].equals(lstTitle.get(groupPosition))){
                    navigationManager.showFragment(selectedItem);
                }else{
                    throw new IllegalArgumentException("Fragment not supported Exception");
                }

                drawerLayout.closeDrawer(Gravity.START);
                return false;
            }
        });
    }

    private void generateData() {

        List<String> headTitle = Arrays.asList("Ionic Framework", "Android Studio", "Visual Studio");
        List<String> childTitleOne = Arrays.asList("Angular","Cordova","NodeJS");
        List<String> childTitleTwo = Arrays.asList("XML","Java","Oops");
        List<String> childTitleThree = Arrays.asList(".net","C#");

        lstChild = new TreeMap<>();
        lstChild.put(headTitle.get(0), childTitleOne);
        lstChild.put(headTitle.get(1), childTitleTwo);
        lstChild.put(headTitle.get(2), childTitleThree);

        lstTitle = new ArrayList<>(lstChild.keySet());
    }

    private void addHeaderView() {
        View listHeaderView = getLayoutInflater().inflate(R.layout.custom_nav_header, null, false);
        expandableListView.addHeaderView(listHeaderView);
    }

    private void initItem() {

        items = new String[]{"Ionic Framework", "Android Studio", "Visual Studio"};

    }

    private void initAllView() {
        drawerLayout = findViewById(R.id.drawer);
        activityTitle = getTitle().toString();
        expandableListView = findViewById(R.id.navList);
        navigationManager = FragmentNavigationManager.getmInstance(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.nav_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        return super.onOptionsItemSelected(item);
    }
}
