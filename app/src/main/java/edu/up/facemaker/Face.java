package edu.up.facemaker;


import android.content.Context;

import android.graphics.Canvas;

import android.graphics.Color;

import android.graphics.Paint;

import android.util.AttributeSet;

import android.view.SurfaceView;

import android.view.View;

import android.widget.AdapterView;

import java.util.Random;


/**
 * @Author: Moses Ndagijimana
**/

public class Face extends SurfaceView implements AdapterView.OnItemSelectedListener, View.OnClickListener {

    int skinColor;

    int eyeColor;

    int hairColor;

    int hairStyle;


    Paint paint = new Paint();

    public void setSkinColor(int red, int green, int blue){

        skinColor = Color.rgb(red, green, blue);
    }

    public void setEyeColor(int red, int green, int blue) {

        eyeColor = Color.rgb(red, green, blue);
    }

    public void setHairColor(int red, int green, int blue) {

        hairColor = Color.rgb(red, green, blue);
    }


    public Face(Context context, AttributeSet attrs){

        super(context, attrs);

        setWillNotDraw(false);

        randomize();

    }


    /**
     * initializes all the variables to randomly selected valid values.
     *
     * @param: Takes no parameters
     *
     * @return: This method does not return anything.
     */
    public void randomize(){

        Random rand = new Random();

        skinColor = Color.rgb(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256) );

        eyeColor = Color.rgb(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256) );

        hairColor = Color.rgb(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256) );

       hairStyle = rand.nextInt();
    }

    /**
     * onDraw() method which draw the face object upon a given canvas. Inside this method I called
     *          Helper methods that draw each part of the object accordingly.
     *
     * @param canvas: what to draw, which is the whole face and

     * @return This method does not return anything.
     */
    @Override
    public void onDraw(Canvas canvas){

        drawFace(canvas);

        drawHair(canvas);

        drawEyes(canvas);

        drawHair(canvas);

        drawMouth(canvas);
    }

    public void drawFace(Canvas canvas){

        paint.setColor(skinColor);

        canvas.drawCircle(165.0f, 165.0f, 120.0f, paint);
    }

    /**
     * Helper method to the Ondraw() method which draws hair upon a given canvas.
     *
     * @param canvas: what to draw, which is the hair

     * @return This method does not return anything.
     */
    public void drawHair(Canvas canvas){

        paint.setColor(hairColor);

        //different three hair style of the face which change based on the user selection.
        if(hairStyle == 0){


            canvas.drawRect(0.0f,0.0f,0.0f,0.0f,paint);

        }
        else if(hairStyle == 1){

            canvas.drawRect(100.0f,40.0f, 230.0f, 60.0f, paint );

            canvas.drawRect(100.0f,40.0f, 230.0f, 60.0f, paint );
        }

        else{

             canvas.drawCircle(125.0f, 50.0f, 25.0f, paint);

             canvas.drawCircle(145.0f, 50.0f, 25.0f, paint);

             canvas.drawCircle(165.0f, 50.0f, 25.0f, paint);

             canvas.drawCircle(185.0f, 50.0f, 25.0f, paint);

             canvas.drawCircle(205.0f, 50.0f, 25.0f, paint);

        }


    }
    /**
     * Helper method to the Ondraw() method which draws eyes upon a given canvas.
     *
     * @param canvas: what to draw, which is the eyes.

     * @return This method does not return anything.
     */

    public void drawEyes(Canvas canvas){

        //draws the eye
        paint.setColor(Color.WHITE);

        canvas.drawCircle(120.0f, 145.0f, 30.0f, paint);

        canvas.drawCircle(205.0f, 145.0f, 30.0f, paint);

        //draws iris of the eye

        paint.setColor(eyeColor);

        canvas.drawCircle(120.0f, 145.0f, 15.0f, paint);

        canvas.drawCircle(205.0f, 145.0f, 15.0f, paint);

        // draw pupils of the eyes

        paint.setColor(Color.BLACK);

        canvas.drawCircle(120.0f, 145.0f, 7.5f, paint);

        canvas.drawCircle(205.0f, 145.0f, 7.5f, paint);
    }


    /**
     * Helper method to the Ondraw() method which draws the mouth upon a given canvas.
     *
     * @param canvas: what to draw, which is the Mouth.

     * @return This method does not return anything.
     */
    public void drawMouth(Canvas canvas){

        paint.setColor(Color.RED);

        canvas.drawCircle(175.0f, 230.0f, 25.0f, paint);

        paint.setColor(skinColor);

        canvas.drawCircle(175.0f, 230.0f,12.5f, paint);

    }


    @Override

    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

       hairStyle = (int) parent.getItemAtPosition(position);


    }

    @Override

    public void onNothingSelected(AdapterView<?> parent) {

            //do nothing

    }

    @Override
    public void onClick(View v) {
        randomize();
    }
}

/**
 External Citation
 Date: 6 October 2020
 Problem: Could not get my random function to work. It was not generating random colors.
 Resource: https://stackoverflow.com/questions/4246351/creating-random-colour-in-java
 Solution: I used the example code from this post.
 */

