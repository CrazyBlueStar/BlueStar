package org.example;
import java.util.HashMap;
import java.util.Map;

public class PyramidRubiksCube {
    private static final int NUM_FACES = 4;
    private static final String[] COLORS = {"Red", "Green", "Blue", "Yellow"};

    private Map<String, Face> faces;
    private Map<String, String[]> edges;

    //Face of the Pyramid Rubik Cube
    class Face {
        private String color;

        //9 tiles
        private String tile1, tile2, tile3, tile4, tile5, tile6, tile7, tile8, tile9;

        public Face(String color) {
            this.color = color;
            this.tile1 = this.tile2 = this.tile3 = this.tile4 = this.tile5 = this.tile6 = this.tile7 = this.tile8 = this.tile9 = color;
        }

        public String getColor() {
            return color;
        }

        //Checks for valid tiles
        public boolean hasValidTiles() {
            return tile1.equals(tile2) && tile1.equals(tile3) && tile1.equals(tile4) && tile1.equals(tile5) &&
                    tile1.equals(tile6) && tile1.equals(tile7) && tile1.equals(tile8) && tile1.equals(tile9);
        }
    }

    //Pyramid Rubik's Cube Constructor
    public PyramidRubiksCube() {
        faces = new HashMap<>();
        edges = new HashMap<>();
        initializeFaces();
        initializeEdges();
    }

    //Initialize the faces with a color for each face
    private void initializeFaces() {
        faces.put("front", new Face("Red"));
        faces.put("left", new Face("Green"));
        faces.put("right", new Face("Blue"));
        faces.put("bottom", new Face("Yellow"));
    }

    //Initialize edges
    private void initializeEdges() {
        edges.put("front", new String[]{"left", "right", "bottom"});
        edges.put("left", new String[]{"front", "bottom", "right"});
        edges.put("right", new String[]{"front", "left", "bottom"});
        edges.put("bottom", new String[]{"front", "left", "right"});
    }

    //Checks each face if it has 9 tiles
    public boolean validateCube() {
        for (Map.Entry<String, Face> entry : faces.entrySet()) {
            if (!entry.getValue().hasValidTiles()) {
                return false;
            }
        }

        //Checks if all faces have the same color
        for (String faceName : faces.keySet()) {
            String color = faces.get(faceName).getColor();
            boolean validColorBool = false;
            for (String validColor : COLORS) {
                if (validColor.equals(color)) {
                    validColorBool = true;
                    break;
                }
            }
            if (!validColorBool) {
                return false; //Shouldn't trigger as each face has the same color(no shuffling yet)
            }
        }

        return true; //Valid Cube
    }


}
