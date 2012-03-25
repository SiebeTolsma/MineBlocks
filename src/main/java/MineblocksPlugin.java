package net.bot2k3.siebe.Mineblocks;

import net.bot2k3.siebe.Mineblocks.Blocks.*;

import org.bukkit.*;
import org.bukkit.block.*;
import org.bukkit.event.*;
import org.bukkit.event.block.*;
import org.bukkit.plugin.java.*;

/**
 * Provides the main plugin interface.
 */
public class MineblocksPlugin extends JavaPlugin implements Listener
{
    /**
     * Occurs when the plugin is being enabled.
     */
    public void onEnable()
    {
        this.getServer().getPluginManager().registerEvents(this, this);
    }

    /**
     * Occurs when the plugin is being disabled.
     */
    public void onDisable()
    {
    }

    /**
     * Occurs when a furnace is burning.
     */
	@EventHandler
    public void onBlockRedstoneEvent(BlockRedstoneEvent e)
    {
        Block block = e.getBlock();
        
        // look around the redstone block to see what this is powering.
        BlockFace[] faces = new BlockFace[] 
        {
            BlockFace.UP,
            BlockFace.EAST,
            BlockFace.WEST,
            BlockFace.NORTH,
            BlockFace.SOUTH,
        };

        for (int i = 0, len = faces.length; i < len; i++)
        {
            Block relative = block.getRelative(faces[i]);

            if (relative.getType() == Material.IRON_BLOCK)
            {
                // handle the redstone event for a piston.
                if (IronBlock.handleRedstoneEvent(e, relative))
                {
                    break;
                }
            }
        }
    }
}
