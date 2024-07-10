package se.hkr.robot;

public record Robot(Position pos, int dirIndex, Room room) {
    public static final char[] DIRECTIONS = {'N', 'E', 'S', 'W'};
    public static int directionToIndex(char direction) {
        for (int i = 0; i < DIRECTIONS.length; i++) {
            if (DIRECTIONS[i] == direction) {
                return i;
            }
        }
        return 0; // NORTH is default direction
    }
    public Robot turn(char leftRight) {
        int newIndex = (leftRight == 'L') ? (dirIndex + 3) % 4 : (dirIndex + 1) % 4;
        return new Robot(pos, newIndex, room);
    }
    public Robot move() throws OutOfBoundsException {
        Position newPos = switch (dirIndex) {
            case 0 -> new Position(pos.x(), pos.y() - 1);
            case 1 -> new Position(pos.x() + 1, pos.y());
            case 2 -> new Position(pos.x(), pos.y() + 1);
            case 3 -> new Position(pos.x() - 1, pos.y());
            default -> new Position(pos.x(), pos.y());
        };
        if (room.isValidPos(newPos)) {
            return new Robot(newPos, dirIndex, room);
        } else {
            throw new OutOfBoundsException("Out of bounds at " + newPos);
        }
    }

    @Override
    public String toString() {
        return String.format("%s %s", pos, DIRECTIONS[dirIndex % 4]);
    }
}
