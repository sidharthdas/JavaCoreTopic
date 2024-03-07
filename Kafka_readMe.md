# KAFKA:

Replication in Kafka:

![image](https://github.com/sidharthdas/JavaCoreTopic/assets/36167954/c7ff72c6-5b1e-410e-866a-02ef8cf4c419)

In above example, we have a kafka cluster.
Take a example of 3 Brokers, 1 topic, 1 partition, 2 Replication
In this scenario, zookeeper will choose one of the replication as leader and other one is follower. So when the kafka producer produce the data, the data will be in leader aand will get replicated to folowers.
So all read and write operation will happen in leader and then replicated to followers.

![image](https://github.com/sidharthdas/JavaCoreTopic/assets/36167954/558b2548-4914-4f60-b67c-bb55a288c85d)

Now, where by anychance, the leader fails, so zookeeper will come to action and choose one leader among the followers

``` NOTE: Consumer only consumes from leader not follower ```


