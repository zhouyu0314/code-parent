package com.code;

import com.code.bean.Table;
import com.code.handler.MvcHandler;
import com.code.handler.TableHandler;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by dm
 */
public class Genterator {

    public static void main(String args[]) throws Exception {
        TableHandler tableHandler = new TableHandler();
        MvcHandler mvcHandler = new MvcHandler();
        List<Table> tableList = tableHandler.getTables();
        //*********************指定具体的表*********************
        Iterator<Table> iterator = tableList.iterator();
                while(iterator.hasNext()){
                    Table next = iterator.next();
                    if (!next.getTableName().equals("test_gen")) {
                        iterator.remove();
                    }
                }
        //*********************指定具体的表*********************
        for (Table table : tableList) {
            mvcHandler.executeModule(table);//0k
            mvcHandler.executeMapper(table);//ok
            mvcHandler.executeClazzMapper(table);//ok

        }
    }
}