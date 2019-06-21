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
 *
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
