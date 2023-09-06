package eu.pierrebeitz;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.LsRemoteCommand;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class DefaultGitWrapper implements GitWrapper {

    @Override
    public LsRemoteCommand lsRemoteRepository() {
        return Git.lsRemoteRepository();
    }

}
