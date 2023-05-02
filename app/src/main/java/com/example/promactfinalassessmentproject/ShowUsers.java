package com.example.promactfinalassessmentproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;

public class ShowUsers extends AppCompatActivity {

    private List<User> userList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_users);
        setTitle("User List");
        userList = new ArrayList<>();

        String url = "https://jsonplaceholder.typicode.com/users";

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(
                Request.Method.GET,
                url,
                null,
                response -> {
                    try {
                        for (int i = 0; i < response.length(); i++) {
                            JSONObject jsonObject = response.getJSONObject(i);
                            int id = jsonObject.getInt("id");
                            String name = jsonObject.getString("name");
                            String username = jsonObject.getString("username");
                            String email = jsonObject.getString("email");
                            String phone = jsonObject.getString("phone");

                            JSONObject addressObj = jsonObject.getJSONObject("address");
                            String street = addressObj.getString("street");
                            String suite = addressObj.getString("suite");
                            String city = addressObj.getString("city");
                            String zipcode = addressObj.getString("zipcode");

                            JSONObject companyObj = jsonObject.getJSONObject("company");
                            String companyName = companyObj.getString("name");
                            String catchPhrase = companyObj.getString("catchPhrase");
                            String bs = companyObj.getString("bs");

                            User user = new User(id, name, username, email, phone, street, suite, city, zipcode, companyName, catchPhrase, bs);
                            userList.add(user);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    // Do something with userList here
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                    }
                }
        );

        Volley.newRequestQueue(this).add(jsonArrayRequest);
    }

    private static class User {
        private int id;
        private String name;
        private String username;
        private String email;
        private String phone;
        private String street;
        private String suite;
        private String city;
        private String zipcode;
        private String companyName;
        private String catchPhrase;
        private String bs;

        public User(int id, String name, String username, String email, String phone, String street, String suite, String city, String zipcode, String companyName, String catchPhrase, String bs) {
            this.id = id;
            this.name = name;
            this.username = username;
            this.email = email;
            this.phone = phone;
            this.street = street;
            this.suite = suite;
            this.city = city;
            this.zipcode = zipcode;
            this.companyName = companyName;
            this.catchPhrase = catchPhrase;
            this.bs = bs;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getStreet() {
            return street;
        }

        public void setStreet(String street) {
            this.street = street;
        }

        public String getSuite() {
            return suite;
        }

        public void setSuite(String suite) {
            this.suite = suite;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getZipcode() {
            return zipcode;
        }

        public void setZipcode(String zipcode) {
            this.zipcode = zipcode;
        }

        public String getCompanyName() {
            return companyName;
        }

        public void setCompanyName(String companyName) {
            this.companyName = companyName;
        }

        public String getCatchPhrase() {
            return catchPhrase;
        }

        public void setCatchPhrase(String catchPhrase) {
            this.catchPhrase = catchPhrase;
        }

        public String getBs() {
            return bs;
        }

        public void setBs(String bs) {
            this.bs = bs;
        }

        // Getters and setters here
    }
}