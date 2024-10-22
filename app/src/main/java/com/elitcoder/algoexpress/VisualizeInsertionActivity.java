package com.elitcoder.algoexpress;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.elitcoder.algoexpress.databinding.ActivityVisualizeInsertionBinding;

public class VisualizeInsertionActivity extends AppCompatActivity {
    ActivityVisualizeInsertionBinding visualizeInsertionBinding;
    String result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        // view binding
        visualizeInsertionBinding = ActivityVisualizeInsertionBinding.inflate(getLayoutInflater());
        View view = visualizeInsertionBinding.getRoot();
        setContentView(view);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //Visualize Insertion:
        callVisulalizer();
    }

    private void callVisulalizer() {
        visualizeInsertionBinding.btnInsertionVisualize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                visualizeInsertion();
            }
        });
    }

    private void visualizeInsertion() {
        String noOfElementsS = visualizeInsertionBinding.edtNoOfElements.getText().toString();
        String elements = visualizeInsertionBinding.edtElements.getText().toString();

        int noOfElements = Integer.parseInt(noOfElementsS);

        String[] elementsArray = elements.split(" ");
        int[] intArray = new int[elementsArray.length];

        // Convert each element to an integer
        for (int i = 0; i < elementsArray.length; i++) {
            try {
                intArray[i] = Integer.parseInt(elementsArray[i]);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        //Insertion Sort:\
        insertionSort(noOfElements,intArray);
        Toast.makeText(this, "Successfully Insetion Sort Executed!", Toast.LENGTH_SHORT).show();
    }

    private void insertionSort(int n, int[] intArray) {
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < n; i++){
            sb.append("Pass ").append(i).append(" : \n");
            int value = intArray[i];
            int hole = i;
            while(hole>0 && intArray[hole-1]>value){
                intArray[hole] = intArray[hole-1];
                hole--;
                for(int k = 0; k<n;k++){
                    if (k==hole) sb.append("__").append(" ");
                    else sb.append(intArray[k]).append(" ");
                }sb.append("\n");
            }
            intArray[hole] = value;
            for(int k = 0; k<n;k++){
                sb.append(intArray[k]).append(" ");
            }sb.append("\n\n");
        }


        // Update UI with all appended steps
        result = sb.toString();
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                visualizeInsertionBinding.txtInsertionResult.setVisibility(View.VISIBLE);
                visualizeInsertionBinding.txtInsertionResult.setText(result);
            }
        });
    }
}