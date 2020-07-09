/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartmahjong.app.engine;

/**
 *
 * @author moku
 */
public class Tile {
    
    private final TileType type;
    private final int digit; // 0 if honor
    private final HonorType honorType; // NONE if not an honor
    private boolean dora;

    public Tile(TileType type, int digit, HonorType honorType) {
        this.type = type;
        
        if (type == TileType.DRAGON || type == TileType.WIND) {
            this.digit = 0;
            this.honorType = honorType;
        }
        else {
            this.digit = digit;
            this.honorType = HonorType.NONE;
        }
    }
    
    public boolean isHonor() {
        return type == TileType.DRAGON || type == TileType.WIND;
    }

    public boolean isDora() {
        return dora;
    }

    public void setDora(boolean dora) {
        this.dora = dora;
    }

    public TileType getType() {
        return type;
    }

    public int getDigit() {
        return digit;
    }

    public HonorType getHonorType() {
        return honorType;
    }
    
    public enum TileType {
        BAMBOO,
        CHARACTER,
        CIRCLE,
        DRAGON,
        WIND
    }
    
    public enum HonorType {
        NONE,
        EAST,
        SOUTH,
        WEST,
        NORTH,
        RED_DRAGON,
        GREEN_DRAGON,
        WHITE_DRAGON
    }
    
}
