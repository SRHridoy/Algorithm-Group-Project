package com.elitcoder.algoexpress;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.elitcoder.algoexpress.databinding.ActivityFloydWarshallDescriptionBinding;

public class FloydWarshallDescriptionActivity extends AppCompatActivity {
    ActivityFloydWarshallDescriptionBinding floydWarshallDescriptionBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        //View Binding :
        floydWarshallDescriptionBinding = ActivityFloydWarshallDescriptionBinding.inflate(getLayoutInflater());
        View view = floydWarshallDescriptionBinding.getRoot();
        setContentView(view);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        //Go to all pair activity and visualize:
        goToAllPairActivity();
    }

    private void goToAllPairActivity() {
        floydWarshallDescriptionBinding.btnAllPairShortest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToAllPairShortestActivity = new Intent(FloydWarshallDescriptionActivity.this, AllPairShortestActivity.class);
                startActivity(goToAllPairShortestActivity);
            }
        });
    }
}