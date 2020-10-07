package edu.up.facemaker;

import android.util.Log;

import android.view.View;

import android.widget.AdapterView;

import android.widget.RadioGroup;

import android.widget.SeekBar;

import android.widget.Spinner;

/**
 * @Author: Moses Ndagijimana
 **/


public class faceListener implements View.OnClickListener, SeekBar.OnSeekBarChangeListener,

        Spinner.OnItemSelectedListener, RadioGroup.OnCheckedChangeListener {

    Face controllerFace;

    private int red;

    private int green;

    private int blue;

    private int checkedB;

    int currentRadioButton;

    // constructor

    public faceListener(Face initFace){

        controllerFace = initFace;

    }

    @Override

    public void onClick(View v) {

        // call randomize and then invalidate

        controllerFace.randomize();

        controllerFace.invalidate();
    }
    /**
     *OnProgressChanged() method to respond to the user when they user changes progress of
     *  the seekbars
     *
     * @param seek : Type Seekbar: the seekBar whose progress has changed
     * @param progress : Type int:  the current progress level
     * @param  fromUser : Type boolean: True if the progress was initiated by the user

     * @return This method does not return anything.
     */
    @Override

    public void onProgressChanged(SeekBar seek, int progress, boolean fromUser) {

        int ID = seek.getId();

        // decipher which seekbar is being changed

        if(ID == R.id.seekBarRed){

            red = seek.getProgress();

        }
        else if(ID == R.id.seekBarGreen){

            green = seek.getProgress();

        }

        else if(ID == R.id.seekBarBlue){

            blue = seek.getProgress();

        }

        // could not get the radio buttons to work

        if(checkedB == R.id.radioButtonHair){

            controllerFace.setHairColor(red, green, blue);

        }

        else if(checkedB == R.id.radioButtonEyes){

            controllerFace.setEyeColor(red, green, blue);

        }
        else if(checkedB == R.id.radioButtonSkin){

            controllerFace.setSkinColor(red, green, blue);

        }

        controllerFace.setEyeColor(green, red, blue);

        controllerFace.setSkinColor(red, green, blue);

        controllerFace.setHairColor(blue, red, green);

        controllerFace.invalidate();
    }

    @Override

    public void onStartTrackingTouch(SeekBar seekBar) {

        //do nothing
    }

    @Override

    public void onStopTrackingTouch(SeekBar seekBar) {

        //do nothing
    }

    @Override

    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        //do nothing
    }

    @Override

    public void onNothingSelected(AdapterView<?> parent) {

        //do nothing
    }

    /**
     *onCheckedChanged() method called when the checked radio button has changed
     *
     * @param group : Type RadioGroup: the group in which the checked radio button has changed
     *
     * @param checked : Type  int: the unique identifier of the newly checked radio button
     *
     * @return This method does not return anything.
     */

        @Override

    public void onCheckedChanged(RadioGroup group, int checked) {

        checkedB = checked;

        if(checked == R.id.radioButtonEyes){

            currentRadioButton = checkedB;

        }
        else if(checked == R.id.radioButtonHair){

            currentRadioButton = checkedB + 1;

        }

        else if(checked == R.id.radioButtonSkin){

            currentRadioButton = checkedB + 2;

        }

        controllerFace.invalidate();

    }


}

/**
 External Citation
     Date: 6 October 2020
     Problem: Could not get the Radio buttons to respond to an event. when clicked on radio button,
            the app would crash.
     Resource: Prof Nux
     Solution: Prof Nux recommended to get reference to the button in the if statement
            "checked == R.id.radioButtonHair"
 */

/**
 External Citation
 Date: 5 October 2020
 Problem: Did not know how to implement RadioGroup
 Resource: https://developer.android.com/guide/topics/ui/controls/radiobutton
 Solution: I used the example code from this website.
 */

/**
 External Citation
 Date: 6 October 2020
 Problem:
 Resource:
 Solution: I used the example code from this post.
 */
