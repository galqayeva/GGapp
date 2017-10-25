package g.y.v.anew.Other;

/**
 * Created by galqayeva on 25.10.2017.
 */



import android.content.Context;
import android.content.SharedPreferences;
import android.provider.Settings;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import g.y.v.anew.Models.Category;
import g.y.v.anew.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static android.content.Context.MODE_PRIVATE;



public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private List<Category> modelList;
    private Context context;


    public MyAdapter(List<Category> modelList, Context context) {
        this.modelList=modelList;
        this.context = context;
    }



    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.category_list,parent,false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        final Category model=modelList.get(position);

        holder.date.setText(model.getOtherText());
        holder.category.setText(model.getBirthdayText());


    }



    @Override
    public int getItemCount() {
        return modelList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        public  TextView date,category;

        public ViewHolder(View itemView) {
            super(itemView);

            date=(TextView)itemView.findViewById(R.id.twDate);
            category=(TextView)itemView.findViewById(R.id.twCategory);
        }
    }
}