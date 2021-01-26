package com.example.api_recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<Users> user_list = new ArrayList<>();
//todo

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerview2);
        Log.d("Userlist Tag: ", "Number of users: " + user_list.size());
        parseData();


//        recyclerView.setAdapter(adapter);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    //The parsedata function is not working remove all of it and try again

    public void parseData(){
        String url = "https://reqres.in/api/users/";
        RequestQueue request = Volley.newRequestQueue(this);

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray jsonArray = response.getJSONArray("data");
                    for(int i = 0; i < jsonArray.length(); i++){
                        JSONObject user_object = jsonArray.getJSONObject(i);
                        Users user_add = new Users();
                        Log.d("fname", "First name: " + user_object.getString("first_name"));
                        user_add.setFname(user_object.getString("first_name"));
                        user_add.setLname(user_object.getString("last_name"));
                        user_add.setEmail(user_object.getString("email"));
                        user_add.setImg_url(user_object.getString("avatar"));
                        user_list.add(user_add);
                    }
                    Recycler_Adapter adapter = new Recycler_Adapter(getApplicationContext(), user_list);
                    recyclerView.setAdapter(adapter);
                    recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        request.add(jsonObjectRequest);

    }

}