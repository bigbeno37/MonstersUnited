package io.github.monstersunited.monstergame.objects.enums;

// Convenience for determining which position to set
// the player
public enum Corner {
    TOP_LEFT(0, 0), TOP_RIGHT(8, 0), BOTTOM_LEFT(0, 8), BOTTOM_RIGHT(8, 8);

    public int x;
    public int y;

    Corner(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
