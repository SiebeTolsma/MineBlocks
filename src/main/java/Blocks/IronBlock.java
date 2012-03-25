package net.bot2k3.siebe.Mineblocks.Blocks;

import net.bot2k3.siebe.Mineblocks.Mechanisms.*;

import org.bukkit.*;
import org.bukkit.block.*;
import org.bukkit.event.block.*;
import org.bukkit.material.*;

/**
 * Handles events for a piston block.
 */
public class IronBlock
{
    /**
     * Handles a redstone event for a piston block.
     * @param e The event.
     * @param block The block.
     */
    public static boolean handleRedstoneEvent(BlockRedstoneEvent e, Block block)
    {
        if (DrawBridge.isDrawbridge(block))
        {
            if (e.getNewCurrent() > e.getOldCurrent())
            {
                DrawBridge.lower(block);
            }
            else
            {
                DrawBridge.raise(block);
            }

            return true;
        }

        return false;
    }
}
