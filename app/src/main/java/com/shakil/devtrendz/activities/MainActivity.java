package com.shakil.devtrendz.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import com.shakil.devtrendz.R;
import com.shakil.devtrendz.databinding.ActivityMainBinding;
import com.shakil.devtrendz.drawerextra.DrawerAdapter;
import com.shakil.devtrendz.drawerextra.DrawerItem;
import com.shakil.devtrendz.drawerextra.SimpleItem;
import com.shakil.devtrendz.drawerextra.SpaceItem;
import com.shakil.devtrendz.fragments.FragmentUIComponents;
import com.yarolegovich.slidingrootnav.SlidingRootNav;
import com.yarolegovich.slidingrootnav.SlidingRootNavBuilder;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private SlidingRootNav slidingRootNav ;
    private ActivityMainBinding activityMainBinding;
    private DrawerAdapter adapter;
    private String[] screenTitles;
    private Drawable[] screenIcons;
    private RecyclerView list;
    private static final int POS_UI_COMPONENTS = 0;
    private static final int POS_DRAWING = 1;
    private static final int POS_IMAGE_PROCESSING = 2;
    private static final int POS_SCANNING = 3;
    private static final int POS_BINDING = 4;
    private static final int POS_DEBUGGING = 5;
    private static final int POS_EASY_NAVIGATION = 6;
    private static final int POS_RECYCLER_VIEW = 7;
    private static final int POS_LIST_VIEW = 8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = DataBindingUtil.setContentView(this , R.layout.activity_main);

        setSupportActionBar(activityMainBinding.toolBar);

        init(savedInstanceState);
        bindUIWithComponents();
    }


    private void init(Bundle savedInstanceState) {
        slidingRootNav  = new SlidingRootNavBuilder(this)
                .withToolbarMenuToggle(activityMainBinding.toolBar)
                .withMenuOpened(false)
                .withContentClickableWhenMenuOpened(true)
                .withSavedState(savedInstanceState)
                .withMenuLayout(R.layout.menu)
                .inject();

        screenIcons = loadScreenIcons();
        screenTitles = loadScreenTitles();
    }

    private void setAdapter() {
        list = findViewById(R.id.nav_list_item);
        adapter = new DrawerAdapter(Arrays.asList(
                createItemFor(POS_UI_COMPONENTS).setChecked(true),
                createItemFor(POS_DRAWING),
                createItemFor(POS_IMAGE_PROCESSING),
                createItemFor(POS_SCANNING),
                createItemFor(POS_BINDING),
                createItemFor(POS_DEBUGGING),
                createItemFor(POS_EASY_NAVIGATION),
                createItemFor(POS_RECYCLER_VIEW),
                createItemFor(POS_LIST_VIEW)));

        list.setNestedScrollingEnabled(false);
        list.setLayoutManager(new LinearLayoutManager(this));
        list.setAdapter(adapter);

        adapter.setSelected(POS_UI_COMPONENTS);
    }

    private void showFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.fadein,R.anim.fadeout);
        fragmentTransaction.replace(R.id.container, fragment)
                .commit();
    }

    private DrawerItem createItemFor(int position) {
        return new SimpleItem(screenIcons[position], screenTitles[position])
                .withTextTint(getResources().getColor(R.color.md_blue_grey_700))
                .withSelectedTextTint(getResources().getColor(R.color.md_grey_900));
    }

    private void bindUIWithComponents() {


        setAdapter();
        adapter.setListener(new DrawerAdapter.OnItemSelectedListener() {
            @Override
            public void onItemSelected(int position) {
                final int pos = position;
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (pos == POS_UI_COMPONENTS) {
                            showFragment(FragmentUIComponents.getInstance());
                            return;
                        }
                    }
                },5);

                slidingRootNav.closeMenu();

            }
        });
        FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.container,new FragmentUIComponents());
        fragmentTransaction.commit();
    }

    private String[] loadScreenTitles() {
        return getResources().getStringArray(R.array.ld_activityScreenTitles);
    }

    private Drawable[] loadScreenIcons() {
        TypedArray ta = getResources().obtainTypedArray(R.array.ld_activityScreenIcons);
        Drawable[] icons = new Drawable[ta.length()];
        for (int i = 0; i < ta.length(); i++) {
            int id = ta.getResourceId(i, 0);
            if (id != 0) {
                icons[i] = ContextCompat.getDrawable(this, id);
            }
        }
        ta.recycle();
        return icons;
    }

    public void exitApp(){
        Intent exitIntent = new Intent(Intent.ACTION_MAIN);
        exitIntent.addCategory(Intent.CATEGORY_HOME);
        exitIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        this.startActivity(exitIntent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        exitApp();
    }
}
