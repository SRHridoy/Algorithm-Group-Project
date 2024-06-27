package com.elitcoder.algoexpress;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.elitcoder.algoexpress.databinding.ActivitySortingAlgoOptionBinding;

public class SortingAlgoOptionActivity extends AppCompatActivity {
    ActivitySortingAlgoOptionBinding sortingAlgoOptionBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        //View binding :
        sortingAlgoOptionBinding = ActivitySortingAlgoOptionBinding.inflate(getLayoutInflater());
        View view = sortingAlgoOptionBinding.getRoot();
        setContentView(view);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //Button Functionality :
        buttonFunctionality();

    }

    private void buttonFunctionality() {
        goToBubbleActivity();
        goToSelectionActivity();
        gotToInsertionActivity();
    }

    private void gotToInsertionActivity() {
        sortingAlgoOptionBinding.btnBubble.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToBubble = new Intent(SortingAlgoOptionActivity.this,BubbleSortActivity.class);
                startActivity(goToBubble);
            }
        });
    }

    private void goToSelectionActivity() {
        sortingAlgoOptionBinding.btnSelectionSort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToSelection = new Intent(SortingAlgoOptionActivity.this,SelectionSortActivity.class);
                startActivity(goToSelection);
            }
        });
    }

    private void goToBubbleActivity() {
        sortingAlgoOptionBinding.btnInsertionSort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToInsertion = new Intent(SortingAlgoOptionActivity.this,InsertionSortActivity.class);
                startActivity(goToInsertion);
            }
        });
    }
}