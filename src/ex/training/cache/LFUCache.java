package ex.training.cache;

import ex.training.list.dlList;
import java.util.LinkedList;

public class LFUCache {
//    int capacity;
//    int size;
//    private Integer[] pages;
//    private int[] cnt;
//    private LinkedList<Integer> pagesCache;
//
//    public static void main(String[] args) {
//        recursivePrint("1234560");
//    }
//
//    static int recursivePrint(String numbers) throws Exception {
//        try {
//            return 1;
//        } catch (Exception e) {
//            throw e;
//        }
//        finally {
//            throw new Exception();
//        }
////        char number = numbers.charAt(0);
////        if (number == '0') {
////            return;
////        }
////        recursivePrint(
////                numbers.substring(1)
////        );
////        System.out.println(number);
//    }
//
//    public LFUCache(int pageCnt, int capacity) {
//        pages = new Integer[pageCnt];
//        size = 0;
//        this.capacity = capacity;
//        cnt = new int[pageCnt];
//        pagesCache = new LinkedList<>();
//    }
//
//    public void get(int page) {
//        cnt[page]++;
//        Integer node = pages[page];
//        if (node == null) {
//            addToCache(page);
//        } else {
//            update(node);
//        }
//    }
//
//    private void update(Integer node) {
//
//    }
//
//    public boolean contains(int page) {
//        return pages[page] != null;
//    }
//
//    private void removeFromCache(Integer node) {
//        pagesCache.remove(node);
//        size--;
//        pages[node] = null;
//    }
//
//    private void addToCache(int page) {
//        if (size == capacity) {
//            pages[pagesCache.getFirst()] = null;
//            pagesCache.pollLast();
//            size--;
//        }
//        size++;
//        pagesCache.addLast(page);
//
//        pages[page] = pagesCache.getLast();
////        update(cache.back());
//    }
}
