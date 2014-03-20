package protobufdsl.common;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author jackcptdev<jackcptdev@gmail.com>
 * @version Feb 26, 2014 6:08:17 PM
 * 
 */
public class Context implements Cloneable {

    private final Map<Object, Object> objs = new ConcurrentHashMap<Object, Object>();

    public Map<Object, Object> getObjs() {
        return objs;
    }

    public Object get(Object key) {
        return objs.get(key);
    }

    public void remove(Object key) {
        objs.remove(key);
    }

    public void putAll(Map<? extends Object, ? extends Object> all) {
        objs.putAll(all);
    }

    public Object put(Object key, Object obj) {
        return objs.put(key, obj);
    }

    public boolean contais(Object key) {
        return objs.containsKey(key);
    }

    public void clear() {
        objs.clear();
    }

    public Boolean getBoolean(Object key) {
        return (Boolean) get(key);
    }

    public String getString(Object key) {
        return (String) get(key);
    }

    public Integer getInt(Object key) {
        return (Integer) get(key);
    }

    public <T> T get(Object key, Class<T> type) {
        return (T) get(key);
    }

    public void putContext(Context ctx) {
        this.objs.putAll(ctx.objs);
    }

    public Map<Object, Object> getProperties() {
        return objs;
    }

    @Override
    public String toString() {
        return objs.toString();
    }

    @Override
    public Context clone() {
        try {
            Context ctx = (Context) super.clone();
            ctx.putAll(this.objs);
            return ctx;
        } catch (CloneNotSupportedException e) {
            throw new InternalError("could not clone:" + this.getClass().getName());
        }
    }

    public Context merge(Context dest) {
        Context ctx = dest;
        if (ctx == null) {
            ctx = new Context();
        }
        ctx.putAll(this.objs);
        return ctx;
    }

}
