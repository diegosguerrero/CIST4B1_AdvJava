public class mazeproblem {

    //Diego Guerrero - CIST04B1
    // 0 = open path
    // 1 = wall
    // 2 = visited path
    // Spawn point = (0,0) and Exit (n,n)
    // Base Cases:
    // 1. Reach the exit (success)
    // 2. Dead end (walls) (failure)
    // 3. Exit is walled up (failure)
    // 4. Out of bounds (failure)
    // 5. Spawn point is walled up (failure)
    // Recursive Cases:
    // 1. Move left
    // 2. Move down
    // 3. Move right
    // 4. Move up
    // 5. We could mark paths visited with a different value ( 2 )

    public static void main(String[] args) {

        int[][] pathways = { { 0, 1, 0, 1, 0 },
                             { 0, 1, 0, 0, 0 },
                             { 0, 0, 0, 1, 0 },
                             { 1, 1, 1, 0, 0 },
                             { 0, 0, 0, 0, 1 },
                             { 0, 1, 1, 1, 1 },
                             { 0, 0, 0, 0, 0 }
        };

        System.out.println("Is the maze solvable? " + solveMaze(pathways, 0, 0));

        for (int i = 0; i < pathways.length; i++) {
            for (int j = 0; j < pathways[i].length; j++) {
                System.out.print(pathways[i][j] + " ");
            }
            System.out.println();
        }

    }

    public static boolean solveMaze(int[][] pathways, int x, int y) {

        // Base Cases
        // case 4 out of bounds
        if (x < 0 || x >= pathways.length || y < 0 || y >= pathways[0].length) {
            return false;
        }

        // case 5 spawn point is walled up
        if (pathways[0][0] == 1) {
            return false;
        }

        // inside a wall
        if (pathways[x][y] == 1) {
            return false;
        }

        // case 3 exit is walled up
        // if (x > 0 && y > 0 && pathways[x - 1][y - 1] == 1) {
        //     return false;
        // }
        if (pathways[6][4] == 1) {
            return false;
        }

        // case 1 reaching exit
        if (pathways.length - 1 == x && pathways[0].length - 1 == y) {
            pathways[x][y] = 2;
            return true;
        }

        // Set the breadcrumb
        pathways[x][y] = 2;

        // Recursive Cases
        // Moving left
        if (x > 0 && pathways[x - 1][y] != 1 && pathways[x - 1][y] != 2) {
            if (solveMaze(pathways, x - 1, y))
                return true;
        }

        // Moving right
        if (x < pathways.length - 1 && pathways[x + 1][y] != 1 && pathways[x + 1][y] != 2) {
            if (solveMaze(pathways, x + 1, y))
            return true;
        }
        // Moving down
        if (y > 0 && pathways[x][y - 1] != 1 && pathways[x][y - 1] != 2) {
            if (solveMaze(pathways, x, y - 1))
            return true;
        }

        // Moving up
        if (y < pathways[0].length - 1 && pathways[x][y + 1] != 1 && pathways[x][y + 1] != 2) {
            if (solveMaze(pathways, x, y + 1))
            return true;
        }
        // case 2 dead end
        pathways[x][y] = 0;
        return false;
    }
}


// Output:
// Is the maze solvable? true
// 2 1 0 1 0 
// 2 1 2 2 2
// 2 2 2 1 2
// 1 1 1 2 2
// 2 2 2 2 1
// 2 1 1 1 1
// 2 2 2 2 2
