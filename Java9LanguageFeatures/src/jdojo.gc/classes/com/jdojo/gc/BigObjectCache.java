// BigObjectCache.java
package com.jdojo.gc;

import java.lang.ref.SoftReference;

public class BigObjectCache {
    @SuppressWarnings("unchecked")
    private static final SoftReference<BigObject>[] cache = new SoftReference[10];

    public static BigObject getObjectById(int id) {
        // Check for valid cache id 
        if (id < 0 || id >= cache.length) {
            throw new IllegalArgumentException("Invalid id");
        }

        BigObject obj;

        // Check if we have a cache for this id
        if (cache[id] == null) {
            // We have not cached the object yet. Cache and return it.
            obj = createCacheForId(id);
            return obj;
        }

        // Get the BigObject reference using a soft reference
        obj = cache[id].get();

        // Make sure the object has not yet been reclaimed
        if (obj == null) {
            // Garbage collector has reclaimed the object. 
            // Cache it again and return the newly cached object.
            obj = createCacheForId(id);
        }

        return obj;
    }

    // Creates cache for a given id
    private static BigObject createCacheForId(int id) {
        BigObject obj = null;
        if (id >= 0 && id < cache.length) {
            obj = new BigObject(id);
            cache[id] = new SoftReference<>(obj);
        }

        return obj;
    }
}
