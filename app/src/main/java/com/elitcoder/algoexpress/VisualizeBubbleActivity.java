package com.elitcoder.algoexpress;


import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.elitcoder.algoexpress.databinding.ActivityVisualizeBubbleBinding;

public class VisualizeBubbleActivity extends AppCompatActivity {
    ActivityVisualizeBubbleBinding visualizeBubbleBinding;
    String result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        //View Binding :
        visualizeBubbleBinding = ActivityVisualizeBubbleBinding.inflate(getLayoutInflater());
        View view = visualizeBubbleBinding.getRoot();
        setContentView(view);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        //Visualize Bubbble:
        callVisulalizer();
    }

    private void callVisulalizer() {
        visualizeBubbleBinding.btnBubbleVisualize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                visualizeBubble();
            }
        });
    }

    private void visualizeBubble() {
        String noOfElementsS = visualizeBubbleBinding.edtNoOfElements.getText().toString();
        String elements = visualizeBubbleBinding.edtElements.getText().toString();

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
        //Bubble Sort:\
        bubbleSort(noOfElements,intArray);

    }

    void bubbleSort(int n, int[] intArray){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n-1; i++){
            sb.append("Pass ").append(i+1).append(" : \n");
            for(int j = 0; j<n-i-1;j++){
                int tr1 = 0;
                if(intArray[j]>intArray[j+1]){
                    int temp;
                    temp = intArray[j];
                    intArray[j] = intArray[j+1];
                    intArray[j+1] = temp;
                    //Track:
                    tr1 = j;
                }
                for(int k = 0; k<n;k++){
                    if(k==tr1) {
                        sb.append("(").append(intArray[k]).append(" ");
                    }else if(k==tr1+1){
                        sb.append(intArray[k]).append(") ");
                    }else{
                        sb.append(intArray[k]).append(" ");
                    }
                }sb.append("\n");
            }sb.append("\n\n");
        }

        // Update UI with all appended steps
        result = sb.toString();
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                visualizeBubbleBinding.txtBubbleResult.setVisibility(View.VISIBLE);
                visualizeBubbleBinding.txtBubbleResult.setText(result);
            }
        });
    }
}