package edu.up.facemaker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.widget.ArrayAdapter;

import android.widget.Button;

import android.widget.RadioGroup;

import android.widget.SeekBar;

import android.widget.Spinner;

/**
 * @Author: Moses Ndagijimana
 **/


public class MainActivity extends AppCompatActivity {

    private String[] hairStyles = {"Afro short", "Afro long", "Skin Head"};

    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        //populating the spinner

        ArrayAdapter<String> hairAdapter = new ArrayAdapter<String>(this,

                android.R.layout.simple_list_item_1, hairStyles);

        Spinner hairStyleSpinner = findViewById(R.id.spinnerHair);

        hairStyleSpinner.setAdapter(hairAdapter);

        //initial Face

        Face myFace = (Face) findViewById(R.id.face);

        // make a myFaceController linking to the surface view

        faceListener controller = new faceListener(myFace);

        Spinner hairSpinner = (Spinner) findViewById(R.id.spinnerHair);

        // init seeKbars, set max value to 255, set listener
        // retrieve a reference to seekBars view on the user interface
        //call the setOnSeekBarChangeListener() method on seekBars to register my controller
        // object as a listener for clicks on the seekBars.

        SeekBar rSeekBar = (SeekBar) findViewById(R.id.seekBarRed);

        rSeekBar.setMax(255);

        rSeekBar.setOnSeekBarChangeListener(controller);

        SeekBar gSeekBar = (SeekBar) findViewById(R.id.seekBarGreen);

        gSeekBar.setMax(255);

        gSeekBar.setOnSeekBarChangeListener(controller);

        SeekBar bSeekBar = (SeekBar) findViewById(R.id.seekBarBlue);

        bSeekBar.setMax(255);

        bSeekBar.setOnSeekBarChangeListener(controller);


       // retrieve a reference to the “RadioGroup” Button view on the user interface
        //call the setOnCheckedChangeListener() method on the button to register my controller
        // object as a listener for clicks on the radioButtons

        RadioGroup myRadioGroup = (RadioGroup)  findViewById(R.id.radioGroup);

        myRadioGroup.setOnCheckedChangeListener(controller);

        Button randButton = (Button) findViewById(R.id.radioButtonRandom);

        randButton.setOnClickListener(controller);




    }


}

/**
 External Citation
 Date: 6 October 2020
 Problem: I had issues implementing radioButton Group. Whenever I run the app it would crash after selecting
                one of the radiobutton
 Resource: Prof Nux
 Solution: Removed "android feature I had in my XML file which was causing the crash, initiated RadioGroup button and
    set onCheckedChangedListener to myRadioGroup button.

 */

/**
 External Citation
 Date: 6 October 2020
 Problem: I had issue populating my spinner
 Resource: Class Code.
 Solution: I used the example code from lecture
 */
