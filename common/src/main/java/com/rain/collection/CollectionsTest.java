package com.rain.collection;

import lombok.SneakyThrows;
//import sun.misc.Unsafe;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;


/**
 * @author chenyu
 * @version 1.0.0
 * @date 2020/5/2 10:25 下午
 */
@SuppressWarnings("all")
public class CollectionsTest {


    @SneakyThrows
    public void testMap() {
    //   AtomicInteger;
     //          ThreadLocalRandom
        //1.7 数组+Node单链表  16 * 0.75  >=8 &&hashMap.size>=64 红黑树
        HashMap hashMap = new HashMap();
        hashMap.put("1", 1);
        //hashMap.containsKey();
        //数组+node单链表/红黑树  + 双链表（newNode 时候追加 保证顺序） extend hashmap LinkedHashMap.Entry
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("", "");
        //synchronized  Entry 性能差 11*0.75 k/v not null
        Hashtable hashtable = new Hashtable();
        hashtable.put("","");

        PriorityQueue a = new PriorityQueue();
        a.add(null);
        //Entry extends WeakReference   16*0.75
        WeakHashMap weakHashMap = new WeakHashMap();
        weakHashMap.put("", "");

        TreeMap treeMap = new TreeMap();
        treeMap.put("", "");

        IdentityHashMap identityHashMap = new IdentityHashMap();
        identityHashMap.put("a","");


        //数组
        List a1 = new ArrayList<>();

        Collections collections;

        StackOverflowError error;

        Thread t = null;
       t.join();

    }

    public static void testSet() {
        //通过hashmap 去重
        HashSet hashSet = new HashSet(20);
        hashSet.add("a");
        hashSet.add("3");
        hashSet.add("2");
        hashSet.add("4");
        hashSet.add("b");
        hashSet.add("z");
        hashSet.add("c");

        Thread threadl;
        //thread.interrupt();
        //linkHashmap
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.add("11");

        TreeSet treeSet = new TreeSet();
        treeSet.add("");


    }


    public void testSet2() throws BrokenBarrierException, InterruptedException {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("11");

        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("a");

        ThreadLocal threadLocal = new ThreadLocal();
        threadLocal.set("x");
        threadLocal.remove();

        CyclicBarrier cyclicBarrier = new CyclicBarrier(10);
        cyclicBarrier.await();
        cyclicBarrier.reset();
        AtomicInteger atomicInteger;
        AtomicStampedReference atomicStampedReference;
        int random = new Random().nextInt();
        ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();

        ReentrantLock reentrantLock = new ReentrantLock();
        reentrantLock.tryLock(3,TimeUnit.SECONDS);
        Condition condition = reentrantLock.newCondition();
        condition.await();
        condition.signal();

     //Unsafe.getUnsafe().compareAndSwapInt(null,1,1,1);
     //lock.tryLock(1, 10);

        /*  ExecutorService executorService = Executors.newFixedThreadPool(10);
        ThreadPoolExecutor executor = new ThreadPoolExecutor();
        RunnableFuture future = executor.submit(new Runnable() {
            @Override
            public void run() {

            }
        });
      executorService.submit(new Runnable() {
            @Override
            public void run() {

            }
        });*/
    }
    public void testCurrent() throws BrokenBarrierException, InterruptedException {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        concurrentHashMap.put("", "");
        concurrentHashMap.get("");
        //ConcurrentTaskScheduler
        Comparator a;
        //Concurrent

    }

    @SneakyThrows
    public  void main2(String[] args) {
        testSet();
        DelayQueue a;
        PriorityBlockingQueue b = new PriorityBlockingQueue();
        //Map;
       // AbstractQueuedSynchronizer s;
     //   ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(10);
      //arrayBlockingQueue.add()

        //ConcurrentLinkedQueue : 无界非阻塞队列，底层使用单向链表实现，对于出队和入队使用CAS来实现线程安全
        ConcurrentLinkedQueue concurrentLinkedQueue = new ConcurrentLinkedQueue();
        concurrentLinkedQueue.add(null);

        //LinkedBlockingQueue: 有界阻塞队列，使用单向链表实现，通过ReentrantLock实现线程安全，阻塞通过Condition实现，出队和入队各一把锁，不存在互相竞争
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        linkedBlockingQueue.put(null);

       /*
        ArrayBlockingQueue: 有界数组方式实现的阻塞队列 , 通过ReentrantLock实现线程安全，阻塞通过Condition实现，出队和入队使用同一把锁
        PriorityBlockingQueue: 带优先级的无界阻塞队列，内部使用平衡二叉树堆实现，遍历保证有序需要自定排序
        DelayQueue: 无界阻塞延迟队列，队列中的每个元素都有个过期时间，当从队列获取元素时，只有过期元素才会出队列，队列头元素是最快要过期的元素
        SynchronousQueue: 任何一个写需要等待一个读的操作，读操作也必须等待一个写操作，相当于数据交换  https://www.cnblogs.com/dwlsxj/p/Thread.html
        LinkedTransferQueue: 由链表组成的无界阻塞队列，多了tryTransfer 和 transfer方法。transfer方法，能够把生产者元素立刻传输给消费者，如果没有消费者在等待，那就会放入队列的tail节点，并阻塞等待元素被消费了返回，可以使用带超时的方法。tryTransfer方法，会在没有消费者等待接收元素的时候马上返回false

        LinkedBlockingDeque: 由链表组成的双向阻塞队列，可以从队列的两端插入和移除元素*/
        ArrayBlockingQueue arrayBlockingQueue;
        //arrayBlockingQueue.offer()
        AbstractQueuedSynchronizer abstractQueuedSynchronizer;
        LinkedList linkedList;
        //linkedList.add("");
        ArrayList arrayList = new ArrayList();

        CopyOnWriteArrayList c = new CopyOnWriteArrayList(new ArrayList());
        c.add(null);
        c.get(1);

        Executor executor;
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(3);

        Vector vector;
        Hashtable hashtable;
        CopyOnWriteArrayList arrayList1;
        //arrayList1.add(1)

        Arrays.asList("","");


    }

    public static void main(String[] args) {
        Hashtable hashtable = new Hashtable();
        hashtable.put(null,"");
    }

}
