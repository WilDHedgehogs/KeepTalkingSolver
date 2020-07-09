import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//Лабиринт.
public class Maze {
    //Символы стрелок не отображаются в консоли Windows.
    public static Map<String, String> directions = Stream.of(new String[][]{
            {"right", "→"},
            {"left", "←"},
            {"up", "↑"},
            {"down", "↓"},
    }).collect(Collectors.toMap(data -> data[0], data -> data[1]));

    public static Map<String, String[][]> mazes = new HashMap<>();
    public static String[][] map = new String[13][13];
    public static List<Position> positionsRoute = new ArrayList<>();
    public static List<String> route = new ArrayList<>();
    public static int[] startPosition = new int[2];
    public static int[] endPosition = new int[2];
    public static int rows;
    public static int columns;

    static {
        mazes.put("2,1 3,6",
                new String[][]{{"W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W"},
                        {"W", "0", "0", "0", "0", "0", "W", "0", "0", "0", "0", "0", "W"},
                        {"W", "0", "W", "W", "W", "0", "W", "0", "W", "W", "W", "W", "W"},
                        {"W", "0", "W", "0", "0", "0", "W", "0", "0", "0", "0", "0", "W"},
                        {"W", "0", "W", "0", "W", "W", "W", "W", "W", "W", "W", "0", "W"},
                        {"W", "0", "W", "0", "0", "0", "W", "0", "0", "0", "0", "0", "W"},
                        {"W", "0", "W", "W", "W", "0", "W", "0", "W", "W", "W", "0", "W"},
                        {"W", "0", "W", "0", "0", "0", "0", "0", "W", "0", "0", "0", "W"},
                        {"W", "0", "W", "W", "W", "W", "W", "W", "W", "W", "W", "0", "W"},
                        {"W", "0", "0", "0", "0", "0", "W", "0", "0", "0", "W", "0", "W"},
                        {"W", "0", "W", "W", "W", "0", "W", "0", "W", "W", "W", "0", "W"},
                        {"W", "0", "0", "0", "W", "0", "0", "0", "W", "0", "0", "0", "W"},
                        {"W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W"},
                });

        mazes.put("2,5 4,2",
                new String[][]{{"W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W"},
                        {"W", "0", "0", "0", "0", "0", "W", "0", "0", "0", "0", "0", "W"},
                        {"W", "W", "W", "0", "W", "W", "W", "0", "W", "0", "W", "W", "W"},
                        {"W", "0", "0", "0", "W", "0", "0", "0", "W", "0", "0", "0", "W"},
                        {"W", "0", "W", "W", "W", "0", "W", "W", "W", "W", "W", "0", "W"},
                        {"W", "0", "W", "0", "0", "0", "W", "0", "0", "0", "0", "0", "W"},
                        {"W", "0", "W", "0", "W", "W", "W", "0", "W", "W", "W", "0", "W"},
                        {"W", "0", "0", "0", "W", "0", "0", "0", "W", "0", "W", "0", "W"},
                        {"W", "0", "W", "W", "W", "0", "W", "W", "W", "0", "W", "0", "W"},
                        {"W", "0", "W", "0", "W", "0", "W", "0", "0", "0", "W", "0", "W"},
                        {"W", "0", "W", "0", "W", "0", "W", "0", "W", "W", "W", "0", "W"},
                        {"W", "0", "W", "0", "0", "0", "W", "0", "0", "0", "0", "0", "W"},
                        {"W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W"},
                });

        mazes.put("4,4 4,6",
                new String[][]{{"W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W"},
                        {"W", "0", "0", "0", "0", "0", "W", "0", "W", "0", "0", "0", "W"},
                        {"W", "0", "W", "W", "W", "0", "W", "0", "W", "0", "W", "0", "W"},
                        {"W", "0", "W", "0", "W", "0", "W", "0", "0", "0", "W", "0", "W"},
                        {"W", "W", "W", "0", "W", "0", "W", "W", "W", "W", "W", "0", "W"},
                        {"W", "0", "0", "0", "W", "0", "W", "0", "0", "0", "W", "0", "W"},
                        {"W", "0", "W", "0", "W", "0", "W", "0", "W", "0", "W", "0", "W"},
                        {"W", "0", "W", "0", "W", "0", "W", "0", "W", "0", "W", "0", "W"},
                        {"W", "0", "W", "0", "W", "0", "W", "0", "W", "0", "W", "0", "W"},
                        {"W", "0", "W", "0", "0", "0", "W", "0", "W", "0", "W", "0", "W"},
                        {"W", "0", "W", "W", "W", "W", "W", "0", "W", "0", "W", "0", "W"},
                        {"W", "0", "0", "0", "0", "0", "0", "0", "W", "0", "0", "0", "W"},
                        {"W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W"},
                });

        mazes.put("1,1 4,1",
                new String[][]{{"W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W"},
                        {"W", "0", "0", "0", "W", "0", "0", "0", "0", "0", "0", "0", "W"},
                        {"W", "0", "W", "0", "W", "W", "W", "W", "W", "W", "W", "0", "W"},
                        {"W", "0", "W", "0", "W", "0", "0", "0", "0", "0", "0", "0", "W"},
                        {"W", "0", "W", "0", "W", "0", "W", "W", "W", "W", "W", "0", "W"},
                        {"W", "0", "W", "0", "0", "0", "W", "0", "0", "0", "W", "0", "W"},
                        {"W", "0", "W", "W", "W", "W", "W", "0", "W", "W", "W", "0", "W"},
                        {"W", "0", "W", "0", "0", "0", "0", "0", "0", "0", "0", "0", "W"},
                        {"W", "0", "W", "W", "W", "W", "W", "W", "W", "W", "W", "0", "W"},
                        {"W", "0", "0", "0", "0", "0", "0", "0", "0", "0", "W", "0", "W"},
                        {"W", "0", "W", "W", "W", "W", "W", "W", "W", "0", "W", "0", "W"},
                        {"W", "0", "0", "0", "0", "0", "W", "0", "0", "0", "W", "0", "W"},
                        {"W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W"},
                });

        mazes.put("3,5 6,4",
                new String[][]{{"W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W"},
                        {"W", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "W"},
                        {"W", "W", "W", "W", "W", "W", "W", "W", "W", "0", "W", "0", "W"},
                        {"W", "0", "0", "0", "0", "0", "0", "0", "0", "0", "W", "0", "W"},
                        {"W", "0", "W", "W", "W", "W", "W", "0", "W", "W", "W", "W", "W"},
                        {"W", "0", "0", "0", "W", "0", "0", "0", "W", "0", "0", "0", "W"},
                        {"W", "0", "W", "0", "W", "W", "W", "W", "W", "0", "W", "0", "W"},
                        {"W", "0", "W", "0", "0", "0", "0", "0", "W", "0", "W", "0", "W"},
                        {"W", "0", "W", "W", "W", "W", "W", "0", "W", "W", "W", "0", "W"},
                        {"W", "0", "W", "0", "0", "0", "0", "0", "0", "0", "W", "0", "W"},
                        {"W", "0", "W", "0", "W", "W", "W", "W", "W", "W", "W", "0", "W"},
                        {"W", "0", "W", "0", "0", "0", "0", "0", "0", "0", "0", "0", "W"},
                        {"W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W"},
                });

        mazes.put("1,5 5,3",
                new String[][]{{"W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W"},
                        {"W", "0", "W", "0", "0", "0", "W", "0", "0", "0", "0", "0", "W"},
                        {"W", "0", "W", "0", "W", "0", "W", "W", "W", "0", "W", "0", "W"},
                        {"W", "0", "W", "0", "W", "0", "W", "0", "0", "0", "W", "0", "W"},
                        {"W", "0", "W", "0", "W", "0", "W", "0", "W", "W", "W", "0", "W"},
                        {"W", "0", "0", "0", "W", "0", "W", "0", "W", "0", "0", "0", "W"},
                        {"W", "0", "W", "W", "W", "W", "W", "0", "W", "0", "W", "W", "W"},
                        {"W", "0", "0", "0", "W", "0", "0", "0", "W", "0", "W", "0", "W"},
                        {"W", "W", "W", "0", "W", "0", "W", "0", "W", "0", "W", "0", "W"},
                        {"W", "0", "0", "0", "W", "0", "W", "0", "W", "0", "0", "0", "W"},
                        {"W", "0", "W", "W", "W", "W", "W", "0", "W", "W", "W", "0", "W"},
                        {"W", "0", "0", "0", "0", "0", "0", "0", "W", "0", "0", "0", "W"},
                        {"W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W"},
                });

        mazes.put("1,2 6,2",
                new String[][]{{"W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W"},
                        {"W", "0", "0", "0", "0", "0", "0", "0", "W", "0", "0", "0", "W"},
                        {"W", "0", "W", "W", "W", "W", "W", "0", "W", "0", "W", "0", "W"},
                        {"W", "0", "W", "0", "0", "0", "W", "0", "0", "0", "W", "0", "W"},
                        {"W", "0", "W", "0", "W", "W", "W", "W", "W", "W", "W", "0", "W"},
                        {"W", "0", "0", "0", "W", "0", "0", "0", "W", "0", "0", "0", "W"},
                        {"W", "W", "W", "W", "W", "0", "W", "W", "W", "0", "W", "W", "W"},
                        {"W", "0", "0", "0", "W", "0", "0", "0", "0", "0", "W", "0", "W"},
                        {"W", "0", "W", "0", "W", "0", "W", "W", "W", "W", "W", "0", "W"},
                        {"W", "0", "W", "0", "W", "0", "0", "0", "0", "0", "W", "0", "W"},
                        {"W", "0", "W", "W", "W", "W", "W", "W", "W", "0", "W", "0", "W"},
                        {"W", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "W"},
                        {"W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W"},
                });

        mazes.put("1,4 4,3",
                new String[][]{{"W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W"},
                        {"W", "0", "W", "0", "0", "0", "0", "0", "W", "0", "0", "0", "W"},
                        {"W", "0", "W", "0", "W", "W", "W", "0", "W", "0", "W", "0", "W"},
                        {"W", "0", "0", "0", "0", "0", "W", "0", "0", "0", "W", "0", "W"},
                        {"W", "0", "W", "W", "W", "W", "W", "W", "W", "W", "W", "0", "W"},
                        {"W", "0", "W", "0", "0", "0", "0", "0", "0", "0", "W", "0", "W"},
                        {"W", "0", "W", "0", "W", "W", "W", "W", "W", "0", "W", "0", "W"},
                        {"W", "0", "W", "0", "0", "0", "W", "0", "0", "0", "0", "0", "W"},
                        {"W", "0", "W", "W", "W", "0", "W", "W", "W", "W", "W", "W", "W"},
                        {"W", "0", "W", "0", "W", "0", "0", "0", "0", "0", "0", "0", "W"},
                        {"W", "0", "W", "0", "W", "W", "W", "W", "W", "W", "W", "W", "W"},
                        {"W", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "W"},
                        {"W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W"},
                });

        mazes.put("2,3 5,1",
                new String[][]{{"W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W"},
                        {"W", "0", "W", "0", "0", "0", "0", "0", "0", "0", "0", "0", "W"},
                        {"W", "0", "W", "0", "W", "W", "W", "W", "W", "0", "W", "0", "W"},
                        {"W", "0", "W", "0", "W", "0", "0", "0", "W", "0", "W", "0", "W"},
                        {"W", "0", "W", "0", "W", "0", "W", "W", "W", "0", "W", "0", "W"},
                        {"W", "0", "0", "0", "0", "0", "W", "0", "0", "0", "W", "0", "W"},
                        {"W", "0", "W", "W", "W", "W", "W", "0", "W", "W", "W", "0", "W"},
                        {"W", "0", "W", "0", "W", "0", "0", "0", "W", "0", "0", "0", "W"},
                        {"W", "0", "W", "0", "W", "0", "W", "W", "W", "W", "W", "0", "W"},
                        {"W", "0", "W", "0", "W", "0", "W", "0", "0", "0", "W", "0", "W"},
                        {"W", "0", "W", "0", "W", "0", "W", "0", "W", "0", "W", "W", "W"},
                        {"W", "0", "0", "0", "W", "0", "0", "0", "W", "0", "0", "0", "W"},
                        {"W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W"},
                });
    }

