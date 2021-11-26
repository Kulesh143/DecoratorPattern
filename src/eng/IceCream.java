package eng;

public interface IceCream {
    public String getDescription();
    public double getPrice();
}
class PlainIceCream implements IceCream{

    @Override
    public String getDescription() {
        return "Chocolate And Vanilla";
    }

    @Override
    public double getPrice() {
        return 4.00;
    }
}
abstract class ToppingDecorator implements IceCream{
    protected IceCream tempicecream;
    public ToppingDecorator(IceCream newIcecream){
        tempicecream=newIcecream;
    }
    public String getDescription(){
        return tempicecream.getDescription();
    }
    public double getPrice(){
        return tempicecream.getPrice();
    }
}
class Nuts extends ToppingDecorator{

    public Nuts(IceCream newIcecream) {
        super(newIcecream);
        System.out.println("Adding Cream");
        System.out.println("Adding Nuts");
    }
    public String getDescription(){
        return "Cream";
    }
    public double getPrice(){
        return 5.00;
    }
}
class Jelly extends ToppingDecorator{

    public Jelly(IceCream newIcecream) {
        super(newIcecream);
        System.out.println("Sugar coating made");
    }



    public String getDescription(){
        return "Choco Droppings";
    }
    public double getPrice(){
        return 7.00;
    }
}
class IceCreamMaker{
    public static void main(String[] args) {
        IceCream plainIcecream=new Nuts(new Jelly(new PlainIceCream()));
        System.out.println(plainIcecream.getDescription());
        System.out.println(plainIcecream.getPrice());
        IceCream BasicIceCream=new Jelly(new PlainIceCream());
        System.out.println(BasicIceCream.getDescription());
        System.out.println(BasicIceCream.getPrice());
    }
}
