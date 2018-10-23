package uk.gaz492.exactspawn.command;

import net.minecraft.command.ICommandSender;
import net.minecraftforge.server.command.CommandTreeBase;

public class CommandExactSpawn extends CommandTreeBase {

    public CommandExactSpawn() {
        addSubcommand(new CommandSetSpawnPitch());
        addSubcommand(new CommandSetSpawnYaw());
        addSubcommand(new CommandSetSpawnPitchYaw());
    }

    @Override
    public String getName() {
        return "exactspawn";
    }

    @Override
    public String getUsage(ICommandSender sender) {
        return "commands.exactspawn.usage";
    }

    @Override
    public int getRequiredPermissionLevel() {
        return 2;
    }
}
