package com.soulpatch.github.github.datamodels;

import java.net.URL;

public class Tree {
	private String SHA;
	private URL url;
	Tree[] trees;
	String path;
	private String mode;
	private String type;
	private String sha;
	private int size;
	
	public Tree[] getTrees() {
		return trees;
	}
	public void setTrees(Tree[] trees) {
		this.trees = trees;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getMode() {
		return mode;
	}
	public void setMode(String mode) {
		this.mode = mode;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSha() {
		return sha;
	}
	public void setSha(String sha) {
		this.sha = sha;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public String getSHA() {
		return SHA;
	}
	public void setSHA(String sHA) {
		SHA = sHA;
	}
	public URL getUrl() {
		return url;
	}
	public void setUrl(URL url) {
		this.url = url;
	}
}
