package net.erzekawek.enditions.blocks;

import net.minecraft.util.StringRepresentable;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import org.betterx.bclib.blocks.BlockProperties;

public class EnditionsBlockProperties extends BlockProperties {
	public static final EnumProperty<QuadShape> QUAD_SHAPE = EnumProperty.create("shape", QuadShape.class);
	public static final IntegerProperty TEXTURE_4 = IntegerProperty.create("texture", 0, 3);
	public static final BooleanProperty NATURAL = BooleanProperty.create("natural");
	public static final BooleanProperty[] DIRECTIONS = new BooleanProperty[] {
		BlockStateProperties.DOWN,
		BlockStateProperties.UP,
		BlockStateProperties.NORTH,
		BlockStateProperties.SOUTH,
		BlockStateProperties.WEST,
		BlockStateProperties.EAST
	};
	public static final BooleanProperty[] DIRECTIONS_HORIZONTAL = new BooleanProperty[] {
		BlockStateProperties.NORTH,
		BlockStateProperties.EAST,
		BlockStateProperties.SOUTH,
		BlockStateProperties.WEST
	};
	
	public enum QuadShape implements StringRepresentable {
		SMALL("small"),
		TOP("top"),
		MIDDLE("middle"),
		BOTTOM("bottom");
		
		private final String name;
		
		QuadShape(String name) {
			this.name = name;
		}
		
		@Override
		public String getSerializedName() {
			return name;
		}
		
		@Override
		public String toString() {
			return name;
		}
	}
}
