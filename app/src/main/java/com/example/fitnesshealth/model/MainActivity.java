package com.example.fitnesshealth.model;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.example.fitnesshealth.R;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private TextInputLayout exCountText, setCountText;

    private String exCount, setCount;

    private ArrayList<Workout> workouts;



    @SuppressLint("SourceLockedOrientationActivity")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        exCountText = findViewById(R.id.exerciseCount);
        setCountText = findViewById(R.id.setCount);


    }

    public void selectiveExMode(View view) {
        Log.d(TAG, "selectiveExMode: selected");

        exCount = exCountText.getEditText().getText().toString();
        setCount = setCountText.getEditText().getText().toString();

        if (exCount.equals("") && setCount.equals("")) {
            exCountText.setError("Required");
            setCountText.setError("Required");

        } else if (exCount.equals("") || exCount.equals("0")) {
            exCountText.setError("Required");
            setCountText.setError(null);

        } else if (setCount.equals("") || setCount.equals("0")) {
            setCountText.setError("Required");
            exCountText.setError(null);
        } else {

            if (Integer.parseInt(exCount) > 20)
                exCount = "20";
            else if (Integer.parseInt(exCount) < 1)
                exCount = "1";

            setCountText.setError(null);
            exCountText.setError(null);

            setWorkoutList();

            ArrayList<Workout> selectedExercises = new ArrayList<>();
            for (int i = 0; i < Integer.parseInt(exCount); i++) {
                selectedExercises.add(workouts.get(i));
            }

            Intent intent = new Intent(this, CheckoutActivity.class);
            intent.putParcelableArrayListExtra("workout", selectedExercises);
            intent.putExtra("sets", Integer.parseInt(setCount));
            startActivity(intent);
        }

    }

    public void randomExMode(View view) {
        Log.d(TAG, "randomExMode: selected");

        setCount = setCountText.getEditText().getText().toString();

        if (setCount.equals("")) {
            setCountText.setError("Required");
            exCountText.setError(null);
        } else {
            setCountText.setError(null);
            exCountText.setError(null);

            ArrayList<Workout> randomExercises = new ArrayList<>();

            Random ran = new Random();
            int rand = ran.nextInt(19) + 1;
            setWorkoutList();
            for (int i = 0; i < rand; i++) {
                randomExercises.add(workouts.get(i));
            }

            Intent intent = new Intent(this, CheckoutActivity.class);
            intent.putParcelableArrayListExtra("workout", randomExercises);
            intent.putExtra("sets", Integer.parseInt(setCount));
            startActivity(intent);

        }

    }

    public void aboutApp(View view) {
        Intent intent = new Intent(this, AboutApp.class);
        startActivity(intent);
    }

    private void setWorkoutList() {
        workouts = new ArrayList<>();

        workouts.add(new Workout("Push Ups", 100, R.drawable.img01));
        workouts.add(new Workout("Sit ups", 100, R.drawable.img02));
        workouts.add(new Workout("Crunches", 100, R.drawable.img03));
        workouts.add(new Workout("Side Bends", 100, R.drawable.img04));
        workouts.add(new Workout("Leg Lifts", 100, R.drawable.img05));
        workouts.add(new Workout("Weighted Push Ups", 100, R.drawable.img06));
        workouts.add(new Workout("Bicep Dumbbell Curl", 100, R.drawable.img07));
        workouts.add(new Workout("Exercise Ball Push Ups", 180, R.drawable.img08));
        workouts.add(new Workout("Tree Pose", 180, R.drawable.img09));
        workouts.add(new Workout("Body Plank", 100, R.drawable.img10));
        workouts.add(new Workout("Body Squats", 100, R.drawable.img11));
        workouts.add(new Workout("Rotating Push Ups", 100, R.drawable.img12));
        workouts.add(new Workout("Superman", 100, R.drawable.img13));
        workouts.add(new Workout("Incline Crunches", 100, R.drawable.img14));
        workouts.add(new Workout("Lunges", 100, R.drawable.img15));
        workouts.add(new Workout("Hollow Body Holds", 100, R.drawable.img16));
        workouts.add(new Workout("Jackknife Sit Ups", 100, R.drawable.img17));
        workouts.add(new Workout("Handstands", 100, R.drawable.img18));
        workouts.add(new Workout("Pistol Squads", 100, R.drawable.img19));
        workouts.add(new Workout("Burpees", 100, R.drawable.img20));

        Collections.shuffle(workouts);
    }

    @Override
    protected void onStart() {
        super.onStart();
        exCountText.getEditText().clearFocus();
        exCountText.getEditText().setText("");
        setCountText.getEditText().clearFocus();
        setCountText.getEditText().setText("");
    }
}