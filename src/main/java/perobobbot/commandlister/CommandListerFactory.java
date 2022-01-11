
package perobobbot.commandlister;


import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import jplugman.api.Requirement;
import jplugman.api.ServiceProvider;
import lombok.NonNull;
import perobobbot.access.AccessRule;
import perobobbot.chat.core.IO;
import perobobbot.command.CommandDeclaration;
import perobobbot.command.CommandDeclarationLister;
import perobobbot.commandlister.command.ListAllCommands;
import perobobbot.extension.ExtensionFactory;
import perobobbot.extension.ExtensionPlugin;
import perobobbot.lang.Role;
import perobobbot.plugin.PerobobbotPlugin;

import java.time.Duration;

/**
 * This is the entry point of the plugin (at the jplugman level).
 * <p>
 * For jplugman, the plugin provides a service which in the case
 * of the bot, is an ExtensionPlugin (which might be confusing, sorry).
 * <p>
 * An ExtensionPlugin is a plugin for the Bot to add an extension to itself.
 */
public class CommandListerFactory implements ExtensionFactory<CommandListerExtension> {


    @Override
    public @NonNull CommandListerExtension createExtension(@NonNull ModuleLayer pluginLayer, @NonNull ServiceProvider serviceProvider) {
        return new CommandListerExtension(
                serviceProvider.getAnyService(IO.class),
                serviceProvider.getAnyService(CommandDeclarationLister.class)
        );
    }

    @Override
    public @NonNull ImmutableList<CommandDeclaration> createCommandDefinitions(@NonNull CommandListerExtension extension,
                                                                                 @NonNull ServiceProvider serviceProvider,
                                                                                  CommandDeclaration.@NonNull Factory factory) {
        final var accessRule = AccessRule.create(Role.ANY_USER, Duration.ofSeconds(30));
        return ImmutableList.of(
                factory.create("cmds", accessRule, new ListAllCommands(extension))
        );
    }
}
