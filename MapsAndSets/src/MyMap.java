import java.util.*;

/**
 * Created by akravets on 12/30/14.
 */
public class MyMap implements Map {
    LinkedList[] arr = new LinkedList[10];
    int size = 0;


    @Override
    public void clear() {
        arr = new LinkedList[10];
        size = 0;
    }

    @Override
    public boolean containsKey(Object key) {
        for (LinkedList ll : arr) {
            for (Object o : ll) {
                Tuple t = (Tuple) o;
                if (t.key.equals(key)) return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        for (LinkedList ll : arr) {
            for (Object o : ll) {
                Tuple t = (Tuple) o;
                if (t.value.equals(value)) return true;
            }
        }
        return false;
    }

    @Override
    public Set<Entry> entrySet() {
        Set<Entry> es = new HashSet<Entry>();
        for (LinkedList ll : arr) {
            for (Object o : ll) {
                final Tuple t = (Tuple) o;
                es.add(new Entry() {
                    @Override
                    public Object getKey() {
                        return t.key;
                    }

                    @Override
                    public Object getValue() {
                        return t.value;
                    }

                    @Override
                    public Object setValue(Object object) {
                        return put(t.key, t.value);
                    }
                });
            }
        }
        return es;
    }

    @Override
    public Object get(Object key) {
        int pos = key.hashCode();
        List list = arr[pos];
        if(list==null) return false;
        if(list.size()==1){
            return ((Tuple)list.get(0)).value;
        } else {
            for(Object o: list){
                Tuple t = (Tuple) o;
                if(t.key.equals(key)) return t.value;
            }
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Set keySet() {
        Set set = new HashSet();
        for(LinkedList ll: arr){
            for(Object o: ll){
                Tuple t = (Tuple) o;
                set.add(t.key);
            }
        }
        return !set.isEmpty() ? set :null;
    }

    @Override
    public Object put(Object key, Object value) {
        int position = key.hashCode() % arr.length;
        List list = arr[position] == null ? new LinkedList() : (List) arr[position];
        Tuple tuple = new Tuple(key, value);
        boolean contains = false;
        for (int i = 0; i < list.size(); i++) {
            Tuple tp = (Tuple) list.get(i);
            if (tp.key.equals(key)) {
                contains = true;
                list.set(i, tuple);
                break;
            }
        }
        if (!contains) list.add(tuple);
        size++;
        return tuple.value;
    }

    @Override
    public void putAll(Map map) {
        for (Object entry : map.entrySet()) {
            Map.Entry e = (Entry) entry;
            this.put(e.getKey(), e.getValue());
        }
    }

    @Override
    public Object remove(Object key) {
        List l = arr[key.hashCode()%10];
        Object res = null;
        for (Object o: l){
            Tuple t = (Tuple) o;
            if(t.key.equals(key)) { res = o; l.remove(o);}
        }
        return res;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Collection values() {
        Collection col = new LinkedList();
        for(LinkedList ll: arr){
            for(Object o: ll){
                Tuple t = (Tuple) o;
                col.add(t.value);
            }
        }
        return !col.isEmpty() ? col :null;
    }

    private class Tuple {
        Object key;
        Object value;

        public Tuple(Object key, Object value) {
            this.key = key;
            this.value = value;
        }
    }
}
