package g.y.v.anew.Other;

/**
 * Created by galqayeva on 25.10.2017.
 */



import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import g.y.v.anew.Models.CategoryModel;
import g.y.v.anew.R;

import java.util.List;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private List<CategoryModel> modelList;
    private Context context;


    public MyAdapter(List<CategoryModel> modelList, Context context) {
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
        final CategoryModel model=modelList.get(position);

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