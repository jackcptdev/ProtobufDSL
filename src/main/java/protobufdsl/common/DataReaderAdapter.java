package protobufdsl.common;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.google.protobuf.Descriptors.Descriptor;

/**
 * @author jackcptdev<jackcptdev@gmail.com>
 * @version Mar 19, 2014 10:07:07 AM
 * 
 */
public class DataReaderAdapter {

    private final com.google.protobuf.DynamicMessage.Builder messageStruct;
    private final Descriptor messageDescriptor;
    private final String outerMessageName;
    private final int maxStructDept;

    private final Object inputSource;
    private String currentIdentifer;

    public DataReaderAdapter(Object inputSource, com.google.protobuf.DynamicMessage.Builder messageStruct,
            Descriptor messageDecDescriptor, String outerMessageName, int maxStructDept) {
        this.inputSource = inputSource;
        this.messageStruct = messageStruct;
        this.messageDescriptor = messageDecDescriptor;
        this.outerMessageName = outerMessageName;
        this.maxStructDept = maxStructDept;
    }

    public String getCurrentIdentifer() {
        return currentIdentifer;
    }

    public void setCurrentIdentifer(String currentIdentifer) {
        this.currentIdentifer = currentIdentifer;
    }

    public int getMaxStructDept() {
        return maxStructDept;
    }

    public String getOuterMessageName() {
        return outerMessageName;
    }

    public Descriptor getMessageDescriptor() {
        return messageDescriptor;
    }

    public com.google.protobuf.DynamicMessage.Builder getMessageStruct() {
        return messageStruct;
    }

    public Object getInputSource() {
        return inputSource;
    }

    private final Map<Object, Object> objs = new ConcurrentHashMap<Object, Object>();

    public Map<Object, Object> getObjs() {
        return objs;
    }

    public Object get(Object key) {
        return objs.get(key);
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

    public void putContext(DataReaderAdapter ctx) {
        this.objs.putAll(ctx.objs);
    }

    public Map<Object, Object> getProperties() {
        return objs;
    }

    @Override
    public String toString() {
        return objs.toString();
    }

    public void emitObjs(DataReaderAdapter dest) {
        if (dest != null) {
            dest.putAll(objs);
        }
    }

}
