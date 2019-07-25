package com.mowen.designpattern.buildmodel.proto;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;

/***
 * @description : 
 *用一个已经创建的实例作为原型，通过复制该原型对象来创建一个和原型相同或相
 * 似的新对象。在这里，原型实例指定了要创建的对象的种类。用这种方式创建对象非常
 * 高效，根本无须知道对象创建的细节
 * java中一般的拷贝，直接实现cloneable，Cloneable 只有一个方法，clone, 怎么拷贝， 我们可以自己实现，也可以采用jvm默认的给我们实现
 * @author: mowen
 * @time: 2019/6/20 17:42
 * @since: v1.0
 */
public class PrototypeModel implements Cloneable, Serializable {

    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "PrototypeModel{" +
            "id=" + id +
            ", name='" + name + '\'' +
            '}';
    }

    /**
     * 利用序列化实现深拷贝， 序列化的方式有很多，比如protoBuffer, kryo, hessian等
     * @return PrototypeModel
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public PrototypeModel deepCopy() throws IOException, ClassNotFoundException {

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(this);

        InputStream inputStream = new ByteArrayInputStream(outputStream.toByteArray());
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
        PrototypeModel model = (PrototypeModel)objectInputStream.readObject();
        return model;
    }

    /**
     * 最笨的方式创建一个新的对象，直接复制对象的属性
     * @return
     */
    public PrototypeModel stupidCopy(){
        PrototypeModel model = new PrototypeModel();
        model.setId(id);
        model.setName(name);
        return model;
    }
}
