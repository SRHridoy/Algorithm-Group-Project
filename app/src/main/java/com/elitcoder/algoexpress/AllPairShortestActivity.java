package com.elitcoder.algoexpress;

import static java.lang.Math.min;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.elitcoder.algoexpress.databinding.ActivityAllPairShortestBinding;

public class AllPairShortestActivity extends AppCompatActivity {
    ActivityAllPairShortestBinding allPairShortestBinding;
    private static final int MX = 1000 + 123;
    private int[][] adj = new int[MX][MX];
    String steps;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        //View Binding:
        allPairShortestBinding = ActivityAllPairShortestBinding.inflate(getLayoutInflater());
        setContentView(allPairShortestBinding.getRoot());

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //Apply floyd Warshall:
        applyFloydWarshall();
    }

    private void applyFloydWarshall(){
        allPairShortestBinding.btnApplyFloydWarshal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String noOfNodesInput = allPairShortestBinding.edtNodes.getText().toString();
                String adjMatInput = allPairShortestBinding.edtMatrix.getText().toString();
                if(noOfNodesInput.isEmpty() && adjMatInput.isEmpty()){
                    //Predefined values :
                    adj[1][1] = 0;
                    adj[1][2] = 3;
                    adj[1][3] = 1000;
                    adj[1][4] = 7;

                    adj[2][1] = 8;
                    adj[2][2] = 0;
                    adj[2][3] = 2;
                    adj[2][4] = 1000;

                    adj[3][1] = 5;
                    adj[3][2] = 1000;
                    adj[3][3] = 0;
                    adj[3][4] = 1;

                    adj[4][1] = 2;
                    adj[4][2] = 1000;
                    adj[4][3] = 1000;
                    adj[4][4] = 0;
                    floydWarshall(4);
                    Toast.makeText(AllPairShortestActivity.this, "Successfully applied Floyd-Warshall!", Toast.LENGTH_LONG).show();
                }else{
                    //Converting to Int:
                    int noOfNodes = Integer.parseInt(noOfNodesInput);
                    //Store adj to mat:
                    String[] rows = adjMatInput.split("\n");

                    for (int i = 0; i < noOfNodes; i++) {
                        String[] values = rows[i].split(" ");
                        for (int j = 0; j < noOfNodes; j++) {
                            adj[i+1][j+1] = Integer.parseInt(values[j]);
                        }
                    }

                    //call floyd warshall :
                    floydWarshall(noOfNodes);
                    Toast.makeText(AllPairShortestActivity.this, "Successfully applied Floyd-Warshall!", Toast.LENGTH_LONG).show();

                }
            }
        });
    }

    //Floyd warshall Algorithm :
    private void floydWarshall(int node){
        //For efficient appending of results in every steps :
        StringBuilder sb = new StringBuilder();

        for(int k = 1; k <= node; k++){
            for(int i = 1; i<=node; i++){
                for(int j = 1; j<=node; j++){
                    adj[i][j] = min(adj[i][j],adj[i][k]+adj[k][j]);
                }
            }
            //Print in every step :
            // Append current step to StringBuilder
            sb.append("For ").append(k).append(" : \n");
            for(int i = 1; i<=node; i++){
                for(int j = 1; j<=node; j++){
                    sb.append(adj[i][j] == 1000 ? "INF" : adj[i][j]).append(" ");
                }sb.append("\n");
            }sb.append("\n\n");

            // Update UI with all appended steps
            steps = sb.toString();
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    allPairShortestBinding.txtResultMat.setVisibility(View.VISIBLE);
                    allPairShortestBinding.txtResultMat.setText(steps);
                }
            });
        }
    }
}