package com.example.promactfinalassessmentproject;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ShowUsers extends AppCompatActivity {

    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_users);

        RequestQueue mQueue = Volley.newRequestQueue(this);
        mTextView = findViewById(R.id.text_view);

        String url = "https://jsonplaceholder.typicode.com/users";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                response -> {
                    try {
                        JSONArray jsonArray = response.getJSONArray("users");

                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject user = jsonArray.getJSONObject(i);

                            int id = user.getInt("id");
                            String name = user.getString("name");
                            String email = user.getString("email");

                            mTextView.append(id + ", " + name + ", " + email + "\n\n");
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }, error -> Log.e("Error", error.getMessage()));

        mQueue.add(request);
    }
}