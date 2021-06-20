package it.ooproject.offsiteeyes.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import it.ooproject.offsiteeyes.R;

public class ToolsActivity extends AppCompatActivity {
    CardView cardViewWashingMachine;
    CardView cardViewSecondOption;  // Todo? or only one tool?

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tools);
        cardViewWashingMachine = findViewById(R.id.card_view_first_option);
        cardViewSecondOption = findViewById(R.id.card_view_second_option);


        cardViewWashingMachine.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(ToolsActivity.this, WashingMachineActivity.class);
                startActivity(intent);
            }
        });

        cardViewSecondOption.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(ToolsActivity.this, ToolsActivity.class);
                startActivity(intent);
            }
        });


    }
}
