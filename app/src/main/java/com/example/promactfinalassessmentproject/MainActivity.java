package com.example.promactfinalassessmentproject;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.android.volley.Request;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    // Declare the EditText fields and the button
    private EditText nameEditText;
    private EditText userNameEditText;
    private EditText emailEditText;
    private EditText phoneEditText;
    private EditText webUrlEditText;
    private EditText streetNameEditText;
    private EditText suiteNameEditText;
    private EditText cityNameEditText;
    private EditText zipcodeEditText;
    private EditText companyName;
    private EditText catchPhrase;
    private EditText bs;
    private AppCompatButton post_btn;
    private  AppCompatButton user_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Upload Data");

        // Initialize the EditText fields and the button
        nameEditText = findViewById(R.id.name);
        userNameEditText = findViewById(R.id.user_name);
        emailEditText = findViewById(R.id.email);
        phoneEditText = findViewById(R.id.label_phone);
        webUrlEditText = findViewById(R.id.label_web_url);
        streetNameEditText = findViewById(R.id.label_street_name);
        suiteNameEditText = findViewById(R.id.label_suite_name);
        cityNameEditText = findViewById(R.id.label_city_name);
        zipcodeEditText = findViewById(R.id.label_zipcode);
        companyName = findViewById(R.id.label_company_name);
        catchPhrase = findViewById(R.id.label_catch_phrase);
        bs = findViewById(R.id.label_bs);
        post_btn = findViewById(R.id.post_btn);
        user_list = findViewById(R.id.user_list);

        user_list.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, ShowUsers.class);
            startActivity(intent);
        });


        // Set an onClickListener to the button
        post_btn.setOnClickListener(v -> {
            // Get the values of the EditText fields
            String name = nameEditText.getText().toString();
            String userName = userNameEditText.getText().toString();
            String email = emailEditText.getText().toString();
            String phone = phoneEditText.getText().toString();
            String webUrl = webUrlEditText.getText().toString();
            String streetName = streetNameEditText.getText().toString();
            String suiteName = suiteNameEditText.getText().toString();
            String cityName = cityNameEditText.getText().toString();
            String zipcode = zipcodeEditText.getText().toString();
            String companyNameText = companyName.getText().toString();
            String catchPhraseText = catchPhrase.getText().toString();
            String bsText = bs.getText().toString();

            // Create a JSONObject with the values of the EditText fields
            JSONObject postData = new JSONObject();
            try {
                postData.put("name", name);
                postData.put("username", userName);
                postData.put("email", email);

                JSONObject addressData = new JSONObject();
                addressData.put("street", streetName);
                addressData.put("suite", suiteName);
                addressData.put("city", cityName);
                addressData.put("zipcode", zipcode);

                postData.put("address", addressData);

                postData.put("phone", phone);
                postData.put("website", webUrl);

                JSONObject companyData = new JSONObject();
                companyData.put("name", companyNameText);
                companyData.put("catchPhrase", catchPhraseText);
                companyData.put("bs", bsText);

                postData.put("company", companyData);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            // Create a JsonObjectRequest with the POST method and the postData
            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, "https://jsonplaceholder.typicode.com/users", postData,
                    response -> {
                        Log.d("Response", response.toString());
                        Toast.makeText(MainActivity.this, "Data uploaded successfully", Toast.LENGTH_SHORT).show();
                    }, error -> {
                Log.e("Error", error.toString());
                Toast.makeText(MainActivity.this, "Error uploading data", Toast.LENGTH_SHORT).show();
            });
            Volley.newRequestQueue(MainActivity.this).add(jsonObjectRequest);
        });

    }
}