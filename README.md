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





