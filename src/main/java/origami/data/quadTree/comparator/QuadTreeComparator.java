package origami.data.quadTree.comparator;

import origami.data.quadTree.QuadTreeItem;
import origami.data.quadTree.QuadTree.Node;

/**
 * Author: Mu-Tsun Tsai
 * 
 * QuadTreeComparator describes how should QuadTree decide if a node
 * contains a given 2D rectangle.
 */
public abstract class QuadTreeComparator {

    protected static final double EPSILON = 0.001;

    public abstract boolean contains(Node node, double l, double r, double b, double t);

    public QuadTreeItem createRoot(double l, double r, double b, double t) {
        // We enlarge the root by at least 2 * EPSILON to avoid rounding errors.
        // Also, we strategically offset the center of the root, since it is very common
        // for origami to have creases that are on exactly half of the sheet, 1/4 of the
        // sheet etc.
        return new QuadTreeItem(l - 2 * EPSILON, r + 3 * EPSILON, b - 2 * EPSILON, t + 3 * EPSILON);
    }
}
