class Solution {
    public String[] uncommonFromSentences(String A, String B) {
        String D = A+" "+B;
        String out="";
        //int n=D.indexOf(" ");
        //List<String> s=new ArrayList<>();
        out = recursion(D,out);
        System.out.println("out="+out);
        return out.split(" ");
    }
    public static String recursion(String i, String o) {
        int n = i.indexOf(" ");
       // System.out.println("n="+n);
       // System.out.println("i="+i);
        if (n==-1) {
            o=o+i+" ";
           // System.out.println("o="+o);
            return o;
        } else {
        String sub = i.substring(0,n);
        String rest = i.substring(n+1);
            System.out.println("sub="+sub+"; rest="+rest);
        if (!rest.contains(sub)) {
            o=o+sub+" ";
            
        }
        while (rest.contains(sub)) {
            if (sub.equals(rest)) {
                return o;
            }
            int z = rest.indexOf(sub);
            
            if (rest.contains(" "+sub+" ")) {
                
                rest = rest.substring(0,z)+rest.substring(z+sub.length()+1);
            } else if (rest.contains(sub+" ")) {
                if (z==0) {
                rest = rest.substring(sub.length()+1);
                } else {
                    //Char c=' ';
                    if (rest.charAt(z-1) != ' ') {
                        o=o+sub+" ";
                        break;
                    }
                }
            } else if (rest.contains(" "+sub) && z+sub.length()==rest.length()) {
                rest = rest.substring(0, z-1);
            } else {
                o=o+sub+" ";
                System.out.println(rest.contains(sub+' '));
              System.out.println("o="+o);
                break;
            }
        }
        
        return recursion(rest,o);
        }
        //System.out.println("last o="+o);
        //return o;
    }
}
