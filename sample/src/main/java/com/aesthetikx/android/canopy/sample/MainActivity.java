package com.aesthetikx.android.canopy.sample;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import com.aesthetikx.android.canopy.CanopyAdapter;
import com.aesthetikx.android.canopy.CanopyItemClickListener;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Comment rootComment = CommentTreeFactory.makeCommentTree(0, 4);

        CanopyAdapter adapter = new CanopyAdapter(this, rootComment);
        ListView list = (ListView) findViewById(R.id.comments_list);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new CanopyItemClickListener(adapter));
    }

}
