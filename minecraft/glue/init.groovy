import betterwithmods.api.BWMRecipeHelper
import betterwithmods.BWMItems
import net.minecraft.item.ItemStack

import net.minecraftforge.oredict.OreDictionary

//steel requires crucible, non-stocked is fine
ItemStack steel = OreDictionary.getOres("ingotSteel").get(0).func_77946_l()
steel.field_77994_a = 2 //ItemStack.stackSize
BWMRecipeHelper.addCrucibleRecipe(steel, ["dustCoal", "ingotIron", 2] as Object[])

OreDictionary.getOres("nuggetIron").forEach { ItemStack stack ->
    betterwithmods.util.RecipeUtils.removeFurnaceRecipe(stack)
}

//Soulforged steel requires steel
import betterwithmods.craft.bulk.CraftingManagerCrucibleStoked
import betterwithmods.craft.bulk.BulkRecipe
import betterwithmods.craft.OreStack
import betterwithmods.items.ItemMaterial

List<BulkRecipe> list = CraftingManagerCrucibleStoked.instance.recipes
Iterator itr = list.iterator()
while (itr.hasNext()) {
    BulkRecipe r = itr.next()
    if (r.output.func_77969_a(ItemMaterial.getMaterial(ItemMaterial.EnumMaterial.INGOT_STEEL))) {
        List<Object> inputs = r.getRecipeInput()
        Iterator i = inputs.iterator()
        while(i.hasNext()) {
            Object input = i.next()
            if (input instanceof OreStack && ((OreStack)input).oreName == "ingotIron") {
                i.remove()
                break
            }
        }
        inputs.add(new OreStack("ingotSteel"))
        break
    }
}

//Grout requires kiln
import slimeknights.tconstruct.shared.TinkerCommons

BWMRecipeHelper.addKilnRecipe(TinkerCommons.blockSoil, 0, TinkerCommons.searedBrick)

betterwithmods.util.RecipeUtils.removeFurnaceRecipe(TinkerCommons.grout)

//Coal coke.
import mods.railcraft.common.blocks.aesthetics.generic.EnumGeneric

BWMRecipeHelper.addKilnRecipe(net.minecraft.init.Blocks.field_150402_ci, 0, EnumGeneric.BLOCK_COKE.stack)
