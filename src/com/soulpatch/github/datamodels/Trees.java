package com.soulpatch.github.github.datamodels;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Trees {
    @SerializedName("tree")
    List<Tree> trees;

    public List<Tree> getTrees() {
        return trees;
    }

    public void setTrees(List<Tree> trees) {
        this.trees = trees;
    }
}