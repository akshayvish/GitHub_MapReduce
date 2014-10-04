package com.soulpatch.github.github.datamodels;

import java.util.List;

import com.google.gson.annotations.SerializedName;

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