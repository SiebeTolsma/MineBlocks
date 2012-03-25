package net.bot2k3.siebe.Mineblocks.Mechanisms;

import org.bukkit.*;
import org.bukkit.block.*;
import org.bukkit.material.*;

/**
 * Summary description for DrawBridge.
 */
public class DrawBridge
{
    /**
     * Lowers the bridge.
     * @param block The source block.
     */
    public static void lower(Block block)
    {
        BlockFace faceStairs = DrawBridge.getStairFace(block);
        BlockFace faceOpposite = faceStairs.getOppositeFace();

        Block moving = block.getRelative(BlockFace.UP);
        Block destination = block.getRelative(faceOpposite);

        Material movingMaterial = moving.getType();

        while ((moving != null) &&
               (moving.getType() == movingMaterial) &&
               (destination != null) &&
               (destination.getType() == Material.AIR))
        {
            // we can move this block to the destination.
            destination.setType(movingMaterial);
            destination = destination.getRelative(faceOpposite);

            moving.setType(Material.AIR);
            moving = moving.getRelative(BlockFace.UP);
        }
    }

    /**
     * Raises the bridge.
     * @param block The source block.
     */
    public static void raise(Block block)
    {
        BlockFace faceStairs = DrawBridge.getStairFace(block);
        BlockFace faceOpposite = faceStairs.getOppositeFace();

        Block moving = block.getRelative(faceOpposite);
        Block destination = block.getRelative(BlockFace.UP);

        Material movingMaterial = moving.getType();

        while ((moving != null) &&
               (moving.getType() == movingMaterial) &&
               (destination != null) &&
               (destination.getType() == Material.AIR))
        {
            // we can move this block to the destination.
            destination.setType(movingMaterial);
            destination = destination.getRelative(BlockFace.UP);

            moving.setType(Material.AIR);
            moving = moving.getRelative(faceOpposite);
        }
    }

    /**
     * Checks whether a given block is a drawbridge.
     * @param block The block.
     */
    public static boolean isDrawbridge(Block block)
    {
        // a drawbridge is an iron block that has a staircase on one side of it.
        return (block.getType() == Material.IRON_BLOCK) && 
               (DrawBridge.getStairFace(block) != null);
    }

    private static BlockFace getStairFace(Block block)
    {
        BlockFace[] faces = new BlockFace[] 
        {
            BlockFace.EAST,
            BlockFace.WEST,
            BlockFace.NORTH,
            BlockFace.SOUTH
        };

        for (int i = 0, len = faces.length; i < len; i++)
        {
            Block relative = block.getRelative(faces[i]);
            if (relative != null)
            {
                Material material = relative.getType();

                if ((material == Material.WOOD_STAIRS) ||
                    (material == Material.COBBLESTONE_STAIRS) ||
                    (material == Material.BRICK_STAIRS) ||
                    (material == Material.SMOOTH_STAIRS) ||
                    (material == Material.NETHER_BRICK_STAIRS))
                {
                    return faces[i];
                }
            }
        }

        return null;
    }
}
