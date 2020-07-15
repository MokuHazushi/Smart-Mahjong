/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartmahjong.app.gui.utils;

import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import smartmahjong.app.engine.Tile;
import smartmahjong.app.gui.components.GTile;

/**
 *
 * @author moku
 */
public class GUIFactory {
    private static final String IMAGE_FOLDER = "images";
    
    private static BufferedImage tilesGraphics = null;
    
    private static BufferedImage getTileGraphic(Tile tile) {
        
        final Dimension TILE_DIMENSION = GUIConstants.TILE_DIMENSION;
        int topX = 0, topY = 0;
        BufferedImage tileImage;
        
        if (tilesGraphics == null)
            loadTilesGraphics();
        
        /*
        Tiles graphics are saved in 1 file of size 600x810
        One tile has the dimension 90x150
        The tiles are ordered as the following (one item per row):
        - Circles (1-9)
        - Bamboos (1-9)
        - Characters (1-9)
        - East, South, West, North, Red dragon, Green dragon, White dragon
        - Red doras (5-character, 5-circle, 5-bamboo)
        */
        
        // Red doras
        if (tile.getDigit() == 5 && tile.isDora()) {
            topY = TILE_DIMENSION.height * 4;
            switch (tile.getType()) {
                case CHARACTER:
                    topX = 0;
                    break;
                case CIRCLE:
                    topX = TILE_DIMENSION.width * 1;
                    break;
                case BAMBOO:
                    topX = TILE_DIMENSION.width * 2;
                    break;
                default:
                    // Never happens
            }
        }
        else {
            
            // Honors
            if (tile.isHonor()) {
                topY = TILE_DIMENSION.height * 3;
                switch (tile.getHonorType()) {
                    case EAST:
                        topX = 0;
                        break;
                    case SOUTH:
                        topX = TILE_DIMENSION.width * 1;
                        break;
                    case WEST:
                        topX = TILE_DIMENSION.width * 2;
                        break;
                    case NORTH:
                        topX = TILE_DIMENSION.width * 3;
                        break;
                    case RED_DRAGON:
                        topX = TILE_DIMENSION.width * 4;
                        break;
                    case GREEN_DRAGON:
                        topX = TILE_DIMENSION.width * 5;
                        break;
                    case WHITE_DRAGON:
                        topX = TILE_DIMENSION.width * 6;
                        break;
                    default:
                        // Never happens
                }
            }
            else {
                
                // Others
                switch (tile.getType()) {
                    case CIRCLE:
                        topY = 0;
                        break;
                    case BAMBOO:
                        topY = TILE_DIMENSION.height * 1;
                        break;
                    case CHARACTER:
                        topY = TILE_DIMENSION.height * 2;
                        break;
                    default:
                        // Never happens
                }
                topX = TILE_DIMENSION.width * (tile.getDigit()-1);
            }
        }
        
        tileImage = tilesGraphics.getSubimage(
                topX, topY, 
                TILE_DIMENSION.width, TILE_DIMENSION.height);
        return tileImage;
    }
    
    public static GTile createGTile(Tile tile, Dimension prefDim) {
        return new GTile(getTileGraphic(tile), prefDim);
    }
    
    private static void loadTilesGraphics() {
        final String TILES_IMAGE_FILE = "tiles.png";
        tilesGraphics = loadImage(TILES_IMAGE_FILE);
    }
    
    public static BufferedImage loadImage(String fileName) {
        BufferedImage img = null;
        
        try {
            img = ImageIO.read(new File(IMAGE_FOLDER+"/"+fileName));
        }
        catch (IOException ioe) {
            ioe.printStackTrace();
        }
        
        return img;
    }
    
}
