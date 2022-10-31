package Oct4Th2022.binarysearchtree;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @author Sidharth Das
 * created on  31/10/22
 */
public class LeetCodeMainClass20 {

    public static void main(String[] args) {

    }

    public boolean isPathCrossing(String path) {
        int currentX = 0;
        int currentY = 0;
        Set<Point> set = new HashSet<>();

        String str[] = path.split("");
        for(String s : str){
            //'N', 'S', 'E' or 'W'
            if(s.equals("N")){
                currentX += 1;
                if(!set.add(new Point(currentX, currentY))){
                    return true;
                }
            } else if(s.equals("S")){
                currentX -= 1;
                if(!set.add(new Point(currentX, currentY))){
                    return true;
                }
            }else if(s.equals("E")){
                currentY += 1;
                if(!set.add(new Point(currentX, currentY))){
                    return true;
                }
            }else if(s.equals("W")){
                currentY -= 1;
                if(!set.add(new Point(currentX, currentY))){
                    return true;
                }
            }
        }

        return false;
    }
}

class Point {

    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

}
