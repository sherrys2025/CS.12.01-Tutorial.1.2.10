import java.util.Random;

public class LightBoard {
    private boolean[][] lights;

    public LightBoard(int numRows, int numCols)
    {
        lights = new boolean[numRows][numCols];

        for (int y = 0; y < numRows; y++) {
            for (int x = 0; x < numCols; x++) {
                Random random = new Random();
                if (random.nextDouble() <= 0.4) {
                    lights[y][x] = true;
                }
            }
        }
    }

    private int countLights(int col) {
        int count = 0;
        for (int row = 0; row < lights.length; row++) {
            if (lights[row][col]) {
                count++;
            }
        }
        return count;
    }

    /** If the light is on, return false if the number of lights
     * in its column that are on is even, including the current light.
     * If the light is off, return true if the number of lights in its
     * column that are on is divisible by three. Otherwise, return the
     * light’s current status.
    */
    public boolean evaluateLight(int row, int col)
    {
        if (!lights[row][col]) {
            if (countLights(col) % 2 == 0) {
                return false;
            }
        } else {
            if (countLights(col) % 3 == 0) {
                return true;
            }
        }
        return lights[row][col];
    }

    public boolean[][] getLights() {
        return lights;
    }

    public void setLights(boolean[][] lights) {
        this.lights = lights;
    }
}
