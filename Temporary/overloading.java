class overloading {

    public static int overload(int a) {
        return 2 * a;
    }

    // changing the return type would'nt cause method to overload => method doesn't
    // change act differently on changing return type
    public static char overload(int a) {
        return (char) (a);
    }

    public static void main(String[] args) {
        int a = overload(33);
        char ch = overload(65);
    }
}