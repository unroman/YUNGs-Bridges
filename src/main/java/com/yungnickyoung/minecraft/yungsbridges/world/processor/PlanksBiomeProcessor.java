package com.yungnickyoung.minecraft.yungsbridges.world.processor;

import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.template.PlacementSettings;
import net.minecraft.world.gen.feature.template.Template;

import java.util.Random;

/**
 * Processor responsible for replacing planks based on biome.
 */
public class PlanksBiomeProcessor implements ITemplateFeatureProcessor {
    @Override
    public void processTemplate(Template template, ISeedReader world, Random rand, BlockPos cornerPos, PlacementSettings placementSettings) {
        Biome biome = world.getBiome(cornerPos);

        // Replace wooden planks for biome variants
        for (Template.BlockInfo blockInfo : template.func_215381_a(cornerPos, placementSettings, Blocks.OAK_PLANKS)) {
            world.setBlockState(blockInfo.pos, getPlanksBiomeVariant(biome), 2);
        }
    }
}