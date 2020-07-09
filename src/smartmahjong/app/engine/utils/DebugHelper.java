/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartmahjong.app.engine.utils;

import java.util.ArrayList;
import smartmahjong.app.engine.Hand;
import smartmahjong.app.engine.Tile;
import smartmahjong.app.engine.Tile.HonorType;
import smartmahjong.app.engine.Tile.TileType;

/**
 *
 * @author moku
 */
public class DebugHelper {
    
    public static Hand createPinfuHand() {
        return new Hand(
                new Tile[] {
                    new Tile(TileType.CHARACTER, 1, HonorType.NONE),
                    new Tile(TileType.CHARACTER, 2, HonorType.NONE),
                    new Tile(TileType.CHARACTER, 3, HonorType.NONE),
                    new Tile(TileType.CHARACTER, 5, HonorType.NONE),
                    new Tile(TileType.CHARACTER, 5, HonorType.NONE),
                    new Tile(TileType.CIRCLE, 3, HonorType.NONE),
                    new Tile(TileType.CIRCLE, 4, HonorType.NONE),
                    new Tile(TileType.CIRCLE, 7, HonorType.NONE),
                    new Tile(TileType.CIRCLE, 8, HonorType.NONE),
                    new Tile(TileType.CIRCLE, 9, HonorType.NONE),
                    new Tile(TileType.BAMBOO, 4, HonorType.NONE),
                    new Tile(TileType.BAMBOO, 5, HonorType.NONE),
                    new Tile(TileType.BAMBOO, 6, HonorType.NONE)
                }, 
                new Tile(TileType.CIRCLE, 2, HonorType.NONE),
                new ArrayList<>());
    }
    
}
