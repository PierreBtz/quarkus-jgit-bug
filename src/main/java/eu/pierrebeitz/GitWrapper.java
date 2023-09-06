package eu.pierrebeitz;

import org.eclipse.jgit.api.LsRemoteCommand;

public interface GitWrapper {

  LsRemoteCommand lsRemoteRepository();

}
