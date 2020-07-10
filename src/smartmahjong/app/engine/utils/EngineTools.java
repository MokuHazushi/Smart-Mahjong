/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartmahjong.app.engine.utils;

import java.util.ArrayList;
import java.util.List;
import smartmahjong.app.engine.Tile;
import smartmahjong.app.engine.Tile.HonorType;
import smartmahjong.app.engine.Tile.TileType;

/**
 *
 * @author moku
 */
public class EngineTools {
    
    public static List<Tile> createMahjongTileSet() {
        List<Tile> mahjongSet = new ArrayList<>();
        
        for (TileType t : Tile.TileType.values()) {
            switch (t) {
                    case CHARACTER:
                    case CIRCLE:
                    case BAMBOO:
                        for (int i=1; i<=9; i++) {
                            for (int j=0; j<4; j++) {
                                Tile tile = new Tile(t, i, Tile.HonorType.NONE);
                                if (j == 0)
                                    tile.setDora(true);
                                mahjongSet.add(tile);
                            }
                        }
                        break;
                    case WIND:
                    case DRAGON:
                        for (HonorType ht : Tile.HonorType.values()) {
                            switch (ht) {
                                case EAST:
                                case SOUTH:
                                case WEST:
                                case NORTH:
                                case RED_DRAGON:
                                case WHITE_DRAGON:
                                case GREEN_DRAGON:
                                    for (int j=0; j<4; j++)
                                        mahjongSet.add(new Tile(t, 0, ht));
                            }
                        }
                    default:
            }
        }
        return mahjongSet;
    }
    
}
