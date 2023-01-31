package com.zhouyu.gradleDemo.designModel.Prototype;

import java.util.ArrayList;
import java.util.List;

public class Prototype {
    public static void main(String[] args) {
        List<Shape> list = new ArrayList<>();
        List<Shape> listCopy = new ArrayList<>();
        Circle circle = new Circle();
        circle.radius = 5;
        Rectangle rectangle = new Rectangle();
        rectangle.height = 10;
        rectangle.width = 10;

        list.add(circle);
        list.add(rectangle);

        for (Shape shape : list) {
            listCopy.add(shape.clone());
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
            System.out.println(listCopy.get(i));

        }
    }
}
class Rectangle extends Shape{
    public int width;
    public int height;
    public Rectangle(){}
    public Rectangle(Rectangle target){
        if(target!=null){
            this.width = target.width;
            this.height = target.height;
        }
    }
    @Override
    public Shape clone() {
        return new Rectangle(this);
    }
}
class Circle extends Shape{
    public int radius;

    public Circle(){};

    public Circle(Circle target){
        if(target!=null){
            this.radius = target.radius;
        }
    }

    @Override
    public Circle clone() {
        return new Circle(this);
    }
}
abstract class Shape{
    public int x;
    public int y;
    public String color;
    public Shape(){}
    public Shape(Shape target){
        if(target!=null){
            this.x = target.x;
            this.y = target.y;
            this.color = target.color;
        }
    }
    public abstract Shape clone();
}

