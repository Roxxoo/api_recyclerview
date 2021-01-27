package com.example.api_recyclerview;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class RecyclerFragment extends Fragment {
    RecyclerView recyclerView;
    ArrayList<Users> user_list = new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View v = inflater.inflate(R.layout.frag_recycler,container, false);
        recyclerView = v.findViewById(R.id.recyclerview2);
        parseData();

       return v;
    }

    public void parseData(){
        String url = "https://reqres.in/api/users/";
        RequestQueue request = Volley.newRequestQueue(getActivity());
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
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                Recycler_Adapter adapter = new Recycler_Adapter(getActivity(), user_list);
                recyclerView.setAdapter(adapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

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
