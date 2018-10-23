package uk.gaz492.exactspawn.command;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import uk.gaz492.exactspawn.ConfigHandler;
import uk.gaz492.exactspawn.ExactSpawn;

public class CommandSetSpawnYaw extends CommandBase {

    private static float roundToHalf(float f) {
        return Math.round(f * 2) / 2.0f;
    }

    @Override
    public String getName() {
        return "setyaw";
    }

    @Override
    public String getUsage(ICommandSender sender) {
        return "commands.exactspawn.setyaw.usage";
    }

    @Override
    public int getRequiredPermissionLevel() {
        return 2;
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
        EntityPlayerMP player = getCommandSenderAsPlayer(sender);
        ConfigHandler.spawnSettings.spawnRotationYaw = roundToHalf(player.getPitchYaw().y);
        ConfigManager.sync(ExactSpawn.MODID, Config.Type.INSTANCE);
        sender.sendMessage(new TextComponentString("Set spawn yaw to: " + TextFormatting.GREEN + roundToHalf(player.getPitchYaw().y)));
    }
}
