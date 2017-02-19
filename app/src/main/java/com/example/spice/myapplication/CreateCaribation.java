package com.example.spice.myapplication;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewDebug;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class CreateCaribation extends AppCompatActivity {

    private EditText  NameCalibration;
    private EditText  Intensity1;
    private EditText  Intensity2;
    private EditText  Intensity3;
    private EditText  Intensity4;
    private EditText  Intensity5;

    private TextView ITSTR1;
    private TextView ITSTR2;
    private TextView ITSTR3;
    private TextView ITSTR4;
    private TextView ITSTR5;

//    private TextView ITSTG1;
//    private TextView ITSTG2;
//    private TextView ITSTG3;
//    private TextView ITSTG4;
//    private TextView ITSTG5;
//
//    private TextView ITSTB1;
//    private TextView ITSTB2;
//    private TextView ITSTB3;
//    private TextView ITSTB4;
//    private TextView ITSTB5;

    private int IntensityR[] = new int[5];
    private int IntensityG[] = new int[5];
    private int IntensityB[] = new int[5];
    private double Intensity[] = new double[5];

    private static int TAKE_PHOTO_REQUEST_CODE=1;

    private int red=0;
    private int green=0;
    private int blue=0;
    private Context activity;  //เอาไว้ใช้ Toast (ข้อความลอย)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_caribation);

        NameCalibration = (EditText)findViewById(R.id.eTNameCalibration);
        Intensity1 = (EditText)findViewById(R.id.eT1);
        Intensity2 = (EditText)findViewById(R.id.eT2);
        Intensity3 = (EditText)findViewById(R.id.eT3);
        Intensity4 = (EditText)findViewById(R.id.eT4);
        Intensity5 = (EditText)findViewById(R.id.eT5);

        ITSTR1 = (TextView)findViewById(R.id.tVR1);
        ITSTR2 = (TextView)findViewById(R.id.tVR2);
        ITSTR3 = (TextView)findViewById(R.id.tVR3);
        ITSTR4 = (TextView)findViewById(R.id.tVR4);
        ITSTR5 = (TextView)findViewById(R.id.tVR5);

//        ITSTG1 = (TextView)findViewById(R.id.tVG1);
//        ITSTG2 = (TextView)findViewById(R.id.tVG2);
//        ITSTG3 = (TextView)findViewById(R.id.tVG3);
//        ITSTG4 = (TextView)findViewById(R.id.tVG4);
//        ITSTG5 = (TextView)findViewById(R.id.tVG5);
//
//        ITSTB1 = (TextView)findViewById(R.id.tVB1);
//        ITSTB2 = (TextView)findViewById(R.id.tVB2);
//        ITSTB3 = (TextView)findViewById(R.id.tVB3);
//        ITSTB4 = (TextView)findViewById(R.id.tVB4);
//        ITSTB5 = (TextView)findViewById(R.id.tVB5);



    }

