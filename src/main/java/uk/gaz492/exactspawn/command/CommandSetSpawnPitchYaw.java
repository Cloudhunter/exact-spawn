package uk.gaz492.exactspawn.command;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.Entity;
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
import java.util.ArrayList;
import java.util.List;

public class CommandSetSpawnPitchYaw extends CommandBase {
    public static float roundToHalf(float f) {
        return Math.round(f * 2) / 2.0f;
    }

    private ArrayList<String> subCommands = new ArrayList<String>();

    public CommandSetSpawnPitchYaw() {
        this.subCommands.add("help");
        this.subCommands.add("pitch");
        this.subCommands.add("yaw");
    }

    @Override
    public String getName() {
        return "exactSpawn";
    }

    @Override
    public String getUsage(ICommandSender sender) {
        return "/exactSpawn [subCommand]";
    }

    @Override
    //TODO SET PERMISSIONS TO OP ONLY
    public int getRequiredPermissionLevel() {
        return 0;
    }

    @Override
    public boolean checkPermission(MinecraftServer server, ICommandSender sender) {
        return true;
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
        Entity entity = sender.getCommandSenderEntity();
        if (entity instanceof EntityPlayerMP) {
            if (args.length == 0) {
                ConfigHandler.spawnSettings.spawnRotationPitch = roundToHalf(entity.getPitchYaw().x);
                ConfigHandler.spawnSettings.spawnRotationYaw = roundToHalf(entity.getPitchYaw().y);
                ConfigManager.sync(ExactSpawn.MODID, Config.Type.INSTANCE);
                sender.sendMessage(new TextComponentString("Set spawn pitch to: " + TextFormatting.GREEN + roundToHalf(entity.getPitchYaw().x)));
                sender.sendMessage(new TextComponentString("Set spawn yaw to: " + TextFormatting.GREEN + roundToHalf(entity.getPitchYaw().y)));
            } else {
                String subCommand = args[0].toLowerCase();

                if (subCommand.equalsIgnoreCase(this.subCommands.get(0))) {
                    sender.sendMessage(new TextComponentString(TextFormatting.GREEN + "/exactSpawn pitch"));
                    sender.sendMessage(new TextComponentString(TextFormatting.GREEN + "/exactSpawn yaw"));
                } else if (subCommand.equalsIgnoreCase(this.subCommands.get(1))) {
                    ConfigHandler.spawnSettings.spawnRotationPitch = roundToHalf(entity.getPitchYaw().x);
                    ConfigManager.sync(ExactSpawn.MODID, Config.Type.INSTANCE);
                    sender.sendMessage(new TextComponentString("Set spawn pitch to: " + TextFormatting.GREEN + roundToHalf(entity.getPitchYaw().x)));
                } else if (subCommand.equalsIgnoreCase(this.subCommands.get(2))) {
                    ConfigHandler.spawnSettings.spawnRotationYaw = roundToHalf(entity.getPitchYaw().y);
                    ConfigManager.sync(ExactSpawn.MODID, Config.Type.INSTANCE);
                    sender.sendMessage(new TextComponentString("Set spawn yaw to: " + TextFormatting.GREEN + roundToHalf(entity.getPitchYaw().y)));
                } else {
                    sender.sendMessage(new TextComponentString(TextFormatting.RED + "[Exact Spawn] Command not found"));
                }
            }
        }
    }

    @Override
    public List<String> getTabCompletions(MinecraftServer server, ICommandSender sender, String[] args, @Nullable BlockPos pos) {
        return this.subCommands;
    }
}
