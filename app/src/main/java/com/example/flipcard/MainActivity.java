package com.example.flipcard;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView frontTV, backTV;
    private Boolean isFront = true;

    //private AnimatorSet frontAnim, backAnim;
    private Animator frontAnim, backAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        frontTV = findViewById(R.id.front_card);
        backTV = findViewById(R.id.back_card);

        float scale = getApplicationContext().getResources().getDisplayMetrics().density;
        frontTV.setCameraDistance(8000 * scale);
        backTV.setCameraDistance(8000 * scale);

        frontAnim = AnimatorInflater.loadAnimator(this, R.animator.front_animator);
        backAnim = AnimatorInflater.loadAnimator(this, R.animator.back_animator);


        Button flipButton = findViewById(R.id.flipButton);
        flipButton.setOnClickListener(v -> {
            if(isFront) {
                frontAnim.setTarget(frontTV);
                backAnim.setTarget(backTV);
                frontAnim.start();
                backAnim.start();
                isFront = false;
            } else {
                frontAnim.setTarget(backTV);
                backAnim.setTarget(frontTV);
                frontAnim.start();
                backAnim.start();
                isFront = true;
            }
        });
    }
}