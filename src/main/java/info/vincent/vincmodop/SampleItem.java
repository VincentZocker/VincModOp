package info.vincent.vincmodop;

import info.vincent.vincmodop.reference.Reference;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;

import javax.annotation.ParametersAreNonnullByDefault;

public class SampleItem extends Item {
    public SampleItem() {
        super(new Item.Properties().group(ModItemGroups.weaponsItemGroup));
        setRegistryName(Reference.REIGSTRY_NAME_SAMPLE_ITEM);
    }

    @Override
    @ParametersAreNonnullByDefault
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        EntityRayTraceResult entityraytraceresult = ProjectileHelper.rayTraceEntities(worldIn, playerIn,
                playerIn.getEyePosition(1),
                playerIn.getEyePosition(1)
                        .add(playerIn.getLook(1.0F).x * 32,
                                playerIn.getLook(1.0F).y * 32,
                                playerIn.getLook(1.0F).z * 32),
                playerIn.getBoundingBox()
                        .expand(playerIn.getLook(1.0F).scale(32)), (p_215312_0_) -> {
                    return !p_215312_0_.isSpectator() && p_215312_0_.canBeCollidedWith();
                }); // , 1024
        ItemStack itemstack = playerIn.getHeldItem(handIn);
        if (entityraytraceresult != null) {
            // found entity so attack it if possible !
            // TSRTS.LOGGER.info("Hit entity:" + entityraytraceresult.getEntity().getName());
            if (entityraytraceresult.getEntity() instanceof LivingEntity) {
                LivingEntity le = (LivingEntity) entityraytraceresult.getEntity();
                if (!playerIn.world.isRemote) {
                    // TODO need to consider if the player is on the same team as the entity or not !
//                    if (playerIn.getTeam() != null && !(playerIn.getTeam().isSameTeam(le.getTeam()))) {
//                        Utilities.SelectedUnitsTargetEntity(worldIn, le, playerIn.getScoreboardName());
//                    } else if (playerIn.getTeam() == null) {
//                        Utilities.SelectedUnitsTargetEntity(worldIn, le, playerIn.getScoreboardName());
//                    }
                }
            }
        } else {
            // NO ENTITY FOUND so instead look for a block move
            Vector3d vec3d = playerIn.getEyePosition(1);
            Vector3d vec3d1 = playerIn.getLook(1);
            Vector3d vec3d2 = vec3d.add(vec3d1.x * 32, vec3d1.y * 32, vec3d1.z * 32);
            RayTraceResult rtr = worldIn.rayTraceBlocks(new RayTraceContext(vec3d, vec3d2, RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, playerIn));
            if (rtr.getType() == RayTraceResult.Type.BLOCK) {
                if (rtr instanceof BlockRayTraceResult) {
                    BlockRayTraceResult brtr = (BlockRayTraceResult) rtr;
                    if (!worldIn.isRemote) {
                        VincModOp.LOGGER.info("Block HIT at:" + brtr.getPos());
                        // Utilities.SelectedUnitsMoveToBlock(worldIn, brtr.getPos(), playerIn.getScoreboardName(), playerIn, false, false);
                    }
                }
            } else {
                VincModOp.LOGGER.debug("ignore onItemRightClick");
            }
        }
        return new ActionResult<>(ActionResultType.SUCCESS, itemstack);
    }
}
