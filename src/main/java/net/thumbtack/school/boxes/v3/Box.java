package net.thumbtack.school.boxes.v3;

import net.thumbtack.school.figures.v3.ClosedFigure;
import net.thumbtack.school.iface.v3.HasPerimeter;

public class Box<T extends ClosedFigure> implements HasPerimeter {

    private T object;
    private static final double EPS = 1E-6;

    public Box(T obj) {
        super();
        this.object = obj;
    }

    public void setContent(T obj) {
        this.object = obj;
    }

    public T getContent() {
        return object;
    }

    @Override
    public double getPerimeter() {
        return object.getPerimeter();
    }

    // REVU Raw use of parameterized class 'Box'
    public boolean isPerimeterEqual(Box<?> anotherClass) {
        return Math.abs(getPerimeter() - anotherClass.getPerimeter()) < EPS;
    }

    // REVU Raw use of parameterized class 'Box'
    // REVU вызовите предыдущий метод
    public boolean isPerimeterEqual(Box<?> box1, Box<?> box2) {
        return isPerimeterEqual(box1) == isPerimeterEqual(box2);
    }

}
