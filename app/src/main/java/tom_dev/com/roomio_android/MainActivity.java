package tom_dev.com.roomio_android;

import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import java.util.ArrayList;
import android.support.v4.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private DrawerLayout drawer;
    private RecyclerView recyclerView;
    private MateAdapter mateAdapter;

    private Utility util;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        util = new Utility(this);

        // setup drawer layout
        drawer = (DrawerLayout)findViewById(R.id.drawer_layout);

        // setup custom tool bar
        toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);

        // add navigation drawer button
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.ic_menu);

        // recycler view in nav drawer
        recyclerView = (RecyclerView)findViewById(R.id.drawerRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ArrayList<Mate> mates = new ArrayList<Mate>();
        mateAdapter = new MateAdapter(this, mates);
        recyclerView.setAdapter(mateAdapter);

        // setup initial home fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        HomeFragment fragment = new HomeFragment();
        transaction.replace(R.id.fragment_container, fragment).commit();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawer.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}
