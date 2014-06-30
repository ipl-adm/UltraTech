package common.cout970.UltraTech.blocks.models;

import buildcraft.api.tools.IToolWrench;
import common.cout970.UltraTech.TileEntities.fluid.CopperPipeEntity;
import common.cout970.UltraTech.TileEntities.intermod.EngineEntity;
import common.cout970.UltraTech.core.UltraTech;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class CopperPipe extends FluidPipeBlock{

	public CopperPipe(Material par2Material) {
		super(par2Material);
		setBlockName("CopperPipe");
	}
	
	public boolean onBlockActivated(World w, int x, int y, int z, EntityPlayer p, int par6, float par7, float par8, float par9)
	{
		if(p.isSneaking())return true;
		CopperPipeEntity e = (CopperPipeEntity) w.getTileEntity(x, y, z);
		if(e != null){
			if(p.getCurrentEquippedItem() != null && p.getCurrentEquippedItem().getItem() instanceof IToolWrench){
				e.mode = !e.mode;
				e.lock = e.mode;
				e.Sync();
			}
		}
		return false;
	}

	public void registerBlockIcons(IIconRegister iconRegister){
		this.blockIcon = iconRegister.registerIcon("ultratech:copperpipe");
	}

	public void onNeighborBlockChange(World w, int x, int y, int z, Block side){
		CopperPipeEntity m = (CopperPipeEntity) w.getTileEntity(x, y, z);
		if(m.getNetwork() != null)m.getNetwork().refresh();
		m.onNeighUpdate();
	}
	
	@Override
	public TileEntity createNewTileEntity(World world,int a) {
		return new CopperPipeEntity();
	}

}
