class Solution {
    public String[] uncommonFromSentences(String A, String B) {
        String[] A_ = A.split(" ");
        String[] B_ = B.split(" ");
        List<String> out = new ArrayList<>(Arrays.asList(A_));
        out.addAll(Arrays.asList(B_));
        for (String a : A_) {
            for (String b : B_) {
                if (a.equals(b)) {
                    while (out.contains(a)) {
                        out.remove(a);
                    }
                }
            }
        }
        List<String> result = new ArrayList<>(out);
        for (int i=0; i<out.size()-1;i++) {
            for (int j=i+1;j<out.size();j++) {
                String s=out.get(i);
                if (s.equals(out.get(j))) {
                    while (result.contains(s)) {
                        result.remove(s);
                    }
                }
            }
        }
        String[] array = result.toArray(new String[0]);
        return array;
    }
}
