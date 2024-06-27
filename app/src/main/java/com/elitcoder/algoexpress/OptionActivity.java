package com.elitcoder.algoexpress;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.elitcoder.algoexpress.databinding.ActivityOptionBinding;

public class OptionActivity extends AppCompatActivity {
    ActivityOptionBinding optionBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        //View Binding:
        optionBinding = ActivityOptionBinding.inflate(getLayoutInflater());
        View view = optionBinding.getRoot();
        setContentView(view);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //Button functionality:
        buttonFunctionality();
    }

    private void buttonFunctionality(){
        buttonSorting();
        buttonGraphTraversal();
        buttonAllPairShortestPath();
    }

    //Button for Sorting Intent :
    private void buttonSorting(){
        optionBinding.btnSortingAlgo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToSortingAlgoActivity = new Intent(OptionActivity.this,SortingAlgoOptionActivity.class);
                startActivity(goToSortingAlgoActivity);
            }
        });
    }

    //Button for Graph Traversal Intent :
    private  void buttonGraphTraversal(){
        optionBinding.btnGraphTraversal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToGraphTraveralOptionActivity = new Intent(OptionActivity.this,GraphTraversalOptionActivity.class);
                startActivity(goToGraphTraveralOptionActivity);
            }
        });
    }

    //Button for All Pair Shortest Path :
    private void buttonAllPairShortestPath(){
        optionBinding.btnAllPairShortest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToAllPairShortestActivity = new Intent(OptionActivity.this, AllPairShortestActivity.class);
                startActivity(goToAllPairShortestActivity);
            }
        });
    }
}