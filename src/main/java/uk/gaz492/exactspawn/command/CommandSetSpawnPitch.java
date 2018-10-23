package uk.gaz492.exactspawn.command;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import uk.gaz492.exactspawn.ConfigHandler;
import uk.gaz492.exactspawn.ExactSpawn;

import javax.annotation.Nullable;
import java.util.List;

public class CommandSetSpawnPitch extends CommandBase {

    private static float roundToHalf(float f) {
        return Math.round(f * 2) / 2.0f;
    }

    @Override
    public String getName() {
        return "setpitch";
    }

    @Override
    public String getUsage(ICommandSender sender) {
        return "commands.exactspawn.setpitch.usage";
    }

    @Override
    public int getRequiredPermissionLevel() {
        return 2;
    }

    @Override
    public List<String> getTabCompletions(MinecraftServer server, ICommandSender sender, String[] args, @Nullable BlockPos pos) {
        return super.getTabCompletions(server, sender, args, pos);
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
        EntityPlayerMP player = getCommandSenderAsPlayer(sender);
        ConfigHandler.spawnSettings.spawnRotationPitch = roundToHalf(player.getPitchYaw().x);
        ConfigManager.sync(ExactSpawn.MODID, Config.Type.INSTANCE);
        sender.sendMessage(new TextComponentString("Set spawn pitch to: " + TextFormatting.GREEN + roundToHalf(player.getPitchYaw().x)));
    }
}
