package tom_dev.com.roomio_android;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MateAdapter extends RecyclerView.Adapter<MateAdapter.ViewHolder> {

    private ArrayList<Mate> items;
    private int type = 0;
    private Context context;

    public MateAdapter(Context context, ArrayList<Mate> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        this.type = viewType;

        if (type == 0) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.mate_nav_item, null, false);
        }
        else {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.mate_home_item, null, false);
        }
        return new ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        Mate mate = items.get(position);

        viewHolder.getNameTV().setText(mate.getName());

        if (type == 1) {
            viewHolder.getAmountTV().setText("$69");
            viewHolder.getImage().setImageBitmap(mate.getImage());
        }
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView image = null;
        private TextView name = null;
        private TextView amount = null;

        public ViewHolder(View v) {
            super(v);

            name = v.findViewById(R.id.tv_mate_name);

            if (type == 1) {
                amount = v.findViewById(R.id.tv_mate_balance);
                image = v.findViewById(R.id.img_mate);
            }

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (type == 0) {
                        Mate mate = items.get(ViewHolder.this.getAdapterPosition());
                        String id = mate.getID();

                        FragmentTransaction transaction =((MainActivity)context).getSupportFragmentManager().beginTransaction();
                        MateFragment fragment = new MateFragment();
                        Bundle bundle = new Bundle();
                        bundle.putString("mate-id", id);
                        bundle.putString("me-id", "thisUsersID");
                        fragment.setArguments(bundle);
                        transaction.replace(R.id.fragment_container, fragment).commit();
                    }
                }
            });
        }

        public TextView getNameTV() {
            return name;
        }

        public TextView getAmountTV() {
            return amount;
        }

        public ImageView getImage() {
            return image;
        }
    }
}
