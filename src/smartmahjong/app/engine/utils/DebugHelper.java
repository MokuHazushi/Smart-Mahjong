/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartmahjong.app.engine.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import smartmahjong.app.engine.Hand;
import smartmahjong.app.engine.Meld;
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
    
    public static Hand createOpenedHand() {
        Tile tiles[] = new Tile[] {
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
                };
        Tile drawnTile = new Tile(TileType.CIRCLE, 2, HonorType.NONE);
        List<Meld> melds = new ArrayList<>();
        
        melds.add(new Meld(
                Arrays.asList(Arrays.copyOfRange(tiles, 0, 3)),
                true,
                1
        ));
        
        return new Hand(tiles, drawnTile, melds);
    }
    
    public static Hand createRandomHand() {
        Tile tiles[] = new Tile[13];
        Tile drawnTile;
        List<Tile> mahjongSet = EngineTools.createMahjongTileSet();
        Random ranGen = new Random(System.currentTimeMillis());
        
        for (int i=0; i<13; i++) {
            int nextTileIndex = ranGen.nextInt(mahjongSet.size());
            tiles[i] = mahjongSet.get(nextTileIndex);
            mahjongSet.remove(nextTileIndex);
        }
        
        int drawnTileIndex = ranGen.nextInt(mahjongSet.size());
        drawnTile = mahjongSet.get(drawnTileIndex);
        mahjongSet.remove(drawnTileIndex);
        
        return new Hand(tiles, drawnTile, new ArrayList<>());
    }
    
}
