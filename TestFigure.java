class Shape {
    private String name;
    public Shape(String name) {
        this.name = name;
    }
    public Shape() {
        name = "no name";
    }
    public String getName() {
        return name;
    }
    public String toString() {
        return getClass().getName() + " " + name;
    }
    public boolean equals(Object obj){
        if(obj==null)return false;
        else if("Shape"==obj.getClass().getName())return true;
        else return false;
    }
}
class Circle extends Shape{
    private float radius;
    Circle(float a,String name){
        super(name);
        radius=a;
    }
    public float getPerimeter(){
        return 2*radius*(float)Math.PI;
    }
    public float getArea(){
        return (float)(Math.pow(radius,2)*Math.PI);
    }
    public float getInstanData(){
        return radius;
    }
    public boolean equals(Object obj){
        if(obj==null)return false;
        else if(super.equals(obj))return true;
        else if("Circle"==obj.getClass().getName()){
            System.out.println("Class match");
            Circle circle=(Circle)obj;
            if(Math.abs(circle.getInstanData()-radius)<=0.00000000001)return true;
	    else return false;
        }else return false;
    }
}
class Rectangle extends Shape{
    private float length;
    private float width;
    Rectangle(float a,float b,String name){
        super(name);
        length=a;
        width=b;
    }
    public float getPerimeter(){
        return length*2+width*2;
    }
    public float getArea(){
        return length*width;
    }
    public float getInstanData1(){
        return length;
    }
    public float getInstanData2(){
        return width;
    }
    public boolean equals(Object obj){
        if(obj==null)return false;
        else if(super.equals(obj))return true;
        else if("Rectangle"==obj.getClass().getName()){
            System.out.println("Class match");
            Rectangle rectangle=(Rectangle)obj;
            if(Math.abs(length-rectangle.getInstanData1())<=0.00000001 && Math.abs(width-rectangle.getInstanData2())<=0.0000001)return true;
	    else return false;
        }else return false;
    }
}
class Square extends Rectangle{
    Square(float a,String name){
        super(a,a,name);
    }
}
class Rhombus extends Parallelogram{
    Rhombus(float a,float b,String name){
        super(a,a,b,name);
    }
}
class Parallelogram extends Rectangle{
    private float diagonal;
    private float s;
    Parallelogram(float a,float b,float c,String name){
        super(a,b,name);
        diagonal=c;
    }
    public float getArea(){
        s=(diagonal+getInstanData1()+getInstanData2())/2;
        return (float)Math.sqrt(s*(s-diagonal)*(s-getInstanData2())*(s-getInstanData1()))*2;
    }
    public float getInstanData3(){
        return diagonal;
    }
    public boolean equals(Object obj){
        if(obj==null)return false;
        else if(super.equals(obj))return true;
        else if("Parallelogram"==obj.getClass().getName()){
          System.out.println("Class match");
          Parallelogram parallelogram=(Parallelogram)obj;
	  if(Math.abs(diagonal-parallelogram.getInstanData3())<=0.0000001 && Math.abs(super.getInstanData2()-parallelogram.getInstanData2())<=0.000001 && Math.abs(super.getInstanData1()-parallelogram.getInstanData1())<=0.0000001)return true;
	  else return false;
        }else return false;
    }
}
public class TestFigure{
    public static void main(String[] args){
        Circle circle = new Circle(3f,"circle");
        Rectangle rectangle = new Rectangle(3f,4f,"rectangle");
        Square square = new Square(3f,"square");
        Rhombus rhombus = new Rhombus(3f,4f,"rhombus");
        Parallelogram parallelogram = new Parallelogram(3f,4f,5f,"parallelogram");


        System.out.println(circle.toString());
        System.out.println("Instant data : "+circle.getInstanData()+"\tPerimeter : "+circle.getPerimeter()+"\tArea : "+circle.getArea());
        System.out.println(rectangle.toString());
        System.out.println("Instant data : "+rectangle.getInstanData1()+" and "+rectangle.getInstanData2()+"\tPerimeter : "+rectangle.getPerimeter()+"\tArea : "+rectangle.getArea());
        System.out.println(square.toString());
        System.out.println("Instant data : "+square.getInstanData1()+" and "+square.getInstanData2()+"\tPerimeter : "+square.getPerimeter()+"\tArea : "+square.getArea());
        System.out.println(rhombus.toString());
        System.out.println("Instant data : "+rhombus.getInstanData1()+" and "+rhombus.getInstanData2()+" and "+rhombus.getInstanData3()+"(diagonal)"+"\tPerimeter : "+rhombus.getPerimeter()+"\tArea : "+rhombus.getArea());
        System.out.println(parallelogram.toString());
        System.out.println("Instant data : "+parallelogram.getInstanData1()+" and "+parallelogram.getInstanData2()+" and "+parallelogram.getInstanData3()+"(diagonal)"+"\tPerimeter : "+parallelogram.getPerimeter()+"\tArea : "+parallelogram.getArea());


        System.out.println("match Judge!");
        System.out.println(circle.equals(circle));
        Circle circle1=new Circle(4f,"circle1");
        System.out.println(circle.equals(circle1));
        Parallelogram p=new Parallelogram(3f,4f,5f,"parallelogram");
        System.out.println(parallelogram.equals(circle));
    }
}
