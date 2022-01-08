package com.hauntedchest.the_patchlands.block;

import com.hauntedchest.the_patchlands.PatchlandsMain;
import com.hauntedchest.the_patchlands.block.block_classes.IgnisteelOreBlock;
import com.hauntedchest.the_patchlands.item.ModCreativeTab;
import com.hauntedchest.the_patchlands.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, PatchlandsMain.MOD_ID);

    public static final RegistryObject<Block> BRITTLESTONE = registerBlock("brittlestone",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_GREEN)
                    .requiresCorrectToolForDrops()
                    .strength(3.5F, 4F)), ModCreativeTab.PATCHLANDS_BLOCKS_TAB);

    public static final RegistryObject<Block> IGNISTEEL_ORE = registerBlock("ignisteel_ore",
            () -> new IgnisteelOreBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_YELLOW)
                    .requiresCorrectToolForDrops()
                    .strength(3.5F, 3F)), ModCreativeTab.PATCHLANDS_BLOCKS_TAB);

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab){
        RegistryObject<T> toReturn = BLOCKS.register(name,block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab){
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().tab(tab)));
    }

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block){
        RegistryObject<T> toReturn = BLOCKS.register(name,block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block){
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().tab(ModCreativeTab.PATCHLANDS_BLOCKS_TAB)));
    }






    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}