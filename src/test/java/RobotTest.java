import org.junit.jupiter.api.Test;
import se.hkr.robot.OutOfBoundsException;
import se.hkr.robot.Position;
import se.hkr.robot.Robot;
import se.hkr.robot.Room;

import static org.junit.jupiter.api.Assertions.*;

public class RobotTest {

    @Test
    public void testDirectionToIndex() {
        assertEquals(0, Robot.directionToIndex('N'));
        assertEquals(1, Robot.directionToIndex('E'));
        assertEquals(2, Robot.directionToIndex('S'));
        assertEquals(3, Robot.directionToIndex('W'));
        assertEquals(0, Robot.directionToIndex('X'));
    }

    @Test
    public void testTurnLeft() {
        Room room = new Room(5, 5);
        Robot robot = new Robot(new Position(2, 2), Robot.directionToIndex('N'), room);
        robot = robot.turn('L');
        assertEquals('W', Robot.DIRECTIONS[robot.dirIndex()]);
    }

    @Test
    public void testTurnRight() {
        Room room = new Room(5, 5);
        Robot robot = new Robot(new Position(2, 2), Robot.directionToIndex('N'), room);
        robot = robot.turn('R');
        assertEquals('E', Robot.DIRECTIONS[robot.dirIndex()]);
    }

    @Test
    public void testMoveNorth() throws OutOfBoundsException {
        Room room = new Room(5, 5);
        Robot robot = new Robot(new Position(2, 2), Robot.directionToIndex('N'), room);
        robot = robot.move();
        assertEquals(new Position(2, 1), robot.pos());
    }

    @Test
    public void testMoveEast() throws OutOfBoundsException {
        Room room = new Room(5, 5);
        Robot robot = new Robot(new Position(2, 2), Robot.directionToIndex('E'), room);
        robot = robot.move();
        assertEquals(new Position(3, 2), robot.pos());
    }

    @Test
    public void testMoveSouth() throws OutOfBoundsException {
        Room room = new Room(5, 5);
        Robot robot = new Robot(new Position(2, 2), Robot.directionToIndex('S'), room);
        robot = robot.move();
        assertEquals(new Position(2, 3), robot.pos());
    }

    @Test
    public void testMoveWest() throws OutOfBoundsException {
        Room room = new Room(5, 5);
        Robot robot = new Robot(new Position(2, 2), Robot.directionToIndex('W'), room);
        robot = robot.move();
        assertEquals(new Position(1, 2), robot.pos());
    }

    @Test
    public void testOutOfBounds() {
        Room room = new Room(5, 5);
        Robot robot = new Robot(new Position(0, 0), Robot.directionToIndex('N'), room);
        assertThrows(OutOfBoundsException.class, robot::move);
    }

    @Test
    public void testToString() {
        Room room = new Room(5, 5);
        Robot robot = new Robot(new Position(2, 2), Robot.directionToIndex('N'), room);
        assertEquals("2 2 N", robot.toString());
    }
}
