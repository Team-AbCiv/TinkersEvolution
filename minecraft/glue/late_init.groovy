//Hellfire. Remove this at the time Glease has a robust fix
import meltery.common.MelteryHandler
import meltery.common.MelteryRecipe
import net.minecraftforge.oredict.OreDictionary
import net.minecraftforge.fluids.FluidRegistry
import net.minecraftforge.fluids.Fluid
import net.minecraft.item.ItemStack

Iterator<MelteryRecipe> itrMeltery = MelteryHandler.meltingRecipes.iterator()
Fluid hellfireFluid = FluidRegistry.getFluid("hellfire")

while (itrMeltery.hasNext()) {
    MelteryRecipe r = itrMeltery.next()
    if (r.output.fluid == hellfireFluid) {
        if (r.matches(OreDictionary.getOres("dustHellfire")[0])) {
            itrMeltery.remove()
            break
        }
    }
}

import net.minecraftforge.fluids.FluidStack

MelteryRecipe newRecipe = new MelteryRecipe(slimeknights.mantle.util.RecipeMatch.of("dustHellfire", 18), new FluidStack(hellfireFluid, 18))
MelteryHandler.meltingRecipes.add(newRecipe) //TODO make use of operator overloading

//More saw interaction
import betterwithmods.BWCrafting
import net.minecraft.init.Blocks
import betterwithmods.BWMBlocks

BWCrafting.addSawRecipe(Blocks.@field_150462_ai, 0, new ItemStack(Blocks.@field_150344_f))

for (meta in 0..7) {
    BWCrafting.addSawRecipe(Blocks.@field_150476_ad, meta, new ItemStack(BWMBlocks.@WOOD_MOULDING, 3, 0))
    BWCrafting.addSawRecipe(Blocks.@field_150485_bF, meta, new ItemStack(BWMBlocks.@WOOD_MOULDING, 3, 1))
    BWCrafting.addSawRecipe(Blocks.@field_150487_bG, meta, new ItemStack(BWMBlocks.@WOOD_MOULDING, 3, 2))
    BWCrafting.addSawRecipe(Blocks.@field_150481_bH, meta, new ItemStack(BWMBlocks.@WOOD_MOULDING, 3, 3))
    BWCrafting.addSawRecipe(Blocks.@field_150400_ck, meta, new ItemStack(BWMBlocks.@WOOD_MOULDING, 3, 4))
    BWCrafting.addSawRecipe(Blocks.@field_150401_cl, meta, new ItemStack(BWMBlocks.@WOOD_MOULDING, 3, 5))
}

for (meta in 0..5) {
    BWCrafting.addSawRecipe(Blocks.@field_150376_bx, meta, new ItemStack(BWMBlocks.@WOOD_MOULDING, 2, meta))
    BWCrafting.addSawRecipe(Blocks.@field_150376_bx, meta + 8, new ItemStack(BWMBlocks.@WOOD_MOULDING, 4, meta))
}

//Smelting metal plates 
import mods.railcraft.common.items.Metal
import slimeknights.tconstruct.library.TinkerRegistry
import slimeknights.tconstruct.shared.TinkerFluids

for (metal in Metal.VALUES) {
    net.minecraftforge.oredict.OreDictionary.registerOre(metal.getOreTag(Metal.Form.PLATE), metal.getStack(Metal.Form.PLATE))
}
TinkerRegistry.registerMelting("plateIron", TinkerFluids.@iron, 144)
TinkerRegistry.registerMelting("plateGold", TinkerFluids.@gold, 144)
TinkerRegistry.registerMelting("plateCopper", TinkerFluids.@copper, 144)
TinkerRegistry.registerMelting("plateTin", TinkerFluids.@tin, 144)
TinkerRegistry.registerMelting("plateBronze", TinkerFluids.@bronze, 144)
TinkerRegistry.registerMelting("plateZinc", TinkerFluids.@zinc, 144)
TinkerRegistry.registerMelting("plateLead", TinkerFluids.@lead, 144)
TinkerRegistry.registerMelting("plateSteel", TinkerFluids.@steel, 144)
TinkerRegistry.registerMelting("plateNickel", TinkerFluids.@nickel, 144)
TinkerRegistry.registerMelting("plateSilver", TinkerFluids.@silver, 144)
