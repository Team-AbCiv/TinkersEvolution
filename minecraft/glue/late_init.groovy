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

