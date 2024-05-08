package Model.Shape;

import java.awt.*;
import java.util.Random;

public abstract class MyShape {
    protected int _x;
    protected int _y;
    protected boolean[][] _shape;
    protected boolean[][][] _shapeRotattions;
    protected Color _currentColor;
    protected Random _random = new Random();
    protected Color[] _colors = new Color[] {
            Color.red,
            Color.green,
            Color.blue,
            Color.yellow,
            Color.orange,
            Color.pink,
            Color.cyan,
            Color.magenta,
            Color.gray,
    };
    private final int CNT_ROTATIONS = 4;

    public MyShape(boolean[][] shape) {
        _shape = shape;
        generateShapeRotations();
        setColor();
    }

    public void spawn() {
        _x = 0;
        _y = 0;
    }

    private void setColor() {
        _currentColor = _colors[_random.nextInt(_colors.length)];
    }

    private void generateShapeRotations() {
        _shapeRotattions = new boolean[CNT_ROTATIONS][][];
        for (int i = 0; i < CNT_ROTATIONS; ++i) {
            int h = getHeight();
            int w = getWidth();
            _shapeRotattions[i] = new boolean[h][w];
            for (int y = 0; y < h; ++y) {
                for (int x = 0; x < w; ++x) {
                    _shapeRotattions[i][y][x] = _shape[w - x - 1][y];
                }
            }
            _shape = _shapeRotattions[i];
        }
    };

    public int getWidth() {
        return _shape.length;
    }

    public int getHeight() {
        return _shape[0].length;
    }

    public boolean isShape(int x, int y) {
        return _shape[x][y];
    }

    public Color getColor() {
        return _currentColor;
    }

    public int getY() {
        return _y;
    }

    public void setY(int y) {
        _y = y;
    }

    public int getX() {
        return _x;
    }

    public void setX(int x) {
        _x = x;
    }

    public void moveDown() {
        _y += 1;
    }
    public void moveUp() {
        _y -= 1;
    }
    public void moveLeft() {
        _x -= 1;
    }
    public void moveRight() {
        _x += 1;
    }

    public void moveRotate() {
        _shape = _shapeRotattions[_random.nextInt(_shapeRotattions.length)];
    }
}