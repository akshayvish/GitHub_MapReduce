package com.soulpatch.github

import FileUtils.ReadProperties
import FileUtils.StringUtils

import com.google.gson.Gson
import sun.misc.BASE64Decoder;
import com.soulpatch.github.github.datamodels.Branch
import com.soulpatch.github.github.datamodels.Commit
import com.soulpatch.github.github.datamodels.GitBlob
import com.soulpatch.github.github.datamodels.Repository
import com.soulpatch.github.github.datamodels.Tree
import com.soulpatch.github.github.datamodels.Trees

public class GitFunctions {

	private static String BLOB = "blob";
	private static String TREE = "tree";

	public void getRepository(URL gitHomeURL, String repositoryName, String user){
		URL reposURL = new URL("$gitHomeURL${StringUtils.REPOS}${ReadProperties.readGitProperties(StringUtils.USER)}${repositoryName}")
		println "${reposURL.toString()}"
		String json = reposURL.getText()
		Gson gson = new Gson()
		Repository repository = gson.fromJson(json, Repository.class)
	}

	/**
	 *
	 * @param repoName
	 */
	public List<Repository> getUserRepositoties(URL gitHomeURL, String user){
		URL reposURL = new URL("$gitHomeURL${StringUtils.USERS}${ReadProperties.readGitProperties(StringUtils.USER)}${StringUtils.REPOS}")
		println "${reposURL.toString()}"
		String json = reposURL.getText()
		Gson gson = new Gson()
		List<Repository> repositories = gson.fromJson(json, Repository[].class)
		return repositories;
	}

	/**
	 * Get all the public repositories in the given GitHub instance.
	 */
	public List<Repository> getAllPublicRepositories(URL gitHomeURL){
		println "************ $gitHomeURL${StringUtils.REPOSITORIES}"
		URL reposURL = new URL("$gitHomeURL${StringUtils.REPOSITORIES}")
		String json = reposURL.getText()
		Gson gson = new Gson()
		List<Repository> repositories = gson.fromJson(json, ArrayList.class)
		return repositories;
	}

	/**
	 * Get the master branch for the given repository
	 *
	 * @return {@link Branch} object for the JSON returned
	 */
	public Branch getMasterBranch(URL gitHomeURL, String repository, String user){
		URL reposURL = new URL("$gitHomeURL${StringUtils.REPOS}${ReadProperties.readGitProperties(StringUtils.USER)}${repository}${StringUtils.BRANCH_MASTER}")
		String json = reposURL.getText()
		Gson gson = new Gson()
		Branch branch = gson.fromJson(json, Branch.class)
		Commit commit = branch.getCommit();
		return branch;
	}

	/**
	 * Get all the files within the current project.
	 *
	 * @param sha SHA of the master branch of the project
	 */
	public void getAllContent(URL treeURL){
		URL reposURL = new URL("$treeURL")

		String json = reposURL.getText()
		Gson gson = new Gson()
		Trees trees = gson.fromJson(json, Trees.class)
		List<Tree> treeList = trees.getTrees();
		int length = treeList.size()
		for(int i=0 ;i <length; i++){
			if(treeList.get(i).getType() == BLOB){
				String jsonBlob = treeList.get(i).getUrl().getText();
				GitBlob blob = gson.fromJson(jsonBlob, GitBlob.class);
				println "${decode(blob.getContent())}";
			}else if(treeList.get(i).getType() == TREE){
				String jsonTree = treeList.get(i).getUrl().getText()
				Trees interTrees = gson.fromJson(jsonTree, Trees.class)
				treeList.addAll(interTrees.getTrees())
				length = treeList.size();
			}
		}
	}

	/**
	 * Decode a Base64 string
	 * 
	 * @param base64String String in Base64 enconding format 
	 * @throws IOException thrown by the decoder
	 */
	private static void decode(String base64String) throws IOException {
		BASE64Decoder decoder = new BASE64Decoder();
		byte[] decodedBytes = decoder.decodeBuffer(base64String);
		println "*******************************************"
		System.out.println("decodedBytes " + new String(decodedBytes));
		println "*******************************************"
	}
}