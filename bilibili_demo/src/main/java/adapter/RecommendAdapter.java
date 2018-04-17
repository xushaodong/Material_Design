package adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.sixrooms.s518.drawerlayouttest.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dell on 2016/4/25.
 */
public class RecommendAdapter extends BaseAdapter {
    private List list = new ArrayList();
    private Context context;
    public RecommendAdapter(Context context){
        this.context = context;
    }

    @Override
    public int getCount() {
        return 20;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView == null){
            viewHolder = new ViewHolder();
            convertView = View.inflate(context, R.layout.item_recommend,null);
            viewHolder.imageView = (ImageView) convertView.findViewById(R.id.iv_recommend_item);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }


        return convertView;
    }

    static class ViewHolder{
        ImageView imageView;

    }


}
