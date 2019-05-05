package adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.onlineclothingshoppingapp.DescriptionActivity;
import com.example.onlineclothingshoppingapp.R;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import model.Pant;

public class PantAdapter extends RecyclerView.Adapter<PantAdapter.ItemsViewHolder> {
    Context mContext;
    List<Pant> pantList;

    public PantAdapter(Context mContext, List<Pant> pantList) {
        this.mContext = mContext;
        this.pantList = pantList;
    }

    @NonNull
    @Override
    public ItemsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_viewitems,viewGroup,false);
        return new ItemsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemsViewHolder itemsViewHolder, int i) {
        final Pant pant = pantList.get(i);
        itemsViewHolder.impProfile.setImageResource(pant.getItemImage());
        itemsViewHolder.tvName.setText(pant.getItemName());
        itemsViewHolder.tvPrice.setText(pant.getItemPrice());

        itemsViewHolder.impProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, DescriptionActivity.class);

                intent.putExtra("image", pant.getItemImage());
                intent.putExtra("name", pant.getItemName());
                intent.putExtra("price", pant.getItemPrice());
                intent.putExtra("description", pant.getItemDescription());

                mContext.startActivity(intent);
            }
        });
    }
    @Override
    public int getItemCount() {
        return pantList.size();
    }

    public class ItemsViewHolder extends RecyclerView.ViewHolder{
        CircleImageView impProfile;
        TextView tvName,tvPrice;

        public ItemsViewHolder(@NonNull View itemView) {
            super(itemView);
            impProfile = itemView.findViewById(R.id.img);
            tvName = itemView.findViewById(R.id.tvName);
            tvPrice = itemView.findViewById(R.id.tvPrice);
        }
    }
}