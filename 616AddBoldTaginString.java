class Solution {
    public String addBoldTag(String s, String[] dict) {
        if (s.isEmpty() || dict.length == 0) return s;
        Map<Integer, Integer> map = new TreeMap<>();
        int start = 0, end = 0;
        for (int i = 0; i < dict.length; i++) {
            start = 0;
            end = 0;
            String word = dict[i];
            while ((start = s.indexOf(word, start)) != -1) {
                end = start + word.length() - 1;
                System.out.println(word + "start " + start + " " + "end " + end);
                map.put(start, end);
                start += 1;
            }
        }
        Map<Integer, Integer> updateRange = new TreeMap<>();
        boolean first = true;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int tmpStart = entry.getKey();
            int tmpEnd = entry.getValue();
            if (first) {
                start = tmpStart;
                end = tmpEnd;
                first = false;
                continue;
            }
            if (tmpStart <= end + 1) {
                end = Math.max(tmpEnd, end);
                updateRange.put(start, end);
            } else {
                updateRange.put(start, end);
                start = tmpStart;
                end = tmpEnd;
            }
        }
        if (map.size() == 0) {
            return s;
        } else {
            updateRange.put(start, end);
        }
        StringBuilder sb = new StringBuilder();
        end = 0;
        for (Map.Entry<Integer, Integer> entry : updateRange.entrySet()) {
            int tmpStart = entry.getKey();
            int tmpEnd = entry.getValue();
            if (end < tmpStart) sb.append(s.substring(end, tmpStart));
            sb.append("<b>");
            sb.append(s.substring(tmpStart, tmpEnd + 1));
            sb.append("</b>");
            end = tmpEnd + 1;
        }
        sb.append(s.substring(Math.min(end, s.length())));
        return sb.toString();
    }
}