package it.ooproject.offsiteeyes.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.google.android.material.textfield.TextInputLayout;

import it.ooproject.offsiteeyes.R;


/**
 * <p>This activity is shown only on first boot, in this version of the app
 * it collects the city of interest and the name of the user, its focus is to
 * create a dynamic behaviour.
 * These data can be useful in future potential releases or also only for concept.
 * These data can also improve the potential ux/p>
 *
 * {@link #getUserWelcomeCity() returns the user city gave by input at first boot}
 * {@link #getUserWelcomeName() returns the user name gave by input at first boot}
 *
 */


// https://maps.googleapis.com/maps/api/place/photo?maxwidth=1080&maxheight=1920&photoreference=ATtYBwIHWe9IsyuzCFWC98yus7LeOmZPk7_Q7ZrrKSCZPYrMxoeJnDd8aNIzrdtN6kliW745Qiw3zvmXFd2afP4T2fIRVc414UYpt5DAOcshngwUgI6HTo7cv7ZduwvBS9Nxq_Roh0bucVvMh1Frgq3vWyC9qSv7SIEGzd2_wTO_0UbQmQbf&key=AIzaSyAdDc5y6sbN-3Vk65MkNx0w62MjZXQHA4g

// https://maps.googleapis.com/maps/api/place/photo?maxwidth=1080&maxheight=1920&photoreference=ATtYBwIGXHSFnYqiYq6mD-uloybmRgEJnVGdj8PFmVngJaPczhQk5xedQNs19rofDOjZSlG5LKkD43qVt-GKS07KlD9WY5CkOyNdmklGhmV55J4kySGg_fMrvJK6PYI_Gux5gfRVIaXiv4jdP5lJbfu2LCFCkU4i0cjUEvJ5gvvIA4g0GtFO&key=AIzaSyAdDc5y6sbN-3Vk65MkNx0w62MjZXQHA4g
// https://maps.googleapis.com/maps/api/place/findplacefromtext/json?input=Napoli+Posillipo&inputtype=textquery&fields=photos,formatted_address,name&locationbias&key=AIzaSyAdDc5y6sbN-3Vk65MkNx0w62MjZXQHA4g
public class WelcomeActivity extends AppCompatActivity {
    private TextInputLayout textInputCityOfArrival;
    private TextInputLayout textInputName;
    private Button btnNext;
    private RequestQueue reqQueue;
    private Editable txteditCity;
    private Editable txteditName;
    private SharedPreferences welcomeSharedPrefData;
    private static String userWelcomeName;
    private static String userWelcomeCity;

    public static String getUserWelcomeName() {
        return userWelcomeName;
    }

    public static String getUserWelcomeCity() {
        return userWelcomeCity;
    }


    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        welcomeSharedPrefData = getSharedPreferences("WelcomeActivity", 0);


        setContentView(R.layout.activity_welcome);



        btnNext = findViewById(R.id.btn_wmachine_calculate);

        textInputCityOfArrival = findViewById(R.id.txtInput_3);
        textInputName = findViewById(R.id.text_input_welcome_name);
        textInputCityOfArrival.getEditText().setText(txteditCity);


        btnNext.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                txteditCity = textInputCityOfArrival.getEditText().getText();
                txteditName = textInputName.getEditText().getText();
                if(txteditCity.length() == 0 || txteditName.length() == 0){
                    Toast.makeText(WelcomeActivity.this, "Questi due campi non possono essere vuoti", Toast.LENGTH_SHORT).show();

                }else {
                    if(txteditCity.chars().allMatch(Character::isLetter) && txteditName.chars().allMatch(Character::isLetter)) {
                        Intent intent = new Intent(WelcomeActivity.this, AppIntroductionActivity.class);
                        intent.putExtra("city_arrival_name", textInputCityOfArrival.getEditText().getText());
                        intent.putExtra("user_name", textInputName.getEditText().getText());

                        try
                        {
                            saveData();
                        }catch(Exception e){
                            e.printStackTrace();
                            Toast.makeText(WelcomeActivity.this, "fatal error (sharedPreferences)", Toast.LENGTH_SHORT).show();
                            return;
                        }


                        changeActivityOnClickHandler(getApplicationContext(), HomeActivity.class);
                    }else{
                        Toast.makeText(WelcomeActivity.this, "Non sono accettati numeri/simboli", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    private void saveData() throws RuntimeException{

        SharedPreferences.Editor editor = welcomeSharedPrefData.edit();
        userWelcomeCity = txteditCity.toString();
        userWelcomeName = txteditName.toString();


        editor.putString("Welcome_User_City", userWelcomeCity);
        editor.putString("Welcome_User_Name", userWelcomeName);
        editor.putBoolean("First_Boot", false);

        if(editor.commit() != true){
            throw new RuntimeException();
        }

    }


    public void changeActivityOnClickHandler(Context ctx, Class<?> cls) {
        startActivity(new Intent(ctx, cls));
        overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
    }

}