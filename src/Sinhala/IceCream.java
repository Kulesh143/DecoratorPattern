package Sinhala;

interface IceCream{
    public String getDescription();
    public double getPrice();
}
class PlainIceCream implements IceCream{

    @Override
    public String getDescription() {
        return "Chocolate, Vanilla";
    }

    @Override
    public double getPrice() {
        return 4.00;
    }
}
abstract class ToppingDecorator implements IceCream{
    protected  IceCream tempicecream;
    public ToppingDecorator(IceCream newIcecream){
        tempicecream=newIcecream;
    }
    public String getDescription(){
        return  tempicecream.getDescription();
    }
    public double getPrice(){
        return tempicecream.getPrice();
    }
}
class Nuts extends ToppingDecorator{

    public Nuts(IceCream newIcecream) {
        super(newIcecream);
        System.out.println("Adding Cream");
        System.out.println("Adding fruits");
    }
    public String getDescription(){
        return  "Cream And Nuts";
    }
    public double getPrice(){
        return 5.00;
    }
}
class Jelly extends ToppingDecorator{

    public Jelly(IceCream newIcecream) {
        super(newIcecream);
        System.out.println("Adding Jelly and Vanilla");
        System.out.println("Adding Choco droppings");
    }
    public String getDescription(){
        return  "Jelly Added";
    }
    public double getPrice(){
        return 7.00;
    }
}
class IceCreamMaker{
    public static void main(String[] args) {
        IceCream plainIceCream=new Nuts(new Jelly(new PlainIceCream()));
        System.out.println("Ingredients= "+plainIceCream.getDescription());
        System.out.println("Cost for all "+plainIceCream.getPrice());
        IceCream basiciceCream=new Jelly(new PlainIceCream());
        System.out.println("Ingredients= "+basiciceCream.getDescription());
        System.out.println("Cost for all "+basiciceCream.getPrice());

    }
}