    public static void SolveMaze() throws IOException {
        System.out.print("Enter first point (x,y): ");
        String firstPoint = KeepTalking.bufferedReader.readLine().toLowerCase().replaceAll(" ", "");

        if (firstPoint.equals("-1") || firstPoint.length() != 3 || !firstPoint.contains(",")) {
            return;
        }

        System.out.print("Enter second point (x,y): ");
        String secondPoint = KeepTalking.bufferedReader.readLine().toLowerCase().replaceAll(" ", "");

        if (secondPoint.equals("-1") || secondPoint.length() != 3 || !secondPoint.contains(",")) {
            return;
        }

        System.out.print("Enter starting position (x,y): ");
        String startCoordinate = KeepTalking.bufferedReader.readLine().toLowerCase().replaceAll(" ", "");

        if (startCoordinate.equals("-1") || startCoordinate.length() != 3 || !startCoordinate.contains(",")) {
            return;
        }

        System.out.print("Enter ending position (x,y): ");
        String endCoordinate = KeepTalking.bufferedReader.readLine().toLowerCase().replaceAll(" ", "");

        if (endCoordinate.equals("-1") || endCoordinate.length() != 3 || !endCoordinate.contains(",")) {
            return;
        }
        System.out.println();

        InitializeStartPosition(startCoordinate);
        InitializeEndPosition(endCoordinate);

        if (startPosition[0] == -1 || endPosition[0] == -1) {
            return;
        }

        InitializeMap(firstPoint + " " + secondPoint);

        FindRoute();
        PrintRoute();
    }

