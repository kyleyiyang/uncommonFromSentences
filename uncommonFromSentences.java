class Solution {
    public String[] uncommonFromSentences(String A, String B) {
        String D = A+" "+B;
        int n=D.indexOf(" ");
        List<String> s=new ArrayList<>();
        while (n>=0) {
            String sub = D.substring(0,n);
            String rest = D.substring(n+1);
            System.out.println("sub="+sub+"; rest="+rest);
            
            if (sub.equals(rest)) {
                break;
            }
            if (rest.indexOf(" ")==-1) {
                s.add(sub);
                if (rest!="") {
                    s.add(rest);
                }
                break;
            } //else {
                if (!rest.contains(" "+sub)) { // || rest.indexOf(" ")==-1 ) {
                    s.add(sub);
                    System.out.println("!rest.contains(sub)="+sub);
                } else {
            //if (rest.indexOf(" ")!=-1) {
                    //String t_sub = " " + sub + " ";
                    while (rest.contains(sub)) {
                        if (sub.equals(rest)) {
                            break;
                        }
                        int m = rest.indexOf(sub);
                        System.out.println("m="+m+"; rest="+rest+"; sub="+sub);
                        if (m==0) {
                            if (rest.contains(sub+" ")) {
                                rest = rest.substring(m+sub.length()+1);
                            }
                        } else {
                            if (rest.contains(" "+sub) && m+sub.length()+1<rest.length()) {
                                rest=rest.substring(0,m)+rest.substring(m+sub.length()+1);
                            } else {
                                break;
                               // rest=rest.substring(0,m-1);
                            }
                        }
                        /*if (m+sub.length()+1<rest.length()) {
                            rest=rest.substring(0,m)+rest.substring(m+sub.length()+1);
                        } else {
                            rest=rest.substring(0,m-1);
                        }*/
                    }
                    
                    
                    
                    
               // while (rest.contains(sub) && rest.substring() {
                    
                  //  System.out.println("m="+m+"; rest="+rest+"; sub="+sub);
                    //if (rest.indexOf(" ")!=-1 && rest.substring(m,m+rest.indexOf(" ")).equals(sub)) {
                      //  if (m+sub.length()+1<rest.length()) {
                         //   rest=rest.substring(0,m)+rest.substring(m+sub.length()+1);
                      // } else {
                      //      rest=rest.substring(0,m-1);
                     //   }
                    
            
                
                   // } //else {
                            //rest=rest.substring(0,m-1);
                        //}
                    //}
                //} 
                //}
            }
            D=rest;
            n=D.indexOf(" ");
            if (n==-1 && D!="") {
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
