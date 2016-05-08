接口和抽象类的区别：

最大的区别是：

1：抽象类能提供方法的实现，而接口不行，接口只能定义方法，不能有实现方法的代码。

2：抽象类的数据成员可以使任何类型，而接口只能是final static。

3：抽象类可以有静态方法可静态代码段，而接口没有。

4：接口是实现多个，而java只能是单继承。

从设计层面上来说，抽象类是模板式设计，如果在抽象类中添加新的方法，所有子类都能拥有该方法；而接口是行为规范，是辐射式设计，在接口中
添加新的方法，所以实现类都不能编译通过，这是接口的缺点。

结合各自的优势，经典的设计模式就是接口在最上层，抽象类实现这个接口，其他的具体类可以自由的选择是实现接口还是继承抽象类。


Java多线程：

描述任务的方式，实现Runnable接口，编写run方法，将Runnable对象提交给Thread构造器，Thread调用start方法执行初始化操作，之后自动调用run
方法，注意，start方法只能调用一次，调用多次会报错。

Executor执行器可以来管理Thread对象，避免显示的创建对象，实际上，new显式的创建对象比较耗时，只用这种方式把线程一次性创建好并放入池中
，需要的时候再拿出来，更高效。主要的有FixThreadPool, CachedThreadPool, SingleThreadPool. 

从任务中产生返回值的接口Callable， Runable执行独立的任务，但是它不返回任何值。Callable是一种具有类型参数的泛型，实现call方法
返回一个值。通过ExecutorService.submit()调用，并且能够返回一个Future对象。

下面说一下Runable和Callable的区别：

1.Callable可以返回一个类型V，而Runnable不可以

2.Callable能够抛出checked exception,而Runnable不可以。

3.Runnable是自从java1.1就有了，而Callable是1.5之后才加上去的

4.Callable和Runnable都可以应用于executors。而Thread类只支持Runnable.

上面只是简单的不同，其实这两个接口在用起来差别还是很大的。Callable与executors联合在一起，在任务完成时可立刻获得一个更新了的
Future。而Runable却要自己处理
 
Future接口，一般都是取回Callable执行的状态用的。其中的主要方法：

cancel，取消Callable的执行，当Callable还没有完成时

get，获得Callable的返回值

isCanceled，判断是否取消了

isDone，判断是否完成

