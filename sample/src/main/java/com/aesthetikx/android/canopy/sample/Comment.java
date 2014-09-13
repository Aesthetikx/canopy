package com.aesthetikx.android.canopy.sample;

import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aesthetikx.android.canopy.BaseCanopyItem;
import com.aesthetikx.android.canopy.CanopyItem;
import com.aesthetikx.android.canopy.view.CanopyRowView;

import java.util.List;

public class Comment extends BaseCanopyItem {

    private String username;
    private String body;

    public Comment(String username, String body, List<CanopyItem> children, int depth) {
        super(true, true, depth, children);
        this.username = username;
        this.body = body;
    }

    @Override
    public View getExpandedView(LayoutInflater inflater, ViewGroup parent) {
        CanopyRowView canopyRow = (CanopyRowView) super.getExpandedView(inflater, parent);
        RelativeLayout content = canopyRow.getContentLayout();

        LinearLayout commentLayout = (LinearLayout) inflater.inflate(R.layout.comment_layout, null, false);

        content.addView(commentLayout);

        ((TextView) commentLayout.findViewById(R.id.username)).setText(username);
        ((TextView) commentLayout.findViewById(R.id.body)).setText(body);

        return canopyRow;
    }

    @Override
    public View getCollapsedView(LayoutInflater inflater, ViewGroup parent) {
        CanopyRowView canopyRow = (CanopyRowView) super.getExpandedView(inflater, parent);
        RelativeLayout content = canopyRow.getContentLayout();
        TextView text = new TextView(inflater.getContext());
        text.setText((getChildCount() + 1) + " comment(s) hidden");
        content.addView(text,
                new RelativeLayout.LayoutParams(
                    RelativeLayout.LayoutParams.WRAP_CONTENT,
                    RelativeLayout.LayoutParams.WRAP_CONTENT));

        return canopyRow;
    }

}
