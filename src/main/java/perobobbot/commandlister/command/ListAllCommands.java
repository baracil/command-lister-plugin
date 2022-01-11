package perobobbot.commandlister.command;


import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import perobobbot.command.CommandAction;
import perobobbot.command.CommandParsing;
import perobobbot.lang.ExecutionContext;

import perobobbot.commandlister.CommandListerExtension;

@RequiredArgsConstructor
public class ListAllCommands implements CommandAction {

    private final @NonNull CommandListerExtension extension;

    @Override
    public void execute(@NonNull CommandParsing parsing, @NonNull ExecutionContext context) {
        extension.listAllCommands(context);
    }
}
