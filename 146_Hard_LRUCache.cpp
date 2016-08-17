/*
Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

Subscribe to see which companies asked this question
*/

struct node{
    node* prev;
    node* next;
    int key;
    int value;
    node(int key){
        this->key  = key;
    }
};

class LRUCache{
private:
    node* head;
    node* tail;
    map<int,node*> map1;
    int size;
    int count;
public:
    LRUCache(int capacity) {
        size = capacity;
        count = 0;
        head = new node(0);
        tail = new node(0);
        head->prev = NULL;
        head->next = tail;
        tail->prev = head;
        tail->next = NULL;
    }
    
    int get(int key) {
        if(map1.find(key) == map1.end()){
            return -1;
        }
        else{
            node* nn = map1[key];
            remove(nn);
            insert(nn);
            return nn->value;
        }
    }
    
    void set(int key, int value) {
        if(map1.find(key) != map1.end()){
            node* nn = map1[key];
            nn->value = value;
            //remove
            remove(nn);
            //insert
            insert(nn);
        }
        else{
            node* nn;
            if(count == size){
                //cache is full
                nn = tail->prev;
                //remove
                remove(nn);
                count--;
                map1.erase(nn->key);
                delete nn;
            }
            
            nn = new node(key);
            nn->value = value;
            insert(nn);
            map1[key] = nn;
            count++;
        }
    }
    
    void remove(node* nn){
        nn->prev->next = nn->next;
        nn->next->prev = nn->prev;
    }
    
    void insert(node* nn){
        nn->prev = head;
        nn->next = head->next;
        head->next = nn;
        nn->next->prev = nn;
    }
};
