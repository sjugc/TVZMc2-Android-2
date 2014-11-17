package com.ivankocijan.workshop_2.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ivankocijan.workshop_2.R;
import com.ivankocijan.workshop_2.model.Car;

import java.util.List;

/**
 * @author Koc
 *         ivan.kocijan@infinum.hr
 * @since 17.11.14.
 */
public class CarAdapter extends RecyclerView.Adapter<CarAdapter.CarViewHolder> {

    private List<Car> carList;
    private OnCarClickListener clickListener;

    public CarAdapter (List<Car> list, OnCarClickListener clickListener) {

        this.carList = list;
        this.clickListener = clickListener;

    }

    @Override
    public int getItemCount () {
        return carList.size();
    }


    @Override
    public void onBindViewHolder (CarViewHolder carViewHolder, final int i) {
        carViewHolder.carName.setText(carList.get(i).getName());
        carViewHolder.carImage.setBackgroundResource(carList.get(i).getImageId());

        carViewHolder.carImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                clickListener.onCarSelected(carList.get(i));
            }
        });

    }

    @Override
    public CarViewHolder onCreateViewHolder (ViewGroup parent, final int i) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_list_item, parent, false);
        return new CarViewHolder(v);
    }


    public static class CarViewHolder extends RecyclerView.ViewHolder {

        public TextView carName;
        public ImageView carImage;

        public CarViewHolder (View view) {
            super(view);
            carName = (TextView) view.findViewById(R.id.car_name);
            carImage = (ImageView) view.findViewById(R.id.car_image);
        }
    }

    public interface OnCarClickListener {

        void onCarSelected (Car selectedCar);

    }


}
