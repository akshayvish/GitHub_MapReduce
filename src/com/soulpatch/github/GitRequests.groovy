package com.soulpatch.github

import com.soulpatch.github.datamodels.Branch
import com.soulpatch.github.datamodels.Repository
import com.soulpatch.fileUtils.StringUtils
import com.soulpatch.fileUtils.ReadProperties;

public class GitRequests {

    public static URL gitHomeURL;

    public static void main(String[] args) {
        String user = "/akshayvish";
        GitFunctions gitFunction = new GitFunctions();
//		GitRequests gitRequests = new GitRequests();
        gitHomeURL = new URL(ReadProperties.readGitProperties(StringUtils.GIT_HOME));
//		List<Repository> repositories = gitFunction.getAllPublicRepositories(gitHomeURL);
        List<Repository> repositories = gitFunction.getUserRepositoties(gitHomeURL, user);
        for (Repository repository : repositories) {
//			gitFunction.getRepository(repository.getName(), "/akshayvish");
//			gitFunction.getUserRepositoties(repository.getName());
            println "Repository ${repository.getName()}"
            Branch branch = gitFunction.getMasterBranch(gitHomeURL, "/" + repository.getName(), user);
//			gitFunction.getAllContent(gitHomeURL, repository.getName(), user, "/" + branch.getCommit().getSha());
            gitFunction.getAllContent(branch.getCommit().getCommit().getTree().getUrl())
        }
    }
}
