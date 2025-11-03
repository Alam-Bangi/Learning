```
Question 1:
What is the purpose of implementing the Runnable interface in Java?
- To create a class that can be executed by a thread.

Question 2:
Which of the following states is a thread in when it is ready to be executed but not currently running?
- RUNNABLE

Question 3:
What is the range of thread priorities in Java?
- 1 to 10

Question 4:
What is the default priority assigned to a thread in Java?
- 5

Question 5:
What is the purpose of the join() method in Java?
- It allows one thread to wait for completion of another thread.

Question 6:
What is a drawback of using the Thread class or Runnable interface for managing threads?
- No fine-grained control over thread execution.
- Difficult to maintain when managing multiple threads.
- No way to get the result from a sub-task.

Question 7:
Which method is used to create a  ExecutorService with just one Thread?
- ExecutorService.newSingleThreadExecutor()

Question 8:
Which method is used to create a thread pool with a specified number of threads?
- ExecutorService.newFixedThreadPool()

Question 9:
What happens if more tasks are submitted to an ExecutorService than the number of threads in the thread pool?
- The additional tasks are queued and executed when a thread becomes available.

Question 10:
Which interface is used to create sub-tasks that return a result?
- Callable<T>

Question 11:
What method of ExecutorService can be used to wait for the result of the fastest completed task from a collection of Callable tasks?
- invokeAny()

```