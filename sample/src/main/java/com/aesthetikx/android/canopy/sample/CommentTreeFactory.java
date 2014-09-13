package com.aesthetikx.android.canopy.sample;

import com.thedeanda.lorem.Lorem;

import java.util.ArrayList;
import java.util.List;

import com.aesthetikx.android.canopy.CanopyItem;

public class CommentTreeFactory {

    public static Comment makeCommentTree(int depth, int maxDepth) {

        List<CanopyItem> children = new ArrayList<CanopyItem>();

        String uname = Lorem.getName();
        String body = Lorem.getWords(3, 30);

        if (depth < maxDepth) {
            for (int i = 0; i < depth + 1; i++) {
                children.add(makeCommentTree(depth + 1, maxDepth));
            }
        }

        return new Comment(uname, body, children, depth);
    }

}
