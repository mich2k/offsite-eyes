package it.ooproject.offsiteeyes.activities;

import android.app.VoiceInteractor;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.util.StringUtil;

import com.android.volley.Cache;
import com.android.volley.Network;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.textfield.TextInputLayout;
import com.google.gson.internal.bind.util.ISO8601Utils;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.NetworkInterface;
import java.net.URL;

import it.ooproject.offsiteeyes.R;

// https://maps.googleapis.com/maps/api/place/photo?maxwidth=1080&maxheight=1920&photoreference=ATtYBwIHWe9IsyuzCFWC98yus7LeOmZPk7_Q7ZrrKSCZPYrMxoeJnDd8aNIzrdtN6kliW745Qiw3zvmXFd2afP4T2fIRVc414UYpt5DAOcshngwUgI6HTo7cv7ZduwvBS9Nxq_Roh0bucVvMh1Frgq3vWyC9qSv7SIEGzd2_wTO_0UbQmQbf&key=AIzaSyAdDc5y6sbN-3Vk65MkNx0w62MjZXQHA4g

// https://maps.googleapis.com/maps/api/place/photo?maxwidth=1080&maxheight=1920&photoreference=ATtYBwIGXHSFnYqiYq6mD-uloybmRgEJnVGdj8PFmVngJaPczhQk5xedQNs19rofDOjZSlG5LKkD43qVt-GKS07KlD9WY5CkOyNdmklGhmV55J4kySGg_fMrvJK6PYI_Gux5gfRVIaXiv4jdP5lJbfu2LCFCkU4i0cjUEvJ5gvvIA4g0GtFO&key=AIzaSyAdDc5y6sbN-3Vk65MkNx0w62MjZXQHA4g
// https://maps.googleapis.com/maps/api/place/findplacefromtext/json?input=Napoli+Posillipo&inputtype=textquery&fields=photos,formatted_address,name&locationbias&key=AIzaSyAdDc5y6sbN-3Vk65MkNx0w62MjZXQHA4g
public class WelcomeActivity extends AppCompatActivity {
    private final String APIKey = "AIzaSyAdDc5y6sbN-3Vk65MkNx0w62MjZXQHA4g";
    private String stringURL;
    private TextInputLayout textInputCityOfArrival;
    private TextInputLayout textInputName;
    private Button btnNext;
    private RequestQueue reqQueue;
    private String city;

    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        btnNext = findViewById(R.id.btn_next_welcome);

        textInputCityOfArrival = findViewById(R.id.text_input_welcome_city);
        textInputName = findViewById(R.id.text_input_welcome_name);
        textInputCityOfArrival.getEditText().setText(city);


        //Toast.makeText(this, "req " + stringURL, Toast.LENGTH_SHORT).show();

        btnNext.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                Editable city = textInputCityOfArrival.getEditText().getText();
                Editable name = textInputName.getEditText().getText();
                if(city.length() == 0 || name.length() == 0){
                    Toast.makeText(WelcomeActivity.this, "Questi due campi non possono essere vuoti", Toast.LENGTH_SHORT).show();

                }else {
                    if(city.chars().allMatch(Character::isLetter) && name.chars().allMatch(Character::isLetter)) {
                        Intent intent = new Intent(WelcomeActivity.this, AppIntroductionActivity.class);
                        intent.putExtra("city_arrival_name", textInputCityOfArrival.getEditText().getText());
                        intent.putExtra("user_name", textInputName.getEditText().getText());
                        changeActivityOnClickHandler(getApplicationContext(), AppIntroductionActivity.class);
                    }else{
                        Toast.makeText(WelcomeActivity.this, "Non sono accettati numeri/simboli", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    public void changeActivityOnClickHandler(Context ctx, Class<?> cls) {
        startActivity(new Intent(ctx, cls));
        overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
    }

}