# KAFKA:

# Producer And Kafka Cluster Part:
Replication in Kafka:

![image](https://github.com/sidharthdas/JavaCoreTopic/assets/36167954/c7ff72c6-5b1e-410e-866a-02ef8cf4c419)

In the above example, we have a Kafka cluster.
Take an example of 3 Brokers, 1 topic, 1 partition, 2 Replication
In this scenario, the zookeeper will choose one of the replications as a leader and the other one as a follower. So when the Kafka producer produces the data, the data will be in the leader and will get replicated to followers.
So all read and write operations will happen in the leader and then replicated to followers.

![image](https://github.com/sidharthdas/JavaCoreTopic/assets/36167954/558b2548-4914-4f60-b67c-bb55a288c85d)

Now, where by any chance, the leader fails, so zookeeper will come to action and choose one leader among the followers

``` NOTE: Consumer only consumes from a leader, not follower ```

# Consumer And Consumer Group:

![image](https://github.com/sidharthdas/JavaCoreTopic/assets/36167954/36751e66-5e55-4cc6-9a0d-2b1e5819b1ac)

In the consumer group, the consumer enters and exists, but how does it get managed:

Here Group coordinator comes into the picture, he manages enter/exits of consumers in the consumer group.
  1. one of the Kafka brokers gets elected as coordinator in the Kafka cluster. when the consumer wants to enter the consumer group it sends the request to the coordinator
  2. The first consumer became the leader in the consumer group, rest became the members of the group
![image](https://github.com/sidharthdas/JavaCoreTopic/assets/36167954/5ee7c24e-65a8-43ee-ab7a-a427e3a5ce6d)

So we have two actors here:
Coordinator: 
  1. Manager a list of group members
  2. initiate a rebalance activity
  3. Communicate about new assignments to consumers
Leader:
  1. Executes the rebalance activity
  2. sends new partition assignment to the coordinator



