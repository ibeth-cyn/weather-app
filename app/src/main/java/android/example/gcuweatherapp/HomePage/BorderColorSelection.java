package android.example.gcuweatherapp.HomePage;

import android.content.Context;
import android.example.gcuweatherapp.R;
import android.support.v4.content.ContextCompat;

public class BorderColorSelection {

     static int[] borderList = new int[]{R.drawable.chetwode_blue,R.drawable.east_bay,R.drawable.near_pale_chestnut,
        R.drawable.strong_red,R.drawable.cerulean_blue,R.drawable.lawn_green,R.drawable.danfo_yellow};

    public static int getViewHolderBackgroundFromInstance(Context context, int instanceNumber){
        switch (instanceNumber){
            case 0:
                return borderList[0];
            case 1:
                return borderList[1];
            case 2:
                return borderList[2];
            case 3:
                return borderList[3];
            case 4:
                return borderList[4];
            case 5:
                return borderList[5];
            case 6:
                return borderList[6];

            default:
                return borderList[0];
        }
    }
}
