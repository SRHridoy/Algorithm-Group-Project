package com.elitcoder.algoexpress;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.elitcoder.algoexpress.databinding.ActivityVisualizeSelectionBinding;

public class VisualizeSelectionActivity extends AppCompatActivity {
    ActivityVisualizeSelectionBinding visualizeSelectionBinding;
    String result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        //View bindig:
        visualizeSelectionBinding = ActivityVisualizeSelectionBinding.inflate(getLayoutInflater());
        View view = visualizeSelectionBinding.getRoot();
        setContentView(view);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //Visualize selection:
        callVisulalizer();
    }

    private void callVisulalizer() {
        visualizeSelectionBinding.btnSelectionVisualize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                visualizeSelection();
            }
        });
    }

    private void visualizeSelection() {
        String noOfElementsS = visualizeSelectionBinding.edtNoOfElements.getText().toString();
        String elements = visualizeSelectionBinding.edtElements.getText().toString();

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
        //Selection Sort:\
        selectionSort(noOfElements,intArray);
        Toast.makeText(this, "Successfully Selection Sort Executed!", Toast.LENGTH_SHORT).show();
    }

    private void selectionSort(int n, int[] intArray) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n-1; i++){
            sb.append("Pass ").append(i+1).append(" : \n");
            int min = Integer.MAX_VALUE;
            int x=0;
            for(int j = i; j < n; j++){
                if(min>intArray[j]){
                    min = intArray[j];
                    x = j;
                }
                for(int k = 0; k<n;k++){
                    sb.append(intArray[k]).append(" ");
                }sb.append("\n");
            }
            int temp = intArray[i];
            intArray[i] = intArray[x];
            intArray[x] = temp;
            for(int k = 0; k<n;k++){
                sb.append(intArray[k]).append(" ");
            }sb.append("\n");

        }


        // Update UI with all appended steps
        result = sb.toString();
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                visualizeSelectionBinding.txtSelectionResult.setVisibility(View.VISIBLE);
                visualizeSelectionBinding.txtSelectionResult.setText(result);
            }
        });

    }
}