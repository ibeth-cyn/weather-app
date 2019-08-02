package android.example.gcuweatherapp;

import android.content.Context;
import android.support.v4.content.ContextCompat;

public class BorderColorSelection {

    public static int getViewHolderBackgroundFromInstance(Context context, int instanceNumber){
        switch (instanceNumber){
            case 0:
                return ContextCompat.getColor(context, R.color.description);
            case 1:
                return ContextCompat.getColor(context,R.color.chetwode_blue);
            case 2:
                return ContextCompat.getColor(context,R.color.east_bay);
            case 3:
                return ContextCompat.getColor(context,R.color.near_pale_chestnut);
            case 4:
                return ContextCompat.getColor(context,R.color.strong_red);
            case 5:
                return ContextCompat.getColor(context,R.color.cerulean_blue);
            case 6:
                return ContextCompat.getColor(context,R.color.lawn_green);
            case 7:
                return ContextCompat.getColor(context,R.color.danfo_yellow);

            default:
                return ContextCompat.getColor(context,R.color.east_bay);
        }
    }
}
