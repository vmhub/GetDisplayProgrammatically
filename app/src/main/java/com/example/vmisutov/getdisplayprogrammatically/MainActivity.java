package com.example.vmisutov.getdisplayprogrammatically;

import android.app.Activity;
import android.content.res.Configuration;
import android.graphics.Point;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.Surface;
import android.widget.TextView;


public class MainActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView orientationTxt= (TextView) findViewById(R.id.orientationTxt);
        TextView rotationTxt= (TextView) findViewById(R.id.rotationTxt);
        TextView densityTxt= (TextView) findViewById(R.id.densityTxt);
        TextView widthTxt= (TextView) findViewById(R.id.widthTxt);
        TextView heightTxt= (TextView) findViewById(R.id.heightTxt);

        orientationTxt.setText(getOrientation());
        rotationTxt.setText(getRotate());
        densityTxt.setText(getDensity());
        widthTxt.setText(getWidth());
        heightTxt.setText(getHeight());
    }


    private String getOrientation(){
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT)
            return "Ориентация: Портретная";
        else if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE)
            return "Ориентация: Альбомная";
        else            return "Ориентация: не известно";
    }

    private String getRotate() {
        int rotate = getWindowManager().getDefaultDisplay().getRotation();
        switch (rotate) {
            case Surface.ROTATION_0:
                return "Не повёрнут";
            case Surface.ROTATION_90:
                return "Повернут на 90 градусов против часовой стрелке";
            case Surface.ROTATION_180:
                return "Повернут на 180 градусов";
            case Surface.ROTATION_270:
                return "Повернут на 90 градусов по часовой стрелке";
            default:
                return "Не понятно";
        }
    }

    private String getDensity() {
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);

        switch(metrics.densityDpi){
            case DisplayMetrics.DENSITY_LOW:
                return "Плотность dpi: low";
            case DisplayMetrics.DENSITY_MEDIUM:
                return "Плотность dpi: medium";
            case DisplayMetrics.DENSITY_HIGH:
                return "Плотность dpi: high";
            default:
                return "Не понятно";
        }
    }

    private String getWidth() {
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        return " Ширина экрана: "+ size.x + "px";
    }

    private String getHeight() {
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        return " Высота экрана: "+ size.y + "px";
    }
}