//    public void ibtnDoTakephoto(View view){
//        Intent itn = new Intent(this,takephoto.class);
//        startActivity(itn);
//
//    }

    public void AGVRGBColor(Bitmap imageBitmap){

        int redColors = 0;
        int greenColors = 0;
        int blueColors = 0;
        int pixelCount = 0;
        for (int y = 0; y < imageBitmap.getHeight(); y++)
        {
            for (int x = 0; x < imageBitmap.getWidth(); x++)
            {
                int c = imageBitmap.getPixel(x, y);
                pixelCount++;
                redColors += Color.red(c);
                greenColors += Color.green(c);
                blueColors += Color.blue(c);
            }
        }
        // calculate average of bitmap r,g,b values
        this.red = (redColors/pixelCount);
        this.green = (greenColors/pixelCount);
        this.blue = (blueColors/pixelCount);

    }



    public void ibtnDoTakephoto(View v){
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE );
        startActivityForResult(intent,TAKE_PHOTO_REQUEST_CODE);
    }

    public void ibtnDoTakephoto2(View v){
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE );
        startActivityForResult(intent,2);
    }

    public void ibtnDoTakephoto3(View v){
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE );
        startActivityForResult(intent,3);
    }

    public void ibtnDoTakephoto4(View v){
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE );
        startActivityForResult(intent,4);
    }

    public void ibtnDoTakephoto5(View v){
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE );
        startActivityForResult(intent,5);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == TAKE_PHOTO_REQUEST_CODE && resultCode == RESULT_OK){
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            AGVRGBColor(imageBitmap);

            TextView TV1 = (TextView) findViewById(R.id.tVR1);
            TextView TV2 = (TextView) findViewById(R.id.tVG1);
            TextView TV3 = (TextView) findViewById(R.id.tVB1);

            TV1.setText(red+" ");
            TV2.setText(green+" ");
            TV3.setText(blue+" ");

            IntensityR[0] = red;
            IntensityG[0] = green;
            IntensityB[0] = blue;
        }

        else if(requestCode == 2 && resultCode == RESULT_OK){
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            AGVRGBColor(imageBitmap);

            TextView TV1 = (TextView) findViewById(R.id.tVR2);
            TextView TV2 = (TextView) findViewById(R.id.tVG2);
            TextView TV3 = (TextView) findViewById(R.id.tVB2);

            TV1.setText(red+" ");
            TV2.setText(green+" ");
            TV3.setText(blue+" ");

            IntensityR[1] = red;
            IntensityG[1] = green;
            IntensityB[1] = blue;
        }

        else if(requestCode == 3 && resultCode == RESULT_OK){
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            AGVRGBColor(imageBitmap);

            TextView TV1 = (TextView) findViewById(R.id.tVR3);
            TextView TV2 = (TextView) findViewById(R.id.tVG3);
            TextView TV3 = (TextView) findViewById(R.id.tVB3);

            TV1.setText(red+" ");
            TV2.setText(green+" ");
            TV3.setText(blue+" ");
            IntensityR[2] = red;
            IntensityG[2] = green;
            IntensityB[2] = blue;
        }

        else if(requestCode == 4 && resultCode == RESULT_OK){
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            AGVRGBColor(imageBitmap);

            TextView TV1 = (TextView) findViewById(R.id.tVR4);
            TextView TV2 = (TextView) findViewById(R.id.tVG4);
            TextView TV3 = (TextView) findViewById(R.id.tVB4);

            TV1.setText(red+" ");
            TV2.setText(green+" ");
            TV3.setText(blue+" ");
            IntensityR[3] = red;
            IntensityG[3] = green;
            IntensityB[3] = blue;
        }

        else if(requestCode == 5 && resultCode == RESULT_OK){
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            AGVRGBColor(imageBitmap);

            TextView TV1 = (TextView) findViewById(R.id.tVR5);
            TextView TV2 = (TextView) findViewById(R.id.tVG5);
            TextView TV3 = (TextView) findViewById(R.id.tVB5);

            TV1.setText(red+" ");
            TV2.setText(green+" ");
            TV3.setText(blue+" ");
            IntensityR[4] = red;
            IntensityG[4] = green;
            IntensityB[4] = blue;
        }
    }






    public void btnCompute(View view) {
        Context context = getApplicationContext();

        String nameCLBT = NameCalibration.getText().toString();

        String SNIntensity1 = Intensity1.getText().toString();
        String SNIntensity2 = Intensity2.getText().toString();
        String SNIntensity3 = Intensity3.getText().toString();
        String SNIntensity4 = Intensity4.getText().toString();
        String SNIntensity5 = Intensity5.getText().toString();

        String SNIESTR1 = ITSTR1.getText().toString();
        String SNIESTR2 = ITSTR2.getText().toString();
        String SNIESTR3 = ITSTR3.getText().toString();
        String SNIESTR4 = ITSTR4.getText().toString();
        String SNIESTR5 = ITSTR5.getText().toString();


//        int NIESTR1 = Integer.parseInt(SNIESTR1);
//        int NIESTR2 = Integer.parseInt(SNIESTR2);
//        int NIESTR3 = Integer.parseInt(SNIESTR3);
//        int NIESTR4 = Integer.parseInt(SNIESTR4);
//        int NIESTR5 = Integer.parseInt(SNIESTR5);
//
//        int NIESTG1 = Integer.parseInt(ITSTG1.getText().toString());
//        int NIESTG2 = Integer.parseInt(ITSTG2.getText().toString());
//        int NIESTG3 = Integer.parseInt(ITSTG3.getText().toString());
//        int NIESTG4 = Integer.parseInt(ITSTG4.getText().toString());
//        int NIESTG5 = Integer.parseInt(ITSTG5.getText().toString());
//
//        int NIESTB1 = Integer.parseInt(ITSTB1.getText().toString());
//        int NIESTB2 = Integer.parseInt(ITSTB2.getText().toString());
//        int NIESTB3 = Integer.parseInt(ITSTB3.getText().toString());
//        int NIESTB4 = Integer.parseInt(ITSTB4.getText().toString());
//        int NIESTB5 = Integer.parseInt(ITSTB5.getText().toString());

//        RGB[0][0] = NIESTR1;
//        RGB[0][1] = NIESTR2;
//        RGB[0][2] = NIESTR3;
//        RGB[0][3] = NIESTR4;
//        RGB[0][4] = NIESTR5;
//
//        RGB[1][0] = NIESTG1;
//        RGB[1][1] = NIESTG2;
//        RGB[1][2] = NIESTG3;
//        RGB[1][3] = NIESTG4;
//        RGB[1][4] = NIESTG5;
//
//        RGB[2][0] = NIESTB1;
//        RGB[2][1] = NIESTB2;
//        RGB[2][2] = NIESTB3;
//        RGB[2][3] = NIESTB4;
//        RGB[2][4] = NIESTB5;

        Intent Int = new Intent(this, CalibrationGraph.class);





        if (nameCLBT != null && (!TextUtils.equals(nameCLBT ,"null")) && (!TextUtils.isEmpty(nameCLBT))) {

            if(SNIntensity1 != null && (!TextUtils.equals(SNIntensity1 ,"null")) && (!TextUtils.isEmpty(SNIntensity1))){
                if(SNIntensity2 != null && (!TextUtils.equals(SNIntensity2 ,"null")) && (!TextUtils.isEmpty(SNIntensity2))){
                    if(SNIntensity3 != null && (!TextUtils.equals(SNIntensity3 ,"null")) && (!TextUtils.isEmpty(SNIntensity3))){
                        if(SNIntensity4 != null && (!TextUtils.equals(SNIntensity4 ,"null")) && (!TextUtils.isEmpty(SNIntensity4))){
                            if(SNIntensity5 != null && (!TextUtils.equals(SNIntensity5 ,"null")) && (!TextUtils.isEmpty(SNIntensity5))){

                                if(SNIESTR1 != null && (!TextUtils.equals(SNIESTR1 ,"null")) && (!TextUtils.isEmpty(SNIESTR1))){
                                    if(SNIESTR2 != null && (!TextUtils.equals(SNIESTR2 ,"null")) && (!TextUtils.isEmpty(SNIESTR2))){
                                        if(SNIESTR3 != null && (!TextUtils.equals(SNIESTR3 ,"null")) && (!TextUtils.isEmpty(SNIESTR3))){
                                            if(SNIESTR4 != null && (!TextUtils.equals(SNIESTR4 ,"null")) && (!TextUtils.isEmpty(SNIESTR4))){
                                                if(SNIESTR5 != null && (!TextUtils.equals(SNIESTR5 ,"null")) && (!TextUtils.isEmpty(SNIESTR5))){

                                                    double NIntensity1 = Double.parseDouble(SNIntensity1);
                                                    double NIntensity2 = Double.parseDouble(SNIntensity2);
                                                    double NIntensity3 = Double.parseDouble(SNIntensity3);
                                                    double NIntensity4 = Double.parseDouble(SNIntensity4);
                                                    double NIntensity5 = Double.parseDouble(SNIntensity5);
                                                    Intensity[0] = NIntensity1;
                                                    Intensity[1] = NIntensity2;
                                                    Intensity[2] = NIntensity3;
                                                    Intensity[3] = NIntensity4;
                                                    Intensity[4] = NIntensity5;

                                                    Int.putExtra("name", nameCLBT);
                                                    Int.putExtra("ITST", Intensity);
                                                    Int.putExtra("ITSTR",IntensityR);
                                                    Int.putExtra("ITSTG",IntensityG);
                                                    Int.putExtra("ITSTB",IntensityB);

                                                    startActivity(Int);
                                                }else{Toast.makeText(context, "Error take photo row 5." , Toast.LENGTH_SHORT).show();}
                                            }else{Toast.makeText(context, "Error take photo row 4." , Toast.LENGTH_SHORT).show();}
                                        }else{Toast.makeText(context, "Error take photo row 3." , Toast.LENGTH_SHORT).show();}
                                    }else{Toast.makeText(context, "Error take photo row 2." , Toast.LENGTH_SHORT).show();}
                                }else{Toast.makeText(context, "Error take photo row 1." , Toast.LENGTH_SHORT).show();}


                            }else{Toast.makeText(context, "Error input intensity row 5." , Toast.LENGTH_SHORT).show();}
                        }else{Toast.makeText(context, "Error input intensity row 4." , Toast.LENGTH_SHORT).show();}
                    }else{Toast.makeText(context, "Error input intensity row 3." , Toast.LENGTH_SHORT).show();}
                }else{Toast.makeText(context, "Error input intensity row 2." , Toast.LENGTH_SHORT).show();}
            }else{ Toast.makeText(context, "Error input intensity row 1." , Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(context, "Error name calibration."+nameCLBT , Toast.LENGTH_SHORT).show();

        }
    }



}

