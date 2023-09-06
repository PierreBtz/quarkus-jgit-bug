package eu.pierrebeitz;

import io.quarkus.arc.Unremovable;
import javax.enterprise.context.ApplicationScoped;
import picocli.CommandLine;

@ApplicationScoped
@Unremovable
public class VersionProvider implements CommandLine.IVersionProvider {

    private final GitWrapper gitWrapper;

    public VersionProvider(GitWrapper gitWrapper) {
        this.gitWrapper = gitWrapper;
    }

    @Override
    public String[] getVersion() {
        return new String[] { "" };
    }
}
