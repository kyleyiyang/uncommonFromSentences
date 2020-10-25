class Solution {
    public String[] uncommonFromSentences(String A, String B) {
        String D = A+" "+B;
        String out="";
        out = recursion(D,out);
        String[] result = {};
        if (out!="") {result=out.split(" ");}
        return result;
    }
    public static String recursion(String i, String o) {
        int n = i.indexOf(" ");
        if (n==-1) {
            o=o+i+" ";
            return o;
        } else {
        String sub = i.substring(0,n);
        String rest = i.substring(n+1);
        if (rest.indexOf(sub)==-1) {
            o=o+sub+" ";
        } else if (rest.indexOf(' ')==-1 && !sub.equals(rest)) {
            o=o+sub+" ";
        } else {
        int z = rest.indexOf(sub);
        boolean flag=false;
        while (rest.indexOf(sub)!=-1 && z>=0) {
            if (sub.equals(rest)) {
                return o;
            }
            if (rest.indexOf(" "+sub+" ",z-1)!=-1) {
                rest = rest.substring(0,z)+rest.substring(z+sub.length()+1);
                z = rest.indexOf(sub);
                flag=true;
            } else if (rest.indexOf(sub+" ",z)!=-1) {
                flag=true;
                if (z==0) {
                rest = rest.substring(sub.length()+1);
                    z = rest.indexOf(sub);
                } else {
                    if (rest.charAt(z-1) != ' ' && rest.indexOf(sub,z+1)==-1) {
                        o=o+sub+" ";
                        break;
                    }
                    z = rest.indexOf(sub,z+1);
                }
            } else if (rest.indexOf(" "+sub,z-1)!=-1) {
                flag=true;
                
                if (z+sub.length()==rest.length()) {
                    rest = rest.substring(0, z-1);
                    z = rest.indexOf(sub);
                    break;
                } else {
                    if (rest.charAt(z+1) != ' ' && rest.indexOf(sub,z+1)==-1) {
                        o=o+sub+" ";
                        break;
                    }
                    z = rest.indexOf(sub,z+1);
                }
            } else {
                z = rest.indexOf(sub,z+1);
                if (z==-1 && !flag) {
                    o=o+sub+" ";
                    break;
                }
            }
            
        }
        }
        return recursion(rest,o);
        }
    }
}
