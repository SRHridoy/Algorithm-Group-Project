package com.elitcoder.algoexpress;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.elitcoder.algoexpress.databinding.ActivityBubbleSortBinding;

public class BubbleSortActivity extends AppCompatActivity {
    ActivityBubbleSortBinding bubbleSortBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        //View Binding :
        bubbleSortBinding = ActivityBubbleSortBinding.inflate(getLayoutInflater());
        View view = bubbleSortBinding.getRoot();
        setContentView(view);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //visulaizeBubbleSort :
        goToVisualizeBubbleSort();
    }

    private void goToVisualizeBubbleSort() {
        bubbleSortBinding.btnBubbleVisualize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToVisualizeBubble = new Intent(BubbleSortActivity.this,VisualizeBubbleActivity.class);
                startActivity(goToVisualizeBubble);
            }
        });
    }
}