public class SystemDate extends Day {
    private static SystemDate instance;

    public static void createTheInstance(String sDay) {
        if (instance == null) {
            instance = new SystemDate(sDay);
        } else {
            System.out.println("Cannot create one more system date instance.");
        }
    }

    private SystemDate(String sDay) {
        super(sDay);
    }

    public static SystemDate getInstance() {
        return instance;
    }


}
