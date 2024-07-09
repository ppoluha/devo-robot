package se.hkr.robot;

public record Room(int width, int height) {
    public boolean isValidPos(Position pos) {
        return pos.x() >= 0 && pos.x() < width && pos.y() >= 0 && pos.y() < height;
    }
}
