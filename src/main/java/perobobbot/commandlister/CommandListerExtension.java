package perobobbot.commandlister;


import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Synchronized;
import perobobbot.chat.core.IO;
import perobobbot.command.CommandDeclaration;
import perobobbot.command.CommandDeclarationLister;
import perobobbot.extension.ExtensionBase;
import perobobbot.lang.ExecutionContext;

import java.util.UUID;
import java.util.stream.Collectors;

public class CommandListerExtension extends ExtensionBase {

    private final IO io;
    private final CommandDeclarationLister commandDeclarationLister;

    public CommandListerExtension(@NonNull IO io, @NonNull CommandDeclarationLister commandDeclarationLister) {
        super("Command Lister");
        this.io = io;
        this.commandDeclarationLister = commandDeclarationLister;
    }


    public void listAllCommands(ExecutionContext context) {
        final char prefix = commandDeclarationLister.getPrefix(context.getPlatform());
        final var commands = commandDeclarationLister.getAllActiveCommands(context.getBotId());

        final var message = commands.stream()
                                    .map(CommandDeclarationStringifier.stringifier(prefix))
                                    .collect(Collectors.joining(", "));

        io.send(
                context.getChatConnectionInfo(),
                context.getChannelName(),
                message
        );
    }

}
