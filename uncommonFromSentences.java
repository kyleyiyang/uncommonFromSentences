class Solution {
    public String[] uncommonFromSentences(String A, String B) {
        String D = A+" "+B;
        int n=D.indexOf(" ");
        List<String> s=new ArrayList<>();
        while (n>=0) {
            String sub = D.substring(0,n);
            String rest = D.substring(n+1);
            if (sub.equals(rest)) {
                break;
            }
            if (!rest.contains(sub) || rest.indexOf(" ")==-1 ) {
                s.add(sub);
            }
            //if (rest.indexOf(" ")!=-1) {
                while (rest.contains(sub)) {
                    int m = rest.indexOf(sub);
                    if (m+sub.length()+1<rest.length() && rest.substring(m,m+sub.length()).equals(sub)) {
                        rest=rest.substring(0,m)+rest.substring(m+sub.length()+1);
                    } else {
                        rest=rest.substring(0,m-1);
                    }
                } 
            //}
            D=rest;
            n=D.indexOf(" ");
            if (n==-1) {
                s.add(rest);
            }
        }
        String[] out = new String[s.size()];
        for (int j=0;j<s.size();j++) {
            out[j] = s.get(j);
        }
        return out;
    }
}
