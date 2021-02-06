import java.util.HashMap;

public class HM_Implemetation_for_Objects {

    static class Pair {
        int a;
        String s;

        Pair(int a, String s) {
            this.a = a;
            this.s = s;
        }

        @Override
        public String toString() {

            return "(" + this.a + "," + this.s + ")";
        }

        @Override
        public int hashCode() {
            // function to put things in bucket => hash function
            return this.a % 1027;
        }

        @Override
        public boolean equals(Object obj) {
            // method to compare elements within the bucket
            if (obj == null)
                return false;
            Pair o = (Pair) obj;
            if (o.a == this.a && o.s.equals(this.s))
                return true;
            return false;
        }
    }

    public static void main(String[] args) {
        HashMap<Pair, Integer> map = new HashMap<>();

        // creating objs and increasing freq
        for (int i = 0; i < 5; i++) {
            Pair p = new Pair(10, "Mohit");
            map.put(p, map.getOrDefault(p, 0) + 1);
        }

        System.out.println("Hasmap Size " + map.size());
        System.out.println("Hasmap : " + map);
        /**
         * Default op with overriding equals and hashCode => Hasmap Size 5 Hasmap :
         * {(10,Mohit)=1, (10,Mohit)=1, (10,Mohit)=1, (10,Mohit)=1, (10,Mohit)=1}
         * 
         * op After overiding hashCOde => Hasmap Size 5 Hasmap : {(10,Mohit)=1,
         * (10,Mohit)=1, (10,Mohit)=1, (10,Mohit)=1, (10,Mohit)=1}
         * 
         * op After overiding equals =>Hasmap Size 5 Hasmap : {(10,Mohit)=1,
         * (10,Mohit)=1, (10,Mohit)=1, (10,Mohit)=1, (10,Mohit)=1} //it is same bcz all
         * elemts falled into different bucket (address of each elements) are such that
         * hashcode generated from these address corresponds to different bucket, there
         * maybe a case where 2 address goes to same bucket leading result like
         * (10,Mohit)=2 somwehere
         * 
         * 
         * op After overiding hashCOde and equals => Hasmap Size 1 Hasmap :
         * {(10,Mohit)=5}
         */
    }
}
