package amu.roboclub.ui.fragments;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import amu.roboclub.R;
import amu.roboclub.models.News;
import amu.roboclub.ui.viewholder.NewsHolder;
import butterknife.BindView;
import butterknife.ButterKnife;

public class NewsFragment extends Fragment {

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.no_news)
    LinearLayout loading;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_news, container, false);

        ButterKnife.bind(this, root);

        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        llm.setReverseLayout(true);
        llm.setStackFromEnd(true);
        recyclerView.setLayoutManager(llm);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        DatabaseReference newsReference = FirebaseDatabase.getInstance().getReference("news");
        FirebaseRecyclerAdapter newsAdapter = new FirebaseRecyclerAdapter<News, NewsHolder>(News.class, R.layout.item_announcement, NewsHolder.class, newsReference) {

            @Override
            protected void populateViewHolder(final NewsHolder holder, News news, int position) {

                if (loading.getVisibility() == View.VISIBLE)
                    loading.setVisibility(View.GONE);

                holder.setNews(getContext(), news);

            }
        };

        recyclerView.setAdapter(newsAdapter);

        return root;
    }
}
