package perobobbot.commandlister;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import perobobbot.command.CommandDeclaration;
import perobobbot.lang.Role;
import perobobbot.lang.fp.Function1;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class CommandDeclarationStringifier {

    public static @NonNull Function1<CommandDeclaration,String> stringifier(char prefix) {
        return commandDeclaration -> stringify(prefix,commandDeclaration);
    }


    public static @NonNull String stringify(char prefix,@NonNull CommandDeclaration commandDeclaration) {
        return new CommandDeclarationStringifier(prefix,commandDeclaration).stringify();
    }

    private final char prefix;
    private final @NonNull CommandDeclaration commandDeclaration;

    private boolean availableForAnyUser;
    private String result;

    private @NonNull String stringify() {
        this.determineIfCommandIsAvailableForAnyUser();
        this.buildResult();
        return result;
    }

    private void buildResult() {
        final var adminIndicator = availableForAnyUser?"":"*";
        this.result = adminIndicator+prefix+commandDeclaration.getDefinition();
    }

    private void determineIfCommandIsAvailableForAnyUser() {
        final var accessRule = commandDeclaration.getDefaultAccessRule();
        availableForAnyUser = accessRule.getRequiredRole() == Role.ANY_USER || accessRule.getCoolDowns().containsKey(Role.ANY_USER);
    }
}
