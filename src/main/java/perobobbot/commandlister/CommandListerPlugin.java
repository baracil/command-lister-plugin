package perobobbot.commandlister;


import jplugman.annotation.Extension;
import jplugman.api.Disposable;
import jplugman.api.ServiceProvider;
import lombok.Getter;
import lombok.NonNull;
import perobobbot.extension.PerobobbotExtensionPluginBase;
import perobobbot.plugin.PerobobbotPlugin;

@Getter
@Extension(point = PerobobbotPlugin.class, version = "1.0.0")
public class CommandListerPlugin extends PerobobbotExtensionPluginBase implements  Disposable {

    public CommandListerPlugin(@NonNull ModuleLayer pluginLayer, @NonNull ServiceProvider serviceProvider) {
        super(new CommandListerFactory(), pluginLayer, serviceProvider);
    }

    @Override
    public void dispose() {}
}
