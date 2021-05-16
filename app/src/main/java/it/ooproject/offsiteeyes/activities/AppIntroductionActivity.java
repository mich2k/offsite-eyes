package it.ooproject.offsiteeyes.activities;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Cache;
import com.android.volley.Network;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import it.ooproject.offsiteeyes.R;

public class AppIntroductionActivity extends AppCompatActivity {
    RequestQueue reqQueue;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_appintroduction);

        reqQueue = Volley.newRequestQueue(this);

    }


    private String requestServ(String url, final VolleyResponse volleyResponse) {
        RequestQueue requestQueue;
        Cache cache;
        Network network;
        String response;

        cache = new DiskBasedCache(getCacheDir(), 1024 * 1024); // 1MB cap

        network = new BasicNetwork(new HurlStack());

        requestQueue = new RequestQueue(cache, network);

        requestQueue.start();


        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        volleyResponse.onSuccess(response);

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) { // Error Handling
                        Toast.makeText(AppIntroductionActivity.this, "Impossibile comunicare con Google Places", Toast.LENGTH_SHORT).show();
                        Log.e("GOOGLE API ERROR", "Error with google api onResponse");
                        volleyResponse.onError(error);
                        error.printStackTrace();
                    }
                });

        requestQueue.add(stringRequest);

        return null;
    }

    public interface VolleyResponse {
        void onSuccess(String result);

        void onError(VolleyError error);
    }
}