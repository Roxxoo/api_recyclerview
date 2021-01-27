package com.example.api_recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toolbar;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.tabs.TabLayout;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

//todo

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Toolbar toolbar;
        ViewPager viewPager;
        TabLayout tabLayout;

        RecyclerFragment recyclerFragment;
        ProfileActivity profileActivity;


        super.onCreate(savedInstanceState);
        this.getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        recyclerFragment = new RecyclerFragment();
        profileActivity = new ProfileActivity();
        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);

        ViewPager_Adapter adapter = new ViewPager_Adapter(getSupportFragmentManager(), 0);
        adapter.addFragment(recyclerFragment, "Recycler");
        adapter.addFragment(profileActivity, "Profile");
        
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

    }


}

