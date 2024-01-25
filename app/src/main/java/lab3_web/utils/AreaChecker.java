package lab3_web.utils;

public class AreaChecker implements HitChecker {

    @Override
    public boolean isHit(double x, double y, double r) {
        return check_circle(x, y, r) || check_rectangle(x, y, r) || check_triangle(x, y, r);
    }

    private boolean check_circle(double x, double y, double r) {
        return x >= 0 && y >= 0 && (Math.pow(x, 2) + Math.pow(y, 2) <= Math.pow(r, 2));
    }

    private boolean check_rectangle(double x, double y, double r) {
        return x <= 0 && y >= 0 && x >= -r &&  y <= r;
    }

    private boolean check_triangle(double x, double y, double r) {
        return x >= 0 && y <= 0 && x<=r/2 && y>=-r/2 && Math.abs(x - y) <= r/2;
    }
    
}