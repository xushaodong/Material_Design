package adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sixrooms.s518.drawerlayouttest.DetailsActivity;
import com.sixrooms.s518.drawerlayouttest.R;

/**
 * Created by dell on 2016/4/10.
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> implements View.OnClickListener {
    private int[] colors = {R.color.color_0, R.color.color_1, R.color.color_2, R.color.color_3,
            R.color.color_4, R.color.color_5, R.color.color_6, R.color.color_7,
            R.color.color_8, R.color.color_9,};
    private Context mContext;

    public RecyclerViewAdapter(Context context) {
        mContext = context;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        TextView view = (TextView) LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mTextView.setBackgroundColor(mContext.getResources().getColor(colors[position % (colors.length)]));
        holder.mTextView.setText(position + "");
        holder.mTextView.setOnClickListener(this);

    }

    @Override
    public int getItemCount() {
        return colors.length*2;
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(mContext,DetailsActivity.class);
        mContext.startActivity(intent);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView mTextView;

        public ViewHolder(TextView view) {
            super(view);
            mTextView = view;
        }
    }
}
