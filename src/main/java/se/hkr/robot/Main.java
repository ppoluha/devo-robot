package se.hkr.robot;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read grid size
        int gridX = scanner.nextInt();
        int gridY = scanner.nextInt();
        scanner.nextLine();

        // Create room
        Room room = new Room(gridX, gridY);

        // Read initial position and direction
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        char initialDir = scanner.next().charAt(0);
        scanner.nextLine();

        // Create initial robot
        Robot robot = new Robot(
                new Position(x, y),
                Robot.directionToIndex(initialDir),
                room);

        // Store the robot's path (extra feature)
        LinkedList<Robot> path = new LinkedList<>();
        path.add(robot);

        // Read movement commands
        String commands = scanner.nextLine();
        try {
            for (char command : commands.toCharArray()) {
                robot = switch (command) {
                    case 'L', 'R' -> robot.turn(command);
                    case 'F' -> robot.move();
                    default -> robot;
                };
                path.add(robot);
            }
            System.out.println("Report: " + robot);
            // To display the robot's path, uncomment line below
            // path.forEach(System.out::println);
        } catch (OutOfBoundsException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }
}
