package pizzaBilling;

public class Pizza {
    private int price;
    private Boolean veg;
    private int extraCheesePrice= 100;
    private int extraToppingsPrice= 150;
    private int backPack= 20;
    private int basePizaPrice;
    private boolean isExtraCheeseAdded=false;
    private boolean isExtraToppingAdded=false;
    private boolean isOptedForTakeAway=false;
    public Pizza(Boolean veg) {
        this.veg = veg;
        if(this.veg){
            this.price=300;
        }else{
            this.price=400;
        }
        basePizaPrice=this.price;
    }
    public void getPizzaPrice(){
        System.out.println(this.price);
    }
    public void addExtraCheese(){
        isExtraCheeseAdded=true;
        System.out.println("Extra Cheese added");
        this.price +=extraCheesePrice;

    }
    public void addExtraToppings(){
        isExtraToppingAdded=true;
        System.out.println("Extra Toppings added");
        this.price +=extraToppingsPrice;

    }
    public void takeAway(){
        isOptedForTakeAway=true;
        System.out.println("TakeAway");
        this.price += backPack;

    }
    public void getBill(){
        String bill= "";
        System.out.println("Pizza: "+basePizaPrice);
        if(isExtraCheeseAdded){
            bill += "Extra cheese added: "+extraCheesePrice+ "\n";
        }
        if(isExtraToppingAdded){
            bill += "Extra Topping added: "+extraToppingsPrice+ "\n";
        }
        if(isOptedForTakeAway){
            bill += "Take away: "+backPack+ "\n";
        }
//        System.out.println("Base Pizza: "+basePizaPrice);
//        System.out.println("Toppings: "+this.extraToppingsAdded);
//        System.out.println("Cheese: "+this.extraCheesePrice);
//        System.out.println("TakeAway: "+this.backPack);
//        System.out.println("Total Price of the Pizza bill is: "+this.price);
        bill += "Bill: "+this.price + "\n";
        System.out.println(bill);

    }
}
