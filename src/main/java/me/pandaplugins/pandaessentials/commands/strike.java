package me.pandaplugins.pandaessentials.commands;

import me.pandaplugins.pandaessentials.PandaEssentials;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class strike implements CommandExecutor {

  Plugin plugin = PandaEssentials.getPlugin(PandaEssentials.class);

  @Override
  public boolean onCommand(CommandSender sender, Command command, String label,
                           String[] args) {

    if (sender instanceof Player) {
      Player player = (Player)sender;
      Block target = player.getTargetBlockExact(30);
      Location loc = target.getLocation();

      player.getWorld().spawnEntity(loc, EntityType.LIGHTNING);

    } else {
      plugin.getLogger().severe("This command has be run as a player");
    }

    return true;
  }
}
