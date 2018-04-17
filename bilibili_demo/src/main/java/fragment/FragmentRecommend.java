package fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.sixrooms.s518.drawerlayouttest.R;

import adapter.RecommendAdapter;

/**
 * 推荐页面
 * Created by xushaodong on 2016/4/25.
 */
public class FragmentRecommend extends BaseFragment {
    private Context context;
    private GridView mGridView;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        context = activity;

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmentrecommend,container,false);
        mGridView = (GridView) view.findViewById(R.id.gv_recommend);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mGridView.setAdapter(new RecommendAdapter(context));

    }
}
