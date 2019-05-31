package com.mowen.nettylearn.codec.kryo.serialize;
import de.javakaffee.kryoserializers.ArraysAsListSerializer;
import de.javakaffee.kryoserializers.EnumMapSerializer;
import de.javakaffee.kryoserializers.KryoReflectionFactorySupport;
import de.javakaffee.kryoserializers.SubListSerializers;
import de.javakaffee.kryoserializers.UnmodifiableCollectionsSerializer;
import java.util.Arrays;
import java.util.EnumMap;

import org.apache.commons.pool2.BasePooledObjectFactory;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.DefaultPooledObject;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Serializer;

/***
 * desc  : com.mowen.nettylearn.codec.kryo.serialize
 * author: mowen
 * create_time: 2019/5/31 15:52
 * project_name : mowen_parent
 */
public class PooledKryoFactory  extends BasePooledObjectFactory<Kryo>{
    @Override
    public Kryo create() throws Exception {
        return createKryo();
    }

    @Override
    public PooledObject<Kryo> wrap(Kryo kryo) {
        return new DefaultPooledObject<Kryo>(kryo);
    }

    private Kryo createKryo() {
        Kryo kryo = new KryoReflectionFactorySupport() {

            @Override
            public Serializer<?> getDefaultSerializer(@SuppressWarnings("rawtypes") final Class clazz) {
                if (EnumMap.class.isAssignableFrom(clazz)) {
                    return new EnumMapSerializer();
                }
                if (SubListSerializers.ArrayListSubListSerializer.canSerialize(clazz) || SubListSerializers.JavaUtilSubListSerializer.canSerialize(clazz)) {
                    return SubListSerializers.createFor(clazz);
                }
                return super.getDefaultSerializer(clazz);
            }
        };
        kryo.register(Arrays.asList("").getClass(), new ArraysAsListSerializer());
        UnmodifiableCollectionsSerializer.registerSerializers(kryo);
        return kryo;
    }
}
