package com.elitcoder.algoexpress;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.elitcoder.algoexpress.databinding.ActivitySelectionSortBinding;

public class SelectionSortActivity extends AppCompatActivity {
    ActivitySelectionSortBinding selectionSortBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        //View binding :
        selectionSortBinding = ActivitySelectionSortBinding.inflate(getLayoutInflater());
        View view = selectionSortBinding.getRoot();
        setContentView(view);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //goToVisualizeSelection():
        goToVisualizeSelection();
    }

    private void goToVisualizeSelection() {
        selectionSortBinding.btnSelectionVisualize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToVisualizeSelection = new Intent(SelectionSortActivity.this,VisualizeSelectionActivity.class);
                startActivity(goToVisualizeSelection);
            }
        });
    }


}