    public static void FindRoute() {
        final int[][] grid = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (map[i][j].equals("W")) {
                    grid[i][j] = -2;
                }
            }
        }

        PriorityQueue<Position> queue = new PriorityQueue<>(columns * rows,
                (p1, p2) -> {
                    if (grid[p1.x][p1.y] < grid[p2.x][p2.y])
                        return -1;
                    else if (grid[p1.x][p1.y] > grid[p2.x][p2.y])
                        return 1;
                    else
                        return 0;
                });

        queue.offer(new Position(startPosition[0], startPosition[1]));
        grid[startPosition[0]][startPosition[1]] = 0;

        while (!queue.isEmpty()) {

            Position current = queue.poll();
            List<Position> neighbors = getNeighbor(current);

            for (Position neighbor : neighbors) {

                if (!(map[neighbor.x][neighbor.y].equals("W"))
                        && !(map[neighbor.x][neighbor.y].equals("S"))
                        && grid[neighbor.x][neighbor.y] == 0) {

                    grid[neighbor.x][neighbor.y] = grid[current.x][current.y] + 1;
                    queue.offer(neighbor);
                }

                if (map[neighbor.x][neighbor.y].equals("F")) {
                    CreateRoute(grid);
                    return;
                }
            }
        }
        System.out.println("Route not found");
    }

    public static void CreateRoute(int[][] grid) {
        PriorityQueue<Position> queue = new PriorityQueue<Position>(columns * rows,
                new Comparator<Position>() {

                    @Override
                    public int compare(Position p1, Position p2) {
                        if (grid[p1.x][p1.y] < grid[p2.x][p2.y])
                            return -1;
                        else if (grid[p1.x][p1.y] > grid[p2.x][p2.y])
                            return 1;
                        else
                            return 0;
                    }
                });

        queue.offer(new Position(endPosition[0], endPosition[1]));
        int step = grid[endPosition[0]][endPosition[1]];

        while (!queue.isEmpty()) {

            Position current = queue.poll();
            positionsRoute.add(current);
            List<Position> neighbors = getNeighbor(current);

            for (Position neighbor : neighbors) {

                if (grid[neighbor.x][neighbor.y] == step - 1) {
                    step--;
                    queue.offer(neighbor);
                }
            }
        }


        for (int i = positionsRoute.size() - 1; i > 0; i--) {
            if (i % 2 == 0) {
                route.add(FindDirection(positionsRoute.get(i), positionsRoute.get(i - 1)));
            }
        }
    }

    private static void PrintRoute() {
        System.out.print("Result: ");
        int count = 0;
        String lastDirection = route.get(0);
        int i = -1;

        do {
            i++;
            String direction;
            try {
                direction = route.get(i);
            } catch (IndexOutOfBoundsException e) {
                direction = lastDirection;
            }

            if (i == route.size() || !direction.equals(lastDirection)) {
                if (count == 1) {
                    System.out.print(directions.get(lastDirection) + ", ");
                } else {
                    System.out.print("[" + count + "]" + directions.get(lastDirection) + ", ");
                }
                lastDirection = direction;
                count = 1;
            } else {
                count++;
            }
        } while (i != route.size());
    }

    public static String FindDirection(Position p1, Position p2) {
        if (p1.y < p2.y) {
            return "right";
        }
        if (p1.y > p2.y) {
            return "left";
        }
        if (p1.x < p2.x) {
            return "down";
        }
        if (p1.x > p2.x) {
            return "up";
        }
        return "unknown";
    }

    public static void InitializeStartPosition(String sCoordinates) {
        startPosition = TransformCoordinates(sCoordinates);
    }

    public static void InitializeEndPosition(String sCoordinates) {
        endPosition = TransformCoordinates(sCoordinates);
    }

    public static int[] TransformCoordinates(String sCoordinates) {
        int[] coordinates = new int[2];

        int x = 0;
        int y = 0;

        try {
            x = Integer.parseInt(sCoordinates.substring(0, sCoordinates.indexOf(",")));
            y = Integer.parseInt(sCoordinates.substring(sCoordinates.lastIndexOf(",") + 1));
        } catch (NumberFormatException e) {
            System.out.println("Wrong coordinates!");
            return new int[] {-1, -1};
        }

        x = x * 2 - 1;
        y = y * 2 - 1;

        coordinates[0] = x;
        coordinates[1] = y;

        return coordinates;
    }

    private static void InitializeMap(String mapName) {
        map = mazes.get(mapName);
        map[startPosition[0]][startPosition[1]] = "S";
        map[endPosition[0]][endPosition[1]] = "F";
        rows = map.length;
        columns = map[0].length;
        positionsRoute.clear();
        route.clear();
    }

    public static List<Position> getNeighbor(Position p) {
        List<Position> neighbors = new ArrayList<>();

        Position posLeft = p.getLeft();
        if (posLeft.x >= 0
                && posLeft.x < rows
                && posLeft.y >= 0
                && posLeft.y < columns)
            neighbors.add(posLeft);
        Position posRight = p.getRight();
        if (posRight.x >= 0
                && posRight.x < rows
                && posRight.y >= 0
                && posRight.y < columns)
            neighbors.add(posRight);
        Position posUp = p.getUp();
        if (posUp.x >= 0
                && posUp.x < rows
                && posUp.y >= 0
                && posUp.y < columns)
            neighbors.add(posUp);
        Position posDown = p.getDown();
        if (posDown.x >= 0
                && posDown.x < rows
                && posDown.y >= 0
                && posDown.y < columns)
            neighbors.add(posDown);

        return neighbors;
    }

    static class Position {
        public int x;
        public int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Position getLeft() {
            return new Position(x, y - 1);
        }

        public Position getRight() {
            return new Position(x, y + 1);
        }

        public Position getDown() {
            return new Position(x + 1, y);
        }

        public Position getUp() {
            return new Position(x - 1, y);
        }

        @Override
        public String toString() {
            return x + "," + y;
        }
    }
}
