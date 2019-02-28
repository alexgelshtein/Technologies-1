import java.util.*;

public class FractionsSet {

    static List<int[]> fractureList = new ArrayList<>();

    public void addFracture(int a, int b) {
        RationalFracture myFracture = new RationalFracture();
        myFracture.fracture(a, b);
        fractureList.add(new int[] {myFracture.getN(), myFracture.getD()});
    }

    static Map sortedMapOfFractures() {
        Map<Integer, Float> max = new HashMap<>();
        for (int i = 0; i<fractureList.size(); i++) {
            float x = (float) fractureList.get(i)[0] / fractureList.get(i)[1];
            max.put(i, x);
        }
        Map<Integer, Float> max1 = new LinkedHashMap<>();
        max.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .forEachOrdered(x -> max1.put(x.getKey(), x.getValue()));
        return max1;
    }

    static List listOfKeys(Map max1) {
        List keys = new ArrayList(max1.keySet());
        return keys;
    }

    public void maxFracture(List keys) {
        int Max = (int) keys.get(keys.size()-1);
        System.out.println("\nMaximum fracture is " + fractureList.get(Max)[0] + "/" + fractureList.get(Max)[1] + "\n");
    }

    public void minFracture(List keys) {
        int Min = (int) keys.get(0);
        System.out.println("\nMinimum fracture is " + fractureList.get(Min)[0] + "/" + fractureList.get(Min)[1] + "\n");
    }

    public void greaterThanGiven(Map max1, int n1, int d1) {
        List values = new ArrayList(max1.values());
        float currentFracture = (float) n1/d1;
        int quantity = 0;
        for (int i=0; i<values.size(); i++) {
            if ((float)values.get(i)>currentFracture) {
                quantity++;
            }
        }
        System.out.println("\nThere are " + quantity + " fractures greater than " + n1 + "/" + d1 + "\n");
    }

    public void lessThanGiven(Map max1, int n1, int d1) {
        List values = new ArrayList(max1.values());
        float currentFracture = (float) n1/d1;
        int quantity = 0;
        for (int i=0; i<values.size(); i++) {
            if ((float)values.get(i)<currentFracture) {
                quantity++;
            }
        }
        System.out.println("\nThere are " + quantity + " fractures less than " + n1 + "/" + d1 + "\n");
    }

    public static void main(String[] args) {
        FractionsSet mySet = new FractionsSet();
        Scanner myScan = new Scanner(System.in);
        while(true) {
            System.out.println("Choose any option:\n1) Add fracture\n2) Find maximum fracture\n3) Find minimum fracture\n4) Fractures greater than entered\n5) Fractures less than entered\n6) Print all\n7) Exit\n");
            int option = myScan.nextInt();
            switch (option) {
                case 1:
                    System.out.println("\nEnter two numbers:\n");
                    int n = myScan.nextInt();
                    int d = myScan.nextInt();
                    mySet.addFracture(n, d);
                    break;
                case 2:
                    mySet.maxFracture(listOfKeys(sortedMapOfFractures()));
                    break;
                case 3:
                    mySet.minFracture(listOfKeys(sortedMapOfFractures()));
                    break;
                case 4:
                    System.out.println("\nEnter two numbers:\n");
                    int n1 = myScan.nextInt();
                    int d1 = myScan.nextInt();
                    mySet.greaterThanGiven(sortedMapOfFractures(), n1, d1);
                    break;
                case 5:
                    System.out.println("\nEnter two numbers:\n");
                    int n2 = myScan.nextInt();
                    int d2 = myScan.nextInt();
                    mySet.lessThanGiven(sortedMapOfFractures(), n2, d2);
                    break;
                case 6:
                    System.out.println("Here is a set of all fractures:\n");
                    for (int i=0; i<fractureList.size(); i++) {
                        System.out.println(fractureList.get(i)[0] + "/" + fractureList.get(i)[1]);
                    }
                    break;
                case 7:
                    System.exit(0);
                    break;
                default:
                    System.out.println("\nWrong number!\nTry again!\n");
            }
        }
    }
}