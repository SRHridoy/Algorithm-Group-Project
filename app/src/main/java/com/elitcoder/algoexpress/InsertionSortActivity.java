package com.elitcoder.algoexpress;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.elitcoder.algoexpress.databinding.ActivityInsertionSortBinding;

public class InsertionSortActivity extends AppCompatActivity {

    ActivityInsertionSortBinding insertionSortBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        //View binding :
        insertionSortBinding = ActivityInsertionSortBinding.inflate(getLayoutInflater());
        View view = insertionSortBinding.getRoot();
        setContentView(view);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        //visulaizeInsertionSort :
        goToVisualizeInsertionSort();

    }

    private void goToVisualizeInsertionSort() {
        insertionSortBinding.btnInsertionVisualize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InsertionSortActivity.this,VisualizeInsertionActivity.class);
                startActivity(intent);
            }
        });
    }
}