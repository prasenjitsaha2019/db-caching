# A Quick Simple Caching Service

The Spring boot application shows a simple way to interact with backend H2 DB via Java Persistent API. Here the application users level1(L1) and level2(L2) caching service. L1 is in-memory caching service and L2 is file based secondary caching service. 

**Regarding L1 caching**
- enabled by default
- stores fixed number of elements (Hard Coded and non-configurable for now - which can be externalized)
- in memory caching, destroyed as soon as the application closes.

**Regarding L2 caching**
* configurable via properties specified in application.properties
    * to enable cache -> mycache.H2.enable
    * cache file location -> mycache.filenane
    *  maximum cache capacity -> mycache.record.max
    * cache refresh interval - > mycache.refresh.interval
* The cache is maintained in file and read from the file.
* The cache contents remain even after the application is closed.

##### General flow
The Application starts with prepopulated data in db via data.sql. DbCachingApplication queries with first name of students. Initially L1 cache is empty, hence all data gets retrieved from db or L2 Cache. But if the same student is searched again it is obtained from L1 cache. Once a student record is added to db, a copy if it is kept in L1 cache. So on next enquiry of the  same record it is obtained from
L1 cache.

**Yet to be done:**
* The refreshing of L2 cache - The idea is that based on access of records a separate set of records keys are maintained (max upto mycache.record.max). refreshL2Cache method in L2CacheManager will fetch and maintain only those records as per mycache.refresh.interval.  

