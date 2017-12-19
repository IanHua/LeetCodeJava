public class Vector2D implements Iterator<Integer> {
    private Iterator<List<Integer>> outer;
    private Iterator<Integer> inner;
    
    public Vector2D(List<List<Integer>> vec2d) {
        outer = vec2d.iterator();
    }

    @Override
    public Integer next() {
        if (hasNext()) return inner.next();
        else return -1;
    }

    @Override
    public boolean hasNext() {
        while (outer != null && (inner == null || !inner.hasNext()) && outer.hasNext()) {
            inner = outer.next().iterator();
        }
        return inner != null && inner.hasNext();
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */