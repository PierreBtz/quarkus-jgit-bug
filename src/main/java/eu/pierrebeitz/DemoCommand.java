package eu.pierrebeitz;

import org.eclipse.jgit.util.FS;
import org.eclipse.jgit.util.SystemReader;
import io.quarkus.logging.Log;
import io.quarkus.picocli.runtime.annotations.TopCommand;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import picocli.CommandLine;

@QuarkusMain
@TopCommand
@CommandLine.Command(subcommands = CommandLine.HelpCommand.class)
public class DemoCommand implements QuarkusApplication {

    @Override
    public int run(String... args) throws Exception {
        peakSystemReader();

        Log.infof("JGitConfig computed by calling openJGitConfig: %s", SystemReader.getInstance().openJGitConfig(null, FS.DETECTED));
        Log.infof("JGitConfig retrieved by calling getJGitConfig: %s", SystemReader.getInstance().getJGitConfig().toString());
        return 0;
    }

    private static void peakSystemReader() throws NoSuchFieldException, IllegalAccessException {
        // this field is somehow set at build time
        var jgitConfigField = SystemReader.class.getDeclaredField("jgitConfig");
        jgitConfigField.setAccessible(true);
        var jgitConfig = jgitConfigField.get(SystemReader.getInstance());
        Log.infof("Value of the org.eclipse.jgit.util.SystemReader#jgitConfig field before any call to getJGitConfig: %s", jgitConfig);
    }
}
