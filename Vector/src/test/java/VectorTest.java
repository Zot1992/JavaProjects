import com.schmegmacht.vector.Vector;
import org.junit.Assert;

public class VectorTest {

    @org.junit.Test
    public void addVector() {
        Vector v1 = new Vector(1, 0, 0);//создание вектора и его координат
        Vector v2 = new Vector(1, 0, 0);
        Vector result = v1.addVector(v2);
        Assert.assertEquals(2, result.getX(),0.001 );
    }

    @org.junit.Test
    public void minusVector() {
        Vector v1 = new Vector(1, 0, 0);//создание вектора и его координат
        Vector v2 = new Vector(1, 0, 0);
        Vector result = v1.minusVector(v2);
        Assert.assertEquals(0, result.getX(),0.001);
    }

    @org.junit.Test
    public void lengthVector() {
        Vector v1 = new Vector(1, 0, 0);//создание вектора и его координат
        Vector v2 = new Vector(1, 0, 0);
        double result = v1.lengthVector(v2);
        Assert.assertEquals(1, result,0.001);
    }

    @org.junit.Test
    public void scalarProductVector() {
        Vector v1 = new Vector(1, 0, 0);//создание вектора и его координат
        Vector v2 = new Vector(1, 0, 0);
        double result = v1.scalarProductVector(v2);
        Assert.assertEquals(1, result,0.001);
    }

    @org.junit.Test
    public void normalization() {
        Vector v1 = new Vector(1, 0, 0);//создание вектора и его координат
        Vector v2 = new Vector(1, 0, 0);
        Vector result = v1.normalization(v2);
        Assert.assertEquals(1, result.getX(),0.001);
    }

    @org.junit.Test
    public void getting_an_angle() {
        Vector v1 = new Vector(1, 0, 0);//создание вектора и его координат
        Vector v2 = new Vector(1, 0, 0);
        double result = v1.getting_an_angle(v2);
        Assert.assertEquals(1, result,0.001);
    }

    @org.junit.Test
    public void getX() {

    }

    @org.junit.Test
    public void setX() {
    }

    @org.junit.Test
    public void getY() {
    }

    @org.junit.Test
    public void setY() {
    }

    @org.junit.Test
    public void getZ() {
    }

    @org.junit.Test
    public void setZ() {
    }
}