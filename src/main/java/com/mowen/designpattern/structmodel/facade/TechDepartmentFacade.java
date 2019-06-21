package com.mowen.designpattern.structmodel.facade;

/***
 * @description : 
 * 门面模式对其他独立功能主体的组装，封装成为一个整体，
 * 对外提供统一的服务感知
 * @author: mowen
 * @time: 2019/6/21 14:38
 * @since: v1.0
 */
public class TechDepartmentFacade {
    private ProductManager productManager;

    private UI ui;

    private WebCoder webCoder;
    private JavaCoder javaCoder;
    private Tester tester;

    public TechDepartmentFacade(){
        productManager = new ProductManager();
        ui = new UI();
        webCoder = new WebCoder();
        javaCoder = new JavaCoder();
        tester = new Tester();
    }

    public void startProject(){
        productManager.start();
        ui.start();
        webCoder.start();
        javaCoder.start();
        tester.start();
    }

    public void finishProject(){
        productManager.finish();
        ui.finish();
        webCoder.finish();
        javaCoder.finish();
        tester.finish();
    }

    public static void main(String[] args) {
        TechDepartmentFacade techDepartmentFacade = new TechDepartmentFacade();
        techDepartmentFacade.startProject();
        techDepartmentFacade.finishProject();
    }
}
