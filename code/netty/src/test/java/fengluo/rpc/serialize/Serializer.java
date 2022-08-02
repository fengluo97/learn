package fengluo.rpc.serialize;

/**
 * @Author: fengluo
 * @Date: 2022/8/1 22:06
 */
public interface Serializer {

    byte[] serialize(Object obj);

    <T> T deserialize(byte[] bytes, Class<T> clazz);

}
