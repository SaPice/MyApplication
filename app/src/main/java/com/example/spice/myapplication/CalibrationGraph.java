package com.example.spice.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class CalibrationGraph extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calibrationgraph);


        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            String name = bundle.getString("name");
            double intst[] = bundle.getDoubleArray("ITST");
            int IntensityR[] = bundle.getIntArray("ITSTR");
            int IntensityG[] = bundle.getIntArray("ITSTG");
            int IntensityB[] = bundle.getIntArray("ITSTB");

            TextView TVname = (TextView) findViewById(R.id.tVnameCLBTG);
            TVname.setText("Calibration name : "+name);

            TextView Tvintst = (TextView)findViewById(R.id.tVINTSandRGB1);
            Tvintst.setText(intst[0]+"{"+IntensityR[0]+" , "+IntensityG[0]+" , "+IntensityB[0]+" }");

            TextView Tvintst2 = (TextView)findViewById(R.id.tVINTSandRGB2);
            Tvintst2.setText(intst[1]+"{"+IntensityR[1]+" , "+IntensityG[1]+" , "+IntensityB[1]+" }");

            TextView Tvintst3 = (TextView)findViewById(R.id.tVINTSandRGB3);
            Tvintst3.setText(intst[2]+"{"+IntensityR[2]+" , "+IntensityG[2]+" , "+IntensityB[2]+" }");

            TextView Tvintst4 = (TextView)findViewById(R.id.tVINTSandRGB4);
            Tvintst4.setText(intst[3]+"{"+IntensityR[3]+" , "+IntensityG[3]+" , "+IntensityB[3]+" }");

            TextView Tvintst5 = (TextView)findViewById(R.id.tVINTSandRGB5);
            Tvintst5.setText(intst[4]+"{"+IntensityR[4]+" , "+IntensityG[4]+" , "+IntensityB[4]+" }");

        }
    }
}
