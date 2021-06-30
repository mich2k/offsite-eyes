package it.ooproject.offsiteeyes.activities;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import it.ooproject.offsiteeyes.R;

import com.google.android.material.textfield.TextInputLayout;

public class WashingMachineActivity extends AppCompatActivity {
    private TextInputLayout baseQuantity;
    private TextInputLayout degreeWaterHardness;
    // radio buttons for the capacity, identified in order
    private RadioButton radioButtonSelected;
    private Button btnCalculate;
    private RadioGroup radioCapacityGroup;
    private TextView txtResult;

    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_washingmachine);

        txtResult = findViewById(R.id.txtView_result);

        txtResult.setVisibility(View.INVISIBLE);

        onRadioButtonClicked();


    }


    public void onRadioButtonClicked() {
        baseQuantity = findViewById(R.id.txtInput_3);
        degreeWaterHardness = findViewById(R.id.txtInput_1);
        radioCapacityGroup = (RadioGroup) findViewById(R.id.radioGrpupCapacity);
        btnCalculate = (Button) findViewById(R.id.btn_wmachine_calculate);

        btnCalculate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(baseQuantity.getEditText().getText().length() == 0 || degreeWaterHardness.getEditText().getText().length() == 0){
                    Toast.makeText(WashingMachineActivity.this, "Verifica di aver inserito tutti i dati", Toast.LENGTH_SHORT).show();
                }else {

                    if(  !TextUtils.isDigitsOnly(baseQuantity.getEditText().getText()) ||  !TextUtils.isDigitsOnly(degreeWaterHardness.getEditText().getText())){
                        /*
                         * since in .xml the EditText has 'input type = number' attribute this should already be a safe/checked case
                         */
                        Toast.makeText(WashingMachineActivity.this, "Sono ammessi solo valori numerici", Toast.LENGTH_SHORT).show();
                    }else{

                    // radioCapacityGroup.check(); could also be possible to set default 4/5 kg radio button (hint=1)

                    int selectedId = radioCapacityGroup.getCheckedRadioButtonId();

                    // find the radiobutton by returned id

                    radioButtonSelected = (RadioButton) findViewById(selectedId);


                    if( radioButtonSelected == null ){
                        Toast.makeText(WashingMachineActivity.this, "Seleziona anche la capacità", Toast.LENGTH_SHORT).show();
                    }else {

                        int ml_equivalent = -1;
                        int water_degrees = -1;
                        int result = -1;

                        try {
                            ml_equivalent = Integer.parseInt(baseQuantity.getEditText().getText().toString());
                            water_degrees = Integer.parseInt(degreeWaterHardness.getEditText().getText().toString());

                        }catch (NumberFormatException e){
                            Toast.makeText(WashingMachineActivity.this, "Parsing Error", Toast.LENGTH_SHORT).show();
                            e.printStackTrace();
                        }

                        // legit input

                        /*
                          HINTS: (.getHint()) defined in .xml activity
                         * 1 - 5/6 kg
                         * 2 - 5/7 kg
                         * 3 - 8/10 kg
                         */



                        if(water_degrees < 15){
                            result = ml_equivalent;

                        }else{
                            if(water_degrees < 25){
                                result = ml_equivalent * 2;

                            }else{
                                if(water_degrees > 25 && water_degrees <= 100){
                                    result = ml_equivalent * 3;
                                }else{
                                    Toast.makeText(WashingMachineActivity.this, "Inserisci un valore di durezza valido.", Toast.LENGTH_SHORT).show();
                                    return;
                                }
                            }
                        }

                        try {
                            switch (Integer.parseInt((String) radioButtonSelected.getHint())) {
                                case 1:
                                    break;
                                case 2:
                                    result += (ml_equivalent * 6)/5;
                                    break;
                                case 3:
                                    result += (ml_equivalent * 9)/5;
                                    break;
                                default:
                                    break;

                            }
                        }catch (NumberFormatException e){
                            Toast.makeText(WashingMachineActivity.this, "Parsing Error", Toast.LENGTH_SHORT).show();
                            e.printStackTrace();
                        }

                        //Toast.makeText(WashingMachineActivity.this, radioButtonSelected.getHint().toString(), Toast.LENGTH_SHORT).show();
                        txtResult.setVisibility(View.VISIBLE);

                        txtResult.setText("Aggiungi " + String.valueOf(result) + " ml di detergente");
                    }
                    }
                }

            }

        });

    }

}
