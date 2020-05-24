# java_concurrent


### 安全发布对象

- 在静态初始化函数中初始化一个对象
- 将对象的引用保存到volatile类型域或者AtomicReference对象中
- 将对象的引用保存到某个正确构造对象的final类型域中
- 将对象的引用保存到一个由锁保护的域中

### 不可变对象

- 不可变对象需要满足的条件
    - 对象创建以后其状态就不能修改
    - 对象所有域都是final类型
    - 对象时正确创建的（在对象创建期间，this引用没有逸出）
- final关键字：类、方法、变量
    - 修饰类：不能被继承（final类中的成员方法都会被隐式的执行为final方法）
    - 修饰方法：1.锁定方法不被继承修饰；2.效率（private方法会被隐式的执行为final方法）
    - 修饰变量：基本数据类型变量、引用类型变量
    
- 不可变的对象
    - Collections.unmodifiableXXX:Collection、List、Set、Map
    - Guava：ImmutableXXX: Collection、List、Set、Map

### 线程封闭

把对象封装在一个线程内

- Ad-hoc线程封闭：程序控制实现，最糟糕，忽略
- 堆栈封闭：局部变量，无并发问题
- ThreadLocal线程封闭

### 线程不安全类与写法

- StringBuilder -> StringBuffer
- SimpleDateFormat -> JodaTime
- ArrayList, HashSet, HashMap 等Collections

### 线程安全-同步容器

- ArrayList -> Vector, Stack
- HashMap -> HashTable(key、value不能不能为null)
- Collections.synchronizedXXX(List、Set、Map)

### 线程安全-并发容器JUC
- ArrayList->CopyOnWriteArrayList
- HashSet、TreeSet -> CopyOnWriteArraySet、ConcurrentSkipListSet
- HashMap、TreeMap -> ConcurrentHashMap、ConcurrentSkipListMap

### AQS同步组件
- CountDownLatch
- Semaphore
- CyclicBarrier
- ReentrantLock
- Condition
- FutureTask

### ReentrantLock 与锁
- ReentrantLock(可重入锁)和synchronized区别
    - 可重入性
    - 锁的实现
    - 性能的区别
    - 功能的区别

- ReentrantLock独有的功能
    - 可指定时公平锁还是非公平锁
    - 提供了一个Condition类，可以分组唤醒需要唤醒的线程
    - 提供能够中断等待的线程机制，lock.lockInterruptibly()

### FutureTask

- Callable与Runnable接口对比
- Future接口
- FutureTask类

### Fork/Join框架

窃取算法

### BlockingQueue

用在生产者-消费者模型
- ArrayBlockingQueue
- DelayQueue
- LinkedBlockingQueue
- PriorityBlockingQueue
- SynchronousQueue

### 线程池

- new Thread弊端
    - 每次new Thread线建对象，性能差
    - 线程缺乏统一管理，可能无限制的新建线程，相互竞争，有可能占用过多系统资源导致死机或OOM
    - 缺少更多功能，如更多执行、定期执行、线程中断

- 线程池的好处
    - 重用存在的线程，减少对象的创建、消亡的开销，性能佳
    - 可有效控制最大并发线程数，提高系统资源利用率，同时可以避免过多资源竞争，避免阻塞
    - 提供定时执行、定期执行、单线程、并发数控制等功能
    
#### 线程池 - ThreadPoolExecutor 参数
- corePoolSize：核心线程数量
- maximumPoolSize：线程最大线程数
- workQueue：阻塞队列，存储等待执行的任务，很重要，会对线程池运行过程产生重大影响
- KeepAliveTime：线程没有任务执行时最多保持多久时间终止
- unit：KeepAliveTime的时间单位
- threadFactory：线程工厂，用来创建线程
- rejectHandler：当拒绝处理任务时的策略

#### 线程池 - ThreadPoolExecutor 方法
- execute():提交任务，交给线程池执行
- submit() :提交任务，能够返回执行结果 execute + Future
- shutdown():关闭线程池，等待任务执行完
- shutdownNow():关闭线程池，不等待任务完成
- getTaskCount():线程已执行和未执行的任务数量
- getCompletedTaskCount():已完成的任务数量
- getPoolSize():线程池当前的线程数量
- getActiveCount():当前线程池中正在执行任务的线程数量

#### 线程池 - Executor框架接口
- Executors.newCachedThreadPool 创建一个可缓存的线程池
- Executors.newFixedThreadPool
- Executors.newScheduledThreadPool
- Executors.newSingleThreadExecutor

### Spring与线程安全
- Spring bean：singleton、prototype
- 无状态对象


### HashMap与ConcurrentHashMap
 
 多线程的HashMap扩容会导致循环链表，导致死循环
 
 ConcurrentHashMap使用分段锁
 
 ### 扩容数据库
 
- 读操作扩展：redis、CDN等缓存
- 写操作扩展：Cassandra、Hbase等

### 缓存

#### 缓存特征
- 命中率：命中数/（命中数+没有命中数）
- 最大元素（空间）
- 清空策略：FIFO、LFU（清空命中数最低的缓存）、LRU（优先保证热点数据）、过期时间、随机等
#### 缓存命中率影响因素
- 业务场景和业务需求（读多写少）
- 缓存的设计（粒度和策略）
- 缓存容量和基础设施
#### 缓存分类和应用场景
- 本机缓存：编程实现（成员变量、局部变量、静态变量）、 Guava Cache
- 分布式缓存：Memcacahe、Redis

### 高并发场景下缓存常见问题

#### 缓存一致性
更新数据库成功->更新缓存失败->数据不一致
更新缓存成功->更新数据库失败->数据不一致
更新数据库成功->淘汰缓存失败->数据不一致
淘汰缓存成功->更新数据库失败->查询缓存miss

#### 缓存并发问题
#### 缓存穿透问题
- 缓存空对象，保存缓存时效性
- 过滤处理
#### 缓存的雪崩现象


