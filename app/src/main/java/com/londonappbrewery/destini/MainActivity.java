package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class  MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here
      private Button mtopButton,mbottomButton;
      private int mnumber;
      private int[] mstory=new int[] {R.string.T1_Story,R.string.T2_Story,R.string.T3_Story};
      private int[] manswer1=new int[]{R.string.T1_Ans1,R.string.T2_Ans1,R.string.T3_Ans1};
      private int[] manswer2=new int[]{R.string.T1_Ans2,R.string.T2_Ans2,R.string.T3_Ans2};
      private int[] mEndStory=new int[]{R.string.T4_End,R.string.T5_End,R.string.T6_End};
      private TextView mStoryText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        mtopButton=findViewById(R.id.buttonTop);
        mbottomButton=findViewById(R.id.buttonBottom);
        mStoryText=findViewById(R.id.storyTextView);
        if(savedInstanceState!=null)
            mnumber=savedInstanceState.getInt("mnumber");
        else
        {
            mnumber=0;
        }
        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:
         mtopButton.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 if(mnumber==0){
                     mnumber=2;
                     mStoryText.setText(mstory[mnumber]);
                     mtopButton.setText(manswer1[mnumber]);
                     mbottomButton.setText(manswer2[mnumber]);
                 }
                 else if(mnumber==2){
                     mStoryText.setText(mEndStory[2]);
                     mtopButton.setVisibility(View.INVISIBLE);
                     mbottomButton.setVisibility(View.INVISIBLE);
                     mnumber=0;
                 }
                 else if(mnumber==1){
                     mnumber=2;
                     mStoryText.setText(mstory[mnumber]);
                     mtopButton.setText(manswer1[mnumber]);
                     mbottomButton.setText(manswer2[mnumber]);
                 }

             }
         });



        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:
        mbottomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(mnumber==0){
                    mnumber=1;
                    mStoryText.setText(mstory[mnumber]);
                    mtopButton.setText(manswer1[mnumber]);
                    mbottomButton.setText(manswer2[mnumber]);
                }
                else if(mnumber==1){
                    mStoryText.setText(mEndStory[0]);
                    mtopButton.setVisibility(View.INVISIBLE);
                    mbottomButton.setVisibility(View.INVISIBLE);
                    mnumber=0;
                }
                else if(mnumber==2){
                    mStoryText.setText(mEndStory[1]);
                    mtopButton.setVisibility(View.INVISIBLE);
                    mbottomButton.setVisibility(View.INVISIBLE);
                    mnumber=0;
                }

            }
        });


    }
    @Override
    public void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putInt("mnumber",mnumber);
    }
}
