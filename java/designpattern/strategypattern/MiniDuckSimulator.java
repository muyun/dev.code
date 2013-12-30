//MiniDuckSimulator.java
//Type and compile the test class
package strategypattern;

public class MiniDuckSimulator {
    public static void main(String[] args){
        //1. program to a supertype
        //   exploit polymorphism by programming to a supertype so that the actual runtime object isn't locked into the code;
        //   programming to an interface/supertype would be better, because it can assign the concrete implementation object at runtime
        Duck mallard = new MallardDuck();
        //call MallardDuck's inherited performQuack() method, which then delegates to the object's QuackBehavior

        //TODO: a poor job of initializing the instance variables in a flexible way.
        //MallardDuck's constructor initializes the MallarDuck's inherited quackBehavior instance variable to a new instance of type Quack
        mallard.performQuack(); 
        mallard.performFly();
        
    }
    
}

