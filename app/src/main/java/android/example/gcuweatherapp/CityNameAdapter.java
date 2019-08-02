package android.example.gcuweatherapp;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class CityNameAdapter extends
        RecyclerView.Adapter<CityNameAdapter.CityViewHolder> {

    private final String[] mCityName;

    private LayoutInflater mInflater;

    private static int viewHolderCount;


    public CityNameAdapter(Context context,String[] mCityName){
        mInflater = LayoutInflater.from(context);
        this.mCityName = mCityName;
        viewHolderCount = 0;
    }

    @NonNull
    @Override
    public CityViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Context context = viewGroup.getContext();
        View mItemView = mInflater.inflate(R.layout.city_name, viewGroup ,false);
        CityViewHolder viewHolder = new CityViewHolder(mItemView,this);

        int backgroundColorForViewHolder = BorderColorSelection.
                getViewHolderBackgroundFromInstance(context, viewHolderCount);
        viewHolder.cityNameView.setBackgroundColor(backgroundColorForViewHolder);

        viewHolderCount++;
        return new CityViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(CityViewHolder cityViewHolder, int i) {
        String mCurrent = mCityName[i];
        cityViewHolder.cityNameView.setText(mCurrent);
    }

    @Override
    public int getItemCount() {
        return mCityName.length;
    }

    class CityViewHolder extends RecyclerView.ViewHolder{

        public final TextView cityNameView;
        final CityNameAdapter mAdapter;

        public CityViewHolder(View itemView, CityNameAdapter adapter) {
            super(itemView);
            cityNameView = (TextView) itemView.findViewById(R.id.city_name);
            this.mAdapter = adapter;

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(),WeatherActivity.class);
                    intent.putExtra("city name",mCityName);
                    v.getContext().startActivity(intent);
//                    startActivity(v.getContext(),intent);
                }
            });
        }
    }
}
