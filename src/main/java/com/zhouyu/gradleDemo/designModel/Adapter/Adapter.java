package com.zhouyu.gradleDemo.designModel.Adapter;

public class Adapter {
    public static void main(String[] args) {
        RoundHole roundHole = new RoundHole(5);
        RoundPeg roundPeg = new RoundPeg(4);
        SquarePeg squarePeg = new SquarePeg(10);
        SquarePegAdapter squarePegAdapter = new SquarePegAdapter(squarePeg);

        System.out.println(roundHole.fits(roundPeg));
        System.out.println(roundHole.fits(squarePegAdapter));
    }
}
class SquarePegAdapter extends RoundPeg{
    private SquarePeg peg;
    public SquarePegAdapter(SquarePeg peg) {
        this.peg = peg;
    }

    @Override
    public double getRadius() {
        double width = peg.getWidth();
        double result = Math.sqrt(Math.pow(width / 2, 2) * 2);
        return result;
    }
}
 class RoundPeg {
    private double radius;
    public RoundPeg(){};
    public RoundPeg(double radius){
        this.radius = radius;
    }
    public double getRadius() {
        return radius;
    }
}
class SquarePeg {
    private double width;

    public SquarePeg(double width) {
        this.width = width;
    }

    public double getWidth() {
        return width;
    }

    public double getSquare() {
        double result;
        result = Math.pow(this.width, 2);
        return result;
    }
}
class RoundHole{
    private double radius;
    public RoundHole(double radius){
        this.radius = radius;
    }
    public double getRadius(){
        return radius;
    }
    public boolean fits(RoundPeg peg){
        return (this.getRadius()>=peg.getRadius());
    }
}