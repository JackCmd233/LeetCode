package Number804;

public class UniqueMorseCodeWords {
    public int uniqueMorseRepresentations(String[] words) {
        int a =0;
        return a;
    }

    public static void main(String []args){
        Zi2 z2 = new Zi2();

    }
}

abstract class AbstractFu{
    int fuNumber ;
    String fuName;

    abstract void show(String  name);


}

abstract class AbstractZi extends AbstractFu {
    int ziNumber;
    String ziName;

    @Override
    void show(String name) {
        System.out.println("ziname");
    }

    abstract void show(int number);

}

class Zi2 extends AbstractZi {

    @Override
    void show(int number) {
        System.out.println("ziziname");
    }
}