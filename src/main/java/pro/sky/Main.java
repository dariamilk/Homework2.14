package pro.sky;

public class Main {
    public static void main(String[] args) {
        StringList stringList = new StringListImpl();

        System.out.println(stringList.add("cat"));
        System.out.println(stringList);
    }
}