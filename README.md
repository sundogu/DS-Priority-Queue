# DS-Priority Queue

My implementation of Priority Queue data structure. [Priority Queue](https://en.wikipedia.org/wiki/Priority_queue) is a map data structure that utilizes a key and value pair to store the weight and data of the element. In my ordered / unordered implementation I have used a LinkedList as a data structure to contain the key and value pair in order to have a more efficient insertion and removal time. In my heap implementation I have used ArrayList data structure in order to utilize index access time.

# Time Complexity

My implementation of Ordered Priority Queue has:
* Min / Max Access: O(1)
* Queue Insert: O(n)
* Min / Max Remove: O(1)

My Implementation of Unordered Priority Queue has:
* Min / Max Access: O(1)
* Queue Insert: O(1)
* Min / Max Remove: O(n)

My Implementation of Heap Priority Queue has:
* Min Access: O(1)
* Queue Insert: O(log n)
* Min Remove: O(log n)

# Space Complexity

* O(n)
