package common.cout970.UltraTech.items;

import common.cout970.UltraTech.TileEntities.electric.MinerEntity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class RangeUpgrade extends UT_Item{

	public RangeUpgrade(String name) {
		super(name);
	}

	@Override
	public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int x, int y, int z, int par7, float par8, float par9, float par10)
	{

		if(par3World.getTileEntity(x, y, z) instanceof MinerEntity){

			MinerEntity te = (MinerEntity) par3World.getTileEntity(x, y, z);
			if(te.height < 56 && te.widht < 56){	
				te.height += 2;
				te.widht += 2;
				te.hasMine = false;
				te.current = 0;
				te.hasRangeUpgrades = true;
				te.rangeUpgrades += 1;
				par1ItemStack.splitStack(1);
				return true;
			}else{
				System.out.println(te.height+" "+te.widht);
			}
		}
		return false;
	}
}
