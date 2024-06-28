package com.elitcoder.algoexpress;

import android.os.Bundle;
import android.view.View;

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
    }

    private void insertionSort(int n, int[] intArray) {
        StringBuilder sb = new StringBuilder();
        for (int i=1; i<n; i++) {
            sb.append("Pass ").append(i).append(" : \n");
            int temp=intArray[i];
            int j=i-1;

            while(j>=0 && intArray[j]>temp) {
                intArray[j+1]=intArray[j];
                j--;
                for(int k = 0; k<n;k++){
                    sb.append(intArray[k]).append(" ");
                }sb.append("\n");
            }
            intArray[j+1]=temp;
            sb.append("\n\n");
        }
       /* for(int i = 0; i < n-1; i++){
            sb.append("Pass ").append(i+1).append(" : \n");
            for(int j = 0; j<n-i-1;j++){
                if(intArray[j]>intArray[j+1]){
                    int temp;
                    temp = intArray[j];
                    intArray[j] = intArray[j+1];
                    intArray[j+1] = temp;
                }
                for(int k = 0; k<n;k++){
                    sb.append(intArray[k]).append(" ");
                }sb.append("\n");
            }sb.append("\n\n");
        } */

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