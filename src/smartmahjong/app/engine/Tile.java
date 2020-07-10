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
public class Tile implements Comparable<Tile> {
    
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

    @Override
    public int compareTo(Tile t) {
        /* Sorting rules:
        - Type: Characters -> Circles -> Bamboos -> Honors
        - For non-honor type, increasing order
        - For honors type East -> North -> West -> South -> Red dr. -> White dr. -> Green dr.
        */
        
        if (this.isHonor() && t.isHonor())
            return this.honorType.compareTo(t.getHonorType());
        
        if (this.isHonor() && !t.isHonor())
            return 1;
        
        if (!this.isHonor() && t.isHonor())
            return -1;
        
        if (this.type == t.getType())
            return this.digit - t.getDigit();
        
        return this.type.compareTo(t.getType());
    } 
    
    
    public enum TileType {
        // ORDER IS IMPORTANT
        CHARACTER,
        CIRCLE,
        BAMBOO,
        DRAGON,
        WIND
    }
    
    public enum HonorType {
        // ORDER IS IMPORTANT
        NONE,
        EAST,
        NORTH,
        WEST,
        SOUTH,
        RED_DRAGON,
        GREEN_DRAGON,
        WHITE_DRAGON
    }
    
}
