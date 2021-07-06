package ex.training.cache;

import java.util.LinkedList;

public class LRUCache {
    int capacity;
    int size;
    private Integer[] pages;
    private LinkedList<Integer> pagesCache;

    public LRUCache(int pageCnt, int capacity) {
        pages = new Integer[pageCnt];
        size = 0;
        this.capacity = capacity;
        pagesCache = new LinkedList<>();
    }

    public void get(int page) {
        Integer node = pages[page];
        if (node != null) {
            removeFromCache(node);
        }
        addToCache(page);
    }

    public boolean contains(int page) {
        return pages[page] != null;
    }

    private void removeFromCache(Integer node) {
        pagesCache.remove(node);
        size--;
        pages[node] = null;
    }

    private void addToCache(int page) {
        if (pages[page] != null) {
            return;
        }

        pagesCache.addFirst(page);
        pages[page] = pagesCache.getFirst();

        if (size == capacity) {
            pages[page] = pagesCache.getFirst();
            pagesCache.pollLast();
        } else {
            size++;
        }
    }
}
